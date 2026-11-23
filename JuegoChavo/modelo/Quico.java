package modelo;

public class Quico extends Personaje
{
    public Quico(){
        super("Quico", 9, "Engreído y consentido", "Vecino");
    }

    public String llorar(){
        return nombre + " empieza a llorar";
    }

    public String accionEspecial(){
        return llorar();
    }

    public String interactuarCon(Personaje otro){
        if(otro instanceof Chavo){
            return nombre + " presume sus juguetes ante " + otro.getNombre();
        }
        return super.interactuarCon(otro);
    }
}
