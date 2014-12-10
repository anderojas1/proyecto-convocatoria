/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import controlador.DriverUsuario;
import java.io.File;
import java.sql.SQLException;


/**
 *
 * @author anderojas
 */
public class VentanaLogin extends JFrame {
    
    private final JLabel lbtitulo;
    private final JLabel lbusername;
    private final JLabel lbpassword;
    private final JLabel lbolvidar;
    
    private final JTextField jtfusername;
    private final JPasswordField jpfpassword;
    
    private final JButton jbiniciar;
    
    private final JPanel panel;
    
    private final ManejaEventos driverEventos;
    
    private final DriverUsuario controladorUsuario;
    
    private final ViewValidator validador;
    
    
    public VentanaLogin () {
        
        validador = new ViewValidator();
        
        controladorUsuario = new DriverUsuario();
        
        lbtitulo = new JLabel(new ImageIcon("src/iconos/convocatoria.jpg"));
        lbusername = new JLabel(new ImageIcon("src/iconos/user-login.png"));
        lbpassword = new JLabel(new ImageIcon("src/iconos/password.png"));
        lbolvidar = new JLabel("¿Olvidó sus datos de acceso?");
        
        jpfpassword = new JPasswordField();
        
        jtfusername = new JTextField();
        
        jbiniciar = new JButton(new ImageIcon("src/iconos/iniciar-sesion.jpg"));
        jbiniciar.setBorder(null);
        
        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        getContentPane().add(panel);
        
        driverEventos = new ManejaEventos();
        
        agregarComponentes();
        acomodarComponentes();
        addFeatures(); 
        
        setSize(500, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        
        setTitle("Sistema Convocatoria Docente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true); 
        
        
    }
    
    
    private void addFeatures () {
        
        jbiniciar.setToolTipText("Clic para iniciar sesión");
        jpfpassword.setToolTipText("Ingrese su contraseña de acceso");
        jtfusername.setToolTipText("Ingrese su usuario de acceso");
        
        lbolvidar.setFont(new Font("Arial", 0, 10));
        lbolvidar.setToolTipText("Clic si olvidó sus datos de acceso");
        
    }
    
    
    private void agregarComponentes () {
        
        panel.add(lbtitulo);
        panel.add(lbusername);
        panel.add(lbpassword);
        panel.add(jtfusername);
        panel.add(jpfpassword);
        panel.add(jbiniciar);
        panel.add(lbolvidar);
        panel.setLayout(null);
        
    }
    
    
    private void acomodarComponentes () {
        
        lbtitulo.setBounds(0, 0, 500, 80);
        lbusername.setBounds(80, 150, 30, 30);
        jtfusername.setBounds(120, 150, 300, 30);
        lbpassword.setBounds(80, 190, 30, 30);
        jpfpassword.setBounds(120, 190, 300, 30);
        
        lbolvidar.setBounds(120, 230, 140, 10);
        
        jbiniciar.setBounds(110, 270, 100, 53);
        
    }
    
    public void addEvents () {
        
        jbiniciar.addMouseListener(driverEventos);
        lbolvidar.addMouseListener(driverEventos);
        
        jpfpassword.addKeyListener(driverEventos);
        jtfusername.addKeyListener(driverEventos);
        
    }
    
    
    public void identificarTipoUsuario () {
        
        String user = jtfusername.getText();
        String pass = jpfpassword.getText();
        
        try {
        
            String tipo = controladorUsuario.tipoUsuario(user, pass);
            
            if (!tipo.equals("")) {
            
                if (controladorUsuario.verificarSesion(user) == false) {

                controladorUsuario.estadoSesion(user, true);
                
                    switch (tipo) {

                        case "Administrador": {

                            VentanaAdministrador admin = new VentanaAdministrador(user);
                            this.dispose();

                        }
                        break;

                        case "Supervisor": {

                            VentanaIniSupervisor sprv = new VentanaIniSupervisor(user);
                            this.dispose();

                        }
                        break;

                        case "Digitador": {

                            VentanaPrincipalDigitador dig = new VentanaPrincipalDigitador(user);
                            this.dispose();

                        }
                        break;

                    }

                } else {

                    JOptionPane.showMessageDialog(this, "El usuario " + user + " ya ha iniciado sesión", "Múltiple inicio de sesión",
                            JOptionPane.ERROR_MESSAGE);

                }
                
            } else {
                
                JOptionPane.showMessageDialog(this, "Usuario o contraseña inválidos", "Inicio de sesión fallido",
                            JOptionPane.ERROR_MESSAGE);
                
            }
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            jpfpassword.setText("");
            jtfusername.setText("");
        }
        
    }
    
    
    public void verificarUsuarioAdmin () {
        
        try {
            
            if (controladorUsuario.consultarUsuarioAdmin() == false) {

                JOptionPane.showMessageDialog(null, "Advertencia: No existe administrador de la aplicación", "Advertencia", JOptionPane.WARNING_MESSAGE);

                VentanaRegUsuario registrarAdmin = new VentanaRegUsuario(false);
                registrarAdmin.asignarEventos();
                
                dispose();
                
            }
            
        } catch (SQLException | NullPointerException ex) {
            
            JOptionPane.showMessageDialog(this, "No se pudo conectar a la base de datos", "Error fatal", JOptionPane.ERROR_MESSAGE);
            dispose();
            
        }
        
    }
    
    
    public void iniciarSesion () {
        
        String [] campos = new String[2];
        
        campos[0] = jtfusername.getText();
        campos[1] = jpfpassword.getText();
        
        try {
            
            validador.validateEmptyFields(campos);
                
            identificarTipoUsuario ();
                
        } catch (MyException ex) {
                
            JOptionPane.showMessageDialog(this, "Debe ingresar sus datos de acceso", "Error", JOptionPane.ERROR_MESSAGE);
            
        }
        
    }
    
    
    public void recuperarPassword () {
        
        VentanaRestorePassword restaurar = new VentanaRestorePassword();
        
        dispose();
        
    }
    
    
    private class ManejaEventos implements MouseListener, KeyListener {
        
        
        @Override
        public void mouseClicked (MouseEvent me) {
            
            if (me.getSource() == jbiniciar) {
            
                iniciarSesion();
                
            }
            
            else if (me.getSource() == lbolvidar) {
                
                recuperarPassword();
                
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
            
            if (me.getSource() == lbolvidar) {
                
                lbolvidar.setCursor(new Cursor(Cursor.HAND_CURSOR));
                lbolvidar.setSize(170, 10);
                lbolvidar.setFont(new Font("Arial", 1, 10));
                
            }
            
            if (me.getSource() == jbiniciar) {
                
                jbiniciar.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
            }
            
        }

        @Override
        public void mouseExited(MouseEvent me) {
            
            if (me.getSource() == lbolvidar) {
                
                lbolvidar.setFont(new Font("Arial", 0, 10));
                lbolvidar.setSize(140, 10);
                
            }
            
        }        

        @Override
        public void keyTyped(KeyEvent ke) {
            
            
        }

        @Override
        public void keyPressed(KeyEvent ke) {
            
            if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                
                iniciarSesion();
                
            }
            
        }

        @Override
        public void keyReleased(KeyEvent ke) {
            
            
        }
        
    }
    
}
