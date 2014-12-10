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
    
    private ArrayList <String> consultar;

    public DaoIdioma() {
        
        fachadaConectar = new Fachada();
        
    }
    
    
    public ArrayList <String> consultarIdiomas () throws SQLException {
        
        ArrayList <String> idiomas = new ArrayList<>();
        
        conectar = fachadaConectar.conectar();        
        sqlSentence = "SELECT nombre FROM IDIOMA;";
        sentencia = conectar.createStatement();
        registros = sentencia.executeQuery(sqlSentence);
        
        while (registros.next()) {
            
            String idioma = registros.getString(1);
            idiomas.add(idioma);
            
        }
        
        conectar.close();
        
        return idiomas;
                
    }
    
    
    public String consultarCodigo (String nombre) throws SQLException {
        
        String codigo = "";
		
        conectar = fachadaConectar.conectar();

        sqlSentence = "SELECT codigo_idioma FROM IDIOMA WHERE nombre = '" + nombre + "';";        
        sentencia = conectar.createStatement();
        registros = sentencia.executeQuery(sqlSentence);
        
        if (registros.next()) {
            
            codigo = registros.getString(1);
            
        }
        
        conectar.close();

        return codigo;
		
    
    }
    
    
    public ArrayList <String> consultarIdiomasAspirante (String id) throws SQLException {
        
        consultar = new ArrayList<>();
        
        sqlSentence = "SELECT nombre, leer, escribir, hablar FROM ASPIRANTE_HABLA INNER JOIN IDIOMA ON cod_idioma = codigo_idioma where "
                + "id_aspirante = '" + id + "';";
		
        conectar = fachadaConectar.conectar();
        sentencia = conectar.createStatement();
        registros = sentencia.executeQuery(sqlSentence);
        
        while (registros.next()) {
            
            consultar.add(registros.getString(1));
            consultar.add(registros.getString(2));
            consultar.add(registros.getString(3));
            consultar.add(registros.getString(4));
            
        }
        
        conectar.close();
        
        return consultar;
    }
    
    
    private void consultar () throws SQLException {
        
        consultar = new ArrayList<>();
        
        conectar = fachadaConectar.conectar();		
	sentencia = conectar.createStatement();
        registros = sentencia.executeQuery(sqlSentence);
        
        while (registros.next()) {
            
            consultar.add(registros.getString(1));
            consultar.add(registros.getString(2));
            consultar.add(registros.getString(3));
            consultar.add(registros.getString(4));
            
            System.out.println(registros.getString(1));
            
        }
        
        conectar.close();
                
    }
    
    
    public void agregarIdiomaAspirante (String id_con, String id, String cod, String hablar, String leer, String esc, 
                                            double puntaje, boolean escoger) throws SQLException {
        
        sqlSentence = "INSERT INTO ASPIRANTE_HABLA VALUES ('" + id + "','" + cod + "','" + hablar + "','" + leer + "','"
                + esc + "'," + puntaje + ",'" + id_con + "'," + escoger + ");";
        
        ejecutarSentencia();
    }
    
    
    public void ejecutarSentencia () throws SQLException {
        
        conectar = fachadaConectar.conectar();

        sentencia = conectar.createStatement();
        sentencia.executeUpdate(sqlSentence);

        conectar.close();
        
    }
    
    
    public void cambiarIdiomaEscogido () throws SQLException {
        
        sqlSentence = "UPDATE ASPIRANTE_HABLA SET escoger = false WHERE escoger = TRUE;";
        
        ejecutarSentencia();
        
    }
    
    
    public void ejecutarConsulta () throws SQLException {
        
        conectar = fachadaConectar.conectar();		
	sentencia = conectar.createStatement();
        registros = sentencia.executeQuery(sqlSentence);
        
        conectar.close();
        
    }
    
    
    public double consultarPuntaje (String id) throws SQLException {
        
        sqlSentence = "SELECT puntaje FROM ASPIRANTE_HABLA WHERE id_aspirante = '" + id +"' and escoger = TRUE;";
        
        ejecutarConsulta();
        
        double puntaje = 0.0;
        
        if (registros.next()) puntaje = registros.getDouble(1);
        
        return puntaje;
        
    }
}
