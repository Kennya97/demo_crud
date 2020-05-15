
package crud;

//borre comentarios en ingles "julissa salinas" mi tercer cambio
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

//SEGUNDA PARTE DE CODIGO AGREGADA POR KENNYA

public Connection getConnection(){
return conexion; //DEVUELVE EL OBJETO CONEXION
}

public void guardar_registros(String tabla , String campos_tabla, String valores_campos){
//CARGAR LA CONEXION
    
mi_conexion_CRUD  conectar = new mi_conexion_CRUD();
Connection cone = conectar.getConnection();

try{
//DEFINIR LA SENTENCIA SQL
String  sqlQueryStmt = "INSERT  INTO " + tabla + "("+campos_tabla+" )  VALUES  (" +valores_campos+");";

//ESTABLECEMOS LA COMUNICACION ENTRE NUESTRA APLICACION  JAVA Y LA BASE DE DATO
Statement  stmt ; //Envia sentencia sql a la base de datos 

stmt = cone.createStatement();

stmt.executeUpdate(sqlQueryStmt);//Ejecutar la sentencia sql

//CERRAR EL STATEMENT Y LA CONEXION SE CIERRAN EN ORDEN INVERSO DE COMO SE HAN ABIERTO 
stmt.close();
cone.close();

System.out.println("Registro guardado correctamente!!");

}catch(Exception e ){
System.out.println(e.getMessage());
}
}

public void actualizar_eliminar_registro(String tabla, String valores_campos_nuevos, String condicion ){

//CARGAR LA CONEXION
mi_conexion_CRUD  conectar = new mi_conexion_CRUD();
Connection cone = conectar.getConnection();

try{
Statement stmt;
String sqlQueryStmt;

//VERIFICAR QUE VALORES CAMPOS_NUEVOS VENGA VACIA Y ASI SELECCIONAR SI ES BORRAR O ACTUALIZAR REGISTROS
if (valores_campos_nuevos.isEmpty()){
sqlQueryStmt = " DELETE  FROM "+ tabla + " WHERE " +  condicion + ";";

}else {
sqlQueryStmt = " UPDATE " + tabla + " SET "+valores_campos_nuevos +"  WHERE   "+condicion +";";
}
stmt = cone.createStatement();
stmt.executeUpdate(sqlQueryStmt);
stmt.close();
cone.close();
        
}catch(SQLException ex){

System.out.println(""+ex.getMessage());
}
}

public void desplegar_registros (String  tabla_buscar, String campos_buscar, String condicion_buscar) throws SQLException{

//CARGAR LA CONEXION
mi_conexion_CRUD  conectar = new mi_conexion_CRUD();
Connection cone = conectar.getConnection();

try{
Statement stmt;

String sqlQueryStmt;

if (condicion_buscar.equals("") ){
    
sqlQueryStmt = " SELECT " + campos_buscar+"  FROM  "+ tabla_buscar+";";
  
}else {
sqlQueryStmt = " SELECT " + campos_buscar + " FROM  " + tabla_buscar + " WHERE " + condicion_buscar;
        
}
stmt = cone.createStatement();

stmt.executeQuery(sqlQueryStmt);
//LE INDICAMOS QUE EJECUTE  LA CONSULTA DE LA TABLA Y LE PASAMOS POR ARGUMENTOS NUESTRAS SENTENCIAS

try (ResultSet miResultSet= stmt.executeQuery(sqlQueryStmt)){

if (miResultSet.next () ){//UBICA EL CURSOR EN LA PRIMERA FILA DE LA TABLA DE RESULTADO

ResultSetMetaData metaData = miResultSet.getMetaData();
int num_Columnas = metaData.getColumnCount();//OBTIENE EL NUMERO DE COLUMNAS DE LA CONSULTA

System.out.println("<<REGISTROS ALMACENADOS>>");
System.out.println("");

for (int i = 1; i <= num_Columnas; i++){

//MUESTRA LOS TITULOS DE LAS COLUMNAS Y %-20s\t INDICA LA SEPARACION ENTRE COLUMNAS
System.out.printf("%-20s\t", metaData.getColumnName(i));

}
System.out.println();

do{
for (int i = 1; i<= num_Columnas; i++){
System.out.printf("%-20s\t" , miResultSet.getObject(i));
}
System.out.println();

}while(miResultSet.next());

System.out.println();

}else{
//hice este cambio-julissa
System.out.println("El Registro no existe  ");
}
//Aqui AGREGUE ESTA PARTE

miResultSet.close();//CERRAR EL RESULTSET
}finally{
stmt.close();
cone.close();
}

}catch(SQLException ex){
System.out.println("Ha ocurrido el siguiente error !! : "+ex.getMessage());
}
}
}


