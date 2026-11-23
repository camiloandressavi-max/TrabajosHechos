package Modelo;


/**
 * Write a description of class UnidadTerrestre here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class UnidadTerrestre extends UnidadOperativa {
    
    private int equipoTotal;
    private boolean equipoCertificado;
    public UnidadTerrestre() {
}
    public UnidadTerrestre(String codigo, int equipoTotal, boolean equipoCertificado) {
        super(codigo);
        this.equipoTotal = equipoTotal;
        this.equipoCertificado = equipoCertificado;
    }

    public int getEquipoTotal() {
        return equipoTotal;
    }

    public void setEquipoTotal(int equipoTotal) {
        this.equipoTotal = equipoTotal;
    }

    public boolean isEquipoCertificado() {
        return equipoCertificado;
    }

    public void setEquipoCertificado(boolean equipoCertificado) {
        this.equipoCertificado = equipoCertificado;
    }

    @Override
    public String toString() {
        String estadoCertificado;
        if (equipoCertificado==true) {
            estadoCertificado = "Posee certificado, puede participar hasta en municipios de nivel de riesgo alto";
        } else {
            estadoCertificado = "Solo puede ingresar hasta rescates de nivel bajo";
        }
        return "Unidad Terrestre de Código: " + codigo + ", Equipo Total: " + equipoTotal + " Certificado: " +  estadoCertificado;
        
            
        
        
    }
}
