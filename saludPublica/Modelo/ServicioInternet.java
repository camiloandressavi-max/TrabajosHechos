package Modelo;


/**
 * Write a description of class ServicioInternet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ServicioInternet
{
     private int valor= 20000;

    public ServicioInternet() {
    }

    public ServicioInternet(int valor) {
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
        return "ServicioInternet{" + "valorServicio=" + valor + '}';
    }
     
}