package Modelo;

/**
 * Write a description of class LineaDeInvestigacion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LineaDeInvestigacion
{
        private Ponencia ponencia;

    public LineaDeInvestigacion() {
    }

    public LineaDeInvestigacion(Ponencia ponencia) {
        this.ponencia = ponencia;
    }

    public Ponencia getPonencia() {
        return ponencia;
    }

    public void setPonencia(Ponencia ponencia) {
        this.ponencia = ponencia;
    }
}