package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.*;

public class JFVecindad extends JFrame {
    private JList<String> listaPersonajes;
    private DefaultListModel<String> modeloPersonajes;
    private JList<String> listaObjetos;
    private DefaultListModel<String> modeloObjetos;

    private JTextField txtNombre;
    private JTextField txtEdad;
    private JTextField txtPersonalidad;
    private JTextField txtRol;

    private JTextField txtMensaje;
    private JComboBox<String> cmbDireccion;
    private JComboBox<String> cmbOtroPersonaje;

    private JButton btnHablar;
    private JButton btnMover;
    private JButton btnAccionEspecial;
    private JButton btnInteractuar;
    private JButton btnUsarObjeto;
    private JButton btnLimpiar;
    private JButton btnSalir;

    private JTextArea areaRegistro;
    private JLabel lblMensaje;

    public JFVecindad() {
        setTitle("La Vecindad del Chavo del 8");
        setSize(980, 780);
        setMinimumSize(new Dimension(800, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        Font fuenteNormal = new Font("Segoe UI", Font.PLAIN, 13);
        Font fuenteNegrita = new Font("Segoe UI", Font.BOLD, 13);

        JLabel lblTitulo = new JLabel("LA VECINDAD DEL CHAVO DEL 8", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 26));
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(12, 10, 4, 10));
        add(lblTitulo, BorderLayout.NORTH);

        JPanel panelCentral = new JPanel(new BorderLayout(12, 0));
        panelCentral.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));

        JPanel panelListas = new JPanel(new GridLayout(2, 1, 0, 10));
        panelListas.setPreferredSize(new Dimension(230, 100));

        modeloPersonajes = new DefaultListModel<>();
        listaPersonajes = new JList<>(modeloPersonajes);
        listaPersonajes.setFont(fuenteNormal);
        listaPersonajes.setFixedCellHeight(26);
        listaPersonajes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JPanel panelPersonajes = new JPanel(new BorderLayout());
        panelPersonajes.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Personajes"),
                BorderFactory.createEmptyBorder(0, 8, 8, 8)));
        panelPersonajes.add(new JScrollPane(listaPersonajes), BorderLayout.CENTER);
        panelListas.add(panelPersonajes);

        modeloObjetos = new DefaultListModel<>();
        listaObjetos = new JList<>(modeloObjetos);
        listaObjetos.setFont(fuenteNormal);
        listaObjetos.setFixedCellHeight(26);
        listaObjetos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JPanel panelObjetos = new JPanel(new BorderLayout());
        panelObjetos.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Objetos de la vecindad"),
                BorderFactory.createEmptyBorder(0, 8, 8, 8)));
        panelObjetos.add(new JScrollPane(listaObjetos), BorderLayout.CENTER);
        panelListas.add(panelObjetos);

        panelCentral.add(panelListas, BorderLayout.WEST);

        JPanel panelDerecha = new JPanel(new BorderLayout(0, 10));
        JPanel panelArriba = new JPanel();
        panelArriba.setLayout(new BoxLayout(panelArriba, BoxLayout.Y_AXIS));

        JPanel panelDatos = new JPanel(new GridBagLayout());
        panelDatos.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Personaje seleccionado"),
                BorderFactory.createEmptyBorder(2, 6, 8, 6)));

        GridBagConstraints gbcDatos = new GridBagConstraints();
        gbcDatos.insets = new Insets(4, 6, 4, 6);
        gbcDatos.anchor = GridBagConstraints.WEST;

        String[] etiquetasDatos = {"Nombre:", "Edad:", "Personalidad:", "Rol:"};
        txtNombre = new JTextField(20);
        txtEdad = new JTextField(20);
        txtPersonalidad = new JTextField(20);
        txtRol = new JTextField(20);
        JTextField[] camposDatos = {txtNombre, txtEdad, txtPersonalidad, txtRol};

        for (int i = 0; i < etiquetasDatos.length; i++) {
            JLabel lbl = new JLabel(etiquetasDatos[i]);
            lbl.setFont(fuenteNegrita);
            gbcDatos.gridx = 0;
            gbcDatos.gridy = i;
            gbcDatos.weightx = 0;
            gbcDatos.fill = GridBagConstraints.NONE;
            panelDatos.add(lbl, gbcDatos);

            camposDatos[i].setFont(fuenteNormal);
            camposDatos[i].setEditable(false);
            gbcDatos.gridx = 1;
            gbcDatos.weightx = 1.0;
            gbcDatos.fill = GridBagConstraints.HORIZONTAL;
            panelDatos.add(camposDatos[i], gbcDatos);
        }

        panelArriba.add(panelDatos);
        panelArriba.add(Box.createVerticalStrut(10));

        JPanel panelAcciones = new JPanel(new GridBagLayout());
        panelAcciones.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Acciones"),
                BorderFactory.createEmptyBorder(2, 6, 8, 6)));

        GridBagConstraints gbcAcc = new GridBagConstraints();
        gbcAcc.insets = new Insets(4, 6, 4, 6);
        gbcAcc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblHablar = new JLabel("Mensaje:");
        lblHablar.setFont(fuenteNegrita);
        gbcAcc.gridx = 0;
        gbcAcc.gridy = 0;
        gbcAcc.weightx = 0;
        panelAcciones.add(lblHablar, gbcAcc);

        txtMensaje = new JTextField(15);
        txtMensaje.setFont(fuenteNormal);
        gbcAcc.gridx = 1;
        gbcAcc.weightx = 1.0;
        panelAcciones.add(txtMensaje, gbcAcc);

        btnHablar = new JButton("Hablar");
        btnHablar.setFont(fuenteNegrita);
        btnHablar.setFocusPainted(false);
        btnHablar.setPreferredSize(new Dimension(150, 34));
        gbcAcc.gridx = 2;
        gbcAcc.weightx = 0;
        panelAcciones.add(btnHablar, gbcAcc);

        JLabel lblMover = new JLabel("Dirección:");
        lblMover.setFont(fuenteNegrita);
        gbcAcc.gridx = 0;
        gbcAcc.gridy = 1;
        gbcAcc.weightx = 0;
        panelAcciones.add(lblMover, gbcAcc);

        cmbDireccion = new JComboBox<>(new String[]{"el norte", "el sur", "el este", "el oeste", "el patio", "el barril"});
        cmbDireccion.setFont(fuenteNormal);
        gbcAcc.gridx = 1;
        gbcAcc.weightx = 1.0;
        panelAcciones.add(cmbDireccion, gbcAcc);

        btnMover = new JButton("Mover");
        btnMover.setFont(fuenteNegrita);
        btnMover.setFocusPainted(false);
        btnMover.setPreferredSize(new Dimension(150, 34));
        gbcAcc.gridx = 2;
        gbcAcc.weightx = 0;
        panelAcciones.add(btnMover, gbcAcc);

        JLabel lblInteractuar = new JLabel("Con personaje:");
        lblInteractuar.setFont(fuenteNegrita);
        gbcAcc.gridx = 0;
        gbcAcc.gridy = 2;
        gbcAcc.weightx = 0;
        panelAcciones.add(lblInteractuar, gbcAcc);

        cmbOtroPersonaje = new JComboBox<>();
        cmbOtroPersonaje.setFont(fuenteNormal);
        gbcAcc.gridx = 1;
        gbcAcc.weightx = 1.0;
        panelAcciones.add(cmbOtroPersonaje, gbcAcc);

        btnInteractuar = new JButton("Interactuar");
        btnInteractuar.setFont(fuenteNegrita);
        btnInteractuar.setFocusPainted(false);
        btnInteractuar.setPreferredSize(new Dimension(150, 34));
        gbcAcc.gridx = 2;
        gbcAcc.weightx = 0;
        panelAcciones.add(btnInteractuar, gbcAcc);

        btnAccionEspecial = new JButton("Acción especial");
        btnAccionEspecial.setFont(fuenteNegrita);
        btnAccionEspecial.setFocusPainted(false);
        btnAccionEspecial.setMargin(new Insets(6, 8, 6, 8));

        btnUsarObjeto = new JButton("Usar objeto seleccionado");
        btnUsarObjeto.setFont(fuenteNegrita);
        btnUsarObjeto.setFocusPainted(false);
        btnUsarObjeto.setMargin(new Insets(6, 8, 6, 8));

        JPanel panelBotonesAccion = new JPanel(new GridLayout(1, 2, 12, 0));
        panelBotonesAccion.add(btnAccionEspecial);
        panelBotonesAccion.add(btnUsarObjeto);

        gbcAcc.gridx = 0;
        gbcAcc.gridy = 3;
        gbcAcc.gridwidth = 3;
        panelAcciones.add(panelBotonesAccion, gbcAcc);

        panelArriba.add(panelAcciones);
        panelDerecha.add(panelArriba, BorderLayout.NORTH);

        JPanel panelRegistro = new JPanel(new BorderLayout());
        panelRegistro.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Lo que pasa en la vecindad"),
                BorderFactory.createEmptyBorder(0, 8, 8, 8)));

        areaRegistro = new JTextArea();
        areaRegistro.setEditable(false);
        areaRegistro.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 13));
        areaRegistro.setMargin(new Insets(8, 10, 8, 10));
        areaRegistro.setLineWrap(true);
        areaRegistro.setWrapStyleWord(true);

        panelRegistro.add(new JScrollPane(areaRegistro), BorderLayout.CENTER);
        panelDerecha.add(panelRegistro, BorderLayout.CENTER);

        panelCentral.add(panelDerecha, BorderLayout.CENTER);
        add(panelCentral, BorderLayout.CENTER);

        JPanel panelInferior = new JPanel(new BorderLayout(0, 10));
        panelInferior.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(0, 20, 12, 20),
                BorderFactory.createCompoundBorder(
                        BorderFactory.createEtchedBorder(),
                        BorderFactory.createEmptyBorder(10, 12, 10, 12))));

        lblMensaje = new JLabel(" ");
        lblMensaje.setFont(fuenteNormal);
        panelInferior.add(lblMensaje, BorderLayout.NORTH);

        btnLimpiar = new JButton("Limpiar registro");
        btnLimpiar.setFont(fuenteNegrita);
        btnLimpiar.setFocusPainted(false);
        btnLimpiar.setMargin(new Insets(6, 8, 6, 8));

        btnSalir = new JButton("Salir");
        btnSalir.setFont(fuenteNegrita);
        btnSalir.setFocusPainted(false);
        btnSalir.setMargin(new Insets(6, 8, 6, 8));

        JPanel panelBotonesInferior = new JPanel(new GridLayout(1, 2, 30, 0));
        panelBotonesInferior.add(btnLimpiar);
        panelBotonesInferior.add(btnSalir);
        panelInferior.add(panelBotonesInferior, BorderLayout.CENTER);

        add(panelInferior, BorderLayout.SOUTH);
    }

    public JList<String> getListaPersonajes() {
        return listaPersonajes;
    }

    public DefaultListModel<String> getModeloPersonajes() {
        return modeloPersonajes;
    }

    public JList<String> getListaObjetos() {
        return listaObjetos;
    }

    public DefaultListModel<String> getModeloObjetos() {
        return modeloObjetos;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public JTextField getTxtEdad() {
        return txtEdad;
    }

    public JTextField getTxtPersonalidad() {
        return txtPersonalidad;
    }

    public JTextField getTxtRol() {
        return txtRol;
    }

    public JTextField getTxtMensaje() {
        return txtMensaje;
    }

    public JComboBox<String> getCmbDireccion() {
        return cmbDireccion;
    }

    public JComboBox<String> getCmbOtroPersonaje() {
        return cmbOtroPersonaje;
    }

    public JButton getBtnHablar() {
        return btnHablar;
    }

    public JButton getBtnMover() {
        return btnMover;
    }

    public JButton getBtnAccionEspecial() {
        return btnAccionEspecial;
    }

    public JButton getBtnInteractuar() {
        return btnInteractuar;
    }

    public JButton getBtnUsarObjeto() {
        return btnUsarObjeto;
    }

    public JButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public JButton getBtnSalir() {
        return btnSalir;
    }

    public JTextArea getAreaRegistro() {
        return areaRegistro;
    }

    public JLabel getLblMensaje() {
        return lblMensaje;
    }
}