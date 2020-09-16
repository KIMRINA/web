package com.dev.controller.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.common.Controller;
import com.dev.dao.MemberDAO;
import com.dev.model.MemberVO;

public class MemberListController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("회원목록");
		
		// 파라미터
		
		// 유효성 체크
		
		// VO 담기
		
		// 서비스
		List<MemberVO> list = MemberDAO.getInstance().selectAll();
		
		// 결과 저장
		request.setAttribute("list", list);
		
		// 페이지 이동
		request.getRequestDispatcher("/member/memberAll.jsp").forward(request, response);

	}

}
