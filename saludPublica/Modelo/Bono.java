package Modelo;


/**
 * Write a description of class Bono here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bono
{
    private int monto;
    
    public Bono(){
        
    }
    
    public Bono(int monto){
        this.monto=monto;
    }
    
    public int getMonto(){
        return monto;
        
    }
    
    public void setMonto(int monto){
        this.monto=monto;
    }
    
    @Override
    public String toString() {
        return "Bono{" + "monto=" + monto + '}';
    }
}