package Modelo;


/**
 * Write a description of class PonenciaPoster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PonenciaPoster extends Ponencia
{
    public PonenciaPoster(String nombre) {
        super(nombre);
    }
    
    @Override
    public String toString() {
        return "PonenciaPoster de nombre: " +nombre;
    }
}