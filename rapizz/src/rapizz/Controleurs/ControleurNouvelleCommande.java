package rapizz.Controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import rapizz.Commande;
import rapizz.CommandePizzasJTableModel;
import rapizz.CommandesJTableModel;
import rapizz.DAOCommande;
import rapizz.DAOPizza;
import rapizz.DAOUser;
import rapizz.Pizza;
import rapizz.PizzasJTableModel;
import rapizz.User;
import rapizz.Fenetres.FenetreAccueilClient;
import rapizz.Fenetres.FenetreLogin;
import rapizz.Fenetres.FenetreNouvelleCommande;

import java.sql.Timestamp;

public class ControleurNouvelleCommande {
	private User connectedUser;
	private float total = 0;
	private static DecimalFormat df = new DecimalFormat("0.00");
	
	public ControleurNouvelleCommande(FenetreLogin f0, FenetreAccueilClient f1, FenetreNouvelleCommande f2, DAOUser daouser, User user, DAOCommande daocommande, DAOPizza daopizza) {
		this.connectedUser = user;
		
		List<Pizza> pizzasObj = daopizza.getAllPizzas();
		List<String> pizzas = new ArrayList<>();
		
		for (Pizza p : pizzasObj) {
			String pizza = p.getNomPizza()+" : "+daopizza.getIngredientsPizza(p.getIdPizza())+" => "+p.getPrixBase()+" €";
			pizzas.add(pizza);
		}
		
		f2.getComboBoxPizzas().setModel(new DefaultComboBoxModel<>(pizzas.toArray()));
		f2.getComboBoxPizzas().setSelectedIndex(0);
		
		List<String> tailles = new ArrayList<>();
		tailles.add("Naine");
		tailles.add("Humaine");
		tailles.add("Ogresse");
		
		f2.getComboBoxTaille().setModel(new DefaultComboBoxModel<>(tailles.toArray()));
		f2.getComboBoxTaille().setSelectedIndex(0);
		
		
		List<Pizza> data = new ArrayList<>();
		List<String> correspondingSizes= new ArrayList<>();
		List<Float> correspondingPrices= new ArrayList<>();
		
		f2.setVisible(true);
		
		f2.getBtnAjouter().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int pizzaIndex = f2.getComboBoxPizzas().getSelectedIndex();
				int tailleIndex = f2.getComboBoxTaille().getSelectedIndex();
				
				Pizza pizzaSelectionnee = pizzasObj.get(pizzaIndex);
				float prix = daopizza.getPrixPizza(pizzaSelectionnee.getIdPizza(), tailles.get(tailleIndex));
				
				total += prix;
				f2.getTextPaneTotal().setText(df.format(total));
				
				data.add(pizzaSelectionnee);
				correspondingSizes.add(tailles.get(tailleIndex));
				correspondingPrices.add(prix);
				
				CommandePizzasJTableModel modele = new CommandePizzasJTableModel(data, correspondingSizes, correspondingPrices, daopizza);
				f2.getTable().setModel(modele);
				
				List<String> pizzaInfos =  new ArrayList<>();
				for (int i=0; i<data.size(); i++) {
					String s = data.get(i).getNomPizza()+" "+correspondingSizes.get(i)+", "+correspondingPrices.get(i);
					pizzaInfos.add(s);
				}
				
				f2.getComboBoxRetirer().setModel(new DefaultComboBoxModel<>(pizzaInfos.toArray()));
				if(pizzaInfos.size()>0) {
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
		
		
		f2.getBtnRetirerDuPanier().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int pizzaIndex = f2.getComboBoxRetirer().getSelectedIndex();
				
				data.remove(pizzaIndex);
				correspondingSizes.remove(pizzaIndex);
				
				total -= correspondingPrices.get(pizzaIndex);
				correspondingPrices.remove(pizzaIndex);
				
				f2.getTextPaneTotal().setText(df.format(total));
				
				CommandePizzasJTableModel modele = new CommandePizzasJTableModel(data, correspondingSizes, correspondingPrices, daopizza);
				f2.getTable().setModel(modele);
				
				List<String> pizzaInfos =  new ArrayList<>();
				for (int i=0; i<data.size(); i++) {
					String s = data.get(i).getNomPizza()+" "+correspondingSizes.get(i)+", "+correspondingPrices.get(i);
					pizzaInfos.add(s);
				}
				
				f2.getComboBoxRetirer().setModel(new DefaultComboBoxModel<>(pizzaInfos.toArray()));
				if(pizzaInfos.size()>0) {
					f2.getComboBoxRetirer().setSelectedIndex(0);
				}
				
			}
		});
		
		f2.getBtnCommander().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Confirmer la commande ?", "WARNING",
				        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					if(user.getSolde() >= total) {
						f2.setVisible(false);
						Commande commande = new Commande();
						commande.setIdClient(user.getId());
						commande.setDateCommande(new Timestamp(System.currentTimeMillis()));
						commande.setMontantCommande(total);
						daocommande.addCommande(commande, data, correspondingSizes);
						new ControleurAccueilClient(f0, f1, daouser, connectedUser, daocommande, daopizza);
					} else {
						JOptionPane.showMessageDialog(f2, "Solde insuffisant !");
					}
					
				}
			}
		});
	}

}
