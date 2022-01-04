package Model.Components;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Random;

import Model.DB.Database;
import Model.Interfaces.SensoreInterface;

public class Sensore implements SensoreInterface {
	
	Integer idSensore;
	String data_manutenzione;
	String stato;
	String umidita;
	String pressione;
	String luminosita;
	String temperatura;
	String Gestore;
	String piano;
	String edificio;
	String area;
	
	public String getEdificio() {
		return edificio;
	}

	public void setEdificio(String edificio) {
		this.edificio = edificio;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	@Override
	public void setSegnale() {
		
		//Creo al momento un solo sensore, dovrà essere fatto 150k volte
		//Segnale s=new Segnale();
		//s.valore=new Random().nextInt(30-10) + 10;
		
		/*
		for(int i=0;i<150000;i++)
			{
			int s=new Segnale().valore=new Random().nextInt(30-10) + 10;
			System.out.println("i: "+i+" valore"+s);
			}*/
		
		//nome="ALPHA";
		//idArea=1;
		
		//Insert nel DB
		/*Connection c=new Database().Connect();
		Statement st;
		try {
			st = c.createStatement();
			String tot="insert into Sensore values(null,'"+nome+"','"+idArea+"')";
			st.executeUpdate(tot);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		
	}

	@Override
	public void setBackup(BackupValori b) {
		// TODO Auto-generated method stub
				//Database 
				
						//Connessione al Db
						Connection c=new Database().Connect();
						
						//Prende la connessione
								try {
									Statement st = c.createStatement();
									String tot="insert into backupvalori values(null,'"+b.getRange_luminosita()+"','"+b.getRange_pressione()+"','"+b.getRange_temperatura()+"','"+b.getRange_umidita()+"','"+b.getLuminosita_ottimale()+"','"+b.getPressione_ottimale()+"','"+b.getTemperatura_ottimale()+"','"+b.getUmidita_ottimale()+"',"+""+"("+"select ID from sensore order by ID desc limit 1"+")"+""+")";
									st.executeUpdate(tot);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}		
	}
	
	public Integer getIdSensore() {
		return idSensore;
	}

	public String getData_manutenzione() {
		return data_manutenzione;
	}

	public void setData_manutenzione(String data_manutenzione) {
		this.data_manutenzione = data_manutenzione;
	}

	public String isStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getUmidita() {
		return umidita;
	}

	public void setUmidita(String umidita) {
		this.umidita = umidita;
	}

	public String getPressione() {
		return pressione;
	}

	public void setPressione(String pressione) {
		this.pressione = pressione;
	}

	public String getLuminosita() {
		return luminosita;
	}

	public void setLuminosita(String luminosita) {
		this.luminosita = luminosita;
	}

	public String getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}

	public void setIdSensore(Integer idSensore) {
		this.idSensore = idSensore;
	}
	
	public String getPiano() {
		return piano;
	}

	public void setPiano(String piano) {
		this.piano = piano;
	}

	public String getGestore() {
		return Gestore;
	}

	public void setGestore(String gestore) {
		Gestore = gestore;
	}

	
}
