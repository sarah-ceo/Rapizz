package rapizz.Fenetres;


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

public class FenetreNouvelIngredient extends JFrame{

	private JPanel contentPane;
	private JTextArea textAreaNomIngredient;
	private JButton btnConfirmer;
	private JButton btnAnnuler;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreNouvelIngredient frame = new FenetreNouvelIngredient();
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
	public FenetreNouvelIngredient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 300, 350, 200);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNouvelIngredient = new JLabel("Nouvel Ingr\u00E9dient");
		lblNouvelIngredient.setHorizontalAlignment(SwingConstants.CENTER);
		lblNouvelIngredient.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNouvelIngredient, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textAreaNomIngredient = new JTextArea();
		textAreaNomIngredient.setBounds(46, 52, 239, 30);
		panel.add(textAreaNomIngredient);
		
		JLabel lblNomIngredient = new JLabel("Nom de l'ingr\u00E9dient:");
		lblNomIngredient.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomIngredient.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomIngredient.setBounds(46, 11, 239, 30);
		panel.add(lblNomIngredient);
		
		btnConfirmer = new JButton("Confirmer");
		btnConfirmer.setBounds(10, 106, 138, 23);
		panel.add(btnConfirmer);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(174, 106, 150, 23);
		panel.add(btnAnnuler);
	}
	public JTextArea getTextAreaNomIngredient() {
		return textAreaNomIngredient;
	}
	public JButton getBtnConfirmer() {
		return btnConfirmer;
	}
	public JButton getBtnAnnuler() {
		return btnAnnuler;
	}
}
