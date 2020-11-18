package objetos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class fileOBJ {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		persona p1= new persona("peper","8595424X",32,785646461);
		
		
		/*int tlf2= scan.nextInt();
		
		p1.setTelefon(tlf2);*/
		
		//System.out.println(p1.toString());
	/*ArrayList<persona> llistap = new ArrayList<>();
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
		*/
		//espectacular
		/*
		for (persona persona : llistap) {
			System.out.println(persona.toString());
		}
		*/
		try {
			
			//llegir
			//FileOutputStream fos = new FileOutputStream("persones.dat");
			//ObjectOutputStream oos=new ObjectOutputStream(fos);
			//for (int i = 0; i <llistap.size(); i++) {
				//oos.writeObject(llistap.get(i));
			//}
			//escriure
			FileInputStream fis = new FileInputStream("persones.dat");
			ObjectInputStream ois=new ObjectInputStream(fis);
			ArrayList<persona> llistap = new ArrayList<>();
			persona p= (persona)ois.readObject();
			llistap.add(p);
			while(fis.available()!=0) {
				p= (persona)ois.readObject();
				llistap.add(p);	
			}
			ois.close();
			fis.close();
		for(persona z:llistap) {
			System.out.println(z.toString());
		}
		for (int i = 0; i <2; i++) {
			System.out.print("Inserta el nom: ");
			String nom = scan.nextLine();
			System.out.print("Inserta el DNI: ");
			String dni = scan.nextLine();
			System.out.print("Inserta la edat: ");
			int edat=scan.nextInt();
			System.out.print("Inserta el telefon: ");
			int telf= scan.nextInt();
			p=new persona(nom,dni,edat,telf);
			llistap.add(p);
			scan.nextLine();
		}
		FileOutputStream fos = new FileOutputStream("persones.dat");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
	for(persona x:llistap) {
		oos.writeObject(x);
	}
		fos.close();
		oos.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		

	}

}
