package View.DashboardGestore;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Controller.GestoreAdminController;
import Controller.GestoreSensoriController;
import Model.Components.BackupValori;
import Model.Components.Sensore;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;


public class CreazioneSensoreBackup extends JFrame {

	private JPanel contentPane;
	private JTextField datamanutenzione;
	private JTextField stato;
	private JTextField temperatura;
	private JTextField luminosita;
	private JTextField pressione;
	private JTextField umidita;
	private JTextField rangeluminosita;
	private JTextField rangepressione;
	private JTextField rangetemperatura;
	private JTextField rangeumidita;
	private JTextField luminositaottimale;
	private JTextField pressioneottimale;
	private JTextField temperaturaottimale;
	private JTextField umiditaottimale;
	static String tipo;
	static String username;
	String datamanutenzionevar;
	String statovar;
	String temperaturavar;
	String luminositavar;
	String pressionevar;
	String umiditavar;
	String rangeluminositavar;
	String rangepressionevar;
	String rangetemperaturavar;
	String rangeumiditavar;
	String temperaturaottimalevar;
	String luminositaottimalevar;
	String pressioneottimalevar;
	String umiditaottimalevar;
	String areaselected;
	String edificioselected;
	ArrayList<String> areavarlist;
	String[] areavar;
	ArrayList<String> edificiovarlist;
	String[] edificiovar;
	ArrayList<String> pianovarlist;
	String[] pianovar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreazioneSensoreBackup frame = new CreazioneSensoreBackup(tipo,username);
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
	public CreazioneSensoreBackup(String tipo, String username) {
		setTitle("Aggiungi Sensore e Backup");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 755, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSensore = new JLabel("Sensore:");
		lblSensore.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSensore.setBounds(10, 11, 100, 28);
		contentPane.add(lblSensore);
		
		JLabel lblBackup = new JLabel("Backup:");
		lblBackup.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBackup.setBounds(375, 14, 89, 23);
		contentPane.add(lblBackup);
		
		JLabel lblDataDellaManutenzione = new JLabel("Data della Manutenzione:");
		lblDataDellaManutenzione.setBounds(10, 47, 143, 14);
		contentPane.add(lblDataDellaManutenzione);
		
		datamanutenzione = new JTextField();
		datamanutenzione.setText("yyyy-mm-dd");
		datamanutenzione.setBounds(174, 43, 132, 23);
		contentPane.add(datamanutenzione);
		datamanutenzione.setColumns(10);
		
		JLabel lblStatoDiFunzionamento = new JLabel("Stato di Funzionamento:");
		lblStatoDiFunzionamento.setBounds(10, 72, 143, 14);
		contentPane.add(lblStatoDiFunzionamento);
		
		JLabel lblNbFunziona = new JLabel("N.B. 0 Funziona 1 Guasto");
		lblNbFunziona.setBounds(10, 91, 143, 14);
		contentPane.add(lblNbFunziona);
		
		stato = new JTextField();
		stato.setText("0/1");
		stato.setBounds(174, 77, 132, 23);
		contentPane.add(stato);
		stato.setColumns(10);
		
		JLabel lblTemperatura = new JLabel("Temperatura:");
		lblTemperatura.setBounds(10, 121, 143, 14);
		contentPane.add(lblTemperatura);
		
		temperatura = new JTextField();
		temperatura.setBounds(174, 115, 132, 23);
		contentPane.add(temperatura);
		temperatura.setColumns(10);
		
		JLabel lblLuminosit = new JLabel("Luminosit\u00E0:");
		lblLuminosit.setBounds(10, 146, 143, 14);
		contentPane.add(lblLuminosit);
		
		luminosita = new JTextField();
		luminosita.setBounds(174, 143, 132, 20);
		contentPane.add(luminosita);
		luminosita.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Pressione:");
		lblNewLabel.setBounds(10, 171, 143, 14);
		contentPane.add(lblNewLabel);
		
		pressione = new JTextField();
		pressione.setBounds(174, 168, 132, 20);
		contentPane.add(pressione);
		pressione.setColumns(10);
		
		JLabel lblUmidit = new JLabel("Umidit\u00E0:");
		lblUmidit.setBounds(10, 194, 143, 14);
		contentPane.add(lblUmidit);
		
		umidita = new JTextField();
		umidita.setBounds(174, 191, 132, 20);
		contentPane.add(umidita);
		umidita.setColumns(10);
		
		JLabel lblArea = new JLabel("Area:");
		lblArea.setBounds(10, 219, 143, 14);
		contentPane.add(lblArea);
		
		areavarlist = new GestoreSensoriController().getArea();
		areavar = new String[areavarlist.size()];
		JComboBox<String> area = new JComboBox(areavarlist.toArray(areavar));
		area.setMaximumRowCount(50);
		area.setBounds(174, 216, 132, 20);
		contentPane.add(area);
		
		JLabel lblEdificio = new JLabel("Edificio:");
		lblEdificio.setBounds(10, 244, 143, 14);
		contentPane.add(lblEdificio);
		
		edificiovarlist = new GestoreSensoriController().getEdificio();
		edificiovar = new String[edificiovarlist.size()];
		JComboBox<String> edificio = new JComboBox(edificiovarlist.toArray(edificiovar));
		edificio.setMaximumRowCount(50);
		edificio.setBounds(174, 241, 132, 20);
		contentPane.add(edificio);
		
		JLabel lblPiano = new JLabel("Piano:");
		lblPiano.setBounds(10, 269, 143, 14);
		contentPane.add(lblPiano);
		
		pianovarlist = new GestoreSensoriController().getPiano();
		for (int i = 1; i <pianovarlist.size(); i++) { 
			if (pianovarlist.indexOf(pianovarlist.get(i)) < pianovarlist.lastIndexOf(pianovarlist.get(i))) {
			pianovarlist.remove(pianovarlist.lastIndexOf(pianovarlist.get(i)));
			i--; 
			} 
			} 
		pianovar = new String[pianovarlist.size()];
		JComboBox<String> piano = new JComboBox(pianovarlist.toArray(pianovar));
		piano.setMaximumRowCount(50);
		piano.setBounds(174, 266, 132, 20);
		contentPane.add(piano);
		
		JLabel lblRangeluminosit = new JLabel("RangeLuminosit\u00E0:");
		lblRangeluminosit.setBounds(375, 47, 132, 14);
		contentPane.add(lblRangeluminosit);
		
		rangeluminosita = new JTextField();
		rangeluminosita.setText("350");
		rangeluminosita.setBounds(517, 44, 157, 20);
		contentPane.add(rangeluminosita);
		rangeluminosita.setColumns(10);
		
		JLabel lblRangepressione = new JLabel("RangePressione:");
		lblRangepressione.setBounds(375, 72, 132, 14);
		contentPane.add(lblRangepressione);
		
		rangepressione = new JTextField();
		rangepressione.setText("2");
		rangepressione.setBounds(517, 69, 157, 20);
		contentPane.add(rangepressione);
		rangepressione.setColumns(10);
		
		JLabel lblRangetemperatura = new JLabel("RangeTemperatura:");
		lblRangetemperatura.setBounds(375, 97, 132, 14);
		contentPane.add(lblRangetemperatura);
		
		rangetemperatura = new JTextField();
		rangetemperatura.setText("35");
		rangetemperatura.setBounds(517, 94, 157, 20);
		contentPane.add(rangetemperatura);
		rangetemperatura.setColumns(10);
		
		JLabel lblRangeumidit = new JLabel("RangeUmidit\u00E0:");
		lblRangeumidit.setBounds(375, 121, 132, 14);
		contentPane.add(lblRangeumidit);
		
		rangeumidita = new JTextField();
		rangeumidita.setText("90");
		rangeumidita.setBounds(517, 118, 157, 20);
		contentPane.add(rangeumidita);
		rangeumidita.setColumns(10);
		
		JLabel lblLuminositOttimale = new JLabel("Luminosit\u00E0 Ottimale:");
		lblLuminositOttimale.setBounds(375, 146, 132, 14);
		contentPane.add(lblLuminositOttimale);
		
		luminositaottimale = new JTextField();
		luminositaottimale.setText("225");
		luminositaottimale.setBounds(517, 143, 157, 20);
		contentPane.add(luminositaottimale);
		luminositaottimale.setColumns(10);
		
		JLabel lblPressioneottimale = new JLabel("PressioneOttimale:");
		lblPressioneottimale.setBounds(375, 171, 132, 14);
		contentPane.add(lblPressioneottimale);
		
		pressioneottimale = new JTextField();
		pressioneottimale.setText("1");
		pressioneottimale.setBounds(517, 168, 157, 20);
		contentPane.add(pressioneottimale);
		pressioneottimale.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("TemperaturaOttimale:");
		lblNewLabel_1.setBounds(375, 194, 132, 14);
		contentPane.add(lblNewLabel_1);
		
		temperaturaottimale = new JTextField();
		temperaturaottimale.setText("23");
		temperaturaottimale.setBounds(517, 191, 157, 20);
		contentPane.add(temperaturaottimale);
		temperaturaottimale.setColumns(10);
		
		JLabel lblUmiditottimale = new JLabel("Umidit\u00E0Ottimale:");
		lblUmiditottimale.setBounds(375, 219, 132, 14);
		contentPane.add(lblUmiditottimale);
		
		umiditaottimale = new JTextField();
		umiditaottimale.setText("70");
		umiditaottimale.setBounds(517, 216, 157, 20);
		contentPane.add(umiditaottimale);
		umiditaottimale.setColumns(10);
		
		JLabel lblNbIlRange = new JLabel("N.B. Il Range indica il valore che non deve essere SUPERATO");
		lblNbIlRange.setBounds(375, 244, 354, 14);
		contentPane.add(lblNbIlRange);
		
		JButton btnAggiungiSensore = new JButton("Aggiungi Sensore e Backup");
		btnAggiungiSensore.setFont(new Font("Dialog", Font.BOLD, 13));
		btnAggiungiSensore.setBounds(421, 294, 226, 34);
		contentPane.add(btnAggiungiSensore);
		if(tipo.equals("Città")) {
			piano.setVisible(false);
			edificio.setVisible(false);
			lblEdificio.setVisible(false);
			lblPiano.setVisible(false);
		}
		if(tipo.equals("Area")) {
			piano.setVisible(false);
			lblPiano.setVisible(false);
		}
		
		btnAggiungiSensore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datamanutenzionevar = datamanutenzione.getText();
				statovar = stato.getText();
				temperaturavar = temperatura.getText();
				luminositavar = luminosita.getText();
				pressionevar = pressione.getText();
				umiditavar = umidita.getText();
				rangeluminositavar = rangeluminosita.getText();
				rangepressionevar = rangepressione.getText();
				rangetemperaturavar = rangetemperatura.getText();
				rangeumiditavar = rangeumidita.getText();
				luminositaottimalevar = luminositaottimale.getText();
				pressioneottimalevar = pressioneottimale.getText();
				temperaturaottimalevar = temperaturaottimale.getText();
				umiditaottimalevar = umiditaottimale.getText();
				
				if (!datamanutenzionevar.equals("") && !statovar.equals("") && !temperaturavar.equals("") && !luminositavar.equals("") &&!pressionevar.equals("") &&!umiditavar.equals("") &&!rangeluminositavar.equals("") && !rangepressionevar.equals("") &&!rangetemperaturavar.equals("") &&!luminositaottimalevar.equals("") &&!pressioneottimalevar.equals("") &&!temperaturaottimalevar.equals("") &&!umiditaottimalevar.equals("")  ) {
					//SetSensore
					Sensore s = new Sensore();
					s.setData_manutenzione(datamanutenzionevar);
					s.setStato(statovar);
					s.setTemperatura(temperaturavar);
					s.setLuminosita(luminositavar);
					s.setPressione(pressionevar);
					s.setUmidita(umiditavar);
					s.setGestore(username);
					if(tipo.equals("Città")) { s.setArea(area.getSelectedItem().toString()); }
					if(tipo.equals("Area")){ s.setArea(area.getSelectedItem().toString()); s.setEdificio(edificio.getSelectedItem().toString()); }
					if(tipo.equals("Edificio")) { s.setArea(area.getSelectedItem().toString()); s.setEdificio(edificio.getSelectedItem().toString()); s.setPiano(piano.getSelectedItem().toString());}
					
					new GestoreSensoriController().setSensore(s,tipo);
					
					//SetBackup
					BackupValori b = new BackupValori();
					b.setRange_luminosita(rangeluminositavar);
					b.setRange_pressione(rangepressionevar);
					b.setRange_temperatura(rangetemperaturavar);
					b.setRange_umidita(rangeumiditavar);
					b.setLuminosita_ottimale(luminositaottimalevar);
					b.setPressione_ottimale(pressioneottimalevar);
					b.setTemperatura_ottimale(temperaturaottimalevar);
					b.setUmidita_ottimale(umiditaottimalevar);
					
					new Sensore().setBackup(b);
					
					dispose();
					JOptionPane.showMessageDialog(null,"Sensore e Backup aggiunti correttamente!");
					
				} else { JOptionPane.showMessageDialog(null,"Riempire tutti i campi");}
			}	
		});
	}
}
