package Modelo;
import java.util.*;


/**
 * Write a description of class ProfesionalSalud here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ProfesionalSalud extends Persona
{
    private String institucion;
    private String especialidad;
    private ArrayList<Medicina> medicina = new ArrayList<>();
    private ArrayList<ElementoBioseguridad> bioseguridad = new ArrayList<>();

    public ProfesionalSalud(String tipoDocumento, String documento, String nombre, String apellido, String direccion, String telefono, int edad, String estrato, String estadoCivil, boolean cabezaHogar, String institucion, String especialidad, Bono bono) {
        super(tipoDocumento, documento, nombre, apellido, direccion, telefono, edad, estrato, estadoCivil, cabezaHogar, bono);
        this.institucion = institucion;
        this.especialidad = especialidad;
        this.medicina=medicina;
        this.bioseguridad=bioseguridad;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public ArrayList<Medicina> getMedicina() {
        return medicina;
    }

    public void setMedicina(ArrayList<Medicina> medicina) {
        this.medicina = medicina;
    }

    public ArrayList<ElementoBioseguridad> getBioseguridad() {
        return bioseguridad;
    }

    public void setBioseguridad(ArrayList<ElementoBioseguridad> bioseguridad) {
        this.bioseguridad = bioseguridad;
    }

    @Override
    public String toString() {
        return "ProfesionalSalud{" + "institucion=" + institucion + ", especialidad=" + especialidad + ", medicina=" + medicina + ", bioseguridad=" + bioseguridad + '}';
    }
    
            @Override
public Bono getBonoPorPersona() {
    int montoTotal= 0;
    for(Medicina m: medicina){
        montoTotal +=m.getValor();
    }
    
    for(ElementoBioseguridad b: bioseguridad){
        montoTotal +=b.getValor();
    }
    
    int montoMaximo= 350000;
    if(montoTotal>montoMaximo){
        return null;
    }
    
    return new Bono(montoTotal);
}
}
