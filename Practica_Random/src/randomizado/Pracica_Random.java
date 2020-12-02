package randomizado;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Pracica_Random {
	static RandomAccessFile fichero=null;
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		int numero;
	try {
		//fichero con 10 numeros
		fichero=new RandomAccessFile("Binarios.dat","rw");
		
		
		//asi inserte los 10 numeros
	/*	for (int i = 0; i < 10; i++) {
			System.out.print("numero "+(i+1)+" >");
			numero=scan.nextInt();
			fichero.seek(fichero.length());
			fichero.writeInt(numero);
		}*/
		
		
		
		
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
	//metodo que permite leer el fichero
	