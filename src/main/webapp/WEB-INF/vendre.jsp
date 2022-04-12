<%@ page language="java" contentType="text/html;charset=UTF-8; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
<%@ include file="../../css/vente.css"%>
</style>
<meta charset="ISO-8859-1">
<title>Vendre</title>
</head>
<body>
     <!-- navigation -->
 	<%@ include file = "navigation.jsp" %>
 	
<div id="container">
	<div id="container2">
		
		
	
		
		<form action="<%=request.getContextPath()%>/Vendre" method="post">
		
		<h1>Vendre un Article</h1>
					
					<label>Article</label><input type="text" name="nomArticle" maxlength="30"/><br>			
					<label>Description</label><input type="text" name="nom" maxlength="30"/><br>								
					<label>Categorie</label><input type="text" name="prenom" maxlength="30"/><br>							
					<label>Mise à Prix</label><input type="text" name="email" maxlength="30"/><br>						
					<label>Début de l'enchère</label><input type="text" name="telephone" maxlength="30"/><br>			
					<label>Fin de l'enchère</label><input type="text" name="rue" maxlength="30"/><br>
				<div class="main-div">
				<div class="main-div-overlay-text">
   						 Retrait
  				</div>	
				
					<label>Rue</label><input type="text" name="Rue" maxlength="30"/><br>
					<label><b>Code Postal</b></label><input type="text" name="CodePostal" maxlength="30"/><br>	
					<label><b>Ville</b></label><input type="text" name="ville" maxlength="30"/><br>
				</div>
			<input type="submit" value="Annuler" /> 
			<input type="submit" value="Enregister" />
		</form>
	</div>
</div>
</body>
</html>