package com.dev.controller.users;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.common.Controller;
import com.dev.model.UsersVO;
import com.dev.dao.UsersDAO;

import net.sf.json.JSONArray;

public class GetUsersList implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//파라미터를 vo에 담기
		
		//조회 처리
		UsersDAO dao = new UsersDAO();
		List<UsersVO> userList =dao.getUserList();
		
		//조회 정보를 응답
		String str = JSONArray.fromObject(userList).toString();
		response.getWriter().print(str);
	}
}
