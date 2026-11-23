package Modelo;

public class LiderPolitico
{
    private String nombre;
    private GrupoArmado grupo;
    private String apodos;

    public LiderPolitico(String nombre, String apodos){
        this.nombre = nombre;
        this.apodos = apodos;
    }

    public String getNombre(){
        return nombre;
    }

    public GrupoArmado getGrupo(){
        return grupo;
    }

    public void setGrupo(GrupoArmado grupo){
        this.grupo = grupo;
    }

    public String getCodigoGrupo(){
        return grupo == null ? "" : grupo.getCodigo();
    }

    public String getApodos(){
        return apodos;
    }

    public String toString(){
        return nombre;
    }
}
