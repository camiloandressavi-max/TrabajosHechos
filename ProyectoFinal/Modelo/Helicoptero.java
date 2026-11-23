package Modelo;


/**
 * Write a description of class Helicoptero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Helicoptero extends UnidadOperativa {
    private Piloto piloto;
    private boolean poseeBambiBucket;
    
    public Helicoptero(){
        
    }
    public Helicoptero(String codigo, Piloto piloto, boolean poseeBambiBucket) {
        super(codigo); 
        this.piloto = piloto;
        this.poseeBambiBucket=poseeBambiBucket;
    }
    

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public boolean getPoseeBambiBucket(){
        return poseeBambiBucket;
    }
    public void setPoseeBambiBucket(boolean poseeBambiBucket){
        this.poseeBambiBucket=poseeBambiBucket;
    }

    @Override
    public String toString() {
        return "Helicóptero de Código: " + codigo + ", Piloto: " + piloto.getNombre() + ", Equipado con el sistema Bambi Bucket ";
    }
}
