package proba;
import java.util.Scanner;

public class programa {
	public static void main (String[]args) {
		Scanner scan= new Scanner(System.in);
		int n1=0,n2=0;
		System.out.println("Inserta 2 numeros");
		n1=scan.nextInt();
		n2=scan.nextInt();
		int res= n1+n2;
		System.out.println("resultat: "+"\n"+res);
		if(res<0&&res>5){
			System.out.println("El resultat esta entre 0 i 5");
		}else if(res>5&& res<=8) {
			System.out.println("El resultat esta entre 5 i 8");
		}else if(res>8&& res<=8) {
			System.out.println("El resultat es 8");
		}else {
			System.out.println("Resultat no valid");
		}
		
		
		
	}

}
