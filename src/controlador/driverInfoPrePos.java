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
    
    
    public int calcularPuntaje(String ident, int nPuntaje){
        
        int aPuntaje = 0;
        
        int puntaje = 0;
        
        aPuntaje = daoprepos.getApplicant(ident).getPuntModulo();
                         
        puntaje = nPuntaje - aPuntaje;
        
        return puntaje;
        
    }
    
    
    public void recalificar(String id, String convoca){
    
        double puntajeTotal = 0;
        double puntajeNuevo = 0;
        
        try{         
        
            puntajeTotal = daoAspirante.consultarPuntajeUsuario(id, convoca);
        
          }catch(SQLException ex){
            
                System.err.println("Error al consultar la base de datos");
         
          }
        
        
        puntajeNuevo = calcularPuntaje(objPrePos.getIdentificacion(), objPrePos.getPuntModulo()) + puntajeTotal;
        
        try{
            
            daoAspirante.updatePuntajeUsuario(id, convoca, puntajeNuevo);       
        
        }catch(SQLException ex){
        
            System.err.println("Error al consultar la base de datos");
        }
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
}
