/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.ExpFormadorTIC;

/**
 *
 * @author jhonkrave
 */
public class DaoExpFormadorTIC {
    
    Fachada fachada;
    
    String sentenciaSQL;
    Connection conectar;
    Statement sentencia;
    ResultSet resultado;

    public DaoExpFormadorTIC() {
        
        fachada = new Fachada();
    }
    
    
    public void insertarExperiencia(ExpFormadorTIC efTIC){
    
        sentenciaSQL = "INSERT INTO EXPERIENCIA_FORMADOR_TIC VALUES('"+efTIC.getId()+"', '"+efTIC.getExpFormerEst()+"', "
                + "'"+efTIC.getExpFormerProf()+"', '"+efTIC.getExpFormertoFormers()+"',"+efTIC.getPuntuacion()+");";
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
            
            sentencia.executeUpdate(sentenciaSQL);
            
            conectar.close();
            
        } catch (SQLException ex) {
            
            throw ex;
            
        }
        
    }
    
    
    
}
