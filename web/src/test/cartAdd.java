package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cartAdd")
public class cartAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터 받아서
		
		// session에 상품정보를 조회
		String[] goods = (String[])request.getSession().getAttribute("goods");
		
		// goods가 없으면 생성하고 session에 추가
		
		// 선택한 상품을 goods에 추가
		
		// 상품 목록 페이지로 이동
	
	}

}
