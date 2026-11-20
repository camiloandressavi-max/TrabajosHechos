import Modelo.GestorPersona;
import Vista.JFTSalud;
import Controlador.Control;

public class Main {
    public static void main(String[] args) {
        GestorPersona modelo = new GestorPersona();
        JFTSalud vista = new JFTSalud();
        Control control = new Control(vista, modelo);
    }
}