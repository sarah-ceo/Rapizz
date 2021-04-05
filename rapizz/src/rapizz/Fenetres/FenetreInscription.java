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

public class FenetreInscription extends JFrame {

private JPanel contentPane;
	private JTextField textAreaNom;
	private JTextField textAreaPrenom;
	private JTextField textAreaAdresseLivraison;
	private JTextField textAreaLogin;
	private JButton btnConfirmer;
	private JButton btnAnnuler;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldConfirmation;
	private JTextField textAreaCodePostal;
	private JTextField textAreaVille;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreInscription frame = new FenetreInscription();
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
	public FenetreInscription() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 300, 700, 400);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblCreerUnCompte = new JLabel("Cr\u00E9er un compte");
		lblCreerUnCompte.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreerUnCompte.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblCreerUnCompte, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textAreaNom = new JTextField();
		textAreaNom.setBackground(Color.WHITE);
		textAreaNom.setHorizontalAlignment(SwingConstants.CENTER);
		textAreaNom.setBounds(102, 28, 239, 23);
		panel.add(textAreaNom);
		
		textAreaPrenom = new JTextField();
		textAreaPrenom.setBackground(Color.WHITE);
		textAreaPrenom.setHorizontalAlignment(SwingConstants.CENTER);
		textAreaPrenom.setBounds(435, 28, 239, 23);
		panel.add(textAreaPrenom);
		
		textAreaAdresseLivraison = new JTextField();
		textAreaAdresseLivraison.setBackground(Color.WHITE);
		textAreaAdresseLivraison.setHorizontalAlignment(SwingConstants.CENTER);
		textAreaAdresseLivraison.setBounds(212, 85, 429, 30);
		panel.add(textAreaAdresseLivraison);
		
		textAreaLogin = new JTextField();
		textAreaLogin.setBackground(Color.WHITE);
		textAreaLogin.setHorizontalAlignment(SwingConstants.CENTER);
		textAreaLogin.setBounds(265, 183, 263, 30);
		panel.add(textAreaLogin);
		
		JLabel lblPrenom = new JLabel("Pr\u00E9nom :");
		lblPrenom.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrenom.setBounds(311, 21, 150, 30);
		panel.add(lblPrenom);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setHorizontalAlignment(SwingConstants.CENTER);
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNom.setBounds(10, 21, 113, 30);
		panel.add(lblNom);
		
		JLabel lblAdresseLivraison = new JLabel("Adresse de livraison :");
		lblAdresseLivraison.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdresseLivraison.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdresseLivraison.setBounds(10, 86, 207, 27);
		panel.add(lblAdresseLivraison);
		
		JLabel lblAdresseMail = new JLabel("Adresse e-mail :");
		lblAdresseMail.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdresseMail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdresseMail.setBounds(76, 183, 164, 27);
		panel.add(lblAdresseMail);
		
		btnConfirmer = new JButton("Confirmer");
		btnConfirmer.setBounds(151, 303, 138, 23);
		panel.add(btnConfirmer);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(378, 303, 150, 23);
		panel.add(btnAnnuler);
		
		textAreaCodePostal = new JTextField();
		textAreaCodePostal.setBackground(Color.WHITE);
		textAreaCodePostal.setHorizontalAlignment(SwingConstants.CENTER);
		textAreaCodePostal.setBounds(211, 126, 113, 30);
		panel.add(textAreaCodePostal);
		
		textAreaVille = new JTextField();
		textAreaVille.setBackground(Color.WHITE);
		textAreaVille.setHorizontalAlignment(SwingConstants.CENTER);
		textAreaVille.setBounds(435, 126, 192, 30);
		panel.add(textAreaVille);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setHorizontalAlignment(SwingConstants.CENTER);
		lblMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMotDePasse.setBounds(86, 227, 164, 27);
		panel.add(lblMotDePasse);
		
		JLabel lblCodePostal = new JLabel("Code postal :");
		lblCodePostal.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodePostal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCodePostal.setBounds(76, 124, 125, 27);
		panel.add(lblCodePostal);
		
		JLabel lblVille = new JLabel("Ville : ");
		lblVille.setHorizontalAlignment(SwingConstants.CENTER);
		lblVille.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVille.setBounds(342, 126, 83, 27);
		panel.add(lblVille);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(301, 232, 200, 20);
		panel.add(passwordField);
		
		passwordFieldConfirmation = new JPasswordField();
		passwordFieldConfirmation.setHorizontalAlignment(SwingConstants.CENTER);
		passwordFieldConfirmation.setBounds(301, 272, 200, 20);
		panel.add(passwordFieldConfirmation);
		
		JLabel lblConfirmerMotDe = new JLabel("Confirmer mot de passe :");
		lblConfirmerMotDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmerMotDe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblConfirmerMotDe.setBounds(43, 265, 218, 27);
		panel.add(lblConfirmerMotDe);
		
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
	public JPasswordField getPasswordField() {
		return passwordField;
	}
	public JPasswordField getPasswordFieldConfirmation() {
		return passwordFieldConfirmation;
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
	public JTextField getTextAreaCodePostal() {
		return textAreaCodePostal;
	}
	public JTextField getTextAreaVille() {
		return textAreaVille;
	}
	public JTextField getTextAreaLogin() {
		return textAreaLogin;
	}
}
