package dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bll.ArticlesNotFound;
import bll.ErrorModifArticle;
import bo.ArticleVendu;

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

    public Boolean insertArticle(ArticleVendu article) throws SQLException {
        String req = "insert into ARTICLES_VENDUS values (?,?,?,?,?,?,?,?,?)";

        try (Connection cnn = ConnectionProvider.getConnection();) {
            PreparedStatement stm = cnn.prepareStatement(req);
            stm.setString(1, article.getNomArticle());
            stm.setString(2, article.getDescription());
            stm.setDate(3, new Date(article.getDateDebutEnchere().getTime()));
            stm.setDate(4, new Date(article.getDateFinEnchere().getTime()));
            stm.setInt(5, article.getPrixInitial());
            stm.setInt(7, article.getNoUtilisateur());
            stm.setInt(7, article.getNoCategorie());
            stm.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new SQLException("erreur insertion en base \"" + e.getMessage());
        }

    }

    public Boolean getModifArticle(ArticleVendu article) throws ErrorModifArticle, SQLException {
        // TODO Auto-generated method stub
        String req = "update ARTICLES_VENDUS SET ? = ? no_article = ?";

        try (Connection cnn = ConnectionProvider.getConnection();) {
            PreparedStatement stm = cnn.prepareStatement(req);
        } catch (SQLException e) {
            throw new ErrorModifArticle("champ nom valide");
        }
        return null;
    }

    public Boolean supprimerArticle(ArticleVendu article) throws SQLException {
        try (Connection cnn = ConnectionProvider.getConnection();) {
            System.out.println(article.getNomArticle() + article.getNoArticle());
            String req = "delete from ARTICLES_VENDUS where no_article = ?";
            PreparedStatement stm = cnn.prepareStatement(req);
            stm.setInt(1, article.getNoArticle());
            stm.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new SQLException("erreur suppression en base \"" + e.getMessage());
        }

    }
}
