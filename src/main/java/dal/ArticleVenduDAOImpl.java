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

public class ArticleVenduDAOImpl implements ArticleVenduDAO {

	@Override
	public ArrayList<ArticleVendu> getAllArticles() throws ArticlesNotFound {
		ArrayList<ArticleVendu> articles = new ArrayList();
		String req = "SELECT * FROM ARTICLES_VENDUS";
		String reqTaille = "SELECT COUNT(*) FROM ARTICLES_VENDUS";
		try (Connection cnn = ConnectionProvider.getConnection();) {
			PreparedStatement stm = cnn.prepareStatement(req);
			
			ResultSet rs = stm.executeQuery();
			PreparedStatement stmTaille = cnn.prepareStatement(reqTaille);
			ResultSet rsTaille = stmTaille.executeQuery();
			if (rs.next()) {
				rsTaille.next();
				int taille = rsTaille.getInt(1);
				for (int i = 1; i <= taille; i++) {
					ArticleVendu article = new ArticleVendu();
					article.setNoArticle(rs.getInt("no_article"));
					article.setNomArticle(rs.getString("nom_article"));
					article.setDescription(rs.getString("description"));
					article.setDateDebutEnchere(rs.getDate("date_debut_encheres"));
					article.setDateFinEnchere(rs.getDate("date_fin_encheres"));
					article.setPrixInitial(rs.getInt("prix_initial"));
					article.setPrixvente(rs.getInt("prix_vente"));
					article.setNoUtilisateur(rs.getInt("no_utilisateur"));
					article.setNoCategorie(rs.getInt("no_categorie"));
					articles.add(article);
					rs.next();
				}
				return articles;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new ArticlesNotFound("Aucun article trouvé en base");
	}

}
