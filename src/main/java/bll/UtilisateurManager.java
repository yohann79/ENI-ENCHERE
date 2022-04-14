package bll;

import java.sql.SQLException;

import bo.Utilisateur;
import dal.DaoFactory;
import dal.UtilisateurDAO;

public class UtilisateurManager {
    private static UtilisateurDAO utilisateurDAO;

    public UtilisateurManager() {
        this.utilisateurDAO = DaoFactory.getUtilisateurDAO();
    }

    public Utilisateur seConnecter(String user, String mpd) throws UtilisateurNotFound {

        return utilisateurDAO.getUtilisateur(user, mpd);
    }

    public Utilisateur selectUserById(int id) throws BusinessException {
        return utilisateurDAO.getById(id);

    }

    public static Boolean modifierUtilisateur(Utilisateur utilisateur) throws ErrorModifParameters {
        return utilisateurDAO.getModif(utilisateur);
    }

    public Boolean insertUtilisateur(Utilisateur utilisateur) throws ErrorInsertUtilisateur, SQLException {
        return utilisateurDAO.insertUtilisateur(utilisateur);
    }

    public Boolean supprUtilisateur(Utilisateur utilisateur) throws SQLException {
        return utilisateurDAO.supprimerUtilisateur(utilisateur);
    }

}
