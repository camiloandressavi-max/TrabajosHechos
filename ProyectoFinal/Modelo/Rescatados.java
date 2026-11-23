package Modelo;


/**
 * Write a description of class Afectados here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rescatados
{
    private int noAfectados;
    private int damnificados;
    private int muertos;

    public Rescatados(int noAfectados, int damnificados, int muertos) {
        this.noAfectados = noAfectados;
        this.damnificados = damnificados;
        this.muertos = muertos;
    }

    public int getNoAfectados() {
        return noAfectados;
    }

    public void setNoAfectados(int noAfectados) {
        this.noAfectados = noAfectados;
    }

    public int getDamnificados() {
        return damnificados;
    }

    public void setDamnificados(int damnificados) {
        this.damnificados = damnificados;
    }

    public int getMuertos() {
        return muertos;
    }

    public void setMuertos(int muertos) {
        this.muertos = muertos;
    }

    public int total() {
        return noAfectados + damnificados;
    }
    

    @Override
    public String toString() {
        return "No Afectados: " + noAfectados + 
               ", Damnificados: " + damnificados + 
               ", Muertos: " + muertos + 
               ", Total Rescatados: " + total()
               ;
    }
}
