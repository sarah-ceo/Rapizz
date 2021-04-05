package rapizz.Controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JOptionPane;

import rapizz.DAOCommande;
import rapizz.DAOPizza;
import rapizz.DAOUser;
import rapizz.User;
import rapizz.Fenetres.FenetreAccueilClient;
import rapizz.Fenetres.FenetreLogin;
import rapizz.Fenetres.FenetreUpdateClient;

public class ControleurUpdateClient {
	
	private User connectedUser;
	
	public ControleurUpdateClient(FenetreLogin f0, FenetreAccueilClient f1, FenetreUpdateClient f2, DAOUser daouser, User user, DAOCommande daocommande, DAOPizza daopizza) {
		this.connectedUser = user;
		
		f2.getTextAreaNom().setText(this.connectedUser.getNom());
		f2.getTextAreaPrenom().setText(this.connectedUser.getPrenom());
		f2.getTextAreaAdresseLivraison().setText(this.connectedUser.getAdresse());
		f2.getTextAreaLogin().setText(this.connectedUser.getLogin());
		f2.getPasswordField().setText(this.connectedUser.getPassword());
		f2.getPasswordFieldConfirmation().setText(this.connectedUser.getPassword());
		
		f2.setVisible(true);
		
		f2.getBtnConfirmer().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String password=String.valueOf(f2.getPasswordField().getPassword());
				String passwordConfirmation=String.valueOf(f2.getPasswordFieldConfirmation().getPassword());

				if(password.equals(passwordConfirmation)) {
					connectedUser.setNom(f2.getTextAreaNom().getText());
					connectedUser.setPrenom(f2.getTextAreaPrenom().getText());
					connectedUser.setAdresse(f2.getTextAreaAdresseLivraison().getText());
					connectedUser.setLogin(f2.getTextAreaLogin().getText());
					connectedUser.setPassword(password);
					daouser.UpdateClientInformations(connectedUser);
					f2.setVisible(false);
					ControleurAccueilClient ctrlC = new ControleurAccueilClient(f0, new FenetreAccueilClient(), daouser, connectedUser, daocommande, daopizza);
				}else {
					JOptionPane.showMessageDialog(f1, "Les mots de passe ne sont pas identiques !");
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
	}
}
