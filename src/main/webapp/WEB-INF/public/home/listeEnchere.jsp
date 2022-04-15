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
                    <input class="rd" type="radio" id="achat" name="achats-vente" value="achat"
                        checked>
                    <label class="rdlb"for="achat">Achats</label>
            
                <ul>
                    <li>
                        <input class="ck"  class="" name="ckachat" id="ouverte" type="checkbox">
                        <label class="cklb" for="ouverte">Enchères ouvertes</label>
                    </li>

                    <li>
                        <input  class="ck" name="ckachat" id="encours" type="checkbox">
                        <label class="cklb" for="encours">Mes enchères en cours</label>
                    </li>
                    
                    <li>
                        <input class="ck"  name="ckachat" id="remporte" type="checkbox">
                        <label class="cklb" for="remporte">Mes enchères remportées</label>
                    </li>
                </ul>
            </div>

	</div>
            <div class="recherche-mes-ventes">
                <input class= "rd" type="radio" id="vente" name="achats-vente" value="vente">
                <label class= "rdlb" for="vente">Mes Ventes</label>
            

            <ul>
                <li>
                    <input class="ck"  name="ckvente" id="encours" type="checkbox">
                    <label class="cklb" for="encours">Mes ventes en cours</label>
                </li>
                
                <li>
                    <input class="ck"  name="ckvente" id="debut" type="checkbox">
                    <label class="cklb" for="debut">Ventes non débutés</label>
                </li>

                <li>
                    <input class="ck"  name="ckvente" id="termine" type="checkbox">
                    <label class="cklb" for="termine">Ventes terminées</label>
                </li>
            </ul>

            </div>  

        
</body>
</html>