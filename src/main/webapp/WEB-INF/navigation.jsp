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
              <li><a href="<%=request.getContextPath()%>/Accueil">Enchères  </a></li>
              <li><a href="<%=request.getContextPath()%>/Vendre">Vendre </a></li>
              <li><a href="<%=request.getContextPath()%>/Acheter">Acheter </a></li>
              <li><a href="<%=request.getContextPath()%>/Profil=<%=connectedUser.getPseudo()%>">Mon Profil </a></li>
              <li><a href="<%=request.getContextPath()%>/Deconnextion">Deconnexion  </a></li>
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