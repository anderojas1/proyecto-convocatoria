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
}
