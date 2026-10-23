
/**
 * Write a description of class OperacionesMilitares here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class OperacionesMilitares
{
    protected String codigo,nombreDeLaOperacion,zona,Fecha;
    protected int numeroDeEfectivos;
    protected Estado estado;
    
    public OperacionesMilitares() {
    }

    public OperacionesMilitares(String codigo, String nombreDeLaOperacion, String zona, String Fecha, int numeroDeEfectivos,  Estado estado ) {
        this.codigo = codigo;
        this.nombreDeLaOperacion = nombreDeLaOperacion;
        this.zona = zona;
        this.Fecha = Fecha;
        this.numeroDeEfectivos = numeroDeEfectivos;
        this.estado = estado;
        
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreDeLaOperacion() {
        return nombreDeLaOperacion;
    }

    public void setNombreDeLaOperacion(String nombreDeLaOperacion) {
        this.nombreDeLaOperacion = nombreDeLaOperacion;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public int getNumeroDeEfectivos() {
        return numeroDeEfectivos;
    }

    public void setNumeroDeEfectivos(int numeroDeEfectivos) {
        this.numeroDeEfectivos = numeroDeEfectivos;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    @Override
    public String toString() {
        return "OperacionesMilitares{" + "codigo=" + codigo + ", nombreDeLaOperacion=" + nombreDeLaOperacion + ", zona=" + zona + ", Fecha=" + Fecha + ", numeroDeEfectivos=" + numeroDeEfectivos + ", estado=" + estado + '}';
    }
    
    public abstract int calcularComplejidad ();      
    }
    
