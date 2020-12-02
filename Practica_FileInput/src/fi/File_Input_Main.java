package fi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;




public class File_Input_Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String usuari="";
		File a = new File("productes.dat");
		
		try {
			//si no existe el fichero crearemos el array
			if(!a.exists()) {
				ArrayList<producte>llistap= new ArrayList<>();
				//entraremos en el bucle
			     do {
						System.out.println("----------------------------------------------");
						System.out.println("Que desitja fer:");
						System.out.println("----------------------------------------------");
						System.out.println("1-introduir un producte.");
						System.out.println("2-Mostrar el preu .");
						System.out.println("3-Modificar el preu .");
						System.out.println("4-Mostrar els productes.");
						System.out.println("5-Esborrar un producte.");
						System.out.println("6-Sortir.");
						System.out.println("----------------------------------------------");
						usuari=scan.nextLine();
						
						
				
						//insertaremos datos en el objeto a traves del array de objetos
						if(usuari.equals("introduir un producte")) {
							
							
							System.out.print("Inserta el nom del producte:");
							String nom=scan.nextLine();
							System.out.print("Inserta la marca del producte:");
							String marca=scan.nextLine();
							System.out.print("Inserta el preu del producte:");
							double preu=scan.nextDouble();
							System.out.print("Inserta la quantitat del producte:");
							int quantitat= scan.nextInt();
							scan.nextLine();
							producte p= new producte(nom,marca,preu,quantitat);
							llistap.add(p);
							
						
							
						}
						//mostraremos los precios de array de objetos(buscando uno en concreto)
						if(usuari.equals("mostrar el preu")) {
							System.out.println("¿De quin producte vols saber el preu?");
							String up=scan.nextLine();
							for(producte b: llistap) {
								if(b.getNom().equals(up)) {
								System.out.println(b.getPreu());
								}
							}

						}
						//modificaremos los precios del array de objetos(buscando uno en concreto)
						if(usuari.equals("modificar el preu")) {
							System.out.println("¿De quin producte vols modificar el preu?");
							String up=scan.nextLine();
							System.out.println("¿Quin sera el nou preu?");
							double upn=scan.nextDouble();

							for(producte b: llistap) {
								if(b.getNom().equals(up)) {
									b.setPreu(upn);
								System.out.println(b.getPreu());
								}
								
							}

							
						}
						//mostraremos todos los productos
						if(usuari.equals("mostrar els productes")) {

							for(producte b: llistap) {
								System.out.println(b.toString());
							}


						}
					
					    
						//borraremos un producto en concreto
						if(usuari.equals("esborrar un producte")) {
							System.out.println("¿Quin producte es vol eliminar?");
							String up=scan.nextLine();
						
							for(producte b: llistap) {
								if(b.getNom().equals(up)) {
									llistap.remove(b);	
								System.out.println("¡Producte eliminat!");
								break;//break para finalizar el bucle
								}
								
							}
							
						}
						
						//crearemos el objeto (en la carpeta de proyecto(en este caso))
						FileOutputStream fos1 = new FileOutputStream ("productes.dat");
					     ObjectOutputStream oos1 = new ObjectOutputStream(fos1); 
					     for (int i = 0; i <llistap.size(); i++) {
					    	 //realizamor la ejecucion de escribir(pero sin escribir nada realmente)||Esto nos permite crear el fichero||si no escribe no lo crea
					     oos1.writeObject(llistap.get(i)); 
					     }
					     oos1.close();
					     fos1.close();
					     //crreamos los comandos
					     //escribimos realmente los datos del objeto en el fichero
							FileInputStream fis = new FileInputStream("productes.dat");
							ObjectInputStream ois=new ObjectInputStream(fis);
							while(fis.available()!=0) {
								producte p=(producte)ois.readObject();
								llistap.add(p);
							}
						    ois.close();
						    fis.close();
						    //cerramos los comandos
					  
					}while(!usuari.equals("sortir"));
			}else {
				
				//si existe
			     do {
			    	//entraremos en el bucle
						System.out.println("----------------------------------------------");
						System.out.println("Que desitja fer:");
						System.out.println("----------------------------------------------");
						System.out.println("1-introduir un producte.");
						System.out.println("2-Mostrar el preu .");
						System.out.println("3-Modificar el preu .");
						System.out.println("4-Mostrar els productes.");
						System.out.println("5-Esborrar un producte.");
						System.out.println("6-Sortir.");
						System.out.println("----------------------------------------------");
						usuari=scan.nextLine();
						
						//recorremos el fichero para  añadir al array de objetos los datos de los objetos existentes en el fichero
						FileInputStream fis = new FileInputStream("productes.dat");
						ObjectInputStream ois=new ObjectInputStream(fis);
						ArrayList<producte>llistap= new ArrayList<>();
						while(fis.available()!=0) {
							producte p=(producte)ois.readObject();
							llistap.add(p);
							//los añadimos al arraylist
						}
					    ois.close();
					    fis.close();
					    
					  //insertaremos datos en el objeto a traves del array de objetos
						if(usuari.equals("introduir un producte")) {
							
							
							System.out.print("Inserta el nom del producte:");
							String nom=scan.nextLine();
							System.out.print("Inserta la marca del producte:");
							String marca=scan.nextLine();
							System.out.print("Inserta el preu del producte:");
							double preu=scan.nextDouble();
							System.out.print("Inserta la quantitat del producte:");
							int quantitat= scan.nextInt();
							scan.nextLine();
							producte p= new producte(nom,marca,preu,quantitat);
							llistap.add(p);
							
						
							
						}
						//mosrtar el precio de un producto en concreto
						if(usuari.equals("mostrar el preu")) {
							System.out.println("¿De quin producte vols saber el preu?");
							String up=scan.nextLine();
							for(producte b: llistap) {
								if(b.getNom().equals(up)) {
								System.out.println(b.getPreu());
								}
							}

						}
						//modificamos el precio e un producto en concreto
						if(usuari.equals("modificar el preu")) {
							System.out.println("¿De quin producte vols modificar el preu?");
							String up=scan.nextLine();
							System.out.println("¿Quin sera el nou preu?");
							double upn=scan.nextDouble();

							for(producte b: llistap) {
								if(b.getNom().equals(up)) {
									b.setPreu(upn);
								System.out.println(b.getPreu());
								}
								
							}

							
						}
						//mostramos todos los productos
						if(usuari.equals("mostrar els productes")) {

							for(producte b: llistap) {
								System.out.println(b.toString());
							}


						}
					
					    
						//borramos un producto en concreto
						if(usuari.equals("esborrar un producte")) {
							System.out.println("¿Quin producte es vol eliminar?");
							String up=scan.nextLine();
						
							for(producte b: llistap) {
								if(b.getNom().equals(up)) {
									llistap.remove(b);	
								System.out.println("¡Producte eliminat!");
								break;//break para finalizar el bucle y evitar que pete
								}
								
							}
							
						}
						//escribimos en el fichero los objetos del array de objetos
						FileOutputStream fos = new FileOutputStream ("productes.dat");
					    ObjectOutputStream oos = new ObjectOutputStream(fos);
					    for (producte per : llistap) {
						oos.writeObject(per);
					    }
						
						oos.close();
					    fos.close();
					}while(!usuari.equals("sortir"));
			     
			}
			
		   
		
			
		
			 
	} catch (Exception e) {
		System.out.println(e);	}
	}

}
