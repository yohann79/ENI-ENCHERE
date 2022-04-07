package dal;

import java.util.ArrayList;

import bll.ArticlesNotFound;
import bo.ArticleVendu;
import bo.Enchere;

public interface ArticleVenduDAO {
	public ArrayList<ArticleVendu> getAllArticles() throws ArticlesNotFound;

}
