package Modelo;
import java.util.ArrayList;

public class Racial extends Conflicto
{
    private ArrayList<String> etnias;

    public Racial(int codigo, String nombre, int muertos, int heridos){
        super(codigo, nombre, muertos, heridos);
        this.etnias = new ArrayList<>();
    }

    public void agregarEtnia(String dato){
        etnias.add(dato);
    }

    public ArrayList<String> getEtnias(){
        return etnias;
    }

    public String getTipo(){
        return "Racial";
    }

    public String getDetalle(){
        return "Etnias enfrentadas: " + String.join(", ", etnias);
    }
}
