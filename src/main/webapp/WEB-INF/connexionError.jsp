<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>connexion</title>
</head>
<body>
<%String error =(String) session.getAttribute("error"); %>
	<div align="center">
		<h1>Connexion</h1>
		<form action="<%=request.getContextPath()%>/Connexion" method="post">
			<table style="with: 100%">
				<tr>
					<td>Pseudo</td>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
					<td>Mots de passe</td>
					<td><input type="password" name="password" /></td>
				</tr>

			</table>
			<p><span>${error}</span></p>
			<input type="submit" value="Connexion" />
		</form>
		<form action="<%=request.getContextPath()%>/Inscription">
		<input type="submit" value="Crée un compte utilisateur" />	
		</form>
	</div>
</body>
</html>