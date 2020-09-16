package com.dev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dev.common.ConnectionManager;
import com.dev.model.UsersVO;

public class UsersDAO {
	
	Connection conn;
	PreparedStatement  psmt;
	ResultSet rs;
	
	//싱글톤
	static UsersDAO usersDAO = new UsersDAO();
	public static UsersDAO getInstance() {
		return usersDAO;
	}
	
    // SQL 명령어들
    private final String USER_INSERT = "INSERT INTO USERS(ID, GENDER, NAME, ROLE) VALUES(?,?,?,?)";
    private final String USER_UPDATE = "UPDATE USERS SET GENDER=?, NAME=?, ROLE =? WHERE ID=?";
    private final String USER_DELETE = "DELETE USERS WHERE ID=?";
    private final String USER_GET    = "SELECT * FROM USERS WHERE ID=?";
    private final String USER_LIST   = "SELECT * FROM USERS  ORDER BY ID DESC";

    // CRUD 기능의 메소드 구현
    // 사용자 등록
    public void insertUser(UsersVO dto){
        try {
        	conn = ConnectionManager.getConnnect();
            psmt = conn.prepareStatement(USER_INSERT);
            psmt.setString(1, dto.getId());
            psmt.setString(2, dto.getGender());
            psmt.setString(3, dto.getName());
            psmt.setString(4, dto.getRole());
            psmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	ConnectionManager.close(conn);
        }
    }
    
    // 사용자 수정
    public void updateUser(UsersVO dto){
        try {
        	conn = ConnectionManager.getConnnect();
            psmt = conn.prepareStatement(USER_UPDATE);
            psmt.setString(1, dto.getGender());
            psmt.setString(2, dto.getName());
            psmt.setString(3, dto.getRole());
            psmt.setString(4, dto.getId());
            psmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	ConnectionManager.close(conn);
        }
    }    
    
    // 사용자 삭제
    public void deleteUser(UsersVO dto){
        try {
        	conn = ConnectionManager.getConnnect();
            psmt = conn.prepareStatement(USER_DELETE);
            psmt.setString(1, dto.getId());
            psmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	ConnectionManager.close(conn);
        }
    }
    
    // 사용자 상세 조회
    public UsersVO getUser(UsersVO dto){
        UsersVO user = null;
        try {
        	conn = ConnectionManager.getConnnect();
            psmt = conn.prepareStatement(USER_GET);
            psmt.setString(1, dto.getId());
            rs = psmt.executeQuery();
            if(rs.next()){
                user = new UsersVO();
                user.setId(rs.getString("ID"));
                user.setGender(rs.getString("GENDER"));
                user.setName(rs.getString("NAME"));
                user.setRole(rs.getString("ROLE"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	ConnectionManager.close(conn);
        }
        return user;
    }
    
    // 사용자 목록 조회
    public List<UsersVO> getUserList(){
        List<UsersVO> userList = new ArrayList<UsersVO>();
        try {
        	conn = ConnectionManager.getConnnect();
           	psmt = conn.prepareStatement(USER_LIST);
            
            rs = psmt.executeQuery();
            while(rs.next()){
                UsersVO user = new UsersVO();
                user.setId(rs.getString("ID"));
                user.setGender(rs.getString("GENDER"));
                user.setName(rs.getString("NAME"));
                user.setRole(rs.getString("ROLE"));
                userList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	ConnectionManager.close(conn);
        }
        return userList;
    }    

}
