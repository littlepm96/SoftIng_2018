package Model.Components;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import Model.DB.Database;
import Model.Interfaces.GestoreUtenzaInterface;

public class GestoreUtenza implements GestoreUtenzaInterface{

	@Override
	public void setGestore(GestoreSensori g) {
		
		//Database 
		
		//Connessione al Db
		Connection c=new Database().Connect();
		
		//Prende la connessione
		try {
			Statement st = c.createStatement();
			String tot="insert into gestoresensori values('"+g.getUsername()+"','"+g.getPassword()+"','"+g.getNome()+"','"+g.getCognome()+"','"+g.getTipo()+"','"+g.getLuogo_nascita()+"','"+g.getData_nascita()+"','"+g.getEmail()+"','"+g.getTelefono()+"')";
			st.executeUpdate(tot);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public GestoreSensori getGestore(int idGestore) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GestoreSensori> getGestore() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAdmin(Amministratore a) {
		//Database 
		
		//Connessione al Db
		Connection c=new Database().Connect();
		
		//Prende la connessione
				try {
					Statement st = c.createStatement();
					String tot="insert into amministratore values('"+a.getUsername()+"','"+a.getPassword()+"','"+a.getNome()+"','"+a.getCognome()+"','"+a.getData_nascita()+"','"+a.getLuogo_nascita()+"','"+a.getTelefono()+"','"+a.getEmail()+"','"+a.getChiave_recupero()+"')";
					st.executeUpdate(tot);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
				
	}

	@Override
	public Amministratore getAdmin(int idAdmin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Amministratore> getAdmin() {
		// TODO Auto-generated method stub
		return null;
	}

	//Effettuiamo la logica del login
	@Override
	public String login(String username, String password) {
		
		
		
		//Connessione al database per prendere i dati
		Connection con=new Database().Connect();
		try {
			Statement st=con.createStatement();
			
			//Controlliamo se l'utente loggato è un admin mediante la query su amministratore 
			
			
			System.out.println(username);
			System.out.println(password);
			
			ResultSet result=st.executeQuery("select * from amministratore where Username='"+username+"'and Password='"+password+"'");
			
			// se è admin 
			if(result.next()) {
					
				return "amministratore";
				
			}

			
			//Se l'utente non è un admin verifichiamo se è un gestore 
			//Se è un gestore allora andiamo a vedere di che tipo è , quindi faremo una query per prenderci l'attributo tipo
			
			 result=st.executeQuery("select * from gestoresensori where Username='"+username+"'and Password='"+password+"'");
			
			 if(result.next()) {
				 System.out.println(result.getString("Tipo"));
				 return result.getString("Tipo");
				 	 
			 }
			
		

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Se l'utente non è ne admin e ne Gestore 
		return "";
	}

	@Override
	public DefaultListModel getTicket(String username) {
		
		DefaultListModel dfm = new DefaultListModel();
		ResultSet result;
		
		//Prendo dal Database i ticket con Lettura = 0 
		Connection myConn=Database.Connect();
		Statement st;
		try {
			st = myConn.createStatement();
			
			//
			 result=st.executeQuery("select * from ticket where Lettura=0 and Destinatario='"+username+"' order by DataInvio");
			 

				while(result.next()) {
					
			     dfm.addElement("ID Ticket: "+result.getInt("IdTicket")+"  Oggetto:  "+result.getString("Oggetto")+"  Descrizione:  "+result.getString("Descrizione"));
			    // dfm.addElement(result.getString("Descrizione"));
					
			}
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dfm;
	}

	@Override
	public void setTicket(Ticket t)  {
		Connection c=Database.Connect();
		Statement st;
		try {
			st = c.createStatement();
			String tot="insert into ticket values(null,'"+t.getOggetto()+"','"+t.getDescrizione()+"',null,'"+t.getMittente()+"',0,'"+t.getDestinatario()+"')";
			st.executeUpdate(tot);	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public void setRisposta(int id,String risposta) {
		
		Connection c=Database.Connect();
		Statement st;
		try {
			Connection myConn=Database.Connect();
			st=myConn.createStatement();
			st.executeUpdate("update ticket set Descrizione='"+risposta+"' where IdTicket='"+id+"'");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("null")
	public String[] getAdmin_byKey (String chiave) {
		// TODO Auto-generated method stub
		//Database 
	    String[] a = new String[2];
		//Connessione al Db
		Connection c=new Database().Connect();
		//Prende la connessione
		try {
				Statement st = c.createStatement();
				ResultSet rs = st.executeQuery("select Username, Password from amministratore where ChiaveDiRecupero='"+chiave+"' ");
				while(rs.next()) {
				a[0]=rs.getString("Username");
				a[1]=rs.getString("Password");
				}
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		return a;
	}

}
