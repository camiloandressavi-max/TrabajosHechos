/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cantante;
import Vista.GUIConfiguracion;
import Vista.GUIRegistro;
import Vista.SaveInformation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class Controlador implements ActionListener{
    ArrayList<Cantante> cantantes;
    GUIRegistro vista;
    GUIConfiguracion configuracion;
    SaveInformation save;
    public Controlador(){
        cantantes= new ArrayList<>();
        vista= new GUIRegistro();        
        configuracion= new GUIConfiguracion();
        vista.agragarListener(this);
        configuracion.agregarListener(this);
        save= new SaveInformation();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.btnRegistrar){
            if(datosCompletos()){
                try{
                    cantantes.add(new Cantante(vista.txtNombre.getText(), vista.txtAlbum.getText(), Integer.parseInt(vista.txtNCanciones.getText())));
                    clear();
                }catch(Exception err){
                    vista.mostrarMensaje(1);
                }
            }else{vista.mostrarMensaje(2);}
        }
        if(e.getSource()==vista.btnTerminarRegistro){
            vista.dispose();
            actualizar();
            configuracion.setVisible(true);                        
        }
        
        if(e.getSource()==configuracion.btnBuscar){
            configuracion.txtShow2.setText(toStringInformation(buscarCantantes(Integer.parseInt(configuracion.txtBuscar.getText()))));
        }
        
        if(e.getSource()==configuracion.btnEliminar){
            removerCantante(configuracion.txtEliminar.getText().trim());
            actualizar();
        }
        
    }
    
    public void actualizar(){
        if(!cantantes.isEmpty()){
            configuracion.txtShow1.setText(toStringInformation(cantantes));
            save.guardarInformacion(toStringInformation(cantantes));
        }else{
            configuracion.txtShow1.setText("");
            save.guardarInformacion("");
        }
    }
    
    public Boolean datosCompletos(){
        return !vista.txtNombre.getText().trim().isEmpty() && !vista.txtAlbum.getText().trim().isEmpty() &&
               !vista.txtNCanciones.getText().trim().isEmpty();
    }
    
    public void clear(){
        vista.txtNombre.setText("");
        vista.txtAlbum.setText("");
        vista.txtNCanciones.setText("");
    }
    
    public String toStringInformation(ArrayList<Cantante> cantantesLocal){
        String cadena="";
        cantantesLocal.trimToSize();
        for(Cantante c : cantantesLocal){
            cadena+= c.getNombre()+" , "+c.getAlbum()+" , "+c.getnCanciones()+"\n";
        }
        return cadena;
    }
    
    public ArrayList<Cantante> buscarCantantes(Integer x){
        ArrayList<Cantante> cantantesLocal= new ArrayList<>();
        cantantes.trimToSize();
        for(Cantante c : cantantes){
            if(c.getnCanciones()>x){
                cantantesLocal.add(c);
            }
        }
        return cantantesLocal;
    }
    
    public void removerCantante(String nombre){
        cantantes.trimToSize();
        if(!cantantes.isEmpty()){
            int cont = 0;
            for(Cantante c : cantantes){
                if(c.getNombre().equals(nombre)){
                    cantantes.remove(cont);
                    return;
                }
                cont++;
            }
        }
    }
    
    public static void main(String[] args) {
        Controlador c= new Controlador();
        c.vista.setVisible(true);
    }
}
