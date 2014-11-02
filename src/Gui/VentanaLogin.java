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
    
    
    public VentanaLogin () {
        
        controladorUsuario = new DriverUsuario();
        
        lbtitulo = new JLabel("Sistema de Convocatoria Docente");
        lbusername = new JLabel("Usuario");
        lbpassword = new JLabel("Contraseña");
        lbolvidar = new JLabel("¿Olvidó sus datos de acceso?");
        
        jpfpassword = new JPasswordField();
        
        jtfusername = new JTextField();
        
        jbiniciar = new JButton("Ingresar");
        
        panel = new JPanel();
        getContentPane().add(panel);
        
        driverEventos = new ManejaEventos();
        
        agregarComponentes();
        acomodarComponentes();
        addFeatures(); 
        
        setSize(500, 350);
        setResizable(false);
        setLocationRelativeTo(null);
        
        setTitle("Sistema Convocatoria Docente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true); 
        
        
    }
    
    
    private void addFeatures () {
        
        jbiniciar.setToolTipText("Clic para iniciar sesión");
        jpfpassword.setToolTipText("Ingrese su contraseña de acceso");
        jtfusername.setToolTipText("Ingrese usuario de acceso");
        
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
        
        lbtitulo.setBounds(100, 20, 300, 30);
        lbusername.setBounds(80, 100, 120, 30);
        jtfusername.setBounds(220, 100, 200, 30);
        lbpassword.setBounds(80, 150, 120, 30);
        jpfpassword.setBounds(220, 150, 200, 30);
        
        lbolvidar.setBounds(220, 190, 140, 10);
        
        jbiniciar.setBounds(300, 240, 120, 30);
        
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
        
        String tipo = controladorUsuario.tipoUsuario(user, pass);
        
        switch (tipo) {
            
            case "Administrador": {
                
                VentanaAdministrador admin = new VentanaAdministrador();
                this.dispose();
                
            }break;
                
            case "Supervisor": {
                            
                VentanaIniSupervisor sprv = new VentanaIniSupervisor();
                this.dispose();
                
            }break;
                
            case "Digitador": {
                
                VentanaPrincipalDigitador dig = new VentanaPrincipalDigitador();
                this.dispose();
                
            }break;
                
            default: {
                
                JOptionPane.showMessageDialog(null, "Usuario o contraseña inválidos", "Error", JOptionPane.ERROR_MESSAGE);
                jpfpassword.setText("");
                jtfusername.setText("");
                
            }
        }
        
    }
    
    
    public void verificarUsuarioAdmin () {
        
        if (controladorUsuario.consultarUsuarioAdmin() == false) {
            
            JOptionPane.showMessageDialog(null, "Advertencia: No existe administrador de la aplicación", "Advertencia", JOptionPane.WARNING_MESSAGE);
            
            VentanaRegUsuario registrarAdmin = new VentanaRegUsuario(false);
            registrarAdmin.asignarEventos();
            
            dispose();
        }
        
    }
    
    
    public boolean validarCampos () {
        
        boolean flag = false;
        
        if (!jpfpassword.getText().equals("") && !jtfusername.getText().equals("")) {
            
            flag = true;
            
        }
        
        return flag;
        
    }
    
    
    public void iniciarSesion () {
        
        if (validarCampos() == true) {
                
            identificarTipoUsuario ();
                
        }
        
        else JOptionPane.showMessageDialog(this, "Debe ingresar sus datos de acceso", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
        
    }
    
    
    private class ManejaEventos implements MouseListener, KeyListener {
        
        
        @Override
        public void mouseClicked (MouseEvent me) {
            
            if (me.getSource() == jbiniciar) {
            
                iniciarSesion();
                
            }
            
            else if (me.getSource() == lbolvidar) {
                
                System.out.println("olvidar\n");
                
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
                lbolvidar.setSize(200, 10);
                lbolvidar.setFont(new Font("Arial", 1, 10));
                
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
