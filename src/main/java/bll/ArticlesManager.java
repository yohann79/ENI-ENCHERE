package bll;

import java.sql.SQLException;
import java.util.ArrayList;

import bo.ArticleVendu;
import dal.ArticleVenduDAO;
import dal.DaoFactory;

public class ArticlesManager {
    private ArticleVenduDAO enchereDAO;

    public ArticlesManager() {
        this.enchereDAO = DaoFactory.getEnchereDAO();
    }

    public ArrayList<ArticleVendu> getAllArticles() throws ArticlesNotFound {
        // TODO Auto-generated method stub
        return enchereDAO.getAllArticles();
    }

    public Boolean getModifArticle(ArticleVendu article) throws ErrorModifArticle, SQLException {
        return enchereDAO.getModifArticle(article);
    }

    public Boolean insertArticle(ArticleVendu article) throws SQLException {
        return enchereDAO.insertArticle(article);
    }

    public Boolean supprimerArticle(ArticleVendu article) throws SQLException {
        return enchereDAO.supprimerArticle(article);
    }
}
