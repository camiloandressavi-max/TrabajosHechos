package Modelo;
import java.util.LinkedHashMap;

public class Traficante
{
    private String nombre;
    private LinkedHashMap<TipoArma, Integer> capacidad;   // tipo de arma -> cantidad que podria suministrar

    public Traficante(String nombre){
        this.nombre = nombre;
        this.capacidad = new LinkedHashMap<>();
    }

    public void agregarArma(TipoArma arma, int cantidad){
        capacidad.put(arma, cantidad);
    }

    public int cantidadPosible(TipoArma arma){
        Integer cantidad = capacidad.get(arma);
        return cantidad == null ? 0 : cantidad;
    }

    public String getNombre(){
        return nombre;
    }

    public LinkedHashMap<TipoArma, Integer> getCapacidad(){
        return capacidad;
    }

    public String toString(){
        return nombre;
    }
}
