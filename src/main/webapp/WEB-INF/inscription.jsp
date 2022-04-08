<%@ page language="java" contentType="text/html;charset=UTF-8; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
<%@ include file="../../css/connexion.css"%>
</style>
<meta charset="ISO-8859-1">
<title>Inscription</title>
</head>
<body>
	<div align="center" id="container">
		
		<form action="<%=request.getContextPath()%>/Inscription" method="post">
		<p><a href="Connexion"><img id="bouton-retour" src="<%=request.getContextPath()%>/ressources/img/bouton-retour.jpg"></a></p>
				<h1>Connexion</h1>
					<label><b>Pseudo</b></label>
					<input type="text" name="pseudo" maxlength="30"/>
				
				
					<label><b>Nom</b></label>
					<input type="text" name="nom" maxlength="30"/>
				
				
					<label><b>Prenom</b></label>
					<input type="text" name="prenom" maxlength="30"/>
				
				
					<label><b>Email</b></label>
					<input type="text" name="email" maxlength="30"/>
				
				
					<label><b>Numéro de téléphone</b></label>
					<input type="text" name="telephone" maxlength="30"/>
				
				
					<label><b>Rue</b></label>
					<input type="text" name="rue" maxlength="30"/>
				
					<label><b>Code postal</b></label>
					<input type="text" name="codePostal" maxlength="30"/>
				
				
					<label><b>Ville</b></label>
					<input type="text" name="ville" maxlength="30"/>
				
				
					<label><b>Mots de passe</b></label>
					<input type="password" name="motDePasse" maxlength="30"/>
				
				
					<label><b>Répéter mots de passe</b></label>
					<input type="password" name="confirmMotDePasse" maxlength="30"/>
			<input type="submit" value="Créer un compte" />
		</form>
	</div>

</body>
</html>