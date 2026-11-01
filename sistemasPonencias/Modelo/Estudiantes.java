package Modelo;


/**
 * Write a description of class Estudiantes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Estudiantes extends Persona
{  private String grado;
   private Semillero semillero;
    public Estudiantes() {
    }

    public Estudiantes(String grado,Semillero semillero) {
        this.grado = grado;
        this.semillero = semillero;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }
    
    public Semillero getSemillero() {
        return semillero;
    }

    public void setSemillero(Semillero semillero) {
        this.semillero = semillero;
    }

    @Override
    public String toString() {
        return "Estudiantes de" + "nombre=" + nombre + ", cedula=" + cedula + ", correo=" + correo + ", institucion=" + institucion + "de grado: "+grado;
    }
}