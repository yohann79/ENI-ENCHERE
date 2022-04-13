<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="bll.UtilisateurManager"%>
<%@ page import="bo.Utilisateur"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profil</title>
</head>
<style>
<style>
<%@include file="/css/profil.css"%>
</style>
     <!-- navigation -->
 	<%@ include file = "../home/navigation.jsp" %>
<body>

 	
      <%
	Utilisateur utilisateur = null;
	if (session.getAttribute("utilisateur") == null) {
	} else {
		utilisateur = (Utilisateur) session.getAttribute("utilisateur");
	}
	%>
	
	<div align="center" id="container">
       <h2>Mon Profil</h2>
        <ul id="profil_list")>
			<li>Pseudo :</li>
			<li>Nom :</li>
			<li>Prenom :</li>
			<li>Email :</li>
			<li>Téléphone :</li>
			<li>Rue :</li>
			<li>Code Postal :</li>
			<li>Ville :</li>
			<li>Credit :</li>
			
			<li>${utilisateur.pseudo}</li>
			<li>${utilisateur.nom}</li>
			<li>${utilisateur.prenom}</li>
			<li>${utilisateur.email}</li>
			<li>${utilisateur.telephone}</li>
			<li>${utilisateur.rue}</li>
			<li>${utilisateur.code_postal}</li>
			<li>${utilisateur.ville}</li>
			<li>${utilisateur.credit}</li>
		</ul>

		<form action="<%=request.getContextPath()%>/ModifierProfil">
			<input type="submit" value="modifier le profil" />
		</form>
		<form action="<%=request.getContextPath()%>/SupprimerProfil">
			<input type="submit" value="Suprimer le profil" />
		</form>
		
		

	</div>
</body>
</html>