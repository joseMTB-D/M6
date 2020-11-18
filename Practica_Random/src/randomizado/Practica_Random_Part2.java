package randomizado;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
public class Practica_Random_Part2 {
	  static RandomAccessFile fichero=null;
	
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		System.out.println("Inicio Fichero");	
		char c;
		
	try {
		int pos;
		fichero = new RandomAccessFile("cambio.dat","rw");
		
		
		for (int i = 0; i < fichero.length(); i++) {
		System.out.println(c=(char)fichero.readByte());//leer el fichero
		System.out.println(fichero.getFilePointer());
		if((c=='a')||(c=='e')||(c=='o')||(c=='u'))
		{
			pos=(int)fichero.getFilePointer();
			fichero.seek(pos-1);
			fichero.writeByte('i');
		
		}
		}
			
		


		
		
	} catch (FileNotFoundException ex) {
		// TODO: handle exception
	}catch (IOException ex) {
       
    } finally {
    	try {
		if(fichero !=null) {
			fichero.close();
			}
    	} catch (Exception e) {
		// TODO: handle exception
    	}
    	
    }
    
		

	}
	
}
