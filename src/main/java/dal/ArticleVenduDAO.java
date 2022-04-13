package dal;

import java.sql.SQLException;
import java.util.ArrayList;

import bll.ArticlesNotFound;
import bll.ErrorModifArticle;
import bo.ArticleVendu;

public interface ArticleVenduDAO {
    public ArrayList<ArticleVendu> getAllArticles() throws ArticlesNotFound;

    public Boolean insertArticle(ArticleVendu article) throws SQLException;

    public Boolean supprimerArticle(ArticleVendu article) throws SQLException;

    public Boolean getModifArticle(ArticleVendu article) throws ErrorModifArticle, SQLException;
}