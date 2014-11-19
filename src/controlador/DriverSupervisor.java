/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import AccesoDatos.DaoAspirante;
import java.util.ArrayList;

/**
 *
 * @author kegisan
 */
public class DriverSupervisor {
    
    DaoAspirante daoA;

    public DriverSupervisor() {
        
        daoA = new DaoAspirante();
    }
    
    
    public ArrayList<Object> getListaAspirantes(String cod_convocatoria){
    
        return daoA.getListApirantes(cod_convocatoria);
    
    }
    
    
    
    
    
    
    
    
}
