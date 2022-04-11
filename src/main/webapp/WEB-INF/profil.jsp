<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="bll.UtilisateurManager"%>
<%@ page import="bo.Utilisateur"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profil</title>
</head>
<body>
     <!-- navigation -->
 	<%@ include file = "navigation.jsp" %>
 	
      
	Utilisateur utilisateur = null;
	if (session.getAttribute("utilisateur") == null) {
	} else {
		utilisateur = (Utilisateur) session.getAttribute("utilisateur");
	}
	%>
	<div align="center">
       <h2>Mon Profil</h2>
        <article>
            <p><span>Pseudo : </span><span> ${utilisateur.pseudo}</span></p>
            <p><span>Nom :</span><span>${utilisateur.nom}</span></p>
            <p><span>Prenom :</span><span>${utilisateur.prenom}</span></p>
            <p><span>Email :</span><span>${utilisateur.email}</span></p>
            <p><span>Téléphone :</span><span>${utilisateur.telephone}<span></p>
            <p><span>Rue :</span><span>${utilisateur.rue}<span/></p>
            <p><span>Code Postal :</span><span>${utilisateur.code_postal}<span/></p>
            <p><span>Ville :</span><span>${utilisateur.ville}</span></p>
            <p><span>Credit :</span><span>${utilisateur.credit}</span></p>
    </div>
	<form action="<%=request.getContextPath()%>/Accueil">
		<input type="submit" value="retour a l'accueil" />
	</form>
		<form action="<%=request.getContextPath()%>/ModifierProfil">
		<input type="submit" value="modifier le profil" />
	</form>
</body>
</html>