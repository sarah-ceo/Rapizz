package rapizz;
import java.sql.Timestamp;

public class Commande {
	
	private int idCommande;
	private int idClient;
	private int idLivreur;
	private int idVehicule;
	private Timestamp dateCommande;
	private int tempsLivraison;
	private String bonification;
	private float montantCommande;
	private String statutCommande;
	
	public Commande() {
		
	}
	
	public Commande(int idCommande, int idClient, int idLivreur, int idVehicule, Timestamp dateCommande,
			int tempsLivraison, String bonification, float montantCommande, String statutCommande) {
		super();
		this.idCommande = idCommande;
		this.idClient = idClient;
		this.idLivreur = idLivreur;
		this.idVehicule = idVehicule;
		this.dateCommande = dateCommande;
		this.tempsLivraison = tempsLivraison;
		this.bonification = bonification;
		this.montantCommande = montantCommande;
	}

	public int getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public int getIdLivreur() {
		return idLivreur;
	}

	public void setIdLivreur(int idLivreur) {
		this.idLivreur = idLivreur;
	}

	public int getIdVehicule() {
		return idVehicule;
	}

	public void setIdVehicule(int idVehicule) {
		this.idVehicule = idVehicule;
	}

	public Timestamp getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Timestamp dateCommande) {
		this.dateCommande = dateCommande;
	}

	public int getTempsLivraison() {
		return tempsLivraison;
	}

	public void setTempsLivraison(int tempsLivraison) {
		this.tempsLivraison = tempsLivraison;
	}

	public String getBonification() {
		return bonification;
	}

	public void setBonification(String bonification) {
		this.bonification = bonification;
	}

	public float getMontantCommande() {
		return montantCommande;
	}

	public void setMontantCommande(float montantCommande) {
		this.montantCommande = montantCommande;
	}

	public String getStatutCommande() {
		return statutCommande;
	}

	public void setStatutCommande(String statutCommande) {
		this.statutCommande = statutCommande;
	}
}
