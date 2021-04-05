package rapizz.Fenetres;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class FenetreUpdateClient extends JFrame {

private JPanel contentPane;
	private JTextField textAreaNom;
	private JTextField textAreaPrenom;
	private JTextField textAreaAdresseLivraison;
	private JTextField textAreaLogin;
	private JButton btnConfirmer;
	private JButton btnAnnuler;
	private JPasswordField passwordField;
	private JLabel labelConfirmerMotDePasse;
	private JPasswordField passwordFieldConfirmation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreUpdateClient frame = new FenetreUpdateClient();
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
	public FenetreUpdateClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 300, 700, 400);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblMettreAJour = new JLabel("Mettre \u00E0 jour les informations");
		lblMettreAJour.setHorizontalAlignment(SwingConstants.CENTER);
		lblMettreAJour.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblMettreAJour, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textAreaNom = new JTextField();
		textAreaNom.setBackground(Color.WHITE);
		textAreaNom.setHorizontalAlignment(SwingConstants.CENTER);
		textAreaNom.setBounds(215, 40, 150, 30);
		panel.add(textAreaNom);
		
		textAreaPrenom = new JTextField();
		textAreaPrenom.setBackground(Color.WHITE);
		textAreaPrenom.setHorizontalAlignment(SwingConstants.CENTER);
		textAreaPrenom.setBounds(488, 40, 186, 30);
		panel.add(textAreaPrenom);
		
		textAreaAdresseLivraison = new JTextField();
		textAreaAdresseLivraison.setBackground(Color.WHITE);
		textAreaAdresseLivraison.setHorizontalAlignment(SwingConstants.CENTER);
		textAreaAdresseLivraison.setBounds(210, 110, 429, 30);
		panel.add(textAreaAdresseLivraison);
		
		textAreaLogin = new JTextField();
		textAreaLogin.setBackground(Color.WHITE);
		textAreaLogin.setHorizontalAlignment(SwingConstants.CENTER);
		textAreaLogin.setBounds(212, 179, 380, 30);
		panel.add(textAreaLogin);
		
		JLabel lblPrenom = new JLabel("Pr\u00E9nom :");
		lblPrenom.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrenom.setBounds(339, 38, 150, 30);
		panel.add(lblPrenom);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setHorizontalAlignment(SwingConstants.CENTER);
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNom.setBounds(55, 38, 113, 30);
		panel.add(lblNom);
		
		JLabel lblAdresseLivraison = new JLabel("Adresse de livraison :");
		lblAdresseLivraison.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdresseLivraison.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdresseLivraison.setBounds(10, 113, 207, 27);
		panel.add(lblAdresseLivraison);
		
		JLabel lblAdresseMail = new JLabel("Adresse e-mail :");
		lblAdresseMail.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdresseMail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdresseMail.setBounds(27, 179, 164, 27);
		panel.add(lblAdresseMail);
		
		btnConfirmer = new JButton("Confirmer");
		btnConfirmer.setBounds(176, 303, 138, 23);
		panel.add(btnConfirmer);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(392, 303, 150, 23);
		panel.add(btnAnnuler);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setHorizontalAlignment(SwingConstants.CENTER);
		lblMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMotDePasse.setBounds(27, 253, 164, 27);
		panel.add(lblMotDePasse);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(210, 248, 170, 30);
		panel.add(passwordField);
		
		labelConfirmerMotDePasse = new JLabel("Confirmer :");
		labelConfirmerMotDePasse.setHorizontalAlignment(SwingConstants.CENTER);
		labelConfirmerMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelConfirmerMotDePasse.setBounds(366, 253, 123, 27);
		panel.add(labelConfirmerMotDePasse);
		
		passwordFieldConfirmation = new JPasswordField();
		passwordFieldConfirmation.setHorizontalAlignment(SwingConstants.CENTER);
		passwordFieldConfirmation.setBounds(483, 248, 170, 30);
		panel.add(passwordFieldConfirmation);
		
		ImageLabel bg = new ImageLabel(new ImageIcon("images/bg.png"));
		bg.setSize(225, 225);
		bg.setLocation(250, 50);
		panel.add(bg);
	}
	public JButton getBtnConfirmer() {
		return btnConfirmer;
	}
	public JButton getBtnAnnuler() {
		return btnAnnuler;
	}

	public JTextField getTextAreaNom() {
		return textAreaNom;
	}
	public JTextField getTextAreaPrenom() {
		return textAreaPrenom;
	}
	public JTextField getTextAreaAdresseLivraison() {
		return textAreaAdresseLivraison;
	}
	public JTextField getTextAreaLogin() {
		return textAreaLogin;
	}
	public JPasswordField getPasswordField() {
		return passwordField;
	}
	public JPasswordField getPasswordFieldConfirmation() {
		return passwordFieldConfirmation;
	}
}
