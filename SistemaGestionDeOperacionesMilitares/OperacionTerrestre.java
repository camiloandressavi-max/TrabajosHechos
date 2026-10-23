
/**
 * Write a description of class OperacionTerrestre here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OperacionTerrestre extends OperacionesMilitares
{
    private String tipoTerreno;
    private int cantidadVehiculos;

    

    public OperacionTerrestre(String tipoTerreno, int cantidadVehiculos, String codigo, String nombreDeLaOperacion, String zona, String Fecha, int numeroDeEfectivos, Estado estado) {
        super(codigo, nombreDeLaOperacion, zona, Fecha, numeroDeEfectivos, estado);
        this.tipoTerreno = tipoTerreno;
        this.cantidadVehiculos = cantidadVehiculos;
    }

    public String getTipoTerreno() {
        return tipoTerreno;
    }

    public void setTipoTerreno(String tipoTerreno) {
        this.tipoTerreno = tipoTerreno;
    }

    public int getCantidadVehiculos() {
        return cantidadVehiculos;
    }

    public void setCantidadVehiculos(int cantidadVehiculos) {
        this.cantidadVehiculos = cantidadVehiculos;
    }
    
    @Override
    public  int calcularComplejidad(){
        int cantidadVehiculos= getCantidadVehiculos();
        int numeroDeEfectivos= getNumeroDeEfectivos();
        
        int complejidad= numeroDeEfectivos +(cantidadVehiculos * 5);
        return complejidad;
        
    }
    
    @Override
    public String toString() {
        return "OperacionTerrestre{" + "tipoTerreno=" + tipoTerreno + ", cantidadVehiculos=" + cantidadVehiculos + '}';
    }
    
}