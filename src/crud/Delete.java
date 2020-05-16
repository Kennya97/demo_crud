
package crud;

/**
 *
 * @author castr
 */

import java.sql.SQLException;
import java.util.Scanner;

public class Delete {
Delete() throws SQLException{
   
Scanner  leer = new Scanner (System.in);
mi_conexion_CRUD batallando = new mi_conexion_CRUD ();

System.out.println("<< ==ELIMINAR  REGISTRO== >>");

System.out.println("Ingresar el  Id del registro: ");
String id_contacto_eliminar= leer.next();

//REINGRESO DE DATOS PARA ACTUALIZAR 

String tabla = "tb_estudiante";
String campos = "*";
String condicion = "id_estudiante  = "+id_contacto_eliminar;

batallando.desplegar_registros(tabla, campos, condicion);

System.out.println("Presionar <<X>> para confirmar");
String confirmar_borrar = leer.next();

if ("X".equals(confirmar_borrar)){
/* SE LE DEJA VACIO PARA EL METODO ACTUALIZAR  ELIMINAR REGISTRO
 ENVIE SOLAMENTE LOS PARAMETROS DE TABLA  Y   CONDICION Y PODER ELIMINAR */

String valores_campos_nuevos = "";

batallando.actualizar_eliminar_registro(tabla, valores_campos_nuevos, condicion);
System.out.println("Registro borrado");        

}
menu_principal.desplegar_Menu(); //LLAMA EL METODO DEL MENU PRINCIPAL
}  
}
