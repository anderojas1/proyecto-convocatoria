/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import AccesoDatos.DaoConvocatoria;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import logica.Convocatoria;
import java.util.ArrayList;

/**
 *
 * @author anderojas
 */
public class DriverConvocatoria {
    
    private final DaoConvocatoria daoConvocatoria;
    
    
    public DriverConvocatoria () {
        
        daoConvocatoria = new DaoConvocatoria();
        
    }
    
    
    public void guardarConvocatoria (String nombre, String descripcion, String fecha_ini, String fecha_fin, String estado, String codigo, 
                                        String usuario) throws SQLException {
        
        Convocatoria crearConv = new Convocatoria(nombre, fecha_ini, fecha_fin, codigo, estado, descripcion);
        
        try {
            
            daoConvocatoria.crearConvocatoria(crearConv, usuario);
            
        } catch (SQLException ex) {
            
            throw ex;
            
        }
        
    }
    
    
    public ArrayList<String> listaConvocatorias(){
        ArrayList<String> convocatorias = new ArrayList();
        try{
        
        convocatorias = daoConvocatoria.nombresConvocatorias();
        
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "No hay convocatorias", JOptionPane.ERROR_MESSAGE);
        }
        return convocatorias;
    }
    
    public String estadoConvo(String codigo){
        String estado="";
        try {
        estado=daoConvocatoria.estado(codigo);
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Consulta erronea", JOptionPane.ERROR_MESSAGE);
        }
        return estado;
    }
    
    public ArrayList<String> consultarConvocatorias () throws SQLException {
        
        return daoConvocatoria.consultarConvocatoriasVigentes();
        
    }
    
}
