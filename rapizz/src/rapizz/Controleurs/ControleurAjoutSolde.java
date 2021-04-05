package rapizz.Controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import rapizz.DAOCommande;
import rapizz.DAOPizza;
import rapizz.DAOUser;
import rapizz.User;
import rapizz.Fenetres.FenetreAccueilClient;
import rapizz.Fenetres.FenetreAjoutSolde;
import rapizz.Fenetres.FenetreLogin;

public class ControleurAjoutSolde {
	private User connectedUser;
	
	public ControleurAjoutSolde(FenetreLogin f0, FenetreAccueilClient f1, FenetreAjoutSolde f2, DAOUser daouser, User user, DAOCommande daocommande, DAOPizza daopizza) {
		this.connectedUser = user;
		
		f2.setVisible(true);
		
		f2.getBtnConfirmer().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				connectedUser.setSolde(connectedUser.getSolde()+Float.parseFloat(f2.getTextAreaMontant().getText()));
				daouser.UpdateSoldeClient(connectedUser);
				f2.setVisible(false);
				ControleurAccueilClient ctrlC = new ControleurAccueilClient(f0, new FenetreAccueilClient(), daouser, connectedUser, daocommande, daopizza);
			}
		});
		
		f2.getBtnAnnuler().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f2.setVisible(false);
				f1.setVisible(true);
			}
		});
	}
}
