package Modelo;
import java.util.*;

/**
 * Write a description of class Persona here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Persona
{
    protected String tipoDocumento;
    protected String documento;
    protected String nombre;
    protected String apellido;
    protected String direccion;
    protected String telefono;
    protected int edad;
    protected String estrato;
    protected String estadoCivil;
    protected boolean cabeza;
    protected Bono bono;
    
    public Persona() {
    }

    public Persona(String tipoDocumento, String documento, String nombre, String apellido, String direccion, String telefono, int edad, String estrato, String estadoCivil, boolean cabeza, Bono bono) {
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.edad = edad;
        this.estrato = estrato;
        this.estadoCivil = estadoCivil;
        this.cabeza = cabeza;
        this.bono = bono;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEstrato() {
        return estrato;
    }

    public void setEstrato(String estrato) {
        this.estrato = estrato;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public boolean isCabeza() {
        return cabeza;
    }

    public void setCabeza(boolean cabeza) {
        this.cabeza = cabeza;
    }

    public Bono getBono() {
        return bono;
    }

    public void setBono(Bono bono) {
        this.bono = bono;
    }
    
    @Override
    public String toString() {
        return "Persona{" + "tipoDocumento=" + tipoDocumento + ", documento=" + documento + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", telefono=" + telefono + ", edad=" + edad + ", estrato=" + estrato + ", estadoCivil=" + estadoCivil + ", cabeza=" + cabeza + ", bono=" + bono + '}';
    }
    
    public abstract Bono getBonoPorPersona();
}