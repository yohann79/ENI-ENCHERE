<%@page import="org.apache.jasper.tagplugins.jstl.core.Out"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="bo.ArticleVendu"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="bo.Utilisateur"%>
<%@ page import="java.util.List"%> 
<!DOCTYPE html>
<html>
<head>
<style>
<%@ include file="../../css/accueil.css"%>
</style>
<meta charset="ISO-8859-1">
<title>Accueil</title>
</head>
<body>

     <!-- navigation -->
 	<%@ include file = "navigation.jsp" %>

	<%
	Utilisateur utilisateur = new Utilisateur();
	utilisateur = (Utilisateur) session.getAttribute("utilisateur");
	int i;
	%>
	<div align="center">
		<h2>Bonjour ${utilisateur.pseudo}</h2>
		<h3>Bienvenue sur le site d'enchere de l'eni</h3>
	</div>
	<div id="article-container">
	<h2>Liste des echeres </h2>
		<h3>Il n'y a aucune article mis au enchere</h3>
	</div>

</body>
</html>