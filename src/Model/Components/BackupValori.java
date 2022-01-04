package Model.Components;

public class BackupValori {
	
	String umidita_ottimale;
	String pressione_ottimale;
	String luminosita_ottimale;
	String temperatura_ottimale;
	String range_temperatura;
	String range_umidita;
	String range_pressione;
	String range_luminosita;
	Integer Sensore;
	int id;
	
	public Integer getSensore() {
		return Sensore;
	}
	public void setSensore(Integer sensore) {
		Sensore = sensore;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUmidita_ottimale() {
		return umidita_ottimale;
	}
	public void setUmidita_ottimale(String umidita_ottimale) {
		this.umidita_ottimale = umidita_ottimale;
	}
	public String getPressione_ottimale() {
		return pressione_ottimale;
	}
	public void setPressione_ottimale(String pressione_ottimale) {
		this.pressione_ottimale = pressione_ottimale;
	}
	public String getLuminosita_ottimale() {
		return luminosita_ottimale;
	}
	public void setLuminosita_ottimale(String luminosita_ottimale) {
		this.luminosita_ottimale = luminosita_ottimale;
	}
	public String getTemperatura_ottimale() {
		return temperatura_ottimale;
	}
	public void setTemperatura_ottimale(String temperatura_ottimale) {
		this.temperatura_ottimale = temperatura_ottimale;
	}
	public String getRange_temperatura() {
		return range_temperatura;
	}
	public void setRange_temperatura(String range_temperatura) {
		this.range_temperatura = range_temperatura;
	}
	public String getRange_umidita() {
		return range_umidita;
	}
	public void setRange_umidita(String range_umidita) {
		this.range_umidita = range_umidita;
	}
	public String getRange_pressione() {
		return range_pressione;
	}
	public void setRange_pressione(String range_pressione) {
		this.range_pressione = range_pressione;
	}
	public String getRange_luminosita() {
		return range_luminosita;
	}
	public void setRange_luminosita(String range_luminosita) {
		this.range_luminosita = range_luminosita;
	}
	
	

}
