package rapizz;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class PizzasJTableModel extends DefaultTableModel {

	List<Pizza> data;
	DAOPizza daopizza;
	int idCommande;
	String[] nomColonnes = {"Pizza", "Taille", "Prix"};
	int taille=0;
	
	public PizzasJTableModel(List<Pizza> l,  int idCommande, DAOPizza daop) {
		data = l;
		taille = data.size();
		this.daopizza = daop;
		this.idCommande = idCommande;
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
		String taillePizza = this.daopizza.getPizzaTaille(this.idCommande, pizza.getIdPizza());
		Object val=null;
		switch(column) {
		case 0:
			val= pizza.getNomPizza();
			break;
		case 1:
			val = taillePizza;
			break;
		case 2:
			val = daopizza.getPrixPizza(pizza.getIdPizza(), taillePizza);
			break;
		}
		return val;
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		return false;
	}

}
