/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import AccesoDatos.*;
import java.sql.SQLException;
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
    
    
    public DaoconociminetoEspecific(){
    
    
        fachadaConectar = new Fachada();
    
    }
    
    public void InsertConocimientoEspficic (conocimientosEspecificos ce) throws SQLException{
    
        sentenciaSql = "INSERT INTO CONOCIMIENTOS_ESPECIFICOS VALUES ('"+ce.getID()+"', '"+ce.getJLherram_Ofimatic()+"', "
                + "'"+ce.getJLherram_Web2()+"', '"+ce.getJLherram_edic_multi()+"', '"+ce.getJLexp_des_cont_edu_dig()+"', "
                + "'"+ce.getJLexp_des_lib_dig()+"', '"+ce.getJLexp_proc_elearning()+"', '"+ce.getJLexp_gest_proy_TIC()+"', "
                + "'"+ce.getJLexp_des_elemnts_eval_comp()+"', "+ce.getPuntuacion()+");";
    
        ejecutarSentencia();
    
    }
    
    public void UpdateConocimentoEspecific(conocimientosEspecificos ce) throws SQLException{
    
        sentenciaSql = "UPDATE CONOCIMIENTOS_ESPECIFICOS "
                + "SET herram_Ofimatic = '"+ce.getJLherram_Ofimatic()+"', "
                + "herram_Web2 = '"+ce.getJLherram_Web2()+"', herram_edic_multi = '"+ce.getJLherram_edic_multi()+"', exp_des_cont_edu_dig = '"+ce.getJLexp_des_cont_edu_dig()+"', "
                + "exp_des_lib_dig = '"+ce.getJLexp_des_lib_dig()+"', exp_proc_elearning= '"+ce.getJLexp_proc_elearning()+"', exp_gest_proy_TIC = '"+ce.getJLexp_gest_proy_TIC()+"', "
                + "getJLexp_des_elemnts_eval_comp = '"+ce.getJLexp_des_elemnts_eval_comp()+"', puntuacion = "+ce.getPuntuacion()+");";
    
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
    
}
