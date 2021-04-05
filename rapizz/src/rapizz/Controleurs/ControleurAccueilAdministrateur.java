package rapizz.Controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.List;

import rapizz.DAOCommande;
import rapizz.DAOPizza;
import rapizz.DAOUser;
import rapizz.IngredientsFavorisJTableModel;
import rapizz.IngredientsJTableModel;
import rapizz.MeilleursClientsJTableModel;
import rapizz.PiresLivreursJTableModel;
import rapizz.PizzasFavoritesJTableModel;
import rapizz.User;
import rapizz.Fenetres.FenetreAccueilAdmin;
import rapizz.Fenetres.FenetreFichesLivraisons;
import rapizz.Fenetres.FenetreLogin;
import rapizz.Fenetres.FenetreNouvellePizza;

public class ControleurAccueilAdministrateur {
	
	private User connectedUser;
	private static DecimalFormat df = new DecimalFormat("0.00");
	
	public ControleurAccueilAdministrateur(FenetreLogin f0, FenetreAccueilAdmin f1, DAOUser daouser, User user, DAOCommande daocommande, DAOPizza daopizza) {
		this.connectedUser = user;
		
		List<String[]> dataClient = daouser.meilleursClients();
		MeilleursClientsJTableModel modeleClient = new MeilleursClientsJTableModel(dataClient);
		f1.getTableClients().setModel(modeleClient);
		
		List<String[]> dataLivreur = daouser.piresLireurs();
		PiresLivreursJTableModel modeleLivreur = new PiresLivreursJTableModel(dataLivreur);
		f1.getTableLivreurs().setModel(modeleLivreur);
		
		List<String[]> dataPizza = daopizza.pizzasFavorites();
		PizzasFavoritesJTableModel modelePizza = new PizzasFavoritesJTableModel(dataPizza);
		f1.getTablePizzas().setModel(modelePizza);
		
		List<String[]> dataIngredient = daopizza.ingredientsFavoris();
		IngredientsFavorisJTableModel modeleIngredient = new IngredientsFavorisJTableModel(dataIngredient);
		f1.getTableIngredients().setModel(modeleIngredient);
		
		f1.getTextPaneCA().setText(df.format(daocommande.getCA())+" €");
		
		f1.setVisible(true);
		
		f1.getBtnDeconnexion().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f1.setVisible(false);
				connectedUser=null;
				f0.getTxtLogin().setText("");
				f0.getPasswordField().setText("");
				f0.setVisible(true);
			}
		});
		
		f1.getBtnNouvellePizza().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f1.setVisible(false);
				new ControleurNouvellePizza(f1, new FenetreNouvellePizza(), user, daopizza);
			}
		});
		
		f1.getBtnFichesLivraison().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f1.setVisible(false);
				new ControleurFichesLivraison(f1, new FenetreFichesLivraisons(), connectedUser, daocommande, daopizza);
			}
		});
	}

}
