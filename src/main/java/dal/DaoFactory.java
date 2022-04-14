package dal;

public class DaoFactory {

    public static UtilisateurDAO getUtilisateurDAO() {
        return new UtilisateurDAOImpl();
    }

    public static ArticleVenduDAO getArticleVenduDAO() {
        // TODO Auto-generated method stub
        return new ArticleVenduDAOImpl();
    }

    public static EnchereDAO getEnchereDAO() {
        // TODO Auto-generated method stub
        return new EnchereDAOImpl();
    }

}
