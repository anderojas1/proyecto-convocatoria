package Gui;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
import controlador.DriverUsuario;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class VentanaPrincipalDigitador extends JFrame{

    
    private JLabel titulo;
    private JLabel icono;
    private JButton ingresar;
    private JButton editar;
    private JButton consultar;
    private JButton cerrar;
    private ManejaEvento driverEventos; 
    private String user;
    private VentanaRegDatoPersona registroPersonal;
    private Container cont;
    private JPanel inicioDigitador;
    private DriverUsuario control;
    
    public  VentanaPrincipalDigitador(String username){
        
        super("Bienvenido @ "+ username);
        //user = username;
        cont = getContentPane(); 
        inicioDigitador = new JPanel();        
        titulo = new JLabel("Sistema de Seleccion de Docentes TIC");
        ingresar = new JButton("Ingresar Aspirante");
        editar = new JButton("Editar Aspirante");
        consultar = new JButton("Consultar Aspirante");
        
        cerrar = new JButton("Cerrar Sesion",new ImageIcon("src/iconos/block.png"));  
        cerrar.setBackground(Color.WHITE);
        cerrar.setBorder(null);
        
        icono = new JLabel(new ImageIcon("src/iconos/graduado.jpg"));
        
        driverEventos = new ManejaEvento(); 
        control = new DriverUsuario();
       
        
        setLocationRelativeTo(null);
        Dimension di = new Dimension(550, 350);
        setSize(550,350);
        setResizable(false);
        setLocationRelativeTo(null);
        setMaximumSize(di);    
        setDefaultCloseOperation(0);
        
        initComponents();
        AcommodateComponents();
        ListenerEvent();
        
        cont.add(inicioDigitador);
        setVisible(true);
       
   }
    
    public void initComponents(){
        
        inicioDigitador.setBackground(Color.white);
        inicioDigitador.setLayout(null);    
        inicioDigitador.add (titulo);
        inicioDigitador.add (ingresar);
        inicioDigitador.add (editar);
        inicioDigitador.add (consultar);
        inicioDigitador.add (cerrar);    
        inicioDigitador.add (icono);
        
        
    }

     private void AcommodateComponents() {
         
        titulo.setBounds(new Rectangle(55, 0, 440, 80));
        titulo.setFont(new Font("Verdana", 0, 22));
        
        ingresar.setBounds(new Rectangle(85, 100, 200, 30));
        editar.setBounds(new Rectangle(85,150 ,200 ,30 ));
        consultar.setBounds(new Rectangle(85,200 ,200 ,30 ));
        
        cerrar.setBounds(new Rectangle(320,260 ,190 ,30 ));
        
        icono.setBounds(340, 75, 150, 200);
     }
     
     public void ListenerEvent(){
        cerrar.addActionListener(driverEventos);
        ingresar.addActionListener(driverEventos); 
        editar.addActionListener(driverEventos);
        consultar.addActionListener(driverEventos);
     }
     
     public void ingresarAspirante(){
         VentanaRegDatoPersona registrar = new VentanaRegDatoPersona(0);
         registrar.asignarEventos();
         registrar.configurarVentana(this);
         setVisible(false);
     }
 
    
    private class ManejaEvento implements ActionListener{
        
     

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(ae.getSource() == cerrar){
                VentanaLogin nuevoLogin = new VentanaLogin();
                nuevoLogin.addEvents();
                try {
                    control.estadoSesion(user, false);
                } catch (SQLException ex) {
                    System.out.println("error al cerrar la sesion");
                }
                dispose();
            }else if(ae.getSource() == ingresar){
                
                ingresarAspirante();
                
            }else if (ae.getSource() == editar){
                
                JOptionPane.showMessageDialog(rootPane, "En construccion");
            
            }else if(ae.getSource() == consultar){
                
                   JOptionPane.showMessageDialog(rootPane, "En construccion");          
            
            }
        }
         
     }
    
    
    
}
