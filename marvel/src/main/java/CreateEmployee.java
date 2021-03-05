
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class CreateEmployee 
{
   public static void main( String[ ] args ) 
   {
      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "JPA_employee" );//llama al persistence.xml(tiene la conexion y configuracion)
      
      EntityManager entitymanager = emfactory.createEntityManager( );//similar al statement.
      entitymanager.getTransaction( ).begin( );
/*
 * INSERTAR EMPLEADO
      Employee employee = new Employee(); 
      //employee.setEid(employee.getEid());
      employee.setEname( "Gopal" );
      employee.setSalary( 40000 );
      employee.setDeg( "Technical Manager" );
      */
      //actualizar
      /*
      Employee emp = entitymanager.find(Employee.class, 1); //consulta para buscar el objeto a actualizar.
      //cambias los valores del atributo con id 1
      emp.setEname("Feferico");
      emp.setSalary(12000);
      emp.setDeg("100TIFICO");*/
      
      //borrar
      /*
      Employee emp = entitymanager.find(Employee.class, 1); //consulta para buscar el objeto a actualizar.
      entitymanager.remove(emp);//borras el objeto con id 1
      */
      
      //entitymanager.persist( employee );solo para insertar
      entitymanager.getTransaction( ).commit();//realiza los camondos

      entitymanager.close( );//cierras el statement
      emfactory.close( );//cierra conexion
   }
}