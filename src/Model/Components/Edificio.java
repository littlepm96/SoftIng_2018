package Model.Components;

public class Edificio {
	
	int ncivico; 
	int capienza;
	String dimensione;
	String tipologia;
	String Area;
	
	public int getNCivico() {
		return ncivico;
	}
	public void setNCivico(int nCivico) {
		ncivico = nCivico;
	}
	public String getArea() {
		return Area;
	}
	public void setArea(String area) {
		Area = area;
	}
	
	public int getCapienza() {
		return capienza;
	}
	public void setCapienza(int capienza) {
		this.capienza = capienza;
	}
	public String getDimensione() {
		return dimensione;
	}
	public void setDimensione(String dimensione) {
		this.dimensione = dimensione;
	}
	public String getTipologia() {
		return tipologia;
	}
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	

}
