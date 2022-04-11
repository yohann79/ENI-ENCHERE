<!-- Connected page  -->
<!-- commit -->
 	<%@page import="bo.Utilisateur"%>
<style>
<%@include file="../../css/navbar.css"%>
</style>
<% if( session.getAttribute("utilisateur") != null){ %>
 		<!--navigation-->
 
    <nav class="navbar">
      
      <a href="#" class="toggle-sbutton">
          <span class="bar"></span>
          <span class="bar"></span>
          <span class="bar"></span>
      </a>
     
      <div class="navbar-links">
      <%Utilisateur connectedUser = (Utilisateur) session.getAttribute("utilisateur"); %>
          <ul id="nav">
              <li><a href="<%=request.getContextPath()%>/Accueil">Accueil  </a></li>
              <li><a href="<%=request.getContextPath()%>/Vendre">Vendre </a></li>
              <li><a href="<%=request.getContextPath()%>/Profil">Mon Profil </a></li>
              <li><a href="<%=request.getContextPath()%>/Deconnexion">Deconnexion  </a></li>
          </ul>
      </div>
    </nav>
 
 	<% } else {  %>

   
<!-- Deconnected page -->

 <!--navigation-->
 
 <nav class="navbar">
        
        <a href="#" class="toggle-button">
            <span class="bar"></span>
            <span class="bar"></span>
            <span class="bar"></span>
        </a>
        <div class="navbar-links">
           <ul id="nav">
                <li><a href="<%=request.getContextPath()%>/Inscription"> Créer Un Compte </a></li>
                 <li><a href="<%=request.getContextPath()%>/Connexion"> Se Connecter  </a></li>
            </ul>
        </div>
    </nav>
    <% } %>
    
       <!--Banner-->
    <div class="header">
    </div>