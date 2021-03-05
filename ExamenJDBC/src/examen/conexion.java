package examen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
	
	
		String DriverClassName="com.mysql.jdbc.Driver";
		String ConnectionUrl="jdbc:mysql://localhost:3306/examenjbdc";
		String dbUser="root";
		String dbPass="";
		
		private static conexion conexio =null;
		
		private conexion() {
			try {
				Class.forName(DriverClassName);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		public Connection getConnection() throws SQLException {
			Connection conn = null;
			conn = DriverManager.getConnection(ConnectionUrl, dbUser, dbPass);
			return conn;
		}
		public static conexion getInstance() {
			if (conexio == null) {
				conexio = new conexion();
			}
			return conexio;
		}

		
		}



