
package crud;

/**
 *
 * @author W. Hernandez
 */
public class student {
    
    //Atributos de la clase
    private int id_student;
    private String carnet;
    private String nombre;
    private String apellido;
    private String edad;

    //Metodos getter y setter
    public int getId_student() {
        return id_student;
    }
    //set estudiante con el id_student(julissa)..
    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
    
    
  
}
