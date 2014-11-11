/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import javax.swing.*;

/**
 *
 * @author anderojas
 */
public class VentanaInformacionIdiomas extends JFrame {
    
    private JTable jttablaIdiomas;
    private VentanaOpcionesModulo ventana_opcionesM;
    
    public VentanaInformacionIdiomas (int tipo, String id_as) {
        
        iniciarComponentes();
        
    }
    
    
    private void iniciarComponentes () {
        
        jttablaIdiomas =  new JTable(5, 4);
        
    }
    
    public void configurarVentana(VentanaOpcionesModulo opcionesMod){
        ventana_opcionesM = opcionesMod;
    }
    
    public void agregarEventos(){
        
    }
    
}
