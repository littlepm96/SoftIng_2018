package View.DashboardAdmin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import View.Login;

import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;

public class DashboardAdmin extends JFrame {

	private JPanel contentPane;
	static String username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashboardAdmin frame = new DashboardAdmin(username);
					frame.setVisible(true);
					
					//Viene richiamato il thread ogni minuto per generare i segnali
					Runnable drawRunnable = new Runnable() {
					    public void run() {
					      System.out.println("test");
					    }
					};
					//Richiama il thread ogni minuto , 1 indica il minuto
					ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);
					exec.scheduleAtFixedRate(drawRunnable , 0, 1, TimeUnit.MINUTES);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DashboardAdmin(String username) {
		//Finestra
		setResizable(false);
		setTitle("Dashboard Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 350);
		
		//Il contentPane contiene gli elementi 
		contentPane = new JPanel();
		contentPane.setToolTipText("Aggiungi Utente");
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Il Panel in questo caso è il menu superiore 
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 610, 56);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//Questa label permetterà di visualizzare il nome dell'utente loggato
		JLabel lblBentornato = new JLabel("Bentornato "+username);
		lblBentornato.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBentornato.setBounds(10, 11, 298, 34);
		panel.add(lblBentornato);

		//Bottono Logout
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(e -> this.dispose());
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogout.setBounds(485, 11, 103, 31);
		panel.add(btnLogout);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setVisible(true);
			}	
		});
		
		//Il bottone Ticket permette di visualizzare un Ticket 
		JButton btnTicket = new JButton("Ticket");
		btnTicket.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTicket.setBounds(227, 67, 162, 56);
		contentPane.add(btnTicket);
		btnTicket.setIcon(new ImageIcon(DashboardAdmin.class.getResource("/Icons/ticket.png")));
		
		//Il bottone Recupero permette di recuperare un account ed eventualmente modificare username e password 
		JButton btnRecupero = new JButton("Recupero");
		btnRecupero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRecupero.setBounds(227, 128, 162, 56);
		contentPane.add(btnRecupero);
		btnRecupero.setIcon(new ImageIcon(DashboardAdmin.class.getResource("/Icons/password.png")));
		
		
		//Il bottone Aggiungi permette di aggiungere un Gestore o un Admin 
		
		JButton btnNewButton = new JButton("Aggiungi");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(227, 195, 162, 56);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aggiungi a=new Aggiungi();
				a.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon(DashboardAdmin.class.getResource("/Icons/aggiungi.png")));
		btnRecupero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RecuperaChiave rc= new RecuperaChiave();
				rc.setVisible(true);
			}	
		});
		btnTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminTicket st=new AdminTicket(username);
				st.setVisible(true);
			}
		});
	}
}
