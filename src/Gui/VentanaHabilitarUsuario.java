/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/*
 * Se hace la conexión con esta ventana así:
 * 
 * 1) hace el llamado a la ventana cuando el usuario da clic en administración de usuarios
 * 2) llama al método conexionAdministrador
 * 3) llama al método consultarUsuarios
 * 4) la ventana de administrador queda invisible
 */
package Gui;

import controlador.DriverUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author jorgeaer
 */
public class VentanaHabilitarUsuario extends JFrame {
    
    private JPanel panel;
    private JPanel panelActivar;
    private JPanel panelDesactivar;
    private JPanel panelCerrar;
    
    private JComboBox <String> usuariosActivos;
    private JComboBox <String> usuariosInactivos;
    
    private JButton jbActivar;
    private JButton jbDesactivar;
    private JButton jbCerrar;
    
    private DriverUsuario controlaUsuario;
    
    private ControladorEventos controlador;
    
    private VentanaAdministrador adm;
    
    
    public VentanaHabilitarUsuario () {
        
        super("Módulo Administración Usuarios");
        
        inicializarComponentes();
        agregarComponentes();
        acomodarComponentes();
        asignarEventos();
        
        setSize(500, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(0);
        
    }
    
    
    private void inicializarComponentes () {
        
        panel = new JPanel(null);
        panelActivar = new JPanel(null);
        panelDesactivar = new JPanel(null);
        panelCerrar = new JPanel(null);
        
        usuariosActivos = new JComboBox<>();
        usuariosInactivos = new JComboBox<>();
        
        jbCerrar = new JButton("Cerrar");
        jbActivar = new JButton("Activar");
        jbDesactivar = new JButton("Desactivar");
        
        controlaUsuario = new DriverUsuario();
        controlador = new ControladorEventos();
        
    }
    
    
    private void agregarComponentes () {
        
        getContentPane().add(panel);
        
        panel.add(panelActivar);
        panel.add(panelDesactivar);
        
        panelActivar.setBorder(BorderFactory.createTitledBorder("Módulo de activación"));
        panelDesactivar.setBorder(BorderFactory.createTitledBorder("Módulo de desactivación"));
        
        panelActivar.add(usuariosInactivos);
        panelActivar.add(jbActivar);
        
        panelDesactivar.add(usuariosActivos);
        panelDesactivar.add(jbDesactivar);
        
        panel.add(panelCerrar);
        
        panelCerrar.add(jbCerrar);
        
    }
    
    
    private void acomodarComponentes () {
        
        panelActivar.setBounds(0, 100, 250, 150);
        panelDesactivar.setBounds(250, 100, 250, 150);
        panelCerrar.setBounds(0, 250, 500, 150);
        
        usuariosActivos.setBounds(30, 30, 180, 30);
        usuariosInactivos.setBounds(30, 30, 180, 30);
        
        jbActivar.setBounds(100, 80, 110, 30);
        jbDesactivar.setBounds(100, 80, 110, 30);
        
        jbCerrar.setBounds(310, 30, 150, 30);
        
    }
    
    
    private void asignarEventos () {
        
        jbCerrar.addActionListener(controlador);
        jbActivar.addActionListener(controlador);
        jbDesactivar.addActionListener(controlador);
        
    }
    
    
    public void consultarUsuarios () {
        
        usuariosActivos.removeAllItems();
        usuariosInactivos.removeAllItems();
        
        try {
            
            ArrayList <String> activos = controlaUsuario.consultarUsuarios(true);
            ArrayList <String> inactivos = controlaUsuario.consultarUsuarios(false);
            
            for (String activar : activos) {
                
                usuariosActivos.addItem(activar);
                
            }
            
            for (String desac : inactivos) {
                
                usuariosInactivos.addItem(desac);
                
            }
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Consulta falló", JOptionPane.ERROR_MESSAGE);
            
        }
        
    }
    
    
    public void activar_desactivarUsuario (boolean nuevoEstado) {
        
        String id;
        
        try {        
        
            if (nuevoEstado == true) id = usuariosInactivos.getSelectedItem().toString();
            else id = usuariosActivos.getSelectedItem().toString();
            
            controlaUsuario.habilitarUsuario(nuevoEstado, id);
            
            JOptionPane.showMessageDialog(this, "Se ha cambiado el estado exitosamente", "Actualización exitosa", JOptionPane.ERROR_MESSAGE);
            
            consultarUsuarios();
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de activación", JOptionPane.ERROR_MESSAGE);
            
        } catch (NullPointerException ex) {
            
            JOptionPane.showMessageDialog(this, "No hay usuarios disponibles para cambiar de estado", "Error de actualización", 
                    JOptionPane.ERROR_MESSAGE);
            
        }
        
    }
    
    public void conexionAdministrador (VentanaAdministrador admin) {
        
        adm = admin;
        
    }
    
    
    private class ControladorEventos implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if (e.getSource() == jbCerrar) {
                
                adm.setVisible(true);
                dispose();
                
            } else if (e.getSource() == jbActivar) {
                
                activar_desactivarUsuario(true);
                
            } else if (e.getSource() == jbDesactivar) {
                
                activar_desactivarUsuario(false);
                
            }
            
        }
        
        
    }
    
    
    public static void main (String [] args) {
        
        VentanaHabilitarUsuario hab = new VentanaHabilitarUsuario();
        hab.consultarUsuarios();
        
    }
    
}
