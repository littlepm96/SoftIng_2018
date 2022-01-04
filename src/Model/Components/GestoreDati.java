package Model.Components;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.DefaultListModel;

import Model.DB.Database;
import Model.Interfaces.GestoreDatiInterface;

public class GestoreDati implements GestoreDatiInterface{

	
	//Vengono settati i segnali 
	@Override
	public void setSegnale() {	
		String[] a = new String[5];
		Connection c=new Database().Connect();
		Statement st;
		Statement st2;
		try {
			st = c.createStatement();
			ResultSet rs = st.executeQuery("select Stato, Luminosit‡, Pressione, Temperatura, Umidit‡ from sensore");
			while(rs.next()) {
				a[0]=rs.getString("Stato");
				a[1]=rs.getString("Luminosit‡");
				a[2]=rs.getString("Pressione");
				a[3]=rs.getString("Temperatura");
				a[4]=rs.getString("Umidit‡");
			}
			//100
			//st.executeUpdate("insert into segnale values(null,null,null,"+rand.nextBoolean()+","+rand.nextInt(45)+","+rand.nextInt(45)+","+rand.nextInt(45)+","+rand.nextInt(45)+","+Math.random() * 10 + 1+")");	
			//st.executeUpdate("insert into segnale values(null,null,null,"+rand.nextBoolean()+","+rand.nextInt(45)+","+rand.nextInt(45)+","+rand.nextInt(45)+","+rand.nextInt(45)+","+Math.random() * 10 + 1+")");	
			//st.executeUpdate("insert into segnale values(null,null,null,"+rand.nextBoolean()+","+rand.nextInt(45)+","+rand.nextInt(45)+","+rand.nextInt(45)+","+rand.nextInt(45)+","+Math.random() * 10 + 1+")");	
			//st.executeUpdate("insert into segnale values(null,null,null,"+rand.nextBoolean()+","+rand.nextInt(45)+","+rand.nextInt(45)+","+rand.nextInt(45)+","+rand.nextInt(45)+","+Math.random() * 10 + 1+")");	
			//st.executeUpdate("insert into segnale values(null,null,null,"+rand.nextBoolean()+","+rand.nextInt(45)+","+rand.nextInt(45)+","+rand.nextInt(45)+","+rand.nextInt(45)+","+Math.random() * 10 + 1+")");	
			//st.executeUpdate("insert into segnale values(null,null,null,"+rand.nextBoolean()+","+rand.nextInt(45)+","+rand.nextInt(45)+","+rand.nextInt(45)+","+rand.nextInt(45)+","+Math.random() * 10 + 1+")");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			st2 = c.createStatement();
			st2.executeQuery("insert into segnale(Stato, Temperatura, Luminosit‡, Pressione, Umidit‡) values ('"+a[0]+"','"+a[3]+"','"+a[1]+"','"+a[2]+"','"+a[4]+"' ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Segnale getSegnale(int idSegnale) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Segnale> getSegnaleByIdSensore(int idSensore) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSensore(Sensore s,String tipo) {
		// TODO Auto-generated method stub
		//Database 
		
				//Connessione al Db
				Connection c=new Database().Connect();
				Statement st;
				//Prende la connessione
						try {
							if(tipo.equals("Edificio")) {
								st = c.createStatement();
								String tot="insert into sensore(DataManutenzione, Stato, Temperatura, Luminosit‡, Pressione, Umidit‡, Gestore, Piano, Edificio, Area) values('"+s.getData_manutenzione()+"','"+s.isStato()+"','"+s.getTemperatura()+"','"+s.getLuminosita()+"','"+s.getPressione()+"','"+s.getUmidita()+"','"+s.getGestore()+"','"+s.getPiano()+"','"+s.getEdificio()+"','"+s.getArea()+"')";
								st.executeUpdate(tot);
							}
							if(tipo.equals("Area")) {
								st = c.createStatement();
							    String tot="insert into sensore(DataManutenzione, Stato, Temperatura, Luminosit‡, Pressione, Umidit‡, Gestore, Edificio, Area) values('"+s.getData_manutenzione()+"','"+s.isStato()+"','"+s.getTemperatura()+"','"+s.getLuminosita()+"','"+s.getPressione()+"','"+s.getUmidita()+"','"+s.getGestore()+"','"+s.getEdificio()+"','"+s.getArea()+"')";
							    st.executeUpdate(tot);
							}
							if(tipo.equals("Citt‡")) {
								st = c.createStatement();
								String tot="insert into sensore(DataManutenzione, Stato, Temperatura, Luminosit‡, Pressione, Umidit‡, Gestore, Area) values('"+s.getData_manutenzione()+"','"+s.isStato()+"','"+s.getTemperatura()+"','"+s.getLuminosita()+"','"+s.getPressione()+"','"+s.getUmidita()+"','"+s.getGestore()+"','"+s.getArea()+"')";
								st.executeUpdate(tot);
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}		
	}

	@Override
	public String[] getSensore (String idSensore) {
		// TODO Auto-generated method stub
				//Database 
			    String[] a = new String[11];
				//Connessione al Db
				Connection c=new Database().Connect();
				//Prende la connessione
				try {
						Statement st = c.createStatement();
						ResultSet rs = st.executeQuery("select * from sensore where ID='"+idSensore+"' ");
						while(rs.next()) {
						a[0]=rs.getString("ID");
						a[1]=rs.getString("DataManutenzione");
						a[2]=rs.getString("Stato");
						a[3]=rs.getString("Temperatura");
						a[4]=rs.getString("Luminosit‡");
						a[5]=rs.getString("Pressione");
						a[6]=rs.getString("Umidit‡");
						a[7]=rs.getString("Gestore");
						a[8]=rs.getString("Piano");
						a[9]=rs.getString("Edificio");
						a[10]=rs.getString("Area");
						}
				} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				}
				return a;
	}

	@Override
	public List<Sensore> getSensore() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<String> getArea() {
		// TODO Auto-generated method stub
		//Database 
		ArrayList<String> alist=new ArrayList<String>();
		
		//Connessione al Db
		Connection c=new Database().Connect();
		//Prende la connessione
		
		try {
				Statement st = c.createStatement();
				ResultSet rs = st.executeQuery("select * from area");
				while(rs.next()) {
				alist.add(rs.getString("Coordinate"));
				}
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		return alist;
	}
	
	public ArrayList<String> getEdificio() {
		// TODO Auto-generated method stub
				//Database 
				ArrayList<String> elist=new ArrayList<String>();
				
				//Connessione al Db
				Connection c=new Database().Connect();
				//Prende la connessione
				
				try {
						Statement st = c.createStatement();
						ResultSet rs = st.executeQuery("select * from edificio");
						while(rs.next()) {
						elist.add(rs.getString("NCivico"));
						}
				} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				}
				return elist;
	}
	
	public ArrayList<String> getPiano() {
		// TODO Auto-generated method stub
		//Database 
		ArrayList<String> plist=new ArrayList<String>();
		
		//Connessione al Db
		Connection c=new Database().Connect();
		//Prende la connessione
		
		try {
				Statement st = c.createStatement();
				ResultSet rs = st.executeQuery("select * from piano");
				while(rs.next()) {
				plist.add(rs.getString("IdPiano"));
				
				}
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		return plist;
	}
	
public DefaultListModel getSensori(String username,String tipo) {
		
		DefaultListModel dfm = new DefaultListModel();
		ResultSet result;
		
		//Prendo dal Database i sensori
		Connection myConn=Database.Connect();
		Statement st;
		try {
			st = myConn.createStatement();
			
			//
			 result=st.executeQuery("select * from sensore where Gestore='"+username+"' ");
			 
			 if(tipo.equals("Edificio")) {
				while(result.next()) {
			     dfm.addElement("ID Sensore : "+result.getInt("ID")+" DataManutenzione: "+result.getDate("DataManutenzione")+" Stato: "+result.getInt("Stato")+" Temperatura: "+result.getInt("Temperatura")+" ∞ Luminosit‡: "+result.getInt("Luminosit‡")+" lx Pressione: "+result.getInt("Pressione")+" bar Umidit‡: "+result.getInt("Umidit‡")+" % Piano: "+result.getInt("Piano")+" Edificio con numero civico: "+result.getInt("Edificio")+" Area: "+result.getString("Area")+"");
			    // dfm.addElement(result.getString("Descrizione"));
				}
			 }
			 if(tipo.equals("Area")) {
					while(result.next()) {
				     dfm.addElement("ID Sensore : "+result.getInt("ID")+" DataManutenzione: "+result.getDate("DataManutenzione")+" Stato: "+result.getInt("Stato")+" Temperatura: "+result.getInt("Temperatura")+" ∞ Luminosit‡: "+result.getInt("Luminosit‡")+" lx Pressione: "+result.getInt("Pressione")+" bar Umidit‡: "+result.getInt("Umidit‡")+" % Edificio con numero civico: "+result.getInt("Edificio")+" Area: "+result.getString("Area")+"");
				    // dfm.addElement(result.getString("Descrizione"));
					}
				 }
			 if(tipo.equals("Citt‡")) {
					while(result.next()) {
				     dfm.addElement("ID Sensore : "+result.getInt("ID")+" DataManutenzione: "+result.getDate("DataManutenzione")+" Stato: "+result.getInt("Stato")+" Temperatura: "+result.getInt("Temperatura")+" ∞ Luminosit‡: "+result.getInt("Luminosit‡")+" lx Pressione: "+result.getInt("Pressione")+" bar Umidit‡: "+result.getInt("Umidit‡")+" % Area: "+result.getString("Area")+"");
				    // dfm.addElement(result.getString("Descrizione"));
					}
				 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dfm;
	}

public DefaultListModel getSensoriRischio(String username,String tipo) {
	
	DefaultListModel dfm = new DefaultListModel();
	ResultSet result;
	
	//Prendo dal Database i sensori
	Connection myConn=Database.Connect();
	Statement st;
	try {
		st = myConn.createStatement();
		String query="select * from sensore,backupvalori where sensore.ID=backupvalori.Sensore AND backupvalori.Sensore=sensore.ID AND Gestore='"+username+"' AND (sensore.stato = 1 OR sensore.Temperatura > backupvalori.RangeTemperatura OR sensore.Luminosit‡ > backupvalori.RangeLuminosit‡ OR sensore.Pressione > backupvalori.RangePressione OR sensore.Umidit‡ > backupvalori.RangeUmidit‡)";
		result=st.executeQuery(query);
		 
		 if(tipo.equals("Edificio")) {
			while(result.next()) {
		    dfm.addElement("ID: "+result.getInt("ID")+" Stato: "+result.getInt("Stato")+" Temperatura: "+result.getInt("Temperatura")+" ∞ Luminosit‡: "+result.getInt("Luminosit‡")+" lx Pressione: "+result.getInt("Pressione")+" bar Umidit‡: "+result.getInt("Umidit‡")+" % Piano: "+result.getInt("Piano")+"");
			}
		 }
		 if(tipo.equals("Area")) {
			while(result.next()) {
			  dfm.addElement("ID: "+result.getInt("ID")+" Stato: "+result.getInt("Stato")+" Temperatura: "+result.getInt("Temperatura")+" ∞ Luminosit‡: "+result.getInt("Luminosit‡")+" lx Pressione: "+result.getInt("Pressione")+" bar Umidit‡: "+result.getInt("Umidit‡")+" % Edificio: "+result.getInt("Edificio")+"");
			}
		 }
		 if(tipo.equals("Citt‡")) {
			while(result.next()) {
		     dfm.addElement("ID: "+result.getInt("ID")+" Stato: "+result.getInt("Stato")+" Temperatura: "+result.getInt("Temperatura")+" ∞ Luminosit‡: "+result.getInt("Luminosit‡")+" lx Pressione: "+result.getInt("Pressione")+" bar Umidit‡: "+result.getInt("Umidit‡")+" % Area: "+result.getString("Area")+"");
			}
		 }	 
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return dfm;
}

public void ripristino(String ID) {
	String[] a = new String[4];
	Connection c=new Database().Connect();
	Statement st;
	Statement st2;
	//Prende la connessione
	
	try {
			st = c.createStatement();
			ResultSet rs = st.executeQuery("select Luminosit‡Ottimale, PressioneOttimale, TemperaturaOttimale, Umidit‡Ottimale from backupvalori where Sensore='"+ID+"'");
			while(rs.next()) {
				a[0]=rs.getString("TemperaturaOttimale");
				a[1]=rs.getString("Luminosit‡Ottimale");
				a[2]=rs.getString("PressioneOttimale");
				a[3]=rs.getString("Umidit‡Ottimale");
			}
	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
	try {
		st2 = c.createStatement();
		st2.executeUpdate("update sensore set Stato=0, Temperatura='"+a[0]+"', Luminosit‡='"+a[1]+"', Pressione='"+a[2]+"', Umidit‡='"+a[3]+"' where ID='"+ID+"'");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
