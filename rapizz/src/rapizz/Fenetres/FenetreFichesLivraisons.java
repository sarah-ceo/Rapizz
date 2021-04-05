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

public class FenetreFichesLivraisons extends JFrame {

	private JTable table;
	private JPanel contentPane;
	private JComboBox cbCommande;
	private JButton btnOK;
	private JButton btnActualiser;
	private JLabel lblDateCommande;
	private JLabel lblTempsDeLivraison;
	private JLabel lblBonification;
	private JLabel lblMontantTotal;
	private JTextField textPaneIdCommande;
	private JTextField textPaneDateCommande;
	private JTextField textPaneTempsLivraison;
	private JTextField textPaneBonification;
	private JTextField textPaneMontantTotal;
	private JTextField textPaneClient;
	private JTextField textPaneLivreur;
	private JLabel lblClient;
	private JTextField textPaneVehicule;
	private JLabel lblLivreur;
	private JLabel lblVhicule;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreFichesLivraisons frame = new FenetreFichesLivraisons();
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
	public FenetreFichesLivraisons() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 300, 700, 400);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblDetailsCommandes = new JLabel("Fiches de livraison");
		lblDetailsCommandes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDetailsCommandes.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblDetailsCommandes, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		cbCommande = new JComboBox();
		cbCommande.setBounds(147, 22, 367, 20);
		panel.add(cbCommande);
		
		btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnOK.setBounds(289, 302, 154, 23);
		panel.add(btnOK);
		
		JLabel lblCommande = new JLabel("Commande :");
		lblCommande.setHorizontalAlignment(SwingConstants.CENTER);
		lblCommande.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCommande.setBounds(33, 21, 110, 19);
		panel.add(lblCommande);
		
		JLabel lblNbCommande = new JLabel("Numero de commande :");
		lblNbCommande.setHorizontalAlignment(SwingConstants.CENTER);
		lblNbCommande.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNbCommande.setBounds(10, 59, 161, 17);
		panel.add(lblNbCommande);
		
		btnActualiser = new JButton("Choisir");
		btnActualiser.setBounds(524, 21, 150, 23);
		panel.add(btnActualiser);
		
		lblDateCommande = new JLabel("Date de la commande :");
		lblDateCommande.setHorizontalAlignment(SwingConstants.CENTER);
		lblDateCommande.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDateCommande.setBounds(10, 87, 161, 17);
		panel.add(lblDateCommande);
		
		lblTempsDeLivraison = new JLabel("Temps de livraison :");
		lblTempsDeLivraison.setHorizontalAlignment(SwingConstants.CENTER);
		lblTempsDeLivraison.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTempsDeLivraison.setBounds(10, 211, 161, 17);
		panel.add(lblTempsDeLivraison);
		
		lblBonification = new JLabel("Bonification :");
		lblBonification.setHorizontalAlignment(SwingConstants.CENTER);
		lblBonification.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBonification.setBounds(33, 239, 110, 17);
		panel.add(lblBonification);
		
		lblMontantTotal = new JLabel("Total : ");
		lblMontantTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblMontantTotal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMontantTotal.setBounds(33, 274, 110, 17);
		panel.add(lblMontantTotal);
		
		textPaneIdCommande = new JTextField();
		textPaneIdCommande.setBackground(Color.WHITE);
		textPaneIdCommande.setHorizontalAlignment(SwingConstants.CENTER);
		textPaneIdCommande.setEditable(false);
		textPaneIdCommande.setBounds(181, 56, 150, 20);
		panel.add(textPaneIdCommande);
		
		textPaneDateCommande = new JTextField();
		textPaneDateCommande.setBackground(Color.WHITE);
		textPaneDateCommande.setHorizontalAlignment(SwingConstants.CENTER);
		textPaneDateCommande.setEditable(false);
		textPaneDateCommande.setBounds(181, 87, 150, 20);
		panel.add(textPaneDateCommande);
		
		textPaneTempsLivraison = new JTextField();
		textPaneTempsLivraison.setBackground(Color.WHITE);
		textPaneTempsLivraison.setHorizontalAlignment(SwingConstants.CENTER);
		textPaneTempsLivraison.setEditable(false);
		textPaneTempsLivraison.setBounds(181, 208, 150, 20);
		panel.add(textPaneTempsLivraison);
		
		textPaneBonification = new JTextField();
		textPaneBonification.setBackground(Color.WHITE);
		textPaneBonification.setHorizontalAlignment(SwingConstants.CENTER);
		textPaneBonification.setEditable(false);
		textPaneBonification.setBounds(181, 239, 150, 20);
		panel.add(textPaneBonification);
		
		textPaneMontantTotal = new JTextField();
		textPaneMontantTotal.setBackground(Color.WHITE);
		textPaneMontantTotal.setHorizontalAlignment(SwingConstants.CENTER);
		textPaneMontantTotal.setEditable(false);
		textPaneMontantTotal.setBounds(181, 271, 150, 20);
		panel.add(textPaneMontantTotal);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(352, 120, 322, 161);
		panel.add(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 302, 139);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblPizzas = new JLabel("Pizzas");
		lblPizzas.setHorizontalAlignment(SwingConstants.CENTER);
		lblPizzas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPizzas.setBounds(371, 79, 286, 25);
		panel.add(lblPizzas);
		
		textPaneClient = new JTextField();
		textPaneClient.setBackground(Color.WHITE);
		textPaneClient.setHorizontalAlignment(SwingConstants.CENTER);
		textPaneClient.setEditable(false);
		textPaneClient.setBounds(181, 118, 150, 20);
		panel.add(textPaneClient);
		
		textPaneLivreur = new JTextField();
		textPaneLivreur.setBackground(Color.WHITE);
		textPaneLivreur.setHorizontalAlignment(SwingConstants.CENTER);
		textPaneLivreur.setEditable(false);
		textPaneLivreur.setBounds(181, 149, 150, 20);
		panel.add(textPaneLivreur);
		
		lblClient = new JLabel("Client :");
		lblClient.setHorizontalAlignment(SwingConstants.CENTER);
		lblClient.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClient.setBounds(33, 121, 110, 17);
		panel.add(lblClient);
		
		textPaneVehicule = new JTextField();
		textPaneVehicule.setBackground(Color.WHITE);
		textPaneVehicule.setHorizontalAlignment(SwingConstants.CENTER);
		textPaneVehicule.setEditable(false);
		textPaneVehicule.setBounds(181, 180, 150, 20);
		panel.add(textPaneVehicule);
		
		lblLivreur = new JLabel("Livreur :");
		lblLivreur.setHorizontalAlignment(SwingConstants.CENTER);
		lblLivreur.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLivreur.setBounds(33, 149, 110, 17);
		panel.add(lblLivreur);
		
		lblVhicule = new JLabel("V\u00E9hicule :");
		lblVhicule.setHorizontalAlignment(SwingConstants.CENTER);
		lblVhicule.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVhicule.setBounds(10, 180, 161, 17);
		panel.add(lblVhicule);
		
		ImageLabel bg = new ImageLabel(new ImageIcon("images/bg.png"));
		bg.setSize(225, 225);
		bg.setLocation(75, 60);
		panel.add(bg);
	}
	public JTable getTable() {
		return table;
	}
	public JComboBox getCbCommande() {
		return cbCommande;
	}
	public JButton getBtnActualiser() {
		return btnActualiser;
	}
	public JButton getBtnOK() {
		return btnOK;
	}
	public JTextField getTextPaneIdCommande() {
		return textPaneIdCommande;
	}
	public JTextField getTextPaneDateCommande() {
		return textPaneDateCommande;
	}
	public JTextField getTextPaneTempsLivraison() {
		return textPaneTempsLivraison;
	}
	public JTextField getTextPaneBonification() {
		return textPaneBonification;
	}
	public JTextField getTextPaneMontantTotal() {
		return textPaneMontantTotal;
	}
	public JTextField getTextPaneClient() {
		return textPaneClient;
	}
	public JTextField getTextPaneLivreur() {
		return textPaneLivreur;
	}
	public JTextField getTextPaneVehicule() {
		return textPaneVehicule;
	}
}
