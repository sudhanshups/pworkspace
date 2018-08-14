
package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class DBUtil 
{
	private static String jdbcURL = 
			"jdbc:sqlserver://127.0.0.1:54219;" +
			"user=singhsud;password=1234;database=testdb";
	
//			"jdbc:sqlserver://SPDEVHYD22\\SHAREPOINT;" +
//			"databaseName=JavaTrainingDB;user=TestAccount;password=TestAccount;";

			
	//		"jdbc:sqlserver://SPDEVHYD22/SHAREPOINT;" +"databaseName=JavaTrainingDB;user=TestAccount;password=TestAccount;";
	
	//"jdbc:mysql://localhost:3306/test?user=root&password=tiger";

	@SuppressWarnings("unused")
	private static String driverClass = "com.mysql.jdbc.Driver";
	
	static
	{
		try 
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
		} 
		catch (Exception e)
		{
			System.out.println("Unable to Load JDBC Driver");
		}		
	}
			
	
	public static Connection getConnection() throws SQLException
	{
		return DriverManager.getConnection(jdbcURL);
	}
	
	public static void close(ResultSet rs)
	{
		if(rs != null) {
			try{ 
				rs.close();
			}
			catch (Exception e) {				
			}
		}
	}

	public static void close(Statement stm)
	{
		if(stm != null) {
			try{ 
				stm.close();
			}
			catch (Exception e) {				
			}
		}
	}
	
	public static void close(Connection conn)
	{
		if(conn != null) {
			try{
				conn.close();
			}
			catch (Exception e) {				
			}
		}
	}
	
	public static void fillStatement(PreparedStatement ps, Object...params) throws SQLException
	{
		for (int i=0; i<params.length; i++) 
		{
			if(params[i] == null)
				ps.setNull(i+1, Types.NULL);
			else
				ps.setObject(i+1, params[i]);
		}		
	}
}
