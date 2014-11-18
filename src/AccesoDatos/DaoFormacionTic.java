

package AccesoDatos;

import java.sql.*;
import javax.swing.JOptionPane;
import logica.formacionTic;

public class DaoFormacionTic {
    
    private final Fachada fachadaConectar;
    private String sentenciaSql;
    private Connection conectar;
    private Statement sentencia;
    private ResultSet registros;
    
    public DaoFormacionTic(){
        fachadaConectar = new Fachada();
    }
    
    public void crearFormacionTic(formacionTic forT) throws SQLException{
        sentenciaSql="INSERT INTO FormacionTic VALUES ('"+forT.getIdentificacion()+"', '"+forT.getConvocatoria()+"', '"+forT.getTitulo()+
                       "', "+forT.getConsecutivo()+", '"+forT.getSoporte()+"', "+forT.getPuntaje()+", false);";
        
        ejecutarSentencia();
    }
    
     public void ejecutarSentencia () throws SQLException {
        
        try{
            
            conectar= fachadaConectar.conectar();
            
            sentencia = conectar.createStatement();
            sentencia.executeUpdate(sentenciaSql);
            
            conectar.close();
            
        } catch(SQLException ex) { 
            
            throw ex;
        
        } catch (NullPointerException ex) {
            
            JOptionPane.showMessageDialog(null, "Error en base de datos. No se puede conectar");
            
        }
        
    }
     
     public String consultarSoporte(String identificacion, String titulo) throws SQLException{
         String soporte="";
         
         sentenciaSql = "SELECT soporte FROM FormacionTic WHERE identificacion ='"+identificacion+"' AND titulo ='"+
                        titulo+"';";
         
         try{
            
            conectar= fachadaConectar.conectar();
            
            sentencia = conectar.createStatement();

            registros = sentencia.executeQuery(sentenciaSql);
            
            while (registros.next()) {
            
                soporte = registros.getString(1);
                
            }
            
        } catch(SQLException ex) { 
            
            JOptionPane.showMessageDialog(null, "Error en base de datos. No se puede guardar");
        
        } catch (NullPointerException ex) {
            
            JOptionPane.showMessageDialog(null, "Error en base de datos. No se puede conectar");
            
        }
         return soporte;
     }
     
     public int maximoPuntajeInscripcion(String identificacion_aspirante, String codigo_convocatoria) throws SQLException{
         sentenciaSql="SELECT MAX(puntaje) FROM formaciontic WHERE identificacion = '"+identificacion_aspirante+"' AND codigo_convocatoria = '"+codigo_convocatoria+"';";
         int puntaje=0;
         
         try{
            
            conectar= fachadaConectar.conectar();
            
            sentencia = conectar.createStatement();

            registros = sentencia.executeQuery(sentenciaSql);
            
            while (registros.next()) {
            
                puntaje = registros.getInt(1);
                
            }
            
        } catch(SQLException ex) { 
            
            JOptionPane.showMessageDialog(null, "Error en base de datos. No se puede guardar");
        
        } catch (NullPointerException ex) {
            
            JOptionPane.showMessageDialog(null, "Error en base de datos. No se puede conectar");
            
        }
         
         return puntaje;
     }
     
     public void asignarPuntajeInscripcion(String identificacion, String codigo_convocatoria, int nuevo_puntaje, int maximo_puntaje)throws SQLException{
 
         
         if(maximo_puntaje < nuevo_puntaje){
         int diferencia = nuevo_puntaje - maximo_puntaje;
         sentenciaSql="UPDATE AspiranteConvocatoria SET puntajetotal = puntajetotal + "+diferencia+" WHERE identificacion = '"+identificacion+"' AND codigo = '"+codigo_convocatoria+"';";
         ejecutarSentencia();
         }
     }
}
