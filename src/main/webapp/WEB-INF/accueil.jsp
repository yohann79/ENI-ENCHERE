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
	<div>
		<h4>Liste des echeres</h4>


		<c:forEach items="${enchereListe}" var="enchere" >
                <c:set var = "date" value = "${enchere.article.dateFinEncheres}" />
                    <article class="enchere-article">
                        <div>
                            <img src="<%=request.getContextPath()%>/upload/images/?imageName=${enchere.article.id}" alt="${enchere.article.nom}">
                        </div>
                        <div class="article-content">
                            <h3><a href="<%=request.getContextPath()%>/detailEnchere?idArticle=${enchere.article.id}">${enchere.article.nom}</a></h3>
                            <c:choose>
                                <c:when test="${enchere.article.prixVente == 0}">Prix : ${enchere.article.prixInitial} points</c:when>
                                <c:when test="${enchere.article.prixVente != 0}">Prix : ${enchere.article.prixVente} points</c:when>
                            </c:choose>
                            <p>Fin de l'enchere : <fmt:formatDate dateStyle = "long" timeStyle = "long" type = "date" value = "${date}" /> </p>
                            <p>Vendeur : <a href="<%=request.getContextPath()%>/view_vendeur?idVendeur=${enchere.article.utilisateur.id}">${enchere.article.utilisateur.pseudo}</a></p>
                        </div>
                    </article>
                </c:forEach>
       <c:forEach items="${articles}" var="enchere" >
			<article>
				<div><h3>la taille :${enchere.nomArticle}</h3>
				</div>
			</article>
		</c:forEach>
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