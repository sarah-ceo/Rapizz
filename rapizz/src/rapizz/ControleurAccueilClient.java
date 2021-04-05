package rapizz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControleurAccueilClient {
	
	private User connectedUser;
	
	public ControleurAccueilClient(FenetreLogin f0, FenetreAccueilClient f1, DAOUser daouser, User user) {
		this.connectedUser = user;
		
		f1.getTextPaneSolde().setText(Float.toString(this.connectedUser.getSolde()));
		f1.getTextPaneNom().setText(this.connectedUser.getNom());
		f1.getTextPanePrenom().setText(this.connectedUser.getPrenom());
		f1.getTextPaneAdresseLivraison().setText(this.connectedUser.getAdresse());
		f1.getTextPaneAdresseMail().setText(this.connectedUser.getLogin());
		
		f1.setVisible(true);
		
		f1.getBtnModifierLesInformations().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f1.setVisible(false);
				ControleurUpdateClient ctrlI = new ControleurUpdateClient(f0, f1, new FenetreUpdateClient(), daouser, user);
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
