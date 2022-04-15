<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.Out"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="bo.ArticleVendu"%>
<%@ page import="bo.Utilisateur"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
    <html lang="fr">
    <head>
        <meta charset="UTF-8">
<style>
<%@include file="/css/style.css"%>
</style>

<title>Détail Vente</title>

</head>
    
  <body>
  <!-- Navigation -->
 	<%@ include file = "/WEB-INF/public/home/navigation.jsp" %>
   
    <div id="container">
		<div id="container2">
      <h1>Détail Vente</h1>
    </div>
		 
    <% Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur"); %>
	<% ArticleVendu article = (ArticleVendu) session.getAttribute("article"); %>
	

        
       	 <div id="list1">
			<label>Nom :</label><p><%=article.getNomArticle() %></p><br>
			<label>Description :</label><p><%=article.getDescription() %></p><br>	
			<label>Mise à Prix :</label><p><%=article.getPrixInitial() %></p><br>	
			<label>Fin enchère :</label><p><%=article.getDateFinEnchere() %></p><br>	
			<label>Retrait :</label><p><%=article.getLieuRetrait().getRue() %>,<%=article.getLieuRetrait().getCode_postal()%>,<%=article.getLieuRetrait().getVille() %></p><br>
			<label>Vendeur :</label><p><%=article.getVendeur().getPseudo() %></p><br>
				
		</div>
		<form action="<%=request.getContextPath()%>/Enchere" method="post">
			<div class="input-field">
				<label for="mPrix">Ma Proposition :</label>
				<input class="input" type="number" name="mPrix" id="mPrix" step="1" max= "10000" required>
			</div>
		    <div>
		        <button class="btn-login" type="submit">Enchérir</button>
		    </div>
	      
		</form>

         <form action="<%=request.getContextPath()%>/Accueil" method="post">
			<input type="submit" value="Annuler" /> 
	</form>
        
     
     
    </div>
  </body>
</html>