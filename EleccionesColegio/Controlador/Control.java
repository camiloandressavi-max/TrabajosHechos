package Controlador;

import Modelo.*;
import Vista.JFElecciones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Control implements ActionListener {
    private JFElecciones vista;
    private GestorElecciones gestor;

    public Control(JFElecciones vista, GestorElecciones gestor) {
        this.vista = vista;
        this.gestor = gestor;

        this.vista.getBtnRegistrarRepresentante().addActionListener(this);
        this.vista.getBtnRegistrarPersonero().addActionListener(this);
        this.vista.getBtnVotar().addActionListener(this);
        this.vista.getBtnBlancoRep().addActionListener(this);
        this.vista.getBtnVotar1().addActionListener(this);
        this.vista.getBtnBlancoPer().addActionListener(this);
        this.vista.getBtnTotal().addActionListener(this);
        this.vista.getBtnElegido().addActionListener(this);
        this.vista.getBtnCandidato().addActionListener(this);
        this.vista.getBtnVotos().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnRegistrarRepresentante()) {
            String nombre = vista.getTxtNombreRep().getText();
            String apellido = vista.getTxtApellidoRep().getText();
            String grado = vista.getTxtGradoRep().getText();
            String grupo = vista.getTxtGrupoRep().getText();
            String lema = vista.getTxtLemaRep().getText();
            String tarjetonTxt = vista.getTxtNumeroTarjetonRep().getText();
            String formula = vista.getTxtFormulaRep().getText();

            if (nombre.isEmpty() || apellido.isEmpty() || grado.isEmpty() || grupo.isEmpty()
                    || lema.isEmpty() || tarjetonTxt.isEmpty() || formula.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Complete todos los campos del representante");
            } else {
                int tarjeton = Integer.parseInt(tarjetonTxt);
                CandidatoRepresentante rep = new CandidatoRepresentante(nombre, apellido, grado, grupo, lema, tarjeton, formula);
                gestor.registrarRepresentantes(rep);
                vista.getCmbRep().addItem(rep);

                JOptionPane.showMessageDialog(vista, "Representante registrado");
            }
        } else if (e.getSource() == vista.getBtnRegistrarPersonero()) {
            String nombre = vista.getTxtNombrePer().getText();
            String apellido = vista.getTxtApellidoPer().getText();
            String grado = vista.getTxtGradoPer().getText();
            String grupo = vista.getTxtGrupoPer().getText();
            String lema = vista.getTxtLemaPer().getText();
            String tarjetonTxt = vista.getTxtNumeroTarjetonPer().getText();
            String nombreAnimal = vista.getTxtNombreAnimal().getText();
            Tipo tipoAnimal = (Tipo) vista.getCmbTipoAnimal().getSelectedItem();

            if (nombre.isEmpty() || apellido.isEmpty() || grado.isEmpty() || grupo.isEmpty()
                    || lema.isEmpty() || tarjetonTxt.isEmpty() || nombreAnimal.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Complete todos los campos del personero");
            } else {
                int tarjeton = Integer.parseInt(tarjetonTxt);
                Animal animal = new Animal(null, nombreAnimal, null, 0, null, tipoAnimal);
                CandidatoPersonero per = new CandidatoPersonero(nombre, apellido, grado, grupo, lema, tarjeton, animal);
                gestor.registrarPersoneros(per);
                vista.getCmbPer().addItem(per);

                JOptionPane.showMessageDialog(vista, "Personero registrado");
            }
        } else if (e.getSource() == vista.getBtnVotar()) {
            CandidatoRepresentante r = (CandidatoRepresentante) vista.getCmbRep().getSelectedItem();
            vista.getTxtArea().setText(gestor.votarPorRepresentante(r));
        } else if (e.getSource() == vista.getBtnBlancoRep()) {
            vista.getTxtArea().setText(gestor.votarBlancoRepresentante());
        } else if (e.getSource() == vista.getBtnVotar1()) {
            CandidatoPersonero p = (CandidatoPersonero) vista.getCmbPer().getSelectedItem();
            vista.getTxtArea1().setText(gestor.votarPorPersonero(p));
        } else if (e.getSource() == vista.getBtnBlancoPer()) {
            vista.getTxtArea1().setText(gestor.votarBlancoPersonero());
        } else if (e.getSource() == vista.getBtnTotal()) {
            CandidatoRepresentante r = (CandidatoRepresentante) vista.getCmbRep().getSelectedItem();
            CandidatoPersonero p = (CandidatoPersonero) vista.getCmbPer().getSelectedItem();
            if (r == null || p == null) {
                vista.getTxtArea2().setText("Seleccione un representante y un personero");
            } else {
                vista.getTxtArea2().setText(gestor.votosPorCandidato(r, p));
            }
        } else if (e.getSource() == vista.getBtnElegido()) {
            vista.getTxtArea2().setText(gestor.personeroElegido());
        } else if (e.getSource() == vista.getBtnCandidato()) {
            vista.getTxtArea2().setText(gestor.candidatoConMenorVotos());
        } else if (e.getSource() == vista.getBtnVotos()) {
            vista.getTxtArea2().setText(gestor.votosTotales());
        }
    }
}
