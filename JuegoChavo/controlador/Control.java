package controlador;

import modelo.*;
import vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Control implements ActionListener, ListSelectionListener {
    private JFVecindad vista;
    private Vecindad modelo;

    public Control(Vecindad modelo, JFVecindad vista) {
        this.modelo = modelo;
        this.vista = vista;

        cargarListas();
        registrar("Bienvenido a la vecindad. Selecciona un personaje y elige una acción.");
        mensaje("Seleccione un personaje de la lista");

        this.vista.getListaPersonajes().addListSelectionListener(this);
        this.vista.getBtnHablar().addActionListener(this);
        this.vista.getBtnMover().addActionListener(this);
        this.vista.getBtnAccionEspecial().addActionListener(this);
        this.vista.getBtnInteractuar().addActionListener(this);
        this.vista.getBtnUsarObjeto().addActionListener(this);
        this.vista.getBtnLimpiar().addActionListener(this);
        this.vista.getBtnSalir().addActionListener(this);

        this.vista.getListaPersonajes().setSelectedIndex(0);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            mostrarDatosPersonaje();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnHablar()) {
            Personaje p = personajeSeleccionado();
            if (p != null) {
                String texto = vista.getTxtMensaje().getText().trim();
                if (texto.isEmpty()) {
                    mensaje("Escriba lo que quiere que diga " + p.getNombre());
                } else {
                    registrar(p.hablar(texto));
                    vista.getTxtMensaje().setText("");
                    mensaje(p.getNombre() + " habló");
                }
            }
        } else if (e.getSource() == vista.getBtnMover()) {
            Personaje p = personajeSeleccionado();
            if (p != null) {
                String direccion = (String) vista.getCmbDireccion().getSelectedItem();
                registrar(p.mover(direccion));
                mensaje(p.getNombre() + " se movió");
            }
        } else if (e.getSource() == vista.getBtnAccionEspecial()) {
            Personaje p = personajeSeleccionado();
            if (p != null) {
                registrar(p.accionEspecial());
                mensaje("Acción especial de " + p.getNombre());
            }
        } else if (e.getSource() == vista.getBtnInteractuar()) {
            Personaje p = personajeSeleccionado();
            if (p != null) {
                int indiceOtro = vista.getCmbOtroPersonaje().getSelectedIndex();
                if (indiceOtro < 0) {
                    mensaje("Elija con qué personaje quiere interactuar");
                } else {
                    Personaje otro = modelo.getPersonajes().get(indiceOtro);
                    if (otro == p) {
                        mensaje("Elija un personaje diferente al seleccionado");
                    } else {
                        registrar(p.interactuarCon(otro));
                        mensaje(p.getNombre() + " interactuó con " + otro.getNombre());
                    }
                }
            }
        } else if (e.getSource() == vista.getBtnUsarObjeto()) {
            Personaje p = personajeSeleccionado();
            if (p != null) {
                int indiceObjeto = vista.getListaObjetos().getSelectedIndex();
                if (indiceObjeto < 0) {
                    mensaje("Seleccione un objeto de la lista de objetos");
                } else {
                    ObjetoInteractivo objeto = modelo.getObjetos().get(indiceObjeto);
                    registrar(p.interactuar(objeto));
                    mensaje(p.getNombre() + " usó: " + objeto.getNombre());
                }
            }
        } else if (e.getSource() == vista.getBtnLimpiar()) {
            vista.getAreaRegistro().setText("");
            mensaje("Registro limpiado");
        } else if (e.getSource() == vista.getBtnSalir()) {
            System.exit(0);
        }
    }

    private void cargarListas() {
        for (Personaje p : modelo.getPersonajes()) {
            vista.getModeloPersonajes().addElement(p.getNombre());
            vista.getCmbOtroPersonaje().addItem(p.getNombre());
        }
        for (ObjetoInteractivo o : modelo.getObjetos()) {
            vista.getModeloObjetos().addElement(o.getNombre());
        }
    }

    private Personaje personajeSeleccionado() {
        int indice = vista.getListaPersonajes().getSelectedIndex();
        if (indice < 0) {
            mensaje("Seleccione un personaje de la lista");
            return null;
        }
        return modelo.getPersonajes().get(indice);
    }

    private void mostrarDatosPersonaje() {
        int indice = vista.getListaPersonajes().getSelectedIndex();
        if (indice < 0) {
            vista.getTxtNombre().setText("");
            vista.getTxtEdad().setText("");
            vista.getTxtPersonalidad().setText("");
            vista.getTxtRol().setText("");
            return;
        }
        Personaje p = modelo.getPersonajes().get(indice);
        vista.getTxtNombre().setText(p.getNombre());
        vista.getTxtEdad().setText("" + p.getEdad());
        vista.getTxtPersonalidad().setText(p.getPersonalidad());
        vista.getTxtRol().setText(p.getRol());
        mensaje("Personaje seleccionado: " + p.getNombre());
    }

    private void registrar(String texto) {
        vista.getAreaRegistro().append("• " + texto + "\n");
        vista.getAreaRegistro().setCaretPosition(vista.getAreaRegistro().getDocument().getLength());
    }

    private void mensaje(String texto) {
        vista.getLblMensaje().setText(texto);
    }
}