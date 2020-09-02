package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.ConnectionManager;

public class BoardDAO {
	// 전역변수. 모든 메서드에 공통으로 사용되는 변수
	Connection conn;
	PreparedStatement pstmt; // PreparedStatement는 Statement와 같은 기능을 수행하지만 가독성이 좋고 더 빠르다. ?기호 사용가능
	ResultSet rs = null; // ResultSet은 결과의 집합이라 select할때 사용하기. 초기값 필요하다

	// 단건 조회
	public BoardVO selectOne(BoardVO boardVO) {
		BoardVO resultVO = null; // select할때는 리턴값이 필요해서 리턴값을 저장할 변수 선언

		try {
			conn = ConnectionManager.getConnnect();
			String sql = "select * from board"
					+ " where no=?"; // 컨+쉬+x 대문자, 컨+쉬+y 소문자 변환가능. 쿼리 엔터해서 쓸거면 앞에 공백 붙이기
			pstmt = conn.prepareStatement(sql); // 미리 sql 구문이 준비가 되어야한다
			pstmt.setInt(1, boardVO.getNo()); // ?의 첫번째 자리에 올 값 지정
			rs = pstmt.executeQuery(); // select 시에는 executeQuery() 쓰기

			if (rs.next()) { // 단건조회라서 next()로 한건 한건마다 true 인지 false인지 확인하고 이동함
				resultVO = new BoardVO();
				resultVO.setNo(rs.getInt(1)); // 컬럼이 첫번째 자리라서 1을 입력한거임
				resultVO.setSubject(rs.getString("subject"));
				resultVO.setContents(rs.getString("contents")); // 컬럼명에다가 별칭있으면 별칭을 넣어줘야함
				resultVO.setLastpost(rs.getString("lastpost")); // 대소문자 구별 없음
			} else {
				System.out.println("no data");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(rs, pstmt, conn);
		}
		return resultVO; // 값을 리턴해줌
	}

	// 전체 조회
	public List<BoardVO> selectAll() { // 조회가 여러건이면 DeptVO를 list에 담음
		List<BoardVO> list = new ArrayList<BoardVO>(); // 결과값을 저장할 list 변수 객체 선언

		try {
			conn = ConnectionManager.getConnnect();
			String sql = "select * from board"
					+ " ORDER BY no"; // 컨+쉬+x 대문자, 컨+쉬+y 소문자 변환가능. 쿼리 엔터해서 쓸거면 앞에 공백 붙이기
			pstmt = conn.prepareStatement(sql); // 미리 sql 구문이 준비가 되어야한다
			rs = pstmt.executeQuery(); // select 시에는 executeQuery() 쓰기

			while (rs.next()) { // 여러건 조회라서 while를 사용. next()로 한건 한건마다 true 인지 false인지 확인하고 이동함
				BoardVO board = new BoardVO(); // 레코드 한건을 resultVO에 담음
				board.setNo(rs.getInt(1)); // 컬럼이 첫번째 자리라서 1을 입력한거임
				board.setPoster(rs.getString("poster"));
				board.setSubject(rs.getString("subject")); // 컬럼명에다가 별칭있으면 별칭을 넣어줘야함
				board.setContents(rs.getString("contents")); // 대소문자 구별 없음
				board.setLastpost(rs.getString("lastpost"));
				board.setViews(rs.getInt("views"));
				board.setFilename(rs.getString("filename"));
				list.add(board); // resultVo를 list에 담음
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(rs, pstmt, conn);
		}
		return list; // 값을 리턴해줌
	}

	// update
	public void update(BoardVO boardVO) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "update board set poster =? where no=?"; // 값 들어갈 자리에 ? 로 지정
			pstmt = conn.prepareStatement(sql); // 미리 sql 구문이 준비가 되어야한다
			pstmt.setString(1, boardVO.getPoster()); // ?의 첫번째 자리에 올 값 지정
			pstmt.setInt(2, boardVO.getNo()); // ?의 두번째 자리에 올 값 지정
			int r = pstmt.executeUpdate(); // 실행
			System.out.println(r + " 건이 수정됨"); // 결과 처리

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(null, pstmt, conn); // 연결 해제
		}
	}

	// delete
	public void delete(BoardVO boardVO) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "delete from board where no=?"; // 값 들어갈 자리에 ? 로 지정
			pstmt = conn.prepareStatement(sql); // 미리 sql 구문이 준비가 되어야한다
			pstmt.setInt(1, boardVO.getNo()); // ?의 첫번째 자리에 올 값 지정
			int r = pstmt.executeUpdate(); // 실행
			System.out.println(r + " 건이 삭제됨"); // 결과 처리

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(null, pstmt, conn); // 연결 해제
		}
	}

	// insert
	public void insert(BoardVO boardVO) {
		int r=0;
		try {
			// 1. DB 연결
			Connection conn = ConnectionManager.getConnnect(); // ConnectionManager클래스의 getConnnect실행
			conn.setAutoCommit(false);
			

			// 보드 번호 조회
			String seqSql = "select no from seq where tablename= 'board'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(seqSql);
			rs.next();
			int no = rs.getInt(1);
			System.out.println(no);
			
			// 보드 번호 업데이트
			seqSql = "update seq set no = no + 1 where tablename = 'board'";
			stmt = conn.createStatement();
			stmt.executeUpdate(seqSql);
			
			
			// 2. sql 구문 실행
			String sql = "insert into board(lastpost,poster,subject,contents,no,filename) values(sysdate,?,?,?,?,?)";

			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, boardVO.getPoster());
			psmt.setString(2, boardVO.getSubject());
			psmt.setString(3, boardVO.getContents());
			psmt.setInt(4, no);
			psmt.setString(5, boardVO.getFilename());
			psmt.executeUpdate();
			conn.commit();

			// 3. 결과 처리
			System.out.println(r + " 건이 처리됨");

		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();

		} finally {
			// 4. 연결 해제
			ConnectionManager.close(conn);
		}

	}

}
