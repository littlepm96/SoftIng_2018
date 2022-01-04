package View.DashboardGestore;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.GestoreSensoriController;
import Model.Components.Ticket;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.awt.event.ActionEvent;

public class CreazioneTicket extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	static String username;
	private JTextField Amministratore;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreazioneTicket frame = new CreazioneTicket(username);
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
	public CreazioneTicket(String username) {
		
		this.username=username;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 524, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(17, 48, 260, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Oggetto:");
		lblNewLabel.setBounds(17, 21, 61, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblDescrizione = new JLabel("Descrizione:");
		lblDescrizione.setBounds(17, 202, 85, 16);
		contentPane.add(lblDescrizione);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(17, 229, 445, 131);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("Invia");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Ticket t=new Ticket();
				t.setOggetto(textField.getText());
				t.setDescrizione(textArea.getText());
				t.setMittente(username);
				t.setDestinatario(Amministratore.getText());
				new GestoreSensoriController().setTicket(t);
				dispose();
				JOptionPane.showMessageDialog(null,"Ticket Inviato Correttamente");
			
					
			}
		});
		btnNewButton.setBounds(345, 33, 117, 63);
		contentPane.add(btnNewButton);
		
		JLabel lblDestinatario = new JLabel("Destinatario:");
		lblDestinatario.setBounds(17, 90, 85, 14);
		contentPane.add(lblDestinatario);
		
		Amministratore = new JTextField();
		Amministratore.setText("Username Amministratore");
		Amministratore.setBounds(17, 115, 260, 31);
		contentPane.add(Amministratore);
		Amministratore.setColumns(10);
		
	
	}
}
