package Modelo;

import java.util.*;

public class GestorElecciones {
    private ArrayList<CandidatoRepresentante> representante;
    private ArrayList<CandidatoPersonero> personero;
    private int votosBlancoRep = 0;
    private int votosBlancoPer = 0;
    private int votosNulosRep = 0;
    private int votosNulosPer = 0;

    public GestorElecciones() {
        this.representante = new ArrayList<>();
        this.personero = new ArrayList<>();
        this.votosBlancoRep = 0;
        this.votosBlancoPer = 0;
        this.votosNulosRep = 0;
        this.votosNulosPer = 0;
    }

    public GestorElecciones(int votosBlancoRep, int votosBlancoPer, int votosNulosRep, int votosNulosPer) {
        this.representante = new ArrayList<>();
        this.personero = new ArrayList<>();
        this.votosBlancoRep = votosBlancoRep;
        this.votosBlancoPer = votosBlancoPer;
        this.votosNulosRep = votosNulosRep;
        this.votosNulosPer = votosNulosPer;
    }

    public GestorElecciones(ArrayList<CandidatoRepresentante> representante, ArrayList<CandidatoPersonero> personero) {
        this.representante = representante;
        this.personero = personero;
        this.votosBlancoRep = 0;
        this.votosBlancoPer = 0;
        this.votosNulosRep = 0;
        this.votosNulosPer = 0;
    }

    public ArrayList<CandidatoRepresentante> getRepresentante() {
        return representante;
    }

    public void setRepresentante(ArrayList<CandidatoRepresentante> representante) {
        this.representante = representante;
    }

    public ArrayList<CandidatoPersonero> getPersonero() {
        return personero;
    }

    public void setPersonero(ArrayList<CandidatoPersonero> personero) {
        this.personero = personero;
    }

    public int getVotosBlancoRep() {
        return votosBlancoRep;
    }

    public void setVotosBlancoRep(int votosBlancoRep) {
        this.votosBlancoRep = votosBlancoRep;
    }

    public int getVotosBlancoPer() {
        return votosBlancoPer;
    }

    public void setVotosBlancoPer(int votosBlancoPer) {
        this.votosBlancoPer = votosBlancoPer;
    }

    public int getVotosNulosRep() {
        return votosNulosRep;
    }

    public void setVotosNulosRep(int votosNulosRep) {
        this.votosNulosRep = votosNulosRep;
    }

    public int getVotosNulosPer() {
        return votosNulosPer;
    }

    public void setVotosNulosPer(int votosNulosPer) {
        this.votosNulosPer = votosNulosPer;
    }

    public void registrarRepresentantes(CandidatoRepresentante c) {
        representante.add(c);
    }

    public void registrarPersoneros(CandidatoPersonero p) {
        personero.add(p);
    }

    public String votarPorRepresentante(CandidatoRepresentante r) {
        if (r == null) {
            votosNulosRep++;
            return "Faltan datos: Voto registrado como NULO";
        }
        r.setVotos(r.getVotos() + 1);
        return "Se ha agregado el voto a " + r.getNombre();
    }

    public String votarPorPersonero(CandidatoPersonero p) {
        if (p == null) {
            votosNulosPer++;
            return "Faltan datos: Voto registrado como NULO";
        }
        p.setVotos(p.getVotos() + 1);
        return "Se ha agregado el voto a " + p.getNombre();
    }

    public String votarBlancoRepresentante() {
        votosBlancoRep++;
        return "Voto en blanco registrado para Representante";
    }

    public String votarBlancoPersonero() {
        votosBlancoPer++;
        return "Voto en blanco registrado para Personero";
    }

    public String votosPorCandidato(CandidatoRepresentante r, CandidatoPersonero p) {
        String res = "";
        int totalVotosRepresentante = r.getVotos();
        int totalVotosPersonero = p.getVotos();
        res += "El candidato a representante tiene: " + totalVotosRepresentante + " votos y el candidato a personero tiene: " + totalVotosPersonero;
        return res;
    }

    public String personeroElegido() {
        String res = "";
        if (personero.isEmpty()) {
            return "Registre lo necesario";
        }

        CandidatoPersonero ganador = personero.get(0);
        for (CandidatoPersonero pe : personero) {
            if (pe.getVotos() > ganador.getVotos()) {
                ganador = pe;
            }
        }

        res = "El ganador es el " + ganador.getNombre() + " con " + ganador.getVotos() + " votos";
        return res;
    }

    public String candidatoConMenorVotos() {
        String res = "";
        if (personero.isEmpty()) {
            return "Registre lo necesario";
        }

        CandidatoPersonero perdedor = personero.get(0);
        for (CandidatoPersonero pe : personero) {
            if (pe.getVotos() < perdedor.getVotos()) {
                perdedor = pe;
            }
        }

        res = "El personero con menos votos es: " + perdedor.getNombre() + " con " + perdedor.getVotos() + " votos";
        return res;
    }
    
    public String votosTotales(){
        String r="";
        
        int votosPer=0;
        for(CandidatoPersonero p: personero){
            votosPer+=p.getVotos();
        }
        int totalPer= votosPer+votosNulosPer+votosBlancoPer;
        
        int votosRep=0;
        for(CandidatoRepresentante re: representante){
            votosRep+=re.getVotos();
        }
        int totalRep= votosRep+votosNulosRep+votosBlancoRep;
        
        int total=totalPer+totalRep;
        r+="El total de votantes en ambas elecciones fue de: "+total;
        return r;
    }
}