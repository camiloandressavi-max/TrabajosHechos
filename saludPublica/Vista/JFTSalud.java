package Vista;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Modelo.*;
import java.util.ArrayList;

public class JFTSalud extends JFrame implements ActionListener, ItemListener {
    
    private GestorPersona gestor = new GestorPersona();
    
    private JLabel lblTipoDoc = new JLabel("Tipo Documento");
    private JLabel lblDocumento = new JLabel("Documento");
    private JLabel lblNombre = new JLabel("Nombre");
    private JLabel lblApellido = new JLabel("Apellido");
    private JLabel lblDireccion = new JLabel("Direccion");
    private JLabel lblTelefono = new JLabel("Telefono");
    private JLabel lblEdad = new JLabel("Edad");
    private JLabel lblEstrato = new JLabel("Estrato");
    private JLabel lblEstadoCivil = new JLabel("Estado Civil");
    private JLabel lblTipo = new JLabel("Tipo");
    private JLabel lblInstitucion = new JLabel("Institucion");
    private JLabel lblEspecialidad = new JLabel("Especialidad");
    private JLabel lblNivel = new JLabel("Nivel");
    
    private JComboBox<String> cmbTipoDoc = new JComboBox<>(new String[]{"Seleccione...", "Cédula de Ciudadanía", "Tarjeta de Identidad", "Cédula de Extranjería"});
    private JTextField txtDocumento = new JTextField();
    private JTextField txtNombre = new JTextField();
    private JTextField txtApellido = new JTextField();
    private JTextField txtDireccion = new JTextField();
    private JTextField txtTelefono = new JTextField();
    private JTextField txtEdad = new JTextField();
    private JTextField txtEstrato = new JTextField();
    private JTextField txtEstadoCivil = new JTextField();
    
    private JComboBox<String> cmbTipo = new JComboBox<>(new String[]{"Seleccione...", "Profesional de Salud", "Docente", "Ciudadano"});
    private JTextField txtInstitucion = new JTextField();
    private JTextField txtEspecialidad = new JTextField();
    
    private JComboBox<String> cmbNivel = new JComboBox<>(new String[]{"Seleccione...", "Bachiller", "Técnico", "Universitario", "Maestría", "Doctorado"});
    
    private JCheckBox chkCabezaHogar = new JCheckBox("Cabeza de hogar");
    
    private JButton btnGuardar = new JButton("Guardar");
    private JButton btnLimpiar = new JButton("Limpiar");
    private JButton btnBuscar = new JButton("Buscar");
    
    private JPanel profSalud, docente, ciudadano;
    
    private JLabel lblElementoBioseguridad = new JLabel("Elemento Bioseguridad");
    private JTextField txtBioseguridad = new JTextField();
    private JLabel lblMedicina1 = new JLabel("Medicina");
    private JTextField txtMedicina1 = new JTextField();

    private JLabel lblImplementosTec = new JLabel("Implementos Tecnológicos");
    private JTextField txtImplementosTec = new JTextField();
    private JLabel lblServicioInternet = new JLabel("Servicio Internet / Energía");
    private JTextField txtServicioInternet = new JTextField();

    private JLabel lblMedicina2 = new JLabel("Medicina");
    private JTextField txtMedicina2 = new JTextField();
    private JLabel lblCanastaFamiliar = new JLabel("Canasta Familiar");
    private JTextField txtCanastaFamiliar = new JTextField();

    public JFTSalud(){
        setTitle("Registro de Salud");
        setSize(1000, 750);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        crearInterfaz();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void crearInterfaz(){
        JPanel principal = new JPanel(new GridLayout(1, 2, 5, 5));
        
        JPanel izq = new JPanel(new GridLayout(14, 2));
        izq.setBorder(BorderFactory.createTitledBorder("Registro de datos basicos"));
        izq.add(lblTipoDoc);
        izq.add(cmbTipoDoc);
        izq.add(lblDocumento);
        izq.add(txtDocumento);
        izq.add(lblNombre);
        izq.add(txtNombre);
        izq.add(lblApellido);
        izq.add(txtApellido);
        izq.add(lblDireccion);
        izq.add(txtDireccion);
        izq.add(lblTelefono);
        izq.add(txtTelefono);
        izq.add(lblEdad);
        izq.add(txtEdad);
        izq.add(lblEstrato);
        izq.add(txtEstrato);
        izq.add(lblEstadoCivil);
        izq.add(txtEstadoCivil);
        izq.add(lblTipo);
        izq.add(cmbTipo);
        izq.add(lblInstitucion);
        izq.add(txtInstitucion);
        izq.add(lblEspecialidad);
        izq.add(txtEspecialidad);
        izq.add(lblNivel);
        izq.add(cmbNivel);
        izq.add(chkCabezaHogar);
        izq.add(new JLabel(""));
        
        JPanel der = new JPanel();
        der.setLayout(new BoxLayout(der, BoxLayout.Y_AXIS));
    
        JPanel boton = new JPanel();
        boton.setBorder(BorderFactory.createTitledBorder("Panel botones"));
        boton.add(btnGuardar);
        boton.add(btnLimpiar);
        boton.add(btnBuscar);
        der.add(boton);
        
        profSalud = new JPanel(new GridLayout(2, 2));
        profSalud.setBorder(BorderFactory.createTitledBorder("Distribucion Bono Prof Salud"));
        profSalud.add(lblElementoBioseguridad);
        profSalud.add(txtBioseguridad);
        profSalud.add(lblMedicina1);
        profSalud.add(txtMedicina1);
        der.add(profSalud);
        
        docente = new JPanel(new GridLayout(2, 2));
        docente.setBorder(BorderFactory.createTitledBorder("Distribucion Bono Docente"));
        docente.add(lblImplementosTec);
        docente.add(txtImplementosTec);
        docente.add(lblServicioInternet);
        docente.add(txtServicioInternet);
        der.add(docente);
        
        ciudadano = new JPanel(new GridLayout(2, 2));
        ciudadano.setBorder(BorderFactory.createTitledBorder("Distribucion Bono Persona Independiente"));
        ciudadano.add(lblMedicina2);
        ciudadano.add(txtMedicina2);
        ciudadano.add(lblCanastaFamiliar);
        ciudadano.add(txtCanastaFamiliar);
        der.add(ciudadano);
        
        principal.add(izq);
        principal.add(der);
        
        btnGuardar.addActionListener(this);
        btnLimpiar.addActionListener(this);
        btnBuscar.addActionListener(this);
        
        txtInstitucion.setEnabled(false);
        txtEspecialidad.setEnabled(false);
        cmbNivel.setEnabled(false);
        profSalud.setVisible(false);
        docente.setVisible(false);
        ciudadano.setVisible(false);

        cmbTipo.addItemListener(this);
        add(principal); 
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == cmbTipo && e.getStateChange() == ItemEvent.SELECTED) {
            String seleccionado = (String) cmbTipo.getSelectedItem();
        
            txtInstitucion.setEnabled(false);
            txtEspecialidad.setEnabled(false);
            cmbNivel.setEnabled(false);
            profSalud.setVisible(false);
            docente.setVisible(false);
            ciudadano.setVisible(false);
            
            if ("Profesional de Salud".equals(seleccionado)) {
                txtInstitucion.setEnabled(true);
                txtEspecialidad.setEnabled(true);
                profSalud.setVisible(true); 
            } else if ("Docente".equals(seleccionado)) {
                txtInstitucion.setEnabled(true);
                cmbNivel.setEnabled(true); 
                docente.setVisible(true);  
            } else if ("Ciudadano".equals(seleccionado)) {
                ciudadano.setVisible(true); 
            }
        }
    }
    
    public void limpiarFormulario() {
        cmbTipoDoc.setSelectedIndex(0);
        txtDocumento.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtEdad.setText("");
        txtEstrato.setText("");
        txtEstadoCivil.setText("");
        cmbTipo.setSelectedIndex(0);
        txtInstitucion.setText("");
        txtEspecialidad.setText("");
        cmbNivel.setSelectedIndex(0);
        chkCabezaHogar.setSelected(false);
        
        txtBioseguridad.setText("");
        txtMedicina1.setText("");
        txtImplementosTec.setText("");
        txtServicioInternet.setText("");
        txtMedicina2.setText("");
        txtCanastaFamiliar.setText("");
        
        txtDocumento.requestFocus();
    }
    
    public void actionPerformed(ActionEvent e) {
        String c = e.getActionCommand();
       
        
        if (c.equals("Guardar")) {
            String tipoDoc = (String) cmbTipoDoc.getSelectedItem();
            String documento = txtDocumento.getText();
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();
            String direccion = txtDireccion.getText();
            String telefono = txtTelefono.getText();
            
            int edad = Integer.parseInt(txtEdad.getText());
            
            String estrato = txtEstrato.getText();
            String estadoCivil = txtEstadoCivil.getText();
            boolean cabeza = chkCabezaHogar.isSelected();
            String tipoSeleccionado = (String) cmbTipo.getSelectedItem();

            boolean guardado = false;

            if ("Profesional de Salud".equals(tipoSeleccionado)) {
                String institucion = txtInstitucion.getText();
                String especialidad = txtEspecialidad.getText();

                ProfesionalSalud prof = new ProfesionalSalud(tipoDoc, documento, nombre, apellido, direccion, telefono, edad, estrato, estadoCivil, cabeza, institucion, especialidad, null);
                
                if (!txtMedicina1.getText().isEmpty()) {
                    prof.getMedicina().add(new Medicina(Integer.parseInt(txtMedicina1.getText())));
                }

                guardado = gestor.agregarPersona(prof);

            } else if ("Docente".equals(tipoSeleccionado)) {
                String institucion = txtInstitucion.getText();
                String nivel = (String) cmbNivel.getSelectedItem();

                Docente doc = new Docente(tipoDoc, documento, nombre, apellido, direccion, telefono, edad, estrato, estadoCivil, cabeza, institucion, nivel);
                guardado = gestor.agregarPersona(doc);

            } else if ("Ciudadano".equals(tipoSeleccionado)) {
                Ciudadano ciudadanoObj = new Ciudadano(tipoDoc, documento, nombre, apellido, direccion, telefono, edad, estrato, estadoCivil, cabeza, null);

                if (!txtMedicina2.getText().isEmpty()) {
                    ciudadanoObj.getMedicina().add(new Medicina(Integer.parseInt(txtMedicina2.getText())));
                }

                if (!txtCanastaFamiliar.getText().isEmpty()) {
                    ciudadanoObj.getProductos().add(new ProductosCanasta(Integer.parseInt(txtCanastaFamiliar.getText())));
                }

                guardado = gestor.agregarPersona(ciudadanoObj);
            }

            if (guardado) {
                JOptionPane.showMessageDialog(this, "¡Persona registrada con éxito!");
                limpiarFormulario();
            }
            
        } else if (c.equals("Limpiar")) {
            limpiarFormulario();
            
        } else if (c.equals("Buscar")) {
            String docBuscado = txtDocumento.getText();
            Persona encontrada = gestor.buscarPersona(docBuscado);
            
            if (encontrada != null) {
                JOptionPane.showMessageDialog(this, "¡Persona encontrada!\n" + encontrada.toString());
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró ninguna persona con ese documento.");
            }
        }
    }

}