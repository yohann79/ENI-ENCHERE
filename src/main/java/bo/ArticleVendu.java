package bo;

import java.sql.Date;

public class ArticleVendu {
	int noArticle ;
	String nomArticle;
	String description;
	Date dateDebutEnchere;
	Date dateFinEnchere;
	int prixInitial;
	int prixvente;
	int noUtilisateur;
	int noCategorie;
	
	
	/**
	 * all arg constructor
	 * @param noArticle
	 * @param nomArticle
	 * @param description
	 * @param dateDebutEnchere
	 * @param dateFinEnchere
	 * @param prixInitial
	 * @param prixvente
	 * @param noUtilisateur
	 * @param noCategorie
	 */
	public ArticleVendu(int noArticle, String nomArticle, String description, Date dateDebutEnchere,
			Date dateFinEnchere, int prixInitial, int prixvente, int noUtilisateur, int noCategorie) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEnchere = dateDebutEnchere;
		this.dateFinEnchere = dateFinEnchere;
		this.prixInitial = prixInitial;
		this.prixvente = prixvente;
		this.noUtilisateur = noUtilisateur;
		this.noCategorie = noCategorie;
	}
	/**
	 * Getter and Setter for all field 
	 * 
	 */
	public int getNoArticle() {
		return noArticle;
	}
	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}
	public String getNomArticle() {
		return nomArticle;
	}
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateDebutEnchere() {
		return dateDebutEnchere;
	}
	public void setDateDebutEnchere(Date dateDebutEnchere) {
		this.dateDebutEnchere = dateDebutEnchere;
	}
	public Date getDateFinEnchere() {
		return dateFinEnchere;
	}
	public void setDateFinEnchere(Date dateFinEnchere) {
		this.dateFinEnchere = dateFinEnchere;
	}
	public int getPrixInitial() {
		return prixInitial;
	}
	public void setPrixInitial(int prixInitial) {
		this.prixInitial = prixInitial;
	}
	public int getPrixvente() {
		return prixvente;
	}
	public void setPrixvente(int prixvente) {
		this.prixvente = prixvente;
	}
	public int getNoUtilisateur() {
		return noUtilisateur;
	}
	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}
	public int getNoCategorie() {
		return noCategorie;
	}
	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}
	
	
}
