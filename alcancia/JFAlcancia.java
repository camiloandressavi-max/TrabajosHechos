import java.awt.event.*;
import java.awt.*;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.lang.*;
import javax.swing.ImageIcon;
import java.awt.event.*;
/**
 * Write a description of class JFAlcancia here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JFAlcancia extends JFrame implements ActionListener
{
    
    private JLabel lblSaldo;
    private JLabel lblTotal;
    private JLabel lbl50;
    private JLabel lbl100;
    private JLabel lbl200;
    private JLabel lbl500;
    private JLabel lbl1000;
    private JLabel lblTextoSaldo;
    private Alcancia alcancia;
    private JButton btnVaciar;    
    
    public JFAlcancia(){
        alcancia = new Alcancia();
        setTitle("Mi Alcancia -POO I");
        setSize(500,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        crearInterfaz();
        actualizarInterfaz();
        
        
        
        setVisible(true);
        
    }
    
    public void crearInterfaz(){
        JPanel principal =new JPanel();
        principal.setLayout(new BorderLayout(15,15));
        principal.setBorder(new EmptyBorder(20,25,20,25));
        
        JPanel encabezado= new JPanel();
        encabezado.setLayout(new BoxLayout(encabezado,BoxLayout.Y_AXIS));
        
        JLabel titulo=new JLabel("MI ALCANCIA");
        titulo.setFont(new Font("Times New Roman",Font.BOLD,50));
         titulo.setAlignmentX(Component.CENTER_ALIGNMENT);        
   ImageIcon icono = new ImageIcon("C:/Users/Camilo Salazar/OneDrive/Documentos/alcancia-copy-copy/Images/descarga.jpg");
   JLabel labelConImagen = new JLabel(icono);
   
   lblSaldo= new JLabel("$0");
   lblSaldo.setFont(new Font("Times New Roman", Font.BOLD,50));
   lblSaldo.setAlignmentX(Component.CENTER_ALIGNMENT);
   
   lblTextoSaldo= new JLabel ("Saldo Disponible");
   lblSaldo.setAlignmentX(Component.CENTER_ALIGNMENT);
   
   
   
   encabezado.add(labelConImagen);
   encabezado.add(titulo);
   encabezado.add(lblSaldo);
   encabezado.add(lblTextoSaldo);
   
   principal.add(encabezado,BorderLayout.NORTH);

   //centro
   
   JPanel panelCentro= new JPanel();
   panelCentro.setLayout(new BoxLayout(panelCentro,BoxLayout.Y_AXIS));
   
   JLabel tituloMonedas= new JLabel("INGRESAR MONEDAS");
   tituloMonedas.setFont(new Font("Times New Roman",Font.BOLD,20));
   tituloMonedas.setAlignmentX(Component.CENTER_ALIGNMENT);
   
   JPanel botones = new JPanel (new FlowLayout(FlowLayout.CENTER,8,12));
   JButton btn50= new JButton("$50");
   JButton btn100= new JButton("$100");
   JButton btn200= new JButton("$200");
   JButton btn500= new JButton("$500");
   JButton btn1000= new JButton("$1000");
   
   
   botones.add(btn50);
   botones.add(btn100);
   botones.add(btn200);
   botones.add(btn500);
   botones.add(btn1000);
   
   btn50.addActionListener(this);
   btn100.addActionListener(this);
   btn200.addActionListener(this);
   btn500.addActionListener(this);
   btn1000.addActionListener(this);
   
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
        btnVaciar.addActionListener(this);
        panelCentro.add(Box.createRigidArea(new Dimension(0, 10)));
        panelCentro.add(btnVaciar);

        principal.add(panelCentro, BorderLayout.CENTER);
        add(principal);
   
   

}
   
    
    public void actualizarInterfaz(){
        lblSaldo.setText("$" + alcancia.getSaldo());
        lbl50.setText(String.valueOf(alcancia.getMonedas50()));
        lbl100.setText(String.valueOf(alcancia.getMonedas100()));
        lbl200.setText(String.valueOf(alcancia.getMonedas200()));
        lbl500.setText(String.valueOf(alcancia.getMonedas500()));
        lbl1000.setText(String.valueOf(alcancia.getMonedas1000()));
        lblTotal.setText(String.valueOf(alcancia.getTotalMonedas()));
    }
    
    @Override
public void actionPerformed(ActionEvent evento) {
    String comando = evento.getActionCommand();

    if (comando.equals("$50")) {
        alcancia.agregarMonedas(50);
    } else if (comando.equals("$100")) {
        alcancia.agregarMonedas(100);
    } else if (comando.equals("$200")) {
        alcancia.agregarMonedas(200);
    } else if (comando.equals("$500")) {
        alcancia.agregarMonedas(500);
    } else if (comando.equals("$1000")) {
        alcancia.agregarMonedas(1000);
    } else if (comando.equals("VACIAR ALCANCIA")) {
        alcancia.vaciar();
    }

    actualizarInterfaz();
}
}
