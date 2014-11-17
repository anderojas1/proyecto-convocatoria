/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import controlador.DriverUsuario;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import javax.swing.*;

/**
 *
 * @author anderojas
 */
public class VentanaRestorePassword extends JFrame {
    
    private JLabel jlTitulo;
    private JLabel jlIdentificacion;
    private JLabel jlNuevoPassword;
    private JLabel jlConfirmarNuevoPassword;
    private JLabel jlEncontrado;
    private JLabel jlInfoBusqueda;
    
    private JTextField jtfIdentificacion;
    private JPasswordField jtfPassword;
    private JPasswordField jtfConfirmarPassword;
    
    private JButton jbIngresarIdentificacion;
    private JButton jbEnviarNuevoPassword;
    private JButton jbCancelar;
    
    private JPanel panel;
    
    private ManejadorEventos driverEvents;
    
    private final DriverUsuario driver;
    
    private final ViewValidator validador;

    public VentanaRestorePassword() {
        
        driver = new DriverUsuario();
        validador = new ViewValidator();
        
        iniciarComponentes();
        adicionarComponentes();
        acomodarComponentes();
        adicionarCaracteristicas();
        agregarEventos();
        
        setSize(500, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Cambiar contraseña de usuario");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
    
    private void iniciarComponentes () {
        
        panel = new JPanel(null);
        panel.setBackground(Color.WHITE);
        
        jlTitulo = new JLabel(new ImageIcon("src/iconos/convocatoria.jpg"));
        
        jlIdentificacion = new JLabel(new ImageIcon("src/iconos/user-login.png"));
        jtfIdentificacion = new JTextField();
        
        jbIngresarIdentificacion = new JButton(new ImageIcon("src/iconos/search_user.png"));
        
        jlEncontrado = new JLabel();
        jlInfoBusqueda = new JLabel();
        
        jbCancelar = new JButton(new ImageIcon("src/iconos/back.png"));
        
        jlNuevoPassword = new JLabel(new ImageIcon("src/iconos/password.png"));
        jlConfirmarNuevoPassword = new JLabel(new ImageIcon("src/iconos/password.png"));
        jtfPassword = new JPasswordField();
        jtfConfirmarPassword = new JPasswordField();
        
        jbEnviarNuevoPassword = new JButton(new ImageIcon("src/iconos/send.png"));
        
        driverEvents = new ManejadorEventos();
        
        
    }
    
    
    private void adicionarComponentes () {
        
        getContentPane().add(panel);
        
        panel.add(jlTitulo);
        
        panel.add(jlIdentificacion);
        panel.add(jtfIdentificacion);
        
        panel.add(jbIngresarIdentificacion);
        
        panel.add(jlEncontrado);
        panel.add(jlInfoBusqueda);
        
        panel.add(jlNuevoPassword);
        panel.add(jlConfirmarNuevoPassword);
        panel.add(jtfPassword);
        panel.add(jtfConfirmarPassword);
        
        panel.add(jbCancelar);
        panel.add(jbEnviarNuevoPassword);
        
    }
    
    
    private void acomodarComponentes () {
        
        jlTitulo.setBounds(0, 0, 500, 80);
        
        jlIdentificacion.setBounds(80, 150, 30, 30);
        jtfIdentificacion.setBounds(120, 150, 300, 30);
        
        jbIngresarIdentificacion.setBounds(120, 190, 15, 15);
        
        jbCancelar.setBounds(325, 300, 40, 40);
        jbEnviarNuevoPassword.setBounds(380, 300, 40, 40);
        jbEnviarNuevoPassword.setEnabled(false);
                
    }
    
    
    private void adicionarCaracteristicas () {
        
        jtfIdentificacion.setToolTipText("Ingrese su identificación");
        
        jbIngresarIdentificacion.setBorder(null);
        jbIngresarIdentificacion.setToolTipText("Buscar");
        jbIngresarIdentificacion.setBackground(Color.WHITE);
        
        jbCancelar.setBorder(null);
        jbCancelar.setBackground(Color.WHITE);
        jbEnviarNuevoPassword.setBorder(null);
        jbEnviarNuevoPassword.setBackground(Color.WHITE);
        
    }
    
    
    private void agregarEventos () {
        
        jbIngresarIdentificacion.addMouseListener(driverEvents);
        jbCancelar.addMouseListener(driverEvents);
        
    }
    
    
    private void mostrarCampos () {
        
        jlNuevoPassword.setBounds(80, 210, 30, 30);
        jtfPassword.setBounds(120, 210, 300, 30);
        jlConfirmarNuevoPassword.setBounds(80, 250, 30, 30);
        jtfConfirmarPassword.setBounds(120, 250, 300, 30);
        
        jbEnviarNuevoPassword.setEnabled(true);
        jbEnviarNuevoPassword.addMouseListener(driverEvents);
        
    }
    
    
    public void cambiarContraseña () {
        
        String pass1 = new String (jtfPassword.getPassword());
        String pass2 = new String (jtfConfirmarPassword.getPassword());
        
        try {
            
            validador.validatePass(pass1, pass2);
        
            driver.cambiarContraseña(jtfIdentificacion.getText(), pass2);
            
            JOptionPane.showMessageDialog(this, "La contraseña se ha actualizado correctamente", "Operación exitosa", JOptionPane.INFORMATION_MESSAGE);
            
            VentanaLogin ven = new VentanaLogin();
            ven.addEvents();
            
            dispose();
            
        } catch (MyException ex) {
            
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Contraseñas no coinciden", JOptionPane.ERROR_MESSAGE);
            
            jtfPassword.setText("");
            jtfConfirmarPassword.setText("");
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(this, "Error al actualizar la contraseña", "Error de acceso", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    
    public void restablecerContraseña () {
        
        try {
            
            String id = jtfIdentificacion.getText();
            
            validador.validateEmptyField(id);
            
            try {
                
                validador.validateInteger(id);
                
                if (driver.consultarUsuario(id) == true) {
                    
                    jlEncontrado.setIcon(new ImageIcon("src/iconos/accept-icon.png"));
                    jlEncontrado.setBounds(140, 190, 15, 15);
                    
                    jlInfoBusqueda.setText("Usuario encontrado");
                    jlInfoBusqueda.setForeground(new Color(45, 139, 14));
                    jlInfoBusqueda.setFont(new Font("Arial", 0, 10));
                    jlInfoBusqueda.setBounds(160, 190, 170, 15);
                    
                    jtfIdentificacion.setEnabled(false);
                    jbIngresarIdentificacion.removeMouseListener(driverEvents);
                    jbIngresarIdentificacion.setEnabled(false);
                    
                    mostrarCampos();
                
                }
                
                else {
                    
                    jlEncontrado.setIcon(new ImageIcon("src/iconos/cancel.png"));
                    jlEncontrado.setBounds(140, 190, 15, 15);

                    jlInfoBusqueda.setText("Usuario no encontrado");
                    jlInfoBusqueda.setForeground(Color.red);
                    jlInfoBusqueda.setFont(new Font("Arial", 0, 10));
                    jlInfoBusqueda.setBounds(160, 190, 170, 15);
                
                }
                
            } catch (NumberFormatException ex) {
                
                JOptionPane.showMessageDialog(this, "No ha ingresado un número", "Error", JOptionPane.ERROR_MESSAGE);
                
            } catch (SQLException ex) {
                
                JOptionPane.showMessageDialog(this, "Error consultando la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            }        

        } catch (MyException ex) {
            
            JOptionPane.showMessageDialog(this, "No ha ingresado su identificación", "Campos vacíos", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    
    private class ManejadorEventos implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {
            
            if (me.getSource() == jbIngresarIdentificacion) {
                
                restablecerContraseña();
                
            } else if (me.getSource() == jbCancelar) {
                
                VentanaLogin nuevo = new VentanaLogin();
                nuevo.addEvents();
                
                dispose();
                
            } else if (me.getSource() == jbEnviarNuevoPassword) {
                
                cambiarContraseña();
                
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
            
            if (me.getSource() == jbIngresarIdentificacion) {
                
                jbIngresarIdentificacion.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
            } else if (me.getSource() == jbCancelar) {
                
                jbCancelar.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
            } else if (me.getSource() == jbEnviarNuevoPassword) {
                
                jbEnviarNuevoPassword.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
            }
        }

        @Override
        public void mouseExited(MouseEvent me) {
            
        }
        
        
    }
    
    
}
