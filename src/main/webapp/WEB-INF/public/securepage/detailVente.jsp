<%@page import="bo.Enchere"%>
<%@page import="java.util.Locale"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="bo.ArticleVendu"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <html lang="fr">
    <head>
        <meta charset="UTF-8">

		
        <!--Font Awesome CDN-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />


        <title>Echères</title>
        
    </head>
  <body>
  <!-- Navigation -->
 	<%@ include file = "/WEB-INF/public/home/navigation.jsp" %>
   <!--Head-->
    <div class="head">
      <h1>Détail Vente</h1>
    </div>
    <% Utilisateur connectedUser = (Utilisateur) session.getAttribute("ConnectedUser"); %>
	<% ArticleVendu article = (ArticleVendu)request.getAttribute("ArticleAffiche"); %>
    <div class="container-vente">
        <div class="card-img-container">
            <img src="img/tournevis.jpeg" alt="">
        </div>
        <table>
       		 <tr>
                <td class="td1"><p class="value-td1">Nom:</p></td>
                <td class="td2"><p class="value-td2"><%=article.getNomArticle() %></p></td>
            </tr>
            <tr>
                <td class="td1"><p class="value-td1">Description:</p></td>
                <td class="td2"><p class="value-td2"><%=article.getDescription() %></p></td>
            </tr>
            <%if(article.getPrixInitial() != 0) { %>
            <tr>
                <td class="td1"><p class="value-td1">Meilleure offre:</p></td>
                <td class="td2"><p class="value-td2"><%=article.getPrixInitial()%> pts </p></td>
            </tr>
            <% } %>
            <tr>
                <td class="td1"><p class="value-td1">Mise à prix:</p></td>
                <td class="td2"><p class="value-td2"><%=article.getPrixInitial()  %> pts</p></td>
            </tr>  
            <tr>
                <td class="td1"><p class="value-td1">Fin de l'enchère:</p></td>
                <td class="td2"><p class="value-td2"><%=article.getDateFinEnchere() %></p></td>
            </tr>
            <tr>
                <td class="td1"><p class="value-td1">Retrait:</p></td>
                <td class="td2"><p class="value-td2"><%=article.getLieuRetrait().getRue()  %>, <%=article.getLieuRetrait().getCode_postal()%>, <%=article.getLieuRetrait().getVille() %></p></td>
            </tr>
            <tr>
                <td class="td1"><p class="value-td1">Vendeur:</p></td>
                <td class="td2"><p class="value-td2"><%=article.getVendeur().getPseudo() %></p></td>
            </tr> 
        </table>
	<% if(!article.getVendeur().getPseudo().equals(connectedUser.getPseudo())) { %>
		<form action="<%=request.getContextPath()%>/Enchere" method="post">
			<div class="input-field">
				<label for="mPrix">Ma Proposition :</label>
				<input class="input" type="number" name="mPrix" id="mPrix" step="1" max= "10000" required>
			</div>
		    <div>
		        <button class="btn-login" type="submit">Enchérir</button>
		    </div>
	      <input value="<%=article.getNoArticle()%>" type="text" id="idArticle" name="idArticle" style="visibility:hidden;">
		</form>
	<% } else { %>
		<a href ="<%=request.getContextPath()%>/updateVente?idArticle=<%=article.getNoArticle()%>"><button class="btn" type="button"> 
        Modifier
     	 </button>
     	 </a>
     	 <a href ="<%=request.getContextPath()%>/Acceuil"><button class="btn" type="button">
        Annuler
     	 </button>
     	 </a>
	<% } %>
      <a href ="<%=request.getContextPath()%>/Acceuil"><button class="btn" type="button"> <!--change that with index.html file location-->
        Back
      </button>
      </a>
    </div>
  </body>
</html>