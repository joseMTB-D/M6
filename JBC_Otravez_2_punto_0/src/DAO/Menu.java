package DAO;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
	
	
	
	
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
	public static void insert() {
		Producte_DAO producte = new Producte_DAO();
		Detall_DAO detall= new Detall_DAO();
		Comanda_DAO comanda= new Comanda_DAO();
		Scanner scan = new Scanner (System.in);
		System.out.println("Indica la taula on insertar dades:");
		System.out.println("--------------------------------------");
		System.out.println("1-comanda");
		System.out.println("2-detall_comanda");
		System.out.println("3-producte");
		System.out.println("--------------------------------------");
		int usde=scan.nextInt();
		scan.hasNextLine();
		if(usde==1) {
			//error clave foranea
			System.out.println("Creant comanda nova");
			Comanda com= new Comanda();
			System.out.println("Indica el numero de la comanda");
			int r1=scan.nextInt();
			scan.nextLine();
			System.out.println("Indica la data de la comanda(YYY-MMM-DDD)");
			String r2=scan.nextLine();
			System.out.println("Indica el tipus de comanda(A,B,C)");
			String r3=scan.nextLine();
			System.out.println("Indica el codi del client");
			int r4=scan.nextInt();
			  scan.nextLine();
			System.out.println("Indica la data de  tramesa (YYY-MMM-DDD)");
			String r5=scan.nextLine();
			System.out.println("Indica el total");
			double r6 =scan.nextDouble();
			  scan.nextLine();			
			com.setCOM_NUM(r1);
			com.setCOM_DATE(r2);
			com.setCOM_TIPUS(r3);
			com.setCLIENT_COD(r4);
			com.setDATA_TRAMESA(r5);
			com.setTOTAL(r6);
			comanda.add(com);
		}else if(usde==2) {
			System.out.println("Creant detall");
			System.out.println("indica el numero de la comanda");
			int r1=scan.nextInt();
			scan.nextLine();
			System.out.println("Indica el numero del detall");
			int r2= scan.nextInt();
			scan.nextLine();
			System.out.println("Indica el numero del producte");
			int r3= scan.nextInt();
			scan.nextLine();
			System.out.println("Indica el preu de venta");
			double r4= scan.nextDouble();
			scan.nextLine();
			System.out.println("Indica la quantitat de productes");
			int r5=scan.nextInt();
			scan.nextLine();
			System.out.println("Indica el import");
			double r6= scan.nextDouble();
			scan.nextLine();
			Detall det = new Detall();
			det.setCOM_NUM(r1);
			det.setDETALL_NUM(r2);
			det.setPROD_NUM(r3);
			det.setPREU_VENDA(r4);
			det.setQUANTITAT(r5);
			det.setIMPORT(r6);
			detall.add(det);

		}else if(usde==3) {
			System.out.println("Creant producte");
			System.out.println("Indica el numero del producte");
			int r1=scan.nextInt();
			scan.nextLine();
			System.out.println("Descriu el producte");
			String r2=scan.nextLine();
			Producte prod = new Producte();
			prod.setPROD_NUM(r1);
			prod.setDESCRIPCIO(r2);
			producte.add(prod);
		}else {
			System.out.println("Taula incorrecta");
		}
		
	}
	
	public static void mostrar() {
		Producte_DAO producte = new Producte_DAO();
		Detall_DAO detall= new Detall_DAO();
		Comanda_DAO comanda= new Comanda_DAO();
		Scanner scan = new Scanner (System.in);
		System.out.println("Indica la taula per mostrar dades:");
		System.out.println("--------------------------------------");
		System.out.println("1-comanda");
		System.out.println("2-detall_comanda");
		System.out.println("3-producte");
		System.out.println("--------------------------------------");
		int usde=scan.nextInt();
		scan.hasNextLine();
		if(usde==1) {
			comanda.findAll();
		}else if(usde==2) {
			detall.findAll();
		}else if(usde==3) {
			producte.findAll();
		}else {
			System.out.println("Taula incorrecta");
		}
		
	}
	
	public static void borrar() {
		Producte_DAO producte = new Producte_DAO();
		Detall_DAO detall= new Detall_DAO();
		Comanda_DAO comanda= new Comanda_DAO();
		Scanner scan = new Scanner (System.in);
		System.out.println("Indica la taula per borrar dades:");
		System.out.println("--------------------------------------");
		System.out.println("1-comanda");
		System.out.println("2-detall_comanda");
		System.out.println("3-producte");
		System.out.println("--------------------------------------");
		int usde=scan.nextInt();
		scan.hasNextLine();
		if(usde==1) {
			System.out.println("Indica el codi de la comanda a esborrar");
			usde=scan.nextInt();
			comanda.delete(usde);
		}else if(usde==2) {
			System.out.println("Indica el codi del detall a esborrar");
			int usde1=scan.nextInt();
			scan.nextLine();
			System.out.println("Indica el codi de la comanda");
			int usde2=scan.nextInt();
			scan.nextLine();

			detall.delete(usde2,usde1);
		}else if(usde==3) {
			System.out.println("Indica el codi del producte a esborrar");
			usde=scan.nextInt();
			producte.delete(usde);
		}else {
			System.out.println("Taula incorrecta");
		}
		
	}
	
	public static void actualitzar() {
		Producte_DAO producte = new Producte_DAO();
		Detall_DAO detall= new Detall_DAO();
		Comanda_DAO comanda= new Comanda_DAO();
		Scanner scan = new Scanner (System.in);
		System.out.println("Indica la per actualitzar dades:");
		System.out.println("--------------------------------------");
		System.out.println("1-comanda");
		System.out.println("2-detall_comanda");
		System.out.println("3-producte");
		System.out.println("--------------------------------------");
		int usde=scan.nextInt();
		scan.hasNextLine();
		if(usde==1) {
			//error clave foranea
			System.out.println("Indica el numero de la comanda a modificar");
			int r1=scan.nextInt();
			scan.nextLine();
			System.out.println("Indica la nova data(YYY-MM-DD)");
			String r2=scan.nextLine();
			System.out.println("Indica el nou tipus(A,B,C)");
			String r3=scan.nextLine();
			System.out.println("Indica el nou client de codi");
			int r4= scan.nextInt();	
			scan.nextLine();
			System.out.println("Indica la nova data de tramesa(YYY-MM-DD)");
			String r5=scan.nextLine();
			System.out.println("Indica el total");
			double r6= scan.nextDouble();
			scan.nextLine();
			Comanda com = new Comanda();
			com.setCOM_NUM(r1);
			com.setCOM_DATE(r2);
			com.setCOM_TIPUS(r3);
			com.setCLIENT_COD(r4);
			com.setDATA_TRAMESA(r5);
			com.setTOTAL(r6);
			comanda.update(com);
		}else if(usde==2) {
			//error clave forane
			System.out.println("Indica el numero del detall a modificar");
			int r1=scan.nextInt();
			scan.nextLine();
			System.out.println("Indica el numero de la comanda del detall");
			int r2=scan.nextInt();
			scan.nextLine();
			System.out.println("Indica el codi del producte");
			int r3 = scan.nextInt();
			scan.nextLine();
			System.out.println("Indica el preu de venta");
			double r4=scan.nextDouble();
			scan.nextLine();
			System.out.println("Indica la cuantitat");
			int r5=scan.nextInt();
			scan.nextLine();
			System.out.println("Indica l' import");
			double r6= scan.nextDouble();
			scan.nextLine();
			Detall det= new Detall();
			det.setCOM_NUM(r2);
			det.setDETALL_NUM(r1);
			det.setIMPORT(r6);
			det.setPREU_VENDA(r4);
			det.setPROD_NUM(r3);
			det.setQUANTITAT(r5);
			detall.update(det);
			
			
		}else if(usde==3) {
			System.out.println("Indica el numero del producte a modificar");
			int r1 = scan.nextInt();
			scan.nextLine();
			System.out.println("Indica la nova descripcio");
			String r2=scan.nextLine();
			Producte prod = new Producte();
			prod.setPROD_NUM(r1);
			prod.setDESCRIPCIO(r2);
			producte.update(prod);
		}else {
			System.out.println("Taula incorrecta");
		}
		
	}

}


