package board;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import common.FileRenamePolicy;

// 파라미터 스트림 값을 바운더리(구분기호)로 잘라서 part배열로 만들어줌
@MultipartConfig(location = "d:/upload", maxRequestSize = 1024 * 1024 * 10)
@WebServlet("/board/boardInsert.do")
public class BoardInsertServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("boardInsert.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 파라미터 인코딩
		request.setCharacterEncoding("utf-8");

		// 파라미터 VO에 담기
		BoardVO board = new BoardVO();

		// 첨부 파일 처리
		Part part = request.getPart("filename");
		String fileName = getFileName(part);
		String path = request.getServletContext().getRealPath("/images");	// "d:/upload";
		System.out.println(path);
		// 파일명 중복체크 -> 파일 중복되면 이름 다음에 숫자 붙여줌
		File renameFile = FileRenamePolicy.rename(new File(path,fileName));
		part.write(path + "/" + renameFile.getName());			// 디비에 저장된 이름으로 write 할거임
		board.setFilename(renameFile.getName());	// 그것을 board에 담기

		try { // 위의 파라미터 한꺼번에 담아주는거
			BeanUtils.copyProperties(board, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("============map============");
		Map<String, String[]> map = request.getParameterMap();
		System.out.println(map);
		System.out.println("no=" + map.get("no"));

		System.out.println("============names============");
		Enumeration<String> pnames = request.getParameterNames(); // 파라미터 이름만 읽어오기 가능
		while (pnames.hasMoreElements()) {
			System.out.println(pnames.nextElement());
		}

		// DB 등록 처리
		BoardDAO dao = new BoardDAO();
		dao.insert(board);

		// 목록으로 이동
		response.sendRedirect("boardSelectAll.do");
	}

	private String getFileName(Part part) throws UnsupportedEncodingException {
		for (String cd : part.getHeader("Content-Disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {		// filename으로 시작되는거 찾아서 
				return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;

	}

}
