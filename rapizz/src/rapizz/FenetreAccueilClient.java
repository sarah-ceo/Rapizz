package rapizz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
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
	private JTextPane textPaneNom;
	private JTextPane textPanePrenom;
	private JTextPane textPaneAdresseLivraison;
	private JTextPane textPaneAdresseMail;
	private JButton buttonAjoutSolde;
	private JButton btnDetails;
	private JTextPane textPaneSolde;

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
		setBounds(150, 150, 700, 400);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCommandes = new JLabel("Commandes");
		lblCommandes.setBounds(383, 70, 286, 25);
		lblCommandes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCommandes.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblCommandes);
		
		btnDeconnexion = new JButton("Deconnexion");
		btnDeconnexion.setBounds(10, 10, 117, 23);
		contentPane.add(btnDeconnexion);
		
		JPanel panel = new JPanel();
		panel.setBounds(375, 117, 309, 213);
		contentPane.add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 289, 191);
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
		btnModifierLesInformations.setBounds(70, 335, 209, 23);
		contentPane.add(btnModifierLesInformations);
		
		lblInformations = new JLabel("Informations");
		lblInformations.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformations.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInformations.setBounds(20, 70, 286, 25);
		contentPane.add(lblInformations);
		
		lblSolde = new JLabel("Solde :");
		lblSolde.setHorizontalAlignment(SwingConstants.CENTER);
		lblSolde.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSolde.setBounds(183, 8, 123, 25);
		contentPane.add(lblSolde);
		
		textPaneSolde = new JTextPane();
		textPaneSolde.setText("0");
		textPaneSolde.setBounds(318, 13, 89, 20);
		contentPane.add(textPaneSolde);
		
		labelNom = new JLabel("Nom :");
		labelNom.setHorizontalAlignment(SwingConstants.CENTER);
		labelNom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelNom.setBounds(34, 120, 113, 30);
		contentPane.add(labelNom);
		
		labelPrenom = new JLabel("Pr\u00E9nom :");
		labelPrenom.setHorizontalAlignment(SwingConstants.CENTER);
		labelPrenom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelPrenom.setBounds(14, 161, 150, 30);
		contentPane.add(labelPrenom);
		
		labelAdresseLivraison = new JLabel("Adresse de livraison :");
		labelAdresseLivraison.setHorizontalAlignment(SwingConstants.CENTER);
		labelAdresseLivraison.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelAdresseLivraison.setBounds(0, 223, 164, 27);
		contentPane.add(labelAdresseLivraison);
		
		labelAdresseMail = new JLabel("Adresse e-mail :");
		labelAdresseMail.setHorizontalAlignment(SwingConstants.CENTER);
		labelAdresseMail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelAdresseMail.setBounds(0, 282, 164, 27);
		contentPane.add(labelAdresseMail);
		
		textPaneNom = new JTextPane();
		textPaneNom.setBounds(157, 128, 168, 20);
		contentPane.add(textPaneNom);
		
		textPanePrenom = new JTextPane();
		textPanePrenom.setBounds(157, 171, 168, 20);
		contentPane.add(textPanePrenom);
		
		textPaneAdresseLivraison = new JTextPane();
		textPaneAdresseLivraison.setBounds(157, 209, 168, 58);
		contentPane.add(textPaneAdresseLivraison);
		
		textPaneAdresseMail = new JTextPane();
		textPaneAdresseMail.setBounds(157, 289, 168, 20);
		contentPane.add(textPaneAdresseMail);
		
		buttonAjoutSolde = new JButton("Ajouter du cr\u00E9dit");
		buttonAjoutSolde.setBounds(417, 10, 183, 23);
		contentPane.add(buttonAjoutSolde);
		
		btnDetails = new JButton("Details");
		btnDetails.setBounds(579, 335, 90, 23);
		contentPane.add(btnDetails);
	}
	
	public JTable getTable() {
		return table;
	}
	public JButton getBtnDeconnexion() {
		return btnDeconnexion;
	}
	public JTextPane getTextPaneSolde() {
		return textPaneSolde;
	}
	public JTextPane getTextPaneNom() {
		return textPaneNom;
	}
	public JTextPane getTextPanePrenom() {
		return textPanePrenom;
	}
	public JTextPane getTextPaneAdresseLivraison() {
		return textPaneAdresseLivraison;
	}
	public JTextPane getTextPaneAdresseMail() {
		return textPaneAdresseMail;
	}
	public JButton getBtnModifierLesInformations() {
		return btnModifierLesInformations;
	}
}
