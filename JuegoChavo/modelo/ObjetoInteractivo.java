package modelo;

public class ObjetoInteractivo
{
    protected String nombre;
    protected String descripcion;

    public ObjetoInteractivo(String nombre, String descripcion){
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre(){ return nombre; }
    public void setNombre(String nombre){ this.nombre = nombre; }

    public String getDescripcion(){ return descripcion; }
    public void setDescripcion(String descripcion){ this.descripcion = descripcion; }

    public String usar(Personaje personaje){
        return personaje.getNombre() + " usa el objeto: " + nombre;
    }

    public String toString(){
        return nombre;
    }
}
