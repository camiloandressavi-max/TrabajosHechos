package Vista;
import Modelo.*;
import javax.swing.*;
import java.awt.*;

/**
- Write a description of class JFElecciones here.
- 
- @author (your name) 
- @version (a version number or a date)
 */
public class JFElecciones extends JFrame
{
    //representante
    private JLabel lblNombreRep = new JLabel("Ingrese nombre del representante:");
    private JTextField txtNombreRep = new JTextField();

    private JLabel lblApellidoRep = new JLabel("Ingrese apellido del representante:");
    private JTextField txtApellidoRep = new JTextField();

    private JLabel lblGradoRep = new JLabel("Ingrese grado del representante:");
    private JTextField txtGradoRep = new JTextField();

    private JLabel lblGrupoRep = new JLabel("Ingrese grupo del representante:");
    private JTextField txtGrupoRep = new JTextField();

    private JLabel lblLemaRep = new JLabel("Ingrese lema del representante:");
    private JTextField txtLemaRep = new JTextField();

    private JLabel lblNumeroTarjetonRep = new JLabel("Ingrese numero de tarjeton del representante:");
    private JTextField txtNumeroTarjetonRep = new JTextField();

    private JLabel lblFormulaRep = new JLabel("Ingrese formula del representante:");
    private JTextField txtFormulaRep = new JTextField();

    private JButton btnRegistrarRepresentante = new JButton("Registrar Representante");
        
    //personero
    private JLabel lblNombrePer = new JLabel("Ingrese nombre del personero:");
    private JTextField txtNombrePer = new JTextField();

    private JLabel lblApellidoPer = new JLabel("Ingrese apellido del personero:");
    private JTextField txtApellidoPer = new JTextField();

    private JLabel lblGradoPer = new JLabel("Ingrese grado del personero:");
    private JTextField txtGradoPer = new JTextField();

    private JLabel lblGrupoPer = new JLabel("Ingrese grupo del personero:");
    private JTextField txtGrupoPer = new JTextField();

    private JLabel lblLemaPer = new JLabel("Ingrese lema del personero:");
    private JTextField txtLemaPer = new JTextField();

    private JLabel lblNumeroTarjetonPer = new JLabel("Ingrese Tarjeton del personero:");
    private JTextField txtNumeroTarjetonPer = new JTextField();

    private JLabel lblNombreAnimal = new JLabel("Ingrese nombre del animal:");
    private JTextField txtNombreAnimal = new JTextField();

    private JLabel lblTipoAnimal = new JLabel("Seleccione tipo de animal:");
    private JComboBox<Tipo> cmbTipoAnimal = new JComboBox<>(Tipo.values());

    private JButton btnRegistrarPersonero = new JButton("Registrar  Personero");
    
    //paneles inferiores izq
    private JComboBox<CandidatoRepresentante> cmbRep = new JComboBox<>();
    private JButton btnVotar = new JButton("Votar Por Representante");
    private JButton btnBlancoRep = new JButton("Votar en Blanco");
    private JTextArea txtArea = new JTextArea(5,5);
    private JScrollPane s = new JScrollPane(txtArea);
        
    //panel inferior der
    private JComboBox<CandidatoPersonero> cmbPer = new JComboBox<>();
    private JButton btnVotar1 = new JButton("Votar Por Personero");
    private JButton btnBlancoPer = new JButton("Votar en Blanco");
    private JTextArea txtArea1 = new JTextArea(5,5);
    private JScrollPane s1 = new JScrollPane(txtArea1);
    
    //panel inferior datos votaciones
    private JButton btnTotal = new JButton("Total votantes");
    private JButton btnElegido = new JButton("Personero Elegido");
    private JButton btnCandidato = new JButton("Candidato con menores votos");
    private JButton btnVotos = new JButton("Votos Totales");
    
    private JTextArea txtArea2 = new JTextArea(5,5);
    private JScrollPane s2 = new JScrollPane(txtArea2);
    
    public JFElecciones(){
        setTitle("Sistema De Elecciones Estudiantiles");
        setSize(1000,650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        crearInterfaz();
        setResizable(false);
        setVisible(true);
    }

    public void crearInterfaz(){
        JPanel a = new JPanel();
        a.setLayout(new BorderLayout());
       
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(0,2));
       
        JPanel a1 = new JPanel();
        a1.setLayout(new GridLayout(0,2));
        a1.add(lblNombreRep);
        a1.add(txtNombreRep);
        a1.add(lblApellidoRep);
        a1.add(txtApellidoRep);
        a1.add(lblGradoRep);
        a1.add(txtGradoRep);
        a1.add(lblGrupoRep);
        a1.add(txtGrupoRep);
        a1.add(lblLemaRep);
        a1.add(txtLemaRep);
        a1.add(lblNumeroTarjetonRep);
        a1.add(txtNumeroTarjetonRep);
        a1.add(lblFormulaRep);
        a1.add(txtFormulaRep);
        a1.add(btnRegistrarRepresentante);
        a1.add(new JLabel(""));
       
        p.add(a1);
       
        JPanel a2 = new JPanel();
        a2.setLayout(new GridLayout(0,2));
       
        a2.add(lblNombrePer);
        a2.add(txtNombrePer);
        a2.add(lblApellidoPer);
        a2.add(txtApellidoPer);
        a2.add(lblGradoPer);
        a2.add(txtGradoPer);
        a2.add(lblGrupoPer);
        a2.add(txtGrupoPer);
        a2.add(lblLemaPer);
        a2.add(txtLemaPer);
        a2.add(lblNumeroTarjetonPer);
        a2.add(txtNumeroTarjetonPer);
        a2.add(lblNombreAnimal);
        a2.add(txtNombreAnimal);
        a2.add(lblTipoAnimal);
        a2.add(cmbTipoAnimal);
        a2.add(btnRegistrarPersonero);
        a2.add(new JLabel(""));
       
        p.add(a2);
       
        JPanel b1 = new JPanel();
        b1.setLayout(new BorderLayout());
        JPanel pBotonesRep = new JPanel(new GridLayout(1, 2));
        pBotonesRep.add(btnVotar);
        pBotonesRep.add(btnBlancoRep);
       
        b1.add(cmbRep, BorderLayout.NORTH);
        b1.add(pBotonesRep, BorderLayout.CENTER);
        b1.add(s, BorderLayout.SOUTH);    
       
        p.add(b1);
       
        JPanel b2 = new JPanel();
        b2.setLayout(new BorderLayout());
        JPanel pBotonesPer = new JPanel(new GridLayout(1, 2));
        pBotonesPer.add(btnVotar1);
        pBotonesPer.add(btnBlancoPer);
       
        b2.add(cmbPer, BorderLayout.NORTH);
        b2.add(pBotonesPer, BorderLayout.CENTER);
        b2.add(s1, BorderLayout.SOUTH);
       
        p.add(b2);
       
        JPanel s = new JPanel();
        s.setLayout(new BorderLayout());
        JPanel s1 = new JPanel();
        s1.add(btnTotal);
        s1.add(btnElegido);
        s1.add(btnCandidato);
        s1.add(btnVotos);
        s.add(s1, BorderLayout.NORTH);
        s.add(s2, BorderLayout.CENTER);
       
        a.add(p, BorderLayout.NORTH);
        a.add(s, BorderLayout.CENTER);
        add(a);
    }
    
    // --- GETTERS Y SETTERS REPRESENTANTE ---
    public JLabel getLblNombreRep() {
        return lblNombreRep;
    }

    public void setLblNombreRep(JLabel lblNombreRep) {
        this.lblNombreRep = lblNombreRep;
    }

    public JTextField getTxtNombreRep() {
        return txtNombreRep;
    }

    public void setTxtNombreRep(JTextField txtNombreRep) {
        this.txtNombreRep = txtNombreRep;
    }

    public JLabel getLblApellidoRep() {
        return lblApellidoRep;
    }

    public void setLblApellidoRep(JLabel lblApellidoRep) {
        this.lblApellidoRep = lblApellidoRep;
    }

    public JTextField getTxtApellidoRep() {
        return txtApellidoRep;
    }

    public void setTxtApellidoRep(JTextField txtApellidoRep) {
        this.txtApellidoRep = txtApellidoRep;
    }

    public JLabel getLblGradoRep() {
        return lblGradoRep;
    }

    public void setLblGradoRep(JLabel lblGradoRep) {
        this.lblGradoRep = lblGradoRep;
    }

    public JTextField getTxtGradoRep() {
        return txtGradoRep;
    }

    public void setTxtGradoRep(JTextField txtGradoRep) {
        this.txtGradoRep = txtGradoRep;
    }

    public JLabel getLblGrupoRep() {
        return lblGrupoRep;
    }

    public void setLblGrupoRep(JLabel lblGrupoRep) {
        this.lblGrupoRep = lblGrupoRep;
    }

    public JTextField getTxtGrupoRep() {
        return txtGrupoRep;
    }

    public void setTxtGrupoRep(JTextField txtGrupoRep) {
        this.txtGrupoRep = txtGrupoRep;
    }

    public JLabel getLblLemaRep() {
        return lblLemaRep;
    }

    public void setLblLemaRep(JLabel lblLemaRep) {
        this.lblLemaRep = lblLemaRep;
    }

    public JTextField getTxtLemaRep() {
        return txtLemaRep;
    }

    public void setTxtLemaRep(JTextField txtLemaRep) {
        this.txtLemaRep = txtLemaRep;
    }

    public JLabel getLblNumeroTarjetonRep() {
        return lblNumeroTarjetonRep;
    }

    public void setLblNumeroTarjetonRep(JLabel lblNumeroTarjetonRep) {
        this.lblNumeroTarjetonRep = lblNumeroTarjetonRep;
    }

    public JTextField getTxtNumeroTarjetonRep() {
        return txtNumeroTarjetonRep;
    }

    public void setTxtNumeroTarjetonRep(JTextField txtNumeroTarjetonRep) {
        this.txtNumeroTarjetonRep = txtNumeroTarjetonRep;
    }

    public JLabel getLblFormulaRep() {
        return lblFormulaRep;
    }

    public void setLblFormulaRep(JLabel lblFormulaRep) {
        this.lblFormulaRep = lblFormulaRep;
    }

    public JTextField getTxtFormulaRep() {
        return txtFormulaRep;
    }

    public void setTxtFormulaRep(JTextField txtFormulaRep) {
        this.txtFormulaRep = txtFormulaRep;
    }

    public JButton getBtnRegistrarRepresentante() {
        return btnRegistrarRepresentante;
    }

    public void setBtnRegistrarRepresentante(JButton btnRegistrarRepresentante) {
        this.btnRegistrarRepresentante = btnRegistrarRepresentante;
    }

    public JLabel getLblNombrePer() {
        return lblNombrePer;
    }

    public void setLblNombrePer(JLabel lblNombrePer) {
        this.lblNombrePer = lblNombrePer;
    }

    public JTextField getTxtNombrePer() {
        return txtNombrePer;
    }

    public void setTxtNombrePer(JTextField txtNombrePer) {
        this.txtNombrePer = txtNombrePer;
    }

    public JLabel getLblApellidoPer() {
        return lblApellidoPer;
    }

    public void setLblApellidoPer(JLabel lblApellidoPer) {
        this.lblApellidoPer = lblApellidoPer;
    }

    public JTextField getTxtApellidoPer() {
        return txtApellidoPer;
    }

    public void setTxtApellidoPer(JTextField txtApellidoPer) {
        this.txtApellidoPer = txtApellidoPer;
    }

    public JLabel getLblGradoPer() {
        return lblGradoPer;
    }

    public void setLblGradoPer(JLabel lblGradoPer) {
        this.lblGradoPer = lblGradoPer;
    }

    public JTextField getTxtGradoPer() {
        return txtGradoPer;
    }

    public void setTxtGradoPer(JTextField txtGradoPer) {
        this.txtGradoPer = txtGradoPer;
    }

    public JLabel getLblGrupoPer() {
        return lblGrupoPer;
    }

    public void setLblGrupoPer(JLabel lblGrupoPer) {
        this.lblGrupoPer = lblGrupoPer;
    }

    public JTextField getTxtGrupoPer() {
        return txtGrupoPer;
    }

    public void setTxtGrupoPer(JTextField txtGrupoPer) {
        this.txtGrupoPer = txtGrupoPer;
    }

    public JLabel getLblLemaPer() {
        return lblLemaPer;
    }

    public void setLblLemaPer(JLabel lblLemaPer) {
        this.lblLemaPer = lblLemaPer;
    }

    public JTextField getTxtLemaPer() {
        return txtLemaPer;
    }

    public void setTxtLemaPer(JTextField txtLemaPer) {
        this.txtLemaPer = txtLemaPer;
    }

    public JLabel getLblNumeroTarjetonPer() {
        return lblNumeroTarjetonPer;
    }

    public void setLblNumeroTarjetonPer(JLabel lblNumeroTarjetonPer) {
        this.lblNumeroTarjetonPer = lblNumeroTarjetonPer;
    }

    public JTextField getTxtNumeroTarjetonPer() {
        return txtNumeroTarjetonPer;
    }

    public void setTxtNumeroTarjetonPer(JTextField txtNumeroTarjetonPer) {
        this.txtNumeroTarjetonPer = txtNumeroTarjetonPer;
    }

    public JLabel getLblNombreAnimal() {
        return lblNombreAnimal;
    }

    public void setLblNombreAnimal(JLabel lblNombreAnimal) {
        this.lblNombreAnimal = lblNombreAnimal;
    }

    public JTextField getTxtNombreAnimal() {
        return txtNombreAnimal;
    }

    public void setTxtNombreAnimal(JTextField txtNombreAnimal) {
        this.txtNombreAnimal = txtNombreAnimal;
    }

    public JLabel getLblTipoAnimal() {
        return lblTipoAnimal;
    }

    public void setLblTipoAnimal(JLabel lblTipoAnimal) {
        this.lblTipoAnimal = lblTipoAnimal;
    }

    public JComboBox<Tipo> getCmbTipoAnimal() {
        return cmbTipoAnimal;
    }

    public void setCmbTipoAnimal(JComboBox<Tipo> cmbTipoAnimal) {
        this.cmbTipoAnimal = cmbTipoAnimal;
    }

    public JButton getBtnRegistrarPersonero() {
        return btnRegistrarPersonero;
    }

    public void setBtnRegistrarPersonero(JButton btnRegistrarPersonero) {
        this.btnRegistrarPersonero = btnRegistrarPersonero;
    }

    public JComboBox<CandidatoRepresentante> getCmbRep() {
        return cmbRep;
    }

    public void setCmbRep(JComboBox<CandidatoRepresentante> cmbRep) {
        this.cmbRep = cmbRep;
    }

    public JButton getBtnVotar() {
        return btnVotar;
    }

    public void setBtnVotar(JButton btnVotar) {
        this.btnVotar = btnVotar;
    }

    public JButton getBtnBlancoRep() {
        return btnBlancoRep;
    }

    public void setBtnBlancoRep(JButton btnBlancoRep) {
        this.btnBlancoRep = btnBlancoRep;
    }

    public JTextArea getTxtArea() {
        return txtArea;
    }

    public void setTxtArea(JTextArea txtArea) {
        this.txtArea = txtArea;
    }

    public JScrollPane getS() {
        return s;
    }

    public void setS(JScrollPane s) {
        this.s = s;
    }

    public JComboBox<CandidatoPersonero> getCmbPer() {
        return cmbPer;
    }

    public void setCmbPer(JComboBox<CandidatoPersonero> cmbPer) {
        this.cmbPer = cmbPer;
    }

    public JButton getBtnVotar1() {
        return btnVotar1;
    }

    public void setBtnVotar1(JButton btnVotar1) {
        this.btnVotar1 = btnVotar1;
    }

    public JButton getBtnBlancoPer() {
        return btnBlancoPer;
    }

    public void setBtnBlancoPer(JButton btnBlancoPer) {
        this.btnBlancoPer = btnBlancoPer;
    }

    public JTextArea getTxtArea1() {
        return txtArea1;
    }

    public void setTxtArea1(JTextArea txtArea1) {
        this.txtArea1 = txtArea1;
    }

    public JScrollPane getS1() {
        return s1;
    }

    public void setS1(JScrollPane s1) {
        this.s1 = s1;
    }

    public JButton getBtnTotal() {
        return btnTotal;
    }

    public void setBtnTotal(JButton btnTotal) {
        this.btnTotal = btnTotal;
    }

    public JButton getBtnElegido() {
        return btnElegido;
    }

    public void setBtnElegido(JButton btnElegido) {
        this.btnElegido = btnElegido;
    }

    public JButton getBtnCandidato() {
        return btnCandidato;
    }

    public void setBtnCandidato(JButton btnCandidato) {
        this.btnCandidato = btnCandidato;
    }

    public JButton getBtnVotos() {
        return btnVotos;
    }

    public void setBtnVotos(JButton btnVotos) {
        this.btnVotos = btnVotos;
    }

    public JTextArea getTxtArea2() {
        return txtArea2;
    }

    public void setTxtArea2(JTextArea txtArea2) {
        this.txtArea2 = txtArea2;
    }

    public JScrollPane getS2() {
        return s2;
    }

    public void setS2(JScrollPane s2) {
        this.s2 = s2;
    }
}