package Modelo;
import java.util.ArrayList;

public class GestorPersona {
    private ArrayList<Persona> listaPersonas;

    public GestorPersona() {
        this.listaPersonas = new ArrayList<>();
    }

    public boolean agregarPersona(Persona p) {
        Bono bono= p.getBonoPorPersona();
        p.setBono(bono);
        listaPersonas.add(p);
        return true;
    }

    
    public Persona buscarPersona(String documentoBuscado) {
    for (Persona p : listaPersonas) {
        if (p.getDocumento().equals(documentoBuscado)) {
            return p;
        }
    }
    return null; 
}
}
