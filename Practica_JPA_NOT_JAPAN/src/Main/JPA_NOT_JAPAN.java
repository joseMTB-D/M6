package Main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Llibre;
import model.Prestec;
import model.Usuari;

public class JPA_NOT_JAPAN {
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		

		System.out.println("Base de dades de la biblioteca:");
		System.out.println("Insertar Llibres...................1");
		System.out.println("Insertar Usuaris...................2");
		System.out.println("Afegir prestec.....................3");
		System.out.println("Modificar prestec..................4");
		System.out.println("Eliminar Usuari....................5");
		System.out.println("Mostrar tots els usuaris...........6");
		System.out.println("Consultes..........................7");
		System.out.println("Sortir.............................8");
		int usuari = scan.nextInt();
		scan.nextLine();
		if (usuari == 1) {
			addBook();
		}
		if (usuari == 2) {
			addUser();
		}
		if (usuari == 3) {
			addRequest();
		}
		if (usuari == 4) {
			UpdateRequestState();
		}
		if(usuari==5) {
			Del();
		}
		if(usuari==6) {
			MP();
		}
		if(usuari==7) {
			Consulta();
		}
		if(usuari==8) {
			sortir();
		}

	}

	public static void addBook() {
		System.out.println("Indica les seguents dades del llibre");
		System.out.println("EL ISBN:");
		String isbn=scan.nextLine();
		System.out.println("El Titol:");
		String titol=scan.nextLine();
		System.out.println("La Categoria:");
		String categoria=scan.nextLine();
		System.out.println("El preu");
		double preu=scan.nextDouble();
		scan.nextLine();
		System.out.println("L'editorial");
		String editorial=scan.nextLine();
		System.out.println("L'autor");
		String autor=scan.nextLine();
		Llibre l=new Llibre(isbn,autor,categoria,editorial,preu,titol);
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Practica_JPA_NOT_JAPANESE");// llama al
		EntityManager entitymanager = emfactory.createEntityManager();// similar al statement.
		entitymanager.getTransaction().begin();
		
		 entitymanager.persist(l);
		  entitymanager.getTransaction( ).commit();//realiza los camondos
	      entitymanager.close();
	      emfactory.close();
	      System.out.println("Llibre registrat correctament");
	      main(null);
	}

	public static void addUser() {
		System.out.println("Indica les seguents dades del Usuari");
		System.out.println("El DNI:");
		String dni=scan.nextLine();
		System.out.println("El Nom:");
		String nom=scan.nextLine();
		System.out.println("El Telefon:");
		int telefon= scan.nextInt();
		scan.nextLine();
		System.out.println("El Correo electronic:");
		String correo=scan.nextLine();
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Practica_JPA_NOT_JAPANESE");// llama al
		EntityManager entitymanager = emfactory.createEntityManager();// similar al statement.
		entitymanager.getTransaction().begin();
		Usuari u= new Usuari(dni,correo,nom,telefon);
		 entitymanager.persist(u);
		  entitymanager.getTransaction( ).commit();//realiza los camondos
	      entitymanager.close();
	      emfactory.close();
	      System.out.println("Usuari registrat correctament");
	      main(null);
	}
	public static void Del() {
		System.out.println("Indica les seguents dades del Usuari");
		System.out.println("El DNI:");
		String dni=scan.nextLine();
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Practica_JPA_NOT_JAPANESE");// llama al
		EntityManager entitymanager = emfactory.createEntityManager();// similar al statement.
		entitymanager.getTransaction().begin();
		Usuari u= entitymanager.find(Usuari.class,dni);
		 entitymanager.remove(u);
		  entitymanager.getTransaction( ).commit();//realiza los camondos
	      entitymanager.close();
	      emfactory.close();
	      System.out.println("Usuari registrat correctament");
	      main(null);
	}

	public static void addRequest() {
		System.out.println("Indica les seguents dades del prestec");
		System.out.println("El Codi:");
		int codi=scan.nextInt();
		scan.nextLine();
		System.out.println("El DNI");
		 String dnip=scan.nextLine();
		System.out.println("El ISBN ");
		String isbnp=scan.nextLine();
		Date date = new Date();
	      Date mes= new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			 mes.setMonth(date.getMonth()+1);

			 
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Practica_JPA_NOT_JAPANESE");// llama al
		EntityManager entitymanager = emfactory.createEntityManager();// similar al statement.
		
		
		
		Usuari u=entitymanager.find(Usuari.class, dnip);
		Llibre l=entitymanager.find(Llibre.class,isbnp);
		
		Prestec p= new Prestec(codi,date,mes,"0",u,l);
		entitymanager.getTransaction().begin();
		 entitymanager.persist(p);
		  entitymanager.getTransaction( ).commit();//realiza los camondos
	      entitymanager.close();
	      emfactory.close();
	      System.out.println("Prestec creat correctament");
	      main(null);
	}

	public static void UpdateRequestState() {
		System.out.println("Indica el prestec que vols actualitzar");
		int codip=scan.nextInt();
		scan.nextLine();

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Practica_JPA_NOT_JAPANESE");// llama al																										// configuracion)
		EntityManager entitymanager = emfactory.createEntityManager();// similar al statement.
		entitymanager.getTransaction().begin();
		Prestec p=entitymanager.find(Prestec.class,codip);

		p.setRetornat("1");
		  
		  entitymanager.getTransaction( ).commit();//realiza los camondos
	      entitymanager.close();
	      emfactory.close();
	      System.out.println("Prestec actualitzat correctament");
	      main(null);
	}
	public static void MP() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Practica_JPA_NOT_JAPANESE");// llama al																										// configuracion)
		EntityManager entitymanager = emfactory.createEntityManager();// similar al statement.
		entitymanager.getTransaction().begin();
		System.out.println("Indica el dni del propietari per buscar els seus prestecs");
		String dni=scan.nextLine();
		Usuari u=entitymanager.find(Usuari.class,dni);
		List<Prestec> pre=  u.getPrestecs();
		for (Prestec prestec : pre) {
			System.out.println("Codi Prestec :"+prestec.getCodi()+" Llibre ISBN: "+prestec.getLlibre().getIsbn()+" Data entrega: "+prestec.getDataPrestec()+" Data retorn: "+prestec.getDataRetorn()+" Retornat: "+prestec.getRetornat());
		}
		entitymanager.getTransaction( ).commit();//realiza los camondos
	      entitymanager.close();
	      emfactory.close();
		 main(null);
	}
	
	
	public static void Consulta() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Practica_JPA_NOT_JAPANESE");// llama al																										// configuracion)
		EntityManager entitymanager = emfactory.createEntityManager();// similar al statement.
		entitymanager.getTransaction().begin();
		Query q =entitymanager.createQuery("SELECT ll FROM Llibre ll");
		List<Llibre>titol= q.getResultList();
		for(Llibre a:titol) {
			System.out.println(a);
		}
		
		
		entitymanager.getTransaction( ).commit();//realiza los camondos
	      entitymanager.close();
	      emfactory.close();
		main(null);
	}
	public static void sortir() {
		
	}

}
