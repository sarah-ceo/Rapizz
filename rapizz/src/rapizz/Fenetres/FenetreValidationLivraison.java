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
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FenetreValidationLivraison extends JFrame {

	private JPanel contentPane;
	private JComboBox cbCommande;
	private JButton btnConfirmer;
	private JButton btnActualiser;
	private JLabel lblDateCommande;
	private JLabel lblTempsDeLivraison;
	private JTextField lblCurrentHeure;
	private JTextField textPaneTempsLivraison;
	private JButton btnAnnuler;
	private JLabel label;
	private JTextField labelDateCommande;
	private JTextField labelHeureCommande;
	private JLabel lblAdresseDeLivraison;
	private JTextField labelAdresseLivraison;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreValidationLivraison frame = new FenetreValidationLivraison();
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
	public FenetreValidationLivraison() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 300, 700, 400);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblDetailsCommandes = new JLabel("D\u00E9tails des commandes");
		lblDetailsCommandes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDetailsCommandes.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblDetailsCommandes, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		cbCommande = new JComboBox();
		cbCommande.setBounds(140, 41, 367, 20);
		panel.add(cbCommande);
		
		btnConfirmer = new JButton("Confirmer");
		btnConfirmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnConfirmer.setBounds(140, 302, 154, 23);
		panel.add(btnConfirmer);
		
		JLabel lblCommande = new JLabel("Commande :");
		lblCommande.setHorizontalAlignment(SwingConstants.CENTER);
		lblCommande.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCommande.setBounds(33, 40, 110, 19);
		panel.add(lblCommande);
		
		btnActualiser = new JButton("Choisir");
		btnActualiser.setBounds(524, 40, 150, 23);
		panel.add(btnActualiser);
		
		lblDateCommande = new JLabel("Commande pass\u00E9e le :");
		lblDateCommande.setHorizontalAlignment(SwingConstants.CENTER);
		lblDateCommande.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDateCommande.setBounds(10, 96, 161, 17);
		panel.add(lblDateCommande);
		
		lblTempsDeLivraison = new JLabel("Corrigez si besoin le temps de livraison (en minutes) :");
		lblTempsDeLivraison.setHorizontalAlignment(SwingConstants.CENTER);
		lblTempsDeLivraison.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTempsDeLivraison.setBounds(25, 257, 386, 17);
		panel.add(lblTempsDeLivraison);
		
		lblCurrentHeure = new JTextField();
		lblCurrentHeure.setEditable(false);
		lblCurrentHeure.setBackground(Color.WHITE);
		lblCurrentHeure.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentHeure.setBounds(317, 141, 166, 28);
		panel.add(lblCurrentHeure);
		
		textPaneTempsLivraison = new JTextField();
		textPaneTempsLivraison.setBackground(Color.WHITE);
		textPaneTempsLivraison.setHorizontalAlignment(SwingConstants.CENTER);
		textPaneTempsLivraison.setBounds(409, 253, 150, 28);
		panel.add(textPaneTempsLivraison);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(386, 302, 154, 23);
		panel.add(btnAnnuler);
		
		label = new JLabel("\u00E0 :");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(340, 96, 110, 17);
		panel.add(label);
		
		labelDateCommande = new JTextField();
		labelDateCommande.setEditable(false);
		labelDateCommande.setBackground(Color.WHITE);
		labelDateCommande.setHorizontalAlignment(SwingConstants.CENTER);
		labelDateCommande.setBounds(181, 92, 161, 28);
		panel.add(labelDateCommande);
		
		labelHeureCommande = new JTextField();
		labelHeureCommande.setEditable(false);
		labelHeureCommande.setBackground(Color.WHITE);
		labelHeureCommande.setHorizontalAlignment(SwingConstants.CENTER);
		labelHeureCommande.setBounds(441, 92, 161, 28);
		panel.add(labelHeureCommande);
		
		lblAdresseDeLivraison = new JLabel("Adresse de livraison :");
		lblAdresseDeLivraison.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdresseDeLivraison.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdresseDeLivraison.setBounds(33, 199, 230, 17);
		panel.add(lblAdresseDeLivraison);
		
		labelAdresseLivraison = new JTextField();
		labelAdresseLivraison.setEditable(false);
		labelAdresseLivraison.setBackground(Color.WHITE);
		labelAdresseLivraison.setHorizontalAlignment(SwingConstants.CENTER);
		labelAdresseLivraison.setBounds(230, 192, 408, 35);
		panel.add(labelAdresseLivraison);
		
		JLabel lblIlEst = new JLabel("Il est :");
		lblIlEst.setHorizontalAlignment(SwingConstants.CENTER);
		lblIlEst.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIlEst.setBounds(206, 145, 110, 17);
		panel.add(lblIlEst);
		
		ImageLabel bg = new ImageLabel(new ImageIcon("images/bg.png"));
		bg.setSize(225, 225);
		bg.setLocation(225, 70);
		panel.add(bg);
		
	}
	public JComboBox getCbCommande() {
		return cbCommande;
	}
	public JButton getBtnActualiser() {
		return btnActualiser;
	}
	public JTextField getTextPaneTempsLivraison() {
		return textPaneTempsLivraison;
	}
	public JTextField getLblCurrentHeure() {
		return lblCurrentHeure;
	}
	public JButton getBtnConfirmer() {
		return btnConfirmer;
	}
	public JButton getBtnAnnuler() {
		return btnAnnuler;
	}
	public JTextField getLabelDateCommande() {
		return labelDateCommande;
	}
	public JTextField getLabelHeureCommande() {
		return labelHeureCommande;
	}
	public JTextField getLabelAdresseLivraison() {
		return labelAdresseLivraison;
	}
}
