package rapizz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControleurAccueilAdministrateur {
	
	private User connectedUser;
	
	public ControleurAccueilAdministrateur(FenetreLogin f0, FenetreAccueilAdmin f1, User user) {
		this.connectedUser = user;
		
		f1.setVisible(true);
		
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
