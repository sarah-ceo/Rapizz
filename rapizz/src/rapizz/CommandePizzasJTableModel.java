package rapizz;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class CommandePizzasJTableModel extends DefaultTableModel {
	
	List<Pizza> data;
	List<String> sizes;
	List<Float> prices;
	DAOPizza daopizza;
	String[] nomColonnes = {"Pizza", "Taille", "Prix"};
	int taille=0;
	
	public CommandePizzasJTableModel(List<Pizza> l, List<String> s, List<Float> p, DAOPizza daop) {
		data = l;
		sizes = s;
		prices = p;
		taille = data.size();
		this.daopizza = daop;
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
		Pizza pizza = data.get(row);
		String taille = sizes.get(row);
		float prix = prices.get(row);
		
		Object val=null;
		switch(column) {
		case 0:
			val= pizza.getNomPizza();
			break;
		case 1:
			val = taille;
			break;
		case 2:
			val = prix;
			break;
		}
		return val;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

}
