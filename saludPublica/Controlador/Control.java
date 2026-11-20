package Controlador;
import javax.swing.*;
import Vista.*;
import Modelo.*;
import java.awt.event.*;

public class Control implements ActionListener, ItemListener {
    private GestorPersona modelo;
    private JFTSalud vista;
    
    private JComboBox<String> cmbTipoDoc;
    private JComboBox<String> cmbTipo;
    private JComboBox<String> cmbNivel;

    private JTextField txtDocumento;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    private JTextField txtEdad;
    private JTextField txtEstrato;
    private JTextField txtEstadoCivil;
    private JTextField txtInstitucion;
    private JTextField txtEspecialidad;
    private JTextField txtBioseguridad;
    private JTextField txtMedicina1;
    private JTextField txtImplementosTec;
    private JTextField txtServicioInternet;
    private JTextField txtMedicina2;
    private JTextField txtCanastaFamiliar;

    private JCheckBox chkCabezaHogar;

    private JButton btnGuardar;
    private JButton btnLimpiar;
    private JButton btnBuscar;

    private JPanel profSalud;
    private JPanel docente;
    private JPanel ciudadano;

    public Control(JFTSalud vista, GestorPersona modelo) {
        this.vista = vista;
        this.modelo = modelo;

        this.cmbTipoDoc = vista.getCmbTipoDoc();
        this.cmbTipo = vista.getCmbTipo();
        this.cmbNivel = vista.getCmbNivel();

        this.txtDocumento = vista.getTxtDocumento();
        this.txtNombre = vista.getTxtNombre();
        this.txtApellido = vista.getTxtApellido();
        this.txtDireccion = vista.getTxtDireccion();
        this.txtTelefono = vista.getTxtTelefono();
        this.txtEdad = vista.getTxtEdad();
        this.txtEstrato = vista.getTxtEstrato();
        this.txtEstadoCivil = vista.getTxtEstadoCivil();
        this.txtInstitucion = vista.getTxtInstitucion();
        this.txtEspecialidad = vista.getTxtEspecialidad();
        this.txtBioseguridad = vista.getTxtBioseguridad();
        this.txtMedicina1 = vista.getTxtMedicina1();
        this.txtImplementosTec = vista.getTxtImplementosTec();
        this.txtServicioInternet = vista.getTxtServicioInternet();
        this.txtMedicina2 = vista.getTxtMedicina2();
        this.txtCanastaFamiliar = vista.getTxtCanastaFamiliar();

        this.chkCabezaHogar = vista.getChkCabezaHogar();

        this.btnGuardar = vista.getBtnGuardar();
        this.btnLimpiar = vista.getBtnLimpiar();
        this.btnBuscar = vista.getBtnBuscar();

        this.profSalud = vista.getProfSalud();
        this.docente = vista.getDocente();
        this.ciudadano = vista.getCiudadano();

        this.btnGuardar.addActionListener(this);
        this.btnLimpiar.addActionListener(this);
        this.btnBuscar.addActionListener(this);
        this.cmbTipo.addItemListener(this);
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
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnGuardar)) {
            if (txtDocumento.getText().isEmpty() || txtNombre.getText().isEmpty() || txtEdad.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Complete los datos básicos obligatorios.");
                return;
            }

            String tipoDoc = (String) cmbTipoDoc.getSelectedItem();
            String doc = txtDocumento.getText();
            String nom = txtNombre.getText();
            String ape = txtApellido.getText();
            String dir = txtDireccion.getText();
            String tel = txtTelefono.getText();
            int edad = Integer.parseInt(txtEdad.getText());
            String est = txtEstrato.getText();
            String civ = txtEstadoCivil.getText();
            boolean cab = chkCabezaHogar.isSelected();
            String tipo = (String) cmbTipo.getSelectedItem();

            Persona p = null;

            if ("Profesional de Salud".equals(tipo)) {
                ProfesionalSalud ps = new ProfesionalSalud(tipoDoc, doc, nom, ape, dir, tel, edad, est, civ, cab, txtInstitucion.getText(), txtEspecialidad.getText(), null);
                if (!txtBioseguridad.getText().isEmpty()) {
                    ps.getBioseguridad().add(new ElementoBioseguridad(Integer.parseInt(txtBioseguridad.getText())));
                }
                if (!txtMedicina1.getText().isEmpty()) {
                    ps.getMedicina().add(new Medicina(Integer.parseInt(txtMedicina1.getText())));
                }
                p = ps;

            } else if ("Docente".equals(tipo)) {
                Docente d = new Docente(tipoDoc, doc, nom, ape, dir, tel, edad, est, civ, cab, txtInstitucion.getText(), (String) cmbNivel.getSelectedItem());
                if (!txtImplementosTec.getText().isEmpty()) {
                    d.getTecno().add(new ImplementosTecnologicos(Integer.parseInt(txtImplementosTec.getText())));
                }
                if (!txtServicioInternet.getText().isEmpty()) {
                    d.getServicio().add(new ServicioInternet(Integer.parseInt(txtServicioInternet.getText())));
                }
                p = d;

            } else if ("Ciudadano".equals(tipo)) {
                Ciudadano c = new Ciudadano(tipoDoc, doc, nom, ape, dir, tel, edad, est, civ, cab, null);
                if (!txtMedicina2.getText().isEmpty()) {
                    c.getMedicina().add(new Medicina(Integer.parseInt(txtMedicina2.getText())));
                }
                if (!txtCanastaFamiliar.getText().isEmpty()) {
                    c.getProductos().add(new ProductosCanasta(Integer.parseInt(txtCanastaFamiliar.getText())));
                }
                p = c;
            }

            if (modelo.guardar(p)) {
                JOptionPane.showMessageDialog(vista, "Guardado con éxito");
                limpiarFormulario();
            } else {
                JOptionPane.showMessageDialog(vista, "No se pudo guardar");
            }

        } else if (e.getSource().equals(btnLimpiar)) {
            limpiarFormulario();

        } else if (e.getSource().equals(btnBuscar)) {
            Persona encontrada = modelo.buscarPersona(txtDocumento.getText());
            if (encontrada != null) {
                JOptionPane.showMessageDialog(vista, encontrada.toString());
            } else {
                JOptionPane.showMessageDialog(vista, "No encontrado");
            }
        }
    }
}