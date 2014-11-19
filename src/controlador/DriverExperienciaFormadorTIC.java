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
    
    
    public void guardarExperiencia(String id, String ExpFormerProf, String ExpFormerEst, String ExpFormertoFormers, String soporte_est, String soporte_pro, String soporte_for, int puntaje_est, int puntaje_pro, int puntaje_for, int puntaje_to, String cod_convo){
    
       
        ExpFormadorTIC expFormerTIC = new ExpFormadorTIC(id, ExpFormerProf, ExpFormerEst, ExpFormertoFormers, soporte_est, soporte_pro, soporte_for, puntaje_est, puntaje_pro, puntaje_for, puntaje_to, cod_convo);
        
        DaoExpFormerTIc.insertarExperiencia(expFormerTIC);
        
    
    }
    
    
    public String consultarSoporte(String identificacion, String titutlo, String sopor, String tipo_titu, String cod_convo){
        String link_soporte="";
        try{
            link_soporte = DaoExpFormerTIc.consultarSoporte(identificacion, titutlo, sopor, tipo_titu, cod_convo);
            
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al guardar la formacion en Tic. Por favor intente nuevamente");
        }
        return link_soporte;
    }
    
    
    public void asignarPuntajeAspirante(String identificacion, String convocatoria, int puntaje){
        try{
            DaoExpFormerTIc.asignarPuntajeAspirante(identificacion, convocatoria, puntaje);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al insertar el puntaje del aspirante en la convocatoria. Por favor intente nuevamente");
        }
    }
    
}
