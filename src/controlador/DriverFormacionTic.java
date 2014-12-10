

package controlador;

import AccesoDatos.DaoFormacionTic;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import logica.formacionTic;

public class DriverFormacionTic {
    
    private DaoFormacionTic daoFormacionTic;
    
    public DriverFormacionTic(){
        daoFormacionTic = new DaoFormacionTic();
    }
    
    
    public void guardar(String identificacion, String titulo, int consecutivo, String soporte, int puntaje, String convocatoria){
        
        formacionTic formacion = new formacionTic(identificacion, titulo, consecutivo, soporte, puntaje, convocatoria);
        
        try{
            daoFormacionTic.crearFormacionTic(formacion);
            JOptionPane.showMessageDialog(null, "Se ha guardado la formacion en TIC con exito", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al guardar la formacion en Tic. Por favor intente nuevamente");
        }
    }
    
    
    public String consultarSoporte(String identificacion, String titutlo, String codigo){
        String link_soporte="";
        try{
            link_soporte = daoFormacionTic.consultarSoporte(identificacion, titutlo, codigo);
            
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al guardar la formacion en Tic. Por favor intente nuevamente");
        }
        return link_soporte;
    }
    
    
    
    public ArrayList<formacionTic> consultarFTICAspirante(String identificacion, String codigo){
       ArrayList<formacionTic> form = new ArrayList();
       
       try{
           form = daoFormacionTic.consultarAspiranteFormacionTic(identificacion, codigo);
       }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al extraer información. Por favor intente nuevamente");
       }
       return form;
    }
    
     public ArrayList<String> consultarFTICAspirante2(String identificacion, String codigo){
       ArrayList<String> form = new ArrayList();
       
       try{
           form = daoFormacionTic.consultarAspiranteFormacionTic2(identificacion, codigo);
       }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al extraer información. Por favor intente nuevamente");
       }
       return form;
    }
     
     
    public ArrayList<String> consultarConsecutivos(String identificacion, String codigo, String formacion){
        ArrayList<String> cons = new ArrayList();
       
       try{
           cons = daoFormacionTic.consultarConsecutivoFormacion(identificacion, codigo, formacion);
       }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al extraer información (Consecutivos). Por favor intente nuevamente");
       }
       return cons;
    }
    
    public int puntajeMaximo(String identificacion, String codigo){
        int maximo = 0;
        try{
            maximo = daoFormacionTic.maximoPuntajeInscripcion(identificacion, codigo);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al consultar puntaje maximo. Por favor intente nuevamente");
        }
        
        return maximo;
    }
    
    public void asignarPuntajeInscripcion(String identificacion, String codigo, int puntaje_nuevo, int maximo_puntaje){
        
        try{
            daoFormacionTic.asignarPuntajeInscripcion(identificacion, codigo, puntaje_nuevo, maximo_puntaje);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al insertar el puntaje del aspirante en la convocatoria. Por favor intente nuevamente");
        }
    }
    
    
    public void editar(String identificacion, String codigo, String titulo, String soporte){
        
        try{
            daoFormacionTic.editar(identificacion, codigo, titulo, soporte);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al insertar el puntaje del aspirante en la convocatoria. Por favor intente nuevamente");
        }
    }
    
    
}
