package Controlador;

import Modelo.*;
import Vista.*;
import java.awt.event.*;
/**
 * Write a description of class Control here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Control implements ActionListener
{
    private JFBiblioteca vista;
    private GestionBiblioteca gestion;

    public Control(JFBiblioteca vista, GestionBiblioteca gestion) {
        this.vista = new JFBiblioteca();
        this.gestion = new GestionBiblioteca();

        this.vista.getBtnDevolucion().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.getBtnDevolucion()){
            String nombre= vista.getTxtNombre().getText();
            String cedula= vista.getTxtCedula().getText();
            String queEs= (String) vista.getCmbQueEs().getSelectedItem();
            Persona p1= null;
            if(queEs.equals("Estudiante")){
                p1= new Estudiante(nombre,cedula,18);
                
            }else if (queEs.equals("Docente")) {
                p1 = new Docente(nombre, cedula, 30);
            } else if (queEs.equals("Administrativo")) {
                p1 = new Administrativo(nombre, cedula, 25);
            }
            String titulo = vista.getTxtTituloLibro().getText();
            int issn = Integer.parseInt(vista.getTxtIssn().getText());
            Tipo tipo = (Tipo) vista.getCmbLibro().getSelectedItem();
            Libro libro = new Libro(titulo, "Autor", issn, 2024, "Editorial", tipo);

            int d1 = Integer.parseInt(vista.getTxtDiaPrestamo().getText());
            int m1 = Integer.parseInt(vista.getTxtMesPrestamo().getText());
            int a1 = Integer.parseInt(vista.getTxtAnioPrestamo().getText());
            Fecha fPrestamo = new Fecha(d1, m1, a1);

            int d2 = Integer.parseInt(vista.getTxtDiaDevolucion().getText());
            int m2 = Integer.parseInt(vista.getTxtMesDevolucion().getText());
            int a2 = Integer.parseInt(vista.getTxtAnioDevolucion().getText());
            Fecha fDevolucion = new Fecha(d2, m2, a2);

            Prestamo p = new Prestamo(fPrestamo, fDevolucion, Estado.PRESTADO, p1, libro);
            String respuesta = gestion.devolucion(p);
            vista.getTxtArea().setText(respuesta);
        }
    }
}