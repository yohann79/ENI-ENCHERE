package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import bll.UtilisateurNotFound;
import bo.Utilisateur;
import dal.UtilisateurDAOImpl;

public class UtilisateurDAOImplTest {
	
	 @Test
	public void getUtilisateurTest() throws UtilisateurNotFound, SQLException {
		UtilisateurDAOImpl utilisateurDaoImple = new UtilisateurDAOImpl();
		String pseudoTrue = "yohann";
		String mpdTrue = "test";
		Utilisateur utilisateur = utilisateurDaoImple.getUtilisateur(pseudoTrue, mpdTrue);
		assertEquals(pseudoTrue,utilisateur.getPseudo());
		assertEquals(mpdTrue,utilisateur.getMot_de_passe());
	}
}
