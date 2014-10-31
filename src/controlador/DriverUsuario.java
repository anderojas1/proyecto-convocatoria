/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import AccesoDatos.DaoUsuario;
import java.sql.SQLException;
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
            
            JOptionPane.showMessageDialog(null, "Se ha guardado el usuario con extito");
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Error al guardar el usuario. Por favor intente nuevamente");
            
        }
    
    }
    
    
    public boolean consultarUsuarioAdmin () {
        
        return daoUsuario.consultarUsuario();
        
    }
    
    
    public String tipoUsuario (String username, String password) {
        
        return daoUsuario.identificarTipo (username, password);
        
    }
}
