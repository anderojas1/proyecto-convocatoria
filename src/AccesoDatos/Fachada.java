/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author anderojas
 */
public class Fachada {
    
    private final String url;
    private final String user;
    private final String password;
    
    private Connection conexion;
    
    
    public Fachada () {
        
        url = "jdbc:postgresql://localhost:5432/georgerr";
        user = "georgerr";
        password = "georgerr";
        
    }
    
    
    public Connection conectar () throws SQLException {
        
        try {
            
            Class.forName("org.postgresql.Driver");
            
            conexion = DriverManager.getConnection(url, user, password);
            
            return conexion;
            
        } catch (SQLException ex) {
            
            throw ex;
            
        } catch (ClassNotFoundException ex) {
            
            return null;
            
        }
        
    }
    
    
    public void desconectar (Connection conex) {
        
        try {
            
            conex.close();
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "No se pudo desconectar");
            
        }
        
    }
    
}
