package Writer;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class filewriter {

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		//crear y leer
		
		try {
			FileWriter fw= new FileWriter("C:\\Users\\JoseM Toribio Bravo\\Desktop\\text.txt",true);
			String frase =scan.nextLine();
			fw.write("\n");
			String[]lletres =frase.split("");
			String[] vocals = {"a","e","o","u"};
			System.out.println(lletres.length);
			
			for(String a:lletres) {
				
				if((a.equals(vocals[0]))||(a.equals(vocals[1]))||(a.equals(vocals[2]))||(a.equals(vocals[3]))) {
					a="i";
				}
				fw.write(a);
			}
		fw.close();
		FileReader fr= new FileReader("C:\\Users\\JoseM Toribio Bravo\\Desktop\\text.txt");
		int lletra= fr.read();
		while(lletra!=-1) {
			System.out.print((char)lletra);
		lletra= fr.read();
		}
		fr.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

		

		

	}

}
