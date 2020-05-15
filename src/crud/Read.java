
package crud;

/**
 *
 * @author castr
 */

import java.sql.SQLException;

public class Read {
public Read () throws SQLException {

System.out.println("<==  CONSULTA  DE  REGISTRO ==>");  

mostrar_resultados(); //LLAMA EL METODO  DENTRO DE ESTA CLASE 
}    
private void mostrar_resultados() throws SQLException {
try{
mi_conexion_CRUD batallando= new mi_conexion_CRUD();

String tabla = " tb_estudiante ";

String campos_tabla = "*";

//CONDICION SE ENVIA VACIA PARA INDICAR QUE TODOS LOS REGISTROS SE NECESITAN MOSTRAR

String condicion_Busqueda = "";

//METODO QUE REALIZA LA BUSQUEDA 

batallando.desplegar_registros(tabla, campos_tabla, condicion_Busqueda);

}catch (SQLException ex){
System.out.println("Ha ocurrido un error!!! Error "+ex.getMessage());
}finally{
    
menu_principal.desplegar_Menu();
}
}
}
