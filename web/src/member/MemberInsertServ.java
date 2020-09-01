package member;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

/**
 * Servlet implementation class MemberInsertServ 회원 전체 조회
 */
@WebServlet("/member/memberInsert.do")
public class MemberInsertServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("memberInsert.jsp").forward(request, response);

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 파라미터 VO에 담기
		MemberVO member = new MemberVO();
//		member.setId(request.getParameter("id"));
//		member.setPw(request.getParameter("pw"));
//		member.setGender(request.getParameter("gender"));
//		member.setJob(request.getParameter("job"));
//		member.setReason(request.getParameter("reason"));
		
		try {  // 위의 파라미터 한꺼번에 담아주는거
			BeanUtils.copyProperties(member, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("============map============");
		Map<String,String[]> map = request.getParameterMap();
		System.out.println(map);
		System.out.println("id=" + map.get("id"));
		
		System.out.println("============names============");
		Enumeration<String> pnames = request.getParameterNames();  // 파라미터 이름만 읽어오기 가능
		while(pnames.hasMoreElements()) {
			System.out.println(pnames.nextElement());
		}
		
		// checkbox
		System.out.println("============values============");
		String strHobby = "";
		String[] hobby = request.getParameterValues("hobby");
		System.out.println(Arrays.toString(hobby));   //[ski,read]
		if(hobby != null) {
			for(String temp : hobby) {
				strHobby += temp + "/";
			}
		}
		member.setHobby(strHobby);
		
		
		// DB 등록 처리
		MemberDAO dao = new MemberDAO();
		dao.insert(member);

		// 목록으로 이동
		response.sendRedirect("memberSelectAll.do");

	}

}
