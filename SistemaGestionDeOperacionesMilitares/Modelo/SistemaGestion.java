package Modelo;

import java.util.*;
/**
 * Write a description of class SistemaGestion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SistemaGestion
{
    private ArrayList<OperacionesMilitares> operacion= new ArrayList<>();
    
    
    public SistemaGestion(){
    }

    
    
public void registrarNuevaOperacion(OperacionesMilitares m){
    if(m!=null){
        
        operacion.add(m);
    }
    else{
        System.out.println("No son validos los datos");
    }
    
}

public String consultarTodasLasOperacionesRegistradas(){
    String me= "";
    if(operacion.isEmpty()){
            return me="Esta vacia la lista";
        }
    for(OperacionesMilitares m: operacion){
        
        
    me+=m.toString();

    }

    return me;
}

public boolean buscarOperacion(String codigo){
    if(operacion.isEmpty()){
        return false;
    }
    for(OperacionesMilitares m: operacion){
    
    if(codigo.equals(m.getCodigo())){
    
    String me= m.getCodigo();
    System.out.println("La Operacion de codigo"+ codigo+ "Existe");
    
    return true;

}
    
    
}
    return false;

}

public String cambiarEstado(Estado m1,String codigo){
    if(operacion.isEmpty()){
        return "no se puede cambiar";
    }
    for(OperacionesMilitares m: operacion){
        if(codigo.equals(m.getCodigo())){
        m.setEstado(m1);
        
        return "El estado se ha cambiado existosamente"; 
    }
    
}
    return "digite bien";

}

public String operacionesDeUnTipo(Estado c){
    String mensaje = "";
    if(operacion.isEmpty()){
        return "Esta vacio pa";
  }
  for(OperacionesMilitares m: operacion){
      if(m.getEstado().equals(c)){
           mensaje += m.toString();
      }
                return mensaje;

  }
    return "incorrecto";
}

public String mostrarNivelComplejidad(String codigo){
    String mensaje ="";
    if(operacion.isEmpty()){
        return "Esta vacio pa";
  }
  for(OperacionesMilitares m: operacion){
      if(m.getCodigo().equals(codigo)){
          
          
        return "el nivel de complejidad es: " +   m.calcularComplejidad();
      }
        
      return mensaje;
  }
    return "incorrecto";
}

public String operacionMayorComplejidad(){
   int p = -1;
   String mayor= "";
    if(operacion.isEmpty()){
        return "Esta vacio pa";
  }
  for(OperacionesMilitares m: operacion){
      
      if(m.calcularComplejidad()>p){
          p=m.calcularComplejidad();
           mayor= m.getCodigo();
      }
      
       return "La operacion con mayor complejidad es del codigo: " +mayor+ "con una complejidad de: " +p;
      }
        
      return "mal digitado";
  }
}




