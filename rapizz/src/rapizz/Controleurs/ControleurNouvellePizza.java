package rapizz.Controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import rapizz.Commande;
import rapizz.CommandePizzasJTableModel;
import rapizz.DAOCommande;
import rapizz.DAOPizza;
import rapizz.IngredientsJTableModel;
import rapizz.Pizza;
import rapizz.User;
import rapizz.Fenetres.FenetreAccueilAdmin;
import rapizz.Fenetres.FenetreNouvelIngredient;
import rapizz.Fenetres.FenetreNouvelleCommande;
import rapizz.Fenetres.FenetreNouvellePizza;

public class ControleurNouvellePizza {

	private User connectedUser;
	
	public ControleurNouvellePizza(FenetreAccueilAdmin f1, FenetreNouvellePizza f2, User user, DAOPizza daopizza) {
		this.connectedUser = user;
		
		List<String> ingredients = daopizza.getAllIngredients();
		
		f2.getComboBoxIngredients().setModel(new DefaultComboBoxModel<>(ingredients.toArray()));
		f2.getComboBoxIngredients().setSelectedIndex(0);
		
		List<String> data = new ArrayList<>();
		f2.setVisible(true);
		
		f2.getBtnAjouter().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int ingredientIndex = f2.getComboBoxIngredients().getSelectedIndex();
				
				String ingredientSelectionne = ingredients.get(ingredientIndex);
				
				data.add(ingredientSelectionne);
				
				IngredientsJTableModel modele = new IngredientsJTableModel(data);
				f2.getTable().setModel(modele);
				
				f2.getComboBoxRetirer().setModel(new DefaultComboBoxModel<>(data.toArray()));
				if(data.size()>0) {
					f2.getComboBoxRetirer().setSelectedIndex(0);
				}
			}
		});
		
		f2.getBtnAnnuler().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f2.setVisible(false);
				f1.setVisible(true);
			}
		});
		
		
		f2.getBtnRetirer().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int ingredientIndex = f2.getComboBoxRetirer().getSelectedIndex();
				
				data.remove(ingredientIndex);
				
				IngredientsJTableModel modele = new IngredientsJTableModel(data);
				f2.getTable().setModel(modele);
				
				f2.getComboBoxRetirer().setModel(new DefaultComboBoxModel<>(data.toArray()));
				if(data.size()>0) {
					f2.getComboBoxRetirer().setSelectedIndex(0);
				}
				
			}
		});
		
		f2.getBtnConfirmer().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Confirmer la nouvelle pizza ?", "WARNING",
				        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					Pizza pizza = new Pizza();
					pizza.setNomPizza(f2.getTextPaneNomPizza().getText());
					pizza.setPrixBase(Float.parseFloat(f2.getTextPanePrixBase().getText()));
					daopizza.addPizza(pizza, data);
					f2.setVisible(false);
					f1.setVisible(true);
				}
			}
		});
		
		f2.getBtnNouvelIngredient().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f2.setVisible(false);
				new ControleurNouvelIngredient(f1, f2, new FenetreNouvelIngredient(), connectedUser, daopizza);
			}
		});
	}


}
