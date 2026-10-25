package Controlador;

import Modelo.*;
import Vista.*;
import java.awt.event.*;
import java.lang.*;
/**
 * Write a description of class Control here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Control implements ActionListener
{

   private GestionRiesgos modeloGestor;
   private JFTGESTION viewGestion;
   
   public Control(GestionRiesgos modeloGestor, JFTGESTION viewGestion) {
        this.modeloGestor = modeloGestor;
        this.viewGestion = viewGestion;
        
        viewGestion.btnAgregar.addActionListener(this);
        viewGestion.btnBuscar.addActionListener(this);
        viewGestion.btnEliminar.addActionListener(this);
        viewGestion.btnListar.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if (comando.equals("Agregar")) {
            String codigo = viewGestion.txtCodigo.getText();
            String descripcion = viewGestion.txtDescripcion.getText();
            String tipo = viewGestion.txtTipo.getText();
            int nivel;
            try {
                nivel = Integer.parseInt(viewGestion.txtNivel.getText());
            } catch (NumberFormatException ex) {
                viewGestion.areaSalida.setText("Nivel debe ser un número entero.");
                return;
            }

            Riesgo r = new Riesgo(codigo, descripcion, tipo, nivel);
            if (modeloGestor.agregarRiesgo(r)) {
                viewGestion.areaSalida.setText("✔ Riesgo agregado\n\n" + modeloGestor.listarRiesgos());
            } else {
                viewGestion.areaSalida.setText("✘ Ya existe un riesgo con ese código.");
            }

        } else if (comando.equals("Buscar")) {
            String codigo = viewGestion.txtCodigo.getText();
            Riesgo r = modeloGestor.buscarPorCodigo(codigo);
            if (r != null) {
                viewGestion.areaSalida.setText("✔ Riesgo encontrado:\n\n" + r.toString());
            } else {
                viewGestion.areaSalida.setText("✘ No se encontró ese riesgo.");
            }

        } else if (comando.equals("Eliminar")) {
            String codigo = viewGestion.txtCodigo.getText();
            if (modeloGestor.eliminarRiesgo(codigo)) {
                viewGestion.areaSalida.setText("✔ Riesgo eliminado\n\n" + modeloGestor.listarRiesgos());
            } else {
                viewGestion.areaSalida.setText("✘ No se encontró ese riesgo.");
            }
        }
    }
}