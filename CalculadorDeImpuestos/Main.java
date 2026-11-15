import Controlador.*;
import Modelo.*;
import Vista.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ClaseGestora gestora = new ClaseGestora();
                JFTrabajador vista = new JFTrabajador();
                Control control = new Control(vista, gestora);
            }
        });
    }
}