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

			// 0. ���ڵ�
	      request.setCharacterEncoding("euc-kr");
	      
	      // 1. �Ķ���� ����
	      String id = request.getParameter("id");
	      String pw = request.getParameter("pw");
	      
	      // VO(DTO)�� �����ֱ�
	      MemberVO vo = new MemberVO(id, pw);
	      
	      // 3. DAO�޼��� ���
	      MemberDAO dao = new MemberDAO();
	      int cnt = dao.login(vo);
	      
	      // ���� ���� �Ǵ�
	      if(cnt > 0) {
	         // main.html���� �̵�
	         response.sendRedirect("main.html");
	      }else {
	         // login.html�� �̵�
	         response.sendRedirect("login.html");
	      }
	}

}
