/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import com.toedter.calendar.*;
import controlador.DriverConvocatoria;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author anderojas
 */
public class VentanaCrearConvocatoria extends JFrame {
    
    private JLabel lbtitulo;
    private JLabel lbcodigo;
    private JLabel lbnombre;
    private JLabel lbdescripcion;
    private JLabel lbfechaInicio;
    private JLabel lbfechaFin;
    
    private JDateChooser escogerFechaInicio;
    private JDateChooser escogerFechaFin;
    
    private JTextField jtfcodigo;
    private JTextField jtfnombre;
    
    private JTextArea jtadescripcion;
    
    private JScrollPane jspdesplazador;
    
    private JButton jbcrear;
    private JButton jbcancelar;
    
    private JPanel panel;
    
    private DriverConvocatoria controlaConvocatoria;
    
    private ViewValidator validar;
    
    private ManejarEventos driverEvent;
    
    private VentanaAdministrador admin;
    
    public VentanaCrearConvocatoria () {
            
        super("Crear Convocatoria");
        
        inicializarComponentes();
        agregarComponentes();
        acomodarComponentes();

        setSize(530, 670);
        setResizable(false);
        setLocationRelativeTo(null);

        setTitle("Sistema Convocatoria Docente");
        setVisible(true);
        setDefaultCloseOperation(0);
            
    }
    
    
    private void inicializarComponentes () {
        
        panel = new JPanel();
        getContentPane().add(panel);
        
        escogerFechaFin = new JDateChooser();
        escogerFechaInicio = new JDateChooser();

        validar = new ViewValidator();

        lbtitulo = new JLabel("Sistema de Convocatoria Docente");
        lbcodigo = new JLabel("Código *");
        lbnombre = new JLabel("Nombre *");
        lbdescripcion = new JLabel("Descripción *");
        lbfechaInicio = new JLabel("Fecha inicio *");
        lbfechaFin = new JLabel("Fecha fin *");        
        
        jtfcodigo = new JTextField();
        jtfnombre = new JTextField();
        
        jtadescripcion = new JTextArea();
        
        jspdesplazador = new JScrollPane(jtadescripcion);
        
        addFeatures();
    
        jbcrear = new JButton("Crear");
        jbcancelar = new JButton("Cancelar");
        
        controlaConvocatoria = new DriverConvocatoria();
        driverEvent = new ManejarEventos();
        
    }    
    
    private void agregarComponentes () {
        
        panel.add(escogerFechaFin);
        panel.add(escogerFechaInicio);
        
        panel.add(lbtitulo);
        panel.add(lbnombre);
        panel.add(lbcodigo);
        panel.add(lbdescripcion);
        panel.add(lbfechaInicio);
        panel.add(lbfechaFin);
        
        panel.add(jtfcodigo);
        panel.add(jtfnombre);        
        
        panel.add(jbcrear);
        panel.add(jbcancelar);
        
        panel.add(jspdesplazador);
        
        panel.setLayout(null);
        
    }
    
    
    private void acomodarComponentes () {
        
        lbtitulo.setBounds(150, 20, 300, 30);
        
        lbcodigo.setBounds(50, 100, 100, 30);
        jtfcodigo.setBounds(170, 100, 310, 30);
        
        lbnombre.setBounds(50, 150, 100, 30);
        jtfnombre.setBounds(170, 150, 310, 30);
        
        lbdescripcion.setBounds(50, 200, 100, 30);
        jspdesplazador.setBounds(170, 200, 310, 200);
        
        lbfechaFin.setBounds(50, 420, 100, 30);
        escogerFechaFin.setBounds(170, 420, 310, 30);
        
        jbcancelar.setBounds(270, 550, 100, 30);
        jbcrear.setBounds(380, 550, 100, 30);
        
    }
    
    
    public void agregarEventos () {
        
        jbcancelar.addMouseListener(driverEvent);
        jbcrear.addMouseListener(driverEvent);
        
    }
    
    
    public void addFeatures () {
        
        jtadescripcion.setLineWrap(true);
        jtadescripcion.setWrapStyleWord(true);
        
    }
    
    
    public void setVentanaAdmin (VentanaAdministrador adm) {
        
        admin = adm;
        
    }   
    
    private void registrarConvocatoria () {
        
        String campos [] = new String[2];
        
        campos[0] = jtfcodigo.getText();
        campos[1] = jtfnombre.getText();
               
        if (!escogerFechaFin.getCalendar().after(Calendar.getInstance())) {
            
            JOptionPane.showMessageDialog(this, "La fecha de finalización debe ser posterior a la fecha de inicio", 
                    "Error", JOptionPane.ERROR_MESSAGE);
            
        }
        
        else {
            
            try {

                validar.validateEmptyFields(campos);

                String fechafin = new SimpleDateFormat("yyyy-MM-dd").format(escogerFechaFin.getDate());
                String fechaini = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
                String descripcion = jtadescripcion.getText();

                if (descripcion.length() <= 1000) {

                    controlaConvocatoria.guardarConvocatoria(campos[1], descripcion, fechaini, fechafin, "abierta", campos[0],
                            admin.getUsuario());

                    JOptionPane.showMessageDialog(this, "Se ha creado la convocatoria con exito", "Registro exitoso",
                            JOptionPane.INFORMATION_MESSAGE);

                    admin.setVisible(true);
                    dispose();

                } else {

                    JOptionPane.showMessageDialog(this, "La descripción no debe exceder los 1000 caracteres", "Error",
                            JOptionPane.ERROR_MESSAGE);

                }

            } catch (MyException ex) {

                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);

            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(this, ex.getMessage(), "Registro falló", JOptionPane.ERROR_MESSAGE);

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

            }

        }
        
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
        public void mouseClicked(MouseEvent me) {
            
            if (jbcancelar == me.getSource()) {
                
                admin.setVisible(true);
                dispose();
                
            }
            
            else if (jbcrear == me.getSource()) {
                
                registrarConvocatoria();
                
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
            
            
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
            
                    
        }
        
    }
    
}
