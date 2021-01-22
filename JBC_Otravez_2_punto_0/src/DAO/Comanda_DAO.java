package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Comanda_DAO {
	Connection connection=null;
	PreparedStatement ptmt= null;
	ResultSet resultSet =null;
	
	public Comanda_DAO() {
		
	}
	


	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = Conexio.getInstance().getConnection();
		return conn;
	}
	
	public void add(Comanda comanda) {
		
		try {
			String queryString ="INSERT INTO `comanda`(`COM_NUM`, `COM_DATA`, `COM_TIPUS`, `CLIENT_COD`, `DATA_TRAMESA`, `TOTAL`) VALUES (?,?,?,?,?,?)";
			connection=getConnection();
			ptmt=connection.prepareStatement(queryString);
			ptmt.setInt(1,comanda.getCOM_NUM());
			ptmt.setString(2,comanda.getCOM_DATE());
			ptmt.setString(3,comanda.getCOM_TIPUS());
			ptmt.setInt(4,comanda.getCLIENT_COD());
			ptmt.setString(5,comanda.getDATA_TRAMESA());
			ptmt.setDouble(6,comanda.getTOTAL());
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

	public void update(Comanda comanda) {
		
		try {
			String queryString ="UPDATE `comanda` SET COM_DATA`=?,`COM_TIPUS`=?,`CLIENT_COD`=?,`DATA_TRAMESA`=?,`TOTAL`=? WHERE COM_NUM=?";
			connection=getConnection();
			ptmt= connection.prepareStatement(queryString);
			ptmt.setString(1,comanda.getCOM_DATE());
			ptmt.setString(2,comanda.getCOM_TIPUS());
			ptmt.setInt(3,comanda.getCLIENT_COD());
			ptmt.setString(4,comanda.getDATA_TRAMESA());
			ptmt.setDouble(5,comanda.getTOTAL());
			ptmt.setInt(6,comanda.getCOM_NUM());
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
	//editar
	public void delete(int COM_NUM) {
		try {
			String queryString ="DELETE FROM `comanda` WHERE COM_NUM=?";
			connection= getConnection();
			ptmt= connection.prepareStatement(queryString);
			ptmt.setInt(1,COM_NUM);
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
 //editar
	public void findAll() {
		try {
			String queryString = "SELECT * FROM comanda";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			while(resultSet.next()) {
				System.out.println("COM_NUM "+resultSet.getInt("COM_NUM")
						+" COM_DATA "+resultSet.getString("COM_DATA")
						+" COM_TIPUS"+resultSet.getString("COM_TIPUS")
						+" CLIENT_COD"+resultSet.getString("CLIENT_COD")
						+" DATA_TRAMESA"+resultSet.getString("DATA_TRAMESA")
						+" TOTAL"+resultSet.getDouble("TOTAL"));
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
