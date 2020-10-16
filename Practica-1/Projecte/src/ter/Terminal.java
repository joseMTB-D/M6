package ter;
import java.io.File;
import java.lang.reflect.Array;
import java.util.*;
import java.util.ArrayList;
import java.util.Calendar;
public class Terminal {

	public static void main(String[] args) {
		Scanner lector= new Scanner(System.in);
		String usuari="";
		File starto = new File("C:\\Users\\JoseM Toribio Bravo");
		do {
			
			System.out.print(starto+">");
		usuari = lector.nextLine();
		String[] us0 = usuari.split(" ");
		
		
		
		if(us0[0].equals("cd")) {
			//String[] us1 = usuari.split(" ");
			String us1= usuari.substring(usuari.indexOf(" ")+1,usuari.length());
			
			
			/*for(int i=1;i<us1.length;i++) {
				 us2= us2+us1[i];
				
			}
			*/
			File us2= new File(us1);
			starto= us2;
			
			
			
		}
		if(us0[0].equals("mkdir")) {
			String us1= usuari.substring(usuari.indexOf(" ")+1,usuari.length());
			File us2= new File (starto+"/"+us1);			

				if(!us2.exists()) {
					if(us2.mkdir()) {
					}
				}
			
			
			
		}
		if(us0[0].equals("dir")) {
		String[]llista = starto.list();
		ArrayList<File>dir= new ArrayList();
		
		for(String a:llista) {
			File b = new File(starto,a);
			dir.add(b);
		}
		int TT=0;
		for(File c: dir) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(c.lastModified());
		
			int Year =calendar.get(Calendar.YEAR);
			int Month =calendar.get(Calendar.MONTH);
			int Day =calendar.get(Calendar.DAY_OF_MONTH);
			int Hour =calendar.get(Calendar.HOUR);
			int Minut =calendar.get(Calendar.MINUTE);
			
			if(c.isDirectory()) {
				System.out.println(Day+"/"+Month+"/"+Year+"  "+Hour+":"+Minut+"   "+" <DIR>   "+c.getName());
				TT= (int) (TT+c.length());
			}else if(c.isFile()) {
				System.out.println(Day+"/"+Month+"/"+Year+"  "+Hour+":"+Minut+"   "+"		  "+c.getName());
				TT= (int) (TT+c.length());
			}
			
		}
		System.out.println("						"+llista.length +" archius "+TT+" bytes");
		
		}
		if(us0[0].equals("del")) {
			String us1= usuari.substring(usuari.indexOf(" ")+1,usuari.length());
			File us2= new File (starto+"/"+us1);
				if(us2.exists()) {
					if(us2.delete()) {

					
					}
				}
		}
		if(us0[0].equals("rename")) {
			String us1= usuari.substring(usuari.indexOf(" ")+1,usuari.length());
			String us2 = us1.substring(us1.indexOf(" ")+1,us1.length());
			String[] us1_1 = usuari.split(" ");
			String us1_2 = us1_1[1];
			File us1_3= new File(starto+"/"+us1_2);
			File us3= new File(us2);
			File us4= new File (starto+"/"+us3);
			
			
				if(us1_3.exists()) {
					us1_3.renameTo(us4);
						
					
					
				}
		}
		
			
			
			
			
			
		}while(!usuari.equals("exit"));

	}

}
