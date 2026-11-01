package Modelo;

import java.util.*;
/**
 * Write a description of class Profesor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Profesor extends Persona
{
    private String materia;
    private Categoria categoria;
    private ArrayList<GrupoDeInvestigacion> grupos= new ArrayList<>();
    
    public Profesor() {
    }

    public Profesor(String materia, Categoria categoria) {
        this.materia = materia;
        this.categoria = categoria;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public ArrayList<GrupoDeInvestigacion> getGrupos() {
        return grupos;
    }

    public void setGrupos(ArrayList<GrupoDeInvestigacion> grupos) {
        this.grupos = grupos;
    }

    @Override
    public String toString() {
        return "Profesor de" + "nombre=" + nombre + ", cedula=" + cedula + ", correo=" + correo + ", institucion=" + institucion + "materia=" + materia + ", categoria=" + categoria + ", grupos=" + grupos + '}';
    }

}