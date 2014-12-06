/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AccesoDatos;

import java.sql.*;
import java.util.ArrayList;
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
    
    
    public void ejecutarUpdate () throws SQLException {
        
        conectar = fachadaConectar.conectar();

        sentencia = conectar.createStatement();
        sentencia.executeUpdate(sentenciaSql);

        conectar.close();
        
    }
    
    
    public void cambiarContraseña (String id, String pass) throws SQLException {
        
        sentenciaSql = "UPDATE ACCESO SET password = '" + pass + "' WHERE identificacion = '" + id + "';";
        ejecutarUpdate();
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
    
    
    public void ejecutarConsulta () throws SQLException {
        
        conectar= fachadaConectar.conectar();
            
        sentencia = conectar.createStatement();

        registros = sentencia.executeQuery(sentenciaSql);
            
    }
    
    
    public boolean consultarUsuario (String id) throws SQLException {
        
        sentenciaSql = "SELECT * FROM ACCESO WHERE identificacion = '" + id + "';";
        
        ejecutarConsulta();
        
        return registros.next();
        
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
    
    public void estadoSesion (String user, boolean est) throws SQLException {
        
        sentenciaSql = "UPDATE ACCESO SET estado = " + est + " WHERE username = '" + user + "';";
        ejecutarUpdate();
        
    }
    
    
    public boolean consultarEstadoSesion (String user) throws SQLException {
        
        boolean estado = false;
        
        sentenciaSql = "SELECT estado FROM ACCESO WHERE username = '" + user + "';";
        ejecutarConsulta();
        
        if (registros.next() == true) estado = registros.getBoolean(1);
        
        return estado;
    }
    
    
    public void habilitarUsuario (boolean estado, String identificacion) throws SQLException {
        
        sentenciaSql = "UPDATE USUARIO SET empleo = " + estado + " WHERE identificacion = '" + identificacion + "';";
        ejecutarUpdate();
        
    }
    
    
    public ArrayList <String> consultarUsuarios (boolean estado) throws SQLException {
        
        ArrayList <String> usuarios = new ArrayList<>();
        
        sentenciaSql = "SELECT identificacion FROM USUARIO WHERE empleo = " + estado + " AND cargo <> 'Administrador';";
        ejecutarConsulta();
        
        while (registros.next() == true) {
            
            usuarios.add(registros.getString(1));
            
        }
        
        return usuarios;
    }
    
}
