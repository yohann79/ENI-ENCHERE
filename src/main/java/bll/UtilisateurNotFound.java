package bll;

public class UtilisateurNotFound extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UtilisateurNotFound(String utilisateurNotFound) {
		super(utilisateurNotFound);
	}
}
