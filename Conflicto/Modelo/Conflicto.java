package Modelo;
import java.util.ArrayList;

public class Conflicto
{
    protected int codigo;
    protected String nombre;
    protected ArrayList<Pais> paises;
    protected int muertos;
    protected int heridos;

    public Conflicto(int codigo, String nombre, int muertos, int heridos){
        this.codigo = codigo;
        this.nombre = nombre;
        this.muertos = muertos;
        this.heridos = heridos;
        this.paises = new ArrayList<>();
    }

    public void agregarPais(Pais pais){
        paises.add(pais);
    }

    public int getCodigo(){
        return codigo;
    }

    public String getNombre(){
        return nombre;
    }

    public ArrayList<Pais> getPaises(){
        return paises;
    }

    public int getMuertos(){
        return muertos;
    }

    public int getHeridos(){
        return heridos;
    }

  
    public String getTipo(){
        return "Sin clasificar";
    }

    public String getDetalle(){
        return "";
    }

    public String toString(){
        return codigo + " - " + nombre;
    }
}
