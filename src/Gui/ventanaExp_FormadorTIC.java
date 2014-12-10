/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;
import controlador.*;
import logica.*;

import java.awt.BorderLayout;
import java.awt.Color;
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
    
    private JFileChooser chooserSoporte;
    
    private DriverExperienciaFormadorTIC driveExpFormador;
    
   //paneles
    JPanel JPventana, JPopciones,JPbotnes, JPruta;
    
    //etiquetas
    
    JLabel JLtitulo, JLformerTICestuciantes, JLformerTICprof;
    JLabel JLformerFormers, JLEncabezado, JLFinal;
    
    //JComboBox
    
    JComboBox JCBformerEstudents, JCBformerProf, JCBformerFormers;
    String [] optionsFEstudents = {"Sin Experiencia", "De 1 a 5 años", "De 2 a 3 años", "De 3 a 5 años", "Más de 5 años"};
    String [] optionsFprof = {"Sin Experiencia","De 80 a 200 horas","De 200 a 300 horas", "De 300 a 450 horas", "Más de 450 horas"};
    String [] optionsFFormers= {"Sin Experiencia","De 80 a 120 horas","Más de 120 horas"};
    String [] datos_convocatoria;
    //botones
    JButton JBcancel, JBsave, JBExaest, JBExapro, JBExafor, JBFinalizar;
    JTextField campoRuta1, campoRuta2, campoRuta3;
    private int tipo; 
    private VentanaPrincipalDigitador ventana_digitador;

    public ventanaExp_FormadorTIC(int tipo, String identificacion_aspirante, String[] datos_convocatoria) {
        super("Experiencia como Formador en TIC");
        
        id_aspirante = identificacion_aspirante;
        this.tipo = tipo;
        this.datos_convocatoria = datos_convocatoria;
        
        container = getContentPane();
        
        
        pack();
        setSize(900,650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(0);
        setResizable(false);
        
        
        
        initComponents();
        addComponents();
        acommodateComponents();
        
        
        
        container.add(JPventana);
        setVisible(true);
        
    }

       public ventanaExp_FormadorTIC(int tipo, String identificacion_aspirante, String[] datos_convocatoria, VentanaPrincipalDigitador ventana_digitador) {
        super("Experiencia como Formador en TIC");
        
        id_aspirante = identificacion_aspirante;
        this.tipo = tipo;
        this.datos_convocatoria = datos_convocatoria;
        this.ventana_digitador = ventana_digitador;
        
        
        
        container = getContentPane();
        
       pack();
        setSize(900,650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(0);
        setResizable(false);
        
        
        
        initComponents();
        addComponents();
        acommodateComponents();
        
        
        
        container.add(JPventana);
        setVisible(true);
    }
       
    private void initComponents() {
        //ActionListener
        eventmanager = new EventManager();
        //Seleccionadro de archivo
        chooserSoporte = new JFileChooser();
        
        //objeto de DriverExperienciaFormadorTIC
        driveExpFormador = new DriverExperienciaFormadorTIC();
        
        //panel
        JPventana = new JPanel();
        
        
        //label
        
        JLtitulo = new JLabel("Experiencia como formador en TIC - "+datos_convocatoria[1]);
        JLformerFormers = new JLabel("Formador TIC de formadores");
        JLEncabezado = new JLabel(new ImageIcon ("src/iconos/encabezado.png"));
        JLFinal = new JLabel(new ImageIcon ("src/iconos/piePagina.png"));
        JLformerTICestuciantes = new JLabel("Formador TIC a estudiantes");
        JLformerTICprof = new JLabel("Formador TIC a profesores");
        
        //comobo box
        
        JCBformerEstudents = new JComboBox(optionsFEstudents);
        JCBformerProf = new JComboBox(optionsFprof);
        JCBformerFormers = new JComboBox(optionsFFormers);
        
        //Texto 
        campoRuta1 = new JTextField("");
        campoRuta1.setEditable(false);
        campoRuta2 = new JTextField("");
        campoRuta2.setEditable(false);
        campoRuta3 = new JTextField("");
        campoRuta3.setEditable(false);
        
        
        //botones
        
        switch(tipo){
            case 0:
                JBExaest = new JButton("Subir Archivo");
        
        
                JBExapro = new JButton("Subir Archivo");
        
        
                JBExafor = new JButton("Subir Archivo");
        
               
                JBcancel = new JButton("Cancelar");
        
        
                JBsave = new JButton("Guardar");
        
                JBFinalizar = new JButton("Omitir");
                break;
            
            case 1:
                JBExaest = new JButton("Editar Archivo");
        
        
                JBExapro = new JButton("Editar Archivo");
        
        
                JBExafor = new JButton("Editar Archivo");
        
               
                JBcancel = new JButton("Cancelar");
        
        
                JBsave = new JButton("Guardar");
                
                break;
        }
        
        
    }
    
    public void addComponents(){
        
        JPventana.add(JLtitulo);
        JPventana.add(JLEncabezado);
        JPventana.add(JLFinal);
        
        switch(tipo){
            case 0:
                
                
        JPventana.add(JLformerTICestuciantes);
        JPventana.add(JCBformerEstudents);
        
        JPventana.add(campoRuta1);
        JPventana.add(JBExaest);
                
        JPventana.add(JLformerTICprof);
        JPventana.add(JCBformerProf);
        
        JPventana.add(campoRuta2);
        JPventana.add(JBExapro);
        
        JPventana.add(JLformerFormers);
        JPventana.add(JCBformerFormers);
        
        JPventana.add(campoRuta3);
        JPventana.add(JBExafor);
        
               
        
        JPventana.add(JBFinalizar);
        JPventana.add(JBsave);
                    
                
                break;
            
            case 1:
                
        JPventana.add(JLformerTICestuciantes);
        JPventana.add(JCBformerEstudents);
        
        JPventana.add(campoRuta1);
        JPventana.add(JBExaest);
                
        JPventana.add(JLformerTICprof);
        JPventana.add(JCBformerProf);
        
        JPventana.add(campoRuta2);
        JPventana.add(JBExapro);
        
        JPventana.add(JLformerFormers);
        JPventana.add(JCBformerFormers);
        
        JPventana.add(campoRuta3);
        JPventana.add(JBExafor);
        
        JPventana.add(JBcancel);
        JPventana.add(JBsave);
                
                break;
        }
        
        JPventana.setLayout(null);
        JPventana.setBackground(Color.WHITE);
        
    }

    private void acommodateComponents() {
        
        JLtitulo.setBounds(150, 110, 600, 50);
        JLtitulo.setHorizontalAlignment (SwingConstants.CENTER);
        JLtitulo.setFont (new java.awt.Font("Georgia", 3, 18));
        
    JLEncabezado.setBounds(0,0,900,80);
    JLFinal.setBounds(0, 570, 900, 80);
        
               JLformerTICestuciantes.setBounds(200, 200, 200, 40);
               JCBformerEstudents.setBounds(470, 200, 250, 40);
               campoRuta1.setBounds(200, 245, 240, 30);
               JBExaest.setBounds(495, 245, 200, 30);
        
               JLformerTICprof.setBounds(200, 285, 200, 40);
               JCBformerProf.setBounds(470, 285, 250, 40);
               campoRuta2.setBounds(200, 330, 240, 30);
               JBExapro.setBounds(495, 330, 200, 30);
               
               JLformerFormers.setBounds(200, 370, 200, 40);
               JCBformerFormers.setBounds(470, 370, 250, 40);
               campoRuta3.setBounds(200, 415, 240, 30);
               JBExafor.setBounds(495, 415, 200, 30);
               
              
               
               
               JLformerTICestuciantes.setVisible(true);
               JCBformerEstudents.setVisible(true);
               campoRuta1.setVisible(true);
               JBExaest.setVisible(true);
               
               JLformerTICprof.setVisible(true);
               JCBformerProf.setVisible(true);
               campoRuta2.setVisible(true);
               JBExapro.setVisible(true);
    
               JLformerFormers.setVisible(true);
               JCBformerFormers.setVisible(true);
               campoRuta3.setVisible(true);
               JBExafor.setVisible(true);
               
               
                
                
            
    
        switch(tipo){
            case 0:
               
                JBFinalizar.setBounds(420, 495, 150, 40);
                JBsave.setBounds(620, 495, 150, 40);
                    
                
                JBFinalizar.setVisible(true);
                JBsave.setVisible(true); 
                
                break;
                
            case 1:
                
                JBcancel.setBounds(420, 495, 150, 40);
                JBsave.setBounds(620, 495, 150, 40);
                    
                
                JBcancel.setVisible(true);
                JBsave.setVisible(true); 
                
                break;
        }
        
        
        
        
        
        
    }
    
    
    
    public void agregarEventos(){
        if(tipo == 0){
            JBExaest.addActionListener(eventmanager);
        JBExapro.addActionListener(eventmanager);
        JBExafor.addActionListener(eventmanager);
        JBsave.addActionListener(eventmanager);
        JBFinalizar.addActionListener(eventmanager);
        }else{
        JBExaest.addActionListener(eventmanager);
        JBExapro.addActionListener(eventmanager);
        JBExafor.addActionListener(eventmanager);
        JBcancel.addActionListener(eventmanager);
        JBsave.addActionListener(eventmanager);
        }
    }
    
    
    public void configurarVentana (VentanaOpcionesModulo opcionesMod) {//ventana anterior
        
        ventana_opcionesM = opcionesMod;
        
    }
    
    public void ingresarDatoPersona(){//Ventana siguiente
         JOptionPane.showMessageDialog(this, "Ha finalizado la inscripción del aspirante Felicitaciones!!!");
         ventana_digitador.setVisible(true);
         dispose();
     }
    
    public String guardar(){
        String mensaje="";
        String titulo1, titulo2, titulo3, ruta1, ruta2, ruta3;
        String link_soporte;
        int puntos_est, puntos_pro, puntos_for, puntaje;
        switch(tipo){
            case 0:
                if(JCBformerEstudents.getSelectedIndex() == 0){
            puntos_est = JCBformerEstudents.getSelectedIndex();
            titulo1 = optionsFEstudents[JCBformerEstudents.getSelectedIndex()];
            ruta1 = campoRuta1.getText();
            
            
        }else{
           if(campoRuta1.getText().equals("") && (JCBformerEstudents.getSelectedIndex() != 0)){
            mensaje = "Debe Seleccionar un archivo de soporte para Formador TIC a estudiantes";
            return mensaje;
        }        
        else{
            puntos_est = JCBformerEstudents.getSelectedIndex()+1;
            titulo1 = optionsFEstudents[JCBformerEstudents.getSelectedIndex()];
            ruta1 = campoRuta1.getText();
            link_soporte = driveExpFormador.consultarSoporte(id_aspirante, titulo1, "soporte_estudiante", "exp_estudiante", datos_convocatoria[0]);
            
            if(link_soporte.equals(ruta1)){
                mensaje = "Debe Seleccionar un archivo de soporte diferente para Formador TIC a estudiantes";
                return mensaje;
            }
           }
        }
        
        if(JCBformerProf.getSelectedIndex() == 0){
            puntos_pro = JCBformerProf.getSelectedIndex();
            titulo2 = optionsFprof[JCBformerProf.getSelectedIndex()];
            ruta2 = campoRuta2.getText();
            
            
        }else{
           if(campoRuta2.getText().equals("") && (JCBformerProf.getSelectedIndex() != 0)){
            mensaje = "Debe Seleccionar un archivo de soporte para Formador TIC a profesores";
            return mensaje;
        }        
        else{
               if(JCBformerProf.getSelectedIndex() == 1){
                   puntos_pro = 5;
               }else{
                   if(JCBformerProf.getSelectedIndex() == 2){
                       puntos_pro = 10;
                   }else{
                       if(JCBformerProf.getSelectedIndex() == 3){
                           puntos_pro = 15;
                       }else{
                           puntos_pro = 20;
                       }
                   }
               }
            
            titulo2 = optionsFprof[JCBformerProf.getSelectedIndex()];
            ruta2 = campoRuta2.getText();
            link_soporte = driveExpFormador.consultarSoporte(id_aspirante, titulo2, "soporte_profesor", "exp_profesor",datos_convocatoria[0]);
            
            if(link_soporte.equals(ruta2)){
                mensaje = "Debe Seleccionar un archivo de soporte diferente para Formador TIC a profesores";
                return mensaje;
            }
           }
        }
        
        if(JCBformerFormers.getSelectedIndex() == 0){
            puntos_for = JCBformerFormers.getSelectedIndex();
            titulo3 = optionsFFormers[JCBformerFormers.getSelectedIndex()];
            ruta3 = campoRuta3.getText();
            
            
        }else{
           if(campoRuta3.getText().equals("") && (JCBformerFormers.getSelectedIndex() != 0)){
            mensaje = "Debe Seleccionar un archivo de soporte para Formador TIC de formadores";
            return mensaje;
        }        
        else{
            if (JCBformerFormers.getSelectedIndex() == 1){
            puntos_for = JCBformerFormers.getSelectedIndex()+2;
            }
            else{
                puntos_for = JCBformerFormers.getSelectedIndex()+3;
            }
            titulo3 = optionsFFormers[JCBformerFormers.getSelectedIndex()];
            ruta3 = campoRuta3.getText();
            link_soporte = driveExpFormador.consultarSoporte(id_aspirante, titulo3, "soporte_formador", "exp_formador", datos_convocatoria[0]);
            
            if(link_soporte.equals(ruta3)){
                mensaje = "Debe Seleccionar un archivo de soporte diferente para Formador TIC de formadores";
                return mensaje;
            }
           }
        }
             
            puntaje = puntos_est + puntos_pro + puntos_for;
            driveExpFormador.guardarExperiencia(id_aspirante, titulo1, titulo2, titulo3,ruta1, ruta2, ruta3, puntos_est, puntos_pro, puntos_for, puntaje, datos_convocatoria[0]);
            driveExpFormador.asignarPuntajeAspirante(id_aspirante, datos_convocatoria[0], puntaje);
                
                
                break;
            case 1:
                
                if(JCBformerEstudents.getSelectedIndex() == 0){
            puntos_est = JCBformerEstudents.getSelectedIndex();
            titulo1 = optionsFEstudents[JCBformerEstudents.getSelectedIndex()];
            ruta1 = campoRuta1.getText();
            
            
        }else{
           if(campoRuta1.getText().equals("") && (JCBformerEstudents.getSelectedIndex() != 0)){
            mensaje = "Debe Seleccionar un archivo de soporte para Formador TIC a estudiantes";
            return mensaje;
        }        
        else{
            puntos_est = JCBformerEstudents.getSelectedIndex()+1;
            titulo1 = optionsFEstudents[JCBformerEstudents.getSelectedIndex()];
            ruta1 = campoRuta1.getText();
            link_soporte = driveExpFormador.consultarSoporte(id_aspirante, titulo1, "soporte_estudiante", "exp_estudiante", datos_convocatoria[0]);
            
            if(link_soporte.equals(ruta1)){
                mensaje = "Debe Seleccionar un archivo de soporte diferente para Formador TIC a estudiantes";
                return mensaje;
            }
           }
        }
        
        if(JCBformerProf.getSelectedIndex() == 0){
            puntos_pro = JCBformerProf.getSelectedIndex();
            titulo2 = optionsFprof[JCBformerProf.getSelectedIndex()];
            ruta2 = campoRuta2.getText();
            
            
        }else{
           if(campoRuta2.getText().equals("") && (JCBformerProf.getSelectedIndex() != 0)){
            mensaje = "Debe Seleccionar un archivo de soporte para Formador TIC a profesores";
            return mensaje;
        }        
        else{
               if(JCBformerProf.getSelectedIndex() == 1){
                   puntos_pro = 5;
               }else{
                   if(JCBformerProf.getSelectedIndex() == 2){
                       puntos_pro = 10;
                   }else{
                       if(JCBformerProf.getSelectedIndex() == 3){
                           puntos_pro = 15;
                       }else{
                           puntos_pro = 20;
                       }
                   }
               }
            
            titulo2 = optionsFprof[JCBformerProf.getSelectedIndex()];
            ruta2 = campoRuta2.getText();
            link_soporte = driveExpFormador.consultarSoporte(id_aspirante, titulo2, "soporte_profesor", "exp_profesor",datos_convocatoria[0]);
            
            if(link_soporte.equals(ruta2)){
                mensaje = "Debe Seleccionar un archivo de soporte diferente para Formador TIC a profesores";
                return mensaje;
            }
           }
        }
        
        if(JCBformerFormers.getSelectedIndex() == 0){
            puntos_for = JCBformerFormers.getSelectedIndex();
            titulo3 = optionsFFormers[JCBformerFormers.getSelectedIndex()];
            ruta3 = campoRuta3.getText();
            
            
        }else{
           if(campoRuta3.getText().equals("") && (JCBformerFormers.getSelectedIndex() != 0)){
            mensaje = "Debe Seleccionar un archivo de soporte para Formador TIC de formadores";
            return mensaje;
        }        
        else{
            if (JCBformerFormers.getSelectedIndex() == 1){
            puntos_for = JCBformerFormers.getSelectedIndex()+2;
            }
            else{
                puntos_for = JCBformerFormers.getSelectedIndex()+3;
            }
            titulo3 = optionsFFormers[JCBformerFormers.getSelectedIndex()];
            ruta3 = campoRuta3.getText();
            link_soporte = driveExpFormador.consultarSoporte(id_aspirante, titulo3, "soporte_formador", "exp_formador", datos_convocatoria[0]);
            
            if(link_soporte.equals(ruta3)){
                mensaje = "Debe Seleccionar un archivo de soporte diferente para Formador TIC de formadores";
                return mensaje;
            }
           }
        }
        
        puntaje = puntos_est + puntos_pro + puntos_for;
        driveExpFormador.asignarPuntajeAspirante(id_aspirante, datos_convocatoria[0], puntaje);
        driveExpFormador.editarExperiencia(id_aspirante, titulo1, titulo2, titulo3,ruta1, ruta2, ruta3, puntos_est, puntos_pro, puntos_for, puntaje, datos_convocatoria[0]);
        
                
                break;
                
        }
        
                          
             System.out.println(JCBformerEstudents.getSelectedIndex());
            
        
        return mensaje;
    }
    
    
    
    
    public String seleccionador() {

        chooserSoporte = new JFileChooser();

        int returnVal = chooserSoporte.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {

            return chooserSoporte.getSelectedFile().getAbsolutePath();

        } else {

            return null;

        }

    }
    
    
     
   
    
    public class EventManager implements ActionListener  {

        public void actionPerformed(ActionEvent e) {
            
            if(e.getSource()== JBExaest){
                String ruta = seleccionador();
               System.out.println(ruta);
               campoRuta1.setText(ruta);
            }
            
            if(e.getSource()== JBExapro){
                String ruta = seleccionador();
               System.out.println(ruta);
               campoRuta2.setText(ruta);
            }
            
            if(e.getSource()== JBExafor){
                String ruta = seleccionador();
               System.out.println(ruta);
               campoRuta3.setText(ruta);
            }
            
            
            
            if(e.getSource() == JBcancel){
                
                ventana_opcionesM.setVisible(true);
                dispose();
                
                System.out.println("hola soy cancelar");
            }
            
            if(e.getSource() == JBsave){
                
                if(tipo == 0){
                       if(guardar().equals("")){
                    JOptionPane.showMessageDialog(null, "Se ha guardado con Exito");
                        ingresarDatoPersona();
                        }else{
                    JOptionPane.showMessageDialog(null, guardar());
                }
                    }else{
                         if(guardar().equals("")){
                    JOptionPane.showMessageDialog(null, "Se ha guardado con Exito");
                        ventana_opcionesM.setVisible(true);
                    dispose();
                        }else{
                    JOptionPane.showMessageDialog(null, guardar());
                }
                    
                
                }   
                    
                    
                    
                
                
            }
            
           if(e.getSource() == JBFinalizar){
               ingresarDatoPersona();
           } 
            
        }
    }
    
     public static void main(String args[]){

   // ventanaExp_FormadorTIC ven =  new ventanaExp_FormadorTIC(1234,"george");

}  
    
    
    
    
    
    
}
