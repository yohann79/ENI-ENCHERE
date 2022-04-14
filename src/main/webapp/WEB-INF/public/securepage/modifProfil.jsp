<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.Out"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="bo.ArticleVendu"%>
<%@ page import="bo.Utilisateur"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil</title>
</head>
<style>
<%@include file="/css/style.css"%>
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
			
			<label>Pseudo :</label><input type="text" name="pseudo" placeholder="${utilisateur.pseudo}" required/><br>			
			<label>Nom :</label><input type="text" name="nom" placeholder="${utilisateur.nom}" required/><br>	
			<label>Prenom :</label><input type="text" name="prenom" placeholder="${utilisateur.prenom}" required/><br>	
			<label>Email :</label><input type="text" name="email" placeholder="${utilisateur.email}"required/><br>	
			<label>Téléphone :</label><input type="text" name="telephone" placeholder="${utilisateur.telephone}" required/><br>	
			<label>Rue :</label><input type="text" name="rue" placeholder="${utilisateur.rue}" required/><br>	
			<label>Code Postal :</label><input type="text" name="codePostal" placeholder="${utilisateur.code_postal}" required/><br>	
			<label>Ville :</label><input type="text" name="ville" placeholder="${utilisateur.ville}" required/><br>	
			<label>Mots de passe :</label><input type="password" name="motDePasse"  required/><br>	
			<label>Mots de passe :</label><input type="password" name="confirmMotDePasse"  required/><br>	
	</div>
	

	<input type="submit" value="Enregister" />
	<%System.out.println("test form"); %>

   	</form>
   <form action="<%=request.getContextPath()%>/Accueil" method="post">
			<input type="submit" value="Annuler" /> 
	</form>
	</div>
	</div>
</body>
</html>