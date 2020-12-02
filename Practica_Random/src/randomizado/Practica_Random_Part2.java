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
		//selecionamos el fichero
	try {
		int pos;
		fichero = new RandomAccessFile("cambio.dat","rw");
		
		//lo leemos
		for (int i = 0; i < fichero.length(); i++) {
		System.out.println(c=(char)fichero.readByte());//leer el fichero
		//obtenemos la direccion del puntero |
		System.out.println(fichero.getFilePointer());
		//si el char es igual a una de las letras cambiaremos esta por la i
		if((c=='a')||(c=='e')||(c=='o')||(c=='u'))
		{
			pos=(int)fichero.getFilePointer();//obtenemos la posicion de la letra.
			fichero.seek(pos-1);//ponemos el puntero en la posicion para sobreescribirla (-1 porque el puntero escribira hacia denlante(es decir,si la posicion es 3 escribira hacia la 4))
			fichero.writeByte('i');//sobreescribimos la letra
		
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
