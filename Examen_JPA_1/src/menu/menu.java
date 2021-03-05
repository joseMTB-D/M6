package menu;

import java.sql.Time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Bombero;
import model.Coche;
import model.Equipo;
import model.EquipoPK;
import model.Parque;
import model.Servicio;

public class menu {
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) throws ParseException {
		int usuari=0;
		while(usuari!=5) {
			
			System.out.println("Informacion bombero..................1");
			System.out.println("Registrar un bombero nuevo...........2");
			System.out.println("Registrar coche......................3");
			System.out.println("Registrar un servicio................4");
			System.out.println("salir................................5");
			System.out.print("User>");
			usuari=scan.nextInt();
			scan.nextLine();
			if(usuari==1) {
				
				infoBombero();
			}
			if(usuari==2) {
				System.out.println("Registrando bombero");
				RegBomb();
			}
			if(usuari==3){
				System.out.println("Registrando vehiculo");
				RegCoche();
			}
			if(usuari==4) {
				System.out.println("Registrando servicio");
				RegService();
			}
		}

	}
	public static void infoBombero() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Examen_JPA_1");																								// configuracion)
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		
		System.out.println("Indica el identificador del bombero:");
		int id=scan.nextInt();
		scan.nextLine();
		Bombero bob= entitymanager.find(Bombero.class,id);
		String datos_bob="Nombre y Apellidos : "+bob.getNombre()+" "+bob.getApellidos()+"|| Telefono: "+bob.getTelefono();
		System.out.println(datos_bob);
		
		entitymanager.getTransaction( ).commit();
	    entitymanager.close();
	    emfactory.close();
	}
	public static void RegBomb() throws ParseException {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Examen_JPA_1");																								// configuracion)
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		//recopilar datos de bombero
		System.out.println("Indica la id del bombero:");
		int id=scan.nextInt();
		scan.nextLine();
		System.out.println("Indica la id del parque al que pertenecera:");
		int idpark=scan.nextInt();
		scan.nextLine();
		System.out.println("Indica sus apellidos:");
		String apellidosbob=scan.nextLine();
		System.out.println("indica su nombre:");
		String nombrebob=scan.nextLine();
		System.out.println("Indica su DNI:");
		String dnibob=scan.nextLine();
		System.out.println("Indica su fecha de nacimiento (MM/dd/yyyy)");
		String naciminetobob=scan.nextLine();
		System.out.println("Indica su direccion:");
		String direcionbob=scan.nextLine();
		System.out.println("Indica su telefono:");
		String telefonobob=scan.nextLine();
		
		//buscando el servicio
		System.out.println("Indica el identificador del servicio:");
		int ids=scan.nextInt();
		scan.hasNextLine();
		
		
		
		Servicio ser=entitymanager.find(Servicio.class, ids);
		//creando el equipo pk para añadir el bombero al equipo(hay que tener en cuenta que la tabla equipo tiene doble clave primaria "PK")
		EquipoPK epk= new EquipoPK(ids,id);
		//creamos el constructor del equipo
		Equipo e= new Equipo();
		//creamos un list de equipos y lo igualamos a un arraylist vacio
		List<Equipo> le = new ArrayList();
		//añadimos al array list el equipo eh
		le.add(e);
		//buscamos el parque de bomberos mediante la siguiente consulta
		Parque park=entitymanager.find(Parque.class, idpark);
		//creamos el constructor de bombero y lo llenamos mediantes sets
		Bombero bob= new Bombero();
		bob.setId(id);
		bob.setApellidos(apellidosbob);
		bob.setDireccion(direcionbob);
		bob.setDni(dnibob);
		//aqui cambiamos la variable String nacimientobo a date.
		bob.setFechaNacimiento(new SimpleDateFormat("MM/dd/yyyy").parse(naciminetobob));
		bob.setEquipos(le);
		bob.setNombre(nombrebob);
		bob.setTelefono(telefonobob);
		//añadimos directamente el constructor park(nombre del constructor parque),dado a que bob.setParque() nos pide un objeto, y park es ese objeto
		bob.setParque(park);
		System.out.println();
		//añadimos a equipos el bombero, al ser un objeto pasamos el nombre del constructor,este contiene todos los campos introducidos en bob.
		e.setBombero(bob);
		//pasa lo mismo con servicio,introducimos el nombre del constructor "ser" ,que contiene  la informacion insertada en servicios
		e.setServicio(ser);
		//Introducimos el puesto que tendra el bombero,este puede ser una variable de tipo String, o un texto directamente, como se muestra en el ejemplo.
		
		e.setPuesto("tasbobo?");
		System.out.println(bob.toString());

		entitymanager.persist(e);
		entitymanager.persist(bob);
		entitymanager.getTransaction( ).commit();
	    entitymanager.close();
	    emfactory.close();
	}
	public static void RegCoche() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Examen_JPA_1");																								// configuracion)
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		System.out.println("Indica el identificador del vehiculo:");
		int id=scan.nextInt();
		scan.nextLine();
		System.out.println("Indica a que parque ira destinado:");
		int parque=scan.nextInt();
		scan.nextLine();
		Parque park=entitymanager.find(Parque.class, parque);
		System.out.println("Indica la marca  del vehiculo:");
		String marca=scan.nextLine();
		System.out.println("Indica el modelo del vehiculo:");
		String model=scan.nextLine();
		System.out.println("Indica la matricula");
		String matricula=scan.nextLine();
		Date date = new Date();
	      Date any= new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			 any.setYear(date.getYear()+5);
		Coche c= new Coche(id,date,any,marca,matricula,model,park);
		entitymanager.persist(c);
		entitymanager.getTransaction( ).commit();
	    entitymanager.close();
	    emfactory.close();
	}
	public static void RegService() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Examen_JPA_1");																								// configuracion)
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		System.out.println("Indica el identificador del servicio:");
		int id=scan.nextInt();
		scan.hasNextLine();
		System.out.println("Indica el parque encargado:");
		int parque=scan.nextInt();
		scan.nextLine();
		Parque park= entitymanager.find(Parque.class, parque);
		Date date = new Date();
		SimpleDateFormat formatterdia = new SimpleDateFormat("dd-MM-yyyy");
		 Time hora = Time.valueOf(LocalTime.now());
		 System.out.println(hora);
		System.out.println("Tipo de servicio:");
		String servicio=scan.nextLine();
		System.out.println("Tipo de urgencia(1 sindo la mayor y 9 la menor)");
		int urgencia=scan.nextInt();
		scan.nextLine();
		System.out.println(hora);
		Servicio serv= new Servicio(id,date,hora,servicio,urgencia,park);
		entitymanager.persist(serv);

		entitymanager.getTransaction( ).commit();
	    entitymanager.close();
	    emfactory.close();
	}
	

}
