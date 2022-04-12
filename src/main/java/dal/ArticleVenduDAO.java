package dal;

import java.sql.SQLException;
import java.util.ArrayList;

import bll.ArticlesNotFound;
import bll.ErrorModifArticle;
import bo.ArticleVendu;

public interface ArticleVenduDAO {
    public ArrayList<ArticleVendu> getAllArticles() throws ArticlesNotFound;

    public static Boolean insertArticle(ArticleVendu article) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    public static Boolean supprimerArticle(ArticleVendu article) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    public static Boolean getModifArticle(ArticleVendu article) throws ErrorModifArticle, SQLException {
        // TODO Auto-generated method stub
        return null;
    }
}