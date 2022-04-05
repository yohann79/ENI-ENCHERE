package bo;

public enum EtatVente {
	CREE("vente cr��e"),
	EN_COURS("en cours"),
	ANNULE("annul�e"),
	ENCHERES_TERMINEES("ench�res termin�es"),
	RETRAIT_EFFECTUE("retrait effectu�");
	
	private final String message; 
	
	EtatVente(String message)
	{
		this.message = message;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
}
