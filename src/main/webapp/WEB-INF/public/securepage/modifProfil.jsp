<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="bo.Utilisateur"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil</title>
</head>
<style>
<%@include file="/css/profil.css"%>
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
		<form action="<%=request.getContextPath()%>/ModifierProfil" method="post">
       <h1>Modification</h1>
       
       
	<div id="list1">
			<p style="display: none">${utilisateur.no_utilisateur}</p>
			
			<label>Pseudo :</label><input type="text" name="pseudo" placeholder="${utilisateur.pseudo}" /><br>			
			<label>Nom :</label><input type="text" name="nom" placeholder="${utilisateur.nom}" /><br>	
			<label>Prenom :</label><input type="text" name="prenom" placeholder="${utilisateur.prenom}" /><br>	
			<label>Email :</label><input type="text" name="email" placeholder="${utilisateur.email}" /><br>	
			<label>Téléphone :</label><input type="text" name="telephone" placeholder="${utilisateur.telephone}" /><br>	
			<label>Rue :</label><input type="text" name="rue" placeholder="${utilisateur.rue}" /><br>	
			<label>Code Postal :</label><input type="text" name="code_postal" placeholder="${utilisateur.code_postal}" /><br>	
			<label>Ville :</label><input type="text" name="ville" placeholder="${utilisateur.ville}" /><br>	
			<label>Credit :</label><input type="text" name="credit"  disabled="disabled" placeholder="${utilisateur.credit}" /><br>	
			<label>Mots de passe :</label><input type="text" name="mot_de_passe" placeholder="${utilisateur.mot_de_passe}" /><br>	
	
	</div>
	
	<input type="submit" value="Enregister" />
   			
   				</form>
   <form action="<%=request.getContextPath()%>/Accueil" method="post">
			<input type="submit" value="Annuler" /> 
	</form>
	</div>
	</div>
</body>
</html>