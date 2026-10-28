package Modelo;

import java.util.*;
/**
 * Write a description of class Ciudadano here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ciudadano extends Persona
{
    
    private ArrayList<Medicina> medicina= new ArrayList<>();
    private ArrayList<ProductosCanasta> productos= new ArrayList<>();
    
    

    public Ciudadano() {
    }

    public Ciudadano(String tipoDocumento, String documento, String nombre, String apellido, String direccion, String telefono, int edad, String estrato, String estadoCivil, boolean cabeza, Bono bono) {
        super(tipoDocumento, documento, nombre, apellido, direccion, telefono, edad, estrato, estadoCivil, cabeza, bono);
    }
    
    public ArrayList<Medicina> getMedicina() {
    return medicina;
}

   public ArrayList<ProductosCanasta> getProductos() {
    return productos;
    
}


    @Override
    public String toString() {  
        return "Ciudadano{" + "medicina=" + medicina + ", productos=" + productos + '}';
        

    }
    
    
        @Override
public Bono getBonoPorPersona() {
    int montoTotal= 0;
    for(Medicina m: medicina){
        montoTotal +=m.getValor();
    }
    
    for(ProductosCanasta p: productos){
        montoTotal +=p.getValor();
    }
    
    int montoMaximo= 160000;
    if(montoTotal>montoMaximo){
        return null;
    }
    
    
    return new Bono(montoTotal);
}
}
