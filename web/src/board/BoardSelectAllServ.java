package board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class BoardSelectAllServ
 */
@WebServlet("/board/boardSelectAll.do")
public class BoardSelectAllServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 파라미터

		// DB 조회
		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = dao.selectAll();

		// 결과 저장
		request.setAttribute("list", list);
		request.getRequestDispatcher("boardAll.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
