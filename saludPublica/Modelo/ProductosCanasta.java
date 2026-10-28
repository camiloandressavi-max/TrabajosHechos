package Modelo;


/**
 * Write a description of class ProductosCanasta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ProductosCanasta
{
        private int valor= 35000;

    public ProductosCanasta() {
    }

    public ProductosCanasta(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valorCanasta) {
        this.valor = valorCanasta;
    }

    @Override
    public String toString() {
        return "ProductosCanasta{" + "valorCanasta=" + valor + '}';
    }
  
}
