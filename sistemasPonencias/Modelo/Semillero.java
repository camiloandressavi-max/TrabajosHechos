package Modelo;

import java.util.*;
/**
 * Write a description of class Semillero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Semillero
{
    private ArrayList<Estudiantes> estudiante = new ArrayList<>(); 
    private ArrayList<Estudiantes> ponente = new ArrayList<>();
    
    public Semillero() {
    }

    public ArrayList<Estudiantes> getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(ArrayList<Estudiantes> estudiante) {
        this.estudiante = estudiante;
    }

    public ArrayList<Estudiantes> getPonente() {
        return ponente;
    }

    public void setPonente(ArrayList<Estudiantes> ponente) {
        this.ponente = ponente;
    }
    
    @Override
    public String toString() {
        return "Semillero{" + "estudiante=" + estudiante.toString() + ", ponente=" + ponente.toString() + '}';
    }
}