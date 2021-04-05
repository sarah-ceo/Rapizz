package rapizz.Controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JOptionPane;

import rapizz.DAOUser;
import rapizz.Fenetres.FenetreInscription;
import rapizz.Fenetres.FenetreLogin;

public class ControleurInscription {
	
	public ControleurInscription(FenetreLogin f0, FenetreInscription f1, DAOUser daouser) {
		
		f1.setVisible(true);
		
		f1.getBtnAnnuler().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f1.setVisible(false);
				f0.setVisible(true);
			}
		});
		
		f1.getBtnConfirmer().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String password=String.valueOf(f1.getPasswordField().getPassword());
				String passwordConfirmation=String.valueOf(f1.getPasswordFieldConfirmation().getPassword());
				
				if(password.equals(passwordConfirmation)) {
					f1.setVisible(false);
					daouser.addClient(f1.getTextAreaNom().getText(), f1.getTextAreaPrenom().getText(), f1.getTextAreaAdresseLivraison().getText()+" "+f1.getTextAreaCodePostal().getText()+" "+f1.getTextAreaVille().getText(), 
							f1.getTextAreaLogin().getText(), password);
					f0.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(f1, "Les mots de passe ne sont pas identiques !");
				}
			}
		});
		
	}
}
