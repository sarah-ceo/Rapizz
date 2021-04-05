package rapizz.Fenetres;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FenetreNouvelleCommande extends JFrame {
	
	private JTable table;
	private JPanel contentPane;
	private JLabel lblMontantTotal;
	private JTextField textPaneTotal;
	private JButton btnCommander;
	private JButton btnAnnuler;
	private JButton btnAjouter;
	private JComboBox comboBoxPizzas;
	private JComboBox comboBoxTaille;
	private JComboBox comboBoxRetirer;
	private JButton btnRetirerDuPanier;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreNouvelleCommande frame = new FenetreNouvelleCommande();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FenetreNouvelleCommande() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 300, 700, 400);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNouvelleCommande = new JLabel("Nouvelle commande");
		lblNouvelleCommande.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNouvelleCommande.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNouvelleCommande, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		lblMontantTotal = new JLabel("Total : ");
		lblMontantTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblMontantTotal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMontantTotal.setBounds(426, 162, 94, 17);
		panel.add(lblMontantTotal);
		
		textPaneTotal = new JTextField();
		textPaneTotal.setBackground(Color.WHITE);
		textPaneTotal.setHorizontalAlignment(SwingConstants.CENTER);
		textPaneTotal.setEditable(false);
		textPaneTotal.setBounds(546, 162, 128, 20);
		panel.add(textPaneTotal);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(20, 64, 302, 218);
		panel.add(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 282, 196);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(table);
		
		btnCommander = new JButton("Commander");
		btnCommander.setBounds(437, 214, 121, 23);
		panel.add(btnCommander);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(575, 214, 99, 23);
		panel.add(btnAnnuler);
		
		btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(575, 101, 99, 23);
		panel.add(btnAjouter);
		
		comboBoxPizzas = new JComboBox();
		comboBoxPizzas.setBounds(10, 24, 664, 25);
		panel.add(comboBoxPizzas);
		
		comboBoxTaille = new JComboBox();
		comboBoxTaille.setBounds(534, 64, 140, 20);
		panel.add(comboBoxTaille);
		
		comboBoxRetirer = new JComboBox();
		comboBoxRetirer.setBounds(20, 302, 154, 25);
		panel.add(comboBoxRetirer);
		
		btnRetirerDuPanier = new JButton("Retirer du panier");
		btnRetirerDuPanier.setBounds(182, 304, 140, 23);
		panel.add(btnRetirerDuPanier);
		
		ImageLabel bg = new ImageLabel(new ImageIcon("images/bg.png"));
		bg.setSize(225, 225);
		bg.setLocation(450, 70);
		panel.add(bg);
	}
	public JTable getTable() {
		return table;
	}
	public JButton getBtnCommander() {
		return btnCommander;
	}
	public JButton getBtnAnnuler() {
		return btnAnnuler;
	}
	public JTextField getTextPaneTotal() {
		return textPaneTotal;
	}
	public JComboBox getComboBoxPizzas() {
		return comboBoxPizzas;
	}
	public JComboBox getComboBoxTaille() {
		return comboBoxTaille;
	}
	public JButton getBtnAjouter() {
		return btnAjouter;
	}
	public JComboBox getComboBoxRetirer() {
		return comboBoxRetirer;
	}
	public JButton getBtnRetirerDuPanier() {
		return btnRetirerDuPanier;
	}
}
