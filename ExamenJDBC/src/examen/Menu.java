package examen;

import java.util.Scanner;

public class Menu {

	usuari_dao user= new usuari_dao();
	llibre_dao llibre= new llibre_dao();
	prestec_dao prestec= new prestec_dao();
	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		int usuari =0;
		do {
			System.out.println("Registrar Llibre.............1");
			System.out.println("Registrar Usuari.............2");
			System.out.println("Registrar Prestec............3");
			System.out.println("Mostrar usuaris amb prestec..4");
			System.out.println("Mostrar llibres disponibles..5");
			System.out.println("Actualitzar estat prestec....6");
			System.out.println("Sortir.......................7");
			usuari=scan.nextInt();
			scan.hasNextLine();
			if (usuari==1) {
				reg_llibre();
			}
			if (usuari==2) {
				reg_user();
			}
			if (usuari==3) {
				reg_prest();
			}
			if (usuari==4) {
				most_usu_prest();
			}
			if (usuari==5) {
				most_llib_disp();
			}
			if (usuari==6) {
				act_prest();
			}
		}while(usuari!=7);

	}
	public static void reg_llibre() {
		llibre_dao lldao= new llibre_dao();
		Scanner scan = new Scanner (System.in);
		System.out.println("Indica el ISBN");
		String us1=scan.nextLine();
		System.out.println("Indica el Titol");
		String us2=scan.nextLine();
		System.out.println("Indica la Categoria");
		String us3=scan.nextLine();
		System.out.println("Indica el Preu");
		double us4=scan.nextDouble();
		scan.nextLine();
		System.out.println("Indica la Editorial");
		String us5=scan.nextLine();
		System.out.println("Indica L'Autor");
		String us6=scan.nextLine();
		Llibre llib= new Llibre(us1,us2,us3,us4,us5,us6);
		lldao.registrar(llib);
	}
	public static void reg_user() {
		Scanner scan = new Scanner (System.in);
		System.out.println("Indica el DNI");
		String us1=scan.nextLine();
		System.out.println("Indica el nom");
		String us2=scan.nextLine();
		System.out.println("Indica el telefon");
		int us3 =scan.nextInt();
		scan.nextLine();
		System.out.println("Indica el correo");
		String us4=scan.nextLine();
		usuari use= new usuari(us1,us2,us3,us4);
		usuari_dao user= new usuari_dao();
		user.registrar(use);
		
	}
	public static void reg_prest(){
		Scanner scan = new Scanner (System.in);
		System.out.println("Indica el codi");
		int us1=scan.nextInt();
		scan.nextLine();
		System.out.println("Indica el ISBN del llibre prestat");
		String us2=scan.nextLine();
		System.out.println("Indica el dni del prestant");
		String us3=scan.nextLine();
		System.out.println("La data de registre s'ha creat automaticament");
		System.out.println("Indica la data de retorn amb el format seguent<yyy-mm-dd>");
		String us4=scan.nextLine();
		System.out.println("Indica si esta prestat o no (0 o 1)");
		int us5=scan.nextInt();
		scan.nextLine();
		Prestec pres= new Prestec(us1,us2,us3,us4,us5);
		prestec_dao prestec= new prestec_dao();
		prestec.registrar(pres);

	}
	public static void most_usu_prest() {
		usuari_dao user= new usuari_dao();
		user.prestec();
	}
	public static void most_llib_disp() {
		llibre_dao llibre= new llibre_dao();
		llibre.llibres_prestec();
	}
	public static void act_prest(){
		Scanner scan = new Scanner (System.in);
		System.out.println("Indica el codi del prestec a actualitzar");
		int us1=scan.nextInt();
		scan.nextLine();
		System.out.println("Indica si el llibre s'ha tornat o no (0=no ,1=si)");
		int us2=scan.nextInt();
		scan.nextLine();
		prestec_dao prestec= new prestec_dao();
		Prestec pres= new Prestec();
		pres.setCodi(us1);
		pres.setRetornat(us2);
		prestec.gestio_prestec(pres);

		
	}
}