<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>hello jsp</h1>
	<%
		// 스크립트릿
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		// =name 은 표현식 
	%>	
	<h3><%=name %></h3>
	<h2><%=age %></h2>
</body>
</html>