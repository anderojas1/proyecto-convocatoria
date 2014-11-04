/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import java.sql.*;
import logica.Convocatoria;

/**
 *
 * @author anderojas
 */
public class DaoConvocatoria {
    
    private final Fachada fachadaConectar;
    private String sqlDatosConvocatoria;
    
    private Connection conectar;
    private Statement sentencia;
    private ResultSet registros;
    
    
    public DaoConvocatoria () {
        
        fachadaConectar = new Fachada();
        
    }
    
    
    public void crearConvocatoria (Convocatoria convoca, String id_admin) throws SQLException {
        
        sqlDatosConvocatoria = "INSERT INTO CONVOCATORIA VALUES ('" + convoca.getCodigo() + "','" + convoca.getNombre() + "','"
                + convoca.getFechaInicio() + "','" + convoca.getFechaCierre() + "','" + convoca.getEstado() + "','" + id_admin + "');";
        
        ejecutarSentencia();
        
    }
    
    
    public void ejecutarSentencia () throws SQLException {
        
        conectar = fachadaConectar.conectar();

        sentencia = conectar.createStatement();
        sentencia.executeUpdate(sqlDatosConvocatoria);

        conectar.close();
        
    }
}
