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
public class Idioma {
    
    private final String nombre;
    private final String codigo;
    private String hablar;
    private String leer;
    private String escribir;
    
    
    public Idioma (String code, String languaje, String cal_hablar, String cal_leer, String cal_escribir) {
        
        nombre = languaje;
        codigo = code;
        hablar = cal_hablar;
        leer = cal_leer;
        escribir = cal_escribir;
        
    }   
    
    
    public void setEscribir (String calificacion) {
        
        escribir = calificacion;
        
    }
    
    
    public void setLeer (String calificacion) {
        
        leer = calificacion;
        
    }
    
    
    public void setHablar (String calificacion) {
        
        hablar = calificacion;
        
    }
    
    
    public String getNombre () {
        
        return nombre;
        
    }
    
    
    public String getEscribir () {
        
        return escribir;
        
    }
    
    
    public String getLeer () {
        
        return leer;
        
    }
    
    
    public String getHablar () {
        
        return hablar;
        
    }
    
    
    public String getCodigo () {
        
        return codigo;
        
    }
    
}
