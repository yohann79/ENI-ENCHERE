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
<style>
<%@ include file="/css/accueil.css"%>
</style>
<meta charset="ISO-8859-1">
<title>Accueil</title>
</head>
     <!-- navigation -->
 	<%@ include file = "navigation.jsp" %>
<body>



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
		<h3>Aucun article aux enchères pour l'instant.</h3>
	</div>

</body>
</html>