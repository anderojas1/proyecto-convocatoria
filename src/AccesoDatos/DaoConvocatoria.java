/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import java.sql.*;
import logica.Convocatoria;
import java.util.ArrayList;

/**
 *
 * @author anderojas
 */
public class DaoConvocatoria {
    
    private final Fachada fachadaConectar;
    private String sqlDatosConvocatoria;
    private String sqlNombreConvocatoria;
    
    private Connection conectar;
    private Statement sentencia;
    private ResultSet registros;
    
    
    public DaoConvocatoria () {
        
        fachadaConectar = new Fachada();
        
    }
    
    
    public void crearConvocatoria (Convocatoria convoca, String usuario) throws SQLException {
        
        sqlDatosConvocatoria = "INSERT INTO CONVOCATORIA VALUES ('" + convoca.getCodigo() + "','" + convoca.getNombre() + "','"
                + convoca.getDescripcion() + "','" + convoca.getFechaInicio() + "','" + convoca.getFechaCierre() + "','" 
                + convoca.getEstado() + "','" + usuario + "');";
        
        ejecutarSentencia();
        
    }
    
    
    public void ejecutarSentencia () throws SQLException {
        
        conectar = fachadaConectar.conectar();

        sentencia = conectar.createStatement();
        sentencia.executeUpdate(sqlDatosConvocatoria);

        conectar.close();
        
    }
    
    public ArrayList<String> nombresConvocatorias() throws SQLException{
        ArrayList<String> nombres = new ArrayList();
        sqlNombreConvocatoria = "SELECT codigo, nombre FROM CONVOCATORIA WHERE estado = 'abierta';";
        
    
            conectar = fachadaConectar.conectar();
            sentencia = conectar.createStatement();
            registros = sentencia.executeQuery(sqlNombreConvocatoria);
            
            while(registros.next()){
               nombres.add(registros.getString(1)+","+registros.getString(2));
              
              System.out.println(registros.getString(1));
            }
            conectar.close();
            return nombres;
         
  
    }
    
    public String estado(String codigo) throws SQLException{
        String estado = "";
        String sql_select;
        sql_select ="SELECT estado FROM Convocatoria WHERE codigo = '"+codigo+"';"; 
        
        conectar = fachadaConectar.conectar();
        sentencia = conectar.createStatement();
        registros = sentencia.executeQuery(sql_select);
            
            while(registros.next()){
              estado=registros.getString(1);
              
              //System.out.println("ok");
            }
            conectar.close();
        return estado;
    }
}
