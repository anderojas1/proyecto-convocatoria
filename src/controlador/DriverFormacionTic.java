

package controlador;

import AccesoDatos.DaoFormacionTic;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import logica.formacionTic;

public class DriverFormacionTic {
    
    private DaoFormacionTic daoFormacionTic;
    
    public DriverFormacionTic(){
        daoFormacionTic = new DaoFormacionTic();
    }
    
    public void guardar(String identificacion, String titulo, int consecutivo, String soporte){
        
        formacionTic formacion = new formacionTic(identificacion, titulo, consecutivo, soporte);
        
        try{
            daoFormacionTic.crearFormacionTic(formacion);
            JOptionPane.showMessageDialog(null, "Se ha guardado la formacion en TIC con exito", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al guardar la formacion en Tic. Por favor intente nuevamente");
        }
    }
    
    
    public String consultarSoporte(String identificacion, String titutlo){
        String link_soporte="";
        try{
            link_soporte = daoFormacionTic.consultarSoporte(identificacion, titutlo);
            
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al guardar la formacion en Tic. Por favor intente nuevamente");
        }
        return link_soporte;
    }
    
    
}
