package file;

import java.io.File;
import java.io.IOException;

public class file1 {

	public static void main(String[] args) {
		File f1= new File("FEDERICO3.txt");
		File f2= new File("A:\\Estudis\\DAM-2\\Acces_a_Dades\\UF1\\M6\\file","FEDERICO3.txt");
		File ruta= new File("A:\\Estudis\\DAM-2\\Acces_a_Dades\\UF1\\M6\\file");
		File f4 = new File(ruta,"FEDERICO3.txt");

		
		try {
			System.out.print(f2.createNewFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
