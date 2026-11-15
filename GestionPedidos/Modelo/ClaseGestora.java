package Modelo;

import java.util.*;

public class ClaseGestora {
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Producto> productos = new ArrayList<>();
    private ArrayList<Pedido> pedidos = new ArrayList<>();

    public ClaseGestora() {
        
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    
    public double calcularTotalPedido() {
    double total = 0;
    for (Producto p : productos) {
        total += p.getPrecio();
    }
    return total;
}
}