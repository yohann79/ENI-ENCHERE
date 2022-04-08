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
<%@ include file="../../css/accueil.css"%>
</style>
<link rel="shortcut icon" href="<%=request.getContextPath()%>/ressources/img/icon.ico">
<meta charset="ISO-8859-1">
<title>Accueil</title>
</head>
<body>

	<%
	Utilisateur utilisateur = new Utilisateur();
	ArrayList<ArticleVendu> articles = new ArrayList();
	articles = (ArrayList<ArticleVendu>) request.getAttribute("articles");
	utilisateur = (Utilisateur) session.getAttribute("utilisateur");
	int i;
	%>
	<div align="center">
		<h2>Bonjour ${utilisateur.pseudo}</h2>
		<h3>Bienvenue sur le site d'enchere de l'eni</h3>
	</div>
	<div id="article-container">
		<h1>Liste des echeres </h1>
		<!--TODO: ne pas utiliser de java dans les jsp modifier l'utilisation de la liste par des balises jstl -->
       <%-- <c:forEach items="${articles}" var="article" >
			<article>
				<div><h3>la taille :${article.nomArticle}</h3>
				</div>
			</article>
		</c:forEach> --%>  
		
		<%for (ArticleVendu article : articles){%>
		<article>
				<div id="article">
				<h3><%=article.getNomArticle() %></h3>
				<h3><%=article.getDescription() %></h3>
				<h3><%=article.getPrixvente() %></h3>
				<h3><%=article.getDateFinEnchere()%></h3>
				</div>
		</article>
		<%}%>
	</div>
	<form action="<%=request.getContextPath()%>/Profil">
		<input type="submit" value="Profil" />
	</form>
	<form action="<%=request.getContextPath()%>/Connexion">
		<input type="submit" value="Connexion" />
	</form>
	<form action="<%=request.getContextPath()%>/Inscription">
		<input type="submit" value="Inscription" />
	</form>
</body>
</html>