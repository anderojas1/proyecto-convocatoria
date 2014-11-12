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
    
    
    public void calcularPuntaje () {
        
        /*Idioma compara = idiomas.get(idiomas.size()-1);
        
        String hablar = compara.getHablar();
        String leer = compara.getLeer();
        String escribir = compara.getEscribir();
        
        double puntaje = 0.0;
        
        puntaje += comparar(true, hablar);
        puntaje += comparar(false, escribir);
        puntaje += comparar(false, leer);
        
        if (puntaje > puntajeModulo) {
            
            setPuntaje(puntaje);
            
        }*/
        
    }
    
    
    public double comparar (boolean opera, String manejo) {
        
        if (opera == true) {
            
            if (manejo.equals("Muy bueno")) return 4.0;
            
            else if (manejo.equals("Bueno")) return 2.0;
            
            else return 1.0;
            
        }
        
        else {
            
            if (manejo.equals("Muy bueno")) return 3.0;
            
            else if (manejo.equals("Bueno")) return 1.5;
            
            else return 0.8;
            
        }
    }
    
    
}
