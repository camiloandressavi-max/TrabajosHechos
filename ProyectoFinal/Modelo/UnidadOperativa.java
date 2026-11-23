package Modelo;


/**
 * Write a description of class UnidadOperativa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class UnidadOperativa
{
    protected String codigo; 
    
    public UnidadOperativa(){
        
    }
    public UnidadOperativa(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}