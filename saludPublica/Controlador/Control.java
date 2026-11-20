package Controlador;
import javax.swing.*;
import Vista.*;
import Modelo.*;
import java.awt.event.*;

/**
 * Write a description of class Control here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Control implements ActionListener,ItemListener
{
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
    
    @Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btnGuardar) {
        String documentoBuscado= txtDocumento.getText();
        
        if(modelo.buscarPersona(documentoBuscado)==null){
            JOptionPane.showMessageDialog(vista,
        }
    } else if (e.getSource() == btnLimpiar) {
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
    } else if (e.getSource() == btnBuscar) {
        String docBuscado = txtDocumento.getText();
        Persona encontrada = modelo.buscarPersona(docBuscado);
        
        if (encontrada != null) {
            JOptionPane.showMessageDialog(vista, "¡Persona encontrada!\n" + encontrada.toString());
        } else {
            JOptionPane.showMessageDialog(vista, "No se encontró ninguna persona con ese documento.");
        }
    }
}
}