package Modelo;


/**
 * Write a description of class ImplementosTecnologicos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ImplementosTecnologicos
{
    private int valor= 50000;

    public ImplementosTecnologicos() {
    }

    public ImplementosTecnologicos(int valor) {
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
        return "ImplementosTecnologicos{" + "valorImplementos=" + valor + '}';
    }
}