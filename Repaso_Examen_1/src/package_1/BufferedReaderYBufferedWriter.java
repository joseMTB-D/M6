package package_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class BufferedReaderYBufferedWriter {

	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		try {
			//BufferedReader
			FileReader fr = new FileReader("C:\\Users\\JoseM Toribio Bravo\\Desktop\\Repaso.txt");
			BufferedReader br = new BufferedReader(fr);
			String linia=br.readLine();
			while(linia!=null) {
				System.out.println(linia);;
				linia= br.readLine();
			}
			br.close();
			fr.close();
			//BufferedWriter
			FileWriter fw = new FileWriter("C:\\Users\\JoseM Toribio Bravo\\Desktop\\Repaso.txt",true);
			BufferedWriter bw = new BufferedWriter(fw);
			String nou =scan.nextLine();
			
			bw.write(nou);
			bw.write("\n");
			bw.close();
			fw.close();
			

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
