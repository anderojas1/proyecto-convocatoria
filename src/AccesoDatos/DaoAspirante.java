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
    private String sqlDatos;
    private String sentenciaSql;
    private Connection conectar;
    private Statement sentencia;
    private ResultSet registros;

    public DaoAspirante() {

        fachada = new Fachada();

    }

    public void insertApplicant(Aspirante asp) throws SQLException {

        sqlDatos = "INSERT INTO Aspirante values ('" + asp.getIdentificacion() + "', '" + asp.getTipo_id() + "', "
                + "'" + asp.getP_nombre() + "', '" + asp.getS_nombre() + "', '" + asp.getP_apellido() + "', '" + asp.getS_apellido() + "',"
                + "'" + asp.getFecha_nacimiento() + "', '" + asp.getLugar_nacimiento() + "', '" + asp.getLugar_nacimiento() + "', "
                + "'" + asp.getSexo() + "', '" + asp.getLugar_residencia() + "', '" + asp.getTel() + "', '" + asp.getJornada() + "', '" + asp.getMunicipio_trabaja() + "')";


        try {
            ejecutarSentencia();
        } catch (SQLException ex) {
            throw ex;
        }

    }

    public Aspirante getApplicant(String id) {

        sentenciaSql = "SELECT * FROM Aspirante WHERE identificacion = " + id + ";";

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




        try {

            conectar = fachada.conectar();

            sentencia = conectar.createStatement();

            registros = sentencia.executeQuery(sentenciaSql);

            while (registros.next()) {

                identificacion = (String) registros.getString(1);
                p_nombre = (String) registros.getString(2);
                s_nombre = (String) registros.getString(3);
                p_apellido = (String) registros.getString(4);
                s_apellido = (String) registros.getString(5);
                tipo_id = (String) registros.getString(6);
                municipio_trabaja = (String) registros.getString(7);
                sexo = (String) registros.getString(8);
                jornada = (String) registros.getString(9);
                lugar_residencia = (String) registros.getString(10);
                fecha_nacimiento = (String) registros.getString(11);
                lugar_nacimiento = (String) registros.getString(12);
                tel = (String) registros.getString(13);

         }
            Aspirante asp = new Aspirante(p_nombre, s_nombre, p_apellido, s_apellido, identificacion, tipo_id, municipio_trabaja, sexo, jornada, lugar_residencia, fecha_nacimiento, lugar_nacimiento, tel);
        
            return asp;
        
        } catch (SQLException ex) {

            System.out.println("error consultar aspirante");
            return null;
            

        } catch (NullPointerException ex) {

            System.out.println("no se pudo crear aspirante");
            return null;

        }



    }

    public void ejecutarSentencia() throws SQLException {

        try {

            conectar = fachada.conectar();

            sentencia = conectar.createStatement();
            sentencia.executeUpdate(sqlDatos);


            conectar.close();

        } catch (SQLException ex) {

            throw ex;

        } catch (NullPointerException ex) {

            JOptionPane.showMessageDialog(null, "Error en base de datos. No se puede conectar");

        }

    }
}
