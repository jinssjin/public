package connect;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class BoardConnect {
	   public static Connection getConnection() throws SQLException, ClassNotFoundException  {      

		      Connection conn = null;      
		   
		      String url = "jdbc:mysql://localhost:3306/boardtest";
		      String user = "root";
		      String password = "1234";

		      Class.forName("com.mysql.cj.jdbc.Driver");
		      conn = DriverManager.getConnection(url, user, password);      
		      
		      return conn;
		   }

		}