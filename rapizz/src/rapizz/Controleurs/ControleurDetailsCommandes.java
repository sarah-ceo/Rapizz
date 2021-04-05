package rapizz.Controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

import rapizz.Commande;
import rapizz.CommandesJTableModel;
import rapizz.DAOCommande;
import rapizz.DAOPizza;
import rapizz.DAOUser;
import rapizz.Pizza;
import rapizz.PizzasJTableModel;
import rapizz.User;
import rapizz.Fenetres.FenetreAccueilClient;
import rapizz.Fenetres.FenetreDetailsCommande;

public class ControleurDetailsCommandes {

	private User connectedUser;
	private static DecimalFormat df = new DecimalFormat("0.00");
	
	public ControleurDetailsCommandes(FenetreAccueilClient f1, FenetreDetailsCommande f2, DAOUser daouser, User user, DAOCommande daocommande, DAOPizza daopizza) {
		this.connectedUser = user;
		
		List<Commande> commandesObj = daocommande.getCommandesByClient(this.connectedUser.getId());
		List<String> commandes = new ArrayList<>();
		
		for (Commande c : commandesObj) {
			String dateCommande = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(c.getDateCommande());
			String commande = "Commande n°"+c.getIdCommande()+" du "+dateCommande+" : "+df.format(c.getMontantCommande())+" €";
			commandes.add(commande);
		}
		
		f2.getCbCommande().setModel(new DefaultComboBoxModel<>(commandes.toArray()));
		
		f2.setVisible(true);
		
		f2.getBtnActualiser().addActionListener(new ActionListener() {
			 
			@Override
			public void actionPerformed(ActionEvent e) {
				int commandeIndex = f2.getCbCommande().getSelectedIndex();
				if (commandeIndex>-1) {
					Commande commandeSelectionnee = commandesObj.get(commandeIndex);
					
					f2.getTextPaneIdCommande().setText(Integer.toString(commandeSelectionnee.getIdCommande()));
					f2.getTextPaneDateCommande().setText(new SimpleDateFormat("dd/MM/yyyy HH:mm").format(commandeSelectionnee.getDateCommande()));
					f2.getTextPaneTempsLivraison().setText(commandeSelectionnee.getTempsLivraison()+" minutes");
					f2.getTextPaneBonification().setText(commandeSelectionnee.getBonification());
					f2.getTextPaneMontantTotal().setText(df.format(commandeSelectionnee.getMontantCommande()));
					
					List<Pizza> data = null;
					data = daopizza.getPizzasByCommande(commandeSelectionnee.getIdCommande());
					
					PizzasJTableModel modele = new PizzasJTableModel(data,  commandeSelectionnee.getIdCommande(), daopizza);
					f2.getTable().setModel(modele);
				}
				
			}
		});
		
		f2.getBtnOK().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f2.setVisible(false);
				f1.setVisible(true);
			}
		});
	}
}
