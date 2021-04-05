package rapizz;

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
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FenetreAccueilAdmin extends JFrame {
	
	private JTable table;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JButton btnNouveauLivreur;
	private JButton btnDeconnexion;
	private JButton btnNouvellePizza;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreAccueilAdmin frame = new FenetreAccueilAdmin();
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
	public FenetreAccueilAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 700, 400);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStatistiques = new JLabel("Statistiques");
		lblStatistiques.setBounds(27, 69, 286, 25);
		lblStatistiques.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblStatistiques.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblStatistiques);
		
		btnDeconnexion = new JButton("Deconnexion");
		btnDeconnexion.setBounds(10, 10, 117, 23);
		contentPane.add(btnDeconnexion);
		
		JPanel panel = new JPanel();
		panel.setBounds(21, 105, 309, 253);
		contentPane.add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 289, 231);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(table);
		
		btnNouveauLivreur = new JButton("Nouveau livreur");
		btnNouveauLivreur.setBounds(421, 175, 183, 23);
		contentPane.add(btnNouveauLivreur);
		
		btnNouvellePizza = new JButton("NouvellePizza");
		btnNouvellePizza.setBounds(421, 225, 183, 23);
		contentPane.add(btnNouvellePizza);
	}
	
	public JTable getTable() {
		return table;
	}
	public JButton getBtnAjouterUneVisite() {
		return btnNouveauLivreur;
	}
	public JButton getBtnDeconnexion() {
		return btnDeconnexion;
	}
}
