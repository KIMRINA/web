package test;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test/cartAdd")
public class CartAddServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	int cnt = 0;	// static과 같음
	
	// 상품조회
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("goodsList.jsp").forward(request, response);
	}

	
	// 장바구니 등록
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 세션에서 장바구니 목록 조회
		// ArrayList<String> cartList = new ArrayList<String>();
		ArrayList<String> cartList = (ArrayList<String>)request.getSession().getAttribute("cartList");
		
		// cartList가 null이면 String[] 초기화하고 session에 추가
		if(cartList == null) {
			cartList = new ArrayList<String>();  // 카트리스트 10개까지 등록가능
			request.getSession().setAttribute("cartList",cartList);	// 카트리스트 session에다가 담기
		}
		
		// 선택한상품(파라미터)을 cartList에 추가 : getParameter
		cartList.add(request.getParameter("goods"));  //cartList의 제일 마지막 배열을 알고싶다면 : [cartList.length]
		
		// 상품조회 페이지로 이동
		response.sendRedirect("cartAdd");
	
	}

}
