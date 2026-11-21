package Controlador;

import Modelo.*;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;

public class Control implements ActionListener {
    private CatedralElectoral modelo;
    private JFVotacion vista;

    private JTextField txtCandidato;
    private JTextField txtRonda;
    private JComboBox<Cardenal> cmbLista;
    private JTextArea txtArea;

    private JButton btnCandidato;
    private JButton btnVotar;
    private JButton btnResultados;
    private JButton btnRonda;

    public Control(JFVotacion vista, CatedralElectoral modelo) {
        this.vista = vista;
        this.modelo = modelo;

        this.txtCandidato = vista.getTxtCandidato();
        this.txtRonda = vista.getTxtRonda();
        this.cmbLista = vista.getCmbLista();
        this.txtArea = vista.getTxtArea();

        this.btnCandidato = vista.getBtnCandidato();
        this.btnVotar = vista.getBtnVotar();
        this.btnResultados = vista.getBtnResultados();
        this.btnRonda = vista.getBtnRonda();

        this.btnCandidato.addActionListener(this);
        this.btnVotar.addActionListener(this);
        this.btnResultados.addActionListener(this);
        this.btnRonda.addActionListener(this);

        this.txtRonda.setText(String.valueOf(this.modelo.getRondaActual().getNumero()));
        this.txtRonda.setEditable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCandidato) {
            String nombre = txtCandidato.getText();
            txtArea.setText(modelo.registrarCandidato(nombre));
            ArrayList<Cardenal> lista = modelo.getCardenal();
            Cardenal c = lista.get(lista.size() - 1);
            cmbLista.addItem(c);
            txtCandidato.setText("");
        } else if (e.getSource() == btnVotar) {
            Cardenal seleccionado = (Cardenal) cmbLista.getSelectedItem();
            txtArea.setText(modelo.votacion(seleccionado));
        } else if (e.getSource() == btnResultados) {
            txtArea.setText(modelo.mostrarResultados());
        } else if (e.getSource() == btnRonda) {
            txtArea.setText(modelo.siguienteRonda());
            txtRonda.setText(String.valueOf(modelo.getRondaActual().getNumero()));
        }
    }
}