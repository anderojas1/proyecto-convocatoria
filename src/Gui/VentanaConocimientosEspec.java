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
import logica.conocimientosEspecificos;

/**
 *
 * @author jhonkrave
 */
public class VentanaConocimientosEspec extends JFrame {

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
    
    private JComboBox[] niveles;
    private String[] items = {"Nulo","Regular", "Bueno", "Muy Bueno"};
    //botnoes
    private JButton JBcanelar, JBback, JBnext, JBomitir;
    //otros
    private EventManager eventmanager;
    private DriverConocimientosEsp control;
    private VentanaOpcionesModulo ParentWindow;
    private String identificacionAspirante;
    private String [] datosConvocatoria;
    private JPanel JPprincipal;
    private final int tipo;
    
    private VentanaPrincipalDigitador ventana_digitador;

    public VentanaConocimientosEspec(int tipo, String idenficacion, String [] datosConvocatoria) {

        super("Conociminetos Específicos");
        this.tipo = tipo;
        this.identificacionAspirante = idenficacion;
        this.datosConvocatoria = datosConvocatoria;

        InitComponents();
        AcommodateCOmponents(tipo);

         setSize(new Dimension(900, 650));
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(0);

    }
    
     public VentanaConocimientosEspec(int tipo, String idenficacion, String [] datosConvocatoria, VentanaPrincipalDigitador ventana_digitador) {//agragar

        super("Conociminetos Específicos");
        this.tipo = tipo;
        this.identificacionAspirante = idenficacion;
        this.datosConvocatoria = datosConvocatoria;
        this.ventana_digitador = ventana_digitador;

        InitComponents();
        AcommodateCOmponents(tipo);

        setSize(new Dimension(900, 650));
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(0);

    }

    public void configurarVentana(VentanaOpcionesModulo parentWindow) {

        this.ParentWindow = parentWindow;

    }

    public final void InitComponents() {

        //otros

        eventmanager = new EventManager(this);
        control = new DriverConocimientosEsp();

        //paneles
        JPtitulo = new JPanel();
        JPconocimientos = new JPanel();
        JPbotones = new JPanel();
        JPprincipal = new JPanel();

        //etiquetas
        JLtitulo = new JLabel(new ImageIcon("src/iconos/encabezado.png"));
        JLsubtitulo = new JLabel("Conocimiento");
        JLsubtitulonivel = new JLabel("Nivel");
        JLexp_des_cont_edu_dig = new JLabel("Experiencia en desarrollo de contenidos educativos digitales");
        JLexp_des_elemnts_eval_comp = new JLabel("Experiencia en desarrollo de elementos de evaluación\n de competencias");
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

        if (control.consultarConocimientoEspecific(identificacionAspirante) != null) {

            conocimientosEspecificos ce = control.consultarConocimientoEspecific(identificacionAspirante);

            niveles[0].setSelectedItem(ce.getJLherram_Ofimatic());
            niveles[1].setSelectedItem(ce.getJLherram_Web2());
            niveles[2].setSelectedItem(ce.getJLherram_edic_multi());
            niveles[3].setSelectedItem(ce.getJLexp_des_cont_edu_dig());
            niveles[4].setSelectedItem(ce.getJLexp_des_lib_dig());
            niveles[5].setSelectedItem(ce.getJLexp_proc_elearning());
            niveles[6].setSelectedItem(ce.getJLexp_gest_proy_TIC());
            niveles[7].setSelectedItem(ce.getJLexp_des_elemnts_eval_comp());
        }

        //botones

        JBback = new JButton("Atras");


        JBcanelar = new JButton("Cancelar");
        

        JBnext = new JButton("Guardar");
        
        JBomitir = new JButton("Omitir");


    }
 

    public final void AcommodateCOmponents(int tipo) {

        
        JPprincipal.setLayout(null);


        //titulo

        
        JPprincipal.add(JLtitulo);
        JLtitulo.setBounds(0, 0, 900, 80);
        
       
        
        JLabel JLnombreC = new JLabel("CONVOCATORIA: "+datosConvocatoria[1]);
        JPprincipal.add(JLnombreC);
        JLnombreC.setBounds(0, 90, 100, 10);
        
        

        //conocimientos

        

        JLsubtitulo.setHorizontalAlignment(SwingConstants.CENTER);
        JPprincipal.add(JLsubtitulo);
        JLsubtitulo.setBounds(600, 110, 300, 30);

//        JLsubtitulonivel.setHorizontalAlignment(SwingConstants.EAST);
        JPprincipal.add(JLsubtitulonivel);
        JLsubtitulonivel.setBounds(450, 110, 300, 30);

        JPprincipal.add(JLherram_Ofimatic);
        JLherram_Ofimatic.setBounds(150, 150, 400, 30);
        JPprincipal.add(niveles[0]);
        niveles[0].setBounds(700, 150, 100, 30);
        

        JPprincipal.add(JLherram_Web2);
        JLherram_Web2.setBounds(150, 190, 500, 30);
        JPprincipal.add(niveles[1]);
        niveles[1].setBounds(700, 190, 100, 30);
        

        JPprincipal.add(JLherram_edic_multi);
        JLherram_edic_multi.setBounds(150, 230, 500, 30);
        JPprincipal.add(niveles[2]);
        niveles[2].setBounds(700, 230, 100, 30);

        JPprincipal.add(JLexp_des_cont_edu_dig);
        JLexp_des_cont_edu_dig.setBounds(150, 270, 500, 30);
        JPprincipal.add(niveles[3]);
        niveles[3].setBounds(700, 270, 100, 30);

        JPprincipal.add(JLexp_des_lib_dig);
        JLexp_des_lib_dig.setBounds(150, 310, 500, 30);
        JPprincipal.add(niveles[4]);
        niveles[4].setBounds(700, 310, 100, 30);

        JPprincipal.add(JLexp_proc_elearning);
        JLexp_proc_elearning.setBounds(150, 350, 500, 30);
        JPprincipal.add(niveles[5]);
        niveles[5].setBounds(700, 350, 100, 30);

        JPprincipal.add(JLexp_gest_proy_TIC);
        JLexp_gest_proy_TIC.setBounds(150, 390, 500, 30);
        JPprincipal.add(niveles[6]);
        niveles[6].setBounds(700, 390, 100, 30);

        JPprincipal.add(JLexp_des_elemnts_eval_comp);
        JLexp_des_elemnts_eval_comp.setBounds(150, 430, 550, 30);
        JPprincipal.add(niveles[7]);
        niveles[7].setBounds(700, 430, 100, 30);

       

        //botnoes


        validarTipo(tipo);

        JPprincipal.setBackground(Color.WHITE);
        
        getContentPane().add(JPprincipal);
        

    }
    
    public void agregarEventos(){
        JBnext.addActionListener(eventmanager);
        JBcanelar.addActionListener(eventmanager);
        JBomitir.addActionListener(eventmanager);
    }
    
      public void ingresarModulo4(){//Ventana siguiente
         VentanaRegistrarIdioma modulo4 = new VentanaRegistrarIdioma(tipo, identificacionAspirante, datosConvocatoria, ventana_digitador);
         modulo4.asignarEventos();
         dispose();
     }
      
      public void validarTipo (int tipo){
      
          switch (tipo){
          
              
              case 1: editar();
                      break;
                      
              case 2: consultar();
                      break;
              
              case 0: agregar();     
              
          
          }
      
      }
      
      public void consultar(){
      
          for (int i = 0; i < niveles.length; i++) {
              niveles[i].setEnabled(false);
              
          }
          
          
          JPprincipal.add(JBcanelar);
          JBcanelar.setBounds(395, 550, 110, 25);
          
          
      
      }

    private void editar() {
        
        JPprincipal.add(JBnext);
        JBnext.setBounds(455, 550, 110, 25);
        JPprincipal.add(JBcanelar);
        JBcanelar.setBounds(335, 550, 110, 25);
        
    }

    private void agregar() {
        JPprincipal.add(JBnext);
        JBnext.setBounds(455, 550, 110, 25);
        JPprincipal.add(JBomitir);
        JBomitir.setBounds(335, 550, 110, 25);
    }

    public class EventManager implements ActionListener {

        private Component parentComponent;

        public EventManager(Component parentComponent) {

            this.parentComponent = parentComponent;

        }

        @Override
        public void actionPerformed(ActionEvent e) {




            if (e.getSource() == JBcanelar) {

                dispose();
                ParentWindow.setVisible(true);
            }

            if (e.getSource() == JBnext) {


                String[] resultados = new String[8];

                for (int i = 0; i < resultados.length; i++) {

                    resultados[i] = (String) niveles[i].getSelectedItem();

                }

                if (control.consultarConocimientoEspecific(identificacionAspirante) == null) {
                    control.updatePuntuacionTotal(identificacionAspirante, datosConvocatoria[0],control.calcularPuntuacionTotal(resultados) , true);
                    control.guaradarConociemientoEspecifico(identificacionAspirante, resultados[0], resultados[1], resultados[2], resultados[3], resultados[4], resultados[5], resultados[6], resultados[7], control.calcularPuntuacionTotal(resultados));
                } else {
                    control.updatePuntuacionTotal(identificacionAspirante, datosConvocatoria[0],control.calcularPuntuacionTotal(resultados) , false);
                    control.updateConocimientoEspecific(identificacionAspirante, resultados[0], resultados[1], resultados[2], resultados[3], resultados[4], resultados[5], resultados[6], resultados[7], control.calcularPuntuacionTotal(resultados));
                    
                }
                dispose();
                
                if(tipo ==0){
                ingresarModulo4();
                }else{
                
                    ParentWindow.setVisible(true);
                    
                }
            }
            
            if(e.getSource() == JBomitir){
                ingresarModulo4();
            }


        }
    }
    public static void main(String args[]){

        String[] conv = {"julian", "miconvocatoria"};
     VentanaConocimientosEspec ven =  new VentanaConocimientosEspec(2, "3523", conv);

     }  
}
