package Vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicButtonUI;
import Modelo.*;

public class JFTIniciarOperacion extends JPanel {

    private static final Color NARANJA = new Color(194, 65, 12);
    private static final Color FONDO = new Color(241, 243, 246);
    private static final Color BORDE = new Color(209, 213, 219);
    private static final Color TEXTO = new Color(17, 24, 39);
    private static final Color GRIS = new Color(107, 114, 128);
    private static final Border CAMPO = BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(BORDE, 1, true),
            BorderFactory.createEmptyBorder(6, 12, 6, 12));

    private JTextField txtFecha;
    private JComboBox<Departamento> cmbDepartamento;
    private JComboBox<MunicipiosAfectados> cmbMunicipio;
    private JComboBox<Incendio> cmbIncendio;
    private JComboBox<UnidadTerrestre> cmbUnidad;
    private JComboBox<Helicoptero> cmbHelicoptero;
    private JButton btnIniciar;
    private JTextArea txtRespuestas;

    public JFTIniciarOperacion() {
        UIManager.put("Label.foreground", TEXTO);
        setLayout(new BorderLayout(0, 24));
        setBackground(FONDO);
        setBorder(BorderFactory.createEmptyBorder(36, 40, 36, 40));

        JPanel encabezado = new JPanel(new GridLayout(2, 1, 0, 6));
        encabezado.setOpaque(false);
        JLabel titulo = new JLabel("Iniciar operación");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 26));
        JLabel subtitulo = new JLabel("Asigna una unidad a un incendio y arranca la operación.");
        subtitulo.setFont(new Font("SansSerif", Font.PLAIN, 14));
        subtitulo.setForeground(GRIS);
        encabezado.add(titulo);
        encabezado.add(subtitulo);
        add(encabezado, BorderLayout.NORTH);

        JPanel cuerpo = new JPanel(new GridLayout(1, 2, 24, 0));
        cuerpo.setOpaque(false);
        add(cuerpo, BorderLayout.CENTER);

        JPanel izquierda = new JPanel(new BorderLayout());
        izquierda.setOpaque(false);
        Tarjeta datos = new Tarjeta(new BorderLayout(0, 18));
        JLabel etiquetaDatos = new JLabel("DATOS DE LA OPERACIÓN");
        etiquetaDatos.setFont(new Font("SansSerif", Font.BOLD, 12));
        etiquetaDatos.setForeground(GRIS);
        datos.add(etiquetaDatos, BorderLayout.NORTH);

        txtFecha = new JTextField();
        cmbDepartamento = new JComboBox<Departamento>();
        cmbMunicipio = new JComboBox<MunicipiosAfectados>();
        cmbIncendio = new JComboBox<Incendio>();
        cmbUnidad = new JComboBox<UnidadTerrestre>();
        cmbHelicoptero = new JComboBox<Helicoptero>();

        JComponent[] campos = {txtFecha, cmbDepartamento, cmbMunicipio, cmbIncendio, cmbUnidad, cmbHelicoptero};
        for (JComponent c : campos) {
            c.setBorder(CAMPO);
            c.setBackground(Color.WHITE);
            c.setFont(new Font("SansSerif", Font.PLAIN, 14));
        }

        JPanel form = new JPanel(new GridLayout(6, 2, 16, 14));
        form.setOpaque(false);
        form.add(new JLabel("Fecha"));
        form.add(txtFecha);
        form.add(new JLabel("Departamento"));
        form.add(cmbDepartamento);
        form.add(new JLabel("Municipio"));
        form.add(cmbMunicipio);
        form.add(new JLabel("Incendio"));
        form.add(cmbIncendio);
        form.add(new JLabel("Unidad terrestre"));
        form.add(cmbUnidad);
        form.add(new JLabel("Helicóptero"));
        form.add(cmbHelicoptero);
        datos.add(form, BorderLayout.CENTER);

        btnIniciar = new JButton("Iniciar operación");
        btnIniciar.setUI(new BasicButtonUI());
        btnIniciar.setOpaque(true);
        btnIniciar.setBorderPainted(false);
        btnIniciar.setFocusPainted(false);
        btnIniciar.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnIniciar.setBorder(BorderFactory.createEmptyBorder(12, 22, 12, 22));
        btnIniciar.setBackground(NARANJA);
        btnIniciar.setForeground(Color.WHITE);
        btnIniciar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JPanel filaBoton = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        filaBoton.setOpaque(false);
        filaBoton.add(btnIniciar);
        datos.add(filaBoton, BorderLayout.SOUTH);

        izquierda.add(datos, BorderLayout.NORTH);
        cuerpo.add(izquierda);

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

    public String getTxtFecha() {
        return txtFecha.getText();
    }

    public JComboBox<Departamento> getCmbDepartamento() {
        return cmbDepartamento;
    }

    public JComboBox<MunicipiosAfectados> getCmbMunicipio() {
        return cmbMunicipio;
    }

    public JComboBox<Incendio> getCmbIncendio() {
        return cmbIncendio;
    }

    public JComboBox<UnidadTerrestre> getCmbUnidad() {
        return cmbUnidad;
    }

    public JComboBox<Helicoptero> getCmbHelicoptero() {
        return cmbHelicoptero;
    }

    public JButton getBotonIniciar() {
        return btnIniciar;
    }

    public void setTxtRespuestasOperacion(String texto) {
        txtRespuestas.setText(texto);
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