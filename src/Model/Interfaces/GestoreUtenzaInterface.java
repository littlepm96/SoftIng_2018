package Model.Interfaces;

import java.util.List;

import javax.swing.DefaultListModel;

import Model.Components.Amministratore;
import Model.Components.GestoreSensori;
import Model.Components.Ticket;

public interface GestoreUtenzaInterface {
	
	public void setGestore(GestoreSensori g);
	public GestoreSensori getGestore(int idGestore);
	public List<GestoreSensori> getGestore();
	public void setAdmin(Amministratore a);
	public Amministratore getAdmin(int idAdmin);
	public List<Amministratore> getAdmin();
	public String login(String username,String password);
	public DefaultListModel getTicket(String username);
	public void setTicket(Ticket t);
	public void setRisposta(int id,String risposta);

}
