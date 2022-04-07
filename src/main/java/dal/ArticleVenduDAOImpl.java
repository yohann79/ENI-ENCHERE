package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bll.ArticlesNotFound;
import bll.UtilisateurNotFound;
import bo.ArticleVendu;
import bo.Enchere;
import bo.Utilisateur;

public class ArticleVenduDAOImpl implements ArticleVenduDAO{

	@Override
	public ArrayList<ArticleVendu> getAllArticles() throws ArticlesNotFound{
		ArrayList<ArticleVendu> articles = new ArrayList();
		String req = "SELECT * FROM ENCHERES";
		try (Connection cnn = ConnectionProvider.getConnection();) {
			PreparedStatement stm = cnn.prepareStatement(req);
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				ArticleVendu article = new ArticleVendu();
				article.setNoUtilisateur(rs.getInt("no_article"));
				article.setNomArticle(rs.getString("nom_article"));
				article.setDescription(rs.getString("description"));
				article.setDateDebutEnchere(rs.getDate("date_debut_encheres"));
				article.setDateFinEnchere(rs.getDate("date_fin_encheres"));
				article.setPrixInitial(rs.getInt("prix_initial"));
				article.setPrixvente(rs.getInt("prix_vente"));
				article.setNoUtilisateur(rs.getInt("no_utilisateur"));
				article.setNoCategorie(rs.getInt("no_categorie"));
			} else {
				throw new ArticlesNotFound("aucun article trouvé");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return articles;
	}



}
