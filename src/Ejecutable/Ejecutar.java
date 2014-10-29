/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejecutable;

import Gui.VentanaLogin;
import javax.swing.JFrame;

/**
 *
 * @author anderojas
 */
public class Ejecutar {
    
    public static void main (String [] args) {
        
        VentanaLogin iniciar = new VentanaLogin();
        iniciar.addEvents();
        
        iniciar.verificarUsuarioAdmin();
    }
    
}
