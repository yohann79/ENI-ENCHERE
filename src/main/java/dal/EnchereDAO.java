package dal;

import java.util.List;

import bll.BusinessException;
import bo.Enchere;

public interface EnchereDAO {

    public Enchere insert(Enchere enchere) throws BusinessException;

    public List<Enchere> getAll() throws BusinessException;

    public Enchere getById(int id) throws BusinessException;

    public List<Enchere> getByEncherisseur(int id) throws BusinessException;

    public List<Enchere> getRemportesParEncherisseur(int id) throws BusinessException;

    public void update(Enchere enchere) throws BusinessException;

    public void delete(int id) throws BusinessException;

    public List<Enchere> getAllByArticle(int id) throws BusinessException;
}