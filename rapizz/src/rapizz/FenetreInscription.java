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

public class FenetreInscription extends JFrame {

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
		setBounds(150, 150, 700, 400);
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
		
		textAreaNom = new JTextArea();
		textAreaNom.setBounds(111, 21, 239, 40);
		panel.add(textAreaNom);
		
		textAreaPrenom = new JTextArea();
		textAreaPrenom.setBounds(435, 21, 239, 40);
		panel.add(textAreaPrenom);
		
		textAreaAdresseLivraison = new JTextArea();
		textAreaAdresseLivraison.setBounds(210, 89, 429, 40);
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
		lblAdresseLivraison.setBounds(10, 86, 207, 27);
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
		
		JTextArea textAreaCodePostal = new JTextArea();
		textAreaCodePostal.setBounds(240, 140, 113, 40);
		panel.add(textAreaCodePostal);
		
		JTextArea textAreaVille = new JTextArea();
		textAreaVille.setBounds(435, 140, 192, 40);
		panel.add(textAreaVille);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setHorizontalAlignment(SwingConstants.CENTER);
		lblMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMotDePasse.setBounds(37, 253, 164, 27);
		panel.add(lblMotDePasse);
		
		JLabel lblCodePostal = new JLabel("Code postal :");
		lblCodePostal.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodePostal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCodePostal.setBounds(66, 140, 164, 27);
		panel.add(lblCodePostal);
		
		JLabel lblVille = new JLabel("Ville : ");
		lblVille.setHorizontalAlignment(SwingConstants.CENTER);
		lblVille.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVille.setBounds(308, 145, 164, 27);
		panel.add(lblVille);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(211, 258, 379, 20);
		panel.add(passwordField);
	}
	public JTextArea getTextAreaPourquoiConfiance() {
		return textAreaNom;
	}
	public JTextArea getTextAreaCommentaireNotices() {
		return textAreaPrenom;
	}
	public JTextArea getTextAreaCommentairePBMedicaments() {
		return textAreaAdresseLivraison;
	}
	public JTextArea getTextAreaAutresCommentaires() {
		return textAreaLogin;
	}
	public JButton getBtnConfirmer() {
		return btnConfirmer;
	}
	public JButton getBtnAnnuler() {
		return btnAnnuler;
	}
}
