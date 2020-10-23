package Pr2;

import java.io.FileReader;
import java.util.Scanner;
import java.io.BufferedReader;

public class Ex_2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
			try {
				System.out.println("Indica la ID: ");
				int id=scan.nextInt();
				FileReader fr =new  FileReader("A:\\Estudis\\DAM-2\\Acces_a_Dades\\UF1\\M6\\Practica-2\\Dades.txt");
				BufferedReader br =new BufferedReader(fr);
				String linia=br.readLine();
				String txt="";
				while(linia!=null) {
					linia=br.readLine();
					if(linia!=null) {
					txt=txt+linia+"\n";
					}else {
						linia=br.readLine();
					}
				}
				String[]cerca = txt.split("\n");
				String txt2="";
				String resu= "";
				for(int i=0;i<cerca.length;i++) {
					if((id-1)==i) {
					txt2=txt2+cerca[i];
					
					}
					
				}
				String[]gmail =txt2.split("\\|");
				for(int i=0;i<gmail.length;i++) {
					if(gmail[i].contains("@")) {
						resu=gmail[i];
						
					}

				}
							
							
						
					
				
			System.out.println(resu);
				br.close();
				fr.close();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		
		

	}

}
