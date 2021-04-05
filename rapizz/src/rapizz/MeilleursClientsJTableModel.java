package rapizz;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class MeilleursClientsJTableModel extends DefaultTableModel {

	List<String[]> data;
	String[] nomColonnes = {"Client", "Commandes", "Total"};
	int taille=0;
	
	public MeilleursClientsJTableModel(List<String[]> l) {
		data = l;
		taille = data.size();
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
		String[] client = data.get(row);
		Object val=null;
		switch(column) {
		case 0:
			val= client[0];
			break;
		case 1:
			val = client[1];
			break;
		case 2:
			val = client[2];
			break;
		}
		return val;
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		return false;
	}

}
