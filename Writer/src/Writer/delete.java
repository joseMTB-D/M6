package Writer;

import java.io.*;
import java.util.Scanner;



public class delete {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		try {
			FileReader fr= new FileReader("C:\\Users\\JoseM Toribio Bravo\\Desktop\\text.txt");
			int lletra=fr.read();
			String text="";
			while(lletra!=-1) {
				text= text+(char)lletra;
				lletra =fr.read();
			}
			fr.close();
			System.out.println("indica la paraula a cambiar");
			String pv=lector.nextLine();
			System.out.println("Indica la nova paraula");
			String pn=lector.nextLine();
			if(text.contains(pv)) {
				text=text.replaceAll(pv, pn);
			}else {
				System.out.println("Paraula no trobada");
			}
			FileWriter fw= new FileWriter("C:\\Users\\JoseM Toribio Bravo\\Desktop\\text.txt");
			fw.write(text);
			System.out.println(text);
			fw.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
