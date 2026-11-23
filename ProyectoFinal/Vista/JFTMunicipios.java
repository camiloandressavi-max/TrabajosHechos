package Vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicButtonUI;
import Modelo.*;

public class JFTMunicipios extends JPanel {

    private static final Color NARANJA = new Color(194, 65, 12);
    private static final Color FONDO = new Color(241, 243, 246);
    private static final Color BORDE = new Color(209, 213, 219);
    private static final Color TEXTO = new Color(17, 24, 39);
    private static final Color GRIS = new Color(107, 114, 128);
    private static final Border CAMPO = BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(BORDE, 1, true),
            BorderFactory.createEmptyBorder(6, 12, 6, 12));

    private JPanel formulario;
    private JPanel panelNuevo;
    private JComboBox<Departamento> cmbDepartamento;
    private JComboBox<MunicipiosAfectados> cmbMunicipio;
    private JTextField txtCodigo;
    private JTextField txtPoblacion;
    private JButton btnRegistrar;
    private JButton btnListar;
    private JComboBox<MunicipiosAfectados> cmbNuevoMunicipio;
    private JTextField txtNuevoCodigo;
    private JButton btnAnadirIncendio;
    private JTextArea txtRespuestas;

    public JFTMunicipios() {
        UIManager.put("Label.foreground", TEXTO);
        setLayout(new BorderLayout(0, 24));
        setBackground(FONDO);
        setBorder(BorderFactory.createEmptyBorder(36, 40, 36, 40));

        JPanel encabezado = new JPanel(new GridLayout(2, 1, 0, 6));
        encabezado.setOpaque(false);
        JLabel titulo = new JLabel("Municipios afectados");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 26));
        JLabel subtitulo = new JLabel("Registra municipios y el incendio que los afecta.");
        subtitulo.setFont(new Font("SansSerif", Font.PLAIN, 14));
        subtitulo.setForeground(GRIS);
        encabezado.add(titulo);
        encabezado.add(subtitulo);
        add(encabezado, BorderLayout.NORTH);

        JPanel cuerpo = new JPanel(new GridLayout(1, 2, 24, 0));
        cuerpo.setOpaque(false);
        add(cuerpo, BorderLayout.CENTER);

        formulario = new JPanel(new GridBagLayout());
        formulario.setOpaque(false);
        cuerpo.add(formulario);

        Tarjeta datos = new Tarjeta(new BorderLayout(0, 18));
        JLabel etiquetaDatos = new JLabel("DATOS DEL INCENDIO");
        etiquetaDatos.setFont(new Font("SansSerif", Font.BOLD, 12));
        etiquetaDatos.setForeground(GRIS);
        datos.add(etiquetaDatos, BorderLayout.NORTH);

        cmbDepartamento = new JComboBox<Departamento>();
        for (Departamento d : Departamento.getCatalogo()) {
            cmbDepartamento.addItem(d);
        }
        cmbDepartamento.setSelectedIndex(-1);
        cmbMunicipio = new JComboBox<MunicipiosAfectados>();
        txtCodigo = new JTextField();
        txtPoblacion = new JTextField();

        JComponent[] campos = {cmbDepartamento, cmbMunicipio, txtCodigo, txtPoblacion};
        for (JComponent c : campos) {
            c.setBorder(CAMPO);
            c.setBackground(Color.WHITE);
            c.setFont(new Font("SansSerif", Font.PLAIN, 14));
        }

        JPanel form = new JPanel(new GridLayout(4, 2, 16, 14));
        form.setOpaque(false);
        form.add(new JLabel("Departamento"));
        form.add(cmbDepartamento);
        form.add(new JLabel("Municipio"));
        form.add(cmbMunicipio);
        form.add(new JLabel("Código del incendio"));
        form.add(txtCodigo);
        form.add(new JLabel("Población"));
        form.add(txtPoblacion);
        datos.add(form, BorderLayout.CENTER);

        btnRegistrar = new JButton("Registrar municipio");
        btnListar = new JButton("Listar municipios");
        JButton[] botones = {btnRegistrar, btnListar};
        for (JButton b : botones) {
            b.setUI(new BasicButtonUI());
            b.setOpaque(true);
            b.setBorderPainted(false);
            b.setFocusPainted(false);
            b.setFont(new Font("SansSerif", Font.BOLD, 14));
            b.setBorder(BorderFactory.createEmptyBorder(12, 22, 12, 22));
            b.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        btnRegistrar.setBackground(NARANJA);
        btnRegistrar.setForeground(Color.WHITE);
        btnListar.setBackground(new Color(243, 244, 246));
        btnListar.setForeground(TEXTO);

        JPanel filaBotones = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        filaBotones.setOpaque(false);
        filaBotones.add(btnRegistrar);
        filaBotones.add(btnListar);
        datos.add(filaBotones, BorderLayout.SOUTH);

        panelNuevo = new Tarjeta(new BorderLayout(0, 18));
        JLabel tituloNuevo = new JLabel("AÑADIR INCENDIO A UN MUNICIPIO");
        tituloNuevo.setFont(new Font("SansSerif", Font.BOLD, 12));
        tituloNuevo.setForeground(NARANJA);
        panelNuevo.add(tituloNuevo, BorderLayout.NORTH);

        txtNuevoCodigo = new JTextField();
        cmbNuevoMunicipio = new JComboBox<MunicipiosAfectados>();
        JComponent[] camposNuevo = {txtNuevoCodigo, cmbNuevoMunicipio};
        for (JComponent c : camposNuevo) {
            c.setBorder(CAMPO);
            c.setBackground(Color.WHITE);
            c.setFont(new Font("SansSerif", Font.PLAIN, 14));
        }

        JPanel formNuevo = new JPanel(new GridLayout(2, 2, 16, 14));
        formNuevo.setOpaque(false);
        formNuevo.add(new JLabel("Código nuevo"));
        formNuevo.add(txtNuevoCodigo);
        formNuevo.add(new JLabel("Municipio"));
        formNuevo.add(cmbNuevoMunicipio);
        panelNuevo.add(formNuevo, BorderLayout.CENTER);

        btnAnadirIncendio = new JButton("Añadir incendio");
        btnAnadirIncendio.setUI(new BasicButtonUI());
        btnAnadirIncendio.setOpaque(true);
        btnAnadirIncendio.setBorderPainted(false);
        btnAnadirIncendio.setFocusPainted(false);
        btnAnadirIncendio.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnAnadirIncendio.setBorder(BorderFactory.createEmptyBorder(12, 22, 12, 22));
        btnAnadirIncendio.setBackground(new Color(255, 247, 237));
        btnAnadirIncendio.setForeground(NARANJA);
        btnAnadirIncendio.setCursor(new Cursor(Cursor.HAND_CURSOR));
        JPanel filaNuevo = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        filaNuevo.setOpaque(false);
        filaNuevo.add(btnAnadirIncendio);
        panelNuevo.add(filaNuevo, BorderLayout.SOUTH);
        panelNuevo.setVisible(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.gridy = 0;
        formulario.add(datos, gbc);
        gbc.gridy = 1;
        gbc.insets = new Insets(20, 0, 0, 0);
        formulario.add(panelNuevo, gbc);
        gbc.gridy = 2;
        gbc.weighty = 1;
        gbc.insets = new Insets(0, 0, 0, 0);
        JPanel relleno = new JPanel();
        relleno.setOpaque(false);
        formulario.add(relleno, gbc);

        Tarjeta resultados = new Tarjeta(new BorderLayout(0, 16));
        JLabel tituloResultados = new JLabel("RESULTADOS");
        tituloResultados.setFont(new Font("SansSerif", Font.BOLD, 12));
        tituloResultados.setForeground(GRIS);
        resultados.add(tituloResultados, BorderLayout.NORTH);

        txtRespuestas = new JTextArea();
        txtRespuestas.setEditable(false);
        txtRespuestas.setFont(new Font("Monospaced", Font.PLAIN, 13));
        txtRespuestas.setForeground(new Color(75, 85, 99));
        txtRespuestas.setBackground(new Color(249, 250, 251));
        txtRespuestas.setBorder(BorderFactory.createEmptyBorder(14, 14, 14, 14));
        JScrollPane scroll = new JScrollPane(txtRespuestas);
        scroll.setBorder(BorderFactory.createLineBorder(new Color(229, 231, 235), 1, true));
        scroll.getViewport().setBackground(new Color(249, 250, 251));
        resultados.add(scroll, BorderLayout.CENTER);
        cuerpo.add(resultados);
    }

    public JComboBox<Departamento> getCmbDepartamento() {
        return cmbDepartamento;
    }

    public JComboBox<MunicipiosAfectados> getCmbMunicipio() {
        return cmbMunicipio;
    }

    public String getTxtCodigo() {
        return txtCodigo.getText();
    }

    public String getTxtPoblacion() {
        return txtPoblacion.getText();
    }

    public JButton getBotonRegistrar() {
        return btnRegistrar;
    }

    public JButton getBotonListar() {
        return btnListar;
    }

    public JComboBox<MunicipiosAfectados> getCmbNuevoMunicipio() {
        return cmbNuevoMunicipio;
    }

    public String getTxtNuevoCodigo() {
        return txtNuevoCodigo.getText();
    }

    public JButton getBotonAnadirIncendio() {
        return btnAnadirIncendio;
    }

    public void setTxtRespuestas(String texto) {
        txtRespuestas.setText(texto);
    }

    public void mostrarPanelNuevo() {
        panelNuevo.setVisible(true);
        formulario.revalidate();
        formulario.repaint();
    }

    private static class Tarjeta extends JPanel {
        Tarjeta(LayoutManager diseno) {
            super(diseno);
            setOpaque(false);
            setBorder(BorderFactory.createEmptyBorder(22, 22, 22, 22));
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.WHITE);
            g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
            g2.setColor(BORDE);
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
            g2.dispose();
        }
    }
}