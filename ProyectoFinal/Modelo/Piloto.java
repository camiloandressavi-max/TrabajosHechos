package Modelo;


/**
 * Write a description of class Piloto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Piloto extends Persona {
   private String idLicenciaVuelo;
   
   
   
    public Piloto(String cedula, String nombre, int edad, String idLicenciaVuelo) {
        super(cedula, nombre, edad);
        this.idLicenciaVuelo = idLicenciaVuelo;
    }
    

    public String getIdLicenciaVuelo() {
        return idLicenciaVuelo;
    }

    public void setidLicenciaVuelo(String idLicenciaVuelo) {
        this.idLicenciaVuelo = idLicenciaVuelo;
    }

    @Override
    public String toString() {
        return "Piloto " + super.toString() + ", ID de Licencia de Vuelo: " + idLicenciaVuelo ;
    }
}
