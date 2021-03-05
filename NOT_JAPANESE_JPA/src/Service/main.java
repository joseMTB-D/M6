package Service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Llibre;
import model.Prestec;
import model.Usuari;

public class main {

	public static void main(String[] args) {
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "NOT_JAPANESE_JPA" );//llama al persistence.xml(tiene la conexion y configuracion)
	      
	      EntityManager entitymanager = emfactory.createEntityManager( );//similar al statement.
	      entitymanager.getTransaction( ).begin( );
	      Llibre l1= new Llibre("5652","juaquin","ficccion","Serafin",13.50,"lo que el flaco me dejo");
	      Llibre l2= new Llibre("5642","roca","tension","Ceramicas SL",13.50,"Al borde de la cadena");
	      Llibre l3= new Llibre("4454","2021","suspense","sanchez",13.50,"el secreto de los bancos");
	      
	      entitymanager.persist(l1);
	      entitymanager.persist(l2);
	      entitymanager.persist(l3);
	      
	      Usuari u1= new Usuari("45s","laputada@gmail.com","carles",66666);
	      Usuari u2= new Usuari("25s","dejava@gmail.com","roura",65656);
	      Usuari u3= new Usuari("5612s","T3@gmail.com","suspenso",46513);
	      
	      entitymanager.persist(u1);
	      entitymanager.persist(u2);
	      entitymanager.persist(u3);
	      Date date = new Date();
	      Date mes= new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			 mes.setMonth(date.getMonth()+1);
		
	      Prestec p1= new Prestec(123,date,mes,(byte)0,u1,l1);
	      entitymanager.persist(p1);
	      entitymanager.getTransaction( ).commit();//realiza los camondos
	      entitymanager.close();
	      emfactory.close();
		

	}

}
