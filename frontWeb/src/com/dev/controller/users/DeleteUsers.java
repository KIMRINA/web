package com.dev.controller.users;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.common.Controller;
import com.dev.model.UsersVO;
import com.dev.dao.UsersDAO;

import net.sf.json.JSONObject;

public class DeleteUsers implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터를 DTO에 담기
		String id = request.getParameter("id");
		UsersVO userVO = new UsersVO(id); 
		
		//삭제 처리
		UsersDAO dao = new UsersDAO();
		dao.deleteUser(userVO);
		
		//삭제된 정보를 응답
		response.getWriter().print( JSONObject.fromObject(Collections.singletonMap("id", id)));
	}

	
}
