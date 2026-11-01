package Modelo;

import java.util.*;
/**
 * Write a description of class GrupoDeInvestigacion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GrupoDeInvestigacion
{
    private LineaDeInvestigacion investigacion;
    private String nombre;
    private Clasificacion clasificacion;
    private Profesor director;
    private ArrayList<Profesor> integrantes= new ArrayList <>();;
    private ArrayList<Estudiantes> estudiantes = new ArrayList<>();
    
    public GrupoDeInvestigacion() {
    }

    public GrupoDeInvestigacion(LineaDeInvestigacion investigacion, String nombre, Clasificacion clasificacion, Profesor director) {
        this.investigacion = investigacion;
        this.nombre = nombre;
        this.clasificacion = clasificacion;
        this.director = director;
    }

    public LineaDeInvestigacion getInvestigacion() {
        return investigacion;
    }

    public void setInvestigacion(LineaDeInvestigacion investigacion) {
        this.investigacion = investigacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Clasificacion getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(Clasificacion clasificacion) {
        this.clasificacion = clasificacion;
    }

    public Profesor getDirector() {
        return director;
    }

    public void setDirector(Profesor director) {
        this.director = director;
    }

    public ArrayList<Profesor> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(ArrayList<Profesor> integrantes) {
        this.integrantes = integrantes;
    }

    public ArrayList<Estudiantes> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiantes> estudiantes) {
        this.estudiantes = estudiantes;
    }

    @Override
    public String toString() {
        return "GrupoDeInvestigacion{" + "investigacion=" + investigacion + ", nombre=" + nombre + ", clasificacion=" + clasificacion + ", director=" + director + ", integrantes=" + integrantes + ", estudiantes=" + estudiantes + '}';
    }
            
            
}