package bll;

public class CodesResultatBLL {

    /**
     * Echec quand le libelle ne respecte pas les r�gles d�finies
     */
    public static final int REGLE_CATEGORIES_LIBELLE_ERREUR = 20000;

    /**
     * Echec quand la la date de l'enchere ne respecte pas les r�gles d�finies
     */
    public static final int REGLE_ENCHERES_DATE_ERREUR = 20001;

    /**
     * Echec quand l'adresse ne respecte pas les r�gles d�finies
     */
    public static final int REGLE_RETRAITS_ADRESSE_ERREUR = 20002;

    /**
     * Echec quand les coordonn�es de l'utilisateur ne respecte pas les r�gles
     * d�finies
     */
    public static final int REGLE_UTILISATEURS_COORDONNEES_ERREUR = 20003;

    /**
     * Echec quand la liste des articles vendus ne respecte pas les r�gles d�finies
     */
    public static final int REGLE_UTILISATEURS_ARTICLE_VENDU_ERREUR = 20004;

    /**
     * Echec quand la liste des articles achet�s ne respecte pas les r�gles d�finies
     */
    public static final int REGLE_UTILISATEURS_ARTICLE_ACHETE_ERREUR = 20005;

    /**
     * Echec quand la liste des encheres ne respecte pas les r�gles d�finies
     */
    public static final int REGLE_UTILISATEURS_ENCHERES_ERREUR = 20006;
    /**
     * Echec quand la date de d�but et de fin des ench�res ne respectent pas les
     * r�gles d�finies
     */
    public static final int REGLE_ARTICLES_DATE_ERREUR = 20007;
    /**
     * Echec lors d'une tentative de supprimer un article d�j� achet�
     */
    public static final int REGLE_ARTICLES_ETAT_VENTE_ERREUR = 20008;

}