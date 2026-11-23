package Modelo;

import java.util.ArrayList;

public class GestionBiblioteca {
    private ArrayList<Persona> usuarios;
    private ArrayList<Prestamo> prestamos;
    private ArrayList<Libro> libros;

    public GestionBiblioteca() {
        this.usuarios = new ArrayList<>();
        this.prestamos = new ArrayList<>();
        this.libros = new ArrayList<>();
    }

    public ArrayList<Persona> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Persona> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(ArrayList<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }
    
    public String devolucion(Prestamo p){
        String r= "";
        if(p.getPersona()==null){
             
             return "No valido";
         }
         String nombre= p.getPersona().getNombre();
         String cedula= p.getPersona().getCedula();
         int edad=p.getPersona().getEdad();
         int fechaDia= p.getFechaPrestamo().getDia();
         int fechaMes= p.getFechaPrestamo().getMes();
         int fechaAño= p.getFechaPrestamo().getAño();
         int fechaDia2= p.getFechaDevolucion().getDia();
         int fechaMes2= p.getFechaDevolucion().getMes();
         int fechaAño2= p.getFechaDevolucion().getAño();
         
         Persona per= p.getPersona();
         String p1="";
         if(per instanceof Docente){
             p1+="docente";
         }else if(per instanceof Administrativo){
             p1+="Administrativo";
         }else if(per instanceof Estudiante){
             p1+="Estudiante";
         }
         
         
         
         int diasPrestados= ((fechaAño2*365)+(fechaMes2*30)+fechaDia2)-((fechaAño*365)+(fechaMes*30)+fechaDia);
         if(p.getPersona() instanceof Estudiante||p.getPersona() instanceof Docente){
             
             if(diasPrestados<=15){
                 r+="Nombre del que busca el libro: " +nombre+"Es un"+p1+"Cedula: "+cedula+"Desde que pido el libro han pasado" + diasPrestados;
             }else{
                 r+= "Nombre del que busca el libro: " +nombre+"Es un"+p1+" Cedula: "+cedula+" Desde que pido el libro han pasado"+diasPrestados +" mas de los 15 dias habiles entonces se le aplicara una multa";
             }
             
         }else if(p.getPersona() instanceof Administrativo){
             if(diasPrestados<=3){
                 r+="Nombre del que busca el libro: " +nombre+"Es un"+p1+"Cedula: "+cedula+"Desde que pido el libro han pasado" + diasPrestados;
             }else{
                 r+= "Nombre del que busca el libro: " +nombre+"Es un"+p1+" Cedula: "+cedula+" Desde que pido el libro han pasado "+diasPrestados +"mas de los 3 dias habiles entonces se le aplicara una multa";
             }
         }
         
         
         
        String titulo= p.getLibro().getTitulo();
        String autor= p.getLibro().getAutor();
        int issn= p.getLibro().getIssn();
        int fechaDePublicacion= p.getLibro().getAñoPublicacion();
        String editorial= p.getLibro().getEditorial();
        Tipo tipo= p.getLibro().getTipo();
        
        Libro l= new Libro(titulo,autor,issn,fechaDePublicacion,editorial,tipo);
        
        if (tipo == Tipo.COLECCION) {
    libros.add(l);
    prestamos.add(p);
    r += " El libro que pidio es de Coleccion, su titulo es: " + titulo + " y su codigo ISSN es: " + issn;
} else if (tipo == Tipo.REFERENCIA) {
    int a = 0;
    for (Libro li : libros) {
        if (li.getTipo() == Tipo.REFERENCIA && li.getIssn() == issn) {
            a++;
        }
    }

    if (a >= 2) {
        r += " El libro que solicito es de referencia pero no puede solicitar mas ya que no existen mas copias de este libro.";
    } else {
        libros.add(l);
        prestamos.add(p);
        r += " El libro que pidio es de Referencia, su titulo es: " + titulo + " y su codigo ISSN es: " + issn;
    }
}
         
        
        
        
        
        return r;
    }
}