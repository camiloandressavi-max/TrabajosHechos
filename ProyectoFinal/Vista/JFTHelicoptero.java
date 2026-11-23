package Vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicButtonUI;

public class JFTHelicoptero extends JPanel {

    private static final Color NARANJA = new Color(194, 65, 12);
    private static final Color FONDO = new Color(241, 243, 246);
    private static final Color BORDE = new Color(209, 213, 219);
    private static final Color TEXTO = new Color(17, 24, 39);
    private static final Color GRIS = new Color(107, 114, 128);
    private static final Border CAMPO = BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(BORDE, 1, true),
            BorderFactory.createEmptyBorder(6, 12, 6, 12));

    private JTextField txtNombre;
    private JTextField txtCodigo;
    private JCheckBox chkBambiBucket;
    private JButton btnRegistrar;
    private JButton btnListar;
    private JTextArea txtRespuestas;

    public JFTHelicoptero() {
        UIManager.put("Label.foreground", TEXTO);
        setLayout(new BorderLayout(0, 24));
        setBackground(FONDO);
        setBorder(BorderFactory.createEmptyBorder(36, 40, 36, 40));

        JPanel encabezado = new JPanel(new GridLayout(2, 1, 0, 6));
        encabezado.setOpaque(false);
        JLabel titulo = new JLabel("Helicópteros");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 26));
        JLabel subtitulo = new JLabel("Registra los helicópteros disponibles para la operación.");
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
        JLabel etiquetaDatos = new JLabel("DATOS DEL HELICÓPTERO");
        etiquetaDatos.setFont(new Font("SansSerif", Font.BOLD, 12));
        etiquetaDatos.setForeground(GRIS);
        datos.add(etiquetaDatos, BorderLayout.NORTH);

        txtNombre = new JTextField();
        txtCodigo = new JTextField();
        chkBambiBucket = new JCheckBox("Posee Bambi Bucket");
        chkBambiBucket.setOpaque(false);
        chkBambiBucket.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JComponent[] campos = {txtNombre, txtCodigo};
        for (JComponent c : campos) {
            c.setBorder(CAMPO);
            c.setBackground(Color.WHITE);
            c.setFont(new Font("SansSerif", Font.PLAIN, 14));
        }

        JPanel form = new JPanel(new GridLayout(3, 2, 16, 14));
        form.setOpaque(false);
        form.add(new JLabel("Nombre"));
        form.add(txtNombre);
        form.add(new JLabel("Código"));
        form.add(txtCodigo);
        form.add(new JLabel(""));
        form.add(chkBambiBucket);
        datos.add(form, BorderLayout.CENTER);

        btnRegistrar = new JButton("Registrar helicóptero");
        btnListar = new JButton("Listar helicópteros");
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

    public String getTxtNombre() {
        return txtNombre.getText();
    }

    public String getTxtCodigo() {
        return txtCodigo.getText();
    }

    public boolean getChkBambiBucket() {
        return chkBambiBucket.isSelected();
    }

    public JButton getBotonRegistrar() {
        return btnRegistrar;
    }

    public JButton getBotonListar() {
        return btnListar;
    }

    public void setTxtRespuestasHelicoptero(String texto) {
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