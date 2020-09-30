package ter;
import java.io.File;
import java.util.*;
import java.util.ArrayList;
import java.util.Calendar;
public class Terminal {

	public static void main(String[] args) {
		Scanner lector= new Scanner(System.in);
		String usuari="";
		
		do {
			File starto = new File("C:\\Users\\JoseM Toribio Bravo");
			System.out.print(starto+">");
		usuari= lector.next();
		
		
		if(usuari.equals("cd")) {
			
		}
		if(usuari.equals("mkdir")) {
			
		}
		if(usuari.equals("dir")) {
		String[]llista = starto.list();
		ArrayList<File>dir= new ArrayList();
		
		for(String a:llista) {
			File b = new File(starto,a);
			dir.add(b);
		}
		for(File c: dir) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(c.lastModified());
			
			int Year =calendar.get(Calendar.YEAR);
			int Month =calendar.get(Calendar.MONTH);
			int Day =calendar.get(Calendar.DAY_OF_MONTH);
			int Hour =calendar.get(Calendar.HOUR);
			int Minut =calendar.get(Calendar.MINUTE);
			
			if(c.isDirectory()) {
				System.out.println(Day+"/"+Month+"/"+Year+"  "+Hour+":"+Minut+"   "+"<DIR>   "+c.getName());
			}
			
		}
		
		}
		if(usuari.equals("rename")) {
			
		}
		
			
			
			
			System.out.println(usuari);
			
		}while(!usuari.equals("exit"));

	}

}
