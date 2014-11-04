/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.text.StyledEditorKit;

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
    private Imagen imagen;
    private JPanel JPpanelPrincipal;
    private EventManager eventmanager;
    private Container container;

    // End of variables declaration
    public VentanaAdministrador() {
        initComponents();
        AcommodateComponents();
        
        pack();
        
        setDefaultCloseOperation(0);
        setSize(600, 200);
        setResizable(true);
        setVisible(true); 
    }

    private void initComponents() {
        //incializar manejador de eventos
        eventmanager = new EventManager(this);

        //paneles

        JPTitulo = new JPanel();
        JPbotones = new JPanel();
        JPCerrarSesion = new JPanel();
        imagen = new Imagen();

        //etiqueta
        JLTitulo = new JLabel("Sistema de Selección de docentes TIC");
        
       

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

    private void AcommodateComponents() {
        container = this.getContentPane();

        container.setLayout(new GridLayout(3, 1, 5, 5));

        //titulo
        JPTitulo.setLayout(new BorderLayout());
        JLTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JPTitulo.add(JLTitulo, BorderLayout.CENTER);
        
        //JPTitulo.add(imagen,BorderLayout.EAST);
        container.add(JPTitulo);

        //panel botones

        JPbotones.setLayout(new GridLayout(1, 3, 5, 5));


        JPbotones.add(JBCreateUser);
        JPbotones.add(JBModifConv);
        JPbotones.add(JBAbrirConv);
        
        container.add(JPbotones);
        
        //cerrar sesion
        JPCerrarSesion.setLayout(new BorderLayout());
        JPCerrarSesion.add(JBCerrarSesion, BorderLayout.EAST);
       
        container.add(JPCerrarSesion);



    }
    
    
    public void crearUsuario () {
        
        VentanaRegUsuario registrar = new VentanaRegUsuario(true);
        registrar.asignarEventos();
        registrar.configurarVentana(this);
        
        setVisible(false);
        
    }
    
    
    public void crearConvocatoria () {
        
        
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

                JOptionPane.showMessageDialog(null, "Lo sentimos estamos en desarrollo", "Error", JOptionPane.ERROR_MESSAGE);
            }

            if (e.getSource() == JBCerrarSesion) {

                VentanaLogin nuevoLogin = new VentanaLogin();
                nuevoLogin.addEvents();
                
                dispose();

            }
        }
    }
    
    
   
    public class Imagen extends JPanel {

public Imagen() {
this.setSize(300, 400); //se selecciona el tamaño del panel
}

//Se crea un método cuyo parámetro debe ser un objeto Graphics

public void paint(Graphics grafico) {
Dimension height = getSize();

//Se selecciona la imagen que tenemos en el paquete de la //ruta del programa

ImageIcon Img = new ImageIcon(getClass().getResource("/Images/gear.jpg")); 

//se dibuja la imagen que tenemos en el paquete Images //dentro de un panel

grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);

setOpaque(false);
super.paintComponent(grafico);
}
}
    
    
 
    
    
}
