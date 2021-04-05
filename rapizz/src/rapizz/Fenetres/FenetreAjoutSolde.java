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
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

public class FenetreAjoutSolde extends JFrame {

	private JPanel contentPane;
	private JTextField textAreaCryptogramme;
	private JTextField textAreaTitulaireCarte;
	private JTextField textAreaNumeroCarte;
	private JTextField textAreaMontant;
	private JButton btnConfirmer;
	private JButton btnAnnuler;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreAjoutSolde frame = new FenetreAjoutSolde();
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
	public FenetreAjoutSolde() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 300, 700, 400);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblAjoutSolde = new JLabel("Ajouter du cr\u00E9dit");
		lblAjoutSolde.setHorizontalAlignment(SwingConstants.CENTER);
		lblAjoutSolde.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblAjoutSolde, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textAreaCryptogramme = new JTextField();
		textAreaCryptogramme.setBackground(Color.WHITE);
		textAreaCryptogramme.setHorizontalAlignment(SwingConstants.CENTER);
		textAreaCryptogramme.setBounds(326, 133, 64, 30);
		panel.add(textAreaCryptogramme);
		
		textAreaTitulaireCarte = new JTextField();
		textAreaTitulaireCarte.setBackground(Color.WHITE);
		textAreaTitulaireCarte.setHorizontalAlignment(SwingConstants.CENTER);
		textAreaTitulaireCarte.setBounds(326, 184, 326, 30);
		panel.add(textAreaTitulaireCarte);
		
		textAreaNumeroCarte = new JTextField();
		textAreaNumeroCarte.setBackground(Color.WHITE);
		textAreaNumeroCarte.setHorizontalAlignment(SwingConstants.CENTER);
		textAreaNumeroCarte.setBounds(326, 72, 326, 30);
		panel.add(textAreaNumeroCarte);
		
		textAreaMontant = new JTextField();
		textAreaMontant.setBackground(Color.WHITE);
		textAreaMontant.setHorizontalAlignment(SwingConstants.CENTER);
		textAreaMontant.setBounds(326, 232, 79, 30);
		panel.add(textAreaMontant);
		
		JLabel lblNomCarte = new JLabel("Nom du titulaire de la carte :");
		lblNomCarte.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomCarte.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomCarte.setBounds(105, 184, 211, 30);
		panel.add(lblNomCarte);
		
		JLabel lblCryptogramme = new JLabel("Cryptogramme visuel :");
		lblCryptogramme.setHorizontalAlignment(SwingConstants.CENTER);
		lblCryptogramme.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCryptogramme.setBounds(140, 133, 199, 30);
		panel.add(lblCryptogramme);
		
		JLabel lblNumeroCarteCredit = new JLabel("Num\u00E9ro de carte de cr\u00E9dit :");
		lblNumeroCarteCredit.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeroCarteCredit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNumeroCarteCredit.setBounds(121, 72, 207, 27);
		panel.add(lblNumeroCarteCredit);
		
		JLabel lblMontant = new JLabel("Montant :");
		lblMontant.setHorizontalAlignment(SwingConstants.CENTER);
		lblMontant.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMontant.setBounds(162, 229, 164, 27);
		panel.add(lblMontant);
		
		btnConfirmer = new JButton("Confirmer");
		btnConfirmer.setBounds(151, 303, 138, 23);
		panel.add(btnConfirmer);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(351, 303, 150, 23);
		panel.add(btnAnnuler);
		
		JRadioButton rdbtnVisa = new JRadioButton("VISA");
		rdbtnVisa.setBounds(252, 19, 64, 23);
		panel.add(rdbtnVisa);
		
		JRadioButton rdbtnMastercard = new JRadioButton("MASTERCARD");
		rdbtnMastercard.setBounds(380, 19, 132, 23);
		panel.add(rdbtnMastercard);
		
		ButtonGroup bgroup = new ButtonGroup();
		bgroup.add(rdbtnVisa);
		bgroup.add(rdbtnMastercard);
		
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
	public JTextField getTextAreaMontant() {
		return textAreaMontant;
	}
}

