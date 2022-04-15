<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.Out"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="bo.ArticleVendu"%>
<%@ page import="bo.Utilisateur"%>
<%@ page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.Locale"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="bll.ArticlesManager"%>
<%@page import="bll.CategorieManager"%>
<%@page import="bo.Categorie"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des Enchères</title>
</head>
<style>
<%@include file="/css/style.css"%>
</style>
 <!-- navigation -->
 	<%@ include file = "../home/navigation.jsp" %>
 	
<body>

<div class="search-bar">
        
       
       <input type="hidden" name="select_extra" value="1">
					<select name="categorie" id=1>
							<option value="">Catégorie</option>
        					<option value=2>Informatique</option>
        					<option value=3>Véhicule</option>
        					<option value=4>Meuble</option>
        					<option value=5>Sport</option>
        					<option value=6>Mode</option>
        					<option value=7>Gaming</option>
        					<option value=8>Enfant</option>
        					<option value=9>Cosmétique</option>
    				</select><br>
        
        <div class="search-box">
            <input type="text" class="search" placeholder="Mots Clées">
        </div>

        <button type="submit" class="search-btn"> <img src="img/search.png"/>
            <i class="fas fa-search"></i>
        </button>
    </div>
    
    <div class="recherche-achats">


            <div>
                    <input type="radio" id="huey" name="drone" value="huey"
                        checked>
                    <label for="huey">Achats</label>
            
                <ul>
                    <li>
                        <input name="Ssdm" id="Ssdm" type="checkbox">
                        <label class="ssdm" for="Ssdm">Enchères ouvertes</label>
                    </li>

                    <li>
                        <input name="Ssdm" id="Ssdm" type="checkbox">
                        <label class="ssdm" for="Ssdm">Mes enchères en cours</label>
                    </li>
                    
                    <li>
                        <input name="Ssdm" id="Ssdm" type="checkbox">
                        <label class="ssdm" for="Ssdm">Mes enchères remportées</label>
                    </li>
                </ul>
            </div>

	</div>
            <div class="recherche-mes-vente">
                <input type="radio" id="huey" name="drone" value="huey">
                <label for="huey">Mes Ventes</label>
            

            <ul>
                <li>
                    <input name="Ssdm" id="Ssdm" type="checkbox">
                    <label class="ssdm" for="Ssdm">Mes ventes en cours</label>
                </li>
                
                <li>
                    <input name="Ssdm" id="Ssdm" type="checkbox">
                    <label class="ssdm" for="Ssdm">Ventes non débutés</label>
                </li>

                <li>
                    <input name="Ssdm" id="Ssdm" type="checkbox">
                    <label class="ssdm" for="Ssdm">Ventes terminées</label>
                </li>
            </ul>

            </div>  

        
</body>
</html>