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


public class JFTrabajador extends JFrame implements ActionListener
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

        btnSupIzquierda.addActionListener(this);
        btnIzquierda.addActionListener(this);
        btnDerecha.addActionListener(this);
        btnSupDerecha.addActionListener(this);
        btnBuscar.addActionListener(this);
        btnMarca.addActionListener(this);
        btnVehiculo.addActionListener(this);
        btnCalcular.addActionListener(this);
        btnOpcion1.addActionListener(this);
        btnOpcion2.addActionListener(this);

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

    public void actionPerformed(ActionEvent evento) {
        String comando = evento.getActionCommand();

        if (comando.equals("Buscar por linea")) {
            String lineaBusqueda = txtLinea1.getText();
            String resultado = gestion.buscarPorLinea(lineaBusqueda);
            JOptionPane.showMessageDialog(this, resultado.isEmpty() ? "No se encontraron coincidencias" : resultado);
        } else if (comando.equals("Buscar por marca")) {
            String marcaBusqueda = txtLinea2.getText();
            Vehiculo vEncontrado = gestion.buscarPorMarca(marcaBusqueda);
            if (vEncontrado != null) {
                JOptionPane.showMessageDialog(this, vEncontrado.toString());
            } else {
                JOptionPane.showMessageDialog(this, "Vehículo no encontrado");
            }
        } else if (comando.equals("Buscar vehiculo mas caro")) {
            Vehiculo masCaro = gestion.buscarVehiculoMasCaro();
            if (masCaro != null) {
                JOptionPane.showMessageDialog(this, "El vehículo más caro es:\n" + masCaro.toString());
            } else {
                JOptionPane.showMessageDialog(this, "No hay vehículos registrados");
            }
        } else if (comando.equals("Calcular")) {
            try {
                String marca = txtMarca.getText();
                String linea = txtLinea.getText();
                int modelo = Integer.parseInt(txtModelo.getText());
                double valor = Double.parseDouble(txtValor.getText());
                
                // Creamos el objeto temporal para calcular el impuesto
                Vehiculo temp = new Vehiculo(marca, linea, modelo, valor);
                boolean pronto = chkPago.isSelected();
                boolean traslado = chkTraslado.isSelected();
                boolean servicio = chkServicio.isSelected();
                
                double impuesto = gestion.calcularImpuesto(temp, pronto, traslado, servicio);
                JOptionPane.showMessageDialog(this, "El impuesto calculado es: $" + impuesto);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Por favor ingrese valores numéricos válidos en Modelo y Valor.");
            }
        }
    }
}

