<%@ page language="java" contentType="text/html;charset=UTF-8; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inscription</title>
</head>
<body>
	<div align="center">
		<h1>Connexion</h1>
		<form action="<%=request.getContextPath()%>/Inscription" method="post">
			<table style="with: 100%">
				<tr>
					<td>Pseudo</td>
					<td><input type="text" name="pseudo" maxlength="30"/></td>
				</tr>
				<tr>
					<td>Nom</td>
					<td><input type="text" name="nom" maxlength="30"/></td>
				</tr>
				<tr>
					<td>Prenom</td>
					<td><input type="text" name="prenom" maxlength="30"/></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text" name="email" maxlength="30"/></td>
				</tr>
				<tr>
					<td>numéro de téléphone</td>
					<td><input type="text" name="telephone" maxlength="30"/></td>
				</tr>
				<tr>
					<td>rue</td>
					<td><input type="text" name="rue" maxlength="30"/></td>
				</tr>
				<tr>
					<td>Code postal</td>
					<td><input type="text" name="codePostal" maxlength="30"/></td>
				</tr>
				<tr>
					<td>Ville</td>
					<td><input type="text" name="ville" maxlength="30"/></td>
				</tr>
				<tr>
					<td>Mots de passe</td>
					<td><input type="password" name="motDePasse" maxlength="30"/></td>
				</tr>
				<tr>
					<td>Répéter mots de passe</td>
					<td><input type="password" name="confirmMotDePasse" maxlength="30"/></td>
				</tr>
			</table>
			<input type="submit" value="Créer un compte" />
		</form>
	</div>

</body>
</html>