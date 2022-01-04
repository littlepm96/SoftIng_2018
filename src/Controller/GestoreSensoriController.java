package Controller;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

import Model.Components.BackupValori;
import Model.Components.GestoreDati;
import Model.Components.GestoreUtenza;
import Model.Components.Sensore;
import Model.Components.Ticket;

public class GestoreSensoriController {

	/*
	public void setSegnale() {
	
		new Sensore().setSegnale();
	
	}*/
	
	public String[] getSensore(String idSensore) {
		return new GestoreDati().getSensore(idSensore);
	}
	
	public void setTicket(Ticket t) {
		
		new GestoreUtenza().setTicket(t);
		
	}
	
	public void setSegnale() {
		new GestoreDati().setSegnale();
		
	}
	
	
	public  DefaultListModel getTicket(String username) {
		return new GestoreUtenza().getTicket(username);
	}

	public ArrayList<String> getArea() {
		return new GestoreDati().getArea();
	}
	
	public ArrayList<String> getEdificio() {
		return new GestoreDati().getEdificio();
	}
	
	public ArrayList<String> getPiano() {
		return new GestoreDati().getPiano();
	}
	
	public void setSensore(Sensore s,String tipo) {
		new GestoreDati().setSensore(s,tipo);
	}
	
	public  DefaultListModel getSensori(String username,String tipo) {
		return new GestoreDati().getSensori(username,tipo);
	}
	
	public  DefaultListModel getSensoriRischio(String username,String tipo) {
		return new GestoreDati().getSensoriRischio(username,tipo);
	}
	
	public void ripristino(String ID) {
		new GestoreDati().ripristino(ID);
	}
}

