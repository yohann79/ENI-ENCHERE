<%@ page language="java" contentType="text/html;charset=UTF-8; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
<%@ include file="../../css/connexion.css"%>
</style>
<meta charset="ISO-8859-1">
<title>Vendre</title>
</head>
<body>

	<div align="center" id="container">
		
		
	
		
		<form action="<%=request.getContextPath()%>/Vendre" method="post">
		
		<h1>Vendre un Article</h1>
		
				<ul id="list">
					<li><label><b>Article</b></label>
					<input type="text" name="nomArticle" maxlength="30"/></li>
				
					<li><label><b>Description</b></label>
					<input type="text" name="nom" maxlength="30"/></li>				
				
					<li><label><b>Categorie</b></label>
					<input type="text" name="prenom" maxlength="30"/></li>				
				
					<li><label><b>Mise à Prix</b></label>
					<input type="text" name="email" maxlength="30"/></li>			
				
					<li><label><b>Début de l'enchère</b></label>
					<input type="text" name="telephone" maxlength="30"/></li>				
				
					<li><label><b>Fin de l'enchère</b></label>
					<input type="text" name="rue" maxlength="30"/></li>
				</ul>
						
				<ul id="retrait">
					<li><label><b>Rue</b></label>
					<input type="text" name="ville" maxlength="30"/></li>			
				
					<li><label><b>Code Postal</b></label>
					<input type="password" name="motDePasse" maxlength="30"/></li>
								
					<li><label><b>Ville</b></label>
					<input type="password" name="confirmMotDePasse" maxlength="30"/></li>
				</ul>
				

			<input type="submit" value="Annuler" /> 
			<input type="submit" value="Enregister" />
		</form>
	</div>

</body>
</html>