package modelo;

public class Casa extends ObjetoInteractivo
{
    private Integer numero;
    private String propietario;

    public Casa(){
        super("Casa", "Una casa de la vecindad");
    }

    public Casa(String nombre, Integer numero, String propietario){
        super(nombre, "Casa número " + numero + " de " + propietario);
        this.numero = numero;
        this.propietario = propietario;
    }

    public Integer getNumero(){ return numero; }
    public void setNumero(Integer numero){ this.numero = numero; }

    public String getPropietario(){ return propietario; }
    public void setPropietario(String propietario){ this.propietario = propietario; }

    public String entrar(Personaje personaje){
        return personaje.getNombre() + " entra a la casa número " + numero + " del propietario: " + propietario;
    }

    public String usar(Personaje personaje){
        return entrar(personaje);
    }
}
