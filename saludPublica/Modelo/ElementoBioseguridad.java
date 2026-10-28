package Modelo;


/**
 * Write a description of class ElementoBioseguridad here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ElementoBioseguridad
{
    private int valor= 100000;

    public ElementoBioseguridad() {
    }

    public ElementoBioseguridad(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "ElementoBioseguridad{" + "valorBioseguridad=" + valor + '}';
    }
}
