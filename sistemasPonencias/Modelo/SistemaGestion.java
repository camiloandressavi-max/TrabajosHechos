package Modelo;

import java.util.ArrayList;

public class SistemaGestion {
    private ArrayList<GrupoDeInvestigacion> grupos = new ArrayList<>();
    private ArrayList<Ponencia> ponencias = new ArrayList<>();

    public void registrarGrupo(GrupoDeInvestigacion g) {
        if (g != null) {
            grupos.add(g);
        }
    }

    public void registrarPonencia(Ponencia p) {
        if (p != null) {
            ponencias.add(p);
        }
    }

    public String consultarTodo() {
        String resultado = "=== GRUPOS DE INVESTIGACIÓN ===\n";
        if (grupos.isEmpty()) {
            resultado += "No hay grupos registrados.\n";
        } else {
            for (GrupoDeInvestigacion g : grupos) {
                resultado += g.toString() + "\n";
            }
        }

        resultado += "\n=== PONENCIAS REGISTRADAS ===\n";
        if (ponencias.isEmpty()) {
            resultado += "No hay ponencias registradas.\n";
        } else {
            for (Ponencia p : ponencias) {
                resultado += p.toString() + "\n";
            }
        }
        return resultado;
    }

    public GrupoDeInvestigacion buscarGrupo(String nombre) {
        for (GrupoDeInvestigacion g : grupos) {
            if (g.getNombre() != null && g.getNombre().equalsIgnoreCase(nombre)) {
                return g;
            }
        }
        return null;
    }
}