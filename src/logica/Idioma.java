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
    
    private String idioma;
    private int dominio;
    
    
    public Idioma (String languaje, int ability) {
        
        idioma = languaje;
        dominio = ability;
        
    }
    
    
    public void setDominio (int ability) {
        
        dominio = ability;
        
    }
    
    
    public String getIdioma () {
        
        return idioma;
        
    }
    
    
    public int getDominio () {
        
        return dominio;
    }
    
}
