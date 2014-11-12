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
public class DaoAspForPrePos {

    private Fachada fachada;
    private String sqlDatos;
    private String sentenciaSql;
    private Connection conectar;
    private Statement sentencia;
    private ResultSet registros;

    public DaoAspForPrePos() {

        fachada = new Fachada();

    }

    public void insertInfoRespaldo(InfoPrePos obj) throws SQLException {

        String iden = obj.getIdentificacion();
        String doc = obj.getRtDoctor();
        String docTic = obj.getRtDoctorTic();
        String maest = obj.getRtMaestria();
        String maestTic = obj.getRtMaestriaTic();
        String espec = obj.getRtEspecia();
        String especTic = obj.getRtEspeciaTic();
        String licen = obj.getRtLicenciado();
        
        
        // System.err.println(iden +"\n"+ doc + "\n"+  docTic +"\n"+   maest +"\n"+   maestTic +"\n"+  
          //                                  espec + "\n"+  especTic +"\n"+   licen);
         
        sqlDatos = "INSERT INTO  DocumentosPrePos VALUES (" + "'" + iden  + "', '" + doc  + "', '"+ docTic + "', '" + maest  + "', '" + maestTic +
                                                   "', '" + espec  + "', '" + especTic  + "', '" + licen  + "'" + ");";
        
        //System.err.println(sqlDatos);

        try {
            
            ejecutarSentencia();
        } 
        catch (SQLException ex) {
        
            throw ex;
        }

    }

    public InfoPrePos getApplicant(String id) {

        sentenciaSql = "SELECT * FROM DocumentosPrePos WHERE identificacion = " + id + ";";

        String identificacion = "";
        String doc = "";
        String docTic = "";
        String maest = "";
        String maestTic = "";
        String espec = "";
        String especTic = "";
        String licen = "";
        
        try {

            conectar = fachada.conectar();

            sentencia = conectar.createStatement();

            registros = sentencia.executeQuery(sentenciaSql);

            while (registros.next()) {

                identificacion = (String) registros.getString(1);
                doc = (String) registros.getString(2);
                docTic = (String) registros.getString(3);
                maest = (String) registros.getString(4);
                maestTic = (String) registros.getString(5);
                espec = (String) registros.getString(6);
                especTic = (String) registros.getString(7);
                licen = (String) registros.getString(8);
                
         }
           InfoPrePos infoprepos = new InfoPrePos();
           
           infoprepos.setIdentificacion(identificacion);
           infoprepos.setRtDoctor(doc);
           infoprepos.setRtDoctorTic(docTic);
           infoprepos.setRtMaestria(maest);
           infoprepos.setRtMaestriaTic(maestTic);
           infoprepos.setRtEspecia(espec);
           infoprepos.setRtEspeciaTic(especTic);
           infoprepos.setRtLicenciado(licen);

           return infoprepos;
           
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
