/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;
import controlador.*;
import logica.*;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author jhonkrave
 */
public class ventanaExp_FormadorTIC extends JFrame {
    
    private Container container;
    private EventManager eventmanager;
    private VentanaOpcionesModulo ventana_opcionesM;
    private String id_aspirante;
   //paneles
    JPanel JPititulo, JPopciones,JPbotnes, JPruta;
    
    //etiquetas
    
    JLabel JLtitulo, JLformerTICestuciantes, JLformerTICprof;
    JLabel JLformerFormers;
    
    //JComboBox
    
    JComboBox JCBformerEstudents, JCBformerProf, JCBformerFormers;
    String [] optionsFEstudents = {"De 1 a 5 años", "De 2 a 3 años", "De 3 a 5 años", "Más de 5 años", "Sin Experiencia"};
    String [] optionsFprof = {"De 80 a 200 horas","De 200 a 300 horas", "De 300 a 450 horas", "Más de 450 horas", "Sin Experiencia"};
    String [] optionsFFormers= {"De 80 a 120 horas","Más de 120 horas", "Sin Experiencia"};
    
    //botones
    JButton JBcancel, JBsave, JBExaest, JBExapro, JBExafor;
    JTextField campoRuta1, campoRuta2, campoRuta3;

    public ventanaExp_FormadorTIC(int tipo, String identificacion_aspirante) {
        super("Experiencia como Formador en TIC");
        
        id_aspirante = identificacion_aspirante;
        
        initComponents();
        acommodateComponents();
        
        pack();
        setSize(500,350);
        setDefaultCloseOperation(0);
        setResizable(true);
        setVisible(true);
    }

    private void initComponents() {
        //ActionListener
        eventmanager = new EventManager();
        
        //paneles
        JPititulo = new JPanel();
        JPopciones = new JPanel();
        JPbotnes = new JPanel();
        JPruta = new JPanel();
        
        //label
        JLformerFormers = new JLabel("Formador TIC de formadores");
        JLtitulo = new JLabel("Experiencia como formador en TIC");
        JLformerTICestuciantes = new JLabel("Formador TIC a estudiantes");
        JLformerTICprof = new JLabel("Formador TIC a profesores");
        
        //comobo box
        
        JCBformerEstudents = new JComboBox(optionsFEstudents);
        JCBformerProf = new JComboBox(optionsFprof);
        JCBformerFormers = new JComboBox(optionsFFormers);
        
        //Texto 
        campoRuta1 = new JTextField("");
        campoRuta2 = new JTextField("");
        campoRuta3 = new JTextField("");
        
        
        //botones
        
        JBExaest = new JButton("Subir Archivo");
        
        
        JBExapro = new JButton("Subir Archivo");
        
        
        JBExafor = new JButton("Subir Archivo");
        
               
        JBcancel = new JButton("Cancelar");
        
        
        JBsave = new JButton("Guardar");
        
        
    }

    private void acommodateComponents() {
        
        container = getContentPane();
        container.setLayout(new BorderLayout());
        
        JPititulo.setLayout(new BorderLayout());
        JLtitulo.setHorizontalAlignment(SwingConstants.CENTER);
        JPititulo.add(JLtitulo, BorderLayout.CENTER);
        
        container.add(JPititulo, BorderLayout.NORTH);
        
        JLabel etiqueta = new JLabel();
        JLabel JLexperiencia = new JLabel("Experiencia");
        JPopciones.setLayout(new GridLayout(7, 2, 0, 5));
        
        JPopciones.add(etiqueta);
        JLexperiencia.setHorizontalAlignment(SwingConstants.CENTER);
        JPopciones.add(JLexperiencia);
        
        JPopciones.add(JLformerTICestuciantes);
        JPopciones.add(JCBformerEstudents);
        
        JPopciones.add(campoRuta1);
        JPopciones.add(JBExaest);
                
        JPopciones.add(JLformerTICprof);
        JPopciones.add(JCBformerProf);
        
        JPopciones.add(campoRuta2);
        JPopciones.add(JBExapro);
        
        JPopciones.add(JLformerFormers);
        JPopciones.add(JCBformerFormers);
        
        JPopciones.add(campoRuta3);
        JPopciones.add(JBExafor);
        
        container.add(JPopciones, BorderLayout.CENTER);
        
        
        
        
        
        JPbotnes.setLayout(new GridLayout(1, 3, 5, 1));
        
        JPbotnes.add(JBcancel);
        JPbotnes.add(JBsave);
        
        container.add(JPbotnes, BorderLayout.SOUTH);
        
        
        
        
    }
    
    
    
    public void agregarEventos(){
        JBExaest.addActionListener(eventmanager);
        JBExapro.addActionListener(eventmanager);
        JBExafor.addActionListener(eventmanager);
        JBcancel.addActionListener(eventmanager);
        JBsave.addActionListener(eventmanager);
    }
    
    
    public void configurarVentana (VentanaOpcionesModulo opcionesMod) {//ventana anterior
        
        ventana_opcionesM = opcionesMod;
        
    }
    
    
    
     
   
    
    public class EventManager implements ActionListener  {

        public void actionPerformed(ActionEvent e) {
            
            
            
            if(e.getSource() == JBcancel){
                ventana_opcionesM.setVisible(true);
                dispose();
             System.out.println("hola soy cancelar");
            }
            
            if(e.getSource() == JBsave){
             System.out.println("hola soy guardar");
            }
            
        }
    }
    
     public static void main(String args[]){

    ventanaExp_FormadorTIC ven =  new ventanaExp_FormadorTIC(1234,"george");

}  
    
    
    
    
    
    
}
