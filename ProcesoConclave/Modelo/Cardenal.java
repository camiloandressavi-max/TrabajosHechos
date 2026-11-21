package Modelo;

public class Cardenal {
    private Pais pais;
    private Tipo tipo;
    private String cedula;
    private String nombre;
    private int edad;
    private boolean poseeProblemas;

    public Cardenal() {
    }

    public Cardenal(Pais pais, Tipo tipo, String cedula, String nombre, int edad, boolean poseeProblemas) {
        this.pais = pais;
        this.tipo = tipo;
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.poseeProblemas = poseeProblemas;
    }

    public boolean esElector() {
        return edad < 80 && !poseeProblemas;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isPoseeProblemas() {
        return poseeProblemas;
    }

    public void setPoseeProblemas(boolean poseeProblemas) {
        this.poseeProblemas = poseeProblemas;
    }

    @Override
    public String toString() {
        return nombre ;
    }
}