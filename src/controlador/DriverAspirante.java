/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import AccesoDatos.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import logica.*;
/**
 *
 * @author johnfla
 */
public class DriverAspirante {
    
    private DaoAspirante daoaspirante;
    

    public DriverAspirante() {
        
        daoaspirante = new DaoAspirante();
    }
    
    public void guardarAspirante(String p_nombre, String s_nombre, String p_apellido, String s_apellido, String identificacion, 
                                    String tipo_id, String municipio_trabaja, String sexo, String jornada,
                                String lugar_residencia, String fecha_nacimiento, String lugar_nacimiento, String tel){
   
        Aspirante asp = new Aspirante(p_nombre, s_nombre, p_apellido, s_apellido, identificacion, tipo_id, municipio_trabaja, sexo, jornada, lugar_residencia, fecha_nacimiento, lugar_nacimiento, tel);
        
        try{
        
        daoaspirante.insertApplicant(asp);
         JOptionPane.showMessageDialog(null, "Se ha guardado el aspirante con exito", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
        
        }catch (SQLException e){
        
            JOptionPane.showMessageDialog(null, "Error al guardar el usuario. Por favor intente nuevamente");
            
        }
    }
    
   
    ///
    
    public void consultarAspirante(String id){
        
          Aspirante asp;       
             
          asp =  daoaspirante.getApplicant(id);
            
           if(asp != null){
            
                System.out.println("nombre: "+asp.getP_nombre()+"\nid: "+asp.getIdentificacion());
           }  
           
            
    
    }
    
           
    
}