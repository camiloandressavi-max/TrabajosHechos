package Modelo;

import java.util.ArrayList;
/**
 * Write a description of class MunicipiosAfectados here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MunicipiosAfectados
{
    private String nombreMunicipio;
    private int poblacion;
    private NivelDeAlerta nivelAlerta; 
    private ArrayList<Incendio> incendios= new ArrayList<>();
    public MunicipiosAfectados(String nombreMunicipio, int poblacion, NivelDeAlerta nivelAlerta) {
        this.nombreMunicipio = nombreMunicipio;
        this.poblacion = poblacion;
        this.nivelAlerta = nivelAlerta;
    }

        public String getNombreMunicipio() {
        return nombreMunicipio;
    }

    public void setNombreMunicipio(String nombreMunicipio) {
        this.nombreMunicipio = nombreMunicipio;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    public NivelDeAlerta getNivelAlerta() {
        return nivelAlerta;
    }

    public void setNivelAlerta(NivelDeAlerta nivelAlerta) {
        this.nivelAlerta = nivelAlerta;
    }
    
        public ArrayList<Incendio> getIncendios() {
    return incendios;
    }

    public void setIncendios(ArrayList<Incendio> incendios) {
    this.incendios = incendios;
    }    
    
    

    @Override
public String toString() {
    return nombreMunicipio;
}
    
}