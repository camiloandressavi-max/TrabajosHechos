package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import Modelo.*;

public class JFTOperaciones extends JFrame {
    
    private JTextField txtCodigo = new JTextField(10);
    private JTextField txtNombre = new JTextField(10);
    private JTextField txtZona = new JTextField(10);
    private JTextField txtFecha = new JTextField(10);
    private JTextField txtEfectivos = new JTextField(5);
    private JComboBox<Estado> cmbEstado = new JComboBox<>(Estado.values());
    private JComboBox<String> cmbTipoOperacion = new JComboBox<>(new String[]{"Aérea", "Marítima", "Terrestre"});

    private JTextField txtNumAeronaves = new JTextField(5);
    private JTextField txtHorasEstimadas = new JTextField(5);

    private JTextField txtCantidadEmbarcaciones = new JTextField(5);
    private JTextField txtAreaMaritima = new JTextField(10);

    private JTextField txtTipoTerreno = new JTextField(10);
    private JTextField txtCantidadVehiculos = new JTextField(5);

    private JButton btnRegistrar = new JButton("Registrar Operación");
    private JButton btnLimpiar = new JButton("Limpiar Campos");

    private JTextArea txtAreaResultados = new JTextArea(8, 30);
    private JButton btnListarTodas = new JButton("Listar Todas");
    private JButton btnBuscarCodigo = new JButton("Buscar por Código");
    private JButton btnMayorComplejidad = new JButton("Operación Mayor Complejidad");
    private JTextField txtBusqueda = new JTextField(10);

    public JFTOperaciones() {
        setTitle("Sistema de Gestión - Operaciones Militares");
        setSize(750, 850);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        crearInterfaz();
        setVisible(true);
    }

    private void crearInterfaz() {
        JPanel contenedorPrincipal = new JPanel();
        contenedorPrincipal.setLayout(new BoxLayout(contenedorPrincipal, BoxLayout.Y_AXIS));

        JPanel panelBasicos = new JPanel(new GridLayout(6, 2, 5, 5));
        panelBasicos.setBorder(BorderFactory.createTitledBorder("1. Datos Básicos de la Operación"));
        panelBasicos.add(new JLabel("Tipo de Operación:"));
        panelBasicos.add(cmbTipoOperacion);
        panelBasicos.add(new JLabel("Código:"));
        panelBasicos.add(txtCodigo);
        panelBasicos.add(new JLabel("Nombre Operación:"));
        panelBasicos.add(txtNombre);
        panelBasicos.add(new JLabel("Zona:"));
        panelBasicos.add(txtZona);
        panelBasicos.add(new JLabel("Fecha (ej. 2026-10-28):"));
        panelBasicos.add(txtFecha);
        panelBasicos.add(new JLabel("Número de Efectivos:"));
        panelBasicos.add(txtEfectivos);

        JPanel panelEspecificos = new JPanel(new GridLayout(3, 4, 5, 5));
        panelEspecificos.setBorder(BorderFactory.createTitledBorder("2. Atributos Específicos"));
        panelEspecificos.add(new JLabel("Nro Aeronaves (Aérea):"));
        panelEspecificos.add(txtNumAeronaves);
        panelEspecificos.add(new JLabel("Horas Est. (Aérea):"));
        panelEspecificos.add(txtHorasEstimadas);
        
        panelEspecificos.add(new JLabel("Cant. Embarcaciones (Mar):"));
        panelEspecificos.add(txtCantidadEmbarcaciones);
        panelEspecificos.add(new JLabel("Área Marítima (Mar):"));
        panelEspecificos.add(txtAreaMaritima);

        panelEspecificos.add(new JLabel("Tipo Terreno (Terrestre):"));
        panelEspecificos.add(txtTipoTerreno);
        panelEspecificos.add(new JLabel("Cant. Vehículos (Terrestre):"));
        panelEspecificos.add(txtCantidadVehiculos);

        JPanel panelBotones = new JPanel();
        panelBotones.setBorder(BorderFactory.createTitledBorder("Acciones de Registro"));
        panelBotones.add(btnRegistrar);
        panelBotones.add(btnLimpiar);

        JPanel panelConsultas = new JPanel(new BorderLayout(5, 5));
        panelConsultas.setBorder(BorderFactory.createTitledBorder("3. Consultas y Reportes"));
        
        JPanel subMenu = new JPanel();
        subMenu.add(btnListarTodas);
        subMenu.add(new JLabel("Cód:"));
        subMenu.add(txtBusqueda);
        subMenu.add(btnBuscarCodigo);
        subMenu.add(btnMayorComplejidad);

        txtAreaResultados.setEditable(false);
        panelConsultas.add(subMenu, BorderLayout.NORTH);
        panelConsultas.add(new JScrollPane(txtAreaResultados), BorderLayout.CENTER);

        contenedorPrincipal.add(panelBasicos);
        contenedorPrincipal.add(panelEspecificos);
        contenedorPrincipal.add(panelBotones);
        contenedorPrincipal.add(panelConsultas);

        add(new JScrollPane(contenedorPrincipal));
    }

    public String getTipoOperacion(){
        return (String) cmbTipoOperacion.getSelectedItem();
    }
    public String getCodigo() {
        return txtCodigo.getText(); 
    }
    public String getNombre() {
        return txtNombre.getText();
    }
    public String getZona() { 
        return txtZona.getText();
    }
    public String getFecha() {
        return txtFecha.getText();
    }
    public String getEfectivosStr() {
        return txtEfectivos.getText();
    }
    
    public String getNumAeronavesStr() {
        return txtNumAeronaves.getText()
        ; }
    public String getHorasEstimadasStr() {
        return txtHorasEstimadas.getText();
    }
    
    public String getCantidadEmbarcacionesStr() { 
        return txtCantidadEmbarcaciones.getText();
    }
    public String getAreaMaritima() { 
        return txtAreaMaritima.getText();
    }
    
    public String getTipoTerreno() { 
        return txtTipoTerreno.getText();
    }
    public String getCantidadVehiculosStr() { 
        return txtCantidadVehiculos.getText();
    }
    
    public String getCodigoBusqueda() { 
        return txtBusqueda.getText(); 
    }
    
    public void mostrarResultados(String texto) {
        txtAreaResultados.setText(texto); 
    }
    
    public void limpiarFormulario() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtZona.setText("");
        txtFecha.setText("");
        txtEfectivos.setText("");
        txtNumAeronaves.setText("");
        txtHorasEstimadas.setText("");
        txtCantidadEmbarcaciones.setText("");
        txtAreaMaritima.setText("");
        txtTipoTerreno.setText("");
        txtCantidadVehiculos.setText("");
        txtBusqueda.setText("");
        txtCodigo.requestFocus();
    }

    public void agregarListeners(ActionListener listener) {
        btnRegistrar.addActionListener(listener);
        btnLimpiar.addActionListener(listener);
        btnListarTodas.addActionListener(listener);
        btnBuscarCodigo.addActionListener(listener);
        btnMayorComplejidad.addActionListener(listener);
    }
}