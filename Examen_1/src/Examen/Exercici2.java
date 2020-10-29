package Examen;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Exercici2 {

	public static void main(String[] args) {
		 
		try {
			FileReader fr=new FileReader("A:\\Estudis\\DAM-2\\Acces_a_Dades\\UF1\\M6\\Examen_1\\Cargol.txt");
			int lletra=fr.read();
			String text="";
			while(lletra !=-1) {
				text=text+(char)lletra;
				lletra=fr.read();
				}
			
			fr.close();
			
			
			
			FileWriter fw= new FileWriter("A:\\Estudis\\DAM-2\\Acces_a_Dades\\UF1\\M6\\Examen_1\\Cargol.txt");
			if(text.contains("bover")) {
				text=text.replaceAll("bover,","revob");
				}
				if(text.contains("també ")) {
				text=text.replaceAll("també ","ebmat");
				}
			fw.write(text);
			fw.close();
			
			
			
		
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
