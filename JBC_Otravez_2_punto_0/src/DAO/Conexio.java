package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexio {
	String DriverClassName="com.mysql.jdbc.Driver";
	String ConnectionUrl="jdbc:mysql://localhost:3306/empresa";
	String dbUser="root";
	String dbPass="";
	
	private static Conexio conexio =null;
	
	private Conexio() {
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
	public static Conexio getInstance() {
		if (conexio == null) {
			conexio = new Conexio();
		}
		return conexio;
	}
	}

