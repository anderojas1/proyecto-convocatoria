

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
        sentenciaSql="INSERT INTO FormacionTic VALUES ('"+forT.getIdentificacion()+"', '"+forT.getTitulo()+
                       "', "+forT.getConsecutivo()+", '"+forT.getSoporte()+"', "+forT.getPuntaje()+");";
        
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
}
