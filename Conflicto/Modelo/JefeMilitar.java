package Modelo;

public class JefeMilitar
{
    private Division division;
    private String codigo;
    private String rango;
    private LiderPolitico liderObedece;

    public JefeMilitar(String codigo, String rango, LiderPolitico liderObedece){
        this.codigo = codigo;
        this.rango = rango;
        this.liderObedece = liderObedece;
    }

    public Division getDivision(){
        return division;
    }

    public void setDivision(Division division){
        this.division = division;
    }

    public String getCodigo(){
        return codigo;
    }

    public String getRango(){
        return rango;
    }

    public LiderPolitico getLiderObedece(){
        return liderObedece;
    }

    public String toString(){
        return codigo + " (" + rango + ", obedece a " + liderObedece.getNombre() + ")";
    }
}
