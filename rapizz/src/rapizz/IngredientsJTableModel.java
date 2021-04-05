package rapizz;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class IngredientsJTableModel extends DefaultTableModel {
		
	List<String> data;
	String[] nomColonnes = {"Ingredient"};
	int taille=0;
	
	public IngredientsJTableModel(List<String> l) {
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
		String ingredient = data.get(row);
		
		Object val=null;
		switch(column) {
		case 0:
			val= ingredient;
			break;
		}
		return val;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
}
