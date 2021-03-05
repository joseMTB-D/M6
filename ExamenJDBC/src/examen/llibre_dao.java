package examen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class llibre_dao {
	Connection connection=null;
	PreparedStatement ptmt= null;
	ResultSet resultSet =null;
	
	public llibre_dao() {
		
	}

	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = conexion.getInstance().getConnection();
		return conn;
	}
	
	public void registrar(Llibre llibre) {
		try {
			
			String queryString ="INSERT INTO `llibre`(`Isbn`, `titol`, `categoria`, `preu`, `editorial`, `autor`) VALUES (?,?,?,?,?,?)";
			connection=getConnection();
			ptmt=connection.prepareStatement(queryString);
			ptmt.setString(1,llibre.getIsbn());
			ptmt.setString(2,llibre.getTitol());
			ptmt.setString(3, llibre.getCategoria());
			ptmt.setDouble(4, llibre.getPreu());
			ptmt.setString(5,llibre.getEditorial());
			ptmt.setString(6, llibre.getAutor());
			ptmt.executeUpdate();
			connection.close();
			System.out.println("Llibre insertat");
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
	public void llibres_prestec() {
		try {
			String queryString="SELECT * FROM `llibre`  LEFT JOIN prestec on prestec.ISBN = llibre.Isbn where prestec.retornat = 1 OR DNI IS NULL";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			while(resultSet.next()) {
				System.out.println("ISBN "+resultSet.getString("isbn")
				+" Titol "+resultSet.getString("titol")
				+" Categoria "+resultSet.getString("categoria")
				+" Preu "+resultSet.getDouble("preu")
				+" Editorial "+resultSet.getString("editorial")
				+" Autor "+resultSet.getString("autor"));
			}
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
