package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JFTSalud extends JFrame  {
    
    
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
        
        txtInstitucion.setEnabled(false);
        txtEspecialidad.setEnabled(false);
        cmbNivel.setEnabled(false);
        profSalud.setVisible(false);
        docente.setVisible(false);
        ciudadano.setVisible(false);

        add(principal); 
    }

    public JComboBox<String> getCmbTipoDoc() {
        return cmbTipoDoc;
    }

    public void setCmbTipoDoc(JComboBox<String> cmbTipoDoc) {
        this.cmbTipoDoc = cmbTipoDoc;
    }

    public JTextField getTxtDocumento() {
        return txtDocumento;
    }

    public void setTxtDocumento(JTextField txtDocumento) {
        this.txtDocumento = txtDocumento;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextField getTxtApellido() {
        return txtApellido;
    }

    public void setTxtApellido(JTextField txtApellido) {
        this.txtApellido = txtApellido;
    }

    public JTextField getTxtDireccion() {
        return txtDireccion;
    }

    public void setTxtDireccion(JTextField txtDireccion) {
        this.txtDireccion = txtDireccion;
    }

    public JTextField getTxtTelefono() {
        return txtTelefono;
    }

    public void setTxtTelefono(JTextField txtTelefono) {
        this.txtTelefono = txtTelefono;
    }

    public JTextField getTxtEdad() {
        return txtEdad;
    }

    public void setTxtEdad(JTextField txtEdad) {
        this.txtEdad = txtEdad;
    }

    public JTextField getTxtEstrato() {
        return txtEstrato;
    }

    public void setTxtEstrato(JTextField txtEstrato) {
        this.txtEstrato = txtEstrato;
    }

    public JTextField getTxtEstadoCivil() {
        return txtEstadoCivil;
    }

    public void setTxtEstadoCivil(JTextField txtEstadoCivil) {
        this.txtEstadoCivil = txtEstadoCivil;
    }

    public JComboBox<String> getCmbTipo() {
        return cmbTipo;
    }

    public void setCmbTipo(JComboBox<String> cmbTipo) {
        this.cmbTipo = cmbTipo;
    }

    public JTextField getTxtInstitucion() {
        return txtInstitucion;
    }

    public void setTxtInstitucion(JTextField txtInstitucion) {
        this.txtInstitucion = txtInstitucion;
    }

    public JTextField getTxtEspecialidad() {
        return txtEspecialidad;
    }

    public void setTxtEspecialidad(JTextField txtEspecialidad) {
        this.txtEspecialidad = txtEspecialidad;
    }

    public JComboBox<String> getCmbNivel() {
        return cmbNivel;
    }

    public void setCmbNivel(JComboBox<String> cmbNivel) {
        this.cmbNivel = cmbNivel;
    }

    public JCheckBox getChkCabezaHogar() {
        return chkCabezaHogar;
    }

    public void setChkCabezaHogar(JCheckBox chkCabezaHogar) {
        this.chkCabezaHogar = chkCabezaHogar;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public void setBtnGuardar(JButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    public JButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public void setBtnLimpiar(JButton btnLimpiar) {
        this.btnLimpiar = btnLimpiar;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public void setBtnBuscar(JButton btnBuscar) {
        this.btnBuscar = btnBuscar;
    }

    public JPanel getProfSalud() {
        return profSalud;
    }

    public void setProfSalud(JPanel profSalud) {
        this.profSalud = profSalud;
    }

    public JPanel getDocente() {
        return docente;
    }

    public void setDocente(JPanel docente) {
        this.docente = docente;
    }

    public JPanel getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(JPanel ciudadano) {
        this.ciudadano = ciudadano;
    }

    public JTextField getTxtBioseguridad() {
        return txtBioseguridad;
    }

    public void setTxtBioseguridad(JTextField txtBioseguridad) {
        this.txtBioseguridad = txtBioseguridad;
    }

    public JTextField getTxtMedicina1() {
        return txtMedicina1;
    }

    public void setTxtMedicina1(JTextField txtMedicina1) {
        this.txtMedicina1 = txtMedicina1;
    }

    public JTextField getTxtImplementosTec() {
        return txtImplementosTec;
    }

    public void setTxtImplementosTec(JTextField txtImplementosTec) {
        this.txtImplementosTec = txtImplementosTec;
    }

    public JTextField getTxtServicioInternet() {
        return txtServicioInternet;
    }

    public void setTxtServicioInternet(JTextField txtServicioInternet) {
        this.txtServicioInternet = txtServicioInternet;
    }

    public JTextField getTxtMedicina2() {
        return txtMedicina2;
    }

    public void setTxtMedicina2(JTextField txtMedicina2) {
        this.txtMedicina2 = txtMedicina2;
    }

    public JTextField getTxtCanastaFamiliar() {
        return txtCanastaFamiliar;
    }

    public void setTxtCanastaFamiliar(JTextField txtCanastaFamiliar) {
        this.txtCanastaFamiliar = txtCanastaFamiliar;
    }
    }
    

    


