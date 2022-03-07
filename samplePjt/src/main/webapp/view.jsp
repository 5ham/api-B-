<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="vo.*" %>
<%
	String id = request.getParameter("id");

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "hr";
	String password="1234";
	DepartmentVO vo = new DepartmentVO();
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url,user,password);
		
		String sql = "select * from departments where department_id="+id;
		psmt = conn.prepareStatement(sql);
		
		rs = psmt.executeQuery();
		
		if(rs.next()){
			vo.setDepartmentId(rs.getInt("department_id"));
			vo.setDepartmentName(rs.getString("department_name"));
		}
		

	}catch(Exception e){
		e.printStackTrace();
	}finally{
		if(conn != null) conn.close();
		if(psmt != null) psmt.close();
		if(rs != null) rs.close();
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>부서 번호</td>
			<td><%= vo.getDepartmentId() %></td>
		</tr>
		<tr>
			<td>부서 번호</td>
			<td><%= vo.getDepartmentName() %></td>
		</tr>
	</table>
	<button onclick="location.href='modify.jsp?id=<%= vo.getDepartmentId() %>'">수정</button>
</body>
</html>