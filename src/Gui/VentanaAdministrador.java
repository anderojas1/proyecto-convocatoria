/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import controlador.DriverUsuario;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;

/**
 *
 * @author jhonkrave
 */
public class VentanaAdministrador extends JFrame {

    private JButton JBAbrirConv;
    private JButton JBCerrarSesion;
    private JButton JBCreateUser;
    private JButton JBModifConv;
    private JPanel JPTitulo;
    private JPanel JPbotones;
    private JPanel JPCerrarSesion;
    private JLabel JLTitulo;
    private JLabel JLadduser;
    private JLabel JLcrearConv;
    private JLabel JLediatrconv;
 
    private JPanel JPpanelPrincipal;
    private EventManager eventmanager;
    private Container container;
    
    private String user;
    private DriverUsuario control;

    // End of variables declaration
    public VentanaAdministrador(String usuario) {
        
        initComponents();
        AcommodateComponents();
        
        user = usuario;
        
        setSize(new Dimension(700, 500));
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(0);
    }

    private void initComponents() {
        //incializar controles
        eventmanager = new EventManager(this);
        control =  new DriverUsuario();

        //paneles

        JPTitulo = new JPanel();
        JPbotones = new JPanel();
        JPCerrarSesion = new JPanel();
        
        JPpanelPrincipal = new JPanel();

        //etiqueta
        JLTitulo = new JLabel(new ImageIcon("src/iconos/encabezado.png"));
        JLadduser = new JLabel(new ImageIcon("src/iconos/user+.jpg"));
        JLediatrconv =  new JLabel(new ImageIcon("src/iconos/editar.jpg"));
        JLcrearConv = new JLabel(new ImageIcon("src/iconos/crear_convocatoria.jpg"));
        
       

        //botones
        JBAbrirConv = new JButton("Abrir Convocatoria");
        JBAbrirConv.addActionListener(eventmanager);

        JBCerrarSesion = new JButton("Cerrar Sesion");
        JBCerrarSesion.addActionListener(eventmanager);

        JBCreateUser = new JButton("Crear Usuario");
        JBCreateUser.addActionListener(eventmanager);

        JBModifConv = new JButton("Modificar Convocatoria");
        JBModifConv.addActionListener(eventmanager);

    }
    
    
    public String getUsuario () {
        
        return user;
        
    }

    private void AcommodateComponents() {
        
        JPpanelPrincipal.setLayout(null);

        //titulo
        
        
        JPpanelPrincipal.add(JLTitulo);
        JLTitulo.setBounds(0, 0, 700, 80);
        
        
        

        //panel botones

        

        JPpanelPrincipal.add(JLadduser);
        JLadduser.setBounds(50, 100, 180, 100);
        JPpanelPrincipal.add(JBCreateUser);
        JBCreateUser.setBounds(50, 200, 180, 50);
        
        JPpanelPrincipal.add(JLcrearConv);
        JLcrearConv.setBounds(250, 100, 180, 100);
        JPpanelPrincipal.add(JBAbrirConv);
        JBAbrirConv.setBounds(250, 200, 180, 50);
        
        
        JPpanelPrincipal.add(JLediatrconv);
        JLediatrconv.setBounds(450, 100, 180, 100);
        JPpanelPrincipal.add(JBModifConv);
        JBModifConv.setBounds(450, 200, 180, 50);
        
        
        
        
        //cerrar sesion
        
       JPpanelPrincipal.add(JBCerrarSesion);
       JBCerrarSesion.setBounds(235, 400, 180, 50);
       
       

       JPpanelPrincipal.setBackground(Color.WHITE);
       getContentPane().add(JPpanelPrincipal);

    }
    
    
    public void crearUsuario () {
        
        VentanaRegUsuario registrar = new VentanaRegUsuario(true);
        registrar.asignarEventos();
        registrar.configurarVentana(this);
        
        setVisible(false);
        
    }
    
    
    public void crearConvocatoria () {
        
        VentanaCrearConvocatoria crear = new VentanaCrearConvocatoria();
        crear.agregarEventos();
        crear.setVentanaAdmin(this);
        
        setVisible(false);
        
    }
    
    public void modificarConvocatoria(){
    
        VentanaEditarConvocatoria modif =new VentanaEditarConvocatoria();
        modif.consultarConvocatoriasVigentes();
        modif.setVentanaAdmin(this);
        
    
    }
    
    
    public void habilitarUsuario (boolean estado, String usuario) {
        
        try {
            
            control.habilitarUsuario(estado, usuario);
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(this, "Error ejecutando actualización", "Error", JOptionPane.ERROR_MESSAGE);
            
        }
    }

    public class EventManager implements ActionListener {

        Component componentepadre;

        public EventManager(Component componentePadre) {

            this.componentepadre = componentePadre;

        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == JBAbrirConv) {

                crearConvocatoria();

            }

            if (e.getSource() == JBCreateUser) {                
                
                crearUsuario();
                
            }

            if (e.getSource() == JBModifConv) {

                modificarConvocatoria();
                componentepadre.setVisible(false);
            }

            if (e.getSource() == JBCerrarSesion) {

                
                VentanaLogin nuevoLogin = new VentanaLogin();
                nuevoLogin.addEvents();
                try {
                    control.estadoSesion(user, false);
                    dispose();
                } catch (SQLException ex) {
                    System.out.println("error al cerrar sesion");
                }
                
                

            }
        }
    }
    
    
   public static void main(String args[]){

        VentanaAdministrador vad = new VentanaAdministrador("1");

     }
 
    

 
    
    
}
