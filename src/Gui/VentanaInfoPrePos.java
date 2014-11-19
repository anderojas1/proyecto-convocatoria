package Gui;

import controlador.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class VentanaInfoPrePos extends JFrame {

    //declaracion de los atributos de la clase
    private JLabel lbTitulo;
    private JLabel lbSubTitulo;
    
    private JLabel lbLicenciado;
    private JLabel lbEspecia;
    private JLabel lbEspeciaTic;
    private JLabel lbMaestria;
    private JLabel lbMaestriaTic;
    private JLabel lbDoctor;
    private JLabel lbDoctorTic;
      
    private JCheckBox CBLicen;
    private JCheckBox CBEspecia;
    private JCheckBox CBEspeciaTic;
    private JCheckBox CBMaestria;
    private JCheckBox CBMaestriaTic;
    private JCheckBox CBDoctor;
    private JCheckBox CBDoctorTic;
    
    private JButton btDoctor;
    private JButton btDoctorTic;
    private JButton btEspec;
    private JButton btEspecTic;
    private JButton btLicen;
    private JButton btMaestria;
    private JButton btMaestriaTic;
    
    private String rtDoctor;
    private String rtDoctorTic;
    private String rtMaestria;
    private String rtMaestriaTic;
    private String rtEspecia;
    private String rtEspeciaTic;
    private String rtLicen;
    
    private String[] datos_convocatoria;
      
    private JButton btCancelar;
    private JButton btAceptar;

    //declaracion paneles
    private JPanel panelPrin;
    //declaracion objetos de control
    private ManejaEventos manejador;
    private ViewValidator validator;
    
    //identificacion del aspirante
    private String indentificacion;
    
    //chooser
    private JFileChooser fc;
    
    //ventana pciones modulo
    VentanaOpcionesModulo ventanaOpcModulo;
    
    //controlador
    driverInfoPrePos driverPrePos;
    
    
    //Constructor de la Clase 
    public VentanaInfoPrePos(int tipo, String iden, String [] datos_convocatoria) {

        super("Informacion Pregrado Posgrado");

        indentificacion = iden;
        
        this.datos_convocatoria = datos_convocatoria;
        
        iniciarComponentes( (String)datos_convocatoria[1]);
        agregarComponentes();
        acomodarComponentes();
        //asignarEventos();
        
        getContentPane().add(panelPrin);
        setSize(new Dimension(540, 450));
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(0);

    }

    public final void iniciarComponentes(String nomConv) {

        lbTitulo = new JLabel(new ImageIcon("src/iconos/convocatoria.jpg"));
        lbSubTitulo = new JLabel("CONVOCATORIA :    " + nomConv );

        lbDoctor = new JLabel("Doctorado");
        lbDoctorTic = new JLabel("Doctorado en areas afines TIC");
        lbEspecia = new JLabel("Especializacion");
        lbEspeciaTic = new JLabel("Especializacion en areas afines a TIC");
        lbLicenciado = new JLabel("Licenciado en educacion o areas afines");
        lbMaestria = new JLabel("Maestria");
        lbMaestriaTic = new JLabel("Maestria en areas a fines a TIC");
        
        CBDoctor = new JCheckBox();
        CBDoctorTic = new JCheckBox();
        CBEspecia = new JCheckBox();
        CBEspeciaTic = new JCheckBox();
        CBLicen = new JCheckBox();
        CBMaestria  = new JCheckBox();
        CBMaestriaTic = new JCheckBox();
        
                                
        btDoctor = new JButton("Examinar");
        btDoctorTic = new JButton("Examinar");
        btEspec = new JButton("Examinar");
        btEspecTic = new JButton("Examinar");
        btLicen = new JButton("Examinar");
        btMaestria = new JButton("Examinar");
        btMaestriaTic = new JButton("Examinar");
        
        rtDoctor = "N/A";
        rtDoctorTic = "N/A";
        rtMaestria = "N/A";
        rtMaestriaTic = "N/A";
        rtEspecia = "N/A";
        rtEspeciaTic = "N/A";
        rtLicen = "N/A";
        
        btDoctor.setEnabled(false);
        btDoctorTic.setEnabled(false);
        btMaestria.setEnabled(false);
        btMaestriaTic.setEnabled(false);
        btLicen.setEnabled(false);
        btEspec.setEnabled(false);
        btEspecTic.setEnabled(false);
        
        
        btCancelar = new JButton("Cancelar");
        btAceptar =  new JButton("Aceptar");

        panelPrin = new JPanel();

        manejador = new ManejaEventos();
        
        driverPrePos =  new driverInfoPrePos();
                

    }

    public final void agregarComponentes() {

        panelPrin.add(lbTitulo);
        panelPrin.add(lbSubTitulo);
        panelPrin.add(lbDoctor);
        panelPrin.add(lbDoctorTic);
        panelPrin.add(lbEspecia);
        panelPrin.add(lbEspeciaTic);
        panelPrin.add(lbLicenciado);
        panelPrin.add(lbMaestria);
        panelPrin.add(lbMaestriaTic);
        
        panelPrin.add(CBDoctor);
        panelPrin.add(CBDoctorTic);
        panelPrin.add(CBEspecia);
        panelPrin.add(CBEspeciaTic);
        panelPrin.add(CBLicen);
        panelPrin.add(CBMaestria);
        panelPrin.add(CBMaestriaTic);
        

        panelPrin.add(btDoctor);
        panelPrin.add(btDoctorTic);
        panelPrin.add(btEspec);
        panelPrin.add(btEspecTic);
        panelPrin.add(btLicen);
        panelPrin.add(btMaestria);
        panelPrin.add(btMaestriaTic);
        
        panelPrin.add(btCancelar);
        panelPrin.add(btAceptar);
        
        panelPrin.setLayout(null);
        panelPrin.setBackground(Color.WHITE);

    }

    private void acomodarComponentes() {

        lbTitulo.setBounds(60, 20, 430, 70);
        lbSubTitulo.setBounds(30, 100, 350, 30);
        
        lbLicenciado.setBounds(30, 130, 280, 30);
        CBLicen.setBounds(350, 130, 20, 25);
        btLicen.setBounds(390, 130, 110, 25);
        lbEspecia.setBounds(30, 160, 250, 30);
        CBEspecia.setBounds(350, 160, 20, 25);
        btEspec.setBounds(390, 160, 110, 25);
        lbEspeciaTic.setBounds(30, 190, 280, 30);
        CBEspeciaTic.setBounds(350, 190, 20, 25);
        btEspecTic.setBounds(390, 190, 110, 25);
        lbMaestria.setBounds(30, 220, 250, 30);
        CBMaestria.setBounds(350, 220, 20, 25);
        btMaestria.setBounds(390, 220, 110, 25);
        lbMaestriaTic.setBounds(30, 250, 250, 30);
        CBMaestriaTic.setBounds(350, 250, 20, 25);
        btMaestriaTic.setBounds(390, 250, 110, 25);
        lbDoctor.setBounds(30, 280, 250, 30);
        CBDoctor.setBounds(350, 280, 20, 25);
        btDoctor.setBounds(390, 280, 110, 25);
        lbDoctorTic.setBounds(30, 310, 250, 30);
        CBDoctorTic.setBounds(350, 310, 20, 25);
        btDoctorTic.setBounds(390, 310, 110, 25);
        
        btAceptar.setBounds(225, 380, 110, 30);
        btCancelar.setBounds(385, 380, 110, 30);




    }

    public void asignarEventos() {
                    
        CBDoctor.addMouseListener(manejador);
        CBDoctorTic.addMouseListener(manejador);
        CBMaestria.addMouseListener(manejador);
        CBMaestriaTic.addMouseListener(manejador);
        CBEspecia.addMouseListener(manejador);
        CBEspeciaTic.addMouseListener(manejador);
        CBLicen.addMouseListener(manejador);
        btCancelar.addMouseListener(manejador);
        btAceptar.addMouseListener(manejador);

    }
    
    public boolean validarCargaArchivos(int seleccion) {
        
        boolean good = false;
        
        switch(seleccion)
        {
            case 1:
            {
                if((rtDoctor == null) || (rtDoctor.equals("N/A")))
                {
                    good = false;
                }
                
                else
                {
                    good = true;
                }
            };break;
                
            case 2:
            {
                if((rtDoctorTic == null) || (rtDoctorTic.equals("N/A")))
                {
                    good = false;
                }
                
                else
                {
                    good = true;
                }
            };break;
                
            case 3:
            {
                if((rtMaestria == null) || (rtMaestria.equals("N/A")))
                {
                    good = false;
                }
                
                else
                {
                    good = true;
                }
            };break;
                
            case 4:
            {
                if((rtMaestriaTic == null) || (rtMaestriaTic.equals("N/A")))
                {
                    good = false;
                }
                
                else
                {
                    good = true;
                }
            };break;
                
            case 5:
            {
                if((rtEspecia == null) || (rtEspecia.equals("N/A")))
                {
                    good = false;
                }
                
                else
                {
                    good = true;
                }
                
            };break;
                
            case 6:
            {
                if((rtEspeciaTic == null) || (rtEspeciaTic.equals("N/A")))
                {
                    good = false;
                }
                
                else
                {
                    good = true;
                }
            };break;
                
            case 7:
            {
                if((rtLicen == null) || (rtLicen.equals("N/A")))
                {
                    good = false;
                }
                
                else
                {
                    good = true;
                }
            };break;
                
           default:
           {
               good = false;
           };break;
        }
        
        return good;
    }
    
    public int checkSeleccion() {
      
        if (CBDoctor.isSelected() == true ) 
        {
             return 1;
        }
        
        else if (CBDoctorTic.isSelected() == true) 
        {
             return 2;
        }
        
        else if (CBMaestria.isSelected() == true ) 
        {
             return 3;
        }
        
        else if (CBMaestriaTic.isSelected() == true ) 
        {
             return 4;
        }
        
        else if (CBEspecia.isSelected() == true ) 
        {
             return 5;
        }
        
        else if (CBEspeciaTic.isSelected() == true ) 
        {
             return 6;
        }
        
        else if (CBLicen.isSelected() == true ) 
        {
             return 7;
        }
        
        return 0;
    }
    
    public String seleccionador(){
  
    fc = new JFileChooser();
  
    int returnVal = fc.showOpenDialog(this);
     
    if (returnVal == JFileChooser.APPROVE_OPTION) {
    
        return fc.getSelectedFile().getAbsolutePath();
  
    }
 
    else {
    
        return null;
  
    }

}

    public void configurarVentana(VentanaOpcionesModulo vent){
    
    ventanaOpcModulo = vent;
    
    }
  
     private class ManejaEventos implements MouseListener{

       

        @Override
        public void mouseClicked(MouseEvent me) {
            
            if (me.getSource() == btAceptar) {
                
                if(validarCargaArchivos(checkSeleccion()) == true ){
                
                   driverPrePos.guardarInfo(indentificacion ,rtDoctor, rtDoctorTic, rtMaestria, rtMaestriaTic,
                                            rtEspecia, rtEspeciaTic, rtLicen, (String)datos_convocatoria[0]);
              
                  //  System.err.println(indentificacion + rtDoctor +  rtDoctorTic +  rtMaestria +  rtMaestriaTic + 
                    //                        rtEspecia +  rtEspeciaTic +  rtLicen);
                }else{
                
                    
                    JOptionPane.showMessageDialog(null, "Se deben de cargar los archivos de respalfo \n de las casillas seleccionadas");
                }
                                
            } else if (me.getSource() == btCancelar) {
                
                ventanaOpcModulo.setVisible(true);
                dispose();

            } else if (me.getSource() == btDoctor) {
                
               rtDoctor = seleccionador(); 
                
            } else if (me.getSource() == btDoctorTic) {
                
                rtDoctorTic = seleccionador();

            }else if (me.getSource() == btEspec) {
                
                rtEspecia = seleccionador();

            } else if (me.getSource() == btEspecTic) {
                
                rtEspeciaTic = seleccionador();

            } else if (me.getSource() == btLicen) {
                
                rtLicen = seleccionador();

            } else if (me.getSource() == btMaestria) {
                
                rtMaestria = seleccionador();

            } else if (me.getSource() == btMaestriaTic) {
                
                rtMaestriaTic = seleccionador();

            } else if (me.getSource() == CBDoctor) {
                
                if(CBDoctor.isSelected() == true) {
                    
                    btDoctor.setEnabled(true);
                    btDoctor.addMouseListener(manejador);
                    
                }else{
                
                    rtDoctor = "N/A";
                    btDoctor.removeMouseListener(manejador);
                    btDoctor.setEnabled(false);
                                    
                }

            }else if (me.getSource() == CBDoctorTic) {
                
                if(CBDoctorTic.isSelected() == true) {
                    
                    btDoctorTic.setEnabled(true);
                    btDoctorTic.addMouseListener(manejador);
                    
                }else{
                
                    rtDoctorTic = "N/A";
                    btDoctorTic.removeMouseListener(manejador);
                    btDoctorTic.setEnabled(false);
                                    
                }

            }else if (me.getSource() == CBMaestria) {
                
                if(CBMaestria.isSelected() == true) {
                    
                    btMaestria.setEnabled(true);
                    btMaestria.addMouseListener(manejador);
                    
                }else{
                    
                    rtMaestria = "N/A";
                    btMaestria.removeMouseListener(manejador);
                    btMaestria.setEnabled(false);
                                    
                }

            }else if (me.getSource() == CBMaestriaTic) {
                
                if(CBMaestriaTic.isSelected() == true) {
                            
                    btMaestriaTic.setEnabled(true);
                    btMaestriaTic.addMouseListener(manejador);
                    
                }else{
                
                    rtMaestriaTic = "N/A";
                    btMaestriaTic.removeMouseListener(manejador);
                    btMaestriaTic.setEnabled(false);
                                    
                }

            }else if (me.getSource() == CBEspecia) {
                
                if(CBEspecia.isSelected() == true) {
                                     
                    btEspec.setEnabled(true);
                    btEspec.addMouseListener(manejador);
                    
                }else{
                
                    rtEspecia = "N/A";
                    btEspec.removeMouseListener(manejador);
                    btEspec.setEnabled(false);
                                    
                }

            }else if (me.getSource() == CBEspeciaTic) {
                
                if(CBEspeciaTic.isSelected() == true) {
                    
                    btEspecTic.setEnabled(true);
                    btEspecTic.addMouseListener(manejador);
                    
                }else{
                
                    rtEspeciaTic = "N/A";
                    btEspecTic.removeMouseListener(manejador);
                    btEspecTic.setEnabled(false);
                                    
                }

            }else if (me.getSource() == CBLicen) {
                
                if(CBLicen.isSelected() == true) {
                    
                    btLicen.setEnabled(true);
                    btLicen.addMouseListener(manejador);
                    
                }else{
                
                    rtLicen = "N/A";
                    btLicen.removeMouseListener(manejador);
                    btLicen.setEnabled(false);
                                    
                }

            }
            
        
        }

        @Override
        public void mousePressed(MouseEvent me) {
        }

        @Override
        public void mouseReleased(MouseEvent me) {
        }

        @Override
        public void mouseEntered(MouseEvent me) {
        }

        @Override
        public void mouseExited(MouseEvent me) {
        }

        
    }

public static void main(String args[]){

    String[] conv = {"julian", "miconvocatoria"};
    //conv[0]="julian";
    VentanaInfoPrePos ven =  new VentanaInfoPrePos(0,"5863", conv);

}    
    
}