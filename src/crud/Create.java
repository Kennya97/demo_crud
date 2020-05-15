
package crud;

/**
 *
 * @author castr
 */
import java.sql.SQLException;
import java.util.Scanner;

public class Create {
   
Create() throws SQLException {

Scanner leer= new Scanner(System.in);
student es = new student ();

System.out.println("==  CREAR REGISTRO ==");

System.out.println("Carnet: ");
es.setCarnet(leer.next());

System.out.println("Nombre:  ");
es.setNombre(leer.next());

System.out.println("Apellido: ");
es.setApellido(leer.next());

System.out.println("Edad");
es.setEdad(leer.next());

String tabla = "tb_estudiante";
String campos_Tabla = "carnet_estudiante, nom_estudiante, ape_estudiante, edad_Estudiante";

String valores_campos = "'"+es.getCarnet() + " ',' " +es.getNombre()+ " ',' " +
es.getApellido()+ " ', ' " +es.getEdad()+ " ' ";//esta linea es continua a la anterior

//instancia u objeto de la clase mi_conexion_CRUD
mi_conexion_CRUD batallando = new mi_conexion_CRUD();

//se envian los parametros necesarios para guardar el registro al metodo guardar_registro
batallando.guardar_registros(tabla, campos_Tabla, valores_campos);

menu_principal.desplegar_Menu(); //llama el metodo del menu principal
}
}

