
package crud;

//Este es mi prime comentario
//se importan las extenciones para que no muestre error al solicitardatos y leerlos

import java.sql.SQLException;
import java.util.Scanner;

public class Update {
    //yo borre lo que seria esta parte.. un comentario que estaba en ingles.-julissa
 Update() throws SQLException {
    //este es mi segundo cambio
     //Scanner se utiliza para solicicitar datos con objeto leer
Scanner  leer = new Scanner (System.in);
student est = new student ();
mi_conexion_CRUD batallando = new mi_conexion_CRUD ();

System.out.println("<<ACTUALIZAR REGISTROS >>");

System.out.println("Ingresa id del registro a modificar: ");
est.setId_student(leer.nextInt());

//yo borre lo que estaba aqui 
//ingree los datos "julissa salinas"

String  tabla_buscar = "tb_estudiante";

String campos_buscar = "id_estudiante,  carnet_estudiante,    nom_estudiante,  ape_estudiante,  edad_estudiante";

String  condicion_buscar = "id_estudiante = "+est.getId_student();

batallando.desplegar_registros(tabla_buscar, campos_buscar, condicion_buscar);

System.out.println("Carnet: ");
est.setCarnet(leer.next());

System.out.println("Nombre: ");
est.setNombre(leer.next());

System.out.println("Apellido: ");
est.setApellido(leer.next());

System.out.println("Edad: ");
est.setEdad(leer.next());

String tabla = "tb_estudiante";

String campos_valores_nuevos = "nom_estudiante = ' "+ est.getNombre() + "',carnet_estudiante ='"+ est.getCarnet() +
"', ape_estudiante = ' " +est.getApellido() + " ' , edad_estudiante = ' "+ est.getEdad() +"'"; //CONTINUACION DE LA FILA ANTERIOR

batallando.actualizar_eliminar_registro(tabla, campos_valores_nuevos, condicion_buscar);
System.out.println("Modificado Correctamente !!!!!!!!");

menu_principal.desplegar_Menu();//LLAMA EL METODO DEL MENU PRINCIPAL
        
}
}

