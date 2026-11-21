import Modelo.CatedralElectoral;
import Vista.JFVotacion;       
import Controlador.Control;    

public class Main {

    public static void main(String[] args) {
        JFVotacion vista = new JFVotacion();
        CatedralElectoral modelo = new CatedralElectoral();
        Control control = new Control(vista, modelo);

    }
}