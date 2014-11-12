/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import AccesoDatos.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import logica.conocimientosEspecificos;

/**
 *
 * @author jhonkrave
 */
public class DriverConocimientosEsp {
    
    DaoconociminetoEspecific Daoce;

    public DriverConocimientosEsp() {
    
        Daoce = new DaoconociminetoEspecific();
    
    }
    
    
    public void guaradarConociemientoEspecifico (String id, String JLherram_Ofimatic, String JLherram_Web2, 
                                                    String JLherram_edic_multi, String JLexp_des_cont_edu_dig, 
                                                    String JLexp_des_lib_dig, String JLexp_proc_elearning, String JLexp_gest_proy_TIC, 
                                                    String JLexp_des_elemnts_eval_comp, double puntuacion){
    
        conocimientosEspecificos ce = new conocimientosEspecificos(id, JLherram_Ofimatic, JLherram_Web2, JLherram_edic_multi, JLexp_des_cont_edu_dig, JLexp_des_lib_dig, JLexp_proc_elearning, JLexp_gest_proy_TIC, JLexp_des_elemnts_eval_comp, puntuacion);
        try {
            Daoce.InsertConocimientoEspficic(ce);
            System.out.println("se alamacenado con exito los cono_espcific");
            JOptionPane.showMessageDialog(null, "Se ha guardado los conocimientos especificos del aspirante con exito", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
        
        } catch (SQLException ex) {
            
            System.out.println("eerro al guardar conoc_espefici"+ex.getMessage());
            
        }
    
    }
    
    
    public conocimientosEspecificos consultarConocimientoEspecific(String id){
    
        return Daoce.selectConocimientoEspecific(id);
    
    }
    
    public void updateConocimientoEspecific(String id, String JLherram_Ofimatic, String JLherram_Web2, 
                                                    String JLherram_edic_multi, String JLexp_des_cont_edu_dig, 
                                                    String JLexp_des_lib_dig, String JLexp_proc_elearning, String JLexp_gest_proy_TIC, 
                                                    String JLexp_des_elemnts_eval_comp, double puntuacion){
    
        conocimientosEspecificos ce = new conocimientosEspecificos(id, JLherram_Ofimatic, JLherram_Web2, JLherram_edic_multi, JLexp_des_cont_edu_dig, JLexp_des_lib_dig, JLexp_proc_elearning, JLexp_gest_proy_TIC, JLexp_des_elemnts_eval_comp, puntuacion);
        try {
            Daoce.UpdateConocimentoEspecific(ce);
            JOptionPane.showMessageDialog(null, "Se ha Actualizado los conocimientos específicos del aspirante con exito", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            
            System.out.println("error al actualizar conocimiento"+ex.getMessage());
        }
    
    }
    
    
    
   
    public double calcularPuntuacionTotal(String [] results){
    
        double resultado=0;
        
        for (int i = 0; i < results.length; i++) {
           
            resultado+= getPuntuacionNivel(results[i]);
            
        }
    
        return resultado;
    }
    
    public double getPuntuacionNivel (String nivel){
    
        switch (nivel){
        
            case "Regular" : return 0.7;
            case "Bueno"   : return  1.3;
            case "Muy Bueno" : return 2.5;    
            default: return 0;
        }
        
       
    
    }
}
