package modelo;

public class DonRamon extends Personaje
{
    public DonRamon(){
        super("Don Ramón", 45, "Perezoso pero simpático", "Vecino endeudado");
    }

    public DonRamon(String nombre, Integer edad, String personalidad, String rol){
        super(nombre, edad, personalidad, rol);
    }

    public String evadirCobroRenta(){
        return nombre + " evade el cobro de la renta del Señor Barriga";
    }

    public String accionEspecial(){
        return evadirCobroRenta();
    }

    public String interactuarCon(Personaje otro){
        if(otro instanceof Florinda){
            return nombre + " se esconde de " + otro.getNombre() + " para evitar una bofetada";
        }
        return super.interactuarCon(otro);
    }
}
