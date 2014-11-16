/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;

/**
 *
 * @author anderojas
 */
public class FormacionIdiomas {
    
    private final ArrayList <Idioma> idiomas;
    private double puntajeModulo;
    
    
    public FormacionIdiomas () {
        
        idiomas = new ArrayList<>();
        puntajeModulo = 0.0;
        
    }
    
    
    public void añadirIdioma (String nombre, String codigo, String hablar, String escribir, String leer) {
        
        Idioma nuevoIdioma = new Idioma(codigo, nombre, hablar, leer, escribir);
        idiomas.add(nuevoIdioma);
        
    }
    
    
    public void setPuntaje (double puntaje) {
        
        puntajeModulo = puntaje;
        
    }
    
    
    
    
    
}
