package Modelo;
import java.util.ArrayList;

public class GrupoArmado
{
    private String codigo;
    private String nombre;
    private ArrayList<LiderPolitico> lideres;
    private ArrayList<Division> divisiones;

    public GrupoArmado(String codigo, String nombre){
        this.codigo = codigo;
        this.nombre = nombre;
        this.lideres = new ArrayList<>();
        this.divisiones = new ArrayList<>();
    }

    public void agregarLider(LiderPolitico lider){
        lideres.add(lider);
        lider.setGrupo(this);
    }

    public void agregarDivision(Division division){
        divisiones.add(division);
    }

    // El jefe debe obedecer a un lider de este mismo grupo
    public boolean agregarJefe(Division division, JefeMilitar jefe){
        if(!divisiones.contains(division) || jefe.getLiderObedece().getGrupo() != this){
            return false;
        }
        return division.agregarJefe(jefe);
    }

    // Las bajas del grupo son la suma de las bajas de todas sus divisiones
    public int sumarBajas(){
        int total = 0;
        for(Division d : divisiones){
            total += d.getBajas();
        }
        return total;
    }

    // Al menos una division y al menos un lider politico
    public boolean cumpleMinimos(){
        return !divisiones.isEmpty() && !lideres.isEmpty();
    }

    public String getCodigo(){
        return codigo;
    }

    public String getNombre(){
        return nombre;
    }

    public ArrayList<LiderPolitico> getLideres(){
        return lideres;
    }

    public ArrayList<Division> getDivisiones(){
        return divisiones;
    }

    public String toString(){
        return codigo + " - " + nombre;
    }
}
