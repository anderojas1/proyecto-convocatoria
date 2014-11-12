/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import logica.Idioma;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author anderojas
 */
public class DaoIdioma {
    
    private final Fachada fachadaConectar;
    private String sqlSentence;
    
    private Connection conectar;
    private Statement sentencia;
    private ResultSet registros;

    public DaoIdioma() {
        
        fachadaConectar = new Fachada();
        
    }
    
    
    public ArrayList <String> consultarIdiomas () throws SQLException {
        
        ArrayList <String> idiomas = new ArrayList<>();
        
        conectar = fachadaConectar.conectar();
        
        sqlSentence = "SELECT nombre FROM IDIOMA;";
        
        consultar();
        
        while (registros.next()) {
            
            String idioma = registros.getString(1);
            idiomas.add(idioma);
            
        }
                
    }
    
    
    public String consultarCodigo (String nombre) throws SQLException {
		
		conectar.fachadaConectar();
		
		sqlSentence = "SELECT codigo_idioma FROM IDIOMA WHERE nombre = '" + nombre + "';";
		
		consultar();
		
		return registros.getString(1);
		
	}
    
    
    private void consultar () throws SQLException {
		
		sentencia = conectar.createStatement();
		
		registros = sentencia.executeQuery(sqlSentence);
                
	}
    
}
