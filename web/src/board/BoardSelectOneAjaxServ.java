package board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BoardSelectOneAjaxServ")
public class BoardSelectOneAjaxServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 게시글 번호를 파라미터 받아서 단건조회 결과를 json 변환해서 출력
		int no = Integer.parseInt(request.getParameter("no"));
		BoardVO board = new BoardVO();
		board.setNo(no);
		
		BoardVO result = BoardDAO.getInstance().selectOne(board);
		response.getWriter().print(result);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
