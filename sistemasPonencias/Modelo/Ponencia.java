package Modelo;


/**
 * Write a description of class Ponencia here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Ponencia
{
    protected String nombre;
    
    public Ponencia(String nombre){
        this.nombre=nombre;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    @Override
    public String toString() {
        return "Ponencia{" + "nombre=" + nombre + '}';
    }
}