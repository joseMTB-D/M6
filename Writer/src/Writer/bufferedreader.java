package Writer;

import java.io.BufferedReader;
import java.io.*;

public class bufferedreader {

	public static void main(String[] args) {
		
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
		} catch (Exception e) {
			
			
		}

	}

}
