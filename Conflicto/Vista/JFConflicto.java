package Vista;

import Modelo.*;
import java.awt.Font;
import javax.swing.*;

public class JFConflicto extends JFrame {
    private JLabel lblTitulo, lblConflicto, lblGrupo;
    private JComboBox<Conflicto> cbConflictos;
    private JComboBox<GrupoArmado> cbGrupos;
    private JButton btnVerConflicto, btnVerGrupo, btnVerDialogos;
    private JScrollPane scrollResultados;
    private JTextArea campoTexto;

    public JFConflicto() {
        setTitle("Seguimiento de Conflictos Belicos");
        setSize(550, 540);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        lblTitulo = new JLabel("Conflictos Belicos");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitulo.setBounds(25, 15, 250, 25);
        add(lblTitulo);

        lblConflicto = new JLabel("Conflicto:");
        lblConflicto.setBounds(25, 55, 100, 25);
        add(lblConflicto);

        cbConflictos = new JComboBox<>();
        cbConflictos.setBounds(130, 55, 250, 25);
        add(cbConflictos);

        btnVerConflicto = new JButton("Ver conflicto");
        btnVerConflicto.setBounds(395, 55, 120, 25);
        add(btnVerConflicto);

        lblGrupo = new JLabel("Grupo armado:");
        lblGrupo.setBounds(25, 95, 100, 25);
        add(lblGrupo);

        cbGrupos = new JComboBox<>();
        cbGrupos.setBounds(130, 95, 250, 25);
        add(cbGrupos);

        btnVerGrupo = new JButton("Ver grupo");
        btnVerGrupo.setBounds(395, 95, 120, 25);
        add(btnVerGrupo);

        btnVerDialogos = new JButton("Ver dialogos");
        btnVerDialogos.setBounds(25, 135, 140, 28);
        add(btnVerDialogos);

        campoTexto = new JTextArea();
        campoTexto.setEditable(false);
        campoTexto.setLineWrap(true);
        campoTexto.setWrapStyleWord(true);

        scrollResultados = new JScrollPane(campoTexto);
        scrollResultados.setBorder(BorderFactory.createTitledBorder("Resultados"));
        scrollResultados.setBounds(25, 180, 490, 300);
        add(scrollResultados);

        setVisible(true);
    }

    public JLabel getLblTitulo() {
        return lblTitulo;
    }

    public JLabel getLblConflicto() {
        return lblConflicto;
    }

    public JLabel getLblGrupo() {
        return lblGrupo;
    }

    public JComboBox<Conflicto> getCbConflictos() {
        return cbConflictos;
    }

    public JComboBox<GrupoArmado> getCbGrupos() {
        return cbGrupos;
    }

    public JButton getBtnVerConflicto() {
        return btnVerConflicto;
    }

    public JButton getBtnVerGrupo() {
        return btnVerGrupo;
    }

    public JButton getBtnVerDialogos() {
        return btnVerDialogos;
    }

    public JScrollPane getScrollResultados() {
        return scrollResultados;
    }

    public JTextArea getCampoTexto() {
        return campoTexto;
    }
}