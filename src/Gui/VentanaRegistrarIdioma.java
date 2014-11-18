/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import controlador.DriverAspirante;
import controlador.DriverIdioma;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author anderojas
 */
public class VentanaRegistrarIdioma extends JFrame {

    private final ControladorEventos driverEventos;
    
    private final DriverIdioma controladorIdioma;

    private JLabel lbtitulo;
    private JLabel lbidioma;
    private JLabel lbhablar;
    private JLabel lbescribir;
    private JLabel lbleer;

    private JCheckBoxMenuItem jchbhablarRegular;
    private JCheckBoxMenuItem jchbhablarBueno;
    private JCheckBoxMenuItem jchbhablarMuyBueno;
    private JCheckBoxMenuItem jchbescribirRegular;
    private JCheckBoxMenuItem jchbescribirBueno;
    private JCheckBoxMenuItem jchbescribirMuyBueno;
    private JCheckBoxMenuItem jchbleerRegular;
    private JCheckBoxMenuItem jchbleerBueno;
    private JCheckBoxMenuItem jchbleerMuyBueno;
    
    private JCheckBoxMenuItem jchbleer;
    private JCheckBoxMenuItem jchbescribir;
    private JCheckBoxMenuItem jchbhablar;

    private JComboBox jcbescogerIdioma;

    private JButton jbcancelar;
    private JButton jbregistrar;

    private JPanel panel;
    
    private final String id_aspirante;
    
    private VentanaInformacionIdiomas informacionIdiomas;
    

    public VentanaRegistrarIdioma(String id) {
        
        id_aspirante = id;

        driverEventos = new ControladorEventos();
        
        controladorIdioma = new DriverIdioma();

        inicializarComponentes();
        agregarComponentes();
        acomodarComponentes();

        setSize(600, 450);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(0);
        setVisible(true);

    }

    private void inicializarComponentes() {

        panel = new JPanel(null);
        
        jchbescribir = new JCheckBoxMenuItem();
        jchbhablar = new JCheckBoxMenuItem();
        jchbleer = new JCheckBoxMenuItem();

        lbtitulo = new JLabel("Registrar Idioma");
        lbidioma = new JLabel("Seleccione el idioma");
        lbhablar = new JLabel("Conversación");
        lbescribir = new JLabel("Escritura");
        lbleer = new JLabel("Lectura");

        jchbhablarRegular = new JCheckBoxMenuItem("Regular");
        jchbhablarBueno = new JCheckBoxMenuItem("Bueno");
        jchbhablarMuyBueno = new JCheckBoxMenuItem("Muy bueno");

        jchbescribirRegular = new JCheckBoxMenuItem("Regular");
        jchbescribirBueno = new JCheckBoxMenuItem("Bueno");
        jchbescribirMuyBueno = new JCheckBoxMenuItem("Muy bueno");

        jchbleerBueno = new JCheckBoxMenuItem("Bueno");
        jchbleerRegular = new JCheckBoxMenuItem("Regular");
        jchbleerMuyBueno = new JCheckBoxMenuItem("Muy bueno");

        jcbescogerIdioma = new JComboBox();
        cargarIdiomas();

        jbcancelar = new JButton("Cancelar");
        jbregistrar = new JButton("Guardar");

        getContentPane().add(panel);
        
    }
    
    
    private void cargarIdiomas () {
        
        try {
            
            ArrayList <String> idiomas = controladorIdioma.consultarIdiomas();
            
            for (String nombre : idiomas) {
                
                jcbescogerIdioma.addItem(nombre);
                
            }
            
        } catch (SQLException ex) {
            
            
        }
        
    }
    

    private void agregarComponentes() {

        panel.add(lbtitulo);

        panel.add(lbidioma);
        panel.add(jcbescogerIdioma);

        panel.add(lbhablar);
        panel.add(jchbhablarRegular);
        panel.add(jchbhablarBueno);
        panel.add(jchbhablarMuyBueno);

        panel.add(lbescribir);
        panel.add(jchbescribirRegular);
        panel.add(jchbescribirBueno);
        panel.add(jchbescribirMuyBueno);

        panel.add(lbleer);
        panel.add(jchbleerRegular);
        panel.add(jchbleerBueno);
        panel.add(jchbleerMuyBueno);

        panel.add(jbcancelar);
        panel.add(jbregistrar);

    }

    private void acomodarComponentes() {

        lbtitulo.setBounds(240, 20, 220, 30);

        lbidioma.setBounds(50, 80, 150, 30);
        jcbescogerIdioma.setBounds(220, 80, 310, 30);
        
        lbhablar.setBounds(50, 140, 160, 30);
        jchbhablarRegular.setBounds(50, 180, 150, 30);
        jchbhablarBueno.setBounds(50, 210, 150, 30);
        jchbhablarMuyBueno.setBounds(50, 240, 150, 30);
        
        lbescribir.setBounds(240, 140, 160, 30);
        jchbescribirRegular.setBounds(240, 180, 150, 30);
        jchbescribirBueno.setBounds(240, 210, 150, 30);
        jchbescribirMuyBueno.setBounds(240, 240, 150, 30);
        
        lbleer.setBounds(430, 140, 160, 30);
        jchbleerRegular.setBounds(430, 180, 150, 30);
        jchbleerBueno.setBounds(430, 210, 150, 30);
        jchbleerMuyBueno.setBounds(430, 240, 150, 30);
        
        jbcancelar.setBounds(300, 320, 110, 30);
        jbregistrar.setBounds(420, 320, 110, 30);
        
    }
    
    
    public void asignarEventos () {
        
        jchbhablarRegular.addMouseListener(driverEventos);
        jchbhablarBueno.addMouseListener(driverEventos);
        jchbhablarMuyBueno.addMouseListener(driverEventos);
        
        jchbescribirRegular.addMouseListener(driverEventos);
        jchbescribirBueno.addMouseListener(driverEventos);
        jchbescribirMuyBueno.addMouseListener(driverEventos);
        
        jchbleerRegular.addMouseListener(driverEventos);
        jchbleerBueno.addMouseListener(driverEventos);
        jchbleerMuyBueno.addMouseListener(driverEventos);
        
        jbcancelar.addMouseListener(driverEventos);
        jbregistrar.addMouseListener(driverEventos);
        
    }
    
    
    public void configurarVentana (VentanaInformacionIdiomas ventana) {
        
        informacionIdiomas = ventana;
        
    }
    
    
    private boolean validarChecks (String moduloIdioma) {
                
        if (moduloIdioma.equals("lectura")) {
            
            if (jchbleerRegular.getState() == true || jchbleerMuyBueno.getState() == true || jchbleerBueno.getState() == true) {
                
                return true;
                
            }
            
        }
        
        else if (moduloIdioma.equals("escritura")) {
            
            if (jchbescribirRegular.getState() == true || jchbescribirMuyBueno.getState() == true || jchbescribirBueno.getState() == true) {
                
                return true;
                
            }
            
        }
        
        else {
            
            if (jchbhablarRegular.getState() == true || jchbhablarMuyBueno.getState() == true || jchbhablarBueno.getState() == true) {
                
                return true;
                
            }
            
        }
        
        return false;
        
    }
    
    
    public void guardarDatos () {
        
        boolean checkLeer = validarChecks("lectura");
        boolean checkEscribir = validarChecks("escritura");
        boolean checkHablar = validarChecks("conversacion");
        
        if (checkLeer == true && checkHablar == true && checkEscribir == true) {
			
            try {
				
		String nombre = jcbescogerIdioma.getSelectedItem().toString();                
		String lee = jchbleer.getText();
                String escribe = jchbescribir.getText();
                String habla = jchbhablar.getText();
				
		String codigoIdioma = controladorIdioma.consultarCodigo(nombre);
                
                double pun = 0.0;
                double nuevo = 0.0;
                double puntajeSumar = 0.0;
                boolean es = false;
                boolean cambia = false;
                
                try {
                    
                    pun = controladorIdioma.consultarPuntajeMaximo();
                    
                    nuevo = calcularPuntaje(habla, lee, escribe);
                    
                    if (pun == 0.0) {
                        
                        es = true;
                        puntajeSumar = nuevo;
                    }
                    
                    else if (nuevo > pun) {
                        
                        es = true;
                        cambia = true;
                        puntajeSumar = nuevo - pun;
                        
                    }
                    
                } catch (SQLException ex) {
                    
                }
                
                controladorIdioma.agregarIdiomaAspirante(id_aspirante, codigoIdioma, habla, lee, escribe, nuevo, es, cambia);
                System.out.println("flag 1");
                DriverAspirante asp = new DriverAspirante();
                
                double puntajeTotalActual = asp.consultarPuntaje(id_aspirante, "1");
                System.out.println("flag 2");
                puntajeTotalActual += puntajeSumar;
                
                asp.updatePuntajeUsuario(id_aspirante, "1", puntajeTotalActual);
            
		JOptionPane.showMessageDialog(this, "Se registró el idioma exitosamente", "Idioma registrado", JOptionPane.INFORMATION_MESSAGE);
            
		informacionIdiomas.setVisible(true);
                informacionIdiomas.actualizarInformacionIdiomas(nombre, lee, escribe, habla);
            
		dispose();
				
            } catch (SQLException ex) {
				
            }
            
        }
        
        else JOptionPane.showMessageDialog(this, "Debe seleccionar su nivel de manejo del idioma en todos los componentes", 
                                                    "Error campos sin marcar", JOptionPane.ERROR_MESSAGE);
    }
    
    public double calcularPuntaje (String hablar, String leer, String escribir) {
                
        double puntaje = 0.0;
        
        puntaje += comparar(true, hablar);
        puntaje += comparar(false, escribir);
        puntaje += comparar(false, leer);
        
        System.out.println("puntaje: " + puntaje);
        
        return puntaje;
        
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

    private class ControladorEventos implements MouseListener, KeyListener {

        @Override
        public void mouseClicked(MouseEvent me) {
            
            if (me.getSource() == jbcancelar) {
                
                informacionIdiomas.setVisible(true);
                dispose();
                
            }
            
            else if (me.getSource() == jbregistrar) {
                
                guardarDatos();
                
            }
            
            else if (me.getSource() == jchbhablarRegular) {
                
                jchbhablarBueno.setState(false);
                jchbhablarMuyBueno.setState(false);
                jchbhablar = jchbhablarRegular;
                
            }
            
            else if (me.getSource() == jchbhablarBueno) {
                
                jchbhablarRegular.setState(false);
                jchbhablarMuyBueno.setState(false);
                jchbhablar = jchbhablarBueno;
                
            }
            
            else if (me.getSource() == jchbhablarMuyBueno) {
                
                jchbhablarBueno.setState(false);
                jchbhablarRegular.setState(false);
                jchbhablar = jchbhablarMuyBueno;
                
            }
            
            else if (me.getSource() == jchbescribirRegular) {
                
                jchbescribirBueno.setState(false);
                jchbescribirMuyBueno.setState(false);
                jchbescribir = jchbescribirRegular;
                
            }
            
            else if (me.getSource() == jchbescribirBueno) {
                
                jchbescribirRegular.setState(false);
                jchbescribirMuyBueno.setState(false);
                jchbescribir = jchbescribirBueno;
                
            }
            
            else if (me.getSource() == jchbescribirMuyBueno) {
                
                jchbescribirBueno.setState(false);
                jchbescribirRegular.setState(false);
                jchbescribir = jchbescribirMuyBueno;
                
            }
            
            else if (me.getSource() == jchbleerRegular) {
                
                jchbleerBueno.setState(false);
                jchbleerMuyBueno.setState(false);
                jchbleer = jchbleerRegular;
                
            }
            
            else if (me.getSource() == jchbleerBueno) {
                
                jchbleerRegular.setState(false);
                jchbleerMuyBueno.setState(false);
                jchbleer = jchbleerBueno;
                
            }
            
            else if (me.getSource() == jchbleerMuyBueno) {
                
                jchbleerBueno.setState(false);
                jchbleerRegular.setState(false);
                jchbleer = jchbleerMuyBueno;
                
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
        public void mouseExited(MouseEvent mme) {

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
