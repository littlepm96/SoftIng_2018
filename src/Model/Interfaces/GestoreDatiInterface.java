package Model.Interfaces;

import java.util.List;

import Model.Components.Segnale;
import Model.Components.Sensore;

public interface GestoreDatiInterface {
	
	public void setSegnale();
	public Segnale getSegnale(int idSegnale);
	public List<Segnale> getSegnaleByIdSensore(int idSensore);
	public void setSensore(Sensore s, String tipo);
	public String[] getSensore(String idSensore);
	public List<Sensore> getSensore();

}
