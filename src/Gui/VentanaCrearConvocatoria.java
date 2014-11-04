/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import controlador.DriverConvocatoria;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

/**
 *
 * @author anderojas
 */
public class VentanaCrearConvocatoria extends JFrame {
    
    private JLabel lbtitulo;
    private JLabel lbcodigo;
    private JLabel lbnombre;
    private JLabel lbfechaInicio;
    private JLabel lbfechaFin;
    
    private JTextField jtfcodigo;
    private JTextField jtfnombre;
    
    private JSpinner jsaño;
    private JSpinner jsmes;
    private JSpinner jsdia;
    
    private JButton jbcrear;
    private JButton jbcancelar;
    
    private JPanel panel;
    
    private DriverConvocatoria controlaConvocatoria;
    
    private ViewValidator validar;
    
    public VentanaCrearConvocatoria () {
            
        super("Crear Convocatoria");
        
        inicializarComponentes();
        agregarComponentes();
        acomodarComponentes();

        setSize(500, 350);
        setResizable(false);
        setLocationRelativeTo(null);

        setTitle("Sistema Convocatoria Docente");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
            
    }
    
    
    private void inicializarComponentes () {
        
        panel = new JPanel(null);

        validar = new ViewValidator();

        lbtitulo = new JLabel("Sistema de Convocatoria Docente");
        lbcodigo = new JLabel("Código *");
        lbnombre = new JLabel("Nombre *");
        lbfechaInicio = new JLabel("Fecha inicio *");
        lbfechaFin = new JLabel("Fecha fin *");
        
        jtfcodigo = new JTextField();
        jtfnombre = new JTextField();

        jsaño = new JSpinner();
        jsmes = new JSpinner();
        jsdia = new JSpinner();
    
        jbcrear = new JButton("Crear");
        jbcancelar = new JButton("Cancelar");
        
    }
    
    
    private void agregarComponentes () {
        
        
    }
    
    
    private void acomodarComponentes () {
        
        
    }
    
    
    private class ManejarEventos implements KeyListener, MouseListener {

        @Override
        public void keyTyped(KeyEvent e) {
            
            
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
            
            
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
            
            
            
        }

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
        
    }
    
}
