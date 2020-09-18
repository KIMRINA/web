package com.dev.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.common.Controller;
import com.dev.dao.MemberDAO;
import com.dev.model.MemberVO;

public class MemberUpdateController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("회원수정");
		MemberVO member = new MemberVO();
		String id = request.getParameter("id");
		member.setId(id);
		member = MemberDAO.getInstance().selectOne(member);
		
		request.setAttribute("memberInfo", member);
		
		request.getRequestDispatcher("/member/memberUpdateOutput.jsp").forward(request, response);
		

	}

}
