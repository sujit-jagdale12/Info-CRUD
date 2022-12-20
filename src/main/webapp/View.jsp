<%@page import="com.Dao.DaoC" %>
<%@page import="com.model.Emp" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
       	List<Emp> li = DaoC.getAllEmployees();
		session.setAttribute("list", li);
%>
<table border="2">
<tr>
<th>ID</th>
<th>NAME</th>
<th>Email</th>
<th>Address</th>
<th>City</th>
<th>UPDATE</th>
<th>DELETE</th>
</tr>


		<c:forEach items = "${list }" var ="l">
		<tr>
					<td>${l.id  }</td>
					<td>${l.name }</td>
					<td>${l.email }</td>
					<td>${l.address }</td>
					<td>${l.city }</td>
				<td><a href="UpdateServlet?id=${l.id }">update</a></td>
				<td><a href="DeletServlet?id=${l.id }">delete</a></td>
		</tr>
		
		
		
		</c:forEach>
		</table>

</body>
</html>