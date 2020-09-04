package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test/CookieAdd")
public class CookieAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("utf-8");	// 한글 변환
		
		// 쿠키 객체 생성
		Cookie cookie = new Cookie("id", "백승엽");
		cookie.setPath("/"); // "/" 하면 루트밑에 모든 폴더에서 접근 가능

		// 쿠키 유효시간 설정
		cookie.setMaxAge(60 * 60 * 24);

		// 쿠키 저장
		response.addCookie(cookie);

		// 쿠키2 객체 생성
		Cookie cookie2 = new Cookie("popupYn", "yes");
		cookie2.setPath("/"); // "/" 하면 루트밑에 모든 폴더에서 접근 가능

		// 쿠키2 유효시간 설정
		cookie2.setMaxAge(60 * 60 * 24);

		// 쿠키2 저장
		response.addCookie(cookie2);

		
		
		// 쿠키 보내기
		response.sendRedirect("cookieSelect.jsp");

	}

}
