/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import logica.ExpFormadorTIC;
import AccesoDatos.DaoExpFormadorTIC;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author jhonkrave
 */
public class DriverExperienciaFormadorTIC {
    
    private DaoExpFormadorTIC DaoExpFormerTIc;

    public DriverExperienciaFormadorTIC() {
        
        DaoExpFormerTIc = new DaoExpFormadorTIC();
    }
    
    
    public void guardarExperiencia(String id, String ExpFormerProf, String ExpFormerEst, String ExpFormertoFormers, String soporte_est, String soporte_pro, String soporte_for, int puntaje_est, int puntaje_pro, int puntaje_for){
    
       
        ExpFormadorTIC expFormerTIC = new ExpFormadorTIC(id, ExpFormerProf, ExpFormerEst, ExpFormertoFormers, soporte_est, soporte_pro, soporte_for, puntaje_est, puntaje_pro, puntaje_for);
        
        DaoExpFormerTIc.insertarExperiencia(expFormerTIC);
        
    
    }
    
    
    public String consultarSoporte(String identificacion, String titutlo, String sopor, String tipo_titu){
        String link_soporte="";
        try{
            link_soporte = DaoExpFormerTIc.consultarSoporte(identificacion, titutlo, sopor, tipo_titu);
            
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al guardar la formacion en Tic. Por favor intente nuevamente");
        }
        return link_soporte;
    }
    
    
    
    
}
