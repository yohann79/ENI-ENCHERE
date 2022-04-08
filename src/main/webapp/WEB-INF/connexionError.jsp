<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
<%@ include file="../../css/connexion.css"%>
</style>
<meta charset="ISO-8859-1">
<title>connexion</title>
</head>
<body>
<%String error =(String) session.getAttribute("error"); %>
	<div align="center" id="container">
		
		<form action="<%=request.getContextPath()%>/Connexion" method="post">
		<h1>Connexion</h1>
			<label><b>Nom d'utilisateur</b></label> 
			<input placeholder="Entrer le nom d'utilisateur" type="text"
				name="username" /> <label><b>Mot de passe</b></label> 
				<input placeholder="Entrer le mot de passe" type="password" name="password" />
				<p id="error"><span>${error}</span></p>
			<input id='submit' type="submit" value="Connexion" />
		</form>
		<form action="<%=request.getContextPath()%>/Inscription">
			<input type="submit" value="Crée un compte utilisateur" />
		</form>
	</div>

</body>
</html>