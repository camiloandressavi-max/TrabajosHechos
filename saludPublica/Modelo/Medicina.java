package Modelo;


/**
 * Write a description of class Medicina here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Medicina
{
   
  private int valor= 30000;

    public Medicina() {
    }

    public Medicina(int valor) {
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
        return "Medicina{" + "valorMedicina=" + valor + '}';
    }
}
