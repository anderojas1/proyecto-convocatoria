/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import controlador.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author jhonkrave
 */
public class VentanaConociemientosEspec extends JFrame {
    
    //container
    private Container container;
    
    
    
    //paneles
    private JPanel JPtitulo;
    private JPanel JPconocimientos;
    private JPanel JPbotones;
    
    //etiquetas
    private JLabel JLtitulo;
    private JLabel JLsubtitulo;
    private JLabel JLsubtitulonivel;
    private JLabel JLherram_Ofimatic;
    private JLabel JLherram_Web2;
    private JLabel JLherram_edic_multi;
    private JLabel JLexp_des_cont_edu_dig;
    private JLabel JLexp_des_lib_dig;
    private JLabel JLexp_proc_elearning;
    private JLabel JLexp_gest_proy_TIC;
    private JLabel JLexp_des_elemnts_eval_comp;
    
    //combox
    
    /*
    private JComboBox JCBherram_Ofimatic;
    private JComboBox JCBherram_Web2;
    private JComboBox JCBherram_edic_multi;
    private JComboBox JCBexp_des_cont_edu_dig;
    private JComboBox JCBexp_des_lib_dig;
    private JComboBox JCBexp_proc_elearning;
    private JComboBox JCBexp_gest_proy_TIC;
    private JComboBox JCBexp_des_elemnts_eval_comp;
    */
    
    private JComboBox [] niveles;
  private String [] items = {"Regular","Bueno", "Muy Bueno"};
    
    //botnoes
    
    private JButton JBcanelar, JBback,JBnext;
    
    //otros
    
    private EventManager eventmanager;
    private DriverConocimientosEsp control;
    private VentanaOpcionesModulo ParentWindow;
    private String identificacionAspirante;
    
    
    
    
    
    public VentanaConociemientosEspec( int tipo, String idenficacion){
        
        super ("Conociminetos Específicos");
        this.identificacionAspirante = idenficacion;
        
        
        InitComponents();
        AcommodateCOmponents();
        
        pack();
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1100, 400);
        setResizable(true);
        setVisible(true);
        
    }
    
    public void configurarVentana(VentanaOpcionesModulo parentWindow){
    
        this.ParentWindow = parentWindow;
    
    }

    private void InitComponents() {
        
        //otros
        
        eventmanager = new EventManager(this);
        control = new DriverConocimientosEsp();
        
        //paneles
        JPtitulo = new JPanel();
        JPconocimientos = new JPanel();
        JPbotones = new JPanel();
        
        //etiquetas
        JLtitulo = new JLabel("Conocimientos Específicos");
        JLsubtitulo = new JLabel("Conocimiento");
        JLsubtitulonivel = new JLabel("Nivel");
        JLexp_des_cont_edu_dig = new JLabel("Experiencia en desarrollo de contenidos educativos digitales");
        JLexp_des_elemnts_eval_comp = new JLabel("Experiencia en desarrollo de elementos de evaluación de competencias");
        JLexp_des_lib_dig = new JLabel("Experiencia en desarrollo de libros de texto digital");
        JLexp_gest_proy_TIC = new JLabel("Experiencia en gestión de proyectos educativos TIC");
        JLexp_proc_elearning = new JLabel("Experiencia en procesos de e-­‐learning");
        JLherram_Ofimatic = new JLabel("Conocimiento y manejo de herramientas ofimáticas");
        JLherram_Web2 = new JLabel("Conocimiento y manejo de herramientas Web 2");
        JLherram_edic_multi = new JLabel("Conocimiento herramientas de edición multimedia");
        
        //combobox
        niveles = new JComboBox[8];
        
        for (int i = 0; i < niveles.length; i++) {
            niveles[i] = new JComboBox(items);
            
        }
        
        //botones
        
        JBback = new JButton("Atras");
        
        
        JBcanelar = new JButton("Cancelar");
        JBcanelar.addActionListener(eventmanager);
        
        JBnext = new JButton("Guardar");
        JBnext.addActionListener(eventmanager);
        
        
        
    }

    private void AcommodateCOmponents() {
        
        container = this.getContentPane();
        container.setLayout(new BorderLayout());
        
        
        //titulo
        
        JPtitulo.setLayout(new BorderLayout());
        JLtitulo.setHorizontalAlignment(SwingConstants.CENTER);
        JPtitulo.add(JLtitulo, BorderLayout.CENTER);
        
        container.add(JPtitulo, BorderLayout.NORTH);
        
        //conocimientos
        
        JPconocimientos.setLayout(new GridLayout(9, 2, 5, 5));
        
        JLsubtitulo.setHorizontalAlignment(SwingConstants.CENTER);
        JPconocimientos.add(JLsubtitulo);
        
//        JLsubtitulonivel.setHorizontalAlignment(SwingConstants.EAST);
        JPconocimientos.add(JLsubtitulonivel);
        
        JPconocimientos.add(JLherram_Ofimatic);
        JPconocimientos.add(niveles[0]);
        
        JPconocimientos.add(JLherram_Web2);
        JPconocimientos.add(niveles[1]);
        
        JPconocimientos.add(JLherram_edic_multi);
        JPconocimientos.add(niveles[2]);
        
        JPconocimientos.add(JLexp_des_cont_edu_dig);
        JPconocimientos.add(niveles[3]);
        
        JPconocimientos.add(JLexp_des_lib_dig);
        JPconocimientos.add(niveles[4]);
        
        JPconocimientos.add(JLexp_proc_elearning);
        JPconocimientos.add(niveles[5]);
        
        JPconocimientos.add(JLexp_gest_proy_TIC);
        JPconocimientos.add(niveles[6]);
        
        JPconocimientos.add(JLexp_des_elemnts_eval_comp);
        JPconocimientos.add(niveles[7]);
        
        container.add(JPconocimientos, BorderLayout.CENTER);
        
        //botnoes
        
        JPbotones.setLayout(new GridLayout(1, 2, 8, 8));
        
        JPbotones.add(JBcanelar);
        //JPbotones.add(JBback);
        JPbotones.add(JBnext);
        
        container.add(JPbotones, BorderLayout.SOUTH);
        container.setBackground(Color.white);
        
    }
    
    public class EventManager implements ActionListener {

        private Component parentComponent;
        
        public EventManager (Component parentComponent){
        
            this.parentComponent = parentComponent;
        
        }
        @Override
        public void actionPerformed(ActionEvent e) {
           
            
            
            
            if (e.getSource() == JBcanelar){
                
                dispose();
                ParentWindow.setVisible(true);
            }
            
            if (e.getSource() == JBnext){
                
                String [] resultados = new String[8];
                
                for (int i = 0; i < resultados.length; i++) {
                    
                    resultados[i] = (String) niveles[i].getSelectedItem() ;
                    
                }
                
                control.guaradarConociemientoEspecifico(identificacionAspirante, resultados[0], resultados[1], resultados[2], resultados[3], resultados[4], resultados[5], resultados[6], resultados[7], control.calcularPuntuacionTotal(resultados));
                
                dispose();
                ParentWindow.setVisible(true);
            }
            
            
        }
    
    
        
    }
    
    /*public static void main(String args[]){

    VentanaConociemientosEspec ven =  new VentanaConociemientosEspec();

}  */
   
}
