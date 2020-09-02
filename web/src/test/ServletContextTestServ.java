package test;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletContextTestServ")
public class ServletContextTestServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = this.getServletContext();
		
		response.setContentType("text/html; charset=UTF-8");  // setContentType는 웹페이지가 이페이지를 어떻게 처리할지 알려주는 것
		// setContentType에 설정해줘서 한글안깨지고 br태그 먹을거임
		response.getWriter()
				.append("서블릿 버전 : " + application.getMajorVersion() + "." + application.getMajorVersion())
				.append("<br>서버정보 : " + application.getServerInfo())
				.append("<br>컨텍스트(=어플리케이션) 경로 : " + application.getContextPath())
				.append("<br>실제 경로 : " + application.getRealPath("/member/memberInsert.jsp"));
		
	}


}
