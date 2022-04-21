package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		// VO(DTO)로 묶어야 파라미터 수집 끝!
		MemberVO vo = new MemberVO(id, pw, nick);

		// 2. JDBC --> Runtime Error를 처리해줘야 함
		
		try {
			// 2-1) 동적로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2-2) 연결객체 생성
			String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 데이터베이스 주소
			String uid = "hr"; // 데이터베이스 계정
			String upw = "hr"; // 비밀번호
		
			Connection conn = DriverManager.getConnection(url, uid, upw);
			
			// 2-3) SQL문 실행준비
			String sql = "insert into jdbc_member values(?, ?, ?)";
			
			PreparedStatement psmt = conn.prepareStatement(sql);
			
			// 바인드 변수 채우기
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPw());
			psmt.setString(3, vo.getNick());
		
			// 2-4) 실행
			psmt.executeUpdate();
			
			// 2-5) 객체 닫기
		
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
	}

}
