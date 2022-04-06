<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 <%@ page import="bo.Utilisateur" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil</title>
</head>
<body>
  <% Utilisateur utilisateur =null;
    if (session.getAttribute("utilisateur") == null) {
    } else {
        utilisateur = (Utilisateur) session.getAttribute("utilisateur");
    }%>
 <div align="center">
  <h1>Bonjour ${utilisateur.pseudo}</h1>
 </div>
 <form action="<%=request.getContextPath()%>/Profil"><input type="submit" value="Profil" /></form>
</body>
</html>