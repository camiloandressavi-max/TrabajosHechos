package Modelo;
import java.util.*;
import java.lang.*;
import java.util.ArrayList;

/**
 * Write a description of class GestionRiesgos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GestionRiesgos
{
    private ArrayList<Riesgo> lista;

    public GestionRiesgos() {
        lista = new ArrayList<>();
    }

    public boolean agregarRiesgo(Riesgo r) {
        for (Riesgo riesgo : lista) {
            if (riesgo.getCodigo().equals(r.getCodigo())) {
                return false;
            }
        }
        lista.add(r);
        return true;
    }

    public Riesgo buscarPorCodigo(String codigo) {
        for (Riesgo riesgo : lista) {
            if (riesgo.getCodigo().equals(codigo)) {
                return riesgo;
            }
        }
        return null;
    }

    public boolean eliminarRiesgo(String codigo) {
        Riesgo r = buscarPorCodigo(codigo);
        if (r != null) {
            lista.remove(r);
            return true;
        }
        return false;
    }

    public String listarRiesgos() {
        if (lista.isEmpty()) return "No hay riesgos registrados.";
        String resultado = "";
        for (Riesgo r : lista) {
            resultado += r.toString() + "\n\n";
        }
        return resultado;
    }
}