package jdbc.student.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
             
	private static Connection con;
	
	static 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnectionFactory()
	{
		return con;
	}
}
