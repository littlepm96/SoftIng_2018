package View.DashboardAdmin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.GestoreAdminController;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RispondiTicket extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RispondiTicket frame = new RispondiTicket();
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
	public RispondiTicket() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(17, 107, 463, 165);
		contentPane.add(textArea);
		
		textField = new JTextField();
		textField.setBounds(16, 48, 139, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Invia Risposta");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new GestoreAdminController().setRisposta(Integer.parseInt(textField.getText()),textArea.getText());
				dispose();
				JOptionPane.showMessageDialog(null,"Ticket Risposto Correttamente");
				
			}
		});
		btnNewButton.setBounds(350, 34, 117, 51);
		contentPane.add(btnNewButton);
		
	
		
		JLabel lblInserisciIdTicket = new JLabel("Inserisci Id Ticket");
		lblInserisciIdTicket.setBounds(16, 34, 117, 16);
		contentPane.add(lblInserisciIdTicket);
		
	
		
		JLabel lblNewLabel = new JLabel("Inserisci Risposta");
		lblNewLabel.setBounds(16, 79, 126, 16);
		contentPane.add(lblNewLabel);
	}
}
