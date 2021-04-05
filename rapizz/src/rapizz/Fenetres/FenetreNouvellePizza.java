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

public class FenetreNouvellePizza extends JFrame{
	
	private JTable table;
	private JPanel contentPane;
	private JLabel lblPrixBase;
	private JTextField textPanePrixBase;
	private JButton btnConfirmer;
	private JButton btnAnnuler;
	private JButton btnAjouter;
	private JComboBox comboBoxIngredients;
	private JComboBox comboBoxRetirer;
	private JButton btnRetirer;
	private JLabel lblNom;
	private JTextField textPaneNomPizza;
	private JLabel lblRecette;
	private JButton btnNouvelIngredient;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreNouvellePizza frame = new FenetreNouvellePizza();
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
	public FenetreNouvellePizza() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 300, 700, 400);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNouvellePizza = new JLabel("Nouvelle Pizza");
		lblNouvellePizza.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNouvellePizza.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNouvellePizza, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		lblPrixBase = new JLabel("Prix de base :");
		lblPrixBase.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrixBase.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrixBase.setBounds(210, 50, 121, 17);
		panel.add(lblPrixBase);
		
		textPanePrixBase = new JTextField();
		textPanePrixBase.setBackground(Color.WHITE);
		textPanePrixBase.setHorizontalAlignment(SwingConstants.CENTER);
		textPanePrixBase.setBounds(353, 50, 128, 20);
		panel.add(textPanePrixBase);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(220, 114, 250, 177);
		panel.add(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 230, 155);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(table);
		
		btnConfirmer = new JButton("Confirmer");
		btnConfirmer.setBounds(210, 302, 121, 23);
		panel.add(btnConfirmer);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(382, 302, 99, 23);
		panel.add(btnAnnuler);
		
		btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(49, 176, 99, 23);
		panel.add(btnAjouter);
		
		comboBoxIngredients = new JComboBox();
		comboBoxIngredients.setBounds(10, 128, 188, 25);
		panel.add(comboBoxIngredients);
		
		comboBoxRetirer = new JComboBox();
		comboBoxRetirer.setBounds(486, 128, 188, 25);
		panel.add(comboBoxRetirer);
		
		btnRetirer = new JButton("Retirer");
		btnRetirer.setBounds(542, 176, 99, 23);
		panel.add(btnRetirer);
		
		lblNom = new JLabel("Nom :");
		lblNom.setHorizontalAlignment(SwingConstants.CENTER);
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNom.setBounds(221, 14, 94, 17);
		panel.add(lblNom);
		
		textPaneNomPizza = new JTextField();
		textPaneNomPizza.setBackground(Color.WHITE);
		textPaneNomPizza.setHorizontalAlignment(SwingConstants.CENTER);
		textPaneNomPizza.setBounds(353, 11, 128, 20);
		panel.add(textPaneNomPizza);
		
		lblRecette = new JLabel("Recette");
		lblRecette.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecette.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRecette.setBounds(195, 92, 286, 25);
		panel.add(lblRecette);
		
		btnNouvelIngredient = new JButton("Nouvel ingr\u00E9dient");
		btnNouvelIngredient.setBounds(542, 302, 132, 23);
		panel.add(btnNouvelIngredient);
		
		ImageLabel bg1 = new ImageLabel(new ImageIcon("images/bg.png"));
		bg1.setSize(225, 225);
		bg1.setLocation(0, 80);
		panel.add(bg1);
		ImageLabel bg2 = new ImageLabel(new ImageIcon("images/bg.png"));
		bg2.setSize(225, 225);
		bg2.setLocation(470, 80);
		panel.add(bg2);
	}
	public JTable getTable() {
		return table;
	}
	public JTextField getTextPaneNomPizza() {
		return textPaneNomPizza;
	}
	public JTextField getTextPanePrixBase() {
		return textPanePrixBase;
	}
	public JComboBox getComboBoxIngredients() {
		return comboBoxIngredients;
	}
	public JButton getBtnAjouter() {
		return btnAjouter;
	}
	public JComboBox getComboBoxRetirer() {
		return comboBoxRetirer;
	}
	public JButton getBtnRetirer() {
		return btnRetirer;
	}
	public JButton getBtnConfirmer() {
		return btnConfirmer;
	}
	public JButton getBtnAnnuler() {
		return btnAnnuler;
	}
	public JButton getBtnNouvelIngredient() {
		return btnNouvelIngredient;
	}
}
