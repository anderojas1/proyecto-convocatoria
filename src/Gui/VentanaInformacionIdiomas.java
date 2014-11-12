/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author anderojas
 */
public class VentanaInformacionIdiomas extends JFrame {
    
    private JTable jttablaIdiomas;
    private JPanel panel;
    
    private JLabel lbtitulo;
    
    private JButton jbcerrar;
    
    private VentanaOpcionesModulo ventana_opcionesM;
    
    private ManejarEventos driverEventos;
    
    private String id_aspirante;
    
    
    public VentanaInformacionIdiomas (int tipo, String id_as) {
        
        driverEventos = new ManejarEventos();
        
        id_aspirante = id_as;
        
        iniciarComponentes(tipo);
        agregarComponentes();
        acomodarComponentes();
        
    }
    
    
    private void iniciarComponentes (int tipo) {
        
        jttablaIdiomas =  new JTable(5, 4);
        
        panel = new JPanel(null);
        
        jbcerrar = new JButton ("Cerrar");
        
        lbtitulo = new JLabel("Modulo de Idiomas");
        
    }
    
    public void configurarVentana(VentanaOpcionesModulo opcionesMod){
        
        ventana_opcionesM = opcionesMod;
        
    }
    
    
    private void agregarComponentes () {
        
        panel.add(jttablaIdiomas);
        
        getContentPane().add(panel);
        
    }
    
    
    private void acomodarComponentes () {
        
        
    }
    
    public void agregarEventos(){
        
    }
    
    
    private class ManejarEventos implements MouseListener, KeyListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
            
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
            
        }

        @Override
        public void keyTyped(KeyEvent e) {
            
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
            
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
            
            
        }
        
        
    }
    
}
