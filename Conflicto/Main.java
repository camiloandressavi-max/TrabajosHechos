import Modelo.*;
import Vista.*;
import Controlador.*;

public class Main
{
    public static void main(String[] args){
        GestorConflicto modelo = new GestorConflicto();
        JFConflicto vista = new JFConflicto();
        Control control = new Control(modelo, vista);
        vista.setVisible(true);
    }
}
