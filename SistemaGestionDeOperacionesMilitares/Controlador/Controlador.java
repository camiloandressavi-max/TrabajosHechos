package Controlador;

import Modelo.*;
import Vista.JFTOperaciones;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {
    private SistemaGestion sistema;
    private JFTOperaciones vista;

    public Controlador(JFTOperaciones vista, SistemaGestion sistema) {
        this.vista = vista;
        this.sistema = sistema;
        this.vista.agregarListeners(this); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton botonPresionado = (JButton) e.getSource();
        String comando = botonPresionado.getText();

        if (comando.equals("Registrar Operación")) {
            try {
                String tipo = vista.getTipoOperacion();
                String cod = vista.getCodigo();
                String nom = vista.getNombre();
                String zona = vista.getZona();
                String fecha = vista.getFecha();
                int efectivos = Integer.parseInt(vista.getEfectivosStr());
                Estado estado = Estado.PLANEADA;

                if (cod.isEmpty() || nom.isEmpty()) {
                    JOptionPane.showMessageDialog(vista, "El código y el nombre no pueden estar vacíos.");
                    return;
                }

                if (tipo.equals("Aérea")) {
                    int aero = Integer.parseInt(vista.getNumAeronavesStr());
                    int horas = Integer.parseInt(vista.getHorasEstimadasStr());
                    sistema.registrarNuevaOperacion(new OperacionAerea(aero, horas, cod, nom, zona, fecha, efectivos, estado));
                } else if (tipo.equals("Marítima")) {
                    int emb = Integer.parseInt(vista.getCantidadEmbarcacionesStr());
                    String area = vista.getAreaMaritima();
                    sistema.registrarNuevaOperacion(new OperacionMaritima(emb, area, cod, nom, zona, fecha, efectivos, estado));
                } else if (tipo.equals("Terrestre")) {
                    String terreno = vista.getTipoTerreno();
                    int veh = Integer.parseInt(vista.getCantidadVehiculosStr());
                    sistema.registrarNuevaOperacion(new OperacionTerrestre(terreno, veh, cod, nom, zona, fecha, efectivos, estado));
                }

                JOptionPane.showMessageDialog(vista, "¡Operación registrada con éxito!");
                vista.limpiarFormulario();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(vista, "Por favor verifique que los campos numéricos tengan valores válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else if (comando.equals("Limpiar Campos")) {
            vista.limpiarFormulario();
            
        } else if (comando.equals("Listar Todas")) {
            String res = sistema.consultarTodasLasOperacionesRegistradas();
            vista.mostrarResultados(res);
            
        } else if (comando.equals("Buscar por Código")) {
            String codBuscado = vista.getCodigoBusqueda();
            boolean encontrada = sistema.buscarOperacion(codBuscado);
            if (encontrada) {
                vista.mostrarResultados("Operación con código " + codBuscado + " encontrada.");
            } else {
                vista.mostrarResultados("No se encontró ninguna operación con el código: " + codBuscado);
            }
            
        } else if (comando.equals("Operación Mayor Complejidad")) {
            String mayor = sistema.operacionMayorComplejidad();
            vista.mostrarResultados(mayor);
        }
    }

    
}