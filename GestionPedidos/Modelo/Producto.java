package Modelo;


/**
 * Write a description of class Prodcuto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Producto
{
    
private String codigo;
    private String nombreProducto;
    private double precio;
    
    public Producto(String codigo, String nombreProducto, double precio) {
    this.codigo = codigo;
    this.nombreProducto = nombreProducto;
    this.precio = precio;
}
    public String getCodigo(){
        return codigo;
    }
    
    public void setCodigo (String codigo){
        this.codigo= codigo;
    }
    
    public String getNombreProducto(){
        return nombreProducto;
    }
    
    public void setNombreProducto (String nombreProducto){
        this.nombreProducto= nombreProducto;
    }
    
    public double getPrecio(){
        return precio;
    }
    
    public void setDouble (Double precio){
        this.precio= precio;
    }
    
}