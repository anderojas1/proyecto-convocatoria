/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;



/**
 *
 * @author jhonkrave
 */
public class conocimientosEspecificos {
    
    private String identififcacion;
    private double puntuacion;
    
    private String JLherram_Ofimatic;
    private String JLherram_Web2;
    private String JLherram_edic_multi;
    private String JLexp_des_cont_edu_dig;
    private String JLexp_des_lib_dig;
    private String JLexp_proc_elearning;
    private String JLexp_gest_proy_TIC;
    private String JLexp_des_elemnts_eval_comp;

    public conocimientosEspecificos(String id, String JLherram_Ofimatic, String JLherram_Web2, String JLherram_edic_multi, String JLexp_des_cont_edu_dig, String JLexp_des_lib_dig, String JLexp_proc_elearning, String JLexp_gest_proy_TIC, String JLexp_des_elemnts_eval_comp, double puntuacion) {
        this.identififcacion = id;
        this.puntuacion = puntuacion;
        
        this.JLherram_Ofimatic = JLherram_Ofimatic;
        this.JLherram_Web2 = JLherram_Web2;
        this.JLherram_edic_multi = JLherram_edic_multi;
        this.JLexp_des_cont_edu_dig = JLexp_des_cont_edu_dig;
        this.JLexp_des_lib_dig = JLexp_des_lib_dig;
        this.JLexp_proc_elearning = JLexp_proc_elearning;
        this.JLexp_gest_proy_TIC = JLexp_gest_proy_TIC;
        this.JLexp_des_elemnts_eval_comp = JLexp_des_elemnts_eval_comp;
    }

    public String getJLherram_Ofimatic() {
        return JLherram_Ofimatic;
    }

    public String getJLherram_Web2() {
        return JLherram_Web2;
    }

    public String getJLherram_edic_multi() {
        return JLherram_edic_multi;
    }

    public String getJLexp_des_cont_edu_dig() {
        return JLexp_des_cont_edu_dig;
    }

    public String getJLexp_des_lib_dig() {
        return JLexp_des_lib_dig;
    }

    public String getJLexp_proc_elearning() {
        return JLexp_proc_elearning;
    }

    public String getJLexp_gest_proy_TIC() {
        return JLexp_gest_proy_TIC;
    }

    public String getJLexp_des_elemnts_eval_comp() {
        return JLexp_des_elemnts_eval_comp;
    }
    
    public String getID(){
    
        return identififcacion;
    }
    
    public double getPuntuacion(){
    return puntuacion;
    }
    
    public void setPuntuacion(double p){
    
        this.puntuacion = p;
    
    }
    
    public void setJLherram_Ofimatic(String JLherram_Ofimatic) {
        this.JLherram_Ofimatic = JLherram_Ofimatic;
    }

    public void setJLherram_Web2(String JLherram_Web2) {
        this.JLherram_Web2 = JLherram_Web2;
    }

    public void setJLherram_edic_multi(String JLherram_edic_multi) {
        this.JLherram_edic_multi = JLherram_edic_multi;
    }

    public void setJLexp_des_cont_edu_dig(String JLexp_des_cont_edu_dig) {
        this.JLexp_des_cont_edu_dig = JLexp_des_cont_edu_dig;
    }

    public void setJLexp_des_lib_dig(String JLexp_des_lib_dig) {
        this.JLexp_des_lib_dig = JLexp_des_lib_dig;
    }

    public void setJLexp_proc_elearning(String JLexp_proc_elearning) {
        this.JLexp_proc_elearning = JLexp_proc_elearning;
    }

    public void setJLexp_gest_proy_TIC(String JLexp_gest_proy_TIC) {
        this.JLexp_gest_proy_TIC = JLexp_gest_proy_TIC;
    }

    public void setJLexp_des_elemnts_eval_comp(String JLexp_des_elemnts_eval_comp) {
        this.JLexp_des_elemnts_eval_comp = JLexp_des_elemnts_eval_comp;
    }
    
    
    
}
