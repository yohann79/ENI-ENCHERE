package dal;

import java.sql.SQLException;
import java.util.List;

import bo.Enchere;

public class EnchereDAOImpl implements EnchereDAO {

    @Override
    public Enchere insert(Enchere enchere) throws SQLException {
        return enchere;
    }

    @Override
    public List<Enchere> getAll() throws SQLException {
        return null;

    }

    @Override
    public Enchere getById(int id) throws SQLException {
        return null;

    }

    @Override
    public List<Enchere> getByEncherisseur(int id) throws SQLException {
        return null;

    }

    @Override
    public List<Enchere> getRemportesParEncherisseur(int id) throws SQLException {
        return null;

    }

    @Override
    public void update(Enchere enchere) throws SQLException {
    }

    @Override
    public void delete(int id) throws SQLException {
    }

    @Override
    public List<Enchere> getAllByArticle(int id) throws SQLException {
        return null;

    }

}