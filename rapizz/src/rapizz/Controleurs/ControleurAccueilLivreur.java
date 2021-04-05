package rapizz.Controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import rapizz.Commande;
import rapizz.CommandesJTableModel;
import rapizz.DAOCommande;
import rapizz.DAOUser;
import rapizz.LivreurCommandesJTableModel;
import rapizz.User;
import rapizz.Fenetres.FenetreAccueilLivreur;
import rapizz.Fenetres.FenetreLogin;
import rapizz.Fenetres.FenetreUpdateClient;
import rapizz.Fenetres.FenetreUpdateLivreur;
import rapizz.Fenetres.FenetreValidationLivraison;

public class ControleurAccueilLivreur {

	private User connectedUser;
	
	public ControleurAccueilLivreur(FenetreLogin f0, FenetreAccueilLivreur f1, DAOUser daouser, User user, DAOCommande daocommande) {
		this.connectedUser = user;
		
		f1.getTextPaneNom().setText(this.connectedUser.getNom());
		f1.getTextPanePrenom().setText(this.connectedUser.getPrenom());
		f1.getTextPaneAdresseMail().setText(this.connectedUser.getLogin());
		
		List<Commande> data = null; 
		data = daocommande.getUnfinishedCommandesByLivreur(user.getId());
		
		LivreurCommandesJTableModel modele = new LivreurCommandesJTableModel(data, daocommande);
		f1.getTable().setModel(modele);
		
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
		
		f1.getBtnModifierLesInformations().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f1.setVisible(false);
				new ControleurUpdateLivreur(f0, f1, new FenetreUpdateLivreur(), daouser, user, daocommande);
			}
		});
		
		f1.getBtnValiderUneLivraison().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f1.setVisible(false);
				new ControleurValidationLivraison(f0, f1, new FenetreValidationLivraison(), daouser, user, daocommande);
			}
		});
	}

}
