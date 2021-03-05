package examen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class prestec_dao {
	Connection connection=null;
	PreparedStatement ptmt= null;
	ResultSet resultSet =null;
	public prestec_dao() {
		
	}
	
	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = conexion.getInstance().getConnection();
		return conn;
	}
	
	public void registrar(Prestec prestec) {
		try {
			String queryString="INSERT INTO `prestec`(`codi`, `ISBN`, `DNI`, `data_retorn`, `retornat`) VALUES (?,?,?,?,?)";
			connection=getConnection();
			ptmt=connection.prepareStatement(queryString);
			ptmt.setInt(1,prestec.getCodi());
			ptmt.setString(2,prestec.getIsbn());
			ptmt.setString(3, prestec.getDni());
			ptmt.setString(4,prestec.getData_retorn());
			ptmt.setInt(5, prestec.getRetornat());
			ptmt.executeUpdate();
			connection.close();
			System.out.println("Prestec Registrat");
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
	
	public void gestio_prestec(Prestec prestec) {
		try {
			String queryString="UPDATE `prestec` SET retornat=? WHERE codi=?";
			connection=getConnection();
			ptmt=connection.prepareStatement(queryString);
			ptmt.setInt(1,prestec.getRetornat());
			ptmt.setInt(2, prestec.getCodi());
			ptmt.executeUpdate();
			connection.close();
			System.out.println("Prestec actualitzat");
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
	
}
