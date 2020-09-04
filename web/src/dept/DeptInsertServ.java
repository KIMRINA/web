package dept;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dept/deptInsert")
public class DeptInsertServ extends HttpServlet {
	private static final long serialVersionUID = 1L;


	// get : 부서등록페이지로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 지역정보
		System.out.println("locations 전체 조회 실행");
		ArrayList<HashMap<String, String>> locationList = LocationDAO.getInstance().selectAll();
		request.setAttribute("locationList", locationList);
		
		// 사원(매니저)정보
		System.out.println("employees 전체 조회 실행");
		List<EmpVO> empList = EmpDAO.getInstance().selectAll();
		request.setAttribute("empList", empList);
		
		
		request.getRequestDispatcher("deptInsertForm.jsp").forward(request, response);
	}

	
	// post : 부서등록 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("dept 등록 실행");

		// 1. 파라미터를 VO 담기
		DeptVO deptVO = new DeptVO();
		System.out.println(request.getParameter("department_id"));
		System.out.println(request.getParameter("department_name"));
		System.out.println(request.getParameter("location_id"));
		System.out.println(request.getParameter("manager_id"));
		deptVO.setDepartment_id(Integer.parseInt(request.getParameter("department_id"))); // getParameter는 String 값이므로 parseInt 해줌
		deptVO.setDepartment_name(request.getParameter("department_name"));
		
		deptVO.setLocation_id(Integer.parseInt(request.getParameter("location_id")));
		deptVO.setManager_id(Integer.parseInt(request.getParameter("manager_id")));
		
		// 2. 등록 처리
		DeptDAO dao = new DeptDAO();
		dao.insert(deptVO);

		// 3. 결과 처리(생략)

		// 4. 전체 조회 서블릿 페이지로 이동
		response.sendRedirect("deptSelectAll");
	}

}
