package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Producte_DAO {

	Connection connection=null;
	PreparedStatement ptmt= null;
	ResultSet resultSet =null;
	
	
	
	
	public Producte_DAO() {

	}




	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = Conexio.getInstance().getConnection();
		return conn;
	}
	
	public void add(Producte producte) {
		try {
			String queryString ="INSERT INTO `producte`(`PROD_NUM`, `DESCRIPCIO`) VALUES (?,?)";
			connection=getConnection();
			ptmt=connection.prepareStatement(queryString);
			ptmt.setInt(1,producte.getPROD_NUM());
			ptmt.setString(2,producte.getDESCRIPCIO());
			ptmt.executeUpdate();
			System.out.println("Insert completed");
			connection.close();
		} catch (SQLException  e) {
			e.printStackTrace();		
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
	public void update(Producte producte) {
		
		try {
			String queryString ="UPDATE `producte` SET `DESCRIPCIO`=? WHERE PROD_NUM=?";
			connection=getConnection();
			ptmt= connection.prepareStatement(queryString);
			ptmt.setString(1, producte.getDESCRIPCIO());
			ptmt.setInt(2,producte.getPROD_NUM());
			ptmt.executeUpdate();
			System.out.println("Update crealed");
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			}

			catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
	}
	
	public void delete(int PROD_NUM) {
		try {
			String queryString ="DELETE FROM `producte` WHERE PROD_NUM=?";
			connection= getConnection();
			ptmt= connection.prepareStatement(queryString);
			ptmt.setInt(1,PROD_NUM);
			ptmt.executeUpdate();
			System.out.println("Delete cleared");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			}

			catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
	}
	
	public void findAll() {
		try {
			String queryString = "SELECT * FROM producte";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			while(resultSet.next()) {
				System.out.println("PROD_NUM "+resultSet.getInt("PROD_NUM")
						+" DESCRIPCIO "+resultSet.getString("DESCRIPCIO"));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			}

			catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		
	}
	
}
