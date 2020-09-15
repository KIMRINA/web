package board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;


@WebServlet("/BoardSelectAllAjaxServ")
public class BoardSelectAllAjaxServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전체 조회 ajax 요청 처리(json)
		List<BoardVO> list = BoardDAO.getInstance().selectAll();
		String result = JSONArray.fromObject(list).toString();
		response.getWriter().print(result);
		
	}

}
