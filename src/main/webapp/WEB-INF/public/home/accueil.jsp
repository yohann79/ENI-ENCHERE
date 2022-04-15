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
<%@include file="/css/accueil.css"%>
</style>
<title>Accueil</title>

     <!-- navigation -->
 	<%@ include file = "navigation.jsp" %>
 	
 	
</head>
<body>


 	
 	
	<%
	Utilisateur utilisateur = new Utilisateur();
	ArrayList<ArticleVendu> articles = new ArrayList();
	articles = (ArrayList<ArticleVendu>) request.getAttribute("articles");
	utilisateur = (Utilisateur) session.getAttribute("utilisateur");
	int i;%>
	
	
	<%if (utilisateur == null) {%>

	<%} %>
	<div align="center">
		<%
		if (utilisateur != null) {
		%>
		<h2>Bonjour  ${utilisateur.pseudo}</h2>
		<%
		}
		%>
		<h3>Bienvenue sur le site d'enchere de la DreamTeam</h3>
	</div>
	<div id="article-container">
		<h3 align="center">Liste des dernières enchères</h3>
		<%
		for (ArticleVendu article : articles) {
		%>
		
			<div id="article" >
				<h4>
					Nom :
					<%=article.getNomArticle()%></h4>
				<h4>
					Description :
					<%=article.getDescription()%></h4>
				<h4>
					Prix :
					<%=article.getPrixInitial()%></h4>
				<h4>
					Fin de l'enchere :
					<%=article.getDateFinEnchere()%></h4>
				<form action="<%=request.getContextPath()%>/Enchere">
					<input type="submit" value="Acceder à l'article" />
				</form>
			</div>
		
		<%
		}
		%>
	</div>

</body>
</html>