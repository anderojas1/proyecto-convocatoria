/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author anderojas
 */
public class VentanaInformacionIdiomas extends JFrame {
    
    private JTable jttablaIdiomas;
    private DefaultTableModel modelo;
    private JPanel panel;
    
    private JLabel lbtitulo;
    
    private JButton jbcerrar;
    private JButton jbregistrar;
    
    private VentanaOpcionesModulo ventana_opcionesM;
    
    private ManejarEventos driverEventos;
    
    private String id_aspirante;
    
    
    public VentanaInformacionIdiomas (int tipo, String id_as) {
        
        driverEventos = new ManejarEventos();
        
        id_aspirante = id_as;
        
        iniciarComponentes(tipo);
        agregarComponentes();
        acomodarComponentes();
        
        setSize(500, 550);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }
    
    
    private void iniciarComponentes (int tipo) {
        
        panel = new JPanel(null);
        
        String [] titulos = new String [] {"Idioma", "Lee", "Escribe", "Habla"};
        
        modelo = new DefaultTableModel(0, 4);
        modelo.addRow(titulos);
        
        jttablaIdiomas =  new JTable(modelo);
        
        jttablaIdiomas.setAutoscrolls(true);
        jttablaIdiomas.setEnabled(false);
               
        jbcerrar = new JButton ("Cerrar");
        jbregistrar = new JButton("Agregar");
        
        lbtitulo = new JLabel("Modulo de Idiomas");
        
    }
    
    
    public void agregarIdiomas (String [] informacion) {
        
        modelo.addRow(informacion);
        
    }
    
    
    public void abrirInterfazRegistro() {
        
        VentanaRegistrarIdioma registrar = new VentanaRegistrarIdioma(id_aspirante);
        registrar.configurarVentana(this);
        registrar.asignarEventos();
        setVisible(false);
        
    }
    
    public void configurarVentana(VentanaOpcionesModulo opcionesMod){
        
        ventana_opcionesM = opcionesMod;
        
    }
    
    
    private void agregarComponentes () {
        
        panel.add(jttablaIdiomas);
        panel.add(jbcerrar);
        panel.add(jbregistrar);
        
        getContentPane().add(panel);
        
    }
    
    
    private void acomodarComponentes () {
        
        jttablaIdiomas.setBounds(50, 100, 400, 300);
        
        jbregistrar.setBounds(220, 450, 100, 30);
        jbcerrar.setBounds(350, 450, 100, 30);
                
    }
    
    public void agregarEventos() {
        
        jbcerrar.addMouseListener(driverEventos);
        jbregistrar.addMouseListener(driverEventos);
        
    }
    
    
    private class ManejarEventos implements MouseListener, KeyListener {

        @Override
        public void mouseClicked(MouseEvent me) {
            
            if (me.getSource() == jbcerrar) {
                
                ventana_opcionesM.setVisible(true);
                dispose();
                
            }
            
            else if (me.getSource() == jbregistrar) {
                
                abrirInterfazRegistro();
                
            }
        }

        @Override
        public void mousePressed(MouseEvent me) {
            
            
        }

        @Override
        public void mouseReleased(MouseEvent me) {
            
            
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            
            
        }

        @Override
        public void mouseExited(MouseEvent me) {
            
            
        }

        @Override
        public void keyTyped(KeyEvent me) {
            
            
        }

        @Override
        public void keyPressed(KeyEvent me) {
            
            
        }

        @Override
        public void keyReleased(KeyEvent me) {
            
            
        }
        
        
    }
    
}
