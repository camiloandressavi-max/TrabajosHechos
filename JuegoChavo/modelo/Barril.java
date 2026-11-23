package modelo;

public class Barril extends ObjetoInteractivo
{
    public Barril(){
        super("Barril del Chavo", "El famoso barril donde se esconde El Chavo");
    }

    public String usar(Personaje personaje){
        return personaje.getNombre() + " se esconde en el barril";
    }
}
