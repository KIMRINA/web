package board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

@WebServlet("/BoardDeleteAjaxServ")
public class BoardDeleteAjaxServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));			// no 파라미터 받아옴
		BoardVO board = new BoardVO();									// 보드보방 생성 해서 보드에 담음
		board.setNo(no);												// 보드에 받아온 no파라미터 셋팅해줌
		System.out.println("1"+board.getNo());
		
		BoardVO resultVO = BoardDAO.getInstance().selectOne(board);		// 보드보의 selectOne 실행하기위해 보드를 안에담고 리절트보생성
		String result = JSONObject.fromObject(resultVO).toString();		// JSONObject으로 제이슨 뿌리게 하기
		response.getWriter().print(result);	
		
		BoardDAO.getInstance().delete(board);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
