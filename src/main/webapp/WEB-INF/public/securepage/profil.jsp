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
<title>Profil</title>
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
	
	
       <h1>Mon Profil</h1>
       
        
        <div id="list1">
			
			<label>Pseudo :</label><p><%=utilisateur.getPseudo() %></p><br>		
			<label>Nom :</label><p><%=utilisateur.getNom() %></p><br>
			<label>Prenom :</label><p><%=utilisateur.getPrenom() %></p><br>	
			<label>Email :</label><p><%=utilisateur.getEmail() %></p><br>	
			<label>Téléphone :</label><p><%=utilisateur.getTelephone() %></p><br>	
			<label>Rue :</label><p><%=utilisateur.getRue() %></p><br>
			<label>Code Postal :</label><p><%=utilisateur.getCode_postal() %></p><br>	
			<label>Ville :</label><p><%=utilisateur.getVille() %></p><br>	
			<label>Credit :</label><p><%=utilisateur.getCredit() %></p><br>	

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