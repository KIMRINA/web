package board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

@WebServlet("/BoardInsertAjaxServ")
public class BoardInsertAjaxServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 받아서 VO에 담기
		BoardVO board = new BoardVO();									// 보드보방 생성 해서 보드에 담음
		String poster = request.getParameter("poster");
		String subject = request.getParameter("subject");
		String contents = request.getParameter("contents");
		board.setPoster(poster);
		board.setSubject(subject);
		board.setContents(contents);
		
		// dao에 insert
		BoardDAO.getInstance().insert(board);
		
		// vo를 json str 변환해서 출력
		BoardVO resultVO = BoardDAO.getInstance().selectOne(board);		// 보드보의 selectOne 실행하기위해 보드를 안에담고 리절트보생성
		String result = JSONObject.fromObject(resultVO).toString();		// JSONObject으로 제이슨 뿌리게 하기
		response.getWriter().print(result);	
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
