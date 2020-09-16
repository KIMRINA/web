package com.dev.controller.users;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.common.Controller;
import com.dev.model.UsersVO;
import com.dev.dao.UsersDAO;

import net.sf.json.JSONObject;

public class UpdateUsers implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//파라미터를 VO에 담기
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String role = request.getParameter("role");
		
		UsersVO userVO = new UsersVO();
		userVO.setId(id);
		userVO.setName(name);
		userVO.setGender(gender);
		userVO.setRole(role);
		
		//수정 처리
		UsersDAO dao = new UsersDAO();
		dao.updateUser(userVO);
		
		//수정된 정보를 조회
		
		//수정된 정보를 응답
		response.getWriter().print( JSONObject.fromObject(userVO) );
	}

}
