import Modelo.GestorElecciones;
import Vista.JFElecciones;
import Controlador.Control;
public class Main {
    public static void main(String[] args) {
        JFElecciones vista = new JFElecciones();
        GestorElecciones gestor = new GestorElecciones();
        Control control = new Control(vista, gestor);
    }
}