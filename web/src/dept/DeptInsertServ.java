package dept;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeptInsertServ
 */
@WebServlet("/dept/deptInsert")
public class DeptInsertServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dept 등록 실행");
		
		// 1. 파라미터를 VO 담기
		DeptVO deptVO = new DeptVO();
		deptVO.setDepartment_id(Integer.parseInt(request.getParameter("department_id")));  // getParameter는 String 값이므로 parseInt 해줌
		deptVO.setDepartment_name(request.getParameter("department_name"));
		
		// 2. 등록 처리
		DeptDAO dao = new DeptDAO();
		dao.insert(deptVO);
		
		// 3. 결과 처리(생략)
		
		// 4. 전체 조회 서블릿 페이지로 이동
		response.sendRedirect("deptSelectAll");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	// doPost에서 doGet을 부르는 구조. doPost 삭제 불가
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
