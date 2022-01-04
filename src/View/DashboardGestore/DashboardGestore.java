package View.DashboardGestore;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.GestoreSensoriController;
import Model.Components.Sensore;
import View.Login;
import View.DashboardAdmin.AdminTicket;
import View.DashboardAdmin.DashboardAdmin;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DashboardGestore extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	static String username;
	static String tipo;
	static String ID;
	DefaultListModel lista;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashboardGestore frame = new DashboardGestore(username,tipo);
					frame.setVisible(true);
					
					/*
					//Viene richiamato il thread ogni minuto per generare i segnali
					Runnable drawRunnable = new Runnable() {
					    public void run() {
					    	System.out.println("Thread");
					     new GestoreSensoriController().setSegnale();
					    }
					};
					
					//Richiama il thread ogni minuto , 1 indica il minuto
					ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);
					exec.scheduleAtFixedRate(drawRunnable , 0, 1, TimeUnit.MINUTES);
					*/
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DashboardGestore(String username,String tipo) {
		//Finestra
		setResizable(false);
		setTitle("Dashboard Gestore "+tipo);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 809, 419);
		
		//Il contentPane contiene gli elementi 
		contentPane = new JPanel();
		contentPane.setToolTipText("Aggiungi Utente");
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Il Panel Ã¨ il menÃ¹ in questo caso 
		JPanel panel_menu = new JPanel();
		panel_menu.setBounds(0, 0, 803, 56);
		contentPane.add(panel_menu);
		panel_menu.setLayout(null);
		
		//Questo panel contiene la textarea
		JPanel panel_area = new JPanel();
		panel_area.setLayout(null);
		panel_area.setBounds(0, 56, 803, 341);
		contentPane.add(panel_area);
		
		//nella textarea printiamo i valori
		JTextArea textArea = new JTextArea();
		textArea.setBounds(598, 51, 186, 284);
		panel_area.add(textArea);
		
		JButton btnSensore = new JButton("Sensore");
		btnSensore.setBounds(609, 53, 117, 36);
		panel_area.add(btnSensore);
		btnSensore.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				ID = textField.getText();
				if(!ID.equals("")) {
				String[] a = new GestoreSensoriController().getSensore(ID);
				JOptionPane.showMessageDialog(null,"I dati del Sensore selezionato sono i seguenti: ID: "+a[0]+" DataManutenzione: "+a[1]+" Stato di Funzionamento: "+a[2]+" Temperatura: "+a[3]+" ° Luminosità: "+a[4]+" lx Pressione: "+a[5]+" bar Umidità: "+a[6]+" %\n Gestore di sua competenza: "+a[7]+" Piano di riferminento: "+a[8]+" nell'edificio con numero civico: "+a[9]+" situata nell'area: "+a[10]+""); 
				} else { JOptionPane.showMessageDialog(null,"Inserisci un ID Sensore"); }
			}
		});
		
		JButton btnListaSensori = new JButton("Lista Sensori");
		btnListaSensori.setBounds(609, 106, 117, 36);
		panel_area.add(btnListaSensori);
		btnListaSensori.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MySensori ms=new MySensori(username,tipo);
				ms.setVisible(true);
			}
		});
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(729, 62, 18, 16);
		panel_area.add(lblId);
		
		textField = new JTextField();
		textField.setForeground(Color.BLACK);
		textField.setBackground(Color.WHITE);
		textField.setBounds(749, 53, 31, 36);
		panel_area.add(textField);
		textField.setVisible(false);
		textField.setColumns(10);
		
		JLabel lblSensoriARischio = new JLabel("Sensori a rischio (Da Ripristinare):");
		lblSensoriARischio.setForeground(Color.RED);
		lblSensoriARischio.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 13));
		lblSensoriARischio.setBounds(10, 11, 227, 14);
		panel_area.add(lblSensoriARischio);
		
		JButton btnRipristinaUnSensore = new JButton("Ripristina un Sensore");
		btnRipristinaUnSensore.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnRipristinaUnSensore.setBounds(242, 8, 166, 32);
		panel_area.add(btnRipristinaUnSensore);
		btnRipristinaUnSensore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RipristinoSensore rs = new RipristinoSensore();
				rs.setVisible(true);
			}
		});
		
		lista=new GestoreSensoriController().getSensoriRischio(username,tipo);
		
		JList list = new JList(lista);
		list.setFont(new Font("Tahoma", Font.PLAIN, 11));
		list.setBounds(6, 51, 587, 329);
		list.setFixedCellHeight(40);
		panel_area.add(list);
		
		//Il bottone Ticket permette di visualizzare un Ticket 
		JButton btnTicket = new JButton("Ticket");
		btnTicket.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnTicket.setIcon(new ImageIcon(DashboardAdmin.class.getResource("/Icons/ticket.png")));
		btnTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestoreTicket gt=new GestoreTicket(username);
				gt.setVisible(true);
			}
		});
		btnTicket.setBounds(173, 7, 116, 40);
		panel_menu.add(btnTicket);
		
		//Il bottone Monitoraggio permette di monitorare 
		JButton btnMonitoraggio = new JButton("Monitoraggio");
		btnMonitoraggio.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnMonitoraggio.setIcon(new ImageIcon(DashboardAdmin.class.getResource("/Icons/monitoraggio.png")));
		btnMonitoraggio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textArea.getBounds().getWidth()==186) {
				textArea.setBounds(6, 51, 0, 329);
				textField.setVisible(true);
				} else {
				textArea.setBounds(598, 51, 186, 284);
				textField.setVisible(false); }
			}
		});
		btnMonitoraggio.setBounds(299, 7, 146, 40);
		panel_menu.add(btnMonitoraggio);
		
		//Questa label permetterÃ  di visualizzare il nome dell'utente loggato
		JLabel lblBentornato = new JLabel("Bentornato "+username);
		lblBentornato.setBounds(10, 19, 153, 16);
		panel_menu.add(lblBentornato);
		
		JButton btnAggiungiSensore = new JButton("Aggiungi Sensore");
		btnAggiungiSensore.setIcon(new ImageIcon(DashboardGestore.class.getResource("/Icons/Industry-Infrared-Sensor-icon.png")));
		btnAggiungiSensore.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnAggiungiSensore.setBounds(455, 7, 199, 40);
		panel_menu.add(btnAggiungiSensore);
		btnAggiungiSensore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreazioneSensoreBackup csb = new CreazioneSensoreBackup(tipo,username);
				csb.setVisible(true);
			}	
		});
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(e -> this.dispose());
		btnLogout.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnLogout.setBounds(664, 7, 116, 40);
		panel_menu.add(btnLogout);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setVisible(true);
			}	
		});
		
		
	
	
	}
}
