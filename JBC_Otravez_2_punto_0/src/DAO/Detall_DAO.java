package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Detall_DAO {

	Connection connection=null;
	PreparedStatement ptmt= null;
	ResultSet resultSet =null;
	
	
	public Detall_DAO() {}
	
	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = Conexio.getInstance().getConnection();
		return conn;
	}
	
	public void add(Detall detall) {
		try {
			String queryString ="INSERT INTO `detall`(`COM_NUM`, `DETALL_NUM`, `PROD_NUM`, `PREU_VENDA`, `QUANTITAT`, `IMPORT`) VALUES (?,?,?,?,?,?)";
			connection=getConnection();
			ptmt=connection.prepareStatement(queryString);
			ptmt.setInt(1,detall.getCOM_NUM());
			ptmt.setInt(2,detall.getDETALL_NUM());
			ptmt.setInt(3,detall.getPROD_NUM());
			ptmt.setDouble(4,detall.getPREU_VENDA());
			ptmt.setInt(5,detall.getQUANTITAT());
			ptmt.setDouble(6,detall.getIMPORT());
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
	
	public void update(Detall detall) {
	try {
		String queryString ="UPDATE `detall` SET `PROD_NUM`=?,`PREU_VENDA`=?,`QUANTITAT`=?,`IMPORT`=? WHERE `DETALL_NUM`=? and `COM_NUM`=?";
		connection=getConnection();
		ptmt= connection.prepareStatement(queryString);
		ptmt.setInt(1,detall.getPROD_NUM());
		ptmt.setDouble(2,detall.getPREU_VENDA());
		ptmt.setInt(3,detall.getQUANTITAT());
		ptmt.setDouble(4,detall.getIMPORT());
		ptmt.setInt(5,detall.getDETALL_NUM());
		ptmt.setInt(6,detall.getCOM_NUM());
		ptmt.executeUpdate();
		System.out.println("Update crealed");
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
	
	public void delete (int COM_NUM,int DETALL_NUM) {
		try {
			String queryString="DELETE FROM `detall` WHERE `COM_NUM`=? and `DETALL_NUM`=?";
			connection= getConnection();
			ptmt= connection.prepareStatement(queryString);
			ptmt.setInt(1,COM_NUM);
			ptmt.setInt(2, DETALL_NUM);
			ptmt.executeUpdate();
			System.out.println("Delete cleared");
			System.out.println(queryString);
			
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
			String queryString = "SELECT * FROM `detall`";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			while(resultSet.next()) {
				System.out.println("COM_NUM "+resultSet.getInt("COM_NUM")
						+" DETALL_NUM "+resultSet.getInt("DETALL_NUM")
						+" PROD_NUM "+resultSet.getInt("PROD_NUM")
						+" PREU_VENDA "+resultSet.getDouble("PREU_VENDA")
						+" QUANTITAT "+resultSet.getInt("QUANTITAT")
						+" IMPORT "+resultSet.getDouble("IMPORT"));
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
