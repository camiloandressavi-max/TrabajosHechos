package Modelo;

public class TipoArma
{
    private String nombre;
    private int capacidadDestructiva;   

    public TipoArma(String nombre, int capacidadDestructiva){
        if(capacidadDestructiva < 1 || capacidadDestructiva > 10){
            throw new IllegalArgumentException("La capacidad destructiva va de 1 a 10");
        }
        this.nombre = nombre;
        this.capacidadDestructiva = capacidadDestructiva;
    }

    public String getNombre(){
        return nombre;
    }

    public int getCapacidadDestructiva(){
        return capacidadDestructiva;
    }

    public String toString(){
        return nombre + " (capacidad " + capacidadDestructiva + ")";
    }
}
