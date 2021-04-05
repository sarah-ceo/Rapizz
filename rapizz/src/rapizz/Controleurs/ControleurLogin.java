package rapizz.Controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import rapizz.DAOCommande;
import rapizz.DAOPizza;
import rapizz.DAOUser;
import rapizz.Singleton;
import rapizz.User;
import rapizz.Fenetres.FenetreAccueilAdmin;
import rapizz.Fenetres.FenetreAccueilClient;
import rapizz.Fenetres.FenetreAccueilLivreur;
import rapizz.Fenetres.FenetreInscription;
import rapizz.Fenetres.FenetreLogin;

public class ControleurLogin {
	FenetreLogin f0;
	DAOUser daouser;
	User connectedUser;
	
	public ControleurLogin(FenetreLogin f0, DAOUser daouser) {
		super();
		this.f0 = f0;
		this.daouser = daouser;
		
		List<String> statuts = new ArrayList<>();
		statuts.add("Client");
		statuts.add("Livreur");
		statuts.add("Administrateur");
		
		f0.getComboBox().setModel(new DefaultComboBoxModel<>(statuts.toArray()));
		
		f0.setVisible(true);
		
		f0.getBtnConnexion().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String email = f0.getTxtLogin().getText();
				char[] motdepasseField = f0.getPasswordField().getPassword();
				String motdepasse = String.valueOf(motdepasseField);
				String statut = f0.getComboBox().getSelectedItem().toString();
				
				connectedUser = daouser.checkAuth(statut, email, motdepasse);
				
				if (connectedUser.getId() == 0) {
					JOptionPane.showMessageDialog(f0, "Email ou mot de passe incorrect !");
				} else {
					f0.setVisible(false);
					DAOCommande daocommande = new DAOCommande(Singleton.getInstance().getConnection());
					DAOPizza daopizza = new DAOPizza(Singleton.getInstance().getConnection());
					switch(statut) {
						case "Client":
							ControleurAccueilClient ctrlC = new ControleurAccueilClient(f0, new FenetreAccueilClient(), daouser, connectedUser, daocommande, daopizza);
							break;
						case "Livreur":
							ControleurAccueilLivreur ctrlL = new ControleurAccueilLivreur(f0, new FenetreAccueilLivreur(), daouser, connectedUser, daocommande);
							break;
						case "Administrateur":
							ControleurAccueilAdministrateur ctrlA = new ControleurAccueilAdministrateur(f0, new FenetreAccueilAdmin(), daouser, connectedUser, daocommande, daopizza);
							break;
					}
				}
				
			}
			});
		
		f0.getBtnInscription().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f0.setVisible(false);
				ControleurInscription ctrlI = new ControleurInscription(f0, new FenetreInscription(), daouser);
			}
		});
	}
}
