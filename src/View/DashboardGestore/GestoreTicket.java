package View.DashboardGestore;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.GestoreSensoriController;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestoreTicket extends JFrame {

	private JPanel contentPane;
	DefaultListModel lista;
	static String username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestoreTicket frame = new GestoreTicket(username);
					
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
	public GestoreTicket(String username) {
		
		this.username=username;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 802, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lista=new GestoreSensoriController().getTicket(username);
		
		JList list = new JList(lista);
		list.setBounds(6, 38, 640, 344);
		list.setFixedCellHeight(70);
		contentPane.add(list);
		
		JButton btnNewButton = new JButton("Crea Ticket");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CreazioneTicket ct=new CreazioneTicket(username);
				ct.setVisible(true);
			}
		});
		btnNewButton.setBounds(658, 41, 138, 40);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("I tuoi Ticket:");
		lblNewLabel.setBounds(6, 10, 91, 16);
		contentPane.add(lblNewLabel);
	}
}
