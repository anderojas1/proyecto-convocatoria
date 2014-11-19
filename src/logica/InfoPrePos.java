/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author julian
 */
public class InfoPrePos {
    
    private String identificacion;
    private String RtLicenciado;
    private String RtEspecia;
    private String RtEspeciaTic;
    private String RtMaestria;
    private String RtMaestriaTic;
    private String RtDoctor;
    private String RtDoctorTic;
    private String cod_convo;
    private int puntModulo;
    
    public InfoPrePos(){
    
        identificacion = "00000000";
        RtDoctor = "N/A";
        RtDoctorTic = "N/A";
        RtMaestria = "N/A";
        RtMaestriaTic = "N/A";
        RtEspecia = "N/A";
        RtEspeciaTic = "N/A";
        RtLicenciado = "N/A";
        cod_convo = "";
        puntModulo = 0;
            
    }

    public String getRtLicenciado() {
        return RtLicenciado;
    }

    public void setRtLicenciado(String RtLicenciado) {
        this.RtLicenciado = RtLicenciado;
    }

    public String getRtEspecia() {
        return RtEspecia;
    }

    public void setRtEspecia(String RtEspecia) {
        this.RtEspecia = RtEspecia;
    }

    public String getRtEspeciaTic() {
        return RtEspeciaTic;
    }

    public void setRtEspeciaTic(String RtEspeciaTic) {
        this.RtEspeciaTic = RtEspeciaTic;
    }

    public String getRtMaestria() {
        return RtMaestria;
    }

    public void setRtMaestria(String RtMaestria) {
        this.RtMaestria = RtMaestria;
    }

    public String getRtMaestriaTic() {
        return RtMaestriaTic;
    }

    public void setRtMaestriaTic(String RtMaestriaTic) {
        this.RtMaestriaTic = RtMaestriaTic;
    }

    public String getRtDoctor() {
        return RtDoctor;
    }

    public void setRtDoctor(String RtDoctor) {
        this.RtDoctor = RtDoctor;
    }

    public String getRtDoctorTic() {
        return RtDoctorTic;
    }

    public void setRtDoctorTic(String RtDoctorTic) {
        this.RtDoctorTic = RtDoctorTic;
    }
    
    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    
    public int getPuntModulo() {
        return puntModulo;
    }

    public void setPuntModulo(int puntModulo) {
        this.puntModulo = puntModulo;
    }

    public String getCod_convo() {
        return cod_convo;
    }

    public void setCod_convo(String cod_convo) {
        this.cod_convo = cod_convo;
    }
    
    
}
