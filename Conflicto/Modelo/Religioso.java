package Modelo;
import java.util.ArrayList;

public class Religioso extends Conflicto
{
    private ArrayList<String> religiones;

    public Religioso(int codigo, String nombre, int muertos, int heridos){
        super(codigo, nombre, muertos, heridos);
        this.religiones = new ArrayList<>();
    }

    public void agregarReligion(String dato){
        religiones.add(dato);
    }

    public ArrayList<String> getReligiones(){
        return religiones;
    }

    public String getTipo(){
        return "Religioso";
    }

    public String getDetalle(){
        return "Religiones afectadas: " + String.join(", ", religiones);
    }
}
