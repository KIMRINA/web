package com.dev.controller.users;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.common.Controller;
import com.dev.model.UsersVO;
import com.dev.dao.UsersDAO;

import net.sf.json.JSONObject;

public class InsertUsers implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//파라미터를 VO에 담기
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String role = request.getParameter("role");
		
		UsersVO usersVO = new UsersVO();
		usersVO.setId(id);
		usersVO.setName(name);
		usersVO.setGender(gender);
		usersVO.setRole(role);
		
		//등록 처리
		UsersDAO dao = new UsersDAO();
		dao.insertUser(usersVO);
		
		//등록된 결과를 조회
		
		//등록된 정보를 응답
		String str = JSONObject.fromObject(usersVO).toString();
		response.getWriter().print(str);
	}

}
