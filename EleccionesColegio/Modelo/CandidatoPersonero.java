package Modelo;

public class CandidatoPersonero {
    private String nombre;
    private String grado;
    private String grupo;
    private String apellido;
    private String lema;
    private int numeroDeTarjeton;
    private Animal animal;
    private int votos;

    public CandidatoPersonero() {
        this.votos = 0;
    }

    public CandidatoPersonero(String nombre, String grado, String grupo, String apellido, String lema, int numeroDeTarjeton, Animal animal) {
        this.nombre = nombre;
        this.grado = grado;
        this.grupo = grupo;
        this.apellido = apellido;
        this.lema = lema;
        this.numeroDeTarjeton = numeroDeTarjeton;
        this.animal = animal;
        this.votos = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getLema() {
        return lema;
    }

    public void setLema(String lema) {
        this.lema = lema;
    }

    public int getNumeroDeTarjeton() {
        return numeroDeTarjeton;
    }

    public void setNumeroDeTarjeton(int numeroDeTarjeton) {
        this.numeroDeTarjeton = numeroDeTarjeton;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public void sumarVoto() {
        this.votos++;
    }

    @Override
    public String toString() {
        return getNombre();
    }
}