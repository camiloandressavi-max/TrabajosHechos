package Vista;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

public class JFAlcancia extends JFrame {
    
    private JLabel lblSaldo;
    private JLabel lblTotal;
    private JLabel lbl50;
    private JLabel lbl100;
    private JLabel lbl200;
    private JLabel lbl500;
    private JLabel lbl1000;
    private JLabel lblTextoSaldo;
    
    private JButton btnVaciar;
    private JButton btn50, btn100, btn200, btn500, btn1000;
    
    public JFAlcancia(){
        setTitle("Mi Alcancia - POO I");
        setSize(500,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        crearInterfaz();
        setVisible(true);
    }
    
    public void crearInterfaz(){
        JPanel principal = new JPanel();
        principal.setLayout(new BorderLayout(15,15));
        principal.setBorder(new EmptyBorder(20,25,20,25));
        
        JPanel encabezado = new JPanel();
        encabezado.setLayout(new BoxLayout(encabezado, BoxLayout.Y_AXIS));
        
        JLabel titulo = new JLabel("MI ALCANCIA");
        titulo.setFont(new Font("Times New Roman", Font.BOLD, 50));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);        
        
        ImageIcon icono = new ImageIcon("C:/Users/Camilo Salazar/OneDrive/Documentos/alcancia-copy-copy/Images/descarga.jpg");
        JLabel labelConImagen = new JLabel(icono);
        labelConImagen.setAlignmentX(Component.CENTER_ALIGNMENT);
       
        lblSaldo = new JLabel("$0");
        lblSaldo.setFont(new Font("Times New Roman", Font.BOLD, 50));
        lblSaldo.setAlignmentX(Component.CENTER_ALIGNMENT);
       
        lblTextoSaldo = new JLabel("Saldo Disponible");
        lblTextoSaldo.setAlignmentX(Component.CENTER_ALIGNMENT);
       
        encabezado.add(labelConImagen);
        encabezado.add(titulo);
        encabezado.add(lblSaldo);
        encabezado.add(lblTextoSaldo);
       
        principal.add(encabezado, BorderLayout.NORTH);

        JPanel panelCentro = new JPanel();
        panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.Y_AXIS));
       
        JLabel tituloMonedas = new JLabel("INGRESAR MONEDAS");
        tituloMonedas.setFont(new Font("Times New Roman", Font.BOLD, 20));
        tituloMonedas.setAlignmentX(Component.CENTER_ALIGNMENT);
       
        JPanel botones = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 12));
        btn50 = new JButton("$50");
        btn100 = new JButton("$100");
        btn200 = new JButton("$200");
        btn500 = new JButton("$500");
        btn1000 = new JButton("$1000");
       
        botones.add(btn50);
        botones.add(btn100);
        botones.add(btn200);
        botones.add(btn500);
        botones.add(btn1000);
       
        panelCentro.add(tituloMonedas);
        panelCentro.add(botones);
       
        JPanel panelResumen = new JPanel(new GridLayout(6, 2, 5, 2));
        panelResumen.setBorder(BorderFactory.createTitledBorder("Resumen de la alcancia"));

        lbl50 = new JLabel("0");
        lbl100 = new JLabel("0");
        lbl200 = new JLabel("0");
        lbl500 = new JLabel("0");
        lbl1000 = new JLabel("0");
        lblTotal = new JLabel("0");

        panelResumen.add(new JLabel("Monedas de $50:")); panelResumen.add(lbl50);
        panelResumen.add(new JLabel("Monedas de $100:")); panelResumen.add(lbl100);
        panelResumen.add(new JLabel("Monedas de $200:")); panelResumen.add(lbl200);
        panelResumen.add(new JLabel("Monedas de $500:")); panelResumen.add(lbl500);
        panelResumen.add(new JLabel("Monedas de $1000:")); panelResumen.add(lbl1000);
        panelResumen.add(new JLabel("TOTAL DE MONEDAS:")); panelResumen.add(lblTotal);

        panelCentro.add(panelResumen);

        btnVaciar = new JButton("VACIAR ALCANCIA");
        btnVaciar.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelCentro.add(Box.createRigidArea(new Dimension(0, 10)));
        panelCentro.add(btnVaciar);

        principal.add(panelCentro, BorderLayout.CENTER);
        add(principal);
    }
    
    public void actualizarVista(int saldo, int m50, int m100, int m200, int m500, int m1000, int total){
        lblSaldo.setText("$" + saldo);
        lbl50.setText(String.valueOf(m50));
        lbl100.setText(String.valueOf(m100));
        lbl200.setText(String.valueOf(m200));
        lbl500.setText(String.valueOf(m500));
        lbl1000.setText(String.valueOf(m1000));
        lblTotal.setText(String.valueOf(total));
    }
    
    public void agregarListeners(ActionListener listener) {
        btn50.addActionListener(listener);
        btn100.addActionListener(listener);
        btn200.addActionListener(listener);
        btn500.addActionListener(listener);
        btn1000.addActionListener(listener);
        btnVaciar.addActionListener(listener);
    }
}