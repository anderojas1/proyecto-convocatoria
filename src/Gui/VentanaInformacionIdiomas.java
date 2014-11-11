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
    
    public VentanaInformacionIdiomas () {
        
        iniciarComponentes();
        
    }
    
    
    private void iniciarComponentes () {
        
        jttablaIdiomas =  new JTable(5, 4);
        
    }
    
}
