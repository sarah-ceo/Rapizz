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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FenetreAccueilAdmin extends JFrame {
	
	private JTable tableClients;
	private JTable tableLivreurs;
	private JTable tablePizzas;
	private JTable tableIngredients;
	private JPanel contentPane;
	private JButton btnDeconnexion;
	private JButton btnNouvellePizza;
	private JButton btnFichesLivraison;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JPanel panel_1;
	private JScrollPane scrollPane_1;
	private JPanel panel_2;
	private JScrollPane scrollPane_2;
	private JPanel panel_3;
	private JScrollPane scrollPane_3;
	private JLabel lblChiffreDaffaires;
	private JTextField textPaneCA;
	private JLabel lblClients;
	private JLabel lblLivreurs;
	private JLabel lblPizzas;
	private JLabel lblIngrdients;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreAccueilAdmin frame = new FenetreAccueilAdmin();
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
	public FenetreAccueilAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 300, 1000, 400);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStatistiques = new JLabel("Quelques statistiques");
		lblStatistiques.setBounds(356, 5, 286, 25);
		lblStatistiques.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblStatistiques.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblStatistiques);
		
		btnDeconnexion = new JButton("Deconnexion");
		btnDeconnexion.setBounds(10, 10, 117, 23);
		contentPane.add(btnDeconnexion);
		
		btnNouvellePizza = new JButton("Nouvelle Pizza");
		btnNouvellePizza.setBounds(801, 337, 183, 23);
		contentPane.add(btnNouvellePizza);
		
		btnFichesLivraison = new JButton("Fiches de livraison");
		btnFichesLivraison.setBounds(608, 337, 183, 23);
		contentPane.add(btnFichesLivraison);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 69, 280, 252);
		contentPane.add(panel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 270, 230);
		panel.add(scrollPane);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(279, 69, 257, 252);
		contentPane.add(panel_1);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 247, 230);
		panel_1.add(scrollPane_1);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(536, 69, 226, 252);
		contentPane.add(panel_2);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 11, 214, 230);
		panel_2.add(scrollPane_2);
		
		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(760, 69, 234, 252);
		contentPane.add(panel_3);
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 11, 214, 230);
		panel_3.add(scrollPane_3);
		
		lblChiffreDaffaires = new JLabel("Chiffre d'affaires :");
		lblChiffreDaffaires.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiffreDaffaires.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblChiffreDaffaires.setBounds(10, 341, 126, 17);
		contentPane.add(lblChiffreDaffaires);
		
		textPaneCA = new JTextField();
		textPaneCA.setBackground(Color.WHITE);
		textPaneCA.setHorizontalAlignment(SwingConstants.CENTER);
		textPaneCA.setEditable(false);
		textPaneCA.setBounds(134, 340, 112, 20);
		contentPane.add(textPaneCA);
		
		tableClients = new JTable();
		tableClients.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(tableClients);
		
		tableLivreurs = new JTable();
		tableLivreurs.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane_1.setViewportView(tableLivreurs);
		
		 tablePizzas = new JTable();
		 tablePizzas.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
				}
			));
			scrollPane_2.setViewportView(tablePizzas);
			
		tableIngredients = new JTable();
		tableIngredients.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane_3.setViewportView(tableIngredients);
		
		lblClients = new JLabel("Clients");
		lblClients.setHorizontalAlignment(SwingConstants.CENTER);
		lblClients.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblClients.setBounds(44, 44, 191, 25);
		contentPane.add(lblClients);
		
		lblLivreurs = new JLabel("Livreurs");
		lblLivreurs.setHorizontalAlignment(SwingConstants.CENTER);
		lblLivreurs.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLivreurs.setBounds(314, 44, 191, 25);
		contentPane.add(lblLivreurs);
		
		lblPizzas = new JLabel("Pizzas");
		lblPizzas.setHorizontalAlignment(SwingConstants.CENTER);
		lblPizzas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPizzas.setBounds(560, 44, 191, 25);
		contentPane.add(lblPizzas);
		
		lblIngrdients = new JLabel("Ingr\u00E9dients");
		lblIngrdients.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngrdients.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIngrdients.setBounds(780, 44, 191, 25);
		contentPane.add(lblIngrdients);
	
	}
	
	public JTable getTableClients() {
		return tableClients;
	}
	public JTable getTableLivreurs() {
		return tableLivreurs;
	}
	public JTable getTablePizzas() {
		return tablePizzas;
	}
	public JTable getTableIngredients() {
		return tableIngredients;
	}
	public JButton getBtnDeconnexion() {
		return btnDeconnexion;
	}
	public JButton getBtnNouvellePizza() {
		return btnNouvellePizza;
	}
	public JTextField getTextPaneCA() {
		return textPaneCA;
	}
	public JButton getBtnFichesLivraison() {
		return btnFichesLivraison;
	}
}
