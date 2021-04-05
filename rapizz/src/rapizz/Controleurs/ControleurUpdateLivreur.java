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
import rapizz.Fenetres.FenetreAccueilLivreur;
import rapizz.Fenetres.FenetreLogin;
import rapizz.Fenetres.FenetreUpdateClient;
import rapizz.Fenetres.FenetreUpdateLivreur;

public class ControleurUpdateLivreur {
	
	private User connectedUser;
	
	public ControleurUpdateLivreur(FenetreLogin f0, FenetreAccueilLivreur f1, FenetreUpdateLivreur f2, DAOUser daouser, User user, DAOCommande daocommande) {
		this.connectedUser = user;
		
		f2.getTextAreaNom().setText(this.connectedUser.getNom());
		f2.getTextAreaPrenom().setText(this.connectedUser.getPrenom());
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
					connectedUser.setLogin(f2.getTextAreaLogin().getText());
					connectedUser.setPassword(password);
					daouser.UpdateLivreurInformations(connectedUser);
					f2.setVisible(false);
					new ControleurAccueilLivreur(f0, new FenetreAccueilLivreur(), daouser, connectedUser, daocommande);
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
