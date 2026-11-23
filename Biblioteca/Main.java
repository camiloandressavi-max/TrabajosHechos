import Modelo.*;
import Vista.*;
import Controlador.*;
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main
{ 
    public static void main (String[] args){
    JFBiblioteca biblioteca= new JFBiblioteca();
    GestionBiblioteca gestion= new GestionBiblioteca();
    Control c= new Control(biblioteca,gestion);
}
}