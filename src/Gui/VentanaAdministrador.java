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
import javax.swing.border.LineBorder;
import logica.Usuario;

/**
 *
 * @author jhonkrave
 */
public class VentanaAdministrador extends JFrame {

    private JButton JBAbrirConv;
    private JButton JBCerrarSesion;
    private JButton JBCreateUser;
    private JButton JBModifConv;
    private JLabel JLTitulo;
    private JLabel JLadduser;
    private JLabel JLcrearConv;
    private JLabel JLediatrconv;
    private JLabel JLbienvenido;
    private JLabel JLbienvenido2;
 
    private JPanel JPpanelPrincipal;
    private EventManager eventmanager;
    private Container container;
    
    private String user;
    private DriverUsuario control;

    // End of variables declaration
    public VentanaAdministrador(String usuario) {
        
        user = usuario;
        initComponents();
        AcommodateComponents();
        
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
        
        
        Usuario u =  control.selectUser(user);
        
        JLbienvenido2 = new JLabel("Bienvenid@ ");
        JLbienvenido = new JLabel(u.getNombreUno().toUpperCase()+" "+u.getApellidoUno().toUpperCase()+".");
        JLbienvenido.setFont(new java.awt.Font ( "Arial" , Font.BOLD, 20 ) );
        
        
      
        JPpanelPrincipal = new JPanel();

        //etiqueta
        JLTitulo = new JLabel(new ImageIcon("src/iconos/encabezado.png"));
        JLadduser = new JLabel(new ImageIcon("src/iconos/user+.jpg"));
        JLediatrconv =  new JLabel(new ImageIcon("src/iconos/editar.jpg"));
        JLcrearConv = new JLabel(new ImageIcon("src/iconos/crear_convocatoria.jpg"));
        
       

        //botones
        JBAbrirConv = new JButton("Abrir Convocatoria");
        JBAbrirConv.addActionListener(eventmanager);

        JBCerrarSesion = new JButton(new ImageIcon("src/iconos/sign_out.png"));
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
        
        
        JPpanelPrincipal.add(JLbienvenido2);
        JLbienvenido2.setBounds(10, 120, 140, 50);
        
        JPpanelPrincipal.add(JLbienvenido);
        JLbienvenido.setBounds(100, 120, 400, 50);
        
        //cerrar sesion
        
       JPpanelPrincipal.add(JBCerrarSesion);
       JBCerrarSesion.setBounds(652, 100, 40, 40);
        

        //panel botones

        
       

        JPpanelPrincipal.add(JLadduser);
        JLadduser.setBounds(50, 200, 180, 100);
        JPpanelPrincipal.add(JBCreateUser);
        JBCreateUser.setBounds(50, 310, 180, 50);
        
        JPpanelPrincipal.add(JLcrearConv);
        JLcrearConv.setBounds(250, 200, 180, 100);
        JPpanelPrincipal.add(JBAbrirConv);
        JBAbrirConv.setBounds(250, 310, 180, 50);
        
        
        JPpanelPrincipal.add(JLediatrconv);
        JLediatrconv.setBounds(450, 200, 180, 100);
        JPpanelPrincipal.add(JBModifConv);
        JBModifConv.setBounds(450, 310, 180, 50);
        
       

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

        VentanaAdministrador vad = new VentanaAdministrador("kellys");

     }
 
    

 
    
    
}
