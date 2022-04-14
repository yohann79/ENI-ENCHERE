package bll;

import java.sql.SQLException;
import java.util.List;

import bo.Enchere;
import dal.EnchereDAO;
import dal.EnchereDAOImpl;

public class EnchereManager {

    private static EnchereDAO enchereDAO = new EnchereDAOImpl();

    public EnchereManager() {

    }

    public static Enchere ajoutEnchere(Enchere enchere) throws SQLException {
        return enchereDAO.insert(enchere);
    }

    public static Enchere selectionnerEnchereById(int id) throws SQLException {
        return enchereDAO.getById(id);
    }

    public static List<Enchere> selectionnerToutesLesEncheres() throws SQLException {
        return enchereDAO.getAll();
    }

    public static List<Enchere> selectionnerEncheresParArticle(int id) throws SQLException {
        return enchereDAO.getAllByArticle(id);
    }
}