package Controlador;


import Modelo.*;
import Vista.JFTPonencia;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {
    private SistemaGestion sistema;
    private JFTPonencia vista;

    public Controlador(JFTPonencia vista, SistemaGestion sistema) {
        this.vista = vista;
        this.sistema = sistema;
        this.vista.agregarListeners(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if (comando.equals("Guardar")) {
            try {
                String nomGrupo = vista.getNombreGrupo();
                String dirNombre = vista.getDirectorGrupo();
                String nomLinea = vista.getLineaInvestigacion();
                String titPonencia = vista.getTituloPonencia();
                String tipoPonencia = vista.getTipoPonencia();

                if (nomGrupo.isEmpty() || titPonencia.isEmpty() || tipoPonencia.equals("Seleccionar")) {
                    JOptionPane.showMessageDialog(vista, "Por favor complete los campos obligatorios y seleccione un tipo de ponencia.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                Profesor director = new Profesor();
                director.setNombre(dirNombre);

                Ponencia ponenciaObj;
                if (tipoPonencia.equals("Oral")) {
                    ponenciaObj = new PonenciaOral(titPonencia);
                } else {
                    ponenciaObj = new PonenciaPoster(titPonencia);
                }
                LineaDeInvestigacion linea = new LineaDeInvestigacion(ponenciaObj);

                GrupoDeInvestigacion grupo = new GrupoDeInvestigacion(linea, nomGrupo, Clasificacion.A, director);

                sistema.registrarGrupo(grupo);
                sistema.registrarPonencia(ponenciaObj);

                JOptionPane.showMessageDialog(vista, "Grupo y ponencia guardados con éxito");
                vista.mostrarMensaje(sistema.consultarTodo());
                vista.limpiarFormulario();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(vista, "Error al guardar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else if (comando.equals("Actualizar")) {
            vista.mostrarMensaje("Función de actualizar pendiente de implementar en el modelo.");
            
        } else if (comando.equals("Buscar")) {
            String grupoBuscado = vista.getNombreGrupo();
            if (grupoBuscado.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Ingrese el nombre del grupo a buscar en el campo correspondiente.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            GrupoDeInvestigacion encontrado = sistema.buscarGrupo(grupoBuscado);
            if (encontrado != null) {
                vista.mostrarMensaje("Grupo Encontrado!n" + encontrado.toString());
            } else {
                vista.mostrarMensaje("No se encontró ningún grupo con el nombre: " + grupoBuscado);
            }
        }
    }
}