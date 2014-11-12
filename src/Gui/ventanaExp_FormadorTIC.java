/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
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
    
   //paneles
    JPanel JPititulo, JPopciones,JPbotnes;
    
    //etiquetas
    
    JLabel JLtitulo, JLformerTICestuciantes, JLformerTICprof;
    JLabel JLformerFormers;
    
    //JComboBox
    
    JComboBox JCBformerEstudents, JCBformerProf, JCBformerFormers;
    String [] optionsFEstudents = {"De 1 a 5 años", "De 2 a 3 años", "De 3 a 5 años", "Más de 5 años", "Sin Experiencia"};
    String [] optionsFprof = {"De 80 a 200 horas","De 200 a 300 horas", "De 300 a 450 horas", "Más de 450 horas", "Sin Experiencia"};
    String [] optionsFFormers= {"De 80 a 120 horas","Más de 120 horas", "Sin Experiencia"};
    
    //botones
    JButton JBcancel, JBback, JBsave;

    public ventanaExp_FormadorTIC() {
        super("Experiencia como Formador en TIC");
        initComponents();
        acommodateComponents();
        
        pack();
        setSize(500,300);
        setDefaultCloseOperation(0);
        setResizable(true);
        setVisible(true);
    }

    private void initComponents() {
        
        //paneles
        JPititulo = new JPanel();
        JPopciones = new JPanel();
        JPbotnes = new JPanel();
        
        //label
        JLformerFormers = new JLabel("Formador TIC de formadores");
        JLtitulo = new JLabel("Experiencia como formador en TIC");
        JLformerTICestuciantes = new JLabel("Formador TIC a estudiantes");
        JLformerTICprof = new JLabel("Formador TIC a profesores");
        
        //comobo box
        
        JCBformerEstudents = new JComboBox(optionsFEstudents);
        JCBformerProf = new JComboBox(optionsFprof);
        JCBformerFormers = new JComboBox(optionsFFormers);
        
        //botones
        
        JBback = new JButton("Atras");
        JBback.addActionListener(eventmanager);
        
        JBcancel = new JButton("Cancelar");
        JBcancel.addActionListener(eventmanager);
        
        JBsave = new JButton("Guardar");
        JBsave.addActionListener(eventmanager);
        
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
        JPopciones.setLayout(new GridLayout(4, 2, 8, 8));
        
        JPopciones.add(etiqueta);
        JLexperiencia.setHorizontalAlignment(SwingConstants.CENTER);
        JPopciones.add(JLexperiencia);
        
        JPopciones.add(JLformerTICestuciantes);
        JPopciones.add(JCBformerEstudents);
        
        JPopciones.add(JLformerTICprof);
        JPopciones.add(JCBformerProf);
        
        JPopciones.add(JLformerFormers);
        JPopciones.add(JCBformerFormers);
                
        container.add(JPopciones, BorderLayout.CENTER);
        
        
        JPbotnes.setLayout(new GridLayout(1, 3, 5, 1));
        
        JPbotnes.add(JBcancel);
        JPbotnes.add(JBback);
        JPbotnes.add(JBsave);
        
        container.add(JPbotnes, BorderLayout.SOUTH);
        
        
        
        
    }
   
    
    public class EventManager implements ActionListener  {

        Component parent;
        public EventManager(Component parentcomponet) {
            
            this.parent = parentcomponet;
        }
        
       

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(e.getSource() == JBback){
            }
            
            if(e.getSource() == JBcancel){
            
            }
            
            if(e.getSource() == JBsave){
            
            }
            
        }
    }
    
     public static void main(String args[]){

    ventanaExp_FormadorTIC ven =  new ventanaExp_FormadorTIC();

}  
    
    
    
    
    
    
}
