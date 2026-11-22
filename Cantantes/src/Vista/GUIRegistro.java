/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUIRegistro extends JFrame{
    JPanel panel;
    public JButton btnRegistrar;
    public JButton btnTerminarRegistro;
    JLabel lblNombre;
    JLabel lblAlbum;
    JLabel lblNCanciones;
    public JTextField txtNombre;    
    public JTextField txtAlbum;
    public JTextField txtNCanciones;
    public GUIRegistro(){
        super("Registrar cantantes");
        super.setSize(300, 250);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(3);
        initComponents();
    }

    private void initComponents() {
        panel= new JPanel(new GridLayout(4, 4, 5, 5));
        panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro"));
        lblNombre= new JLabel("Nombre");
        lblAlbum= new JLabel("Ultimo album");
        lblNCanciones= new JLabel("Numero de canciones");
        txtNombre= new JTextField();
        txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
        txtAlbum= new JTextField();
        txtAlbum.setHorizontalAlignment(SwingConstants.CENTER);
        txtNCanciones= new JTextField();
        txtNCanciones.setHorizontalAlignment(SwingConstants.CENTER);
        btnRegistrar= new JButton("Registrar");
        btnTerminarRegistro= new JButton("Terminar registro");
        panel.add(lblNombre);
        panel.add(txtNombre);
        panel.add(lblAlbum);
        panel.add(txtAlbum);
        panel.add(lblNCanciones);
        panel.add(txtNCanciones);
        panel.add(btnRegistrar);
        panel.add(btnTerminarRegistro);
        this.add(panel);
    }    

    public void agragarListener(ActionListener e){
        btnRegistrar.addActionListener(e);
        btnTerminarRegistro.addActionListener(e);
    }
    
    public void mostrarMensaje(Integer i) {
        switch(i){
            case 1 : JOptionPane.showMessageDialog(this, "Datos invalidos", "Entrada invalida", JOptionPane.ERROR_MESSAGE);
            break;
            case 2 : JOptionPane.showMessageDialog(this, "Datos incompletos", "Llenar campos faltantes", JOptionPane.WARNING_MESSAGE);
            break;
        }
    }
}
