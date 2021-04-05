package rapizz;

import javax.swing.UIManager;

import rapizz.Controleurs.ControleurLogin;
import rapizz.Fenetres.FenetreLogin;

public class main {

	public static void main(String[] args) {
		UIManager.put("OptionPane.noButtonText", "Non");
	    UIManager.put("OptionPane.yesButtonText", "Oui");
	    ControleurLogin ctrl1 = new ControleurLogin(new FenetreLogin(), new DAOUser(Singleton.getInstance().getConnection())); 
	}

}
