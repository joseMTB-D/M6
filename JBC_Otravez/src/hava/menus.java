package hava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class menus {
	static Connection conn = null;
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		String usuari = "";

		do {
			System.out.println("Indica que vols fer:");
			System.out.println("--------------------------------------");
			System.out.println("Insertar");
			System.out.println("Mostrar");
			System.out.println("Borrar");
			System.out.println("Actualitzar");
			System.out.println("Sortir");
			System.out.println("--------------------------------------");
			System.out.print("User: ");
			usuari = scan.nextLine();
			if (usuari.equals("insertar")) {
				insert();
			}
			if (usuari.equals("mostrar")) {
				mostrar();
			}
			if (usuari.equals("borrar")) {
				borrar();
			}
			if (usuari.equals("actualitzar")) {
				actualitzar();
			}

		} while (!usuari.equals("sortir"));

	}

	private static void conectar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String URL = "jdbc:mysql://localhost:3306/empresa";
			String USER = "root";
			String PASS = "";
			conn = DriverManager.getConnection(URL, USER, PASS);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private static void disc() {
		try {
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void insert() {
		try {
			conectar();
			System.out.println("Indica la taula a insertar");
			System.out.print("User: ");
			String user = scan.nextLine();

			if (user.equals("departament")) {
				int codi = 25;
				String nom = "coffe";
				String local = "greentea";
				String sql = ("INSERT INTO dept VALUES(?,?,?)");
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, codi);
				ps.setString(2, nom);
				ps.setString(3, local);
				ps.executeUpdate();
			}
			if (user.equals("producte")) {
				int codi = 25;
				String nom = "coffe";
				String local = "greentea";
				String sql = ("INSERT INTO producte VALUES(?,?)");
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, codi);
				ps.setString(2, nom);
				ps.executeUpdate();
			}

			// inner join con cliente
			if (user.equals("comanda")) {
				int codi = 25;
				String nom = "coffe";
				String local = "greentea";
				String sql = ("INSERT INTO comanda VALUES(?,?,?,?,?,?)");
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, codi);
				ps.setString(2, nom);
				ps.setString(3, local);
				ps.setInt(4, 1);
				ps.setString(5, "Stringo");
				ps.setString(6, "WAW");
				ps.executeUpdate();
			}

			disc();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void mostrar() {
		try {
			conectar();
			System.out.println("Indica la taula a mostrar");
			System.out.print("User: ");
			String user = scan.nextLine();

			if (user.equals("comanda")) {
				String sql = ("SELECT comanda.COM_NUM,comanda.COM_DATA,comanda.COM_TIPUS,comanda.CLIENT_COD,client.NOM,comanda.DATA_TRAMESA,comanda.TOTAL FROM comanda INNER JOIN client ON client.CLIENT_COD= comanda.CLIENT_COD");
				Statement stmt = conn.createStatement();
				ResultSet resu = stmt.executeQuery(sql);
				while (resu.next()) {
					int com = resu.getInt("comanda.COM_NUM");
					String data = resu.getString("comanda.COM_DATA");
					String tipus = resu.getString("comanda.COM_TIPUS");
					int client = resu.getInt("comanda.CLIENT_COD");
					String nom = resu.getString("client.NOM");
					String datat = resu.getString("comanda.DATA_TRAMESA");
					String total = resu.getString("comanda.TOTAL");
					System.out.println(
							com + " " + data + " " + tipus + " " + client + " " + nom + " " + datat + " " + total);
				}
			}
			if (user.equals("client")) {
				String sql = ("SELECT CLIENT_COD,NOM,ADRECA,CIUTAT,ESTAT,CODI_POSTAL,AREA,TELEFON,REPR_COD,LIMIT_CREDIT,OBSERVACIONS from client");
				Statement stmt = conn.createStatement();
				ResultSet resu = stmt.executeQuery(sql);
				while (resu.next()) {
					int cod = resu.getInt("CLIENT_COD");
					String nom = resu.getString("NOM");
					String adreça = resu.getString("ADRECA");
					String ciutat = resu.getString("CIUTAT");
					String estat = resu.getString("ESTAT");
					String cp = resu.getString("CODI_POSTAL");
					String area = resu.getString("AREA");
					String telefon = resu.getString("TELEFON");
					String repr = resu.getString("REPR_COD");
					int lc = resu.getInt("LIMIT_CREDIT");
					String co = resu.getString("OBSERVACIONS");
					System.out.println("Nom= " + nom + " Codi= " + cod + " Adreça=" + adreça + " Ciutat= " + ciutat
							+ " Estat= " + estat + " CP= " + cp + " Area= " + area + " Telefon= " + telefon + " Repr= "
							+ repr + " Loc= " + lc + " Co= " + co);

				}

			}

			if (user.equals("departament")) {
				String sql = ("SELECT dept.DEPT_NO,dept.DNOM,dept.LOC FROM `dept` ");
				Statement stmt = conn.createStatement();
				ResultSet resu = stmt.executeQuery(sql);
				while (resu.next()) {
					int cod = resu.getInt("dept.DEPT_NO");
					String nom = resu.getString("dept.DNOM");
					String adreça = resu.getString("dept.LOC");

					System.out.println(nom + " " + cod + " " + adreça);
				}
			}
			disc();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void borrar() {
		try {
			conectar();
			System.out.println("Indica la taula on es borraran dades: ");
			System.out.print("User: ");
			String user = scan.nextLine();

			if (user.equals("comanda")) {

				System.out.println("Indica el numero de la comanda:");
				int comnum = scan.nextInt();
				System.out.print(">");
				PreparedStatement ps = conn.prepareStatement("DELETE FROM comanda WHERE COM_NUM=?");

				 ps.setInt(1, comnum);
				 ps.executeUpdate();
				
			}
			if (user.equals("client")) {
				System.out.println("Indica el codi del client:");
				int comnum = scan.nextInt();
				PreparedStatement ps = conn.prepareStatement("DELETE FROM client WHERE CLIENT_COD=? ");
				 ps.setInt(1, comnum);
				 ps.executeUpdate();
			}

			if (user.equals("departament")) {

				System.out.println("Indica el codi del departament:");
				int comnum = scan.nextInt();
				PreparedStatement ps = conn.prepareStatement("DELETE FROM dept WHERE dept.DEPT_NO=? ");
				 ps.setInt(1, comnum);
				 ps.executeUpdate();
			}
			disc();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void actualitzar() {
		try {
			conectar();
			System.out.println("Indica la taula que vols actualitzar ");
			System.out.print("User: ");
			String user = scan.nextLine();

			if (user.equals("comanda")) {
				 System.out.println("Indica Antic codi");
				  int ccov = scan.nextInt();
		    	  System.out.println("Indica  nou Codi comanda");
				  int cco = scan.nextInt();
				  scan.nextLine(); 
				  System.out.println("Indica nova Data comanda");
				  String dco = scan.nextLine(); 
				  System.out.println("Indica  nou Tipus de comanda");
				  String tco = scan.nextLine(); 
				  System.out.println("Indica  nou Codi client");
				  int coco = scan.nextInt();
				  scan.nextLine();
				  System.out.println("Indica nova Data tramit");
				  String daco = scan.nextLine();
				  System.out.println("Indica Re-Total");
				  String toco = scan.nextLine();
				 
				  scan.nextLine(); 
				  PreparedStatement ps = conn.prepareStatement(" Update   comanda SET COM_NUM=?,COM_DATA=?,COM_TIPUS=?,CLIENT_COD=?,DATA_TRAMESA=?,TOTAL=? WHERE COM_NUM=? ");
				  ps.setInt(1, cco);
				  ps.setString(2, dco);
				  ps.setString(3, tco);
				  ps.setInt(4, coco);
				  ps.setString(5, daco);
				  ps.setString(6, toco);
				  ps.setInt(7, ccov);

				  ps.executeUpdate();
			}
			if (user.equals("client")) {
				  System.out.println("Entra el vell codi del client");
				  int ccv  = scan.nextInt();
				  scan.nextLine(); 
		    	  System.out.println("Entra el nou codi del client");
				  int cc  = scan.nextInt();
				  scan.nextLine(); 
				  System.out.println("El nom del client");
				  String nc = scan.nextLine(); 
				  System.out.println("Adreça del client");
				  String ac = scan.nextLine(); 
				  System.out.println("Ciutat");
				  String cic = scan.nextLine(); 
				  System.out.println("Estat");
				  String ec = scan.nextLine(); 
				  System.out.println("CP");
				  String cpc = scan.nextLine(); 
				  System.out.println("area");
				  int arc = scan.nextInt(); 
				  scan.nextLine(); 
				  System.out.println("Telefon");
				  String tc = scan.nextLine();
				  System.out.println("Codi repartidor");
				  int rcc = scan.nextInt(); 
				  scan.nextLine(); 
				  System.out.println("Limit de credit");
				  String lc = scan.nextLine(); 
				  System.out.println("Obvservacions del usuari");
				  String oc = scan.nextLine();
				
				  PreparedStatement ps = conn.prepareStatement(" Update   client SET CLIENT_COD=?,NOM=?,ADRECA=?,CIUTAT=?,ESTAT=?,CODI_POSTAL=?,AREA=?,TELEFON=?,REPR_COD=?,LIMIT_CREDIT=?,OBSERVACIONS=? WHERE CLIENT_COD=? ");
				  ps.setInt(1, cc);
				  ps.setString(2, nc);
				  ps.setString(3, ac);
				  ps.setString(4, cic);
				  ps.setString(5, ec);
				  ps.setString(6, cpc);
				  ps.setString(7, tc);
				  ps.setInt(8, arc);
				  ps.setInt(9, rcc);
				  ps.setString(10, lc);
				  ps.setString(11, oc);
				  ps.setInt(12, ccv);
				  ps.executeUpdate();
			}

			if (user.equals("departament")) {
				 System.out.println("Indica el vell codi del departament");
				  int cnv  = scan.nextInt(); 
		    	  System.out.println("Indica el nou codi del departament");
				  int cn  = scan.nextInt(); 
				  scan.nextLine();
				  System.out.println("Indica el nom del departament");
				  String dn = scan.nextLine(); 
				  System.out.println("indica l'ubicació");
				  String LD = scan.nextLine(); 
				 
				  scan.nextLine();
				  PreparedStatement ps = conn.prepareStatement(" Update   dept SET DEPT_NO=?,DNOM=?,LOC=? WHERE DEPT_NO=?");
				  ps.setInt(1, cn);
				  ps.setString(2, dn);
				  ps.setString(3, LD);
				  ps.setInt(4, cnv);

				  ps.executeUpdate();
			}
			disc();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}


