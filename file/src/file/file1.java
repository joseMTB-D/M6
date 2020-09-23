package file;

import java.io.File;
import java.io.IOException;

public class file1 {

	public static void main(String[] args) {
		File f1= new File("FEDERICO1.txt");
		File f2= new File("A:\\Estudis\\DAM-2\\Acces_a_Dades\\UF1\\M6\\file","FEDERICO2.txt");
		File ruta= new File("A:\\Estudis\\DAM-2\\Acces_a_Dades\\UF1\\M6\\file");
		File f4 = new File(ruta,"FEDERICO3.txt");

		
		try {
			if(f1.exists()) {
			System.out.println( "EXISTEIX.");
			System.out.println(f2.getName());
			System.out.println(f2.getAbsolutePath());
			System.out.println(f2.getPath());
			System.out.println(f2.getParent());
			System.out.println();
			//f4
			System.out.println( "EXISTEIX.");
			System.out.println(f4.getName());
			System.out.println(f4.getAbsolutePath());
			System.out.println(f4.getPath());
			System.out.println(f4.getParent());
			System.out.println();
			//f1
			System.out.println( "EXISTEIX.");
			System.out.println(f1.getName());
			System.out.println(f1.getAbsolutePath());
			System.out.println(f1.getPath());
			System.out.println(f1.getParent());
			System.out.println();
			}else {
				System.out.print(f2.createNewFile());
				System.out.print(f4.createNewFile());
				System.out.print(f1.createNewFile());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
