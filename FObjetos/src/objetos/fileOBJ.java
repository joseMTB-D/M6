package objetos;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class fileOBJ {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		persona p1= new persona("peper","8595424X",32,785646461);
		
		
		/*int tlf2= scan.nextInt();
		
		p1.setTelefon(tlf2);*/
		
		//System.out.println(p1.toString());
	ArrayList<persona> llistap = new ArrayList<>();
		for (int i = 0; i <2; i++) {
			System.out.print("Inserta el nom: ");
			String nom = scan.nextLine();
			System.out.print("Inserta el DNI: ");
			String dni = scan.nextLine();
			System.out.print("Inserta la edat: ");
			int edat=scan.nextInt();
			System.out.print("Inserta el telefon: ");
			int telf= scan.nextInt();
			persona p=new persona(nom,dni,edat,telf);
			llistap.add(p);
			scan.nextLine();
		}
		//espectacular
		for (persona persona : llistap) {
			System.out.println(persona.toString());
		}
		try {
			FileOutputStream fos = new FileOutputStream("persones.dat");
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			for (int i = 0; i <llistap.size(); i++) {
				oos.writeObject(llistap.get(i));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		

	}

}
