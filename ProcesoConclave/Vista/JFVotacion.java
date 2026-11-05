package Vista;
import javax.swing.*;
import java.awt.*;

/**
 * Write a description of class JFVotacion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JFVotacion extends JFrame
{
    private JLabel lblLista= new JLabel("Lista De Cardenales: ");
    private JComboBox<String> cmbLista= new JComboBox<>(new String[]{"Seleccionar"});
    
    private JButton btnVotar = new JButton("Votar");    
    private JLabel lblRonda= new JLabel ("Ronda n°");
    
    private JTextField txtRonda= new JTextField(10);
    
    private JTextArea txtArea= new JTextArea(200,150);
    private JScrollPane s= new JScrollPane(txtArea);
    
    private JButton btnResultados= new JButton ("Mostrar Resultados");
    private JButton btnRonda= new JButton("Siguiente Ronda");
    
    public JFVotacion(){
        setTitle("");
        setSize(600,450);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        crearInterfaz();
        
        setVisible(true);
        
        
        
        
    }
    
    
    public void crearInterfaz(){
        txtRonda.setEditable(false);
        JPanel principal= new JPanel();
        principal.setLayout(new BoxLayout(principal, BoxLayout.Y_AXIS));
        
        JPanel a = new  JPanel();
        
        
        a.add(lblLista);
        a.add(cmbLista);
        
        principal.add(a);
        
        JPanel asegundo= new JPanel();
        asegundo.setLayout(new BorderLayout());
        
        asegundo.add(new JLabel("                                                                    "),BorderLayout.WEST);
        asegundo.add(btnVotar,BorderLayout.CENTER);
        JPanel auxiliar= new JPanel();
        auxiliar.add(lblRonda);
        auxiliar.add(txtRonda);
        
        asegundo.add(auxiliar,BorderLayout.EAST);
        
        
        principal.add(asegundo);
        JPanel b= new JPanel();
        b.setLayout(new BorderLayout());
        b.add(s,BorderLayout.CENTER);
        b.add(new JLabel("                                        "),BorderLayout.WEST);
        b.add(new JLabel("                                        "),BorderLayout.EAST);
        principal.add(b);
        
        JPanel c = new JPanel();
        
        c.add(btnResultados);
        c.add(btnRonda);
        
        principal.add(c);
        add(principal);
        
        
        
        
    }
    
    
    

}