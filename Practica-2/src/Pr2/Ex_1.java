package Pr2;
import java.io.*;
public class Ex_1 {

	public static void main(String[] args) {
		
		
		try {
			System.out.println("Identificat contingut");
			FileReader fr =new FileReader("A:\\Estudis\\DAM-2\\Acces_a_Dades\\UF1\\M6\\Practica-2\\Poema.txt");
			int lletra=fr.read();
			String otext ="";
			while(lletra !=-1) {
			otext=otext+(char)lletra;	
			lletra=fr.read();
			}
			fr.close();
			
			if(otext.equals(".")) {
				otext=otext.replace(".","\n");
			}
			
			

			String[]linia = otext.split("\n");
			String ntext="";
			
			
			
			for(int i=linia.length-1;i>=0;i--) {
				ntext=ntext+linia[i];
				
			}
			System.out.println(ntext);
			FileWriter fw= new FileWriter("A:\\Estudis\\DAM-2\\Acces_a_Dades\\UF1\\M6\\Practica-2\\Poema.txt");
			fw.write(ntext);
			fw.close();
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
