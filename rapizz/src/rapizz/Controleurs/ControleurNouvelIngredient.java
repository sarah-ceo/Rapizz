package rapizz.Controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import rapizz.DAOPizza;
import rapizz.User;
import rapizz.Fenetres.FenetreAccueilAdmin;
import rapizz.Fenetres.FenetreNouvelIngredient;
import rapizz.Fenetres.FenetreNouvellePizza;

public class ControleurNouvelIngredient {
	
	private User connectedUser;
	
	public ControleurNouvelIngredient(FenetreAccueilAdmin f1, FenetreNouvellePizza f2, FenetreNouvelIngredient f3, User user, DAOPizza daopizza) {
		this.connectedUser = user;
		
		f3.setVisible(true);
		
		f3.getBtnAnnuler().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f3.setVisible(false);
				f2.setVisible(true);
			}
		});
		
		f3.getBtnConfirmer().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				daopizza.addIngredient(f3.getTextAreaNomIngredient().getText());
				f3.setVisible(false);
				new ControleurNouvellePizza(f1, new FenetreNouvellePizza(), user, daopizza);
			}
		});
	}

}
