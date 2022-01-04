package View;

import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.GestoreSensoriController;
import Controller.LoginController;
import View.DashboardAdmin.DashboardAdmin;
import View.DashboardGestore.DashboardGestore;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField usernamefield;
	private JPasswordField passwordField;
	
	String username;
	String password;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					
					
					//Viene richiamato il thread ogni minuto per generare i segnali
					Runnable drawRunnable = new Runnable() {
					    public void run() {
					    	System.out.println("Thread");
					     new GestoreSensoriController().setSegnale();
					    }
					};
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setResizable(false);
		setTitle(" ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 361);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		//Campo per prendere l'username (Serve per recuperare l'username) 
		usernamefield = new JTextField();
		usernamefield.setBounds(135, 120, 204, 33);
		contentPane.add(usernamefield);
		usernamefield.setColumns(10);
		
		//Campo per prendere la password (Serve per recuperare la password) 
		passwordField = new JPasswordField();
		passwordField.setBounds(135, 186, 204, 33);
		contentPane.add(passwordField);
		
		
		//Bottone Login (serve per effettuare il Login) 
		JButton btnLogin = new JButton("Login");
		//Azione Login
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 username=usernamefield.getText();
				 password=passwordField.getText();
				 
				 if (!username.equals("") && !password.equals("") ) {
					 
					 //Facciamo il login
					 String tipo=new LoginController().login(username, password);
					 if(tipo.equals("amministratore")) {
						dispose();
						DashboardAdmin da=new DashboardAdmin(username);
						da.setVisible(true);
						
					 }
					 else if(tipo.equals("Edificio")) {
						 
						 dispose();
						 DashboardGestore dg=new DashboardGestore(username,tipo);
						 dg.setVisible(true);
 
					 }
					 else if(tipo.equals("Area")) {
						 
						 dispose();
						 DashboardGestore dg=new DashboardGestore(username,tipo);
						 dg.setVisible(true);
						 
					 }
					 
					 else if(tipo.equals("Citt�")) {
						 
						 dispose();
						 DashboardGestore dg=new DashboardGestore(username,tipo);
						 dg.setVisible(true);
						 
					 }
					 else if (tipo.equals(""))
					 {
						 
						 JOptionPane.showMessageDialog(null,"Credenziali Errate");
					 }
						 
					
					 
				 } else {
					 
					 JOptionPane.showMessageDialog(null,"Uno dei due campi e' vuoto!");
		 
				 	}
				
				
			}
		});
		btnLogin.setBounds(163, 256, 149, 43);
		contentPane.add(btnLogin);
		
		//Label Sensore
		JLabel lblGestoreSensori = new JLabel("Dashboard Monitoraggio Ambientale");
		lblGestoreSensori.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblGestoreSensori.setBounds(76, 21, 345, 27);
		contentPane.add(lblGestoreSensori);
		
		//Label Softing
		JLabel lblBySofting = new JLabel("By Soft_Ing");
		lblBySofting.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblBySofting.setBounds(202, 49, 66, 16);
		contentPane.add(lblBySofting);
		
	
		//Labels 
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(135, 99, 66, 16);
		contentPane.add(lblUsername);
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(135, 165, 66, 16);
		contentPane.add(lblPassword);
		
		
		
	}
}
