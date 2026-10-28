
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import Modelo.SistemaGestion;
import Vista.JFTOperaciones;
import Controlador.Controlador;

public class Principal {
    public static void main(String[] args) {
        SistemaGestion sistema = new SistemaGestion();
        
        JFTOperaciones vista = new JFTOperaciones();
        
        Controlador controlador = new Controlador(vista, sistema);
    }
}