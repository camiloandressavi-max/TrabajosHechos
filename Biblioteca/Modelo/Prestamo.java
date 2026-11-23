package Modelo;

public class Prestamo {
    private Fecha fechaPrestamo;
    private Fecha fechaDevolucion;
    private Estado estado;
    private Persona persona;
    private Libro libro;

    public Prestamo() {
    }

    public Prestamo(Fecha fechaPrestamo, Fecha fechaDevolucion, Estado estado, Persona persona, Libro libro) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.estado = estado;
        this.persona = persona;
        this.libro = libro;
    }

    public Fecha getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Fecha fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Fecha getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Fecha fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
}