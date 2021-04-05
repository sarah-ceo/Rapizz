package rapizz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class FenetreDetailsCommande extends JFrame {

	private JPanel contentPane;
	private JComboBox cbCommande;
	private JButton btnOK;
	private JButton button;
	private JLabel lblDateCommande;
	private JLabel lblTaille;
	private JLabel lblTempsDeLivraison;
	private JLabel lblBonification;
	private JLabel lblMontantTotal;
	private JTextPane textPaneIdCommande;
	private JTextPane textPaneDateCommande;
	private JTextPane textPanePizza;
	private JTextPane textPaneTaille;
	private JTextPane textPaneTempsLivraison;
	private JTextPane textPaneBonification;
	private JTextPane textPaneMontantTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreDetailsCommande frame = new FenetreDetailsCommande();
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
	public FenetreDetailsCommande() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 700, 400);
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
		cbCommande.setBounds(140, 39, 367, 20);
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
		lblCommande.setBounds(33, 38, 110, 19);
		panel.add(lblCommande);
		
		JLabel lblNbCommande = new JLabel("Numero de commande :");
		lblNbCommande.setHorizontalAlignment(SwingConstants.CENTER);
		lblNbCommande.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNbCommande.setBounds(54, 95, 161, 17);
		panel.add(lblNbCommande);
		
		JLabel lblPizza = new JLabel("Pizza :");
		lblPizza.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPizza.setBounds(97, 151, 50, 20);
		panel.add(lblPizza);
		
		button = new JButton("Actualiser");
		button.setBounds(524, 38, 150, 23);
		panel.add(button);
		
		lblDateCommande = new JLabel("Date de la commande :");
		lblDateCommande.setHorizontalAlignment(SwingConstants.CENTER);
		lblDateCommande.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDateCommande.setBounds(54, 123, 161, 17);
		panel.add(lblDateCommande);
		
		lblTaille = new JLabel("Taille :");
		lblTaille.setHorizontalAlignment(SwingConstants.CENTER);
		lblTaille.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTaille.setBounds(33, 182, 161, 17);
		panel.add(lblTaille);
		
		lblTempsDeLivraison = new JLabel("Temps de livraison :");
		lblTempsDeLivraison.setHorizontalAlignment(SwingConstants.CENTER);
		lblTempsDeLivraison.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTempsDeLivraison.setBounds(54, 213, 161, 17);
		panel.add(lblTempsDeLivraison);
		
		lblBonification = new JLabel("Bonification :");
		lblBonification.setHorizontalAlignment(SwingConstants.CENTER);
		lblBonification.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBonification.setBounds(54, 241, 161, 17);
		panel.add(lblBonification);
		
		lblMontantTotal = new JLabel("Montant Total : ");
		lblMontantTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblMontantTotal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMontantTotal.setBounds(54, 277, 161, 17);
		panel.add(lblMontantTotal);
		
		textPaneIdCommande = new JTextPane();
		textPaneIdCommande.setBounds(259, 92, 236, 20);
		panel.add(textPaneIdCommande);
		
		textPaneDateCommande = new JTextPane();
		textPaneDateCommande.setBounds(259, 123, 236, 20);
		panel.add(textPaneDateCommande);
		
		textPanePizza = new JTextPane();
		textPanePizza.setBounds(259, 151, 236, 20);
		panel.add(textPanePizza);
		
		textPaneTaille = new JTextPane();
		textPaneTaille.setBounds(259, 179, 236, 20);
		panel.add(textPaneTaille);
		
		textPaneTempsLivraison = new JTextPane();
		textPaneTempsLivraison.setBounds(259, 210, 236, 20);
		panel.add(textPaneTempsLivraison);
		
		textPaneBonification = new JTextPane();
		textPaneBonification.setBounds(259, 241, 236, 20);
		panel.add(textPaneBonification);
		
		textPaneMontantTotal = new JTextPane();
		textPaneMontantTotal.setBounds(259, 271, 236, 20);
		panel.add(textPaneMontantTotal);
	}
	public JComboBox getCbVisite() {
		return cbCommande;
	}
	public JButton getBtnConfirmerEtRemplir() {
		return btnOK;
	}

}
