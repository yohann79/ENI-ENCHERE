package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bll.UtilisateurNotFound;
import bo.Utilisateur;

public class UtilisateurDAOImpl implements UtilisateurDAO{
	
	@Override
	public Utilisateur getUtilisateur(String user, String mpd) throws UtilisateurNotFound {
		String req = "SELECT * FROM UTILISATEURS where pseudo = ? and mot_de_passe = ?";
		try(Connection cnn =ConnectionProvider.getConnection();) {
			PreparedStatement stm=cnn.prepareStatement(req);
			stm.setString(1, user);
			stm.setString(2, mpd);
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				Utilisateur utilisateur = new Utilisateur();
				utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
			}else {
				throw new UtilisateurNotFound();
			}
		} catch (SQLException e) {
			// TODO remonter erreur
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	
}
