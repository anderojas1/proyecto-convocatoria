/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.sun.java.swing.*;
import controlador.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
/**
 *
 * @author kegisan
 */
public class VentanaListadoInscritos extends JFrame{
    
  private JTable tabla;
  private JScrollPane panelScroll;
  private String titColumna[];
  private String datoColumna[][];
  private JComboBox convocatoria;
  private JLabel JLtitulo, JLconvo, JLaspirantes;
  private JButton JBbuscar, JBretroceder;
  private DriverConvocatoria contConvocatoria;
  private JPanel JPtitulo, JPconvo, JPtabla, JPretro;
  private Container container;
  private EventManager eventmanager;
  private DriverSupervisor driversuper;
  private int num;
  private ArrayList<Object> aspirantes;
  private String usuario;
  
  
    public VentanaListadoInscritos(String user){
    
        super("Listado Inscritos");
    usuario = user;
    
    inicializar();
    ajustar();
    // Creamos las columnas y las cargamos con los datos que van a
    // aparecer en la pantalla
   

    // Cambiamos el color de la zona seleccionada (rojo/blanco)
    //tabla.setSelectionForeground( Color.white );
    //tabla.setSelectionBackground( Color.red );
    // Incorporamos la tabla a un panel que incorpora ya una barra
    // de desplazamiento, para que la visibilidad de la tabla sea
    // automática
    
        pack();
        setSize(500,350);
        setDefaultCloseOperation(0);
        setResizable(true);
        setVisible(true);
    
  }
    
    
    
    public void inicializar(){
        
        contConvocatoria = new DriverConvocatoria();
        eventmanager = new EventManager();
        driversuper = new DriverSupervisor();
        
        aspirantes = new ArrayList<>();
        
        JPtitulo = new JPanel();
        JPconvo = new JPanel();
        JPtabla = new JPanel();
        JPretro = new JPanel();
        
        
        // Creamos una instancia del componente Swing

        
    panelScroll = new JScrollPane( tabla );
    
    num = 0;
    
    JLtitulo = new JLabel("Listado Inscritos Por Convocatoria");
    JLaspirantes = new JLabel("La Canidad de aspirantes es: "+ num);
    JLconvo = new JLabel("Elija la convocatoria");
    convocatoria = new JComboBox();
        ArrayList<String> nombreC = new ArrayList();
        nombreC=contConvocatoria.listaConvocatorias();
        int tam=nombreC.size();
        for(int i = 0; i < tam; i++){
            convocatoria.addItem(nombreC.get(i));
        }
      
        
     JBbuscar = new JButton("Buscar");
     JBretroceder = new JButton("Retroceder");
        
    }

    public void ajustar(){
        container = getContentPane();
        container.setLayout(new BorderLayout());
        
        JPtitulo.setLayout(new BorderLayout());
        JLtitulo.setHorizontalAlignment(SwingConstants.CENTER);
        JPtitulo.add(JLtitulo, BorderLayout.NORTH);
        JLabel etiqueta = new JLabel("    ");
        etiqueta.setBounds(0, 0, 100, 100);
        JPtitulo.add(etiqueta, BorderLayout.CENTER);
        
        JPconvo.setLayout(new GridLayout(3, 2, 0, 20));
        
        JPconvo.add(JLconvo);
        JPconvo.add(etiqueta);
        
        JPconvo.add(convocatoria);
        JPconvo.add(JBbuscar);
        
        JPconvo.add(JLaspirantes);
        
        JPtitulo.add(JPconvo, BorderLayout.SOUTH);
        
        container.add(JPtitulo, BorderLayout.NORTH);
        
             
        
        
        JPtabla.setLayout(new BorderLayout());
        JPtabla.add(panelScroll, BorderLayout.CENTER);
        container.add(JPtabla, BorderLayout.CENTER);
        
        JPretro.setLayout(new BorderLayout());
        JPretro.add(JBretroceder, BorderLayout.EAST);
        container.add(JPretro, BorderLayout.SOUTH);
    
    
    
        
    }
    
     public void agregarEventos(){
        JBbuscar.addActionListener(eventmanager);
        JBretroceder.addActionListener(eventmanager);
    }
    
    
     // Creamos las etiquetas que sirven de título a cada una de
  // las columnas de la tabla
  public void CreaColumnas() {
    titColumna = new String[4];
    
    
      titColumna[0] = "Identificacion";
      titColumna[1] = "Nombres";
      titColumna[2] = "Apellidos";
      titColumna[3] = "Municipio_trabajo";
    
  }
  
  // Creamos los datos para cada uno de los elementos de la tabla
  public void CargaDatos() {
    datoColumna = new String[num][4];
    
    for( int iY=0; iY < num; iY++ ) {
        String [] aspirante;
       aspirante = (String []) aspirantes.get(iY);
      for( int iX=0; iX < 4; iX++ ) {
	datoColumna[iY][iX] = aspirante[iX];
      
      }
    }
    
    
    
  }
  
  public void tabla(){
       tabla = new JTable( datoColumna,titColumna );
    // Aquí se configuran algunos de los parámetros que permite 
    // variar la JTable
    tabla.setShowHorizontalLines( true );
    tabla.setRowSelectionAllowed( true );
    tabla.setColumnSelectionAllowed( true );
  }
 

     public class EventManager implements ActionListener  {

        
        public void actionPerformed(ActionEvent e) {
            
           if(e.getSource()== JBbuscar){
               System.out.println("Hola soy boton buscar");
               
               String convocatoriagua = convocatoria.getSelectedItem()+"";
                String partes[] = convocatoriagua.split(",");
                String codconv = partes[0];
                aspirantes = driversuper.getListaAspirantes(codconv);
                num = aspirantes.size();
                
                System.out.println("este es la cantida de aspirantes: "+num);
                
                CreaColumnas();
                CargaDatos();
                tabla();
                
            }
           
           if(e.getSource()== JBretroceder){
               System.out.println("Hola soy boton regresar");
               
               VentanaIniSupervisor vensuper = new VentanaIniSupervisor(usuario);
               dispose();
                
            }
        }
    }
   
     
}