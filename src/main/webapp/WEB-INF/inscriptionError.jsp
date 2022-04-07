<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
					<td><input type="text" name="pseudo" /></td>
				</tr>
				<tr>
					<td>Nom</td>
					<td><input type="text" name="nom" /></td>
				</tr>
				<tr>
					<td>Prenom</td>
					<td><input type="text" name="prenom" /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text" name="email" /></td>
				</tr>
				<tr>
					<td>numéro de téléphone</td>
					<td><input type="text" name="telephone" /></td>
				</tr>
				<tr>
					<td>rue</td>
					<td><input type="text" name="rue" /></td>
				</tr>
				<tr>
					<td>Code postale</td>
					<td><input type="text" name="codePostal" /></td>
				</tr>
				<tr>
					<td>Ville</td>
					<td><input type="text" name="ville" /></td>
				</tr>
				<tr>
					<td>Mots de passe</td>
					<td><input type="password" name="motDePasse" /></td>
				</tr>
				<tr>
					<td>Répéter mots de passe</td>
					<td><input type="password" name="confirmMotDePasse" /></td>
				</tr>
			</table>
			<p><span>${error}</span></p>
			<input type="submit" value="Créer un compte" />
		</form>
	</div>

</body>
</html>