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
    
    String id;
    double puntuacion;
    
    private String ExpFormerProf, ExpFormerEst, ExpFormertoFormers;

    public ExpFormadorTIC(String id, String ExpFormerProf, String ExpFormerEst, String ExpFormertoFormers) {
        this.id = id;
        this.ExpFormerProf = ExpFormerProf;
        this.ExpFormerEst = ExpFormerEst;
        this.ExpFormertoFormers = ExpFormertoFormers;
        puntuacion = 0;
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

    public double getPuntuacion() {
        return puntuacion;
    }
    
   
    
}
