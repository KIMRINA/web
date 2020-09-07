package com.dev.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.model.MemberDAO;
import com.dev.model.MemberVO;

public class MemberSearchController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("회원검색");
		
		// 파라미터 변수에 저장
		String id = request.getParameter("id");
		
		// id 파라미터 읽어서 id가 null인지 유효성 체크
		if(id.isEmpty()) {	// id가 값이 안들어갔을때
			request.setAttribute("error", "id를 입력하세요");
			
			// search 페이지로 포워드
			request.getRequestDispatcher("/member/memberSearch.jsp").forward(request, response);
			return;
		}
		
		// VO에 담기
		MemberVO member = new MemberVO();
		member.setId(id);
		
		// 서비스
		MemberVO r = MemberDAO.getInstance().selectOne(member);
		
		// 조회결과를 request에 저장 후에 memberSearchOutput.jsp로 포워드
		request.setAttribute("member", r);
		request.getRequestDispatcher("/member/memberSearchOutput.jsp").forward(request, response);

	}

}
