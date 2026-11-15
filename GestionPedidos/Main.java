import Modelo.*;
import Vista.*;
import Controlador.*;
import javax.swing.*;

/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main
{public static void main(String[] args) {
        JFTGestion vista = new JFTGestion();
        ClaseGestora modelo = new ClaseGestora();
        Control controlador = new Control(vista, modelo);
    }
}