
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import Modelo.*;
import Vista.*;
import Controlador.*;

public class Main {
    public static void main(String[] args) {
        GestionRiesgos modeloGestor = new GestionRiesgos();
        JFTGESTION vistaGestion = new JFTGESTION();
        Control control = new Control(modeloGestor, vistaGestion);
        vistaGestion.setVisible(true);
    }
}