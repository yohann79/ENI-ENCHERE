<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Vendre</title>
</head>
<style>
<%@include file="/css/vente.css"%>
</style>
     <!-- navigation -->
 	<%@ include file = "../home/navigation.jsp" %>
<body>

 	
<div id="container">
	<div id="container2">
		
	<%
	Utilisateur utilisateur = null;
	if (session.getAttribute("utilisateur") == null) {
	} else {
		utilisateur = (Utilisateur) session.getAttribute("utilisateur");
	}
	%>
		
	
		
		<form action="<%=request.getContextPath()%>/Vendre" method="post">
		
		<h1>Vendre un Article</h1>
					<div id="list1">
					<label>Article</label><input type="text" name="nomArticle" maxlength="30"/><br>			
					<label>Description</label><input type="text" name="description" maxlength="30"/><br>
					
					<label>Categorie</label><input type="hidden" name="select_extra" value="1">
					<select name="categorie" id=1>
							<option value="">Selectionne une Catégorie</option>
        					<option value=2>Informatique</option>
        					<option value=3>Véhicule</option>
        					<option value=4>Meuble</option>
        					<option value=5>Sport</option>
        					<option value=6>Mode</option>
        					<option value=7>Gaming</option>
        					<option value=8>Enfant</option>
        					<option value=9>Cosmétique</option>
    				</select><br>							







							
					<label>Mise à Prix</label><input type="text" name="prixInitial" maxlength="30"/><br>						
					<label>Début de l'enchère</label><input type="date" name="dateDebutEnchere" min=datetime-local max=datetime-local+30/><br>			
					<label>Fin de l'enchère</label><input type="date" name="dateFinEnchere" min=datetime-local max=datetime-local+60/><br>
					</div>
				<div class="main-div">
				<div class="main-div-overlay-text">
   						 Retrait
  				</div>	
				
					<label>Rue</label><input type="text" name="rue" maxlength="30"/><br>
					<label><b>Code Postal</b></label><input type="text" name="codePostal" maxlength="30"/><br>	
					<label><b>Ville</b></label><input type="text" name="ville" maxlength="30"/><br>
				</div>
				<p id = "error"><span>${error}</span></p>
			<input type="submit" value="Annuler" /> 
			<input type="submit" value="Enregister" />
		</form>
	</div>
</div>
</body>
</html>