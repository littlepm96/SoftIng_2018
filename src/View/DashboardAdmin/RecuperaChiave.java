package View.DashboardAdmin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.GestoreAdminController;
import Model.Components.Amministratore;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class RecuperaChiave extends JFrame {

	private JPanel contentPane;
	private JTextField chiave;
    public String chiavetext;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecuperaChiave frame = new RecuperaChiave();
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
	public RecuperaChiave() {
		setTitle("Recupera Chiave");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Chiave di Recupero dell'Admin da recuperare:");
		lblNewLabel.setBounds(10, 73, 232, 96);
		contentPane.add(lblNewLabel);
		
		chiave = new JTextField();
		chiave.setBounds(275, 108, 149, 26);
		contentPane.add(chiave);
		chiave.setColumns(10);
		
		JButton btnRecupera = new JButton("Recupera");
		btnRecupera.setBounds(178, 158, 89, 23);
		contentPane.add(btnRecupera);
		btnRecupera.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				chiavetext=chiave.getText();
				String a[] = new GestoreAdminController().getAdmin_byKey (chiavetext);
				JOptionPane.showMessageDialog(null,"Le Credenziali Admin sono Username: "+a[0]+" e Password: "+a[1]+"");
			}
		});
	}
}
