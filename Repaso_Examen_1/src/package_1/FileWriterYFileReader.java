package package_1;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class FileWriterYFileReader {

	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);

		try {
			//FileReader
			FileReader fr= new FileReader("C:\\Users\\JoseM Toribio Bravo\\Desktop\\Repaso.txt");
			int lletra =fr.read();
			
			while(lletra!=-1) {
				System.out.println((char)lletra);
				lletra=fr.read();
			}
			fr.close();
			//FileWriter
			FileWriter fw = new FileWriter("C:\\\\Users\\\\JoseM Toribio Bravo\\\\Desktop\\\\Repaso.txt",true);
			String frase=scan.nextLine();
			fw.write("\n");
			String[]lletres = frase.split(" ");
			String[]vocals = {"a","e","i","o","u"};
			for(String a:lletres) {
				if((a.equals(vocals[0]))||(a.equals(vocals[1]))||(a.equals(vocals[2]))||(a.equals(vocals[3]))) {
					a="i";
				}
				fw.write(a);
						}
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
