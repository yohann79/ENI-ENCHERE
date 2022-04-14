package dal;

import java.sql.SQLException;

import bll.BusinessException;
import bll.ErrorInsertUtilisateur;
import bll.ErrorModifParameters;
import bll.UtilisateurNotFound;
import bo.Utilisateur;

public interface UtilisateurDAO {
    public Utilisateur getUtilisateur(String user, String mpd) throws UtilisateurNotFound;

    public Boolean getModif(Utilisateur utilisateur) throws ErrorModifParameters;

    public Boolean insertUtilisateur(Utilisateur utilisateur) throws ErrorInsertUtilisateur, SQLException;

    public Boolean supprimerUtilisateur(Utilisateur utilisateur) throws SQLException;

    public Utilisateur getById(int id) throws BusinessException;
}
