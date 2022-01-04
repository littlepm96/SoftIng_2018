package Controller;

import Model.Components.Amministratore;
import Model.Components.GestoreSensori;
import Model.Components.GestoreUtenza;

public class GestoreAdminController {
	
	public String[] getAdmin_byKey (String chiave) {
		return new GestoreUtenza().getAdmin_byKey(chiave);
	}
	
	 public void setAdmin(Amministratore a) {
		new GestoreUtenza().setAdmin(a);
	}

	 public void setGestore(GestoreSensori g) {
		 new GestoreUtenza().setGestore(g);
	}
	 
	 public void setRisposta(int id,String risposta) {
		 
		 new GestoreUtenza().setRisposta(id, risposta);
		 
	 }
}
