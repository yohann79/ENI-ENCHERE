package bll;

import java.util.ArrayList;

import bo.ArticleVendu;
import dal.ArticleVenduDAO;
import dal.DaoFactory;

public class ArticlesManager {
	private ArticleVenduDAO enchereDAO ;
	
	public ArticlesManager() {
		this.enchereDAO = DaoFactory.getEnchereDAO();
	}

	public ArrayList<ArticleVendu> getAllArticles() throws ArticlesNotFound {
		// TODO Auto-generated method stub
		return enchereDAO.getAllArticles();
	}

}
