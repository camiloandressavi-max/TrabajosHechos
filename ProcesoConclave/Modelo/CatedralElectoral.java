package Modelo;

import java.util.ArrayList;

public class CatedralElectoral {

    private ArrayList<Cardenal> cardenal;
    private ArrayList<Ronda> rondas;
    private Ronda rondaActual;

    public CatedralElectoral() {
        this.cardenal = new ArrayList<>();
        this.rondas = new ArrayList<>();
        
        this.rondaActual = new Ronda();
        this.rondaActual.setNumero(1);
        this.rondas.add(this.rondaActual);
    }

    public String registrarCandidato(String nombre) {
        Cardenal nuevo = new Cardenal();
        nuevo.setNombre(nombre);
        cardenal.add(nuevo);
        return "Candidato registrado: " + nombre;
    }

    public String votacion(Cardenal c) {
        if (c == null) {
            return "Seleccione un candidato para votar.";
        }
        
        ArrayList<Voto> votosRonda = rondaActual.getVoto();
        
        if (votosRonda.size() >= 133) {
            return "No se puede votar más, ya los votos disponibles de la ronda " + rondaActual.getNumero() + " se han llenado.";
        } else {
            votosRonda.add(new Voto(null, c));
            return "Ronda " + rondaActual.getNumero() + "Voto registrado para " + c.getNombre() + " (" + votosRonda.size() + "/133)";
        }
    }
    public String mostrarResultados(){
        String texto = "RESULTADOS RONDA: " + rondaActual.getNumero() + "\n";
    ArrayList<Voto> votosRonda = rondaActual.getVoto();
    String ganador = "";

    for (Cardenal c : cardenal) {
        int contador = 0;

        for (Voto v : votosRonda) {
            if (v.getCandidato() == c) {
                contador++;
            }
        }

        texto += c.getNombre() + ": " + contador + " votos\n";

        if (contador >= 89) {
            ganador = "Ganador: " + c.getNombre();
        }
    }

    return texto + ganador;
}

public String siguienteRonda(){
    int nuevoNumero = rondaActual.getNumero() + 1;
    
    Ronda nuevaRonda = new Ronda();
    nuevaRonda.setNumero(nuevoNumero);
    
    this.rondaActual = nuevaRonda;
    this.rondas.add(nuevaRonda);
    
    return "Iniciando Ronda " + nuevoNumero + ". Votos reiniciados .";
}
    public ArrayList<Cardenal> getCardenal() {
        return cardenal;
    }

    public void setCardenal(ArrayList<Cardenal> cardenal) {
        this.cardenal = cardenal;
    }

    public ArrayList<Ronda> getRondas() {
        return rondas;
    }

    public void setRondas(ArrayList<Ronda> rondas) {
        this.rondas = rondas;
    }

    public Ronda getRondaActual() {
        return rondaActual;
    }

    public void setRondaActual(Ronda rondaActual) {
        this.rondaActual = rondaActual;
    }
}