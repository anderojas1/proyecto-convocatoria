/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import controlador.DriverAspirante;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;
/**
 *
 * @author anderojas
 */
public class VentanaGenerarReportes extends JFrame {
    
    private JPanel panel;
    
    private JButton jbCerrar;
    
    private ManejarEventos controlarEventos;
    
    private DriverAspirante driverAspirante;
    
    public VentanaGenerarReportes () {
        
        super("Reporte Jornadas Laborales");
        
        inicializarComponentes();
        agregarComponentes();
        acomodarComponentes();
        
        setSize(400, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    
    private void inicializarComponentes () {
        
        panel = new JPanel (null);
        
        jbCerrar = new JButton("Cerrar");
        
        controlarEventos = new ManejarEventos();
        driverAspirante = new DriverAspirante();
        
    }
    
    
    private void agregarComponentes () {
        
        getContentPane().add(panel);
        
        panel.add(jbCerrar);
        
    }
    
    private void acomodarComponentes () {
        
        jbCerrar.setBounds(250, 300, 100, 30);
        
    }
    
    
    public void asignarEventos () {
        
        jbCerrar.addActionListener(controlarEventos);
        
    }
    
    public void generarReporteJornadas () {
        
        try {
        
            int jornadaMañana = driverAspirante.consultarNumeros("Jornada", "Mañana");
            int jornadaTarde = driverAspirante.consultarNumeros("Jornada", "Tarde");
            int jornadaAmbas = driverAspirante.consultarNumeros("Jornada", "Ambas");
            System.out.println(jornadaMañana + " - " + jornadaTarde + " - " + jornadaAmbas);
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Consulta fallida", JOptionPane.ERROR_MESSAGE);
            
        }
        
    }
    
    public void generarReporteGenero () {
        
        try {
            
            int sexoMasculino = driverAspirante.consultarNumeros("Genero", "Hombre");
            int sexoFemenino = driverAspirante.consultarNumeros("Genero", "Mujer");
            
            System.out.println(sexoMasculino + " - " + sexoFemenino);
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Consulta fallida", JOptionPane.ERROR_MESSAGE);
            
        }
    }
    
    private class ManejarEventos implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            if (ae.getSource() == jbCerrar) {
                
                dispose();
                
            }
            
        }
        
        
    }
    
    public static void main(String[] args) {
        
        VentanaGenerarReportes rp = new VentanaGenerarReportes();
        rp.asignarEventos();
        rp.generarReporteJornadas();
        rp.generarReporteGenero();
        
    }
    
}
