/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import AccesoDatos.DaoAspForPrePos;
import AccesoDatos.DaoAspirante;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import logica.InfoPrePos;

/**
 *
 * @author julian
 */
public class driverInfoPrePos {
    
    private DaoAspForPrePos daoprepos;
    private DaoAspirante daoAspirante;
    private InfoPrePos objPrePos ;
    
    public driverInfoPrePos(){
    
        daoAspirante = new DaoAspirante();
        daoprepos = new DaoAspForPrePos();
        objPrePos = new InfoPrePos();
        
    }
    
      
    public int calificador(String rtDoc, String rtDocTic, String rtMaestria, String rtMaestriaTic,
                            String rtSpecia, String rtSpeciaTic, String rtLicen){
    
        int calificacion = 0;
           
        if(!rtDocTic.equals("N/A")){
        
            calificacion = 30;
            return calificacion;
        
        }else if(!rtDoc.equals("N/A")){
        
            calificacion = 28;
            return calificacion;
        
        }else if(!rtMaestriaTic.equals("N/A")){
            
            calificacion = 26;
            return calificacion;
        
        }else if(!rtMaestria.equals("N/A")){
        
            calificacion = 24;
            return calificacion;
                   
        }else if(!rtSpeciaTic.equals("N/A")){
        
            calificacion = 20;
            return calificacion;
            
        }else if(!rtSpecia.equals("N/A")){
        
            calificacion = 15;
            return calificacion;
        
        }else if (!rtLicen.equals("N/A")){
        
            calificacion = 10;
            return calificacion;
        }
        
        
        return calificacion;
    }
 
    public void SumarPuntaje(){
     
        double puntajeTotal = 0;
        double puntajeAsp = 0;
        
        try{
        
            puntajeAsp = daoAspirante.consultarPuntajeUsuario(objPrePos.getIdentificacion(), objPrePos.getCod_convo());
        
        }catch(SQLException es){
        
            System.err.println("Error al consultar la base de datos");
        }
        
        puntajeTotal = puntajeAsp + objPrePos.getPuntModulo();
        
        try{
        
            daoAspirante.updatePuntajeUsuario(objPrePos.getIdentificacion(), objPrePos.getCod_convo(), puntajeTotal);
        
        }catch(SQLException es){
        
            System.err.println("Error al consultar la base de datos");
        }
            
    }
    
    public void guardarInfo(String identi, String rtDoc, String rtDocTic, String rtMaestria, String rtMaestriaTic,
                            String rtSpecia, String rtSpeciaTic, String rtLicen, String cod_convo){

        
        objPrePos.setIdentificacion(identi);
        objPrePos.setRtDoctor(rtDocTic);
        objPrePos.setRtDoctorTic(rtDocTic);
        objPrePos.setRtMaestria(rtMaestria);
        objPrePos.setRtMaestriaTic(rtMaestriaTic);
        objPrePos.setRtEspecia(rtSpecia);
        objPrePos.setRtEspeciaTic(rtSpeciaTic);
        objPrePos.setRtLicenciado(rtLicen);
        objPrePos.setCod_convo(cod_convo);
        objPrePos.setPuntModulo(calificador(rtDoc, rtDocTic, rtMaestria, rtMaestriaTic, rtSpecia, rtSpeciaTic, rtLicen));
        
        try{
        
        daoprepos.insertInfoRespaldo(objPrePos);
        
        JOptionPane.showMessageDialog(null, "Se han guardado los campos seleccionados y sus archivos ", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
        
        }catch (SQLException e){
        
            JOptionPane.showMessageDialog(null, "Error al guardar el usuario. Por favor intente nuevamente");
            
        }
        
        SumarPuntaje();
    
    
    }


    public void recalificar(String id_asp, String id_conv){
        
        JOptionPane.showMessageDialog(null, objPrePos.getPuntModulo());
        
        InfoPrePos objPrePos = daoprepos.getApplicant(id_asp, id_conv);
        
        
        
        int puntaje_anterior = 0;
        int puntaje_modulo = 0;
        int puntaje_tmp = 0;
        
        
        puntaje_modulo = objPrePos.getPuntModulo();
     
        try{
        
            puntaje_anterior = (int) daoAspirante.consultarPuntajeUsuario(id_asp, id_conv);
        
        }catch(SQLException e){ System.out.println("Error al acceder a la base de datos");}
        
        puntaje_tmp = puntaje_anterior - puntaje_modulo;
        
        try{
        
            daoAspirante.updatePuntajeUsuario(objPrePos.getIdentificacion(), objPrePos.getCod_convo(), puntaje_tmp);
        
        }catch(SQLException es){
        
            System.err.println("Error al consultar la base de datos");
        }
              
    }

}
