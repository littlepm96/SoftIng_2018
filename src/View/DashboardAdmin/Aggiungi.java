package View.DashboardAdmin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Date;
import java.lang.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.GestoreAdminController;
import Model.Components.GestoreSensori;
import Model.Components.Amministratore;
import Controller.GestoreAdminController;

import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;

public class Aggiungi extends JFrame {

	private JPanel contentPane;
	private JTextField username,usernameAdmin;
	private JTextField password,passwordAdmin;
	private JTextField nome,nomeAdmin;
	private JTextField cognome,cognomeAdmin;
	private JTextField data_nascita,data_nascitaAdmin;
	private JTextField telefono,telefonoAdmin;
	private JTextField email,emailAdmin;
	private JTextField chiave_recupero,chiave_recuperoAdmin;
	private JTextField luogo_nascita,luogo_nascitaAdmin;
	private JTextField tipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aggiungi frame = new Aggiungi();
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
	public Aggiungi() {
		setTitle("Aggiungi");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 398);
		//setBounds(100, 100, 633, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panelGestore = new Panel();
		panelGestore.setBounds(10, 52, 612, 324);
		panelGestore.setVisible(false);
		panelGestore.setBackground(Color.WHITE);
		panelGestore.setLayout(null);
		
		
		Panel panelAdmin = new Panel();
		panelAdmin.setBackground(Color.WHITE);
		panelAdmin.setVisible(false);
		panelAdmin.setBounds(10, 52, 612, 324);
		panelAdmin.setLayout(null);
		
		
		JButton btnNewButton = new JButton("Aggiungi Admin");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBounds(100, 100, 633, 408);
				panelAdmin.setVisible(true);
				panelGestore.setVisible(false);
			}
		});
		btnNewButton.setBounds(6, 6, 131, 40);
		contentPane.add(btnNewButton);
		
	//COMPONENTI PANEL GESTORE
		JButton btnAggiungiGestore = new JButton("Aggiungi Gestore");
		btnAggiungiGestore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBounds(100, 100, 633, 408);
				panelAdmin.setVisible(false);
				panelGestore.setVisible(true);
			}
		});
		btnAggiungiGestore.setBounds(155, 6, 131, 40);
		contentPane.add(btnAggiungiGestore);
	
		username = new JTextField();
		username.setBounds(130, 24, 130, 26);
		panelGestore.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(130, 62, 130, 26);
		panelGestore.add(password);
		
		nome = new JTextField();
		nome.setColumns(10);
		nome.setBounds(130, 100, 130, 26);
		panelGestore.add(nome);
		
		cognome = new JTextField();
		cognome.setColumns(10);
		cognome.setBounds(130, 138, 130, 26);
		panelGestore.add(cognome);
		
		data_nascita = new JTextField();
		data_nascita.setText("yyyy-mm-dd");
		data_nascita.setColumns(10);
		data_nascita.setBounds(130, 176, 130, 26);
		panelGestore.add(data_nascita);
		
		telefono = new JTextField();
		telefono.setColumns(10);
		telefono.setBounds(130, 252, 130, 26);
		panelGestore.add(telefono);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(333, 24, 130, 26);
		panelGestore.add(email);
		
		tipo= new JTextField();
		tipo.setText("Edificio,Area,Citt\u00E0");
		tipo.setColumns(10);
		tipo.setBounds(333, 62, 130, 26);
		panelGestore.add(tipo);
		
		luogo_nascita = new JTextField();
		luogo_nascita.setColumns(10);
		luogo_nascita.setBounds(130, 214, 130, 26);
		panelGestore.add(luogo_nascita);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(27, 29, 70, 16);
		panelGestore.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(27, 67, 61, 16);
		panelGestore.add(lblPassword);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(27, 105, 61, 16);
		panelGestore.add(lblNome);
		
		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setBounds(27, 143, 61, 16);
		panelGestore.add(lblCognome);
		
		JLabel lblDataDiNascita = new JLabel("Data Nascita");
		lblDataDiNascita.setBounds(27, 181, 91, 16);
		panelGestore.add(lblDataDiNascita);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(27, 257, 61, 16);
		panelGestore.add(lblTelefono);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(280, 29, 41, 16);
		panelGestore.add(lblEmail);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(279, 67, 52, 16);
		panelGestore.add(lblTipo);
		
		JLabel lblLuogoNascita = new JLabel("Luogo Nascita");
		lblLuogoNascita.setBounds(27, 219, 91, 16);
		panelGestore.add(lblLuogoNascita);
		
		JButton btnNewButton_2 = new JButton("Aggiungi");
		btnNewButton_2.setBounds(473, 15, 117, 47);
		panelGestore.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				//setGestore
				GestoreSensori g=new GestoreSensori();
				g.setCognome(cognome.getText());
				g.setNome(nome.getText());
				g.setUsername(username.getText());
				g.setPassword(password.getText());
				g.setLuogo_nascita(luogo_nascita.getText());
				g.setTelefono(telefono.getText());
				g.setEmail(email.getText());
				g.setTipo(tipo.getText());
				g.setData_nascita(data_nascita.getText());
				
				
				//g.setData_nascita(new Date(Integer.parseInt(data_nascita.getText().substring(0,4)),Integer.parseInt(data_nascita.getText().substring(5,7)),Integer.parseInt((data_nascita.getText()).substring(8,10))));
				
				new GestoreAdminController().setGestore(g);
				dispose();
				JOptionPane.showMessageDialog(null,"Gestore dei Sensori aggiunto correttamente!");
				
			}
		});
		
		//COMPONENTI PANEL ADMIN
		
		usernameAdmin = new JTextField();
		usernameAdmin.setBounds(130, 24, 130, 26);
		panelAdmin.add(usernameAdmin);
		usernameAdmin.setColumns(10);
		
		passwordAdmin = new JTextField();
		passwordAdmin.setColumns(10);
		passwordAdmin.setBounds(130, 62, 130, 26);
		panelAdmin.add(passwordAdmin);
		
		nomeAdmin = new JTextField();
		nomeAdmin.setColumns(10);
		nomeAdmin.setBounds(130, 100, 130, 26);
		panelAdmin.add(nomeAdmin);
		
		cognomeAdmin = new JTextField();
		cognomeAdmin.setColumns(10);
		cognomeAdmin.setBounds(130, 138, 130, 26);
		panelAdmin.add(cognomeAdmin);
		
		data_nascitaAdmin = new JTextField();
		data_nascitaAdmin.setText("yyyy-mm-dd");
		data_nascitaAdmin.setColumns(10);
		data_nascitaAdmin.setBounds(130, 176, 130, 26);
		panelAdmin.add(data_nascitaAdmin);
		
		telefonoAdmin = new JTextField();
		telefonoAdmin.setColumns(10);
		telefonoAdmin.setBounds(130, 252, 130, 26);
		panelAdmin.add(telefonoAdmin);
		
		emailAdmin = new JTextField();
		emailAdmin.setColumns(10);
		emailAdmin.setBounds(333, 24, 130, 26);
		panelAdmin.add(emailAdmin);
		
		chiave_recuperoAdmin = new JTextField();
		chiave_recuperoAdmin.setText("Es: 123456");
		chiave_recuperoAdmin.setColumns(10);
		chiave_recuperoAdmin.setBounds(333, 62, 130, 26);
		panelAdmin.add(chiave_recuperoAdmin);
		
		luogo_nascitaAdmin = new JTextField();
		luogo_nascitaAdmin.setColumns(10);
		luogo_nascitaAdmin.setBounds(130, 214, 130, 26);
		panelAdmin.add(luogo_nascitaAdmin);
		
		
		
		JLabel lblUsernameAdmin = new JLabel("Username");
		lblUsernameAdmin.setBounds(27, 29, 70, 16);
		panelAdmin.add(lblUsernameAdmin);
		
		JLabel lblPasswordAdmin = new JLabel("Password");
		lblPasswordAdmin.setBounds(27, 67, 61, 16);
		panelAdmin.add(lblPasswordAdmin);
		
		JLabel lblNomeAdmin = new JLabel("Nome");
		lblNomeAdmin.setBounds(27, 105, 61, 16);
		panelAdmin.add(lblNomeAdmin);
		
		JLabel lblCognomeAdmin = new JLabel("Cognome");
		lblCognomeAdmin.setBounds(27, 143, 61, 16);
		panelAdmin.add(lblCognomeAdmin);
		
		JLabel lblDataDiNascitaAdmin = new JLabel("Data Nascita");
		lblDataDiNascitaAdmin.setBounds(27, 181, 91, 16);
		panelAdmin.add(lblDataDiNascitaAdmin);
		
		JLabel lblTelefonoAdmin = new JLabel("Telefono");
		lblTelefonoAdmin.setBounds(27, 257, 61, 16);
		panelAdmin.add(lblTelefonoAdmin);
		
		JLabel lblEmailAdmin = new JLabel("Email");
		lblEmailAdmin.setBounds(280, 29, 41, 16);
		panelAdmin.add(lblEmailAdmin);
		
		JLabel lblChiaverecuperoAdmin = new JLabel("Chiave");
		lblChiaverecuperoAdmin.setBounds(279, 67, 52, 16);
		panelAdmin.add(lblChiaverecuperoAdmin);
		
		JLabel lblLuogoNascitaAdmin = new JLabel("Luogo Nascita");
		lblLuogoNascitaAdmin.setBounds(27, 219, 91, 16);
		panelAdmin.add(lblLuogoNascitaAdmin);
		
		
		//Chiamata controller per l'insert dell'admin
		JButton btnNewButton_1 = new JButton("Aggiungi");
		btnNewButton_1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				//setAmministratore
				Amministratore a = new Amministratore();
				a.setCognome(cognomeAdmin.getText());
				a.setNome(nomeAdmin.getText());
				a.setUsername(usernameAdmin.getText());
				a.setPassword(passwordAdmin.getText());
				a.setLuogo_nascita(luogo_nascitaAdmin.getText());
				a.setTelefono(telefonoAdmin.getText());
				a.setEmail(emailAdmin.getText());
				a.setChiave_recupero(chiave_recuperoAdmin.getText());
				a.setData_nascita(data_nascitaAdmin.getText());
				
				new GestoreAdminController().setAdmin(a);
				dispose();
				JOptionPane.showMessageDialog(null,"Amministratore Aggiunto Correttamente!");
			}
		});
		
		JLabel lblLaChiaveDeve = new JLabel("N.B. La chiave deve essere composta\r\n da 6 cifre");
		lblLaChiaveDeve.setBounds(280, 95, 294, 36);
		panelAdmin.add(lblLaChiaveDeve);
		lblLaChiaveDeve.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_1.setBounds(473, 20, 117, 47);
		panelAdmin.add(btnNewButton_1);
		
		contentPane.add(panelGestore);
		contentPane.add(panelAdmin);
		
		
	
		
	}
}
