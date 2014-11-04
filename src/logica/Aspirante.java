/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author johnfla
 */
public class Aspirante {

    private String p_nombre;
    private String s_nombre;
    private String p_apellido;
    private String s_apellido;
    private String identificacion;
    private String tipo_id;
    private String municipio_trabaja;
    private String sexo;
    private String jornada;
    private String lugar_residencia;
    private String fecha_nacimiento;
    private String lugar_nacimiento;
    private String tel;

    public Aspirante(String p_nombre, String s_nombre, String p_apellido, String s_apellido, 
                      String identificacion, String tipo_id, String municipio_trabaja, 
                      String sexo, String jornada, String lugar_residencia, String fecha_nacimiento, 
                      String lugar_nacimiento, String tel) {
        
        this.p_nombre = p_nombre;
        this.s_nombre = s_nombre;
        this.p_apellido = p_apellido;
        this.s_apellido = s_apellido;
        this.identificacion = identificacion;
        this.tipo_id = tipo_id;
        this.municipio_trabaja = municipio_trabaja;
        this.sexo = sexo;
        this.jornada = jornada;
        this.lugar_residencia = lugar_residencia;
        this.fecha_nacimiento = fecha_nacimiento;
        this.lugar_nacimiento = lugar_nacimiento;
        this.tel = tel;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getJornada() {
        return jornada;
    }

    public String getLugar_nacimiento() {
        return lugar_nacimiento;
    }

    public String getLugar_residencia() {
        return lugar_residencia;
    }

    public String getMunicipio_trabaja() {
        return municipio_trabaja;
    }

    public String getP_apellido() {
        return p_apellido;
    }

    public String getP_nombre() {
        return p_nombre;
    }

    public String getS_apellido() {
        return s_apellido;
    }

    public String getS_nombre() {
        return s_nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public String getTel() {
        return tel;
    }

    public String getTipo_id() {
        return tipo_id;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public void setLugar_residencia(String lugar_residencia) {
        this.lugar_residencia = lugar_residencia;
    }

    public void setMunicipio_trabaja(String municipio_trabaja) {
        this.municipio_trabaja = municipio_trabaja;
    }

    public void setP_apellido(String p_apellido) {
        this.p_apellido = p_apellido;
    }

    public void setP_nombre(String p_nombre) {
        this.p_nombre = p_nombre;
    }

    public void setS_apellido(String s_apellido) {
        this.s_apellido = s_apellido;
    }

    public void setS_nombre(String s_nombre) {
        this.s_nombre = s_nombre;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    
    
    
}
