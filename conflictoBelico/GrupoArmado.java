
/**
 * Write a description of class GrupoArmado here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GrupoArmado
{
    private String codigo;
    private String nombre;
    private String liderPolitico;
    
    public void sumaBajas(Division division){
        division.sumarBajas();
    }
}