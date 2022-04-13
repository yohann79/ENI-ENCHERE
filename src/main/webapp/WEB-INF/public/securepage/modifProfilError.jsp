<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="bo.Utilisateur"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profil</title>
</head>
<style>
<%@include file="/css/profil.css"%>
</style>
     <!-- navigation -->
 	<%@ include file = "../home/navigation.jsp" %>
<body>

 	
	<%
	Utilisateur utilisateur = null;
	if (session.getAttribute("utilisateur") == null) {
	} else {
		utilisateur = (Utilisateur) session.getAttribute("utilisateur");
	}
	%>
		<div align="center">
       <h2>Mon Profil</h2>
       		<p style="display: none">${utilisateur.no_utilisateur}</p>
            <p><span>Pseudo : </span><span><input type="text" name="pseudo"
				placeholder="${utilisateur.pseudo}" /></span></p>
            <p><span>Nom :</span><span><input type="text" name="nom"
				placeholder="${utilisateur.nom}" /></span></p>
            <p><span>Prenom :</span><span><input type="text" name="prenom"
				placeholder="${utilisateur.prenom}" /></span></p>
            <p><span>Email :</span><span><input type="text" name="email"
				placeholder="${utilisateur.email}" /></span></p>
            <p><span>Téléphone :</span><span><input type="text" name="telephone"
				placeholder="${utilisateur.telephone}" /><span></p>
            <p><span>Rue :</span><span><input type="text" name="rue"
				placeholder="${utilisateur.rue}" /><span/></p>
            <p><span>Code Postal :</span><span><input type="text" name="code_postal"
				placeholder="${utilisateur.code_postal}" /><span/></p>
            <p><span>Ville :</span><span><input type="text" name="ville"
				placeholder="${utilisateur.ville}" /></span></p>
            <p><span>Credit :</span><span><input type="text" name="credit"
				placeholder="${utilisateur.credit}" /></span></p>
				<p><span>Credit :</span><span><input type="text" name="mot_de_passe"
				placeholder="${utilisateur.mot_de_passe}" /></span></p>
    </div>
    <form action="<%=request.getContextPath()%>/Accueil">
		<input type="submit" value="retour a l'accueil" />
	</form>
	
	<form action="<%=request.getContextPath()%>/ModifierProfil" method="post">
		<input type="submit" value="modifier le profil" />
	</form>
</body>
</html>