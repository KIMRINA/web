package dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.ConnectionManager;

public class DeptDAO {
	// 전역변수. 모든 메서드에 공통으로 사용되는 변수
	Connection conn;
	PreparedStatement pstmt; 	// PreparedStatement는 Statement와 같은 기능을 수행하지만 가독성이 좋고 더 빠르다. ?기호 사용가능
	ResultSet rs = null;		// ResultSet은 결과의 집합이라 select할때 사용하기. 초기값 필요하다
	
	// 단건 조회
	public DeptVO selectOne(DeptVO deptVO) {
		DeptVO resultVO = null;  // select할때는 리턴값이 필요해서 리턴값을 저장할 변수 선언
		
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "SELECT DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID mgr_id, LOCATION_ID"
						+ " FROM DEPARTMENTS"
						+ " WHERE DEPARTMENT_ID=?";  // 컨+쉬+x 대문자, 컨+쉬+y 소문자 변환가능. 쿼리 엔터해서 쓸거면 앞에 공백 붙이기
			pstmt = conn.prepareStatement(sql);  	// 미리 sql 구문이 준비가 되어야한다
			pstmt.setInt(1, deptVO.getDepartment_id());	// ?의 첫번째 자리에 올 값 지정
			rs = pstmt.executeQuery();		// select 시에는 executeQuery() 쓰기
			
			if(rs.next()) {  // 단건조회라서 next()로 한건 한건마다 true 인지 false인지 확인하고 이동함
				resultVO = new DeptVO();
				resultVO.setDepartment_id(rs.getInt(1));  // 컬럼이 첫번째 자리라서 1을 입력한거임
				resultVO.setDepartment_name(rs.getString("department_name"));
				resultVO.setManager_id(rs.getInt("mgr_id"));		// 컬럼명에다가 별칭있으면 별칭을 넣어줘야함
				resultVO.setLocation_id(rs.getInt("LOCATION_ID"));	// 대소문자 구별 없음
			} else {
				System.out.println("no data");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(rs, pstmt, conn);
		}
		return resultVO;	// 값을 리턴해줌
	}
	
	
	// 전체 조회
	public ArrayList<DeptVO> selectAll() {  // 조회가 여러건이면 DeptVO를 list에 담음
		DeptVO resultVO = null;  // select할때는 리턴값이 필요해서 리턴값을 저장할 변수 선언
		ArrayList<DeptVO> list = new ArrayList<DeptVO>();	// 결과값을 저장할 list 변수 객체 선언 
		
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "SELECT DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID mgr_id, LOCATION_ID"
						+ " FROM DEPARTMENTS"
						+ " ORDER BY DEPARTMENT_ID";  // 컨+쉬+x 대문자, 컨+쉬+y 소문자 변환가능. 쿼리 엔터해서 쓸거면 앞에 공백 붙이기
			pstmt = conn.prepareStatement(sql);  	// 미리 sql 구문이 준비가 되어야한다
			rs = pstmt.executeQuery();		// select 시에는 executeQuery() 쓰기
			
			while(rs.next()) {  // 여러건 조회라서 while를 사용. next()로 한건 한건마다 true 인지 false인지 확인하고 이동함
				resultVO = new DeptVO();	// 레코드 한건을 resultVO에 담음
				resultVO.setDepartment_id(rs.getInt(1));  // 컬럼이 첫번째 자리라서 1을 입력한거임
				resultVO.setDepartment_name(rs.getString("department_name"));
				resultVO.setManager_id(rs.getInt("mgr_id"));		// 컬럼명에다가 별칭있으면 별칭을 넣어줘야함
				resultVO.setLocation_id(rs.getInt("LOCATION_ID"));	// 대소문자 구별 없음
				list.add(resultVO);		// resultVo를 list에 담음
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(rs, pstmt, conn);
		}
		return list;	// 값을 리턴해줌
	}
	
	
	// update
	public void update(DeptVO deptVO) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "update departments set department_name =? where department_id=?";  // 값 들어갈 자리에 ? 로 지정
			pstmt = conn.prepareStatement(sql);  // 미리 sql 구문이 준비가 되어야한다
			pstmt.setString(1, deptVO.getDepartment_name());	// ?의 첫번째 자리에 올 값 지정
			pstmt.setInt(2, deptVO.getDepartment_id());  // ?의 두번째 자리에 올 값 지정
			int r = pstmt.executeUpdate();			// 실행
			System.out.println(r + " 건이 수정됨");		// 결과 처리
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(null, pstmt, conn);		// 연결 해제
		}
	}
	
	// delete
	public void delete(DeptVO deptVO) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "delete from departments where department_id=?";  // 값 들어갈 자리에 ? 로 지정
			pstmt = conn.prepareStatement(sql);  // 미리 sql 구문이 준비가 되어야한다
			pstmt.setInt(1, deptVO.getDepartment_id());	// ?의 첫번째 자리에 올 값 지정
			int r = pstmt.executeUpdate();			// 실행
			System.out.println(r + " 건이 삭제됨");		// 결과 처리
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(null, pstmt, conn);		// 연결 해제
		}
	}

	
	// insert
	public void insert(DeptVO deptVO) {
		try {
			// 1. DB 연결
			Connection conn = ConnectionManager.getConnnect();		// ConnectionManager클래스의 getConnnect실행

			// 2. sql 구문 실행
			String sql = "insert into departments (department_id, department_name)" 
						+ "values(" + deptVO.getDepartment_id() 
						+ ",'"
						+ deptVO.getDepartment_name()
						+"')";
			
			Statement stmt = conn.createStatement();	// conn이라는 연결되는 길을 만듬(createStatement는 트럭과 같은 역할)
			int r = stmt.executeUpdate(sql);

			// 3. 결과 처리
			System.out.println(r + " 건이 처리됨");
			
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			// 4. 연결 해제
			ConnectionManager.close(conn);
		}

	}
}
