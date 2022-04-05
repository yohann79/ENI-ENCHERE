package bo;

public enum EtatVente {
	CREE("vente créée"),
	EN_COURS("en cours"),
	ANNULE("annulée"),
	ENCHERES_TERMINEES("enchéres terminées"),
	RETRAIT_EFFECTUE("retrait effectué");
	
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
