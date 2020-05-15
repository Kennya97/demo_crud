
package crud;

/**
 *
 * @author castr
 */


import java.sql.*; //LIBRERIAS PARA LA CONEXION A LA BASE DE DATOS

public class mi_conexion_CRUD {


//Ruta de la base de datos el servidor 127.0.0.1 el puerto 33036  y el nombre
//de la base de datos bd_mi_tarea
private final String servidor = "jdbc:mysql://127.0.0.1:3306/bd_mi_tarea";

//Nomb re del usuario (root por defecto)de la base de datos
private final String usuario = "root";

//clave del usuario de la base de datos
private final String clave = "";

//libreria de mysql
private final String driverConector = "com.mysql.jdbc.Driver";

//Objeto de la clase Connection del paquete java. sql
private static Connection conexion;


public mi_conexion_CRUD(){
try{

Class.forName(driverConector); //   LEVANTA EL DRIVER

//ESTABLECER CONEXION

conexion = DriverManager.getConnection(servidor, usuario, clave);

}catch (ClassNotFoundException | SQLException e) {
System.out.println("Conexion fallida !Error!  : "+e.getMessage());
}
}

}


