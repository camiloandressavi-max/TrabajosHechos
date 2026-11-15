package Modelo;


/**
 * Write a description of class Pedido here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pedido
{
    private String numero;
    
    public Pedido(String numero){
        this.numero= numero;
    }
    
    public String getNumero(){
        return numero;
    }
    
    public void setNumero(String numero){
        this.numero= numero;
    }
}