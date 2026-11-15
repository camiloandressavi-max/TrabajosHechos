package Vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.lang.*;

public class JFTGestion extends JFrame {
    private JTextField txtNumeroPedido;
    private JTextField txtCedula;
    private JTextField txtNombreCliente;
    private JTextField txtCodigoProducto;
    private JTextField txtNombreProducto;
    private JTextField txtPrecio;
    private JButton btnAgregarProducto;
    private JButton btnEliminarProducto;
    private JButton btnNuevoPedido;
    private JButton btnLimpiar;
    private JButton btnSalir;
    private JTable tablaProductos;
    private DefaultTableModel modeloTabla;
    private JLabel lblTotal;

    public JFTGestion() {
        setTitle("Gestión de Pedidos");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        crearTitulo();
        crearPanelCentral();
        crearPanelInferior();

        setVisible(true);
    }

    private void crearTitulo() {
        JPanel titulo = new JPanel();
        JLabel lbltitulo1 = new JLabel("GESTIÓN DE PEDIDOS", SwingConstants.CENTER);
        lbltitulo1.setFont(new Font("Arial", Font.BOLD, 28));
        lbltitulo1.setIcon(cargarIcono("carrito.png", 35, 35));
        lbltitulo1.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));

        add(lbltitulo1, BorderLayout.NORTH);
    }

    private void crearPanelCentral() {
        JPanel central = new JPanel();
        central.setLayout(new BoxLayout(central, BoxLayout.Y_AXIS));
        central.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        central.add(crearPanelPedidoCliente());
        central.add(Box.createVerticalStrut(10));
        central.add(crearPanelProducto());
        central.add(Box.createVerticalStrut(10));
        central.add(crearPanelTabla());

        add(central, BorderLayout.CENTER);
    }

    private JPanel crearPanelPedidoCliente() {
        JPanel panel = new JPanel(new GridLayout(1, 2, 15, 0));

        JPanel panelPedido = new JPanel(new GridBagLayout());
        panelPedido.setBorder(BorderFactory.createTitledBorder("Datos del Pedido"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;

        panelPedido.add(new JLabel("Número de pedido:"), gbc);

        txtNumeroPedido = new JTextField(12);
        gbc.gridx = 1;

        panelPedido.add(txtNumeroPedido, gbc);

        JPanel panelCliente = new JPanel(new GridBagLayout());
        panelCliente.setBorder(BorderFactory.createTitledBorder("Datos del Cliente"));

        GridBagConstraints gbcCliente = new GridBagConstraints();
        gbcCliente.insets = new Insets(5, 10, 5, 10);

        gbcCliente.gridx = 0;
        gbcCliente.gridy = 0;

        panelCliente.add(new JLabel("Cédula:"), gbcCliente);
        txtCedula = new JTextField(15);
        gbcCliente.gridx = 1;
        panelCliente.add(txtCedula, gbcCliente);

        gbcCliente.gridx = 0;
        gbcCliente.gridy = 1;

        panelCliente.add(new JLabel("Nombre:"), gbcCliente);
        txtNombreCliente = new JTextField(15);

        gbcCliente.gridx = 1;
        panelCliente.add(txtNombreCliente, gbcCliente);

        panel.add(panelPedido);
        panel.add(panelCliente);
        return panel;
    }

    private JPanel crearPanelProducto() {
        JPanel panelProducto = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 15));
        panelProducto.setBorder(BorderFactory.createTitledBorder("Datos del Producto"));

        panelProducto.add(new JLabel("Código:"));
        txtCodigoProducto = new JTextField(8);
        panelProducto.add(txtCodigoProducto);

        panelProducto.add(new JLabel("Nombre:"));
        txtNombreProducto = new JTextField(15);
        panelProducto.add(txtNombreProducto);

        panelProducto.add(new JLabel("Precio:"));
        txtPrecio = new JTextField(10);
        panelProducto.add(txtPrecio);

        btnAgregarProducto = new JButton("Agregar Producto");
        btnAgregarProducto.setIcon(cargarIcono("agregar.png", 18, 18));
        panelProducto.add(btnAgregarProducto);

        return panelProducto;
    }

    private JPanel crearPanelTabla() {
        JPanel panelTabla = new JPanel(new BorderLayout(10, 10));
        panelTabla.setBorder(BorderFactory.createTitledBorder("Productos del Pedido"));

        String[] columnas = {"Código", "Nombre", "Precio"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };

        tablaProductos = new JTable(modeloTabla);
        tablaProductos.setRowHeight(25);
        tablaProductos.setShowGrid(true);
        tablaProductos.setGridColor(Color.LIGHT_GRAY);

        JScrollPane scroll = new JScrollPane(tablaProductos);
        scroll.getViewport().setBackground(Color.WHITE);
        panelTabla.add(scroll, BorderLayout.CENTER);

        btnEliminarProducto = new JButton("Eliminar Producto");
        btnEliminarProducto.setIcon(cargarIcono("eliminar.png", 18, 18));

        JPanel panelEliminar = new JPanel();
        panelEliminar.add(btnEliminarProducto);
        panelTabla.add(panelEliminar, BorderLayout.EAST);

        return panelTabla;
    }

    private void crearPanelInferior() {
        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.Y_AXIS));

        JPanel panelTotal = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 10));
        panelTotal.setBackground(new Color(225, 235, 245));
        panelTotal.setOpaque(true);

        JLabel lblTextoTotal = new JLabel("TOTAL DEL PEDIDO:");
        lblTextoTotal.setFont(new Font("Arial", Font.BOLD, 18));

        lblTotal = new JLabel("$ 0");
        lblTotal.setFont(new Font("Arial", Font.BOLD, 24));
        lblTotal.setForeground(new Color(10, 40, 90));

        panelTotal.add(lblTextoTotal);
        panelTotal.add(lblTotal);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));

        btnNuevoPedido = new JButton("Nuevo Pedido");
        btnNuevoPedido.setIcon(cargarIcono("nuevo.png", 18, 18));

        btnLimpiar = new JButton("Limpiar Campos");
        btnLimpiar.setIcon(cargarIcono("limpiar.png", 18, 18));

        btnSalir = new JButton("Salir");
        btnSalir.setIcon(cargarIcono("salir.png", 18, 18));

        panelBotones.add(btnNuevoPedido);
        panelBotones.add(btnLimpiar);
        panelBotones.add(btnSalir);

        panelInferior.add(panelTotal);
        panelInferior.add(panelBotones);

        add(panelInferior, BorderLayout.SOUTH);
    }

    private ImageIcon cargarIcono(String nombreArchivo, int ancho, int alto) {
        java.net.URL url = getClass().getResource("/Images/" + nombreArchivo);
        if (url != null) {
            ImageIcon iconoOriginal = new ImageIcon(url);
            Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
            return new ImageIcon(imagenEscalada);
        } else {
            return null;
        }
    }
    
    public JTextField getTxtNumeroPedido() {
        return txtNumeroPedido;
    }

    public JTextField getTxtCedula() {
        return txtCedula;
    }

    public JTextField getTxtNombreCliente() {
        return txtNombreCliente;
    }

    public JTextField getTxtCodigoProducto() {
        return txtCodigoProducto;
    }

    public JTextField getTxtNombreProducto() {
        return txtNombreProducto;
    }

    public JTextField getTxtPrecio() {
        return txtPrecio;
    }

    public JButton getBtnAgregarProducto() {
        return btnAgregarProducto;
    }

    public JButton getBtnEliminarProducto() {
        return btnEliminarProducto;
    }

    public JButton getBtnNuevoPedido() {
        return btnNuevoPedido;
    }

    public JButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public JButton getBtnSalir() {
        return btnSalir;
    }

    public JTable getTablaProductos() {
        return tablaProductos;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    public JLabel getLblTotal() {
        return lblTotal;
    }
}