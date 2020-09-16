package com.dev.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.controller.member.MemberDeleteController;
import com.dev.controller.member.MemberInsertController;
import com.dev.controller.member.MemberListController;
import com.dev.controller.member.MemberSearchController;
import com.dev.controller.member.MemberSearchPageController;
import com.dev.controller.member.MemberUpdateController;
import com.dev.controller.users.ChartData;
import com.dev.controller.users.DeleteUsers;
import com.dev.controller.users.GetUsers;
import com.dev.controller.users.GetUsersList;
import com.dev.controller.users.InsertUsers;
import com.dev.controller.users.UpdateUsers;

@WebServlet(name = "front", urlPatterns = "*.do", 
initParams = {
		@WebInitParam(name = "charset", value="UTF-8")
})
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String charset = null;
	HashMap<String, Controller> list = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		charset = config.getInitParameter("charset");	// UTF-8을 읽어들여서 인코딩 한다는 뜻
		list = new HashMap<String, Controller>();
		list.put("/memberInsert.do", new MemberInsertController());
		list.put("/memberUpdate.do", new MemberUpdateController());
		list.put("/memberSearch.do", new MemberSearchController());
		list.put("/admin/memberSearchPage.do", new MemberSearchPageController());
		list.put("/memberDelete.do", new MemberDeleteController());
		list.put("/memberList.do", new MemberListController());
		
		
		// user ajax 처리
		list.put("/ajax/DeleteUsers.do", new DeleteUsers());
		list.put("/ajax/GetUsers.do", new GetUsers());
		list.put("/ajax/GetUsersList.do", new GetUsersList());
		list.put("/ajax/InsertUsers.do", new InsertUsers());
		list.put("/ajax/UpdateUsers.do", new UpdateUsers());
		
		// chart data ajax
		list.put("/ajax/ChartData.do", new ChartData());
		
	}
	
	// 서비스에서 확인후 uri를 잘라서 init에서 확인
	// 요청이 들어올때마다 서비스를 실행
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(charset);					// UTF-8을 읽어들여서 인코딩 한다는 뜻
		response.setContentType("text/html; charset=UTF-8"); 	// 한글이 안깨지게 response함
		//response.setCharacterEncoding(charset);	
		String uri = request.getRequestURI();					// frontWeb/memberInsert.do
		String contextPath = request.getContextPath();			// frontWeb
		String path = uri.substring(contextPath.length());		// /memberInsert.do
		Controller subController = list.get(path);
		subController.execute(request, response);
	}


}
