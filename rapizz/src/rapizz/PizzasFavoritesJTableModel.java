package rapizz;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class PizzasFavoritesJTableModel extends DefaultTableModel {
		
		List<String[]> data;
		String[] nomColonnes = {"Pizza", "Commandée"};
		int taille=0;
		
		public PizzasFavoritesJTableModel(List<String[]> l) {
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
			String[] pizza = data.get(row);
			Object val=null;
			switch(column) {
			case 0:
				val= pizza[0];
				break;
			case 1:
				val = pizza[1];
				break;
			}
			return val;
		}

		@Override
		public boolean isCellEditable(int arg0, int arg1) {
			return false;
		}

}
