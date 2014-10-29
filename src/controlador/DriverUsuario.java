/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import AccesoDatos.DaoUsuario;

/**
 *
 * @author jorgeaer
 */
public class DriverUsuario {
    
    private DaoUsuario daoUsuario;
    
    
    public DriverUsuario() {
        
        daoUsuario = new DaoUsuario();
        
    }
    
    
    public boolean consultarUsuarioAdmin () {
        
        return daoUsuario.consultarUsuario();
        
    }
}
