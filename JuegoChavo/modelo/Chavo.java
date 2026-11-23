package modelo;

public class Chavo extends Personaje
{
    public Chavo(){
        super("El Chavo", 8, "Inocente y travieso", "Protagonista");
    }

    public String pedirTortaJamon(){
        return nombre + " pide una torta de jamón";
    }

    public String accionEspecial(){
        return pedirTortaJamon();
    }

    public String interactuarCon(Personaje otro){
        if(otro instanceof Florinda){
            return nombre + " le pide una torta de jamón a " + otro.getNombre();
        }
        if(otro instanceof Quico){
            return nombre + " juega con su amigo " + otro.getNombre();
        }
        return super.interactuarCon(otro);
    }
}
