package Model.Components;

import java.sql.Time;
import java.util.Date;

public class Segnale {
	
	int id; 
	Time ora;
	Date data; 
	int umidita; 
	boolean stato; 
	int temperatura;
	int luminosita; 
	int pressione;
	int idsensore;
	
	//Costruttore
	public Segnale(int id, Time ora, Date data, int umidita, boolean stato, int temperatura, int luminosita,
			int pressione, int idsensore) {
		super();
		this.id = id;
		this.ora = ora;
		this.data = data;
		this.umidita = umidita;
		this.stato = stato;
		this.temperatura = temperatura;
		this.luminosita = luminosita;
		this.pressione = pressione;
		this.idsensore = idsensore;
	}


	public Time getOra() {
		return ora;
	}
	public void setOra(Time ora) {
		this.ora = ora;
	}
	public int getIdsensore() {
		return idsensore;
	}
	public void setIdsensore(int idsensore) {
		this.idsensore = idsensore;
	}
	
	public int getId_sensore() {
		return getId_sensore();
	}
	public void setId_sensore(int id_sensore) {
		this.idsensore = id_sensore;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getOrario() {
		return getOrario();
	}
	public void setOrario(Time orario) {
		this.ora = orario;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getUmidita() {
		return umidita;
	}
	public void setUmidita(int umidita) {
		this.umidita = umidita;
	}
	public boolean isStato() {
		return stato;
	}
	public void setStato(boolean stato) {
		this.stato = stato;
	}
	public int getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}
	public int getLuminosita() {
		return luminosita;
	}
	public void setLuminosita(int luminosita) {
		this.luminosita = luminosita;
	}
	public int getPressione() {
		return pressione;
	}
	public void setPressione(int pressione) {
		this.pressione = pressione;
	}
		
}
