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

/**
 *
 * @author anderojas
 */
public class DriverConvocatoria {
    
    private final DaoConvocatoria daoConvocatoria;
    
    
    public DriverConvocatoria () {
        
        daoConvocatoria = new DaoConvocatoria();
        
    }
    
    
    public void guardarConvocatoria (String nombre, String fecha_ini, String fecha_fin, String estado, String codigo, String id_admin) {
        
        Convocatoria crearConv = new Convocatoria(nombre, fecha_ini, fecha_fin, codigo, estado);
        
        try {
            
            daoConvocatoria.crearConvocatoria(crearConv, id_admin);
            
            JOptionPane.showMessageDialog(null, "Se ha creado la convocatoria con exito", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Error creando la convocatoria", "Registro fallido", JOptionPane.ERROR_MESSAGE);
            
        }
    }
    
}
