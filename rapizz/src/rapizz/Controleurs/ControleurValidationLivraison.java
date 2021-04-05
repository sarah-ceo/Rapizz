package rapizz.Controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

import rapizz.Commande;
import rapizz.DAOCommande;
import rapizz.DAOUser;
import rapizz.Pizza;
import rapizz.PizzasJTableModel;
import rapizz.User;
import rapizz.Fenetres.FenetreAccueilLivreur;
import rapizz.Fenetres.FenetreLogin;
import rapizz.Fenetres.FenetreValidationLivraison;

public class ControleurValidationLivraison {
	private User connectedUser;
	private Commande commandeSelectionnee;
	private int tempsLivraison;

	public ControleurValidationLivraison(FenetreLogin f0, FenetreAccueilLivreur f1, FenetreValidationLivraison f2, DAOUser daouser, User user, DAOCommande daocommande) {
		this.connectedUser = user;
		
		List<Commande> commandesObj = daocommande.getUnfinishedCommandesByLivreur(this.connectedUser.getId());
		List<String> commandes = new ArrayList<>();
		
		for (Commande c : commandesObj) {
			String dateCommande = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(c.getDateCommande());
			String commande = "Commande n°"+c.getIdCommande()+" du "+dateCommande+" : "+daocommande.getAdresseClient(c.getIdCommande());
			commandes.add(commande);
		}
		
		f2.getCbCommande().setModel(new DefaultComboBoxModel<>(commandes.toArray()));
		
		f2.setVisible(true);
		
		f2.getBtnActualiser().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int commandeIndex = f2.getCbCommande().getSelectedIndex();
				if (commandeIndex>-1) {
					commandeSelectionnee = commandesObj.get(commandeIndex);
					
					f2.getLabelDateCommande().setText(new SimpleDateFormat("dd/MM/yyyy").format(commandeSelectionnee.getDateCommande()));
					f2.getLabelHeureCommande().setText(new SimpleDateFormat("HH:mm").format(commandeSelectionnee.getDateCommande()));
					f2.getLblCurrentHeure().setText(new SimpleDateFormat("HH:mm").format(new Timestamp(System.currentTimeMillis())));
					f2.getLabelAdresseLivraison().setText(daocommande.getAdresseClient(commandeSelectionnee.getIdCommande()));
					
					long oldTime = commandeSelectionnee.getDateCommande().getTime();
					long currentTime = new Timestamp(System.currentTimeMillis()).getTime();
					long diffMinutes = (currentTime - oldTime) / (60 * 1000);
					
					f2.getTextPaneTempsLivraison().setText(Long.toString(diffMinutes));
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
		
		f2.getBtnConfirmer().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f2.setVisible(false);
				daocommande.updateCommande(commandeSelectionnee.getIdCommande(), Integer.parseInt(f2.getTextPaneTempsLivraison().getText()));
				new ControleurAccueilLivreur(f0, new FenetreAccueilLivreur(), daouser, connectedUser, daocommande);
			}
		});
	}
}
