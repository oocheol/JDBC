package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;

@WebServlet("/SelectService")
public class SelectService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// DAO에서 데이터 꺼내기
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.select();
		
		System.out.println(list.size());
		
		// request scope에 데이터 저장
		// 객체 바인딩
		request.setAttribute("list", list);
		
		// forward 방식으로 이동
		// url 경로가 바뀌지 않는다.
		// 내부 서버(프로젝트 내 파일)로만 이동 가능하다.
		RequestDispatcher rd = request.getRequestDispatcher("select.jsp");
		rd.forward(request, response);
	
	}

}
