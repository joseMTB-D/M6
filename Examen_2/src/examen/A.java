package examen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;







public class A {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int usuari=0;
	
		ArrayList<producte>llistap= new ArrayList<>();

		ArrayList<ticket>llistat= new ArrayList<>();
		File a = new File("ticket.dat");

		try {
			
				FileInputStream fis = new FileInputStream("productes.dat");
				ObjectInputStream ois=new ObjectInputStream(fis);
				while(fis.available()!=0) {
					producte p=(producte)ois.readObject();
					llistap.add(p);
				}
			    ois.close();
			    fis.close();
			if(a.exists()) {
				FileInputStream tfis = new FileInputStream("ticket.dat");
				ObjectInputStream tois=new ObjectInputStream(tfis);
				while(tfis.available()!=0) {
					ticket p=(ticket)tois.readObject();
					llistat.add(p);
				}
			    tois.close();
			    tfis.close();
				do {
					System.out.println("1-afegir");
					System.out.println("2-mostrar");
					System.out.println("3-sortir");
					usuari=scan.nextInt();
					scan.nextLine();

					if(usuari==1) {
						System.out.println("indica el nombre del producte");
						String producte=scan.nextLine();
						boolean esta=false;
						ticket t= new ticket();
						for(producte p:llistap) {
							if(p.getNom().equals(producte)) {
								esta=true;
								t.setProducte(p);
							}
						}
						if(esta=true) {
							System.out.println("indica le codi del ticket");
							int codit=scan.nextInt();
							scan.nextLine();
							System.out.println("indica el nom del empleat");
							String empleat=scan.nextLine();				
							System.out.println("indica la data del ticket");
							String data=scan.nextLine();						
							t.setCodi_ticket(codit);
							t.setNom_empleat(empleat);
							t.setData_ticket(data);
							llistat.add(t);
							scan.nextLine();
						}
						
					}
					if(usuari==2) {
						for(ticket t:llistat) {
							System.out.println(t.toString());
						}
					}
					scan.nextLine();
					FileOutputStream fos = new FileOutputStream ("ticket.dat");
				    ObjectOutputStream oos = new ObjectOutputStream(fos);
				    for (ticket per : llistat) {
					oos.writeObject(per);
				    }
					
					oos.close();
				    fos.close();
				}while(usuari!=3);
				
			}else {
				do {
					System.out.println("1-afegir");
					System.out.println("2-mostrar");
					System.out.println("3-sortir");
					usuari=scan.nextInt();
					scan.nextLine();

					if(usuari==1) {
						System.out.println("indica el nombre del producte");
						String producte1=scan.nextLine();
						
						ticket t= new ticket();
						for(producte p:llistap) {
							if(p.getNom().equals(producte1)) {
									System.out.println("indica le codi del ticket");
									int codit=scan.nextInt();
									scan.nextLine();
									System.out.println("indica el nom del empleat");
									String empleat=scan.nextLine();				
									System.out.println("indica la data del ticket");
									String data=scan.nextLine();						
									t.setCodi_ticket(codit);
									t.setNom_empleat(empleat);
									t.setData_ticket(data);
									t.setProducte(p);
									llistat.add(t);
							}
						}
						
						
						}
						
					
					if(usuari==2) {
						for(ticket t:llistat) {
							System.out.println(t.toString());
						}
					}
					
					//crearemos el objeto (en la carpeta de proyecto(en este caso))
					FileOutputStream fos1 = new FileOutputStream ("ticket.dat");
				     ObjectOutputStream oos1 = new ObjectOutputStream(fos1); 
				     for (int i = 0; i <llistat.size(); i++) {
				    	 //realizamor la ejecucion de escribir(pero sin escribir nada realmente)||Esto nos permite crear el fichero||si no escribe no lo crea
				     oos1.writeObject(llistat.get(i)); 
				     }
				     oos1.close();
				     fos1.close();
				     //crreamos los comandos
				     //escribimos realmente los datos del objeto en el fichero
						FileInputStream tfis = new FileInputStream("ticket.dat");
						ObjectInputStream tois=new ObjectInputStream(tfis);
						while(tfis.available()!=0) {
							ticket p=(ticket)tois.readObject();
							llistat.add(p);
						}
					    tois.close();
					    tfis.close();
				}while(usuari!=3);
					
			}
			    
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
