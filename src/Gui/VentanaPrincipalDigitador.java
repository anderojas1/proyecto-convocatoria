package Gui;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaPrincipalDigitador extends JFrame{

    
    private JLabel titulo;
    private JButton ingresar;
    private JButton editar;
    private JButton consultar;
    private JButton cerrar;
    private ManejaEvento driverEventos; 
    private String user;
    private VentanaRegDatoPersona registroPersonal;
    private Container cont;
    private JPanel inicioDigitador;
    
    public  VentanaPrincipalDigitador(String username){
        
        //user = username;
        cont = getContentPane(); 
        inicioDigitador = new JPanel();        
        titulo = new JLabel("Sistema de Seleccion de Docentes TIC");
        ingresar = new JButton("Ingresar Aspirante");
        editar = new JButton("Editar ASpirante");
        consultar = new JButton("Consultar Aspirante");
        cerrar = new JButton("Cerrar Sesion");  
        driverEventos = new ManejaEvento(); 
       
        
        Dimension di = new Dimension(800, 500);
        setSize(650,350);
        setMaximumSize(di);    
        setResizable(false);
        setDefaultCloseOperation(0);
        
        initComponents();
        AcommodateComponents();
        ListenerEvent();
        
        cont.add(inicioDigitador);
        setVisible(true);
       
   }
    
    public void initComponents(){
        
        
        inicioDigitador.setLayout(null);    
        inicioDigitador.add (titulo);
        inicioDigitador.add (ingresar);
        inicioDigitador.add (editar);
        inicioDigitador.add (consultar);
        inicioDigitador.add (cerrar);     
        
        
    }

     private void AcommodateComponents() {
         
        titulo.setBounds(new Rectangle(55, 0, 440, 80));
        titulo.setFont(new Font("Verdana", 0, 22));
        ingresar.setBounds(new Rectangle(20, 100, 150, 50));
        editar.setBounds(new Rectangle(200,100 ,150 ,50 ));
        consultar.setBounds(new Rectangle(380,100 ,150 ,50 ));
        cerrar.setBounds(new Rectangle(340,250 ,150 ,50 ));
     }
     
     public void ListenerEvent(){
         cerrar.addActionListener(driverEventos);
        ingresar.addActionListener(driverEventos); 
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
                dispose();
            }
            
            if(ae.getSource() == ingresar){
                ingresarAspirante();
                
            }
        }
         
     }
    
    
    
}
