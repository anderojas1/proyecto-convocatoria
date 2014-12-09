

package logica;


public class formacionTic {
    
    private int consecutivo;
    private String identificacion;
    private String titulo;
    private String soporte;
    private int puntaje;
    private String convocatoria;
   
    public  formacionTic(){
        
    }
    
    public formacionTic(String identificacion, String titulo, int consecutivo, String soporte, int puntaje, String convocatoria){
        
        this.identificacion = identificacion;
        this.titulo = titulo;
        this.consecutivo = consecutivo;
        this.soporte = soporte;
        this.puntaje = puntaje;
        this.convocatoria = convocatoria;
    }

    public int getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSoporte() {
        return soporte;
    }

    public void setSoporte(String soporte) {
        this.soporte = soporte;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public String getConvocatoria() {
        return convocatoria;
    }

    public void setConvocatoria(String convocatoria) {
        this.convocatoria = convocatoria;
    }
    
    
    
}
