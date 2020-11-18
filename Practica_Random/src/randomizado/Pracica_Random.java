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
		fichero=new RandomAccessFile("Binarios.dat","rw");
		mostrarFichero();
		
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
	public static void mostrarFichero() {
		 int n;
	        try {
	            fichero.seek(0); //nos situamos al principio
	            while (true) {
	            	int i=0;
	            	i+=2;
	            	n = fichero.readInt();  //se lee  un entero del fichero   
	            	if(i==2) {      
	            	n = fichero.readInt();  //se lee  un entero del fichero   
	                System.out.print(n+" ");  //se muestra en pantalla
	               
	            	}
	            }
	        } catch (EOFException e) {
	            System.out.println("Fin de fichero");
	        } catch (IOException ex) {
	            System.out.println(ex.getMessage());
	        }
	    }
}
