package Vista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;

public class JFTIncendioPrincipal extends JFrame implements ActionListener {

    private static final Color NARANJA = new Color(194, 65, 12);
    private static final Color SIDEBAR = new Color(31, 38, 51);
    private static final Color FONDO = new Color(241, 243, 246);

    public JFTMunicipios municipios;
    public JFTUnidadTerrestre terrestre;
    public JFTHelicoptero helicoptero;
    public JFTIniciarOperacion operacion;

    private CardLayout cartas;
    private JPanel contenido;
    private JButton btnMunicipios;
    private JButton btnTerrestre;
    private JButton btnHelicoptero;
    private JButton btnOperacion;
    private JButton[] botones;

    public JFTIncendioPrincipal() {
        setTitle("Sistema de Gestión de Emergencias · UNGRD");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 800);
        setLocationRelativeTo(null);

        JPanel raiz = new JPanel(new BorderLayout());
        raiz.setBackground(FONDO);

        JPanel menu = new JPanel();
        menu.setBackground(SIDEBAR);
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
        menu.setBorder(BorderFactory.createEmptyBorder(28, 18, 28, 18));
        menu.setPreferredSize(new Dimension(250, 800));

        JLabel marca = new JLabel("UNGRD");
        marca.setForeground(Color.WHITE);
        marca.setFont(new Font("SansSerif", Font.BOLD, 16));
        marca.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel subtitulo = new JLabel("Incendios forestales");
        subtitulo.setForeground(new Color(156, 163, 175));
        subtitulo.setFont(new Font("SansSerif", Font.PLAIN, 12));
        subtitulo.setAlignmentX(Component.LEFT_ALIGNMENT);

        btnMunicipios = new JButton("Municipios afectados");
        btnTerrestre = new JButton("Unidades terrestres");
        btnHelicoptero = new JButton("Helicópteros");
        btnOperacion = new JButton("Iniciar operación");
        botones = new JButton[]{btnMunicipios, btnTerrestre, btnHelicoptero, btnOperacion};

        for (JButton b : botones) {
            b.setUI(new BasicButtonUI());
            b.setOpaque(true);
            b.setBorderPainted(false);
            b.setFocusPainted(false);
            b.setHorizontalAlignment(SwingConstants.LEFT);
            b.setFont(new Font("SansSerif", Font.PLAIN, 14));
            b.setBorder(BorderFactory.createEmptyBorder(13, 16, 13, 16));
            b.setAlignmentX(Component.LEFT_ALIGNMENT);
            b.setMaximumSize(new Dimension(Integer.MAX_VALUE, 46));
            b.setCursor(new Cursor(Cursor.HAND_CURSOR));
            b.addActionListener(this);
        }

        JLabel version = new JLabel("Versión 1.0");
        version.setForeground(new Color(107, 114, 128));
        version.setFont(new Font("SansSerif", Font.PLAIN, 12));
        version.setAlignmentX(Component.LEFT_ALIGNMENT);

        menu.add(marca);
        menu.add(subtitulo);
        menu.add(Box.createVerticalStrut(28));
        for (JButton b : botones) {
            menu.add(b);
            menu.add(Box.createVerticalStrut(6));
        }
        menu.add(Box.createVerticalGlue());
        menu.add(version);

        municipios = new JFTMunicipios();
        terrestre = new JFTUnidadTerrestre();
        helicoptero = new JFTHelicoptero();
        operacion = new JFTIniciarOperacion();

        cartas = new CardLayout();
        contenido = new JPanel(cartas);
        contenido.setBackground(FONDO);
        contenido.add(municipios, "municipios");
        contenido.add(terrestre, "terrestre");
        contenido.add(helicoptero, "helicoptero");
        contenido.add(operacion, "operacion");

        raiz.add(menu, BorderLayout.WEST);
        raiz.add(contenido, BorderLayout.CENTER);
        setContentPane(raiz);

        btnMunicipios.doClick();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnMunicipios) {
            cartas.show(contenido, "municipios");
        }
        if (e.getSource() == btnTerrestre) {
            cartas.show(contenido, "terrestre");
        }
        if (e.getSource() == btnHelicoptero) {
            cartas.show(contenido, "helicoptero");
        }
        if (e.getSource() == btnOperacion) {
            cartas.show(contenido, "operacion");
        }
        for (JButton b : botones) {
            if (b == e.getSource()) {
                b.setBackground(NARANJA);
                b.setForeground(Color.WHITE);
            }
            if (b != e.getSource()) {
                b.setBackground(SIDEBAR);
                b.setForeground(new Color(209, 213, 219));
            }
        }
    }
}
