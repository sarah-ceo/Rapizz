package rapizz;

import java.io.Console;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOUser {
	private Connection cnx;
	private String table;
	
	public DAOUser(Connection connect) {
		this.cnx = connect;
	}
	
	public User checkAuth(String statut, String email, String motdepasse) {
		PreparedStatement pstatement;
		ResultSet rs;
		User user=null;
		this.table = statut.toLowerCase()+"s" ;
		String loginField = "login"+statut;
		String passwordField = "password"+statut;
		
		String SQL = "SELECT * FROM "+this.table+" WHERE "+loginField+"=? AND "+passwordField+"=?";
		try {
			pstatement = cnx.prepareStatement(SQL);
			pstatement.setString(1, email);
			pstatement.setString(2, motdepasse);
			
			rs = pstatement.executeQuery();
			
			user = new User();
			
			switch(statut) {
				case "Livreur":
					if(rs.next()==true) {
						user.setId(rs.getInt("idLivreur"));
						user.setNom(rs.getString("nomLivreur"));
						user.setPrenom(rs.getString("prenomLivreur"));
						user.setLogin(rs.getString("loginLivreur"));
						user.setPassword(rs.getString("passwordLivreur"));
					}
					break;
				case "Administrateur":
					if(rs.next()==true) {
						user.setId(rs.getInt("idAdministrateur"));
						user.setNom(rs.getString("nomAdministrateur"));
						user.setPrenom(rs.getString("prenomAdministrateur"));
						user.setLogin(rs.getString("loginAdministrateur"));
						user.setPassword(rs.getString("passwordAdministrateur"));
					}
					break;
				default:
					if(rs.next()==true) {
						user.setId(rs.getInt("idClient"));
						user.setNom(rs.getString("nomClient"));
						user.setPrenom(rs.getString("prenomClient"));
						user.setAdresse(rs.getString("adresseClient"));
						user.setSolde(rs.getFloat("soldeClient"));
						user.setLogin(rs.getString("loginClient"));
						user.setPassword(rs.getString("passwordClient"));
					}
					break;
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}
	
	public void UpdateClientInformations(User user) {
		PreparedStatement pStatement;
		String SQL="UPDATE "+this.table+" SET nomClient=?, prenomClient=?, adresseClient=?, loginClient=?, passwordClient=? WHERE idClient=?";
		try {
			pStatement = cnx.prepareStatement(SQL);
			pStatement.setString(1, user.getNom());
			pStatement.setString(2, user.getPrenom());
			pStatement.setString(3, user.getAdresse());
			pStatement.setString(4, user.getLogin());
			pStatement.setString(5, user.getPassword());
			pStatement.setInt(6, user.getId());
			pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void UpdateSoldeClient(User user) {
		PreparedStatement pStatement;
		String SQL="UPDATE "+this.table+" SET soldeClient=? WHERE idClient=?";
		try {
			pStatement = cnx.prepareStatement(SQL);
			pStatement.setFloat(1, user.getSolde());
			pStatement.setInt(2, user.getId());
			pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addClient(String nom, String prenom, String adresse, String login, String password) {
		PreparedStatement pStatement;
		String SQL="INSERT INTO clients(nomClient, prenomClient, adresseClient, loginClient, passwordClient, soldeClient) VALUES(?,?,?,?,?,?)";
		try {
			pStatement = cnx.prepareStatement(SQL);
			pStatement.setString(1, nom);
			pStatement.setString(2, prenom);
			pStatement.setString(3, adresse);
			pStatement.setString(4, login);
			pStatement.setString(5, password);
			pStatement.setFloat(6, 0);
			pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void UpdateLivreurInformations(User user) {
		PreparedStatement pStatement;
		String SQL="UPDATE livreurs SET nomLivreur=?, prenomLivreur=?, loginLivreur=?, passwordLivreur=? WHERE idLivreur=?";
		try {
			pStatement = cnx.prepareStatement(SQL);
			pStatement.setString(1, user.getNom());
			pStatement.setString(2, user.getPrenom());
			pStatement.setString(3, user.getLogin());
			pStatement.setString(4, user.getPassword());
			pStatement.setInt(5, user.getId());
			pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<String[]> meilleursClients(){
		PreparedStatement pStatement;
		ResultSet rs;
		List<String[]> meilleursclients = new ArrayList<>();
		String client="";
		String nbCommandes = "";
		String montantTotal = "";
		String SQL="CALL meilleurClient();";
		try {
			pStatement = cnx.prepareStatement(SQL);
			rs = pStatement.executeQuery();
			
			while(rs.next()) {
				String [] infosClient = new String[3];
				client = rs.getString("Client"); 
				nbCommandes = rs.getInt("Nombre de commandes")+"";
				montantTotal = rs.getFloat("Montant total")+" €";
				infosClient[0]= client;
				infosClient[1]= nbCommandes;
				infosClient[2]= montantTotal;
				meilleursclients.add(infosClient);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return meilleursclients;
	}
	
	public List<String[]> piresLireurs(){
		PreparedStatement pStatement;
		ResultSet rs;
		List<String[]> pireslivreurs = new ArrayList<>();
		String livreur="";
		String retards = "";
		String moyenne = "";
		String SQL="CALL pireLivreur();";
		try {
			pStatement = cnx.prepareStatement(SQL);
			rs = pStatement.executeQuery();
			
			while(rs.next()) {
				String [] infosLivreur= new String[3];
				livreur = rs.getString("Livreur"); 
				retards = rs.getInt("Nombre de retard")+"";
				moyenne = rs.getFloat("Temps de livraison moyen")+" min";
				infosLivreur[0]= livreur;
				infosLivreur[1]= retards;
				infosLivreur[2]= moyenne;
				pireslivreurs.add(infosLivreur);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return pireslivreurs;
	}

}
