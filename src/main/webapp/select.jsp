<%@page import="model.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		// request scope���� ������ ������
		// �ٿ�ĳ���� �ʼ�!
		List<MemberVO> list = (List<MemberVO>) request.getAttribute("list");
		
	%>
	
	<table border="1">
		<% for( MemberVO vo : list ) { %>
			<tr>
				<td><%= vo.getId() %></td>
				<td><%= vo.getPw() %></td>
				<td><%= vo.getNick() %></td>
			</tr>
		<% } %>
	
	</table>
	
</body>
</html>