/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author SAMSUNG E1
 */
import java.io.*;
public class SaveInformation {
    String informacion;
    FileWriter fileWriter;
    
    public SaveInformation(){
    }
    
    public void guardarInformacion(String informacion){
        try{
            fileWriter= new FileWriter("info/infocantantes.txt");
            BufferedWriter buffWriter= new BufferedWriter(fileWriter);
            buffWriter.write(informacion);
            buffWriter.close();
        }catch(Exception e){
            System.out.println("No se encontro el archivo");
        } finally{
            if(fileWriter != null){
                try{fileWriter.close();
            }catch(Exception err){
                err.printStackTrace();
            }
            }
        }
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }
    
}
