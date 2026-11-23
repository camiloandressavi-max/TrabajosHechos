package Modelo;


/**
 * Write a description of class Persona here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Persona
{
    private String cedula;
    private String nombre;
    private int edad;

    public Persona(String cedula, String nombre, int edad) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getCedula() {
        return cedula;
    }
            
    public void setCedula(String cedula){
        this.cedula=cedula;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public int getEdad() { 
        return edad;
    }
    
    public void setEdad(int edad){
        this.edad=edad;
    }

    @Override
    public String toString() {
        return "Cédula: " + cedula + ", Nombre: " + nombre + ", Edad: " + edad;
    }
}