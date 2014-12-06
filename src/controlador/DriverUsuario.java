/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import AccesoDatos.DaoUsuario;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import logica.Usuario;

/**
 *
 * @author jorgeaer
 */
public class DriverUsuario {
    
    private final DaoUsuario daoUsuario;
    
    
    public DriverUsuario() {
        
        daoUsuario = new DaoUsuario();
        
    }
    
    public void guardar(String nom1, String nom2, String apell1, String apell2, String tipoIden,
                        String indent, String nomUsu, String pass, String pass2, String tipoUsuario){
    
        Usuario usu = new Usuario(nom1, nom2, apell1, apell2, tipoIden, nomUsu, pass, indent, tipoUsuario);
        
        try {
            
            daoUsuario.crearUsuario(usu);
            
            JOptionPane.showMessageDialog(null, "Se ha guardado el usuario con exito", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Error al guardar el usuario. Por favor intente nuevamente");
            
        }
    
    }
    
    
    public boolean consultarUsuarioAdmin () throws SQLException, NullPointerException {
        
        return daoUsuario.consultarUsuario();
        
    }
    
    
    public String tipoUsuario (String username, String password) throws SQLException {
        
        return daoUsuario.identificarTipo (username, password);
        
    }
    
    
    public boolean consultarUsuario (String id) throws SQLException {
        
        return daoUsuario.consultarUsuario(id);
        
    }
    
    
    public void cambiarContraseña (String id, String pass) throws SQLException {
        
        daoUsuario.cambiarContraseña(id, pass);
        
    }
    
    
    public void estadoSesion (String user, boolean estado) throws SQLException {
        
        daoUsuario.estadoSesion(user, estado);
        
    }
    
    
    public boolean verificarSesion (String user) throws SQLException {
        
        return daoUsuario.consultarEstadoSesion(user);
        
    }
    
    
    public void habilitarUsuario (boolean estado, String identificacion) throws SQLException {
        
        daoUsuario.habilitarUsuario(estado, identificacion);
        
    }
    
    
    public ArrayList <String> consultarUsuarios (boolean estado) throws SQLException {
        
        return daoUsuario.consultarUsuarios(estado);
        
    }
    
    
}
