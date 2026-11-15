package Vista;
import Modelo.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.lang.*;
import javax.swing.ImageIcon;
import java.awt.event.*;
/**
 * Write a description of class JFTrabajador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


public class JFTrabajador extends JFrame 
{

    private JButton btnSupIzquierda, btnIzquierda, btnDerecha, btnSupDerecha, btnBuscar,btnMarca,btnVehiculo,btnCalcular,btnOpcion1,btnOpcion2;
    
   private JTextField txtMarca,txtLinea, txtModelo, txtValor,txtLinea1,txtLinea2;
   private JCheckBox chkPago, chkTraslado, chkServicio;
   private ClaseGestora gestion;
   private int indiceActual = 0;
    
    public JFTrabajador(){
        gestion = new ClaseGestora();
    setTitle("Calculo de impuestos");
        setSize(500, 750);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        txtMarca = new JTextField();
        txtLinea = new JTextField();
        txtModelo = new JTextField();
        txtValor = new JTextField();

        txtLinea1 = new JTextField();
        txtLinea2 = new JTextField();

        btnSupIzquierda = new JButton("<<");
        btnIzquierda = new JButton("<");
        btnDerecha = new JButton(">");
        btnSupDerecha = new JButton(">>");

        btnBuscar = new JButton("Buscar por linea");
        btnMarca = new JButton("Buscar por marca");
        btnVehiculo = new JButton("Buscar vehiculo mas caro");

        btnCalcular = new JButton("Calcular");
        btnOpcion1 = new JButton("Opcion 1");
        btnOpcion2 = new JButton("Opcion 2");

        chkPago = new JCheckBox("Pronto pago");
        chkServicio = new JCheckBox("Servicio publico");
        chkTraslado = new JCheckBox("Traslado de cuenta");

        

        crearInterfaz();

        setVisible(true);
    }   

    public void crearInterfaz() {
        JPanel principal = new JPanel();
        principal.setLayout(new BoxLayout(principal, BoxLayout.Y_AXIS));
        principal.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout(FlowLayout.CENTER));
        ImageIcon calculador = new ImageIcon("C:/Users/Estudiante/OneDrive/Documentos/taller-copy/Imagenes/images1.png");
        JLabel imagen = new JLabel(calculador);
        p1.add(imagen);
        principal.add(p1);

        JPanel p2 = new JPanel(new BorderLayout(5, 5));
        p2.setBorder(BorderFactory.createTitledBorder("Datos del vehiculo"));

        JPanel p2Datos = new JPanel(new GridLayout(4, 2, 5, 5));
        p2Datos.add(new JLabel("Marca:"));
        p2Datos.add(txtMarca);
        p2Datos.add(new JLabel("Linea:"));
        p2Datos.add(txtLinea);
        p2Datos.add(new JLabel("Modelo:"));
        p2Datos.add(txtModelo);
        p2Datos.add(new JLabel("Valor:"));
        p2Datos.add(txtValor);

        JPanel p2Navegacion = new JPanel(new GridLayout(1, 4, 5, 5));
        p2Navegacion.add(btnSupIzquierda);
        p2Navegacion.add(btnIzquierda);
        p2Navegacion.add(btnDerecha);
        p2Navegacion.add(btnSupDerecha);

        p2.add(p2Datos, BorderLayout.CENTER);
        p2.add(p2Navegacion, BorderLayout.SOUTH);
        principal.add(p2);

        JPanel p3 = new JPanel(new GridLayout(3, 2, 5, 5));
        p3.setBorder(BorderFactory.createTitledBorder("Busquedas"));

        p3.add(txtLinea1);
        p3.add(btnBuscar);
        p3.add(txtLinea2);
        p3.add(btnMarca);
        p3.add(new JLabel("")); 
        p3.add(btnVehiculo);
        principal.add(p3);

        JPanel p4 = new JPanel(new GridLayout(2, 2, 5, 5));
        p4.setBorder(BorderFactory.createTitledBorder("Descuentos"));
        p4.add(chkPago);
        p4.add(chkTraslado);
        p4.add(chkServicio);
        principal.add(p4);

        JPanel p5 = new JPanel(new GridLayout(1, 3, 5, 5));
        p5.setBorder(BorderFactory.createTitledBorder("Opciones"));
        p5.add(btnCalcular);
        p5.add(btnOpcion1);
        p5.add(btnOpcion2);
        principal.add(p5);

        add(principal);
    }
    
    public JTextField getTxtMarca(){
        return txtMarca;
    }
    
    public void setTxtMarca(JTextField txtMarca){
        this.txtMarca= txtMarca;
    }
    
    public JTextField getTxtLinea(){
        return txtLinea;
    }
    
    public void setTxtLinea(JTextField txtLinea){
        this.txtLinea= txtLinea;
    }
    
    public JTextField getTxtModelo(){
        return txtModelo;
    }
    
    public void setTxtModelo(JTextField txtModelo){
        this.txtModelo= txtModelo;
    }
    
    public JTextField getTxtValor(){
        return txtValor;
    }
    
    public void setTxtValor(JTextField txtValor){
        this.txtValor= txtValor;
    }
    
    public JTextField getTxtLinea1(){
        return txtLinea1;
    }
    
    public void setTxtLinea1(JTextField txtLinea1){
        this.txtLinea1= txtLinea1;
    }
    
    public JTextField getTxtLinea2(){
        return txtLinea2;
    }
    
    public void setTxtLinea2(JTextField txtLinea2){
        this.txtLinea2= txtLinea2;
    }
    
    public JButton getBtnBuscar(){
        return btnBuscar;
    }
    
    public void setTxtLinea2(JButton btnBuscar){
        this.btnBuscar= btnBuscar;
    }
    public JButton getBtnMarca(){
        return btnMarca;
    }
    
    public void setBtnMarca(JButton btnMarca){
        this.btnMarca= btnMarca;
    }
    public JButton getBtnVehiculo(){
        return btnVehiculo;
    }
    
    public void setBtbVehiculo(JButton btnVehiculo){
        this.btnVehiculo= btnVehiculo;
    }
    public JButton getBtnCalcular(){
        return btnCalcular;
    }
    
    public void setBtnCalcular(JButton btnCalcular){
        this.btnCalcular= btnCalcular;
    }
    
    public JCheckBox getChkPago(){
        return chkPago;
    }
    
    public void setChkPago(JCheckBox chkPago){
        this.chkPago= chkPago;
    }
    
    public JCheckBox getChkTraslado(){
        return chkTraslado;
    }
    
    public void setChkTraslado(JCheckBox chkTraslado){
        this.chkTraslado= chkTraslado;
    }
    
    public JCheckBox getChkServicio(){
        return chkServicio;
    }
    
    public void setChkServicio(JCheckBox chkServicio){
        this.chkServicio= chkServicio;
    }
    
    
    
    
    
    
    
    
    
}

