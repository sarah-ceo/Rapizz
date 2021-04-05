package rapizz.Fenetres;

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
import java.awt.Color;

public class FenetreAccueilLivreur  extends JFrame {
	
	private JTable table;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JButton btnValiderUneLivraison;
	private JButton btnModifierLesInformations;
	private JButton btnDeconnexion;
	private JLabel lblInformations;
	private JLabel labelNom;
	private JLabel labelPrenom;
	private JLabel labelAdresseMail;
	private JTextField textPaneNom;
	private JTextField textPanePrenom;
	private JTextField textPaneAdresseMail;

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
		setBounds(700, 300, 700, 400);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLivraisons = new JLabel("Livraisons en cours");
		lblLivraisons.setBounds(358, 70, 286, 25);
		lblLivraisons.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLivraisons.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblLivraisons);
		
		btnDeconnexion = new JButton("Deconnexion");
		btnDeconnexion.setBounds(10, 10, 117, 23);
		contentPane.add(btnDeconnexion);
		
		JPanel panel = new JPanel();
		panel.setBounds(326, 117, 358, 167);
		contentPane.add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 338, 145);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(table);
		
		btnValiderUneLivraison = new JButton("Valider une livraison");
		btnValiderUneLivraison.setBounds(360, 295, 284, 23);
		contentPane.add(btnValiderUneLivraison);
		
		btnModifierLesInformations = new JButton("Modifier les informations");
		btnModifierLesInformations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModifierLesInformations.setBounds(71, 291, 209, 23);
		contentPane.add(btnModifierLesInformations);
		
		lblInformations = new JLabel("Informations");
		lblInformations.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformations.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInformations.setBounds(29, 70, 286, 25);
		contentPane.add(lblInformations);
		
		labelNom = new JLabel("Nom :");
		labelNom.setHorizontalAlignment(SwingConstants.CENTER);
		labelNom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelNom.setBounds(10, 130, 113, 30);
		contentPane.add(labelNom);
		
		labelPrenom = new JLabel("Pr\u00E9nom :");
		labelPrenom.setHorizontalAlignment(SwingConstants.CENTER);
		labelPrenom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelPrenom.setBounds(0, 180, 150, 30);
		contentPane.add(labelPrenom);
		
		labelAdresseMail = new JLabel("Adresse e-mail :");
		labelAdresseMail.setHorizontalAlignment(SwingConstants.CENTER);
		labelAdresseMail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelAdresseMail.setBounds(0, 233, 150, 27);
		contentPane.add(labelAdresseMail);
		
		textPaneNom = new JTextField();
		textPaneNom.setBackground(Color.WHITE);
		textPaneNom.setHorizontalAlignment(SwingConstants.CENTER);
		textPaneNom.setEditable(false);
		textPaneNom.setBounds(137, 140, 168, 20);
		contentPane.add(textPaneNom);
		
		textPanePrenom = new JTextField();
		textPanePrenom.setBackground(Color.WHITE);
		textPanePrenom.setHorizontalAlignment(SwingConstants.CENTER);
		textPanePrenom.setEditable(false);
		textPanePrenom.setBounds(137, 190, 168, 20);
		contentPane.add(textPanePrenom);
		
		textPaneAdresseMail = new JTextField();
		textPaneAdresseMail.setBackground(Color.WHITE);
		textPaneAdresseMail.setHorizontalAlignment(SwingConstants.CENTER);
		textPaneAdresseMail.setEditable(false);
		textPaneAdresseMail.setBounds(137, 240, 168, 20);
		contentPane.add(textPaneAdresseMail);
		
		ImageLabel bg = new ImageLabel(new ImageIcon("images/bg.png"));
		bg.setSize(225, 225);
		bg.setLocation(70, 100);
		contentPane.add(bg);
	}
	
	public JTable getTable() {
		return table;
	}
	public JButton getBtnDeconnexion() {
		return btnDeconnexion;
	}
	public JTextField getTextPaneNom() {
		return textPaneNom;
	}
	public JTextField getTextPanePrenom() {
		return textPanePrenom;
	}
	public JTextField getTextPaneAdresseMail() {
		return textPaneAdresseMail;
	}
	public JButton getBtnModifierLesInformations() {
		return btnModifierLesInformations;
	}
	public JButton getBtnValiderUneLivraison() {
		return btnValiderUneLivraison;
	}
}
