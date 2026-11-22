/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author SAMSUNG E1
 */
public class GUIConfiguracion extends JFrame{
    JScrollPane scrollShow1;
    JScrollPane scrollShow2;
    public JTextArea txtShow1;
    public JTextArea txtShow2;
    JPanel confPanel;
    public JTextField txtBuscar;
    public JTextField txtEliminar; 
    public JButton btnBuscar;
    public JButton btnEliminar;
    public GUIConfiguracion(){
        super("Configuracion de registro");
        super.setSize(400, 400);
        super.setLayout(new GridLayout(3, 1));
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(3);
            
        initComponents();
    }

    private void initComponents() {        
        txtShow1= new JTextArea();
        txtShow1.setEditable(false);
        txtShow1.setForeground(Color.BLUE);
        txtShow1.setBackground(Color.WHITE);
        scrollShow1= new JScrollPane(txtShow1);
        scrollShow1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cantantes registrados"));
        this.add(scrollShow1);
        
        confPanel= new JPanel(new GridLayout(2, 2, 5, 5));
        confPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Configuraciones"));
        btnBuscar= new JButton("Buscar por # de canciones");
        btnEliminar= new JButton("Eliminar por  nombre");
        txtBuscar= new JTextField();
        txtBuscar.setHorizontalAlignment(SwingConstants.CENTER);
        txtEliminar= new JTextField();
        txtEliminar.setHorizontalAlignment(SwingConstants.CENTER);
        confPanel.add(btnBuscar);
        confPanel.add(txtBuscar);
        confPanel.add(btnEliminar);
        confPanel.add(txtEliminar);
        this.add(confPanel);

        txtShow2= new JTextArea();
        scrollShow2= new JScrollPane(txtShow2);
        scrollShow2.setBorder(javax.swing.BorderFactory.createTitledBorder("Busqueda"));
        txtShow2.setEditable(false);
        txtShow2.setForeground(Color.BLUE);
        txtShow2.setBackground(Color.WHITE);
        this.add(scrollShow2);
    }
    
    public void agregarListener(ActionListener e){
        btnBuscar.addActionListener(e);
        btnEliminar.addActionListener(e);
    }
}
