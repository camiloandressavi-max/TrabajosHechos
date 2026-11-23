package Modelo;

public class Intervencion
{
    private OrganizacionMediadora organizaciones;   // null si interviene un grupo armado
    private GrupoArmado grupos;                     // null si interviene una organizacion
    private Conflicto conflictos;
    private Fecha fechaIncorporacion;
    private Fecha fechaSalida;                      // null mientras siga en el conflicto
    private int numDespliegue;                      // personas desplegadas en este conflicto
    private TipoAyuda ayuda;                        // ayuda que presta en este conflicto

    // Intervencion de un grupo armado
    public Intervencion(GrupoArmado grupo, Conflicto conflicto, Fecha fechaIncorporacion, Fecha fechaSalida){
        this.grupos = grupo;
        this.conflictos = conflicto;
        this.fechaIncorporacion = fechaIncorporacion;
        this.fechaSalida = fechaSalida;
    }

    // Intervencion de una organizacion mediadora
    public Intervencion(OrganizacionMediadora organizacion, Conflicto conflicto, Fecha fechaIncorporacion,
                        Fecha fechaSalida, int numDespliegue, TipoAyuda ayuda){
        this.organizaciones = organizacion;
        this.conflictos = conflicto;
        this.fechaIncorporacion = fechaIncorporacion;
        this.fechaSalida = fechaSalida;
        this.numDespliegue = numDespliegue;
        this.ayuda = ayuda;
    }

    public boolean esGrupo(){
        return grupos != null;
    }

    public OrganizacionMediadora getOrganizacion(){
        return organizaciones;
    }

    public GrupoArmado getGrupo(){
        return grupos;
    }

    public Conflicto getConflicto(){
        return conflictos;
    }

    public Fecha getFechaIncorporacion(){
        return fechaIncorporacion;
    }

    public Fecha getFechaSalida(){
        return fechaSalida;
    }

    public int getNumDespliegue(){
        return numDespliegue;
    }

    public TipoAyuda getAyuda(){
        return ayuda;
    }

    public String getPeriodo(){
        return "desde " + fechaIncorporacion + " hasta " + (fechaSalida == null ? "en curso" : fechaSalida.toString());
    }
}
