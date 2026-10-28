package Modelo;


/**
 * Write a description of class OperacionAerea here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OperacionAerea extends OperacionesMilitares
{
    private int numeroAeronaves, horasEstimadas;
    
    public OperacionAerea(int numeroAeronaves, int horasEstimadas, String codigo, String nombreDeLaOperacion, String zona, String Fecha, int numeroDeEfectivos, Estado estado) {
        super(codigo, nombreDeLaOperacion, zona, Fecha, numeroDeEfectivos, estado);
        this.numeroAeronaves = numeroAeronaves;
        this.horasEstimadas = horasEstimadas;
    }

    public int getNumeroAeronaves() {
        return numeroAeronaves;
    }

    public void setNumeroAeronaves(int numeroAeronaves) {
        this.numeroAeronaves = numeroAeronaves;
    }

    public int getHorasEstimadas() {
        return horasEstimadas;
    }

    public void setHorasEstimadas(int horasEstimadas) {
        this.horasEstimadas = horasEstimadas;
    }
    @Override
    public  int calcularComplejidad(){
        int numeroAeronaves= getNumeroAeronaves();
        int numeroDeEfectivos= getNumeroDeEfectivos();
        int horasEstimadas= getHorasEstimadas();
        
        int complejidad= numeroDeEfectivos +(numeroAeronaves * 10)+ horasEstimadas ;
        return complejidad;
        
    }
    
    @Override
    public String toString() {
        return "OperacionAerea{" + "numeroAeronaves=" + numeroAeronaves + ", horasEstimadas=" + horasEstimadas + '}';
    }
    
}