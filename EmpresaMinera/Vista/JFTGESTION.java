package Vista;
import java.awt.*;
import java.lang.*;
import javax.swing.*;

/**
 * Write a description of class JFTGESTION here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JFTGESTION extends JFrame 
{
    public JLabel lblCodigo, lblDescripcion, lblTipo,lblNivel;
    public JTextField txtCodigo,txtDescripcion, txtTipo,txtNivel;
    public JButton btnAgregar, btnBuscar, btnEliminar, btnListar;
    public JTextArea areaSalida;
   public JFTGESTION(){
       setTitle("Gestion Riesgos");
       setSize(600,400);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setLayout(new BorderLayout());
        
       JPanel entrada= new JPanel(new GridLayout(5,2));
       lblCodigo= new JLabel("Codigo: ");
       lblDescripcion = new JLabel("Descripcion: ");
       lblTipo= new JLabel("Tipo: ");
       lblNivel= new JLabel("Nivel De Riesgo: ");
       
       txtCodigo= new JTextField();
       txtDescripcion= new JTextField();
       txtTipo= new JTextField();
       txtNivel= new JTextField();
       
       entrada.add(lblCodigo);
       entrada.add(txtCodigo);
       entrada.add(lblDescripcion);
       entrada.add(txtDescripcion);
       entrada.add(lblTipo);
       entrada.add(txtTipo);
       entrada.add(lblNivel);
       entrada.add(txtNivel);
       
       JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
       btnAgregar = new JButton("Agregar");
       btnBuscar = new JButton("Buscar");
       btnEliminar = new JButton("Eliminar");
       btnListar = new JButton("Listar");
        
       panelBotones.add(btnAgregar);
       panelBotones.add(btnBuscar);
       panelBotones.add(btnEliminar);
       panelBotones.add(btnListar);
       
       areaSalida = new JTextArea();
       areaSalida.setEditable(false);
       JScrollPane scrollSalida = new JScrollPane(areaSalida);
       
       add(entrada, BorderLayout.NORTH);
       add(scrollSalida, BorderLayout.CENTER);
       add(panelBotones, BorderLayout.SOUTH);
        
       setVisible(true);
   }
}