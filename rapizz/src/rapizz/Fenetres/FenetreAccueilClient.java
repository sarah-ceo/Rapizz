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

public class FenetreAccueilClient extends JFrame {
	
	private JTable table;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JButton btnNouvelleCommande;
	private JButton btnModifierLesInformations;
	private JButton btnDeconnexion;
	private JLabel lblInformations;
	private JLabel lblSolde;
	private JLabel labelNom;
	private JLabel labelPrenom;
	private JLabel labelAdresseLivraison;
	private JLabel labelAdresseMail;
	private JTextField textPaneNom;
	private JTextField textPanePrenom;
	private JTextField textPaneAdresseLivraison;
	private JTextField textPaneAdresseMail;
	private JButton buttonAjoutSolde;
	private JButton btnDetails;
	private JTextField textPaneSolde;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreAccueilClient frame = new FenetreAccueilClient();
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
	public FenetreAccueilClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 300, 700, 400);
		setResizable(false); 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCommandes = new JLabel("Commandes");
		lblCommandes.setBounds(385, 70, 286, 25);
		lblCommandes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCommandes.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblCommandes);
		
		btnDeconnexion = new JButton("Deconnexion");
		btnDeconnexion.setBounds(10, 10, 117, 23);
		contentPane.add(btnDeconnexion);
		
		JPanel panel = new JPanel();
		panel.setBounds(362, 106, 322, 213);
		contentPane.add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 302, 191);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(table);
		
		btnNouvelleCommande = new JButton("Nouvelle commande");
		btnNouvelleCommande.setBounds(385, 335, 183, 23);
		contentPane.add(btnNouvelleCommande);
		
		btnModifierLesInformations = new JButton("Modifier les informations");
		btnModifierLesInformations.setBounds(71, 335, 209, 23);
		contentPane.add(btnModifierLesInformations);
		
		lblInformations = new JLabel("Informations");
		lblInformations.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformations.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInformations.setBounds(71, 70, 191, 25);
		contentPane.add(lblInformations);
		
		lblSolde = new JLabel("Solde :");
		lblSolde.setHorizontalAlignment(SwingConstants.CENTER);
		lblSolde.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSolde.setBounds(183, 8, 123, 25);
		contentPane.add(lblSolde);
		
		textPaneSolde = new JTextField();
		textPaneSolde.setBackground(Color.WHITE);
		textPaneSolde.setHorizontalAlignment(SwingConstants.CENTER);
		textPaneSolde.setEditable(false);
		textPaneSolde.setText("0");
		textPaneSolde.setBounds(318, 13, 89, 20);
		contentPane.add(textPaneSolde);
		
		labelNom = new JLabel("Nom :");
		labelNom.setHorizontalAlignment(SwingConstants.CENTER);
		labelNom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelNom.setBounds(21, 117, 82, 30);
		contentPane.add(labelNom);
		
		labelPrenom = new JLabel("Pr\u00E9nom :");
		labelPrenom.setHorizontalAlignment(SwingConstants.CENTER);
		labelPrenom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelPrenom.setBounds(21, 158, 89, 30);
		contentPane.add(labelPrenom);
		
		labelAdresseLivraison = new JLabel("Adresse :");
		labelAdresseLivraison.setHorizontalAlignment(SwingConstants.CENTER);
		labelAdresseLivraison.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelAdresseLivraison.setBounds(21, 218, 82, 39);
		contentPane.add(labelAdresseLivraison);
		
		labelAdresseMail = new JLabel("Adresse e-mail :");
		labelAdresseMail.setHorizontalAlignment(SwingConstants.CENTER);
		labelAdresseMail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelAdresseMail.setBounds(0, 279, 128, 27);
		contentPane.add(labelAdresseMail);
		
		textPaneNom = new JTextField();
		textPaneNom.setBackground(Color.WHITE);
		textPaneNom.setHorizontalAlignment(SwingConstants.CENTER);
		textPaneNom.setEditable(false);
		textPaneNom.setBounds(121, 128, 195, 20);
		contentPane.add(textPaneNom);
		
		textPanePrenom = new JTextField();
		textPanePrenom.setBackground(Color.WHITE);
		textPanePrenom.setHorizontalAlignment(SwingConstants.CENTER);
		textPanePrenom.setEditable(false);
		textPanePrenom.setBounds(121, 168, 195, 20);
		contentPane.add(textPanePrenom);
		
		textPaneAdresseLivraison = new JTextField();
		textPaneAdresseLivraison.setBackground(Color.WHITE);
		textPaneAdresseLivraison.setHorizontalAlignment(SwingConstants.CENTER);
		textPaneAdresseLivraison.setEditable(false);
		textPaneAdresseLivraison.setBounds(121, 206, 195, 62);
		contentPane.add(textPaneAdresseLivraison);
		
		textPaneAdresseMail = new JTextField();
		textPaneAdresseMail.setBackground(Color.WHITE);
		textPaneAdresseMail.setHorizontalAlignment(SwingConstants.CENTER);
		textPaneAdresseMail.setEditable(false);
		textPaneAdresseMail.setBounds(121, 286, 195, 20);
		contentPane.add(textPaneAdresseMail);
		
		buttonAjoutSolde = new JButton("Ajouter du cr\u00E9dit");
		buttonAjoutSolde.setBounds(417, 10, 138, 23);
		contentPane.add(buttonAjoutSolde);
		
		btnDetails = new JButton("Details");
		btnDetails.setBounds(579, 335, 90, 23);
		contentPane.add(btnDetails);
		
		ImageLabel bg = new ImageLabel(new ImageIcon("images/bg.png"));
		bg.setSize(225, 225);
		bg.setLocation(75, 100);
		contentPane.add(bg);
	}
	
	public JTable getTable() {
		return table;
	}
	public JButton getBtnDeconnexion() {
		return btnDeconnexion;
	}
	public JTextField getTextPaneSolde() {
		return textPaneSolde;
	}
	public JTextField getTextPaneNom() {
		return textPaneNom;
	}
	public JTextField getTextPanePrenom() {
		return textPanePrenom;
	}
	public JTextField getTextPaneAdresseLivraison() {
		return textPaneAdresseLivraison;
	}
	public JTextField getTextPaneAdresseMail() {
		return textPaneAdresseMail;
	}
	public JButton getBtnModifierLesInformations() {
		return btnModifierLesInformations;
	}
	public JButton getButtonAjoutSolde() {
		return buttonAjoutSolde;
	}
	public JButton getBtnDetails() {
		return btnDetails;
	}
	public JButton getBtnNouvelleCommande() {
		return btnNouvelleCommande;
	}
}
