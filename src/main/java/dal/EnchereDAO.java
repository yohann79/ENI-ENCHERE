package dal;

import java.sql.SQLException;
import java.util.List;

import bo.Enchere;

public interface EnchereDAO {

    public Enchere insert(Enchere enchere) throws SQLException;

    public List<Enchere> getAll() throws SQLException;

    public Enchere getById(int id) throws SQLException;

    public List<Enchere> getByEncherisseur(int id) throws SQLException;

    public List<Enchere> getRemportesParEncherisseur(int id) throws SQLException;

    public void update(Enchere enchere) throws SQLException;

    public void delete(int id) throws SQLException;

    public List<Enchere> getAllByArticle(int id) throws SQLException;
}