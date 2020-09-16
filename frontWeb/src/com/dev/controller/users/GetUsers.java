package com.dev.controller.users;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.common.Controller;
import com.dev.model.UsersVO;
import com.dev.dao.UsersDAO;

import net.sf.json.JSONObject;

public class GetUsers implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터를 vo에 담기
		String id = request.getParameter("id");
		UsersVO usersVO = new UsersVO(id); 
		
		//조회 처리
		UsersDAO dao = new UsersDAO();
		UsersVO resultVO = dao.getUser(usersVO);
		
		//조회결과를 응답
		String str =  JSONObject.fromObject(resultVO).toString();
		response.getWriter().print(str);
	}

}
