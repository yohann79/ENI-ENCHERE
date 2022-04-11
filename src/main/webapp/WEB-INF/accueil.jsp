<%@page import="org.apache.jasper.tagplugins.jstl.core.Out"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="bo.ArticleVendu"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="bo.ArticleVendu"%>
<%@ page import="bo.Utilisateur"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<style>
<%@include file="../../css/accueil.css"%>
</style>
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/ressources/img/icon.ico">
<meta charset="ISO-8859-1">
<title>Accueil</title>
</head>
<body>
	<%
	Utilisateur utilisateur = new Utilisateur();
	ArrayList<ArticleVendu> articles = new ArrayList();
	articles = (ArrayList<ArticleVendu>) request.getAttribute("articles");
	utilisateur = (Utilisateur) session.getAttribute("utilisateur");
	int i;%>
	
	
	<%if (utilisateur == null) {%>
	<form action="<%=request.getContextPath()%>/Connexion">
		<input type="submit" value="Connexion" />
	</form>
	<%}else{%>
	<form action="<%=request.getContextPath()%>/Profil">
		<input type="submit" value="Profil" />
	</form>
	<form action="<%=request.getContextPath()%>/Deconnexion">
		<input type="submit" value="Deconnexion" />
	</form>
	<%} %>
	<div align="center">
		<%
		if (utilisateur != null) {
		%>
		<h2>Bonjour ${utilisateur.pseudo}</h2>
		<%
		}
		%>
		<h3>Bienvenue sur le site d'enchere de l'eni</h3>
	</div>
	<div id="article-container">
		<h1>Liste des echeres</h1>
		<%
		for (ArticleVendu article : articles) {
		%>
		<article>
			<div id="article" align="center">
				<h3>
					Nom :
					<%=article.getNomArticle()%></h3>
				<h3>
					Description :
					<%=article.getDescription()%></h3>
				<h3>
					Prix :
					<%=article.getPrixvente()%></h3>
				<h3>
					Date de fin de l'enchere :
					<%=article.getDateFinEnchere()%></h3>
				<form action="<%=request.getContextPath()%>/Article">
					<input type="submit" value="Acceder à l'article" />
				</form>
			</div>
		</article>
		<%
		}
		%>
	</div>

</body>
</html>