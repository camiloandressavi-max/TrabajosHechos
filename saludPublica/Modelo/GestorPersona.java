package Modelo;
import java.util.ArrayList;

public class GestorPersona {
    private ArrayList<Persona> listaPersonas;

    public GestorPersona() {
        this.listaPersonas = new ArrayList<>();
    }
    public boolean guardar(Persona p) {
        if (p == null || buscarPersona(p.getDocumento()) != null) {
            return false;
        }

        int total = 0;

        if (p instanceof ProfesionalSalud) {
            ProfesionalSalud ps = (ProfesionalSalud) p;
            if (ps.getBioseguridad() != null) {
                for (ElementoBioseguridad b : ps.getBioseguridad()) {
                    total += b.getValor();
                }
            }
            if (ps.getMedicina() != null) {
                for (Medicina m : ps.getMedicina()) {
                    total += m.getValor();
                }
            }
            if (total > 350000) {
                return false;
            }

        } else if (p instanceof Docente) {
            Docente d = (Docente) p;
            if (d.getTecno() != null) {
                for (ImplementosTecnologicos it : d.getTecno()) {
                    total += it.getValor();
                }
            }
            if (d.getServicio() != null) {
                for (ServicioInternet si : d.getServicio()) {
                    total += si.getValor();
                }
            }
            if (total > 100000) {
                return false;
            }

        } else if (p instanceof Ciudadano) {
            Ciudadano c = (Ciudadano) p;
            if (!c.getEstrato().equals("1") && !c.getEstrato().equals("2")) {
                return false;
            }
            if (c.getMedicina() != null) {
                for (Medicina m : c.getMedicina()) {
                    total += m.getValor();
                }
            }
            if (c.getProductos() != null) {
                for (ProductosCanasta pc : c.getProductos()) {
                    total += pc.getValor();
                }
            }
            if (total > 160000) {
                return false;
            }
        }

        p.setBono(p.getBonoPorPersona());
        listaPersonas.add(p);
        return true;
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
