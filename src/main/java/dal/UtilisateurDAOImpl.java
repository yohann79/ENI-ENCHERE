package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bll.UtilisateurNotFound;
import bo.Utilisateur;

public class UtilisateurDAOImpl implements UtilisateurDAO {

	@Override
	public Utilisateur getUtilisateur(String user, String mpd) throws UtilisateurNotFound {
		String req = "SELECT * FROM UTILISATEURS where pseudo = ? and mot_de_passe = ?";
		try (Connection cnn = ConnectionProvider.getConnection();) {
			PreparedStatement stm = cnn.prepareStatement(req);
			stm.setString(1, user);
			stm.setString(2, mpd);
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				Utilisateur utilisateur = new Utilisateur();
				utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setTelephone(rs.getString("telephone"));
				utilisateur.setRue(rs.getString("rue"));
				utilisateur.setCode_postal(rs.getString("code_postal"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setMot_de_passe(rs.getString("mot_de_passe"));
				utilisateur.setCredit(rs.getInt("credit"));
				utilisateur.setAdministrateur(rs.getBoolean("administrateur"));
				cnn.close();
				return utilisateur;

			} else {
				throw new UtilisateurNotFound("utilisateur :"+user+"non trouvé, ou mots de passe incorect");
			}

		} catch (SQLException e) {
			// TODO remonter erreur
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean getModif(Utilisateur utilisateur) throws UtilisateurNotFound {
		String req = "update UTILISATEUR SET ? = ? no_utilisateur = ?";
		
		try (Connection cnn = ConnectionProvider.getConnection(); ){
			PreparedStatement stm = cnn.prepareStatement(req);
		} catch (SQLException e) {
			// TODO remonter erreur
		e.printStackTrace();
		}
		return null;
	}


}
