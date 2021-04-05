package rapizz.Fenetres;

import java.awt.EventQueue;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class FenetreLogin extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtLogin;
	private JButton btnConnexion;
	private JPasswordField passwordField;
	private JComboBox comboBox;
	private JButton btnInscription;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreLogin frame = new FenetreLogin();
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
	public FenetreLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(750, 300, 450, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		
		JLabel lblAuthentification = new JLabel("Connexion");
		lblAuthentification.setHorizontalAlignment(SwingConstants.CENTER);
		lblAuthentification.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblAuthentification, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblLogin = new JLabel("Identifiant (Email) :");
		lblLogin.setBounds(10, 23, 131, 33);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblLogin);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMotDePasse.setHorizontalAlignment(SwingConstants.CENTER);
		lblMotDePasse.setBounds(20, 70, 120, 40);
		panel.add(lblMotDePasse);
		
		txtLogin = new JTextField();
		txtLogin.setHorizontalAlignment(SwingConstants.CENTER);
		txtLogin.setBounds(151, 29, 245, 25);
		panel.add(txtLogin);
		txtLogin.setColumns(10);
		
		btnConnexion = new JButton("Connexion");
		btnConnexion.setActionCommand("Connexion");
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnConnexion.setBounds(276, 170, 120, 33);
		panel.add(btnConnexion);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(151, 80, 245, 25);
		panel.add(passwordField);
		
		btnInscription = new JButton("Inscription (Nouveau client)");
		btnInscription.setActionCommand("Connexion");
		btnInscription.setBounds(28, 170, 202, 33);
		panel.add(btnInscription);
		
		comboBox = new JComboBox();
		comboBox.setBounds(151, 127, 131, 20);
		panel.add(comboBox);
		
		ImageLabel bg = new ImageLabel(new ImageIcon("images/bg.png"));
		bg.setSize(225, 225);
		bg.setLocation(110, 0);
		panel.add(bg);
	}
	public JTextField getTxtLogin() {
		return txtLogin;
	}
	public JButton getBtnConnexion() {
		return btnConnexion;
	}
	public JPasswordField getPasswordField() {
		return passwordField;
	}
	public JComboBox getComboBox() {
		return comboBox;
	}
	public JButton getBtnInscription() {
		return btnInscription;
	}
}
