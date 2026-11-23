import Controlador.ControladorIncendios;
import Modelo.Operacion;
import Vista.JFTIncendioPrincipal;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Operacion gestora = new Operacion();
                JFTIncendioPrincipal vista = new JFTIncendioPrincipal();
                ControladorIncendios control = new ControladorIncendios(gestora, vista);
            }
        });
    }
}