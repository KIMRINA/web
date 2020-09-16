package com.dev.controller.member;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.common.Controller;
import com.dev.dao.MemberDAO;
import com.dev.model.MemberVO;

public class MemberSearchController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("회원검색");
		// job에 따라서 포워드 페이지 지정
		String path="memberSearch.jsp";
		String job = request.getParameter("job");
		if(job.equals("delete")) {			// job이 delete라면 memberDelete.jsp로 넘어감 == job에 따라 리턴하는 포워드 페이지가 달라짐
			path="memberDelete.jsp";
		} else if(job.equals("update")) {	// job이 update라면 memberUpdate.jsp로 넘어감
			path = "memberUpdate.jsp";
		}
		
		// 파라미터 변수에 저장
		String id = request.getParameter("id");
		
		// id 파라미터 읽어서 id가 null인지 유효성 체크
		if(id.isEmpty()) {	// id가 값이 안들어갔을때
			request.setAttribute("error", "id를 입력하세요");
			
			// search 페이지로 포워드
			request.getRequestDispatcher("/member/" + path).forward(request, response);
			return;
		}
		
		// VO에 담기
		MemberVO member = new MemberVO();
		member.setId(id);
		
		// 서비스
		MemberVO reasultVO = MemberDAO.getInstance().selectOne(member);
		
		// 조회결과를 request에 저장 후에 memberSearchOutput.jsp로 포워드
		request.setAttribute("member", reasultVO);
		if(job.equals("search")) {			// job이 search라면 memberSearchOutput.jsp로 넘어감
			request.getRequestDispatcher("/member/memberSearchOutput.jsp").forward(request, response);
		} else {							// job이 delete라면 memberDelete.jsp로 넘어감
			request.getRequestDispatcher("/member/" + path).forward(request, response);
		}
		

	}

}
