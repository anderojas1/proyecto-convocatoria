/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import logica.*;

/**
 *
 * @author jhonkrave
 */
public class DaoconociminetoEspecific {

    private final Fachada fachadaConectar;
    private String sentenciaSql;
    private Connection conectar;
    private Statement sentencia;
    private ResultSet registros;

    public DaoconociminetoEspecific() {


        fachadaConectar = new Fachada();

    }

    public void InsertConocimientoEspficic(conocimientosEspecificos ce) throws SQLException {

        sentenciaSql = "INSERT INTO CONOCIMIENTOS_ESPECIFICOS VALUES ('" + ce.getID() + "', '" + ce.getJLherram_Ofimatic() + "', "
                + "'" + ce.getJLherram_Web2() + "', '" + ce.getJLherram_edic_multi() + "', '" + ce.getJLexp_des_cont_edu_dig() + "', "
                + "'" + ce.getJLexp_des_lib_dig() + "', '" + ce.getJLexp_proc_elearning() + "', '" + ce.getJLexp_gest_proy_TIC() + "', "
                + "'" + ce.getJLexp_des_elemnts_eval_comp() + "', " + ce.getPuntuacion() + ");";

        ejecutarSentencia();

    }

    public void UpdateConocimentoEspecific(conocimientosEspecificos ce) throws SQLException {

        sentenciaSql = "UPDATE CONOCIMIENTOS_ESPECIFICOS "
                + "SET herram_Ofimatic = '" + ce.getJLherram_Ofimatic() + "', "
                + "herram_Web2 = '" + ce.getJLherram_Web2() + "', herram_edic_multi = '" + ce.getJLherram_edic_multi() + "', exp_des_cont_edu_dig = '" + ce.getJLexp_des_cont_edu_dig() + "', "
                + "exp_des_lib_dig = '" + ce.getJLexp_des_lib_dig() + "', exp_proc_elearning= '" + ce.getJLexp_proc_elearning() + "', exp_gest_proy_TIC = '" + ce.getJLexp_gest_proy_TIC() + "', "
                + "exp_des_elemnts_eval_comp = '" + ce.getJLexp_des_elemnts_eval_comp() + "', puntuacion = " + ce.getPuntuacion() + " WHERE id_aspirante = '"+ce.getID()+"';";

        ejecutarSentencia();

    }

    public void ejecutarSentencia() throws SQLException {

        try {

            conectar = fachadaConectar.conectar();

            sentencia = conectar.createStatement();
            sentencia.executeUpdate(sentenciaSql);


            conectar.close();

        } catch (SQLException ex) {

            throw ex;

        } catch (NullPointerException ex) {

            JOptionPane.showMessageDialog(null, "Error en base de datos. No se puede conectar");

        }

    }

    public conocimientosEspecificos selectConocimientoEspecific(String id) {

        sentenciaSql = "SELECT * FROM CONOCIMIENTOS_ESPECIFICOS WHERE id_aspirante= '" + id + "';";
        conocimientosEspecificos c  = null;


        try {
            conectar = fachadaConectar.conectar();
            sentencia = conectar.createStatement();
            registros = sentencia.executeQuery(sentenciaSql);

            while (registros.next()) {

                String JLherram_Ofimatic = (String) registros.getString(2);
                String JLherram_Web2 = (String) registros.getString(3);
                String JLherram_edic_multi = (String) registros.getString(4);
                String JLexp_des_cont_edu_dig = (String) registros.getString(5);
                String JLexp_des_lib_dig = (String) registros.getString(6);
                String JLexp_proc_elearning = (String) registros.getString(7);
                String JLexp_gest_proy_TIC = (String) registros.getString(8);
                String JLexp_des_elemnts_eval_comp = (String) registros.getString(9);

                double puntuacion = (double) registros.getDouble(10);

                 c = new conocimientosEspecificos(id, JLherram_Ofimatic, JLherram_Web2, JLherram_edic_multi, JLexp_des_cont_edu_dig, JLexp_des_lib_dig, JLexp_proc_elearning, JLexp_gest_proy_TIC, JLexp_des_elemnts_eval_comp, puntuacion);
            
            }
            
            return c;
            
        } catch (SQLException ex) {
            
            System.out.println("no se encontro conocimiento especifico");
            return null;
            
            
        }
        
    }
}
