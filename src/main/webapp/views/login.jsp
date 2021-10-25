<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<form action="processlogin" method="post">
			<table class="loginForm">
				<tr>
					<td><label for="username">User Name</label></td>
					<td><input type="text" id="username" name="username"
						class="searchTextField" /></td>
				</tr>
				<tr>
					<td><label for="password">Password</label></td>
					<td><input type="password" id="password" name="password"
						class="searchTextField" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Login" class="actionBtn" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>