package Modelo;
import java.util.ArrayList;

public class Economico extends Conflicto
{
    private ArrayList<String> materiasPrimas;

    public Economico(int codigo, String nombre, int muertos, int heridos){
        super(codigo, nombre, muertos, heridos);
        this.materiasPrimas = new ArrayList<>();
    }

    public void agregarMateriaPrima(String dato){
        materiasPrimas.add(dato);
    }

    public ArrayList<String> getMateriasPrimas(){
        return materiasPrimas;
    }

    public String getTipo(){
        return "Economico";
    }

    public String getDetalle(){
        return "Materias primas disputadas: " + String.join(", ", materiasPrimas);
    }
}
