package Modelo;
import java.util.*;

/**
 * Write a description of class Docente here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Docente extends Persona
{
    private String institucion;
    private String nivel;
    private ArrayList<ServicioInternet> servicio= new ArrayList<>();
    private ArrayList<ImplementosTecnologicos> tecno= new ArrayList<>();

    public Docente() {
    }

    public Docente(String tipoDocumento, String documento, String nombre, String apellido, String direccion, String telefono, int edad, String estrato, String estadoCivil, boolean cabezaHogar, String institucion, String nivel) {
    super(tipoDocumento, documento, nombre, apellido, direccion, telefono, edad, estrato, estadoCivil, cabezaHogar, null);
    this.institucion = institucion;
    this.nivel = nivel;
}

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public ArrayList<ServicioInternet> getServicio() {
        return servicio;
    }

    public void setServicio(ArrayList<ServicioInternet> servicio) {
        this.servicio = servicio;
    }

    public ArrayList<ImplementosTecnologicos> getTecno() {
        return tecno;
    }

    public void setTecno(ArrayList<ImplementosTecnologicos> tecno) {
        this.tecno = tecno;
    }

    @Override
    public String toString() {
        return "Docente{" + "institucion=" + institucion + ", nivelEducativo=" + nivel + ", servicio=" + servicio + ", tecno=" + tecno + '}';
    }
            @Override
public Bono getBonoPorPersona() {
    int montoTotal= 0;
    for(ServicioInternet s: servicio){
        montoTotal +=s.getValor();
    }
    
    for(ImplementosTecnologicos t: tecno){
        montoTotal +=t.getValor();
    }
    
    int montoMaximo= 100000;
    if(montoTotal>montoMaximo){
        return null;
    }
    
    return new Bono(montoTotal);
}
    
    
}