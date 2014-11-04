/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

/**
 *
 * @author anderojas
 */
public class Convocatoria {
    
    private String nombre;
    private final String fechaInicio;
    private String fechaCierre;
    private String estado;
    private final String codigo;
    
    
    public Convocatoria (String nombreConvocatoria, String fecha_inicio, String fecha_cierre, String codigo_convocatoria, String estadoCon) {
        
        nombre = nombreConvocatoria;
        fechaInicio = fecha_inicio;
        fechaCierre = fecha_cierre;
        codigo = codigo_convocatoria;
        estado = estadoCon;
        
    }
    
    
    private void actualizarEstadoConvocatoria () {
        
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
    
    
    public String getCodigo () {
        
        return codigo;
        
    }
    
    
    public String getEstado () {
        
        return estado;
        
    }
    
}
