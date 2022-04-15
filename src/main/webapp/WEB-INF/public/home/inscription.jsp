<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
<%@ include file="/css/connexion.css"%>
</style>
<meta charset="ISO-8859-1">
<title>Inscription</title>
</head>
<body>

	<div align="center" id="container">
		
		
	
		
		<form action="<%=request.getContextPath()%>/Inscription" method="post">
		
		<h1>Inscription</h1>
		
			<p align="left"><a href="Accueil"><img id="bouton-retour" src="<%=request.getContextPath()%>/ressources/img/bouton-retour.jpg"><br></a></p>
				<ul id="list">
					<li><label><b>Pseudo</b></label>
					<input type="text" name="pseudo" maxlength="30" required/></li>
				
					<li><label><b>Nom</b></label>
					<input type="text" name="nom" maxlength="30"required/></li>				
				
					<li><label><b>Prenom</b></label>
					<input type="text" name="prenom" maxlength="30"required/></li>				
				
					<li><label><b>Email</b></label>
					<input type="text" name="email" maxlength="50"required/></li>			
				
					<li><label><b>Numéro de téléphone</b></label>
					<input type="text" name="telephone" maxlength="15"required/></li>				
				
					<li><label><b>Rue</b></label>
					<input type="text" name="rue" maxlength="30"required/></li>
				
					<li><label><b>Code postal</b></label>
					<input type="text" name="codePostal" maxlength="10"required/></li>			
				
					<li><label><b>Ville</b></label>
					<input type="text" name="ville" maxlength="50"required/></li>			
				
					<li><label><b>Mots de passe</b></label>
					<input type="password" name="motDePasse" maxlength="30"required/></li>
								
					<li><label><b>Répéter mots de passe</b></label>
					<input type="password" name="confirmMotDePasse" maxlength="30"required/></li>
				</ul>
			<input type="submit" value="Créer un compte" />
		</form>
	</div>

</body>
</html>
