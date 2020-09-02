package member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

/**
 * Servlet implementation class MemberUpdateServ
 */
@WebServlet("/member/memberUpdate")
public class MemberUpdateServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	// 수정페이지로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("memberUpdate.jsp").forward(request, response);
	}

	// 수정 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVO member = new MemberVO();
		try {  // 위의 파라미터 한꺼번에 담아주는거
			BeanUtils.copyProperties(member, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(member.getPw());
		MemberDAO dao = new MemberDAO();
		dao.update(member);
		response.sendRedirect("memberSelectAll.do");

	}

}
