/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logica.*;

/**
 *
 * @author johnfla
 */
public class DaoAspirante {

    private Fachada fachada;
    //private String sqlDatos;
    private String sentenciaSql;
    private Connection conectar;
    private Statement sentencia;
    private ResultSet registros;

    public DaoAspirante() {

        fachada = new Fachada();

    }

    public void insertApplicant(Aspirante asp) throws SQLException {

        sentenciaSql = "INSERT INTO Aspirante  values ('" + asp.getIdentificacion() + "', '" + asp.getTipo_id() + "', "
                + "'" + asp.getP_nombre() + "', '" + asp.getS_nombre() + "', '" + asp.getP_apellido() + "', '" + asp.getS_apellido() + "',"
                + "'" + asp.getMunicipio_trabaja() + "', '" + asp.getSexo() + "', '" + asp.getJornada() + "', "
                + "'" + asp.getLugar_residencia() + "', '" + asp.getFecha_nacimiento() + "', '" + asp.getLugar_nacimiento() + "', '" + asp.getTel() +"',"
                + asp.getEstado() +" );";


        try {
            ejecutarSentencia();
        } catch (SQLException ex) {
            throw ex;
        }

    }

    public Aspirante getApplicant(String id) {

        sentenciaSql = "SELECT * FROM Aspirante WHERE identificacion = '" + id + "';";

        String identificacion = "";
        String p_nombre = "";
        String s_nombre = "";
        String s_apellido = "";
        String p_apellido = "";
        String tipo_id = "";
        String municipio_trabaja = "";
        String sexo = "";
        String jornada = "";
        String lugar_residencia = "";
        String fecha_nacimiento = "";
        String lugar_nacimiento = "";
        String tel = "";
        Aspirante asp = null;




        try {

            conectar = fachada.conectar();

            sentencia = conectar.createStatement();

            registros = sentencia.executeQuery(sentenciaSql);

            while (registros.next()) {

                identificacion = (String) registros.getString(1);
                System.out.print(identificacion);
                tipo_id = (String) registros.getString(2);
                p_nombre = (String) registros.getString(3);
                s_nombre = (String) registros.getString(4);
                p_apellido = (String) registros.getString(5);
                s_apellido = (String) registros.getString(6);
                municipio_trabaja = (String) registros.getString(7);
                sexo = (String) registros.getString(8);
                jornada = (String) registros.getString(9);
                lugar_residencia = (String) registros.getString(10);
                fecha_nacimiento = (String) registros.getString(11);
                lugar_nacimiento = (String) registros.getString(12);
                tel = (String) registros.getString(13);
                asp = new Aspirante(p_nombre, s_nombre, p_apellido, s_apellido, identificacion, tipo_id, municipio_trabaja, sexo, jornada, lugar_residencia, fecha_nacimiento, lugar_nacimiento, tel);
                  
            }
            return asp;
           
        
        } catch (SQLException ex) {

            System.out.println("error consultar aspirante");
            return null;
            

        } catch (NullPointerException ex) {

            System.out.println("no se pudo crear aspirante");
            return null;

        }



    }
    
    public void AspiranteConvocatoria(String idAsp, String codConv) throws SQLException{
        sentenciaSql="INSERT INTO AspiranteConvocatoria VALUES ('"+idAsp+"', '"+codConv+"', 0.0, false);";
        
         try {
            ejecutarSentencia();
        } catch (SQLException ex) {
            throw ex;
        }
        
    }

    public void ejecutarSentencia() throws SQLException {

        conectar = fachada.conectar();

        sentencia = conectar.createStatement();
        sentencia.executeUpdate(sentenciaSql);

        conectar.close();       

    }
    
    
    public void updatePuntajeUsuario (String id, String convo, double puntaje) throws SQLException {
        
        sentenciaSql = "UPDATE AspiranteConvocatoria SET puntajetotal = " + puntaje + " WHERE identificacion = '" + id +"' AND "
                + "codigo = '" + convo + "';";
        
        ejecutarSentencia();
        
    }
    
    
    public double consultarPuntajeUsuario (String id, String convoca) throws SQLException {
        
        double puntaje = 0.0;
        
        sentenciaSql = "SELECT puntajetotal FROM AspiranteConvocatoria WHERE identificacion = '" + id + "' AND codigo = '" + convoca + "';";
        ejecutarConsulta();
        
        if (registros.next()) puntaje = registros.getDouble(1);
        
        return puntaje;
        
    }
    
    
    public void ejecutarConsulta () throws SQLException {
        
        conectar = fachada.conectar();		
	sentencia = conectar.createStatement();
        registros = sentencia.executeQuery(sentenciaSql);
        
        conectar.close();
        
    }
}
