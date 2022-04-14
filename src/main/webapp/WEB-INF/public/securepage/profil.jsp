<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="bll.UtilisateurManager"%>
<%@ page import="bo.Utilisateur"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profil</title>
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
	
	
       <h1>Mon Profil</h1>
       
        
        <div id="list1">
			
			<label>Pseudo :</label><input type="text" value="${utilisateur.pseudo}" disabled="disabled"/><br>			
			<label>Nom :</label><input type="text" value="${utilisateur.nom}" disabled="disabled"/><br>	
			<label>Prenom :</label><input type="text" value="${utilisateur.prenom}" disabled="disabled"/><br>	
			<label>Email :</label><input type="text" value="${utilisateur.email}" disabled="disabled"/><br>	
			<label>Téléphone :</label><input type="text"  value="${utilisateur.telephone}" disabled="disabled"/><br>	
			<label>Rue :</label><input type="text" value="${utilisateur.rue}" disabled="disabled"/><br>	
			<label>Code Postal :</label><input type="text" value="${utilisateur.code_postal}" disabled="disabled"/><br>	
			<label>Ville :</label><input type="text" name="ville" value="${utilisateur.ville}" disabled="disabled"/><br>	
			<label>Credit :</label><input type="text" name="credit"  disabled="disabled" placeholder="${utilisateur.credit}" disabled="disabled"/><br>	

	</div>
		
		<form action="<%=request.getContextPath()%>/ModifierProfil">
			<input type="submit" value="modifier le profil" />
		</form>
		<form action="<%=request.getContextPath()%>/SupprimerProfil">
			<input type="submit" value="Suprimer le profil" />
		</form>
		
		</div>

	</div>
</body>
</html>