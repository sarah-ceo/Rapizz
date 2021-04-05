package rapizz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControleurUpdateClient {
	
	private User connectedUser;
	
	public ControleurUpdateClient(FenetreLogin f0, FenetreAccueilClient f1, FenetreUpdateClient f2, DAOUser daouser, User user) {
		this.connectedUser = user;
		
		f2.getTextAreaNom().setText(this.connectedUser.getNom());
		f2.getTextAreaPrenom().setText(this.connectedUser.getPrenom());
		f2.getTextAreaAdresseLivraison().setText(this.connectedUser.getAdresse());
		f2.getTextAreaLogin().setText(this.connectedUser.getLogin());
		
		f2.setVisible(true);
		
		f2.getBtnConfirmer().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				connectedUser.setNom(f2.getTextAreaNom().getText());
				connectedUser.setPrenom(f2.getTextAreaPrenom().getText());
				connectedUser.setAdresse(f2.getTextAreaAdresseLivraison().getText());
				connectedUser.setLogin(f2.getTextAreaLogin().getText());
				connectedUser.setPassword(f2.getPasswordField().getText());
				daouser.UpdateClientInformations(connectedUser);
				f2.setVisible(false);
				ControleurAccueilClient ctrlC = new ControleurAccueilClient(f0, new FenetreAccueilClient(), daouser, connectedUser);
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
