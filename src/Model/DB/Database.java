package Model.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Qui va il collegamento al Database
public class Database {
	
	private static String LOCATION="jdbc:mysql://localhost:3306/monitoraggioambientale?serverTimezone=UTC";
			//monitoraggioambientale?characterEncoding=UTF-8&useSSL=false";
			//characterEncoding=UTF-8&useSSL=false?";
	private static String NAME="root";
	private static String PSW="root";
	
	
	//Effettua connessione DB
	public static Connection Connect() {
		
		Connection myConn;
		
		try {
			myConn=DriverManager.getConnection(LOCATION,NAME,PSW);
			System.out.println("\n----Connessione Effettuata Corretamente al Database---- ");
			return myConn;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
}


//ESEMPI:

/*-------------------*/
/*INSERT NEL DATABASE*/
/*-------------------*/

/*
st = c.createStatement();
String tot="insert into Sensore values(null,'"+nome+"','"+idArea+"')";
st.executeUpdate(tot);	
*/

/*-------------------*/
/*QUERY NEL DATABASE */
/*-------------------*/

/*
Connection myConn=Database.Connect();
Statement st=myConn.createStatement();
ResultSet result=st.executeQuery("select username,psw from account where username='"+user+"'and psw='"+pass+"'");
*/

/*-------------------*/
/*UPDATE NEL DATABASE */
/*-------------------*/

/*
Connection myConn=Database.Connect();
Statement st=myConn.createStatement();
st.executeUpdate("select username,psw from account where username='"+user+"'and psw='"+pass+"'");
*/

/*-------------------*/
/*DELETE NEL DATABASE */
/*-------------------*/

/*
Connection myConn=Database.Connect();
Statement st=myConn.createStatement();
st.executeUpdate("select username,psw from account where username='"+user+"'and psw='"+pass+"'");
*/




