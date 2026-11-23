package modelo;
import java.util.ArrayList;

public class Vecindad
{
    private ArrayList<Personaje> personajes;
    private ArrayList<ObjetoInteractivo> objetos;

    public Vecindad(){
        personajes = new ArrayList<>();
        objetos = new ArrayList<>();
    }

    public void agregarPersonaje(Personaje p){
        personajes.add(p);
    }

    public void agregarObjeto(ObjetoInteractivo obj){
        objetos.add(obj);
    }

    public ArrayList<Personaje> getPersonajes(){
        return personajes;
    }

    public ArrayList<ObjetoInteractivo> getObjetos(){
        return objetos;
    }

    public Personaje buscarPersonaje(String nombre){
        for(Personaje p : personajes){
            if(p.getNombre().equalsIgnoreCase(nombre)){
                return p;
            }
        }
        return null;
    }

    public String mostrarPersonajes(){
        String texto = "";
        for(Personaje p : personajes){
            texto += "Personaje en la vecindad: " + p.getNombre() + "\n";
        }
        return texto;
    }
}
