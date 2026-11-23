package Modelo;

public class Fecha
{
    private int dias;
    private int mes;
    private int anio;

    public Fecha(int dias, int mes, int anio){
        this.dias = dias;
        this.mes = mes;
        this.anio = anio;
    }

    public int getDias(){
        return dias;
    }

    public int getMes(){
        return mes;
    }

    public int getAnio(){
        return anio;
    }

    public String toString(){
        return dias + "/" + mes + "/" + anio;
    }
}
