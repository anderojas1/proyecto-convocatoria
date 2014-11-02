/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author anderojas
 */
public class Convocatoria {
    
    private String nombre;
    private final String fechaInicio;
    private String fechaCierre;
    
    
    public Convocatoria (String nombreConvocatoria, String fecha_inicio, String fecha_cierre) {
        
        nombre = nombreConvocatoria;
        fechaInicio = fecha_inicio;
        fechaCierre = fecha_cierre;
        
    }
    
    
    public void cambiarNombre (String nombre) {
        
        this.nombre = nombre;
        
    }
    
    
    public void extenderFechaCierre (String fecha_cierre) {
        
        fechaCierre = fecha_cierre;
        
    }
    
    
    public String getFechaCierre () {
        
        return fechaCierre;
        
    }
    
    
    public String getFechaInicio () {
        
        return fechaInicio;
        
    }
    
    
    public String getNombre () {
        
        return nombre;
        
    }
    
}
