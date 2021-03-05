package examen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class usuari_dao {

	Connection connection=null;
	PreparedStatement ptmt= null;
	ResultSet resultSet =null;
	
	public usuari_dao() {
		
	}
	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = conexion.getInstance().getConnection();
		return conn;
	}
	
	public void registrar(usuari usuari) {
		try {
			String queryString="INSERT INTO `usuari`(`DNI`, `nom`, `telefon`, `correu`) VALUES (?,?,?,?)";
			connection=getConnection();
			ptmt=connection.prepareStatement(queryString);
			ptmt.setString(1,usuari.getDni());
			ptmt.setString(2,usuari.getNom());
			ptmt.setInt(3, usuari.getTelefon());
			ptmt.setString(4,usuari.getCorreu());
			ptmt.executeUpdate();
			connection.close();
			System.out.println("Usuari Registrat");
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
	public void prestec() {
		try {
			String queryString ="SELECT * FROM `usuari` inner join prestec on prestec.DNI = usuari.DNI WHERE prestec.retornat=1";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			while(resultSet.next()) {
				System.out.println("DNI "+resultSet.getString("DNI")
						+" Nom "+resultSet.getString("nom")
						+" Telefon"+resultSet.getInt("telefon")
						+"Correu "+resultSet.getString("correu"));
			}
			connection.close();
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
