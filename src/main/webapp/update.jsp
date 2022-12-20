<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> Company Name </h1>
	<form action="UpdateServlet" method="post">
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" value="${list.name}" /></td>
			</tr>
			<tr>
					<td>Email:</td>
				<td><input type="email" name="email" value="${list.email}" /></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><input type="text" name="address" value="${list.address}" /></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><input type="text" name="city" value="${list.city}"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="update Employee" /></td>
			</tr>
		</table>
	</form>
<br/>
		<a href="View.jsp"> view employees</a> 
</body>
</html>