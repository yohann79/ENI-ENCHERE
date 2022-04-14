package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bll.BusinessException;
import bo.Categorie;

public class CategorieDAOImpl implements CategorieDAO {

    private static final String INSERT = "insert into CATEGORIES values (?)";
    private static final String GET_BY_ID = "select * from CATEGORIES where no_categorie=?";
    private static final String GET_ALL = "select * from CATEGORIES";
    private static final String UPDATE = "update CATEGORIES set libelle = ? where no_categorie=?";
    private static final String DELETE = "delete CATEGORIES where no_categorie=?";
    private static final String GET_BY_LIBELLE = "select * from CATEGORIES where libelle=?";

    @Override
    public Categorie insert(Categorie categorie) throws BusinessException {

        if (categorie == null) {
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
            throw businessException;
        }

        try (Connection cnx = ConnectionProvider.getConnection()) {

            PreparedStatement statement = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, categorie.getLibelle());

            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                categorie.setId(rs.getInt(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
            throw businessException;
        }
        return categorie;

    }

    @Override
    public Categorie getById(int id) throws BusinessException {

        Categorie categorie = null;

        try (Connection cnx = ConnectionProvider.getConnection()) {

            PreparedStatement statement = cnx.prepareStatement(GET_BY_ID);
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                categorie = new Categorie();
                categorie.setId(rs.getInt("no_categorie"));
                categorie.setLibelle(rs.getString("libelle"));
            }

        } catch (Exception e) {
            e.printStackTrace();
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.LECTURE_CATEGORIES_ECHEC);
            throw businessException;

        }

        return categorie;
    }

    @Override
    public List<Categorie> getAll() throws BusinessException {

        List<Categorie> categories = new ArrayList<Categorie>();

        try (Connection cnx = ConnectionProvider.getConnection()) {

            PreparedStatement statement = cnx.prepareStatement(GET_ALL);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Categorie categorie = new Categorie();
                categorie.setId(rs.getInt("no_categorie"));
                categorie.setLibelle(rs.getString("libelle"));
                categories.add(categorie);
            }

        } catch (Exception e) {
            e.printStackTrace();
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.LECTURE_CATEGORIES_ECHEC);
            throw businessException;

        }
        return categories;
    }

    @Override
    public void update(Categorie categorie) throws BusinessException {

        try (Connection cnx = ConnectionProvider.getConnection()) {

            PreparedStatement statement = cnx.prepareStatement(UPDATE);

            statement.setString(1, categorie.getLibelle());
            statement.setInt(2, categorie.getId());

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.UPDATE_OBJET_ECHEC);
            throw businessException;

        }

    }

    @Override
    public void delete(int id) throws BusinessException {
        try (Connection cnx = ConnectionProvider.getConnection()) {

            PreparedStatement statement = cnx.prepareStatement(DELETE);

            statement.setInt(1, id);

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.DELETE_OBJET_ECHEC);
            throw businessException;

        }

    }

}
