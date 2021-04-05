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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FenetreAccueilLivreur  extends JFrame {
	
	private JTable table;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JButton btnSignalerRetard;
	private JButton btnModifierLesInformations;
	private JButton btnDeconnexion;
	private JLabel lblInformations;
	private JLabel labelNom;
	private JLabel labelPrenom;
	private JLabel labelAdresseMail;
	private JTextPane textPaneNom;
	private JTextPane textPanePrenom;
	private JTextPane textPaneAdresseMail;
	private JButton btnDetails;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreAccueilLivreur frame = new FenetreAccueilLivreur();
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
	public FenetreAccueilLivreur() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 700, 400);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLivraisons = new JLabel("Livraisons");
		lblLivraisons.setBounds(383, 70, 286, 25);
		lblLivraisons.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLivraisons.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblLivraisons);
		
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
		
		btnSignalerRetard = new JButton("Signaler un retard");
		btnSignalerRetard.setBounds(385, 335, 183, 23);
		contentPane.add(btnSignalerRetard);
		
		btnModifierLesInformations = new JButton("Modifier les informations");
		btnModifierLesInformations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModifierLesInformations.setBounds(70, 276, 209, 23);
		contentPane.add(btnModifierLesInformations);
		
		lblInformations = new JLabel("Informations");
		lblInformations.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformations.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInformations.setBounds(20, 70, 286, 25);
		contentPane.add(lblInformations);
		
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
		
		labelAdresseMail = new JLabel("Adresse e-mail :");
		labelAdresseMail.setHorizontalAlignment(SwingConstants.CENTER);
		labelAdresseMail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelAdresseMail.setBounds(0, 212, 164, 27);
		contentPane.add(labelAdresseMail);
		
		textPaneNom = new JTextPane();
		textPaneNom.setBounds(157, 128, 168, 20);
		contentPane.add(textPaneNom);
		
		textPanePrenom = new JTextPane();
		textPanePrenom.setBounds(157, 171, 168, 20);
		contentPane.add(textPanePrenom);
		
		textPaneAdresseMail = new JTextPane();
		textPaneAdresseMail.setBounds(157, 224, 168, 20);
		contentPane.add(textPaneAdresseMail);
		
		btnDetails = new JButton("Details");
		btnDetails.setBounds(579, 335, 90, 23);
		contentPane.add(btnDetails);
	}
	
	public JTable getTable() {
		return table;
	}
	public JButton getBtnAjouterUneVisite() {
		return btnSignalerRetard;
	}
	public JButton getBtnModifierLeStatut() {
		return btnModifierLesInformations;
	}
	public JButton getBtnDeconnexion() {
		return btnDeconnexion;
	}
}
