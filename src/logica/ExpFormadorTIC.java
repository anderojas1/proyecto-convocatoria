/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author jhonkrave
 */
public class ExpFormadorTIC {
    private String id, ExpFormerProf, ExpFormerEst, ExpFormertoFormers, soporte_est, soporte_pro, soporte_for,convocatoria;

    
     
    int puntos_est, puntos_pro, puntos_for, puntos_total;

    
    

    public ExpFormadorTIC(String id, String ExpFormerEst, String ExpFormerProf, String ExpFormertoFormers, String soporte_est, String soporte_pro, String soporte_for, int puntos_est, int puntos_pro, int puntos_for, int puntos_total, String convocatoria) {
        this.id = id;
        this.ExpFormerProf = ExpFormerProf;
        this.ExpFormerEst = ExpFormerEst;
        this.ExpFormertoFormers = ExpFormertoFormers;
        this.soporte_est = soporte_est;
        this.soporte_pro = soporte_pro;
        this.soporte_for = soporte_for;
        this.puntos_est = puntos_est;
        this.puntos_pro = puntos_pro;
        this.puntos_for = puntos_for;
        this.puntos_total = puntos_total;
        this.convocatoria = convocatoria;
    }

    public String getExpFormerProf() {
        return ExpFormerProf;
    }

    public void setExpFormerProf(String ExpFormerProf) {
        this.ExpFormerProf = ExpFormerProf;
    }

    public String getExpFormerEst() {
        return ExpFormerEst;
    }

    public void setExpFormerEst(String ExpFormerEst) {
        this.ExpFormerEst = ExpFormerEst;
    }

    public String getExpFormertoFormers() {
        return ExpFormertoFormers;
    }

    public void setExpFormertoFormers(String ExpFormertoFormers) {
        this.ExpFormertoFormers = ExpFormertoFormers;
    }

    public String getId() {
        return id;
    }

    public int getPuntos_est() {
        return puntos_est;
    }
    
    public void setPuntos_est(int puntos) {
        puntos_est = puntos;
    }
    
    
    public int getPuntos_pro() {
        return puntos_pro;
    }
    
   public void setPuntos_pro(int puntos) {
        puntos_pro = puntos;
    }
    
    public int getPuntos_for() {
        return puntos_for;
    }
    
    public void setPuntos_for(int puntos) {
        puntos_for = puntos;
    }
    
    public String getSoporte_est() {
        return soporte_est;
    }
    
    
    public void setSoporte_est(String soporte_est) {
        this.soporte_est = soporte_est;
    }
   
    public String getSoporte_for() {
        return soporte_for;
    }

    public void setSoporte_for(String soporte_for) {
        this.soporte_for = soporte_for;
    }
    
    public String getSoporte_pro() {
        return soporte_pro;
    }

    public void setSoporte_pro(String soporte_pro) {
        this.soporte_pro = soporte_pro;
    }
    
    public String getConvocatoria() {
        return convocatoria;
    }

    public void setConvocatoria(String convocatoria) {
        this.convocatoria = convocatoria;
    }
    
    public int getPuntos_total() {
        return puntos_total;
    }

    public void setPuntos_total(int puntos_total) {
        this.puntos_total = puntos_total;
    }
}
