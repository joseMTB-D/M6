package hava;

import java.sql.*;

public class El_Ejemplo {

	public static void main(String[] args) {
		try {
			   Class.forName("com.mysql.jdbc.Driver");
			   
			   
			   String URL = "jdbc:mysql://localhost:3306/empresa";
			   String USER = "root";
			   String PASS = "";
			   Connection conn = DriverManager.getConnection(URL, USER, PASS);
			   System.out.println("Connectat");
			  /* 	int codi=24;
			   	String t="tomatico";
			   String insertar="INSERT INTO producte VALUES(2,'tocino') ";
			   Statement stmt = conn.createStatement( );
			   
			     int row=stmt.executeUpdate(insertar);
			     System.out.println("la prendiste: "+row);*/
			   int codi=24;
			   String nom="la ccoca";
			   String local="madrid al";
			   String sql=("INSERT INTO dept VALUES(?,?,?)");
			   PreparedStatement ps = conn.prepareStatement(sql);
			   ps.setInt(1,codi);
			   ps.setString(2,nom);
			   ps.setString(3,local);
			   ps.executeUpdate();
			   System.out.println("executat");
			   conn.close();
			}
			catch(ClassNotFoundException ex) {
			   System.out.println("Error: unable to load driver class!");
			   System.exit(1);
			}
		catch(SQLException e){
		
			}

	}

}
