package rapizz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOCommande {
	private Connection cnx;
	
	public DAOCommande(Connection connect) {
		this.cnx = connect;
	}
	
	public float getCA() {
		PreparedStatement pStatement;
		ResultSet rs;
		float ca = 0;
		String SQL="SELECT SUM(montantCommande) AS ca FROM commandes";
		try {
			pStatement = cnx.prepareStatement(SQL);
			rs = pStatement.executeQuery();
			
			while(rs.next()) {
				ca = rs.getFloat("ca");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ca;
	}
	
	public List<Commande> getAllCommandes() {
		PreparedStatement pStatement;
		ResultSet rs;
		List<Commande> allcommandes = new ArrayList<>();
		Commande commande=null;
		String SQL="SELECT * FROM commandes ORDER BY dateCommande DESC";
		try {
			pStatement = cnx.prepareStatement(SQL);
			rs = pStatement.executeQuery();
			
			while(rs.next()) {
				commande = new Commande();
				commande.setIdCommande(rs.getInt("idCommande"));
				commande.setIdClient(rs.getInt("idClient"));
				commande.setIdLivreur(rs.getInt("idLivreur"));
				commande.setIdVehicule(rs.getInt("idVehicule"));
				commande.setDateCommande(rs.getTimestamp("dateCommande"));
				commande.setMontantCommande(rs.getFloat("montantCommande"));
				commande.setBonification(rs.getString("bonification"));
				commande.setTempsLivraison(rs.getInt("tempsLivraison"));
				commande.setStatutCommande(rs.getString("statutCommande"));
				allcommandes.add(commande);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allcommandes;
	}
	
	public List<Commande> getCommandesByClient(int idClient) {
		PreparedStatement pStatement;
		ResultSet rs;
		List<Commande> allcommandes = new ArrayList<>();
		Commande commande=null;
		String SQL="SELECT * FROM commandes WHERE idClient=? ORDER BY dateCommande DESC";
		try {
			pStatement = cnx.prepareStatement(SQL);
			pStatement.setInt(1, idClient);
			rs = pStatement.executeQuery();
			
			while(rs.next()) {
				commande = new Commande();
				commande.setIdCommande(rs.getInt("idCommande"));
				commande.setIdClient(rs.getInt("idClient"));
				commande.setIdLivreur(rs.getInt("idLivreur"));
				commande.setIdVehicule(rs.getInt("idVehicule"));
				commande.setDateCommande(rs.getTimestamp("dateCommande"));
				commande.setMontantCommande(rs.getFloat("montantCommande"));
				commande.setBonification(rs.getString("bonification"));
				commande.setTempsLivraison(rs.getInt("tempsLivraison"));
				commande.setStatutCommande(rs.getString("statutCommande"));
				allcommandes.add(commande);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allcommandes;
	}
	
	public void addCommande(Commande commande, List<Pizza> pizzas, List<String> correspondingSizes) {
		PreparedStatement pStatement;
		String SQL="INSERT INTO commandes(idClient, dateCommande, montantCommande, idLivreur, idVehicule, tempsLivraison, statutCommande) VALUES(?,?,?,?,?,?,?)";
		try {
			pStatement = cnx.prepareStatement(SQL);
			pStatement.setInt(1, commande.getIdClient());
			pStatement.setTimestamp(2, commande.getDateCommande());
			pStatement.setFloat(3, commande.getMontantCommande());
			pStatement.setInt(4, 0);
			pStatement.setInt(5, 0); 
			pStatement.setInt(6, 0);
			pStatement.setString(7, "En cours");
			pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ResultSet rs;
		PreparedStatement pStatement_i;
		String SQL_i="SELECT * FROM commandes WHERE idClient=? ORDER BY dateCommande DESC LIMIT 1";
		try {
			pStatement_i = cnx.prepareStatement(SQL_i);
			pStatement_i.setInt(1, commande.getIdClient());
			rs = pStatement_i.executeQuery();
			
			while(rs.next()) {
				commande.setIdCommande(rs.getInt("idCommande"));
				commande.setIdLivreur(rs.getInt("idLivreur"));
				commande.setIdVehicule(rs.getInt("idVehicule"));
				commande.setBonification(rs.getString("bonification"));
				commande.setTempsLivraison(rs.getInt("tempsLivraison"));
				commande.setStatutCommande(rs.getString("statutCommande"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i=0; i<pizzas.size(); i++) {
			PreparedStatement pStatement2;
			String SQL2="INSERT INTO commandes_pizzas(idCommande, idPizza, taillePizza) VALUES(?,?,?)";
			try {
				pStatement2 = cnx.prepareStatement(SQL2);
				pStatement2.setInt(1, commande.getIdCommande());
				pStatement2.setInt(2, pizzas.get(i).getIdPizza());
				pStatement2.setString(3, correspondingSizes.get(i));
				pStatement2.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
		
	public List<Commande> getCommandesByLivreur(int idLivreur) {
		PreparedStatement pStatement;
		ResultSet rs;
		List<Commande> allcommandes = new ArrayList<>();
		Commande commande=null;
		String SQL="SELECT * FROM commandes WHERE idLivreur=? ORDER BY dateCommande DESC";
		try {
			pStatement = cnx.prepareStatement(SQL);
			pStatement.setInt(1, idLivreur);
			rs = pStatement.executeQuery();
			
			while(rs.next()) {
				commande = new Commande();
				commande.setIdCommande(rs.getInt("idCommande"));
				commande.setIdClient(rs.getInt("idClient"));
				commande.setIdLivreur(rs.getInt("idLivreur"));
				commande.setIdVehicule(rs.getInt("idVehicule"));
				commande.setDateCommande(rs.getTimestamp("dateCommande"));
				commande.setMontantCommande(rs.getFloat("montantCommande"));
				commande.setBonification(rs.getString("bonification"));
				commande.setTempsLivraison(rs.getInt("tempsLivraison"));
				commande.setStatutCommande(rs.getString("statutCommande"));
				allcommandes.add(commande);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allcommandes;
	}
	
	public List<Commande> getUnfinishedCommandesByLivreur(int idLivreur) {
		PreparedStatement pStatement;
		ResultSet rs;
		List<Commande> allcommandes = new ArrayList<>();
		Commande commande=null;
		String SQL="SELECT * FROM commandes WHERE idLivreur=? AND statutCommande=? ORDER BY dateCommande";
		try {
			pStatement = cnx.prepareStatement(SQL);
			pStatement.setInt(1, idLivreur);
			pStatement.setString(2, "En cours");
			rs = pStatement.executeQuery();
			
			while(rs.next()) {
				commande = new Commande();
				commande.setIdCommande(rs.getInt("idCommande"));
				commande.setIdClient(rs.getInt("idClient"));
				commande.setIdLivreur(rs.getInt("idLivreur"));
				commande.setIdVehicule(rs.getInt("idVehicule"));
				commande.setDateCommande(rs.getTimestamp("dateCommande"));
				commande.setMontantCommande(rs.getFloat("montantCommande"));
				commande.setBonification(rs.getString("bonification"));
				commande.setTempsLivraison(rs.getInt("tempsLivraison"));
				commande.setStatutCommande(rs.getString("statutCommande"));
				allcommandes.add(commande);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allcommandes;
	}
	
	
	public String getNomLivreur(int idCommande) {
		PreparedStatement pStatement;
		ResultSet rs;
		String nom="";
		String prenom="";
		String SQL="SELECT nomLivreur, prenomLivreur FROM livreurs JOIN commandes ON commandes.idLivreur=livreurs.idLivreur WHERE commandes.idCommande=?";
		try {
			pStatement = cnx.prepareStatement(SQL);
			pStatement.setInt(1, idCommande);
			rs = pStatement.executeQuery();
			
			while(rs.next()) {
				nom = rs.getString("nomLivreur");
				prenom = rs.getString("prenomLivreur");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prenom+" "+nom;
	}
	
	public String getNomVehicule(int idCommande) {
		PreparedStatement pStatement;
		ResultSet rs;
		String type="";
		String immat="";
		String SQL="SELECT typeVehicule, immatriculationVehicule FROM vehicules JOIN commandes ON commandes.idVehicule=vehicules.idVehicule WHERE commandes.idCommande=?";
		try {
			pStatement = cnx.prepareStatement(SQL);
			pStatement.setInt(1, idCommande);
			rs = pStatement.executeQuery();
			
			while(rs.next()) {
				type = rs.getString("typeVehicule");
				immat = rs.getString("immatriculationVehicule");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return type+" ("+immat+")";
	}
	
	public String getNomClient(int idCommande) {
		PreparedStatement pStatement;
		ResultSet rs;
		String nom="";
		String prenom="";
		String SQL="SELECT nomClient, prenomClient FROM clients JOIN commandes ON commandes.idClient=clients.idClient WHERE commandes.idCommande=?";
		try {
			pStatement = cnx.prepareStatement(SQL);
			pStatement.setInt(1, idCommande);
			rs = pStatement.executeQuery();
			
			while(rs.next()) {
				nom = rs.getString("nomClient");
				prenom = rs.getString("prenomClient");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prenom+" "+nom;
	}
	
	public String getAdresseClient(int idCommande) {
		PreparedStatement pStatement;
		ResultSet rs;
		String adresse="";
		String SQL="SELECT adresseClient FROM clients JOIN commandes ON commandes.idClient=clients.idClient WHERE commandes.idCommande=?";
		try {
			pStatement = cnx.prepareStatement(SQL);
			pStatement.setInt(1, idCommande);
			rs = pStatement.executeQuery();
			
			while(rs.next()) {
				adresse = rs.getString("adresseClient");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return adresse;
	}
	
	public void updateCommande(int idCommande, int tempsLivraison) {
		PreparedStatement pStatement;
		String SQL="";
		if (tempsLivraison > 30) {
			SQL = "UPDATE commandes SET tempsLivraison=?, statutCommande='Terminée', bonification='Retard', montantCommande=0 WHERE idCommande=?";
			try {
				pStatement = cnx.prepareStatement(SQL);
				pStatement.setInt(1, tempsLivraison);
				pStatement.setInt(2, idCommande);
				pStatement.execute();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			SQL="UPDATE commandes SET tempsLivraison=?, statutCommande='Terminée' WHERE idCommande=?";
			try {
				pStatement = cnx.prepareStatement(SQL);
				pStatement.setInt(1, tempsLivraison);
				pStatement.setInt(2, idCommande);
				pStatement.execute();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			PreparedStatement pStatement_i;
			ResultSet rs;
			Commande commande=null;
			String SQL_i="SELECT * FROM commandes WHERE idCommande=?";
			try {
				pStatement_i = cnx.prepareStatement(SQL_i);
				pStatement_i.setInt(1, idCommande);
				rs = pStatement_i.executeQuery();
				
				while(rs.next()) {
					commande = new Commande();
					commande.setIdCommande(rs.getInt("idCommande"));
					commande.setIdClient(rs.getInt("idClient"));
					commande.setIdLivreur(rs.getInt("idLivreur"));
					commande.setIdVehicule(rs.getInt("idVehicule"));
					commande.setDateCommande(rs.getTimestamp("dateCommande"));
					commande.setMontantCommande(rs.getFloat("montantCommande"));
					commande.setBonification(rs.getString("bonification"));
					commande.setTempsLivraison(rs.getInt("tempsLivraison"));
					commande.setStatutCommande(rs.getString("statutCommande"));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			PreparedStatement pStatement_2;
			String SQL_2="UPDATE clients SET soldeClient = soldeClient-? WHERE idClient=?";
			try {
				pStatement_2 = cnx.prepareStatement(SQL_2);
				pStatement_2.setFloat(1, commande.getMontantCommande());
				pStatement_2.setInt(2, commande.getIdClient());
				pStatement_2.execute();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
