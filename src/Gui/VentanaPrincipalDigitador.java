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
    final ManejaEvento driverEventos;
    
   public  VentanaPrincipalDigitador(){
       
       
        driverEventos = new ManejaEvento();
        this.setTitle("Ventana Principal Digitador");
        
        this.setLayout(null);
        this.setSize(560, 400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        //se crea el label y se adiciona en la ventana
        titulo = new JLabel("Sistema de Seleccion de Docentes TIC");
        titulo.setBounds(new Rectangle(55,0 , 440,80 ));
        titulo.setFont(new Font("Verdana", 0, 22));
        this.add (titulo);
        
        // Se crea el botón y se adiciona  en la ventana
        ingresar = new JButton("Ingresar Aspirante");
        ingresar.setBounds(new Rectangle(20,100 ,150 ,50 ));
        this.add (ingresar);
        
        editar = new JButton("Editar ASpirante");
        editar.setBounds(new Rectangle(200,100 ,150 ,50 ));
        this.add (editar);

        consultar = new JButton("Consultar Aspirante");
        consultar.setBounds(new Rectangle(380,100 ,150 ,50 ));
        this.add (consultar);

        cerrar = new JButton("Cerrar Sesion");
        cerrar.setBounds(new Rectangle(340,250 ,150 ,50 ));
        this.add (cerrar);
        
        cerrar.addActionListener(driverEventos);
        
       
        // Se le dice a la ventana que termine el programa cuando se la cierre
       
        
        // Se le da un tamaño automático a la ventana para que quepa todo su
        // contenido.
        
       
        // Se hace visible la ventana
        
       
   }

 
    
    private class ManejaEvento implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(ae.getSource() == cerrar){
                VentanaLogin nuevoLogin = new VentanaLogin();
                nuevoLogin.addEvents();
                dispose();
            }
        }
         
     }
    
    
    
}
