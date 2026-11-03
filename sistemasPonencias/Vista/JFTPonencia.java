package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JFTPonencia extends JFrame {
    private JLabel lblNombre = new JLabel("Nombre Del Grupo: ");
    private JTextField txtNombre = new JTextField();
    
    private JLabel lblDirector = new JLabel("Director Del Grupo: ");
    private JTextField txtDirector = new JTextField();
    
    private JLabel lblLinea = new JLabel("Linea De Investigacion: ");
    private JTextField txtLinea = new JTextField();
    
    private JLabel lblPonencia = new JLabel("Titulo Ponencia: ");
    private JTextField txtPonencia = new JTextField();
    
    private JLabel lblTipo = new JLabel("Tipo De Ponencia: ");
    private JComboBox<String> cmbTipo = new JComboBox<>(new String[]{"Seleccionar", "Oral", "Poster"});
     
    private JButton btnGuardar = new JButton("Guardar");
    private JButton btnActualizar = new JButton("Actualizar");
    private JButton btnBuscar = new JButton("Buscar");
    
    private JTextArea txtArea = new JTextArea();
    private JScrollPane s = new JScrollPane(txtArea);
    
    public JFTPonencia() {
        setTitle("Sistema de gestion de ponencias y grupos");
        setSize(650, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        crearInterfaz();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void crearInterfaz() {
        JPanel principal = new JPanel();
        principal.setLayout(new BoxLayout(principal, BoxLayout.Y_AXIS));
        
        JPanel datos = new JPanel();
        datos.setLayout(new GridLayout(5, 2, 5, 5));
        datos.setBorder(BorderFactory.createTitledBorder("Datos Básicos"));
        
        datos.add(lblNombre);
        datos.add(txtNombre);
        datos.add(lblDirector);
        datos.add(txtDirector);
        datos.add(lblLinea);
        datos.add(txtLinea);
        datos.add(lblPonencia);
        datos.add(txtPonencia);
        datos.add(lblTipo);
        datos.add(cmbTipo);
        
        principal.add(datos);
        
        JPanel botones = new JPanel();
        botones.setBorder(BorderFactory.createTitledBorder("Botones"));
        botones.add(btnGuardar);
        botones.add(btnActualizar);
        botones.add(btnBuscar);
        
        principal.add(botones);
        
        JPanel area = new JPanel(new BorderLayout());
        area.setBorder(BorderFactory.createTitledBorder("Resultados / Consola"));
        txtArea.setEditable(false);
        area.add(s, BorderLayout.CENTER);
        principal.add(area);
        
        add(principal);
    }

    public String getNombreGrupo() {
        return txtNombre.getText();
    }
    public String getDirectorGrupo() {
        return txtDirector.getText();
    }
    public String getLineaInvestigacion() {
        return txtLinea.getText(); 
    }
    public String getTituloPonencia() {
        return txtPonencia.getText();
    }
    public String getTipoPonencia() { 
        return (String) cmbTipo.getSelectedItem();
    }
    
    public void mostrarMensaje(String mensaje) {
        txtArea.setText(mensaje);
    }

    public void limpiarFormulario() {
        txtNombre.setText("");
        txtDirector.setText("");
        txtLinea.setText("");
        txtPonencia.setText("");
        cmbTipo.setSelectedIndex(0);
        txtNombre.requestFocus();
    }

    public void agregarListeners(ActionListener listener) {
        btnGuardar.addActionListener(listener);
        btnActualizar.addActionListener(listener);
        btnBuscar.addActionListener(listener);
    }
}