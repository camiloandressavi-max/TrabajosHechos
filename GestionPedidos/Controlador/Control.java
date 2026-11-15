package Controlador;
import Modelo.*;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Write a description of class Control here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Control implements ActionListener
{
   JFTGestion vista;
   ClaseGestora modelo;
   
   public Control(JFTGestion vista, ClaseGestora modelo){
       this.vista= vista;
       this.modelo= modelo;
       
       vista.getBtnAgregarProducto().addActionListener(this);
       vista.getBtnEliminarProducto().addActionListener(this);
       vista.getBtnNuevoPedido().addActionListener(this);
       vista.getBtnLimpiar().addActionListener(this);
       vista.getBtnSalir().addActionListener(this);
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
    if (e.getSource() == vista.getBtnAgregarProducto()) {
            String codigo = vista.getTxtCodigoProducto().getText();
            String nombre = vista.getTxtNombreProducto().getText();
            double precio = Double.parseDouble(vista.getTxtPrecio().getText());

            Producto producto = new Producto(codigo, nombre, precio);
            modelo.getProductos().add(producto);
            vista.getModeloTabla().addRow(new Object[]{codigo, nombre, precio});

            
    } else if (e.getSource() == vista.getBtnEliminarProducto()) {
        int u=vista.getModeloTabla().getRowCount()-1;
        if(u >=0){
         modelo.getProductos().remove(u); 
            modelo.getProductos().remove(u);
            vista.getModeloTabla().removeRow(u);
            
        }
    } else if (e.getSource() == vista.getBtnNuevoPedido()) {
        double totalFinal = modelo.calcularTotalPedido();
    vista.getLblTotal().setText("$ " + totalFinal);

    vista.getModeloTabla().setRowCount(0);

    modelo.getProductos().clear();
    } else if (e.getSource() == vista.getBtnLimpiar()) {
        vista.getTxtNumeroPedido().setText("");
    vista.getTxtCedula().setText("");
    vista.getTxtNombreCliente().setText("");
    vista.getTxtCodigoProducto().setText("");
    vista.getTxtNombreProducto().setText("");
    vista.getTxtPrecio().setText("");
    } else if (e.getSource() == vista.getBtnSalir()) {
        System.exit(0);
    }
   }
}