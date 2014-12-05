/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import controlador.DriverAspirante;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import javax.swing.*;
/**
 *
 * @author anderojas
 */
public class VentanaGenerarReportes extends JFrame {
    
    private JPanel panel;
    
    private JLabel lbMunicipios;
    private JLabel lbMunicipiosInfo;
    private JLabel lbJornadaLaboral;
    private JLabel lbJornadaLaboralInfo;
    private JLabel lbGenero;
    private JLabel lbGeneroInfo;
    
    private JButton jbCerrar;
    
    private ManejarEventos controlarEventos;
    
    private DriverAspirante driverAspirante;
    
    public VentanaGenerarReportes () {
        
        super("Reportes Convocatoria");
        
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
        panel.setBackground(Color.WHITE);
        
        lbMunicipios = new JLabel(new ImageIcon("src/iconos/mapa-valle.jpg"));
        lbMunicipios.setToolTipText("Generar Reporte");
        lbMunicipiosInfo = new JLabel("<html><center>Inscritos por<br>Municipio</center></html>");
        lbMunicipiosInfo.setFont(new Font("Arial", 1, 10));
        lbMunicipiosInfo.setToolTipText("Número de inscritos por municipio");
        
        lbJornadaLaboral = new JLabel(new ImageIcon("src/iconos/jornada_laboral.jpg"));
        lbJornadaLaboral.setToolTipText("Generar Reporte");
        lbJornadaLaboralInfo = new JLabel("<html><center>Inscritos por<br>Jornada</center></html>");
        lbJornadaLaboralInfo.setFont(new Font("Arial", 1, 10));
        lbJornadaLaboralInfo.setToolTipText("Número de inscritos por jornada laboral");
        
        lbGenero = new JLabel(new ImageIcon("src/iconos/genero.jpg"));
        lbGenero.setToolTipText("Generar Reporte");
        lbGeneroInfo = new JLabel("<html><center>Inscritos por<br>Género</center></html>");
        lbGeneroInfo.setFont(new Font("Arial", 1, 10));
        lbGeneroInfo.setToolTipText("Número de inscritos por género");
        
        jbCerrar = new JButton("Cerrar");
        
        controlarEventos = new ManejarEventos();
        driverAspirante = new DriverAspirante();
        
    }   
      
    
    private void agregarComponentes () {
        
        getContentPane().add(panel);
        
        panel.add(lbMunicipios);
        panel.add(lbMunicipiosInfo);
        
        panel.add(lbJornadaLaboral);
        panel.add(lbJornadaLaboralInfo);
        
        panel.add(lbGenero);
        panel.add(lbGeneroInfo);
        
        panel.add(jbCerrar);
        
    }
    
    private void acomodarComponentes () {
        
        lbMunicipios.setBounds(50, 70, 64, 64);
        lbMunicipiosInfo.setBounds(50, 140, 64, 30);
        
        lbJornadaLaboral.setBounds(140, 70, 64, 64);
        lbJornadaLaboralInfo.setBounds(140, 140, 64, 30);
        
        lbGenero.setBounds(230, 70, 64, 64);
        lbGeneroInfo.setBounds(230, 140, 64, 30);
        
        jbCerrar.setBounds(250, 300, 100, 30);
        
    }
    
    
    public void asignarEventos () {
        
        jbCerrar.addMouseListener(controlarEventos);
        lbMunicipios.addMouseListener(controlarEventos);
        lbJornadaLaboral.addMouseListener(controlarEventos);
        lbGenero.addMouseListener(controlarEventos);
        
    }
    
    public void generarReporteJornadas () {
        
        try {
        
            int jornadaMañana = driverAspirante.consultarNumeros("Jornada", "Mañana");
            int jornadaTarde = driverAspirante.consultarNumeros("Jornada", "Tarde");
            int jornadaAmbas = driverAspirante.consultarNumeros("Jornada", "Ambas");
            System.out.println(jornadaMañana + " - " + jornadaTarde + " - " + jornadaAmbas);
            
            JOptionPane.showMessageDialog(this, "Estamos en desarrollo", "Módulo en desarrollo", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Consulta fallida", JOptionPane.ERROR_MESSAGE);
            
        }
        
    }
    
    public void generarReporteGenero () {
        
        try {
            
            int sexoMasculino = driverAspirante.consultarNumeros("Genero", "Hombre");
            int sexoFemenino = driverAspirante.consultarNumeros("Genero", "Mujer");
            
            System.out.println(sexoMasculino + " - " + sexoFemenino);
            
            JOptionPane.showMessageDialog(this, "Estamos en desarrollo", "Módulo en desarrollo", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Consulta fallida", JOptionPane.ERROR_MESSAGE);
            
        }
        
    }
    
    public void generarReporteMunicipios () {
        
        JOptionPane.showMessageDialog(this, "Estamos en desarrollo", "Módulo en desarrollo", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private class ManejarEventos implements MouseListener {
                
        @Override
        public void mouseClicked(MouseEvent e) {
            
            if (e.getSource() == jbCerrar) {
                
                dispose();
                
            } else if (e.getSource() == lbMunicipios) {
                
                generarReporteMunicipios ();
                
            } else if (e.getSource() == lbJornadaLaboral) {
                
                generarReporteJornadas();
                
            } else if (e.getSource() == lbGenero) {
                
                generarReporteGenero();
                
            }
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
            if (e.getSource() == lbMunicipios) {
                
                lbMunicipios.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
            } else if (e.getSource() == lbJornadaLaboral) {
                
                lbJornadaLaboral.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
            } else if (e.getSource() == lbGenero) {
                
                lbGenero.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
            }
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
        }
        
        
    }
    
    public static void main(String[] args) {
        
        VentanaGenerarReportes rp = new VentanaGenerarReportes();
        rp.asignarEventos();
        
    }
    
}
