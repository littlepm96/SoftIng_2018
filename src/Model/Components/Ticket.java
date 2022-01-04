package Model.Components;

import java.util.Date;

public class Ticket {
	
	int idticket;
	String oggetto;
	String descrizione;
	Date data_invio;
	boolean lettura;
	String destinatario;
	String Mittente;
	String Destinatario;
	String mittente;
	
	public int getIdTicket() {
		return idticket;
	}
	public void setIdTicket(int idTicket) {
		this.idticket = idTicket;
	}
	public boolean isLettura() {
		return lettura;
	}
	public void setLettura(boolean lettura) {
		this.lettura = lettura;
	}
	public String getMittente() {
		return Mittente;
	}
	public void setMittente(String mittente) {
		Mittente = mittente;
	}
	public String getDestinatario1() {
		return destinatario;
	}
	public void setDestinatario1(String destinatario) {
		this.destinatario = destinatario;
	}
	public String getDestinatario() {
		return Destinatario;
	}
	public void setDestinatario(String destinatario) {
		Destinatario = destinatario;
	}
	
	
	public int getId() {
		return idticket;
	}
	public void setId(int id) {
		this.idticket = id;
	}
	public String getOggetto() {
		return oggetto;
	}
	public void setOggetto(String oggetto) {
		this.oggetto = oggetto;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Date getData_invio() {
		return data_invio;
	}
	public void setData_invio(Date data_invio) {
		this.data_invio = data_invio;
	}
	

}
