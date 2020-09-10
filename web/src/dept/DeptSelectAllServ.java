package dept;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Paging;

@WebServlet("/dept/deptSelectAll")
public class DeptSelectAllServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeptDAO dao = new DeptDAO();
		
		// 게시판 페이징 하기 부분
		// 파라미터 받기
		String p = request.getParameter("p");
		String department_name = request.getParameter("department_name");		// 부서명받아서 파라미터 넘김
		
		// 유효성 체크
		int page = 1;
		if(p != null) {
			page = Integer.parseInt(p);		// p가 널이 아니라면 p를 인트로 변환후 page에 담기
		}
		Paging paging = new Paging();
		paging.setPageUnit(5);					// 한페이지에 출력할 레코드 건수 설정
		paging.setPageSize(3);					// 페이지 번호 수 설정
		paging.setPage(page);					// paging 반영되게 해주기
		
		// VO에 담기
		DeptVO dept = new DeptVO();
		dept.setDepartment_name(department_name);	// 부서명을 dept에 담음
		paging.setTotalRecord(dao.count(dept));		// dao.count() 쓰면 first,last paging에서 알아서 계산다해주고 카운트에도 넘김
		dept.setFirst(paging.getFirst());	// first를 dept에 담음
		dept.setLast(paging.getLast());		// last를 dept에 담음
		// http://localhost/web1/dept/deptSelectAll?p=1 주소형식에서 p=에 페이지 숫자 넣으면 다음페이지로 넘어가는거 확인될거임
		
		
		// 전체 조회
		System.out.println("dept 전체 조회 실행");
		ArrayList<DeptVO> list = dao.selectAll(dept);		// 위에 담은 dept를 실행하기위해 selectAll()에 담기
		request.setAttribute("list", list);
		request.setAttribute("paging", paging);
		request.getRequestDispatcher("deptSelectAll.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
