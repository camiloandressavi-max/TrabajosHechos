package Modelo;


/**
 * Write a description of class PonenciaOral here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PonenciaOral extends Ponencia
{
    public PonenciaOral(String nombre) {
        super(nombre);
    } 
    @Override
    public String toString() {
        return "PonenciaOral de nombre" +nombre;
    }
}