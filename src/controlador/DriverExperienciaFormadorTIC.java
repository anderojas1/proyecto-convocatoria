/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import logica.ExpFormadorTIC;
import AccesoDatos.DaoExpFormadorTIC;

/**
 *
 * @author jhonkrave
 */
public class DriverExperienciaFormadorTIC {
    
    private DaoExpFormadorTIC DaoExpFormerTIc;

    public DriverExperienciaFormadorTIC() {
        
        DaoExpFormerTIc = new DaoExpFormadorTIC();
    }
    
    
    public void guardarExperiencia(String id, String ExpFormerProf, String ExpFormerEst, String ExpFormertoFormers){
    
       
        ExpFormadorTIC expFormerTIC = new ExpFormadorTIC(id, ExpFormerProf, ExpFormerEst, ExpFormertoFormers);
        
        DaoExpFormerTIc.insertarExperiencia(expFormerTIC);
        
    
    }
    
    
    
    
}
