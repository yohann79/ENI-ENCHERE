package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bll.BusinessException;
import bll.ErrorInsertUtilisateur;
import bll.ErrorModifParameters;
import bll.UtilisateurNotFound;
import bo.Utilisateur;

public class UtilisateurDAOImpl implements UtilisateurDAO {

    private Boolean getUtilisateurByPseudoAndEmail(String pseudo, String email) {
        String req = "SELECT * FROM UTILISATEURS where pseudo = ? and email = ?";
        try (Connection cnn = ConnectionProvider.getConnection();) {
            PreparedStatement stm = cnn.prepareStatement(req);
            stm.setString(1, pseudo);
            stm.setString(2, email);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

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
                utilisateur.setNo_utilisateur(rs.getInt("no_utilisateur"));
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
                return utilisateur;

            } else {
                throw new UtilisateurNotFound("utilisateur : " + user + " non trouvé, ou mots de passe incorect");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Utilisateur getById(int id) throws BusinessException {
        String req = "SELECT * FROM UTILISATEURS WHERE no_utilisateur=?";
        Utilisateur utilisateur = null;

        try (Connection cnx = ConnectionProvider.getConnection()) {

            PreparedStatement stm = cnx.prepareStatement(req);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.LECTURE_UTILISATEURS_ECHEC);
            throw businessException;

        }

        return utilisateur;
    }

    @Override
    public Boolean getModif(Utilisateur utilisateur) throws ErrorModifParameters {
        String req = "update UTILISATEURS SET pseudo = ?, nom = ?,prenom=?,email=?,telephone=?,rue=?,code_postal=?,ville=?,mot_de_passe=? where no_utilisateur = ?";
        String reqVerif = "select pseudo,email from UTILISATEURS where pseudo =? and email=?";

        try (Connection cnn = ConnectionProvider.getConnection();) {
            PreparedStatement stmVerif = cnn.prepareStatement(reqVerif);
            stmVerif.setString(1, utilisateur.getPseudo());
            stmVerif.setString(2, utilisateur.getEmail());
            ResultSet rs = stmVerif.executeQuery();
            System.out.println(rs.next());
            if (!rs.next()) {
                PreparedStatement stm = cnn.prepareStatement(req);
                stm.setString(1, utilisateur.getPseudo());
                stm.setString(2, utilisateur.getNom());
                stm.setString(3, utilisateur.getPrenom());
                stm.setString(4, utilisateur.getEmail());
                stm.setString(5, utilisateur.getTelephone());
                stm.setString(6, utilisateur.getRue());
                stm.setString(7, utilisateur.getCode_postal());
                stm.setString(8, utilisateur.getVille());
                stm.setString(9, utilisateur.getMot_de_passe());
                stm.setInt(10, utilisateur.getNo_utilisateur());
                System.out.println(utilisateur.getNo_utilisateur());
                stm.executeUpdate();
                return true;
            } else {
                System.out.println("error");
                throw new ErrorModifParameters("pseudo ou email deja existant");
            }

        } catch (SQLException e) {
            System.out.println("catch1" + e.getMessage());
            throw new ErrorModifParameters("champ nom valide" + e.getMessage());
        }

    }

    @Override
    public Boolean insertUtilisateur(Utilisateur utilisateur) throws ErrorInsertUtilisateur, SQLException {
        String req = "insert into UTILISATEURS values (?,?,?,?,?,?,?,?,?,?,?)";

        Boolean UtilisateurExistEnBase = this.getUtilisateurByPseudoAndEmail(utilisateur.getPseudo(),
                utilisateur.getEmail());
        if (UtilisateurExistEnBase == false) {

            try (Connection cnn = ConnectionProvider.getConnection();) {
                PreparedStatement stm = cnn.prepareStatement(req);
                stm.setString(1, utilisateur.getPseudo());
                stm.setString(2, utilisateur.getNom());
                stm.setString(3, utilisateur.getPrenom());
                stm.setString(4, utilisateur.getEmail());
                stm.setString(5, utilisateur.getTelephone());
                stm.setString(6, utilisateur.getRue());
                stm.setString(7, utilisateur.getCode_postal());
                stm.setString(8, utilisateur.getVille());
                stm.setString(9, utilisateur.getMot_de_passe());
                stm.setInt(10, 100);
                stm.setInt(11, 0);
                stm.executeUpdate();
                return true;
            } catch (SQLException e) {
                throw new SQLException("erreur insertion en base \"" + e.getMessage());
            }
        } else {
            throw new ErrorInsertUtilisateur("Pseudo ou email deja pris");
        }

    }

    @Override
    public Boolean supprimerUtilisateur(Utilisateur utilisateur) throws SQLException {
        try (Connection cnn = ConnectionProvider.getConnection();) {
            System.out.println(utilisateur.getNom() + utilisateur.getNo_utilisateur());
            String req = "delete from UTILISATEURS where no_utilisateur = ?";
            PreparedStatement stm = cnn.prepareStatement(req);
            stm.setInt(1, utilisateur.getNo_utilisateur());
            stm.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new SQLException("erreur suppression en base \"" + e.getMessage());
        }

    }
}
