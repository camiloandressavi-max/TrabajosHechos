package Modelo;


/**
 * Write a description of class Persona here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Persona
{
    protected String nombre,cedula,correo, institucion;
    
    public Persona() {
    }

    public Persona(String nombre, String cedula, String correo, String institucion) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.institucion = institucion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", cedula=" + cedula + ", correo=" + correo + ", institucion=" + institucion + '}';
    }
    
    
}