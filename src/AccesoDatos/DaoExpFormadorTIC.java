/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logica.ExpFormadorTIC;

/**
 *
 * @author jhonkrave
 */
public class DaoExpFormadorTIC {
    
    Fachada fachada;
    
    String sentenciaSql;
    Connection conectar;
    Statement sentencia;
    ResultSet resultado;

    public DaoExpFormadorTIC() {
        
        fachada = new Fachada();
    }
    
    
    public void insertarExperiencia(ExpFormadorTIC efTIC){
    
        sentenciaSql = "INSERT INTO ExpFormadorTic VALUES('"+efTIC.getId()+"', '"+efTIC.getExpFormerEst()+"', '"+
                efTIC.getExpFormerProf()+"', '"+efTIC.getExpFormertoFormers()+
                "', '"+efTIC.getSoporte_est()+"', '"+efTIC.getSoporte_pro()+"', '"+efTIC.getSoporte_for()+
                "', "+efTIC.getPuntos_est()+", "+efTIC.getPuntos_pro()+", "+efTIC.getPuntos_for()+", "+efTIC.getPuntos_total()+", '"+efTIC.getConvocatoria()+"');";
        try {
            ejecutarSentencia();
        } catch (SQLException ex) {
            System.out.println("no se pudo guardar la experiencia");
        }
    
    }

    private void ejecutarSentencia() throws SQLException{
        
        
        try {
            
            conectar = fachada.conectar();
            sentencia = conectar.createStatement();
            
            sentencia.executeUpdate(sentenciaSql);
            
            conectar.close();
            
        } catch (SQLException ex) {
            
            throw ex;
            
        }
         catch (NullPointerException ex) {
            
            JOptionPane.showMessageDialog(null, "Error en base de datos. No se puede conectar");
            
        }
               
        
        
    }
    
    
    
     public String consultarSoporte(String identificacion, String titulo, String sopor, String tipo_titu, String convocatoria) throws SQLException{
         String soporte="";
         
         sentenciaSql = "SELECT "+sopor+" FROM EXPFORMADORTIC WHERE identificacion ='"+identificacion+"' AND "+tipo_titu+" ='"+
                        titulo+"' AND cod_convocatoria ='"+convocatoria+"';";
         
         try{
            
            conectar= fachada.conectar();
            
            sentencia = conectar.createStatement();

            resultado = sentencia.executeQuery(sentenciaSql);
            
            while (resultado.next()) {
            
                soporte = resultado.getString(1);
                
            }
            
        } catch(SQLException ex) { 
            
            JOptionPane.showMessageDialog(null, "Error en base de datos. No se puede guardar");
        
        } catch (NullPointerException ex) {
            
            JOptionPane.showMessageDialog(null, "Error en base de datos. No se puede conectar");
            
        }
         return soporte;
     }
    public void asignarPuntajeAspirante(String identificacion, String convocatoria, int puntaje) throws SQLException{
         sentenciaSql="UPDATE AspiranteConvocatoria SET puntajetotal = puntajetotal + "+puntaje+" WHERE identificacion = '"+identificacion+"' AND codigo = '"+convocatoria+"';";
         ejecutarSentencia();
    }
    
    public void editarExperiencia(ExpFormadorTIC efTIC){
        
        sentenciaSql="UPDATE ExpFormadorTic SET exp_estudiante = '"+efTIC.getExpFormerEst()+
                "', exp_profesor = '"+efTIC.getExpFormerProf()+"', exp_formador = '"+efTIC.getExpFormertoFormers()+
                "', soporte_estudiante = '"+efTIC.getSoporte_est()+"', soporte_profesor = '"+efTIC.getSoporte_pro()+
                "', soporte_formador = '"+efTIC.getSoporte_for()+"', puntaje_estudiante = '"+efTIC.getPuntos_est()+
                "', puntaje_profesor = '"+efTIC.getPuntos_pro()+"', puntaje_formador = '"+efTIC.getPuntos_for()+
                "', puntaje_total = '"+efTIC.getPuntos_total()+
                "' WHERE identificacion = '"+efTIC.getId()+"' and  cod_convocatoria = '"+efTIC.getConvocatoria()+"';";
        
         try {
            ejecutarSentencia();
        } catch (SQLException ex) {
            System.out.println("no se pudo editar la experiencia");
        }
    }
    
    public void editarPuntajeAspirante(String id, String convo, int pun_nue) throws SQLException{
        String soporte="";
        int pun_vie = Integer.parseInt(soporte);
        sentenciaSql = "select puntaje_total from expformadortic where identificacion = '"+id+"' and cod_covocatoria = '"+convo+"';";
        
        try{
            
            conectar= fachada.conectar();
            
            sentencia = conectar.createStatement();

            resultado = sentencia.executeQuery(sentenciaSql);
            
            while (resultado.next()) {
            
                soporte = resultado.getString(1);
                
            }
            
        } catch(SQLException ex) { 
            
            JOptionPane.showMessageDialog(null, "Error en base de datos. No se puede guardar");
        
        } catch (NullPointerException ex) {
            
            JOptionPane.showMessageDialog(null, "Error en base de datos. No se puede conectar");
            
        }
        int puntaje = pun_nue - pun_vie;
        
        asignarPuntajeAspirante(id, convo, puntaje);
        
    }
    
    
    
}
