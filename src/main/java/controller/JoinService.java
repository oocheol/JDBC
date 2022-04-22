package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;


@WebServlet("/JoinService")
public class JoinService extends HttpServlet {
   private static final long serialVersionUID = 1L;
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      // 0. 인코딩
      request.setCharacterEncoding("euc-kr");
      
      // 1. 파라미터 수집
      String id = request.getParameter("id");
      String pw = request.getParameter("pw");
      String nick = request.getParameter("nick");
      
      // VO(DTO)로 묶어주기
      MemberVO vo = new MemberVO(id, pw, nick);
      
      // 3. DAO메서드 사용
      MemberDAO dao = new MemberDAO();
      int cnt = dao.join(vo);
      
      // 성공 유무 판단
      if(cnt > 0) {
         // main.html으로 이동
         response.sendRedirect("main.html");
      }else {
         // join.html로 이동
         response.sendRedirect("join.html");
      }
      
      
      
      
   
   }

}