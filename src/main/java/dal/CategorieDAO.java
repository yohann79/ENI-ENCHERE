package dal;

import java.util.List;

import bll.BusinessException;
import bo.Categorie;

public interface CategorieDAO {

    public Categorie insert(Categorie categorie) throws BusinessException;

    public Categorie getById(int id) throws BusinessException;

    public List<Categorie> getAll() throws BusinessException;

    public void update(Categorie categorie) throws BusinessException;

    public void delete(int id) throws BusinessException;

}
