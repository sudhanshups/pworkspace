import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class SqlServerConnection {
 
	static Connection con = null;
	static PreparedStatement st = null;
	
	private static void makeJDBCConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //check whether class is there or not
			log("Congrats - Seems your SQL JDBC Driver Registered!");
		} catch (ClassNotFoundException e) {
			log("Sorry, couldn't found SQL JDBC driver. ");
			e.printStackTrace();
			return;
		}
 
		try {
			// DriverManager: The basic service for managing a set of JDBC drivers.
			con = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:54219;"
					+ "user=singhsud;password=1234;database=testdb");
			if (con != null) {
				log("Connection Successful! Enjoy. Now it's time to push data");
			} else {
				log("Failed to make connection!");
			}
		} catch (SQLException e) {
			log("MySQL Connection Failed!");
			e.printStackTrace();
			return;
		}

	}
	private static void addDataToDB(int id , String name) {		 
		try {
			String insertQueryStatement = "INSERT  INTO  Employee  VALUES  (?,?)";
 
			st = con.prepareStatement(insertQueryStatement);
			st.setInt(1, id);
			st.setString(2, name); 
			// execute insert SQL statement
			st.executeUpdate();
			log(name + " added successfully");
		} catch (
		SQLException e) {
			e.printStackTrace();
		}
	}
	private static void getDataFromDB() {
		 
		try {
			// MySQL Select Query Tutorial
			String getQueryStatement = "SELECT * FROM employee";
			st = con.prepareStatement(getQueryStatement);
			// Execute the Query, and get a java ResultSet
			ResultSet rs = st.executeQuery();
			// Let's iterate through the java ResultSet
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("Name");
				// Simply Print the results
				System.out.format("%d, %s\n", id,name);
			}
		} catch (
		SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		try {
			log("-------- JDBC connection to MySQL DB locally ------------");
			makeJDBCConnection();
 
			log("\n---------- Adding data to DB ----------");
			//addDataToDB(3, "Shadab");
			//addDataToDB(4,"Ayubi"); 
			log("\n---------- Let's get Data from DB ----------");
			getDataFromDB();
 
			st.close();
			con.close(); // connection close
 
		} catch (SQLException e) {
 
			e.printStackTrace();
		}
	}
	
/*		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //check whether class is there or not
		Connection conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:54219;"
				+ "user=singhsud;password=1234;database=testdb");
		System.out.println("test");
		Statement st = conn.createStatement();
		String Sql = "select top 10 * from employee ";
		ResultSet rs = st.executeQuery(Sql);
		while (rs.next()) {
			System.out.println(rs.getString("id") + rs.getString("name"));
		}

	}*/
	// Simple log utility
	private static void log(String string) {
		System.out.println(string);
 
	}
}
/*
Windows authentication + JDBC
This is the connection string we have to use:
String url ="jdbc:sqlserver://MYPC\\SQLEXPRESS;databaseName=MYDB;integratedSecurity=true";
Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
Connection conn = DriverManager.getConnection(url);
https://thusithamabotuwana.wordpress.com/2012/07/19/connecting-to-sql-server-from-java/
*/