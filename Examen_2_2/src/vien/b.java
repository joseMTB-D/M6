package vien;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
public class b {
	static RandomAccessFile fichero=null;
	public static void main(String[] args) {

				Scanner scan= new Scanner(System.in);
				File a = new File("Personas.dat");
				
				try {
				
					fichero=new RandomAccessFile("Personas.dat","rw");
					System.out.println("Introduiex el nom de 4 persones");
					for(int i=0;i<4;i++) {
						System.out.println("Nom persona numero "+(i+1)+": ");
						String nom=scan.nextLine();
						fichero.seek(fichero.length());
						fichero.writeChars(nom);
					}
					int pos;
					System.out.println("Indica el nom a eliminar");
					String borrar=scan.nextLine();
					for (int i = 0; i < fichero.length(); i++) {
						String nom=fichero.readLine();
						//obtenemos la direccion del puntero |
						System.out.println(fichero.getFilePointer());
						//si el char es igual a una de las letras cambiaremos esta por la i
						if(nom.equals(borrar))
						{
							pos=(int)fichero.getFilePointer();//obtenemos la posicion de la letra.
							fichero.seek(pos-1);//ponemos el puntero en la posicion para sobreescribirla (-1 porque el puntero escribira hacia denlante(es decir,si la posicion es 3 escribira hacia la 4))
							fichero.writeChars(" ");//sobreescribimos la letra
						
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


