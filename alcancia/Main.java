import Vista.*;
import Controlador.*;
import Modelo.*;
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main
{
    public static void main(String[] args){
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                Alcancia modelo = new Alcancia();
                JFAlcancia vista = new JFAlcancia();
                new Controlador(modelo, vista);
            }
        });
    }
}