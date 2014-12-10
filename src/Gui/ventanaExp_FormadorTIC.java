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
    
    private JFileChooser chooserSoporte;
    
    private DriverExperienciaFormadorTIC driveExpFormador;
    
   //paneles
    JPanel JPititulo, JPopciones,JPbotnes, JPruta;
    
    //etiquetas
    
    JLabel JLtitulo, JLformerTICestuciantes, JLformerTICprof;
    JLabel JLformerFormers;
    
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
        initComponents();
        acommodateComponents();
        
        pack();
        setSize(500,350);
        setDefaultCloseOperation(0);
        setResizable(true);
        setVisible(true);
    }

       public ventanaExp_FormadorTIC(int tipo, String identificacion_aspirante, String[] datos_convocatoria, VentanaPrincipalDigitador ventana_digitador) {
        super("Experiencia como Formador en TIC");
        
        id_aspirante = identificacion_aspirante;
        this.tipo = tipo;
        this.datos_convocatoria = datos_convocatoria;
        this.ventana_digitador = ventana_digitador;
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
        //Seleccionadro de archivo
        chooserSoporte = new JFileChooser();
        
        //objeto de DriverExperienciaFormadorTIC
        driveExpFormador = new DriverExperienciaFormadorTIC();
        
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
        campoRuta1.setEditable(false);
        campoRuta2 = new JTextField("");
        campoRuta2.setEditable(false);
        campoRuta3 = new JTextField("");
        campoRuta3.setEditable(false);
        
        
        //botones
        
        JBExaest = new JButton("Subir Archivo");
        
        
        JBExapro = new JButton("Subir Archivo");
        
        
        JBExafor = new JButton("Subir Archivo");
        
               
        JBcancel = new JButton("Cancelar");
        
        
        JBsave = new JButton("Guardar");
        
        JBFinalizar = new JButton("Omitir");
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
        JPbotnes.add(JBFinalizar);
        
        container.add(JPbotnes, BorderLayout.SOUTH);
        
        
        
        
    }
    
    
    
    public void agregarEventos(){
        JBExaest.addActionListener(eventmanager);
        JBExapro.addActionListener(eventmanager);
        JBExafor.addActionListener(eventmanager);
        JBcancel.addActionListener(eventmanager);
        JBsave.addActionListener(eventmanager);
        JBFinalizar.addActionListener(eventmanager);
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
        int puntos_est, puntos_pro, puntos_for;
        
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
             
            int puntaje = puntos_est + puntos_pro + puntos_for;
            driveExpFormador.guardarExperiencia(id_aspirante, titulo1, titulo2, titulo3,ruta1, ruta2, ruta3, puntos_est, puntos_pro, puntos_for, puntaje, datos_convocatoria[0]);
            driveExpFormador.asignarPuntajeAspirante(id_aspirante, datos_convocatoria[0], puntaje);
                          
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
            }
            
            if(e.getSource() == JBsave){
                
                if(guardar().equals("")){
                    JOptionPane.showMessageDialog(null, "Se ha guardado con Exito");
                    
                    if(tipo == 0){
                        ingresarDatoPersona();
                    }else{
                    ventana_opcionesM.setVisible(true);
                    dispose();}
                    
                }else{
                    JOptionPane.showMessageDialog(null, guardar());
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
