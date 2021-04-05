package rapizz.Controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.List;

import rapizz.Commande;
import rapizz.CommandesJTableModel;
import rapizz.DAOCommande;
import rapizz.DAOPizza;
import rapizz.DAOUser;
import rapizz.User;
import rapizz.Fenetres.FenetreAccueilClient;
import rapizz.Fenetres.FenetreAjoutSolde;
import rapizz.Fenetres.FenetreDetailsCommande;
import rapizz.Fenetres.FenetreLogin;
import rapizz.Fenetres.FenetreNouvelleCommande;
import rapizz.Fenetres.FenetreUpdateClient;

public class ControleurAccueilClient {
	
	private User connectedUser;
	private static DecimalFormat df = new DecimalFormat("0.00");
	
	public ControleurAccueilClient(FenetreLogin f0, FenetreAccueilClient f1, DAOUser daouser, User user, DAOCommande daocommande, DAOPizza daopizza) {
		this.connectedUser = user;
		
		f1.getTextPaneSolde().setText(df.format(this.connectedUser.getSolde()));
		f1.getTextPaneNom().setText(this.connectedUser.getNom());
		f1.getTextPanePrenom().setText(this.connectedUser.getPrenom());
		f1.getTextPaneAdresseLivraison().setText(this.connectedUser.getAdresse());
		f1.getTextPaneAdresseMail().setText(this.connectedUser.getLogin());
		
		List<Commande> data = null; 
		data = daocommande.getCommandesByClient(user.getId());
		
		CommandesJTableModel modele = new CommandesJTableModel(data, daocommande);
		f1.getTable().setModel(modele);
		
		f1.setVisible(true);
		
		f1.getBtnNouvelleCommande().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f1.setVisible(false);
				new ControleurNouvelleCommande(f0, f1, new FenetreNouvelleCommande(), daouser, user, daocommande, daopizza);
			}
			
		});
		
		f1.getBtnDetails().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f1.setVisible(false);
				new ControleurDetailsCommandes(f1, new FenetreDetailsCommande(), daouser, user, daocommande, daopizza);
			}
			
		});
		
		f1.getBtnModifierLesInformations().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f1.setVisible(false);
				new ControleurUpdateClient(f0, f1, new FenetreUpdateClient(), daouser, user, daocommande, daopizza);
			}
			
		});
		
		f1.getButtonAjoutSolde().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f1.setVisible(false);
				new ControleurAjoutSolde(f0, f1, new FenetreAjoutSolde(), daouser, user, daocommande, daopizza);
			}
			
		});
		
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
	}
}
