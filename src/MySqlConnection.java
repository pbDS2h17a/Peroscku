import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlConnection {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//String[] data = FileReader.readFile();
		//String[] continentData = FileReader.getContinent(data);
		//String[] countryData = FileReader.getCountry(data);
		
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://mysqlpb.pb.bib.de/pbs2h17awb","pbs2h17awb","2vfTcNDp");
//		Connection con = DriverManager.getConnection(
//				"jdbc:mysql://192.168.178.27/testdb","root","password");
// 		BIB verbindung
//		"jdbc:mysql://mysqlpb.pb.bib.de/pbs2h17awb","pbs2h17awb","2vfTcNDp");
		
		Statement stmt=con.createStatement();
		
//		stmt.executeUpdate("DROP TABLE chat");
		String sqlContinent = "CREATE TABLE IF NOT EXISTS chat (" +
				" id INTEGER auto_increment, " +
				" timestamp INTEGER, " +
                " nachricht VARCHAR(255), " +
				" von VARCHAR(20)," +
				" nach VARCHAR(20)," +
				" PRIMARY KEY (id)" +
				");";
		
		stmt.executeUpdate(sqlContinent);
		String nachricht = "Hallo_Roemmich";
		
		stmt.executeUpdate("INSERT into chat(timestamp, nachricht, von, nach)"
				+ "			VALUES("+System.currentTimeMillis()/1000+", 'Hallo', 'Erik', 'Jörg');");
		stmt.executeUpdate("INSERT into chat(timestamp, nachricht, von, nach)"
				+ "			VALUES("+System.currentTimeMillis()/1000+", 'Tschüss', 'Erik', 'Jona');");
		
//		ResultSet r = stmt.executeQuery("SELECT * FROM neighbor");
//		ResultSet r = stmt.executeQuery("SELECT country_name FROM country WHERE country_id IN ( "
//													+ "SELECT neighbor_id "
//													+ "FROM neighbor "
//													+ "WHERE country_id = 20);");
//		
//		while(r.next())
//		{
//			String test = r.getString(1);
//			System.out.println(test);
//		}
		
//		SqlQuery.dropCountry(stmt);
//		SqlQuery.dropContinent(stmt);
//		SqlQuery.dropNeighbor(stmt);
//		
//		SqlQuery.createContinent(stmt);
//		SqlQuery.createCountry(stmt);
//		SqlQuery.createNeighbor(stmt);
//		
//		SqlQuery.fillContinent(stmt, continentData);
//		SqlQuery.fillCountry(stmt, countryData);
		
		
	}

}