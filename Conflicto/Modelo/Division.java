package Modelo;
import java.util.ArrayList;

public class Division
{
    private int consecutivo;
    private int barcos;
    private int aviones;
    private int hombres;
    private int tanques;
    private int bajas;
    private ArrayList<JefeMilitar> jefes;

    public Division(int consecutivo, int barcos, int aviones, int hombres, int tanques, int bajas){
        this.consecutivo = consecutivo;
        this.barcos = barcos;
        this.aviones = aviones;
        this.hombres = hombres;
        this.tanques = tanques;
        this.bajas = bajas;
        this.jefes = new ArrayList<>();
    }

    // Maximo tres jefes por division y cada jefe dirige una sola division
    public boolean agregarJefe(JefeMilitar jefe){
        if(jefes.size() >= 3 || jefe.getDivision() != null){
            return false;
        }
        jefes.add(jefe);
        jefe.setDivision(this);
        return true;
    }

    public int getConsecutivo(){
        return consecutivo;
    }

    public int getBarcos(){
        return barcos;
    }

    public int getAviones(){
        return aviones;
    }

    public int getHombres(){
        return hombres;
    }

    public int getTanques(){
        return tanques;
    }

    public int getBajas(){
        return bajas;
    }

    public ArrayList<JefeMilitar> getJefes(){
        return jefes;
    }

    public String toString(){
        return "Division " + consecutivo + " (barcos: " + barcos + ", aviones: " + aviones +
            ", tanques: " + tanques + ", hombres: " + hombres + ", bajas: " + bajas + ")";
    }
}
