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
    
    private Fachada fachadaConectar;
    private String sentenciaSql;
    
    private Connection conectar;
    private Statement sentencia;
    private ResultSet registros;
    
    
    public DaoUsuario () {
        
        fachadaConectar = new Fachada();
                
    }
    
    
    public void crearUsuario (Usuario user) {
        
        sentenciaSql ="INSERT INTO Usuario VALUES ('" + user.getIdentificacion() + "', '" + user.getTipoIdentificacion()+ "', '"
                + "" + user.getNombreUno() + "'," + " '" + user.getNombreDos() + "', '" + user.getApellidoUno() + "', '" + user.getApellidoDos() + "', '"
                + user.getUsername() + "'," + " '" + user.getPassword() + "', " + user.getEstado() + ", " + user.getEstadoEmpleo() + ", '"
                + "" + user.getTipo() + "');";
        
        guardarUsuario();
        
    }
    
    
    public void guardarUsuario () {
        
        try{
            
            conectar= fachadaConectar.conectar();
            
            sentencia = conectar.createStatement();

            sentencia.executeUpdate(sentenciaSql);
            
            conectar.close();
            
        } catch(SQLException ex) { 
            
            JOptionPane.showMessageDialog(null, "Error en base de datos. No se puede guardar");
        
        } catch (NullPointerException ex) {
            
            JOptionPane.showMessageDialog(null, "Error en base de datos. No se puede conectar");
            
        }
        
    }
    
    
    public boolean consultarUsuario () {
        
        boolean flag_register = false;
        
        sentenciaSql = "SELECT * FROM Usuario";
        
        try{
            
            conectar= fachadaConectar.conectar();
            
            sentencia = conectar.createStatement();

            registros = sentencia.executeQuery(sentenciaSql);
            
            if (registros.next() == true) flag_register = true;
            
        } catch(SQLException ex) { 
            
            JOptionPane.showMessageDialog(null, "Error en base de datos. No se puede guardar");
        
        } catch (NullPointerException ex) {
            
            JOptionPane.showMessageDialog(null, "Error en base de datos. No se puede conectar");
            
        }
        
        return flag_register;
    }
    
}
