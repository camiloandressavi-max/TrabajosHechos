import Modelo.SistemaGestion;
import Vista.JFTPonencia;
import Controlador.Controlador;

public class Principal {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                SistemaGestion sistema = new SistemaGestion();
                JFTPonencia vista = new JFTPonencia();
                new Controlador(vista, sistema);
            }
        });
    }
}