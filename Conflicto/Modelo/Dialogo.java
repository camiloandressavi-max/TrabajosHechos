package Modelo;

public class Dialogo
{
    private Fecha fechaDialogo;
    private LiderPolitico lideres;
    private OrganizacionMediadora organizaciones;

    public Dialogo(LiderPolitico lider, OrganizacionMediadora organizacion, Fecha fechaDialogo){
        this.lideres = lider;
        this.organizaciones = organizacion;
        this.fechaDialogo = fechaDialogo;
    }

    public LiderPolitico getLider(){
        return lideres;
    }

    public OrganizacionMediadora getOrganizacion(){
        return organizaciones;
    }

    public Fecha getFechaDialogo(){
        return fechaDialogo;
    }
}
