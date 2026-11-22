package Modelo;

public class CandidatoRepresentante {
    private String nombre;
    private String apellido;
    private String grado;
    private String grupo;
    private String lema;
    private int numeroDeTarjeton;
    private String formula;
    private int votos;

    public CandidatoRepresentante() {
        this.votos = 0;
    }

    public CandidatoRepresentante(String nombre, String apellido, String grado, String grupo, String lema, int numeroDeTarjeton, String formula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.grado = grado;
        this.grupo = grupo;
        this.lema = lema;
        this.numeroDeTarjeton = numeroDeTarjeton;
        this.formula = formula;
        this.votos = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
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