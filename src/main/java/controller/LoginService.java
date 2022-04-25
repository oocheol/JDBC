package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;

@WebServlet("/LoginService")
public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			// 0. 인코딩
	      request.setCharacterEncoding("euc-kr");
	      
	      // 1. 파라미터 수집
	      String id = request.getParameter("id");
	      String pw = request.getParameter("pw");
	      
	      // VO(DTO)로 묶어주기
	      MemberVO vo = new MemberVO();
	      vo.setId(id);
	      vo.setPw(pw);
	      
	      // 3. DAO메서드 사용
	      MemberDAO dao = new MemberDAO();
	      MemberVO mvo = dao.login(vo);
	      
	      // 4. 결과에 따라 페이지 이동
	      if(mvo == null) {
	    	  System.out.println("로그인 실패");
	    	  response.sendRedirect("login.html");
	      } else {
	    	  System.out.println("로그인 성공 : " + vo.getId());
	    	  response.sendRedirect("main.html");
	    	  
	      }
	      
	}

}
