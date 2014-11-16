/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AccesoDatos;

import java.sql.*;
import javax.swing.JOptionPane;
import logica.Usuario;
/**
 *
 * @author Santa Gutierrez
 */
public class DaoUsuario {
    
    private final Fachada fachadaConectar;
    private String sqlDatosAcceso;
    private String sqlDatos;
    private String sentenciaSql;
    
    private Connection conectar;
    private Statement sentencia;
    private ResultSet registros;
    
    
    public DaoUsuario () {
        
        fachadaConectar = new Fachada();
                
    }
    
    
    public void crearUsuario (Usuario user) throws SQLException {
        
        sqlDatos ="INSERT INTO Usuario VALUES ('" + user.getIdentificacion() + "', '" + user.getTipoIdentificacion()+ "', '"
                + user.getNombreUno() + "', '" + user.getNombreDos() + "', '" + user.getApellidoUno() + "', '" + user.getApellidoDos() + "', "
                + user.getEstadoEmpleo() + ", '" + user.getCargo() + "');";
        
        sqlDatosAcceso = "INSERT INTO ACCESO VALUES ('" + user.getUsername() + "', '" + user.getPassword() + "', "
                + user.getEstado() + ", '" + user.getIdentificacion() + "');";
        
        ejecutarSentencia();
        
    }
    
    
    public void ejecutarSentencia () throws SQLException, NullPointerException {
        
        try{
            
            conectar= fachadaConectar.conectar();
            
            sentencia = conectar.createStatement();
            sentencia.executeUpdate(sqlDatos);
            sentencia.executeUpdate(sqlDatosAcceso);
            
            conectar.close();
            
        } catch(SQLException ex) { 
            
            throw ex;
        
        } catch (NullPointerException ex) {
            
            throw ex;
            
        }
        
    }
    
    
    public String identificarTipo (String usuario, String pass) {
        
        String tipo = "";
        
        sentenciaSql = "select cargo from USUARIO NATURAL JOIN ACCESO where username = '" + usuario + "' and password = '" + pass + "';";
        
        try{
            
            conectar= fachadaConectar.conectar();
            
            sentencia = conectar.createStatement();

            registros = sentencia.executeQuery(sentenciaSql);
            
            while (registros.next()) {
            
                return registros.getString(1);
                
            }
            
        } catch(SQLException ex) { 
            
            JOptionPane.showMessageDialog(null, "Error en base de datos. No se puede guardar");
            return tipo;
        
        } catch (NullPointerException ex) {
            
            JOptionPane.showMessageDialog(null, "Error en base de datos. No se puede conectar");
            
        }
        
        return tipo;
        
    }
    
    
    public boolean consultarUsuario () throws SQLException {
        
        boolean flag_register = false;
        
        sentenciaSql = "SELECT * FROM Usuario";
        
        try{
            
            conectar= fachadaConectar.conectar();
            
            sentencia = conectar.createStatement();

            registros = sentencia.executeQuery(sentenciaSql);
            
            if (registros.next() == true) flag_register = true;
            
        } catch(SQLException ex) { 
            
            throw ex;
        
        } catch (NullPointerException ex) {
            
            JOptionPane.showMessageDialog(null, "Error en base de datos. No se puede conectar");
            
        }
        
        return flag_register;
        
    }
    
}
