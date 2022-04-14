<!-- Connected page  -->
<!-- commit -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 	<%@page import="bo.Utilisateur"%>
<style>
<%@include file="/css/navbar.css"%>
</style>
<% if( session.getAttribute("utilisateur") != null){ %>
 		<!--navigation-->
 
   <nav class="navbar">
        <span class="toggle-nav" id="toggle-nav">
            <i class="material-icons">menu</i>
        </span>
        <!-- <div class=""> -->
       <a href="<%=request.getContextPath()%>/ListeEnchere" class="logo"><img src="/ressources/img/logoenchere.png" alt=""></a>
      
      <a href="#" class="toggle-sbutton">
          <span class="bar"></span>
          <span class="bar"></span>
          <span class="bar"></span>
      </a>

     
      <div class="navbar-links">
      <%Utilisateur connectedUser = (Utilisateur) session.getAttribute("utilisateur"); %>
          <ul id="nav">
            <li class="links"><a href="<%=request.getContextPath()%>/Deconnexion">Deconnexion </a></li>
             <li class="links"><a href="<%=request.getContextPath()%>/Profil">Profil </a></li>
              <li class="links"><a href="<%=request.getContextPath()%>/Vendre">Vendre </a></li>
              <li class="links"><a href="<%=request.getContextPath()%>/Accueil">Accueil </a></li>
             
            
          </ul>
      </div>
    </nav>
 
 	<% } else {  %>

   
<!-- Deconnected page -->

 <!--navigation-->
 
<nav class="navbar">
        <span class="toggle-nav" id="toggle-nav">
            <i class="material-icons">menu</i>
        </span>
        <!-- <div class=""> -->
        <a href="<%=request.getContextPath()%>/ListeEnchere" class="logo"><img src="/img/logoenchere.png" alt=""></a>
        
        <a href="#" class="toggle-button">
            <span class="bar"></span>
            <span class="bar"></span>
            <span class="bar"></span>
        </a>
         <div class="navbar-links">
      <%Utilisateur connectedUser = (Utilisateur) session.getAttribute("utilisateur"); %>
          <ul id="nav">
            <li class="links"><a href="<%=request.getContextPath()%>/Connexion">Connexion </a></li>
             <li class="links"><a href="<%=request.getContextPath()%>/Profil">Profil </a></li>
              <li class="links"><a href="<%=request.getContextPath()%>/Vendre">Vendre </a></li>
              <li class="links"><a href="<%=request.getContextPath()%>/Accueil">Accueil </a></li>
             
            
          </ul>
      </div>
    </nav>
    <% } %>
    
       <!--Banner-->
    <div class="header">
    </div>
