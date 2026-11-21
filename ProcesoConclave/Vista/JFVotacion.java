package Vista;
import javax.swing.*;
import java.awt.*;
import Modelo.*;

public class JFVotacion extends JFrame {
    
    private JTextField txtCandidato = new JTextField(10);
    private JButton btnCandidato = new JButton("Agregar Nuevo candidato");

    private JLabel lblLista = new JLabel("Lista De Cardenales: ");
    private JComboBox<Cardenal> cmbLista = new JComboBox<>();

    private JButton btnVotar = new JButton("Votar");
    private JLabel lblRonda = new JLabel("Ronda n°");

    private JTextField txtRonda = new JTextField(10);

    private JTextArea txtArea = new JTextArea(12, 35);
    private JScrollPane s = new JScrollPane(txtArea);

    private JButton btnResultados = new JButton("Mostrar Resultados");
    private JButton btnRonda = new JButton("Siguiente Ronda");

    public JFVotacion() {
        setTitle("Proceso Cónclave");
        setSize(900, 550);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        crearInterfaz();

        setVisible(true);
    }

    public void crearInterfaz() {
        txtRonda.setEditable(false);
        txtArea.setEditable(false);

        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());

        


        JPanel der = new JPanel();
        der.setLayout(new GridLayout(0, 2));
        der.add(new JLabel("Ingrese Nombre Del Candidato: "));
        der.add(txtCandidato);
        der.add(btnCandidato);

        p.add(der, BorderLayout.CENTER);

        JPanel principal = new JPanel();
        principal.setLayout(new BoxLayout(principal, BoxLayout.Y_AXIS));

        JPanel a = new JPanel();
        a.add(lblLista);
        a.add(cmbLista);
        principal.add(a);

        JPanel asegundo = new JPanel();
        asegundo.setLayout(new BorderLayout());
        asegundo.add(new JLabel("                                                                    "), BorderLayout.WEST);
        asegundo.add(btnVotar, BorderLayout.CENTER);

        JPanel auxiliar = new JPanel();
        auxiliar.add(lblRonda);
        auxiliar.add(txtRonda);
        asegundo.add(auxiliar, BorderLayout.EAST);

        principal.add(asegundo);

        JPanel b = new JPanel();
        b.setLayout(new BorderLayout());
        b.add(s, BorderLayout.CENTER);
        b.add(new JLabel("                                        "), BorderLayout.WEST);
        b.add(new JLabel("                                        "), BorderLayout.EAST);
        principal.add(b);

        JPanel c = new JPanel();
        c.add(btnResultados);
        c.add(btnRonda);
        principal.add(c);

        p.add(principal, BorderLayout.SOUTH);
        add(p);
    }

    

    public JTextField getTxtCandidato() {
        return txtCandidato;
    }

    public void setTxtCandidato(JTextField txtCandidato) {
        this.txtCandidato = txtCandidato;
    }

    public JButton getBtnCandidato() {
        return btnCandidato;
    }

    public void setBtnCandidato(JButton btnCandidato) {
        this.btnCandidato = btnCandidato;
    }

    public JLabel getLblLista() {
        return lblLista;
    }

    public void setLblLista(JLabel lblLista) {
        this.lblLista = lblLista;
    }

    public JComboBox<Cardenal> getCmbLista() {
        return cmbLista;
    }

    public void setCmbLista(JComboBox<Cardenal> cmbLista) {
        this.cmbLista = cmbLista;
    }

    public JButton getBtnVotar() {
        return btnVotar;
    }

    public void setBtnVotar(JButton btnVotar) {
        this.btnVotar = btnVotar;
    }

    public JLabel getLblRonda() {
        return lblRonda;
    }

    public void setLblRonda(JLabel lblRonda) {
        this.lblRonda = lblRonda;
    }

    public JTextField getTxtRonda() {
        return txtRonda;
    }

    public void setTxtRonda(JTextField txtRonda) {
        this.txtRonda = txtRonda;
    }

    public JTextArea getTxtArea() {
        return txtArea;
    }

    public void setTxtArea(JTextArea txtArea) {
        this.txtArea = txtArea;
    }

    public JButton getBtnResultados() {
        return btnResultados;
    }

    public void setBtnResultados(JButton btnResultados) {
        this.btnResultados = btnResultados;
    }

    public JButton getBtnRonda() {
        return btnRonda;
    }

    public void setBtnRonda(JButton btnRonda) {
        this.btnRonda = btnRonda;
    }
}