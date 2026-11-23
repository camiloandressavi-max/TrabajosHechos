package Vista;
import Modelo.*;
import javax.swing.*;
import java.awt.*;

public class JFBiblioteca extends JFrame
{   
    private JLabel lblNombre = new JLabel("Ingrese Nombre: ");
    private JTextField txtNombre = new JTextField(10);
    private JLabel lblCedula = new JLabel("Ingrese Cedula: ");
    private JTextField txtCedula = new JTextField(10);
    private JLabel lblQueEs = new JLabel("Que es usted: ");
    private JComboBox<String> cmbQueEs = new JComboBox<String>(new String[]{"Estudiante", "Docente", "Administrativo"});
    
    private JLabel lblTituloLibro = new JLabel("Nombre del Libro: ");
    private JTextField txtTituloLibro = new JTextField(10);
    private JLabel lblIssn = new JLabel("ISSN del Libro: ");
    private JTextField txtIssn = new JTextField(10);
    private JLabel lblLibro = new JLabel("Ingrese Tipo De Libro A Tomar: ");
    private JComboBox<Tipo> cmbLibro = new JComboBox<Tipo>(Tipo.values());

    private JLabel lblDiaPrestamo = new JLabel("Dia de Prestamo: ");
    private JTextField txtDiaPrestamo = new JTextField(10);
    private JLabel lblMesPrestamo = new JLabel("Mes de Prestamo: ");
    private JTextField txtMesPrestamo = new JTextField(10);
    private JLabel lblAnioPrestamo = new JLabel("Año de Prestamo: ");
    private JTextField txtAnioPrestamo = new JTextField(10);

    private JLabel lblDiaDevolucion = new JLabel("Dia de Devolucion: ");
    private JTextField txtDiaDevolucion = new JTextField(10);
    private JLabel lblMesDevolucion = new JLabel("Mes de Devolucion: ");
    private JTextField txtMesDevolucion = new JTextField(10);
    private JLabel lblAnioDevolucion = new JLabel("Año de Devolucion: ");
    private JTextField txtAnioDevolucion = new JTextField(10);

    private JButton btnDevolucion = new JButton("Registrar Devolucion");

    private JTextArea txtArea = new JTextArea(7, 70);
    private JScrollPane s = new JScrollPane(txtArea);

    public JFBiblioteca() {
        setTitle("Sistema de prestamos");
        setSize(800, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        crearInterfaz();
        setResizable(false);
        setVisible(true);
    }

    public void crearInterfaz() {
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());

        JPanel izq = new JPanel();
        izq.setLayout(new GridLayout(0, 2, 5, 4));
        izq.add(lblNombre);
        izq.add(txtNombre);
        izq.add(lblCedula);
        izq.add(txtCedula);
        izq.add(lblQueEs);
        izq.add(cmbQueEs);

        izq.add(lblTituloLibro);
        izq.add(txtTituloLibro);
        izq.add(lblIssn);
        izq.add(txtIssn);
        izq.add(lblLibro);
        izq.add(cmbLibro);

        izq.add(lblDiaPrestamo);
        izq.add(txtDiaPrestamo);
        izq.add(lblMesPrestamo);
        izq.add(txtMesPrestamo);
        izq.add(lblAnioPrestamo);
        izq.add(txtAnioPrestamo);

        izq.add(lblDiaDevolucion);
        izq.add(txtDiaDevolucion);
        izq.add(lblMesDevolucion);
        izq.add(txtMesDevolucion);
        izq.add(lblAnioDevolucion);
        izq.add(txtAnioDevolucion);

        izq.add(btnDevolucion);
        p.add(izq, BorderLayout.CENTER);

        JPanel sur = new JPanel();
        sur.add(s);
        p.add(sur, BorderLayout.SOUTH);
        add(p);
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextField getTxtCedula() {
        return txtCedula;
    }

    public void setTxtCedula(JTextField txtCedula) {
        this.txtCedula = txtCedula;
    }

    public JComboBox<String> getCmbQueEs() {
        return cmbQueEs;
    }

    public void setCmbQueEs(JComboBox<String> cmbQueEs) {
        this.cmbQueEs = cmbQueEs;
    }

    public JTextField getTxtTituloLibro() {
        return txtTituloLibro;
    }

    public void setTxtTituloLibro(JTextField txtTituloLibro) {
        this.txtTituloLibro = txtTituloLibro;
    }

    public JTextField getTxtIssn() {
        return txtIssn;
    }

    public void setTxtIssn(JTextField txtIssn) {
        this.txtIssn = txtIssn;
    }

    public JComboBox<Tipo> getCmbLibro() {
        return cmbLibro;
    }

    public void setCmbLibro(JComboBox<Tipo> cmbLibro) {
        this.cmbLibro = cmbLibro;
    }

    public JTextField getTxtDiaPrestamo() {
        return txtDiaPrestamo;
    }

    public void setTxtDiaPrestamo(JTextField txtDiaPrestamo) {
        this.txtDiaPrestamo = txtDiaPrestamo;
    }

    public JTextField getTxtMesPrestamo() {
        return txtMesPrestamo;
    }

    public void setTxtMesPrestamo(JTextField txtMesPrestamo) {
        this.txtMesPrestamo = txtMesPrestamo;
    }

    public JTextField getTxtAnioPrestamo() {
        return txtAnioPrestamo;
    }

    public void setTxtAnioPrestamo(JTextField txtAnioPrestamo) {
        this.txtAnioPrestamo = txtAnioPrestamo;
    }

    public JTextField getTxtDiaDevolucion() {
        return txtDiaDevolucion;
    }

    public void setTxtDiaDevolucion(JTextField txtDiaDevolucion) {
        this.txtDiaDevolucion = txtDiaDevolucion;
    }

    public JTextField getTxtMesDevolucion() {
        return txtMesDevolucion;
    }

    public void setTxtMesDevolucion(JTextField txtMesDevolucion) {
        this.txtMesDevolucion = txtMesDevolucion;
    }

    public JTextField getTxtAnioDevolucion() {
        return txtAnioDevolucion;
    }

    public void setTxtAnioDevolucion(JTextField txtAnioDevolucion) {
        this.txtAnioDevolucion = txtAnioDevolucion;
    }

    public JButton getBtnDevolucion() {
        return btnDevolucion;
    }

    public void setBtnDevolucion(JButton btnDevolucion) {
        this.btnDevolucion = btnDevolucion;
    }

    public JTextArea getTxtArea() {
        return txtArea;
    }

    public void setTxtArea(JTextArea txtArea) {
        this.txtArea = txtArea;
    }
}