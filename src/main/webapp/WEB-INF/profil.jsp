<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="bo.Utilisateur"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil</title>
</head>
<body>
	<%
	Utilisateur utilisateur = null;
	if (session.getAttribute("utilisateur") == null) {
	} else {
		utilisateur = (Utilisateur) session.getAttribute("utilisateur");
	}
	%>
	<div align="center">
		<tr>
			<td>Pseudo</td>
			<td><input type="text" name="username"
				placeholder="${utilisateur.pseudo}" /></td>
		</tr>
		<tr>
			<td>Nom</td>
			<td><input type="text" name="username"
				placeholder="${utilisateur.nom}" /></td>
		</tr>
		<tr>
			<td>Prenom</td>
			<td><input type="text" name="username"
				placeholder="${utilisateur.prenom}" /></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input type="text" name="username"
				placeholder="${utilisateur.email}" /></td>
		</tr>
		<tr>
			<td>Téléphone</td>
			<td><input type="text" name="username"
				placeholder="${utilisateur.telephone}" /></td>
		</tr>
		<tr>
			<td>Rue</td>
			<td><input type="text" name="username"
				placeholder="${utilisateur.rue}" /></td>
		</tr>
		<tr>
			<td>Code Postal</td>
			<td><input type="text" name="username"
				placeholder="${utilisateur.code_postal}" /></td>
		</tr>
		<tr>
			<td>Ville</td>
			<td><input type="text" name="username"
				placeholder="${utilisateur.ville}" /></td>
		</tr>
		<tr>
			<td>Crédit</td>
			<td><input type="text" name="username"
				placeholder="${utilisateur.credit}" /></td>
		</tr>
	</div>
	<form action="<%=request.getContextPath()%>/Accueil">
		<input type="submit" value="retour a l'accueil" />
	</form>
</body>
</html>