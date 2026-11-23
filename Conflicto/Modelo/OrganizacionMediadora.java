package Modelo;

public class OrganizacionMediadora
{
    private String codigo;
    private String nombre;
    private TipoOrganizacion tipo;
    private OrganizacionMediadora dependencia;  

    public OrganizacionMediadora(String codigo, String nombre, TipoOrganizacion tipo, OrganizacionMediadora dependencia){
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.dependencia = dependencia;
    }

    public String getCodigo(){
        return codigo;
    }

    public String getNombre(){
        return nombre;
    }

    public TipoOrganizacion getTipo(){
        return tipo;
    }

    public OrganizacionMediadora getDependencia(){
        return dependencia;
    }

    public String toString(){
        return codigo + " - " + nombre;
    }
}
