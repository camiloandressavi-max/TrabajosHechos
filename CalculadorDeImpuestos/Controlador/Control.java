package Controlador;
import Modelo.*;
import Vista.*;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Write a description of class Control here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Control implements ActionListener
{   
    private JFTrabajador vista;
    private ClaseGestora modeloR;
    
    public Control(JFTrabajador vista, ClaseGestora modeloR) {
    this.vista = vista;
    this.modeloR = modeloR;
    iniciarListeners();
}
    private void iniciarListeners(){
        vista.getBtnCalcular().addActionListener(this);
        vista.getBtnBuscar().addActionListener(this);
        vista.getBtnMarca().addActionListener(this);
        vista.getBtnVehiculo().addActionListener(this);
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        String comando = evento.getActionCommand();

        if (comando.equals("Buscar por linea")) {
            
        String linea= vista.getTxtLinea1().getText();
        String resultado= modeloR.buscarPorLinea(linea);
        JOptionPane.showMessageDialog(vista, resultado);
           
        } else if (comando.equals("Buscar por marca")) {
            String marca= vista.getTxtLinea2().getText();
            Vehiculo v= modeloR.buscarPorMarca(marca);
            JOptionPane.showMessageDialog(vista,v);
            
           
        } else if (comando.equals("Buscar vehiculo mas caro")) {
            Vehiculo v= modeloR.buscarVehiculoMasCaro();
            JOptionPane.showMessageDialog(vista,v);
        } else if (comando.equals("Calcular")) {
            String marca= vista.getTxtMarca().getText();
            String linea= vista.getTxtLinea().getText();
            int modelo= Integer.parseInt(vista.getTxtModelo().getText());
            double valor= Double.parseDouble(vista.getTxtValor().getText());
            Vehiculo vehiculo= new Vehiculo(marca,linea,modelo,valor);
            boolean prontoPago=vista.getChkPago().isSelected(); 
            boolean trasladoCuenta=vista.getChkTraslado().isSelected();
            boolean servicioPublico= vista.getChkServicio().isSelected();
            
            double r= modeloR.calcularImpuesto(vehiculo,prontoPago,trasladoCuenta,servicioPublico);
            JOptionPane.showMessageDialog(vista, r);
        }
    }
}