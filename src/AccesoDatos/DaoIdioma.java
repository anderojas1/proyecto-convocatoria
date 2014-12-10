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
    
    
    public ArrayList <String> consultarIdiomasAspirante (String id, String id_con) throws SQLException {
        
        consultar = new ArrayList<>();
        
        sqlSentence = "SELECT nombre, leer, escribir, hablar FROM ASPIRANTE_HABLA INNER JOIN IDIOMA ON cod_idioma = codigo_idioma where "
                + "id_aspirante = '" + id + "' and cod_convocatoria = '" + id_con + "';";
		
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
    
    
    public double consultarPuntaje (String id, String convo) throws SQLException {
        
        sqlSentence = "SELECT puntaje FROM ASPIRANTE_HABLA WHERE id_aspirante = '" + id +"' and cod_convocatoria = '"  
                + convo + "' and escoger = TRUE;";
        
        ejecutarConsulta();
        
        double puntaje = 0.0;
        
        if (registros.next()) puntaje = registros.getDouble(1);
        
        return puntaje;
        
    }
    
    
    public void deleteIdioma (String id, String convocatoria, String cod_idioma) throws SQLException {
        
        sqlSentence = "DELETE FROM ASPIRANTE_HABLA WHERE id_aspirante = '" + id + "' AND cod_convocatoria = "
                + "'" + convocatoria + "' and cod_idioma = '" + cod_idioma + "';";
        
        ejecutarSentencia();
        
    }
    
    public boolean consultarIdiomaEscogido (String idioma, String id_asp, String id_con) throws SQLException {
        
        boolean estado = false;
        
        sqlSentence = "select escoger FROM aspirante_habla where id_aspirante = '" + id_asp + "' and cod_convocatoria "
                + "= '" + id_con + "' and cod_idioma = '" + idioma + "';";
        
        ejecutarConsulta();
        
        if (registros.next() == true) estado = registros.getBoolean(1);
        
        return estado;
        
    }
    
    
    public double nuevoPuntajeMaximo (String id_asp, String id_con) throws SQLException {
        
        double puntaje = 0.0;
        
        sqlSentence = "SELECT max(puntaje) from ASPIRANTE_HABLA where id_aspirante = '" + id_asp + "' and cod_convocatoria"
                + "= '" + id_con + "';";
        
        ejecutarConsulta();
        
        if (registros.next() == true) puntaje = registros.getDouble(1);
        
        return puntaje;
        
    }
    
    public void escogerNuevoIdioma (double puntaje, String id_asp, String id_con) throws SQLException {
        
        sqlSentence = "Update aspirante_habla set escoger = true where puntaje = " + puntaje + " and id_aspirante "
                + "= '" +id_asp + "' and cod_convocatoria = '" + id_con + "';";
        
        ejecutarSentencia();
        
    }
    
    
    public double consultarPuntajeIdioma (String id_asp, String id_con, String id_idioma) throws SQLException {
        
        sqlSentence = "select puntaje from aspirante_habla where id_aspirante = '" + id_asp + "' and cod_convocatoria "
                + "= '" + id_con + "' and cod_idioma = '" + id_idioma + "';";
        
        double pun = 0.0;
        
        ejecutarConsulta();
        
        if (registros.next() == true) {
            
            pun = registros.getDouble(1);
            
        }
        
        return pun;
        
    }
    
    
    public void updatePuntajeIdioma (String id_asp, String cod_con, String cod_idioma, double pun) throws SQLException {
        
        sqlSentence = "Update aspirante_habla set puntaje = " + pun + " where id_aspirante = '" + id_asp + "' "
                + "and cod_idioma = '" + cod_idioma + "' and cod_convocatoria = '"+ cod_con + "';";
        
        ejecutarSentencia();
        
    }
    
    
    public String [] consultarInformacionIdiomas (String id_asp, String convo, String cod_idioma) throws SQLException {
        
        String [] info = new String[3];
        
        sqlSentence = "select leer, escribir, hablar from aspirante_habla where id_aspirante = '" + id_asp + "' and "
                + "cod_convocatoria = '" + convo + "' and cod_idioma = '"+ cod_idioma + "';";
        
        ejecutarConsulta();
        
        if (registros.next()) {
            
            info[0] = registros.getString(1);
            info[1] = registros.getString(2);
            info[2] = registros.getString(3);
        }
        
        return info;
    }
    
    
    public void guardarEdicionIdiomas (String aspirante, String convocatoria, String idioma, String leer, String hablar,
            String escribir) throws SQLException {
        
        sqlSentence = "update aspirante_habla set leer = '"+ leer + "', hablar = '" + hablar + "', escribir = "
                + "'" + escribir + "' where id_aspirante = '" + aspirante + "' and cod_convocatoria = '" + convocatoria + "' "
                + "and cod_idioma = '" + idioma + "';";
        
        ejecutarSentencia();
        
    }
}
