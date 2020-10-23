package Writer;

import java.io.BufferedReader;
import java.util.Scanner;
import java.io.*;

public class bufferedreader {

	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		try {
			FileReader fr= new FileReader("C:\\Users\\JoseM Toribio Bravo\\Desktop\\text.txt");
			BufferedReader br= new BufferedReader(fr);
			String linia=br.readLine();
			
			while(linia!=null) {
			System.out.println(linia);
			linia=br.readLine();
			}
			br.close();
			fr.close();
			
			FileWriter fw= new FileWriter("C:\\Users\\JoseM Toribio Bravo\\Desktop\\text.txt",true);//true=mantenir dades.
			BufferedWriter bw= new BufferedWriter(fw);
			System.out.println("Insertar dades");
			String nou=scan.nextLine();
			bw.newLine();
			bw.write(nou);
			bw.close();
			fw.close();
			
			
		} catch (Exception e) {
			
			
		}

	}

}
