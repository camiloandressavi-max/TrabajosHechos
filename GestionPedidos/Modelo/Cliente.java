package Modelo;


/**
 * Write a description of class Cliente here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cliente
{
    private String cedula;
    private String nombreCliente;
    
    public Cliente(String cedula, String nombreCliente){
        this. cedula= cedula;
        this.nombreCliente= nombreCliente;
    }
    
    public String getCedula(){
        return cedula;
    }
    
    public void setCedula(String Cedula){
        this.cedula= cedula;
    }
    
    public String getNombreCliente(){
        return nombreCliente;
    }
    
    public void setNombre(String nombreCliente){
        this.nombreCliente= nombreCliente;
    }
    
}