package menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.persistence.*;

import model.Client;
import model.Comande;
import model.DetallComande;
import model.DetallComandePK;
import model.Producte;

public class Menu {
	static Scanner scan = new Scanner(System.in);
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Consultes_JPA");// llama al //
																									// configuracion)
	static EntityManager entitymanager = emfactory.createEntityManager();// similar al statement.

	public static void main(String[] args) {
		entitymanager.getTransaction().begin();

		int usuari = 0;
		while (usuari != 8) {
			System.out.println("Mostrar clients amb mes d'una comanda......................1");
			System.out.println("Mostrar LLista de comandes.................................2");
			System.out.println("Mostrar els productes en stock que han tingut una comanda..3");
			System.out.println("Mostrar numero de comandes de:.............................4");
			System.out.println("Mostrar numero de comandes per a cada producte.............5");
			System.out.println("Mostrar els podructes mes cars de la mitja.................6");
			System.out.println("Mostrar els major compradors d'aigua.......................7");
			usuari = scan.nextInt();
			scan.nextLine();
			if (usuari == 1) {
				uno();
			}
			if (usuari == 2) {
				dos();
			}
			if (usuari == 3) {
				tres();
			}
			if (usuari == 4) {
				cuatro();
			}
			if (usuari == 5) {
				cinco();
			}
			if (usuari == 6) {
				seis();
			}
			if (usuari == 7) {
				siete();
			}
		}
		entitymanager.close();
		emfactory.close();

	}

	public static void uno() {
		Query usuarios = entitymanager.createQuery("SELECT c FROM Client c ");
		List<Client> cli = usuarios.getResultList();

		for (Client a : cli) {
			List<Comande> comanda = a.getComandes();
			if (comanda.size() > 1) {
				System.out.println(a.getDni() + " " + a.getNom());
			}
		}

	}

	public static void dos() {
		Query comand = entitymanager.createQuery("SELECT c FROM Comande c ");
		List<Comande> comanda = comand.getResultList();

		for (Comande c : comanda) {
			Client cli = c.getClient();
			// DetallComandePK dcpk= new
			// DetallComandePK(c.getComandaID(),cli.getClientID());
			List<DetallComande> dc = c.getDetallComandes();
			System.out
					.println("Client: DNI: " + cli.getDni() + " Telefon:" + cli.getTelefon() + " Nom:" + cli.getNom());
			for (DetallComande d : dc) {
				System.out.println("Producte: ID: " + d.getProducte().getProducteID() + " Stock: "
						+ d.getProducte().getStock() + " Nom:" + d.getProducte().getNom());
			}
			System.out.println("Data comanda: " + c.getData_comanda() + " Enviament: " + c.getData_enviament());
		}

		/*
		 * 2- Obtenir una llista completa de les comandes on ha de quedar reflexat:
		 * 
		 * b. ProducteID , quantitat i nom del producte . c. Data comanda i data
		 * enviament.
		 */

	}

	public static void tres() {
		Query comand = entitymanager.createQuery("SELECT c FROM Producte c ");
		List<Producte> stock = comand.getResultList();
		for (Producte c : stock) {
			List<DetallComande> comanda = c.getDetallComandes();
			if (comanda.size() <= 0) {
				System.out.println(c);
			}

		}

	}

	public static void cuatro() {
		System.out.println("Indica el producto");
		String producte = scan.nextLine();
		int cda = 0;
		Query comand = entitymanager.createQuery("SELECT c FROM Producte c ");
		List<Producte> stock = comand.getResultList();
		for (Producte c : stock) {
			List<DetallComande> comanda = c.getDetallComandes();
			if ((comanda.size() > 0) && (c.getNom().equals(producte))) {
				cda=comanda.size();
			}

		}
		System.out.println("Numero de comandes contades: " + cda);

		/*
		 * if((comanda.size()!=0)) { if((c.getNom().equals(producte))) { cda+=1;
		 * 
		 * } }
		 */
	}

	public static void cinco() {

		Query css = entitymanager.createQuery("SELECT COUNT(p),p.nom FROM DetallComande dt JOIN dt.producte p GROUP BY p.producteID ORDER BY COUNT(p) DESC");
		List comandsss = css.getResultList();		
		for (Object c : comandsss) {
			printResult(c);
		}

		

	}
	
	public static void seis() {
		double media=0;
		Query Prod = entitymanager.createQuery("SELECT c FROM Producte c ");
		List<Producte> preus = Prod.getResultList();
		for (Producte c : preus) {
			media=media+c.getPreu();
		}
		media=media/preus.size();
		for (Producte c : preus) {
		if(c.getPreu()>media) {
			System.out.println(c.getNom());
			}
		}
		
	//	Obtenir el nom dels productes on el seu preu superin la mitjana del preu de tots els productes.
	}

	public static void siete() {

		Query css1 = entitymanager.createQuery("SELECT c.nom FROM Client c JOIN c.comandes co JOIN co.detallComandes cdt "
				+ "JOIN cdt.producte p WHERE p.producteID = 6 AND cdt.quantitat > 1  UNION ALL "
				+ "SELECT cli.nom FROM Client cli JOIN cli.comandes com JOIN com.detallComandes cdte JOIN cdte.producte pe "
				+ "WHERE pe.producteID = 6 GROUP BY pe.producteID HAVING COUNT(pe.producteID)>1");
		List comanda1 = css1.getResultList();
		for (Object a : comanda1) {
			printResult(a);
			
		}

		/*
		SELECT clients.Nom ,detall_comandes.Quantitat , productes.Nom FROM `clients` 
		INNER JOIN comandes ON comandes.ClientID= clients.ClientID INNER JOIN detall_comandes ON detall_comandes.ComandaID = comandes.ComandaID 
		INNER JOIN productes ON productes.ProducteID = detall_comandes.ProducteID 
		WHERE detall_comandes.ProducteID = 6 AND detall_comandes.Quantitat >1 
		UNION ALL 
		SELECT clients.Nom,detall_comandes.Quantitat , productes.Nom FROM `clients` 
		INNER JOIN comandes ON comandes.ClientID= clients.ClientID INNER JOIN detall_comandes ON detall_comandes.ComandaID = comandes.ComandaID 
		INNER JOIN productes ON productes.ProducteID = detall_comandes.ProducteID 
		WHERE detall_comandes.ProducteID=6 
		GROUP BY clients.Nom 
		HAVING COUNT(detall_comandes.ProducteID)>1
		*/
	

		
		//Obtenir els noms dels clients que hagin comprat més d’una aigua . 
		
		/*SELECT clients.Nom FROM `clients` INNER JOIN comandes ON comandes.ClientID= clients.ClientID INNER JOIN  
				detall_comandes ON detall_comandes.ComandaID = comandes.ComandaID 
				WHERE detall_comandes.ProducteID = 6 and detall_comandes.Quantitat >1  OR HAVING COUNT(comandes.ClientID) > 2 */
	}
	
	 private static void printResult(Object result) {
		    if (result == null) {
		      System.out.print("NULL");
		    } else if (result instanceof Object[]) {
		      Object[] row = (Object[]) result;
		      System.out.print("[");
		      for (int i = 0; i < row.length; i++) {
		        printResult(row[i]);
		      }
		      System.out.print("]");
		    } else if (result instanceof Long || result instanceof Double
		        || result instanceof String) {
		      System.out.print(result.getClass().getName() + ": " + result);
		    } else {
		      System.out.print(result);
		    }
		    System.out.println();
		  }


}
