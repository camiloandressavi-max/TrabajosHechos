package Modelo;
import java.util.ArrayList;

public class Territorial extends Conflicto
{
    private ArrayList<String> regiones;

    public Territorial(int codigo, String nombre, int muertos, int heridos){
        super(codigo, nombre, muertos, heridos);
        this.regiones = new ArrayList<>();
    }

    public void agregarRegion(String dato){
        regiones.add(dato);
    }

    public ArrayList<String> getRegiones(){
        return regiones;
    }

    public String getTipo(){
        return "Territorial";
    }

    public String getDetalle(){
        return "Regiones afectadas: " + String.join(", ", regiones);
    }
}
