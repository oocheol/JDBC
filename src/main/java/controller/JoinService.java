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
		
		// 0. ���ڵ�
		request.setCharacterEncoding("euc-kr");
		
		// 1. �Ķ���� ����
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String nick = request.getParameter("nick");

		// VO(DTO)�� ����� �Ķ���� ���� ��!
		MemberVO vo = new MemberVO(id, pw, nick);

		// 2. JDBC --> Runtime Error�� ó������� ��
		
		try {
			// 2-1) �����ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2-2) ���ᰴü ����
			String url = "jdbc:oracle:thin:@localhost:1521:xe"; // �����ͺ��̽� �ּ�
			String uid = "hr"; // �����ͺ��̽� ����
			String upw = "hr"; // ��й�ȣ
		
			Connection conn = DriverManager.getConnection(url, uid, upw);
			
			// 2-3) SQL�� �����غ�
			String sql = "insert into jdbc_member values(?, ?, ?)";
			
			PreparedStatement psmt = conn.prepareStatement(sql);
			
			// ���ε� ���� ä���
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPw());
			psmt.setString(3, vo.getNick());
		
			// 2-4) ����
			psmt.executeUpdate();
			
			// 2-5) ��ü �ݱ�
		
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
	}

}
