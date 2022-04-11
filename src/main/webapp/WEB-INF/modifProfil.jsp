<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="bo.Utilisateur"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil</title>
</head>
<style>
<%@include file="../../css/profil.css"%>
</style>
<body>
     <!-- navigation -->
 	<%@ include file = "navigation.jsp" %>
 	
	<%
	Utilisateur utilisateur = null;
	if (session.getAttribute("utilisateur") == null) {
	} else {
		utilisateur = (Utilisateur) session.getAttribute("utilisateur");
	}
	%>
		<div align="center" id="container">
       <h2>Mon Profil</h2>

		<ul id="profil_list")>
			<p style="display: none">${utilisateur.no_utilisateur}</p>

			<li>Pseudo :</li>
			<li>Nom :</li>
			<li>Prenom :</li>
			<li>Email :</li>
			<li>Téléphone :</li>
			<li>Rue :</li>
			<li>Code Postal :</li>
			<li>Ville :</li>
			<li>Credit :</li>
			<li>Mots de passe :</li>


			<li><input type="text" name="pseudo"
				placeholder="${utilisateur.pseudo}" /></li>
			<li><input type="text" name="nom"
				placeholder="${utilisateur.nom}" /></li>
			<li><input type="text" name="prenom"
				placeholder="${utilisateur.prenom}" /></li>
			<li><input type="text" name="email"
				placeholder="${utilisateur.email}" /></li>
			<li><input type="text" name="telephone"
				placeholder="${utilisateur.telephone}"/><li>
			<li><input type="text" name="rue"
				placeholder="${utilisateur.rue}" /><li />
			<li><input type="text" name="code_postal"
				placeholder="${utilisateur.code_postal}" /><li />
			<li><input type="text" name="ville"
				placeholder="${utilisateur.ville}" /></li>
			<li><input type="text" name="credit"
				placeholder="${utilisateur.credit}" /></li>
			<li><input type="password" name="mot_de_passe"
				placeholder="${utilisateur.mot_de_passe}" /></li>

		</ul>
	
    <form action="<%=request.getContextPath()%>/Accueil">
		<input type="submit" value="retour a l'accueil" />
	</form>
	
	<form action="<%=request.getContextPath()%>/ModifierProfil" method="post">
		<input type="submit" value="confirmer modification" />
	</form>
	</div>
</body>
</html>