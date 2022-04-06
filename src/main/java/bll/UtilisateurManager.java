package bll;

import bo.Utilisateur;
import dal.DaoFactory;
import dal.UtilisateurDAO;

public class UtilisateurManager {
	private UtilisateurDAO utilisateurDAO ;
	
	public UtilisateurManager() {
		this.utilisateurDAO = DaoFactory.getUtilisateurDAO();
	}

	public Utilisateur seConnecter(String user,String mpd) throws UtilisateurNotFound{
		
		return utilisateurDAO.getUtilisateur(user, mpd);
	}
}
