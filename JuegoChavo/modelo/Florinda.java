package modelo;

public class Florinda extends Personaje
{
    public Florinda(){
        super("Doña Florinda", 40, "Autoritaria y sobreprotectora", "Madre de Quico");
    }

    public String darBofetada(){
        return nombre + " le da una bofetada a Don Ramón";
    }

    public String accionEspecial(){
        return darBofetada();
    }

    public String interactuarCon(Personaje otro){
        if(otro instanceof DonRamon){
            return darBofetada();
        }
        if(otro instanceof Chavo){
            return nombre + " regaña al Chavo por acercarse a Quico";
        }
        return super.interactuarCon(otro);
    }
}
