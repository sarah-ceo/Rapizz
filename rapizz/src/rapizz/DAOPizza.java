package rapizz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOPizza {
	private Connection cnx;
	
	public DAOPizza(Connection connect) {
		this.cnx = connect;
	}
	
	public List<Pizza> getAllPizzas(){
		PreparedStatement pStatement;
		ResultSet rs;
		List<Pizza> allpizzas = new ArrayList<>();
		Pizza pizza=null;
		String SQL="SELECT * FROM pizzas";
		try {
			pStatement = cnx.prepareStatement(SQL);
			rs = pStatement.executeQuery();
			
			while(rs.next()) {
				pizza = new Pizza();
				pizza.setIdPizza(rs.getInt("idPizza"));
				pizza.setNomPizza(rs.getString("nomPizza"));
				pizza.setPrixBase(rs.getFloat("prixBase"));
				allpizzas.add(pizza);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return allpizzas;
	}
	
	public List<Pizza> getPizzasByCommande(int idCommande) {
		PreparedStatement pStatement;
		ResultSet rs;
		List<Pizza> allpizzas = new ArrayList<>();
		Pizza pizza=null;
		String SQL="SELECT * FROM pizzas JOIN commandes_pizzas ON commandes_pizzas.idPizza=pizzas.idPizza WHERE idCommande=? ORDER BY prixBase";
		try {
			pStatement = cnx.prepareStatement(SQL);
			pStatement.setInt(1, idCommande);
			rs = pStatement.executeQuery();
			
			while(rs.next()) {
				pizza = new Pizza();
				pizza.setIdPizza(rs.getInt("idPizza"));
				pizza.setNomPizza(rs.getString("nomPizza"));
				pizza.setPrixBase(rs.getFloat("prixBase"));
				allpizzas.add(pizza);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allpizzas;
	}
	
	public String getPizzaTaille(int idCommande, int idPizza) {
		PreparedStatement pStatement;
		ResultSet rs;
		String taille="";
		String SQL="SELECT taillePizza FROM commandes_pizzas WHERE idCommande=? AND idPizza=?";
		try {
			pStatement = cnx.prepareStatement(SQL);
			pStatement.setInt(1, idCommande);
			pStatement.setInt(2, idPizza);
			rs = pStatement.executeQuery();
			
			while(rs.next()) {
				taille = rs.getString("taillePizza");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return taille;
	}
	
	public float getPrixPizza(int idPizza, String taille) {

		PreparedStatement pStatement;
		ResultSet rs;
		float prixBase = 0;
		float prix = 0;
		String SQL="SELECT prixBase FROM pizzas WHERE idPizza=?";
		try {
			pStatement = cnx.prepareStatement(SQL);
			pStatement.setInt(1, idPizza);
			rs = pStatement.executeQuery();
			
			while(rs.next()) {
				prixBase = rs.getFloat("prixBase");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		switch (taille) {
		case "Naine":
			prix = (float) (prixBase-(1.0/3.0*prixBase));
			break;
		case "Humaine":
			prix = prixBase;
			break;
		case "Ogresse":
			prix =  (float) (prixBase+(1.0/3.0*prixBase));
			break;
		}
		
		return prix;
	}
	
	public List<String> getIngredientsPizza(int idPizza) {
		PreparedStatement pStatement;
		ResultSet rs;
		List<String> allingredients = new ArrayList<>();
		String ingredient="";
		String SQL="SELECT nomIngredient FROM ingredients JOIN pizzas_ingredients ON pizzas_ingredients.idIngredient=ingredients.idIngredient WHERE idPizza=?";
		try {
			pStatement = cnx.prepareStatement(SQL);
			pStatement.setInt(1, idPizza);
			rs = pStatement.executeQuery();
			
			while(rs.next()) {
				ingredient = rs.getString("nomIngredient");
				allingredients.add(ingredient);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allingredients;
	}
	
	public List<String> getAllIngredients() {
		PreparedStatement pStatement;
		ResultSet rs;
		List<String> allingredients = new ArrayList<>();
		String ingredient="";
		String SQL="SELECT nomIngredient FROM ingredients";
		try {
			pStatement = cnx.prepareStatement(SQL);
			rs = pStatement.executeQuery();
			
			while(rs.next()) {
				ingredient = rs.getString("nomIngredient");
				allingredients.add(ingredient);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allingredients;
	}
	
	public int getIngredientByName(String ingredient) {
		PreparedStatement pStatement;
		ResultSet rs;
		int idIngredient=0;
		String SQL="SELECT idIngredient FROM ingredients WHERE nomIngredient=?";
		try {
			pStatement = cnx.prepareStatement(SQL);
			pStatement.setString(1, ingredient);
			rs = pStatement.executeQuery();
			
			while(rs.next()) {
				idIngredient = rs.getInt("idIngredient");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idIngredient;
	}
	
	public void addPizza(Pizza pizza, List<String> ingredients) {
		PreparedStatement pStatement;
		String SQL="INSERT INTO pizzas(nomPizza, prixBase) VALUES(?,?)";
		try {
			pStatement = cnx.prepareStatement(SQL);
			pStatement.setString(1, pizza.getNomPizza());
			pStatement.setFloat(2, pizza.getPrixBase());
			pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ResultSet rs;
		PreparedStatement pStatement_i;
		String SQL_i="SELECT * FROM pizzas WHERE nomPizza=? LIMIT 1";
		try {
			pStatement_i = cnx.prepareStatement(SQL_i);
			pStatement_i.setString(1, pizza.getNomPizza());
			rs = pStatement_i.executeQuery();
			
			while(rs.next()) {
				pizza.setIdPizza(rs.getInt("idPizza"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i=0; i<ingredients.size(); i++) {
			PreparedStatement pStatement2;
			String SQL2="INSERT INTO pizzas_ingredients(idPizza, idIngredient) VALUES(?,?)";
			try {
				pStatement2 = cnx.prepareStatement(SQL2);
				pStatement2.setInt(1, pizza.getIdPizza());
				pStatement2.setInt(2, this.getIngredientByName(ingredients.get(i)));
				pStatement2.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void addIngredient(String nomIngredient) {
		PreparedStatement pStatement;
		String SQL="INSERT INTO ingredients(nomIngredient) VALUES(?)";
		try {
			pStatement = cnx.prepareStatement(SQL);
			pStatement.setString(1, nomIngredient);
			pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<String[]> pizzasFavorites(){
		PreparedStatement pStatement;
		ResultSet rs;
		List<String[]> pizzasfavorites = new ArrayList<>();
		String pizza="";
		String nbCommande = "";
		String SQL="CALL pizzaFavorite();";
		try {
			pStatement = cnx.prepareStatement(SQL);
			rs = pStatement.executeQuery();
			
			while(rs.next()) {
				String [] infosPizza = new String[3];
				pizza = rs.getString("Pizza"); 
				nbCommande = rs.getInt("Nombre de commandes")+" fois";
				infosPizza[0]= pizza;
				infosPizza[1]= nbCommande;
				pizzasfavorites.add(infosPizza);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return pizzasfavorites;
	}
	
	public List<String[]> ingredientsFavoris(){
		PreparedStatement pStatement;
		ResultSet rs;
		List<String[]> ingredientsfavoris = new ArrayList<>();
		String ingredient="";
		String recettes = "";
		String SQL="CALL ingredientFavori();";
		try {
			pStatement = cnx.prepareStatement(SQL);
			rs = pStatement.executeQuery();
			
			while(rs.next()) {
				String [] infosIngredient= new String[3];
				ingredient = rs.getString("Ingrédient"); 
				recettes = rs.getInt("Nombre de pizzas")+" pizzas";
				infosIngredient[0]= ingredient;
				infosIngredient[1]= recettes;
				ingredientsfavoris.add(infosIngredient);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return ingredientsfavoris;
	}

}
