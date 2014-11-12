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
    
    
    public ArrayList <String> consultarIdiomasAspirante (String id) throws SQLException {
        
        return daoIdioma.consultarIdiomasAspirante(id);
        
    }
    
    
    public String consultarCodigo (String nombre) throws SQLException {
		
	return daoIdioma.consultarCodigo(nombre);
		
    }
    
    
    public void agregarIdiomaAspirante (String id_aspi, String cod_idioma, String hablar, String leer, 
                                            String escribir) throws SQLException {
        
        daoIdioma.agregarIdiomaAspirante(id_aspi, cod_idioma, hablar, leer, escribir);
        
    }
    
}
