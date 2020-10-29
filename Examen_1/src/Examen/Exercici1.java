package Examen;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercici1 {

	public static void main(String[] args) {
		File f = new File("A:\\Estudis\\DAM-2\\Acces_a_Dades\\UF1\\M6\\Examen_1\\Fitxers");
		try {
		String[]components =f.list();
		ArrayList<File>dir=new ArrayList();
		
		for(String a:components) {
		File b= new File(f,a);
		dir.add(b);
		}
		for(File c:dir) {
			if(c.isFile()) {
				String format=c.toString();
				String fitxer=c.getName();
				
				
				
				
				if(fitxer.contains(".pdf")) {
					File carp1= new File(f+"/"+"PDF");
					if(!carp1.exists()) {
						if(carp1.mkdir()) {
						}
					}
					File carp2= new File(carp1+"\\"+fitxer);
					if(!carp2.createNewFile()) {
						
					}
					File carp3= new File(f+"\\"+fitxer);
					if(carp3.exists()) {
						if(carp3.delete()) {
							
						}
					}
				}
				
				if(format.contains(".png")) {
					File carp1= new File(f+"/"+"PNG");
					if(!carp1.exists()) {
						if(carp1.mkdir()) {
						}
					}
					File carp2= new File(carp1+"\\"+fitxer);
					if(!carp2.createNewFile()) {
						
					}
					File carp3= new File(f+"\\"+fitxer);
					if(carp3.exists()) {
						if(carp3.delete()) {
							
						}
					}
					
					
					
				}
				if(format.contains(".txt")) {
					File carp1= new File(f+"/"+"TXT");
					if(!carp1.exists()) {
						if(carp1.mkdir()) {
						}
					}
					File carp2= new File(carp1+"\\"+fitxer);
					if(!carp2.createNewFile()) {
						
					}
					File carp3= new File(f+"\\"+fitxer);
					if(carp3.exists()) {
						if(carp3.delete()) {
							
						}
					}
				}
				
				
				
				
				if(format.contains(".mp4")) {
					File carp1= new File(f+"/"+"MP4");
					if(!carp1.exists()) {
						if(carp1.mkdir()) {
						}
						
					}
					File carp2= new File(carp1+"\\"+fitxer);
					if(!carp2.createNewFile()) {
						
					}
					
				}
				File carp3= new File(f+"\\"+fitxer);
				if(carp3.exists()) {
					if(carp3.delete()) {
						
					}
				}
			}
			
		}
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
