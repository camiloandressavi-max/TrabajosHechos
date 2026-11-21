package Modelo;


/**
 * Write a description of class Voto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Voto
{
    private Cardenal elector;
    private Cardenal candidato;
    
    public Voto() {
    }

    public Voto(Cardenal elector, Cardenal candidato) {
        this.elector = elector;
        this.candidato = candidato;
    }

    public Cardenal getElector() {
        return elector;
    }

    public void setElector(Cardenal elector) {
        this.elector = elector;
    }

    public Cardenal getCandidato() {
        return candidato;
    }

    public void setCandidato(Cardenal candidato) {
        this.candidato = candidato;
    }

    
}
