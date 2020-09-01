package dept;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeptSelectServ
 * 단건조회 - 조회는 post가 필요없어서 삭제함. doGet만 있어도 됨
 */
@WebServlet("/dept/deptSelect")
public class DeptSelectServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 부서번호 파라미터로 조회한 결과를 select.jsp 로 포워드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 파라미터를 VO에 담기
		DeptVO paramVO = new DeptVO();
		int department_id = Integer.parseInt(request.getParameter("department_id"));  // department_id를 들고와서 int로 변환
		paramVO.setDepartment_id(department_id);  // 위의 변환한 department_id 값 들고와서 paramVO에 담기
		
		// 2. 단건 조회
		DeptDAO dao = new DeptDAO();
		DeptVO dept = dao.selectOne(paramVO);
		
		// 3. 조회 결과 request 저장
		request.setAttribute("dept", dept);  // jsp페이지에서 ${dept.department_id} 형식으로 쓰고있는데 그때 그 dept를 들고오는거
		
		// 4. view 페이지로 이동(포워드)
		request.getRequestDispatcher("deptSelect.jsp")
			   .forward(request, response);  // deptSelect.jsp를 들고와서 request,response
		
		
	}


}
