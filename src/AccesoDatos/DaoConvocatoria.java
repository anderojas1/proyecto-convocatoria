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
    private String consultaSql;

    private Connection conectar;
    private Statement sentencia;
    private ResultSet registros;

    public DaoConvocatoria() {

        fachadaConectar = new Fachada();

    }

    public void crearConvocatoria(Convocatoria convoca, String usuario) throws SQLException {

        sqlDatosConvocatoria = "INSERT INTO CONVOCATORIA VALUES ('" + convoca.getCodigo() + "','" + convoca.getNombre() + "','"
                + convoca.getDescripcion() + "','" + convoca.getFechaInicio() + "','" + convoca.getFechaCierre() + "','"
                + convoca.getEstado() + "','" + usuario + "');";

        ejecutarSentencia();

    }

    public void ejecutarSentencia() throws SQLException {

        conectar = fachadaConectar.conectar();

        sentencia = conectar.createStatement();
        sentencia.executeUpdate(sqlDatosConvocatoria);

        conectar.close();

    }

    
    public ArrayList<String> nombresConvocatorias() throws SQLException{
        
        ArrayList<String> nombres = new ArrayList();
        sqlNombreConvocatoria = "SELECT codigo, nombre FROM CONVOCATORIA;";

        conectar = fachadaConectar.conectar();
        sentencia = conectar.createStatement();
        registros = sentencia.executeQuery(sqlNombreConvocatoria);

        while (registros.next()) {
            nombres.add(registros.getString(1) + "," + registros.getString(2));

            System.out.println(registros.getString(1));
        }
        conectar.close();
        return nombres;
    
    }
    
    
    public ArrayList<String> nombresConvocatorias(String identificacion) throws SQLException {
        ArrayList<String> nombres = new ArrayList();
        sqlNombreConvocatoria = "SELECT codigo, nombre FROM CONVOCATORIA WHERE estado = 'abierta' EXCEPT \n" +
                                "SELECT C.codigo, C.nombre FROM CONVOCATORIA C JOIN ASPIRANTECONVOCATORIA AC ON C.codigo = AC.codigo WHERE AC.identificacion = '"+identificacion+"' ;";

        conectar = fachadaConectar.conectar();
        sentencia = conectar.createStatement();
        registros = sentencia.executeQuery(sqlNombreConvocatoria);

        while (registros.next()) {
            nombres.add(registros.getString(1) + "," + registros.getString(2));

            System.out.println(registros.getString(1));
        }
        conectar.close();
        return nombres;

    }

    public String estado(String codigo) throws SQLException {
        String estado = "";
        String sql_select;
        sql_select = "SELECT estado FROM Convocatoria WHERE codigo = '" + codigo + "';";

        conectar = fachadaConectar.conectar();
        sentencia = conectar.createStatement();
        registros = sentencia.executeQuery(sql_select);

        while (registros.next()) {
            estado = registros.getString(1);

            //System.out.println("ok");
        }
        conectar.close();
        return estado;
    }

    private void ejecutarConsulta() throws SQLException {

        conectar = fachadaConectar.conectar();
        sentencia = conectar.createStatement();
        registros = sentencia.executeQuery(consultaSql);
        conectar.close();

    }

    public ArrayList<String> consultarConvocatorias() throws SQLException {

        ArrayList<String> convocatorias = new ArrayList<>();

        consultaSql = "SELECT nombre FROM CONVOCATORIA;";
        ejecutarConsulta();

        while (registros.next()) {

            convocatorias.add(registros.getString(1));

        }

        if (convocatorias.isEmpty()) {
            throw new SQLException("No hay convocatorias registradas");
        }

        return convocatorias;

    }
    
    public String[] consultarDetallesConvocatoria (String nombre) throws SQLException {
        
        String datos [] = new String[6];
        
        consultaSql = "SELECT * FROM CONVOCATORIA WHERE nombre = '" + nombre + "';";
        ejecutarConsulta();
        
        if (registros.next() == true) {
            
            datos[0] = registros.getString(1);
            datos[1] = registros.getString(2);
            datos[2] = registros.getString(3);
            datos[3] = registros.getString(4);
            datos[4] = registros.getString(5);
            datos[5] = registros.getString(6);
            
        }
        
        return datos;
        
    }
    
    
    public void actualizarDetallesConvocatoria (String nombre, String descripcion, String estado, String fechaFin,
                                String convocatoria) throws SQLException {
        
        sqlDatosConvocatoria = "UPDATE CONVOCATORIA SET nombre = '" + nombre + "',descripcion = '" + descripcion + "',"
                + "fecha_cierre = '" + fechaFin + "', estado = '" + estado + "' WHERE nombre = '" + convocatoria + "';";
        
        ejecutarSentencia();
        
    }
}
