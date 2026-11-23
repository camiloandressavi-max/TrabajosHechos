package Modelo;

public class Libro {
    private String titulo;
    private String autor;
    private int issn;
    private int añoPublicacion;
    private String editorial;
    private Tipo tipo;

    public Libro() {
    }

    public Libro(String titulo, String autor, int issn, int añoPublicacion, String editorial, Tipo tipo) {
        this.titulo = titulo;
        this.autor = autor;
        this.issn = issn;
        this.añoPublicacion = añoPublicacion;
        this.editorial = editorial;
        this.tipo = tipo;
        
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getIssn() {
        return issn;
    }

    public void setIssn(int issn) {
        this.issn = issn;
    }

    public int getAñoPublicacion() {
        return añoPublicacion;
    }

    public void setAñoPublicacion(int añoPublicacion) {
        this.añoPublicacion = añoPublicacion;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Tipo getTipo() {
        return tipo;
    }
}