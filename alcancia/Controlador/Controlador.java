package Controlador;

import Modelo.*;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {
    private Alcancia modelo;
    private JFAlcancia vista;

    public Controlador(Alcancia modelo, JFAlcancia vista) {
        this.modelo = modelo;
        this.vista = vista;
        
        this.vista.agregarListeners(this);
        
        sincronizarVista();
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        String comando = evento.getActionCommand();

        if (comando.equals("$50")) {
            modelo.agregarMonedas(50);
        } else if (comando.equals("$100")) {
            modelo.agregarMonedas(100);
        } else if (comando.equals("$200")) {
            modelo.agregarMonedas(200);
        } else if (comando.equals("$500")) {
            modelo.agregarMonedas(500);
        } else if (comando.equals("$1000")) {
            modelo.agregarMonedas(1000);
        } else if (comando.equals("VACIAR ALCANCIA")) {
            modelo.vaciar();
        }

        sincronizarVista();
    }

    private void sincronizarVista() {
        vista.actualizarVista(
            modelo.getSaldo(),
            modelo.getMonedas50(),
            modelo.getMonedas100(),
            modelo.getMonedas200(),
            modelo.getMonedas500(),
            modelo.getMonedas1000(),
            modelo.getTotalMonedas()
        );
    }
}