package rapizz;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class CommandesJTableModel extends DefaultTableModel {
	
	List<Commande> data;
	DAOCommande daocommande;
	String[] nomColonnes = {"ID", "Date", "Montant", "Statut"};
	int taille=0;
	private static DecimalFormat df = new DecimalFormat("0.00");
	 
	public CommandesJTableModel(List<Commande> l,  DAOCommande daoc) {
		data = l;
		taille = data.size();
		daocommande = daoc;
	}
	
	@Override
	public int getColumnCount() {
		return nomColonnes.length;
	}

	@Override
	public String getColumnName(int column) {
		return nomColonnes[column];
	}

	@Override
	public int getRowCount() {
		return taille;
	}

	@Override
	public Object getValueAt(int row, int column) {
		Commande commande = data.get(row);
		Object val=null;
		switch(column) {
		case 0:
			val= commande.getIdCommande();
			break;
		case 1:
			val = new SimpleDateFormat("dd/MM/yyyy").format(commande.getDateCommande());
			break;
		case 2:
			val = df.format(commande.getMontantCommande());
			break;
		case 3:
			val = commande.getStatutCommande();
			break;
		}
		return val;
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		return false;
	}

}
