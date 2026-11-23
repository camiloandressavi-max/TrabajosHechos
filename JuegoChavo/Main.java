import modelo.*;
import vista.*;
import controlador.*;
import javax.swing.UIManager;

public class Main
{
    public static void main(String[] args){
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(Exception e){
        }

        Vecindad modelo = new Vecindad();
        modelo.agregarPersonaje(new Chavo());
        modelo.agregarPersonaje(new Quico());
        modelo.agregarPersonaje(new DonRamon());
        modelo.agregarPersonaje(new Florinda());
        modelo.agregarObjeto(new Barril());
        modelo.agregarObjeto(new Casa("Casa de Don Ramón", 72, "Don Ramón"));
        modelo.agregarObjeto(new Casa("Casa de Doña Florinda", 14, "Doña Florinda"));
        modelo.agregarObjeto(new Casa("Casa del Señor Barriga", 1, "Señor Barriga"));

        JFVecindad vista = new JFVecindad();
        Control control = new Control(modelo, vista);
        vista.setVisible(true);
    }
}
