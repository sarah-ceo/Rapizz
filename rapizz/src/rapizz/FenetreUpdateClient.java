package rapizz;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class FenetreUpdateClient extends JFrame {

private JPanel contentPane;
	private JTextArea textAreaNom;
	private JTextArea textAreaPrenom;
	private JTextArea textAreaAdresseLivraison;
	private JTextArea textAreaLogin;
	private JButton btnConfirmer;
	private JButton btnAnnuler;
	private JPasswordField passwordField;

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
		setBounds(150, 150, 700, 400);
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
		
		textAreaNom = new JTextArea();
		textAreaNom.setBounds(111, 21, 239, 40);
		panel.add(textAreaNom);
		
		textAreaPrenom = new JTextArea();
		textAreaPrenom.setBounds(435, 21, 239, 40);
		panel.add(textAreaPrenom);
		
		textAreaAdresseLivraison = new JTextArea();
		textAreaAdresseLivraison.setBounds(210, 89, 429, 86);
		panel.add(textAreaAdresseLivraison);
		
		textAreaLogin = new JTextArea();
		textAreaLogin.setBounds(210, 197, 380, 40);
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
		lblAdresseLivraison.setBounds(10, 113, 207, 27);
		panel.add(lblAdresseLivraison);
		
		JLabel lblAdresseMail = new JLabel("Adresse e-mail :");
		lblAdresseMail.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdresseMail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdresseMail.setBounds(27, 194, 164, 27);
		panel.add(lblAdresseMail);
		
		btnConfirmer = new JButton("Confirmer");
		btnConfirmer.setBounds(151, 303, 138, 23);
		panel.add(btnConfirmer);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(351, 303, 150, 23);
		panel.add(btnAnnuler);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setHorizontalAlignment(SwingConstants.CENTER);
		lblMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMotDePasse.setBounds(37, 253, 164, 27);
		panel.add(lblMotDePasse);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(210, 258, 380, 20);
		panel.add(passwordField);
	}
	public JButton getBtnConfirmer() {
		return btnConfirmer;
	}
	public JButton getBtnAnnuler() {
		return btnAnnuler;
	}

	public JTextArea getTextAreaNom() {
		return textAreaNom;
	}
	public JTextArea getTextAreaPrenom() {
		return textAreaPrenom;
	}
	public JTextArea getTextAreaAdresseLivraison() {
		return textAreaAdresseLivraison;
	}
	public JTextArea getTextAreaLogin() {
		return textAreaLogin;
	}
	public JPasswordField getPasswordField() {
		return passwordField;
	}
}
