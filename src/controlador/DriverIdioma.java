/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import AccesoDatos.DaoIdioma;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author anderojas
 */
public class DriverIdioma {
    
    private final DaoIdioma daoIdioma;
    

    public DriverIdioma() {
        
        daoIdioma = new DaoIdioma();
        
    }
    
    
    public ArrayList <String> consultarIdiomas () throws SQLException {
        
        return daoIdioma.consultarIdiomas();
        
    }
    
    
    public String consultarCodigo (String nombre) throws SQLException {
		
		return daoIdioma.consultarCodigo(nombre);
		
	}
    
    
    
    
}
