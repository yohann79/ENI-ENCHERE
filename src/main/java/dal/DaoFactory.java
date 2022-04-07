package dal;

public class DaoFactory {

	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOImpl();
	}

	public static ArticleVenduDAO getEnchereDAO() {
		// TODO Auto-generated method stub
		return new ArticleVenduDAOImpl();
	}

}
