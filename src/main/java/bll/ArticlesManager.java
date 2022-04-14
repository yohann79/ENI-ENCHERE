package bll;

import java.sql.SQLException;
import java.util.ArrayList;

import bo.ArticleVendu;
import dal.ArticleVenduDAO;
import dal.DaoFactory;

public class ArticlesManager {
    private ArticleVenduDAO articleVenduDAO;

    public ArticlesManager() {
        this.articleVenduDAO = DaoFactory.getArticleVenduDAO();
    }

    public ArrayList<ArticleVendu> getAllArticles() throws ArticlesNotFound {
        // TODO Auto-generated method stub
        return articleVenduDAO.getAllArticles();
    }

    public Boolean getModifArticle(ArticleVendu article) throws ErrorModifArticle, SQLException {
        return articleVenduDAO.getModifArticle(article);
    }

    public Boolean insertArticle(ArticleVendu article) throws SQLException {
        return articleVenduDAO.insertArticle(article);
    }

    public Boolean supprimerArticle(ArticleVendu article) throws SQLException {
        return articleVenduDAO.supprimerArticle(article);
    }
}
