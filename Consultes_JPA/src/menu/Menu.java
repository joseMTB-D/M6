package menu;

import java.util.List;
import java.util.Scanner;


import javax.persistence.*;

import model.Client;
import model.Comande;
import model.DetallComande;
import model.DetallComandePK;

public class Menu {
	static Scanner scan = new Scanner(System.in);
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Consultes_JPA");// llama al																										// configuracion)
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
		Query usuarios =entitymanager.createQuery("SELECT c FROM Client c ");
		List<Client> cli=usuarios.getResultList();
		
		for(Client a:cli){
			List<Comande> comanda =a.getComandes();
			if(comanda.size()>1) {
				System.out.println(a.getDni()+" "+a.getNom());
			}
		}
		
	}

	public static void dos() {
		Query comand =entitymanager.createQuery("SELECT c FROM Comande c ");
		List<Comande> comanda =comand.getResultList();
		
		for(Comande c :comanda) {
			Client cli= c.getClient();
			//DetallComandePK dcpk= new DetallComandePK(c.getComandaID(),cli.getClientID());
			List<DetallComande> dc=c.getDetallComandes();
			System.out.println("Client: DNI: "+cli.getDni()+" Telefon:"+cli.getTelefon()+" Nom:"+cli.getNom());
			for(DetallComande d:dc) {
				System.out.println("Producte: ID: "+d.getProducte().getProducteID()+" Stock: "+d.getProducte().getStock()+" Nom:"+d.getProducte().getNom());	
			}
			System.out.println("Data comanda: "+c.getData_comanda()+" Enviament: "+c.getData_enviament());
		}
		
		/*2-	Obtenir una llista completa de les comandes on ha de quedar reflexat:
		
		b.	ProducteID , quantitat i nom del producte .
		c.	Data comanda i data enviament.*/

	}

	public static void tres() {

	}

	public static void cuatro() {

	}

	public static void cinco() {

	}

	public static void seis() {

	}

	public static void siete() {

	}

}
