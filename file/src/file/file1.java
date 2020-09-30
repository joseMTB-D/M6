package file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

public class file1 {

	public static void main(String[] args) {
		File ruta= new File("A:\\Estudis\\DAM-2");
		File f4 = new File(ruta,"FEDERICO3.txt");
		String[] llista= ruta.list();
		
		ArrayList<File> llistafile = new ArrayList();
		for(String a:llista) {
			File b= new File(ruta,a);
			llistafile.add(b);
		}
		for(File c:llistafile) {
			//libreria calendar(pasar milisegundos a fecha)
			Calendar calendar= Calendar.getInstance();
			calendar.setTimeInMillis(c.lastModified());
			int year =calendar.get(Calendar.YEAR);
			
			
			if(c.isDirectory()) {
			System.out.println(c.getName()+" Es n directori "+"de tamany "+c.length()+" Bytes "+" "+calendar.getTime());
			}
		}

		/*try {
			if(f1.exists()) {
			System.out.println( "EXISTEIX.");
			System.out.println(f2.getName());
			System.out.println(f2.getAbsolutePath());
			System.out.println(f2.getPath());
			System.out.println(f2.getParent());
			System.out.println();
			//f4
			System.out.println( "EXISTEIX.");
			System.out.println(f4.getName());
			System.out.println(f4.getAbsolutePath());
			System.out.println(f4.getPath());
			System.out.println(f4.getParent());
			System.out.println();
			//f1
			System.out.println( "EXISTEIX.");
			System.out.println(f1.getName());
			System.out.println(f1.getAbsolutePath());
			System.out.println(f1.getPath());
			System.out.println(f1.getParent());
			System.out.println();
			}else {
				System.out.print(f2.createNewFile());
				System.out.print(f4.createNewFile());
				System.out.print(f1.createNewFile());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		
		
		
		
	}

}
