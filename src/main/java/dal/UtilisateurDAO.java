package dal;

import bll.UtilisateurNotFound;
import bo.Utilisateur;

public interface UtilisateurDAO {
	public Utilisateur getUtilisateur(String user,String mpd) throws UtilisateurNotFound;
}
