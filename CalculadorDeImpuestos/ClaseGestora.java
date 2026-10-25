import java.util.ArrayList;
/**
 * Write a description of class ClaseGestora here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClaseGestora
{
   private ArrayList<Vehiculo> listaVehiculos;

   public ClaseGestora() {
        this.listaVehiculos = new ArrayList<>();
    }
   public void agregarVehiculo(String marca, String linea, int modelo, double valor) {
        
       if(listaVehiculos==null){
            System.out.println("Error");
        }
        else{
        
            listaVehiculos.add(new Vehiculo (marca,linea,modelo,valor));
        
    }
}

    public String buscarPorLinea(String linea) {
        String r="";
                for(Vehiculo v: listaVehiculos){
                            if(v.getLinea().equals(linea)){
  
                    r+=v.toString();
           
           }
            }
    return r;
}

    public Vehiculo buscarPorMarca(String marca) {
    for (Vehiculo v : listaVehiculos) {
        if (v.getMarca().equalsIgnoreCase(marca)) {
            return v; 
        }
    }
    return null; 
}

    public Vehiculo buscarVehiculoMasCaro() {
        if (listaVehiculos.isEmpty()) {
        return null;
    }
    
    Vehiculo masCaro = listaVehiculos.get(0); 
    
    for (Vehiculo v : listaVehiculos) {
        if (v.getValor() > masCaro.getValor()) {
            masCaro = v;
        }
    }
    
    return masCaro;
}

    public double calcularImpuesto(Vehiculo vehiculo, boolean prontoPago, boolean trasladoCuenta, boolean servicioPublico) {
        if (vehiculo == null) {
        return 0.0;
    }
    
    double valorComercial = vehiculo.getValor();
    double impuestoBase = valorComercial * 0.025; 
    
    double descuentoTotal = 0.0;
    
    if (prontoPago) {
        descuentoTotal += 0.10; 
    }
    
    if (trasladoCuenta) {
        descuentoTotal += 0.05;
    }
    
    if (servicioPublico) {
        descuentoTotal += 0.05;
    }
    
    double impuestoFinal = impuestoBase - (impuestoBase * descuentoTotal);
    
    return Math.max(impuestoFinal, 0.0);
}
 
}