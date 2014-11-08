/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import AccesoDatos.DaoAspForPrePos;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import logica.InfoPrePos;

/**
 *
 * @author julian
 */
public class driverInfoPrePos {
    
    private DaoAspForPrePos daoprepos;
    
    public driverInfoPrePos(){
    
        daoprepos = new DaoAspForPrePos();
        
    }
    
    public void guardarInfo(String identi, String rtDoc, String rtDocTic, String rtMaestria, String rtMaestriaTic,
                            String rtSpecia, String rtSpeciaTic, String rtLicen){

        InfoPrePos objPrePos = new InfoPrePos();

        objPrePos.setIdentificacion(identi);
        objPrePos.setRtDoctor(rtDocTic);
        objPrePos.setRtDoctorTic(rtDocTic);
        objPrePos.setRtEspecia(rtSpecia);
        objPrePos.setRtEspeciaTic(rtSpeciaTic);
        objPrePos.setRtLicenciado(rtLicen);
        objPrePos.setRtMaestria(rtMaestria);
        objPrePos.setRtMaestriaTic(rtMaestriaTic);
        
        try{
        
        daoprepos.insertInfoRespaldo(objPrePos);
        
        JOptionPane.showMessageDialog(null, "Se han guardado los campos seleccionados y sus archivos ", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
        
        }catch (SQLException e){
        
            JOptionPane.showMessageDialog(null, "Error al guardar el usuario. Por favor intente nuevamente");
            
        }
    
    
    }
}
