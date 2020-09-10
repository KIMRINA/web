package dept;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dept/empInsert")
public class EmpInsertServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 파라미터 받기
		String p = request.getParameter("p");

		// 유효성 체크
		int page = 1;
		if (p != null) {
			page = Integer.parseInt(p); // p가 널이 아니라면 p를 인트로 변환후 page에 담기
		}

		// VO에 담기
		int page_unit = 50; // 1페이지에 다섯건 나오게 하기
		int first = (page - 1) * page_unit + 1; // first 물음표 값 설정
		int last = first + page_unit - 1; // last 물음표 값 설정
		DeptVO dept = new DeptVO();
		System.out.println(first + last);
		dept.setFirst(first); // first를 dept에 담음
		dept.setLast(last); // last를 dept에 담음

		
		// department_id 불러오기
		DeptDAO deptDao = new DeptDAO();
		List<DeptVO> deptId = deptDao.selectAll(dept);
		request.setAttribute("deptId", deptId);

		// job_id 불러오기
		List<JobVO> jobId = JobDAO.getInstance().selectAll();
		request.setAttribute("jobId", jobId);

		// manager_id 불러오기
		List<EmpVO> empId = EmpDAO.getInstance().selectAll();
		request.setAttribute("empId", empId);

		request.getRequestDispatcher("employeeInsert.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 파라미터를 VO 담기
		EmpVO empVO = new EmpVO();
		empVO.setEmployee_id(request.getParameter("employeeId"));
		empVO.setFirst_name(request.getParameter("firstName"));
		empVO.setLast_name(request.getParameter("lastName"));
		empVO.setEmail(request.getParameter("email"));
		empVO.setHire_date(request.getParameter("hireDate"));
		empVO.setDepartment_id(request.getParameter("deptId"));
		empVO.setJob_id(request.getParameter("jobId"));
		empVO.setManager_id(request.getParameter("managerId"));

		// 2. 등록 처리
		EmpDAO dao = new EmpDAO();
		dao.insert(empVO);

		// 3. 결과 처리(생략)

		// 4. 전체 조회 서블릿 페이지로 이동
		response.sendRedirect("empSelectAll");
	}

}
