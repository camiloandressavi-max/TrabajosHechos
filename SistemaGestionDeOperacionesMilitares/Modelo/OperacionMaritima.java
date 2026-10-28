package Modelo;


/**
 * Write a description of class OperacionMaritima here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OperacionMaritima extends OperacionesMilitares
{
    private int cantidadEmbarcaciones;
    private String areaMaritima;
    

    public OperacionMaritima(int cantidadEmbarcaciones, String areaMaritima, String codigo, String nombreDeLaOperacion, String zona, String Fecha, int numeroDeEfectivos, Estado estado) {
        super(codigo, nombreDeLaOperacion, zona, Fecha, numeroDeEfectivos, estado);
        this.cantidadEmbarcaciones = cantidadEmbarcaciones;
        this.areaMaritima = areaMaritima;
    }

    public int getCantidadEmbarcaciones() {
        return cantidadEmbarcaciones;
    }

    public void setCantidadEmbarcaciones(int cantidadEmbarcaciones) {
        this.cantidadEmbarcaciones = cantidadEmbarcaciones;
    }

    public String getAreaMaritima() {
        return areaMaritima;
    }

    public void setAreaMaritima(String areaMaritima) {
        this.areaMaritima = areaMaritima;
    }
    
    @Override
    public  int calcularComplejidad(){
        int numeroDeEfectivos= getNumeroDeEfectivos();
        int cantidadEmbarcaciones= getCantidadEmbarcaciones();
        
        int complejidad= numeroDeEfectivos +(cantidadEmbarcaciones * 8) ;
        return complejidad;
        
    }
    
    @Override
    public String toString() {
        return "OperacionMaritima{" + "cantidadEmbarcaciones=" + cantidadEmbarcaciones + ", areaMaritima=" + areaMaritima + '}';
    }
    
}