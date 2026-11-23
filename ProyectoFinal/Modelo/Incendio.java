package Modelo;


/**
 * Write a description of class Incendio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Incendio
{
    private String codigo;
    
    public Incendio(){
        
    }
    
    public Incendio (String codigo){
        this.codigo= codigo;
    }
    
    public String getCodigo(){
        return codigo;
    }
    
    public void getCodigo(String codigo){
        this.codigo= codigo;
    }
    
     @Override
public String toString() {
    return codigo;
}
   
    
}