package rapizz;

public class Pizza {
	
	private int idPizza;
	private String nomPizza;
	private float prixBase;
	
	public Pizza() {
	}
	
	public Pizza(int idPizza, String nomPizza, float prixBase) {
		super();
		this.idPizza = idPizza;
		this.nomPizza = nomPizza;
		this.prixBase = prixBase;
	}

	public int getIdPizza() {
		return idPizza;
	}

	public void setIdPizza(int idPizza) {
		this.idPizza = idPizza;
	}

	public String getNomPizza() {
		return nomPizza;
	}

	public void setNomPizza(String nomPizza) {
		this.nomPizza = nomPizza;
	}

	public float getPrixBase() {
		return prixBase;
	}

	public void setPrixBase(float prixBase) {
		this.prixBase = prixBase;
	}

}
