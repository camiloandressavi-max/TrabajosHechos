package Modelo;

public class Suministra
{
    private Traficante traficante;
    private GrupoArmado grupo;
    private TipoArma arma;
    private int numeroArmas;

    public Suministra(Traficante traficante, GrupoArmado grupo, TipoArma arma, int numeroArmas){
        this.traficante = traficante;
        this.grupo = grupo;
        this.arma = arma;
        this.numeroArmas = numeroArmas;
    }

    public Traficante getTraficante(){
        return traficante;
    }

    public GrupoArmado getGrupo(){
        return grupo;
    }

    public TipoArma getArma(){
        return arma;
    }

    public int getNumeroArmas(){
        return numeroArmas;
    }
}
