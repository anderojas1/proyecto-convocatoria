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
                "', "+efTIC.getPuntos_est()+", "+efTIC.getPuntos_pro()+", "+efTIC.getPuntos_for()+");";
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
    
    
    
     public String consultarSoporte(String identificacion, String titulo, String sopor, String tipo_titu) throws SQLException{
         String soporte="";
         
         sentenciaSql = "SELECT "+sopor+" FROM ExpFormadorTic WHERE identificacion ='"+identificacion+"' AND "+tipo_titu+" ='"+
                        titulo+"';";
         
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
    
}
