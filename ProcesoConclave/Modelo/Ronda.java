package Modelo;

import java.util.ArrayList;

public class Ronda {
    private String jornada;
    private int numero;
    private Fecha fecha;
    private ArrayList<Voto> voto;

    public Ronda() {
        this.voto = new ArrayList<>();
    }

    public Ronda(String jornada, int numero, Fecha fecha) {
        this.jornada = jornada;
        this.numero = numero;
        this.fecha = fecha;
        this.voto = new ArrayList<>();
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public ArrayList<Voto> getVoto() {
        return voto;
    }

    public void setVoto(ArrayList<Voto> voto) {
        this.voto = voto;
    }
}