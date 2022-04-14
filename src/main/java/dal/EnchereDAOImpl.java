package dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bll.BusinessException;
import bo.Enchere;

public class EnchereDAOImpl implements EnchereDAO {
    private static final String INSERT = "INSERT INTO ENCHERES (date_enchere, montant_enchere, no_article, no_utilisateur, remporte) VALUES(?,?,?,?,?)";
    private static final String GET_ALL = "SELECT * FROM ENCHERES";
    private static final String GET_BY_ID = "SELECT * FROM ENCHERES WHERE no_enchere=?";
    private static final String GET_BY_ENCHERISSEUR = "SELECT * FROM ENCHERES WHERE no_utilisateur=?";
    private static final String GET_REMPORTES_PAR_ENCHERISSEUR = "SELECT * FROM ENCHERES WHERE no_utilisateur=? AND remporte=?";
    private static final String UPDATE = "UPDATE ENCHERES SET date_enchere=?, montant_enchere=?,"
            + "no_article=?, no_utilisateur=?, remporte=? WHERE no_enchere=?";
    private static final String DELETE = "DELETE ENCHERES WHERE no_enchere=?";
    private static final String GET_ALL_BY_ARTICLE = "SELECT * FROM ENCHERES WHERE no_article=?";

    private static ArticleVenduDAO articleDao = new ArticleVenduDAOImpl();
    private static UtilisateurDAO utilisateurDAO = new UtilisateurDAOImpl();

    @Override
    public Enchere insert(Enchere enchere) throws BusinessException {

        if (enchere == null) {
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
            throw businessException;
        }

        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement statement = cnx.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setDate(1, Date.valueOf(enchere.getDate()));
            statement.setInt(2, enchere.getMontant());
            statement.setInt(3, enchere.getArticle().getNoArticle());
            statement.setInt(4, enchere.getEncherisseur().getNo_utilisateur());
            statement.setBoolean(5, enchere.isRemporte());

            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                enchere.setId(rs.getInt(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
            throw businessException;
        }
        return enchere;
    }

    @Override
    public List<Enchere> getAll() throws BusinessException {

        List<Enchere> list = new ArrayList<>();

        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement statement = cnx.prepareStatement(GET_ALL);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Enchere enchere = new Enchere();
                enchere.setId(rs.getInt("no_enchere"));
                enchere.setDate(rs.getDate("date_enchere").toLocalDate());
                enchere.setMontant(rs.getInt("montant_enchere"));
                enchere.setArticle(articleDao.getById(rs.getInt("no_article")));
                enchere.setEncherisseur(utilisateurDAO.getById(rs.getInt("no_utilisateur")));
                enchere.setRemporte(rs.getBoolean("remporte"));

                list.add(enchere);
            }

        } catch (Exception e) {
            e.printStackTrace();
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.LECTURE_ENCHERES_ECHEC);
            throw businessException;

        }
        return list;
    }

    @Override
    public Enchere getById(int id) throws BusinessException {

        Enchere enchere = null;

        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement statement = cnx.prepareStatement(GET_BY_ID);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                enchere = new Enchere();
                enchere.setId(rs.getInt("no_enchere"));
                enchere.setDate(rs.getDate("date_enchere").toLocalDate());
                enchere.setMontant(rs.getInt("montant_enchere"));
                enchere.setArticle(articleDao.getById(rs.getInt("no_article")));
                enchere.setEncherisseur(utilisateurDAO.getById(rs.getInt("no_utilisateur")));
                enchere.setRemporte(rs.getBoolean("remporte"));

            }

        } catch (Exception e) {
            e.printStackTrace();
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.LECTURE_ENCHERES_ECHEC);
            throw businessException;

        }

        return enchere;
    }

    @Override
    public List<Enchere> getByEncherisseur(int id) throws BusinessException {

        List<Enchere> list = new ArrayList<>();

        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement statement = cnx.prepareStatement(GET_BY_ENCHERISSEUR);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Enchere enchere = new Enchere();
                enchere.setId(rs.getInt("no_enchere"));
                enchere.setDate(rs.getDate("date_enchere").toLocalDate());
                enchere.setMontant(rs.getInt("montant_enchere"));
                enchere.setArticle(articleDao.getById(rs.getInt("no_article")));
                // enchere.setEncherisseur(utilisateurDAO.getById(rs.getInt("no_utilisateur")));
                enchere.setRemporte(rs.getBoolean("remporte"));

                list.add(enchere);
            }

        } catch (Exception e) {
            e.printStackTrace();
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.LECTURE_ENCHERES_ECHEC);
            throw businessException;

        }
        return list;
    }

    @Override
    public List<Enchere> getRemportesParEncherisseur(int id) throws BusinessException {

        List<Enchere> list = new ArrayList<>();

        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement statement = cnx.prepareStatement(GET_REMPORTES_PAR_ENCHERISSEUR);
            statement.setInt(1, id);
            statement.setBoolean(2, true);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Enchere enchere = new Enchere();
                enchere.setId(rs.getInt("no_enchere"));
                enchere.setDate(rs.getDate("date_enchere").toLocalDate());
                enchere.setMontant(rs.getInt("montant_enchere"));
                enchere.setArticle(articleDao.getById(rs.getInt("no_article")));
                // enchere.setEncherisseur(utilisateurDAO.getById(rs.getInt("no_utilisateur")));
                // enchere.setRemporte(rs.getBoolean("remporte"));

                list.add(enchere);
            }

        } catch (Exception e) {
            e.printStackTrace();
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.LECTURE_ENCHERES_ECHEC);
            throw businessException;
        }
        return list;
    }

    @Override
    public void update(Enchere enchere) throws BusinessException {

        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement statement = cnx.prepareStatement(UPDATE);
            statement.setDate(1, Date.valueOf(enchere.getDate()));
            statement.setInt(2, enchere.getMontant());
            statement.setInt(3, enchere.getArticle().getNoArticle());
            statement.setInt(4, enchere.getEncherisseur().getNo_utilisateur());
            statement.setBoolean(5, enchere.isRemporte());
            statement.setInt(6, enchere.getId());

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

    @Override
    public List<Enchere> getAllByArticle(int id) throws BusinessException {

        List<Enchere> encheres = new ArrayList<>();

        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement statement = cnx.prepareStatement(GET_ALL_BY_ARTICLE);
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Enchere enchere = new Enchere();
                enchere.setId(rs.getInt("no_enchere"));
                enchere.setDate(rs.getDate("date_enchere").toLocalDate());
                enchere.setMontant(rs.getInt("montant_enchere"));
                enchere.setArticle(articleDao.getById(rs.getInt("no_article")));
                enchere.setEncherisseur(utilisateurDAO.getById(rs.getInt("no_utilisateur")));
                enchere.setRemporte(rs.getBoolean("remporte"));

                encheres.add(enchere);
            }

        } catch (Exception e) {
            e.printStackTrace();
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.LECTURE_ENCHERES_ECHEC);
            throw businessException;
        }

        return encheres;
    }

}