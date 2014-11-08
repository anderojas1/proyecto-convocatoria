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
    
    private JButton btCancelar;
    private JButton btAtras;
    private JButton btSiguient;
    //declaracion paneles
    private JPanel panelPrin;
    //declaracion objetos de control
    private ManejaEventos manejador;
    private ViewValidator validator;
    
    //identificacion del aspirante
    private String indentificacion;
    
    //chooser
    private JFileChooser fc;
    
    
    //Constructor de la Clase 
    public VentanaInfoPrePos(String identificacion) {

        super("Informacion Pregrado Posgrado");

        identificacion = identificacion;
        
        iniciarComponentes();
        agregarComponentes();
        acomodarComponentes();
        asignarEventos();
        
        getContentPane().add(panelPrin);
        setSize(new Dimension(540, 450));
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(0);

    }

    public final void iniciarComponentes() {

        lbTitulo = new JLabel("INFORMACION PERSONAL");

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
        btSiguient = new JButton("Siguiente");
        btAtras =  new JButton("Atras");

        panelPrin = new JPanel();

        manejador = new ManejaEventos();

    }

    public final void agregarComponentes() {

        panelPrin.add(lbTitulo);
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
        
        panelPrin.add(btSiguient);
        panelPrin.add(btCancelar);
        panelPrin.add(btAtras);
        
        panelPrin.setLayout(null);
        panelPrin.setBackground(Color.WHITE);

    }

    private void acomodarComponentes() {

        lbTitulo.setBounds(160, 30, 200, 30);

        lbLicenciado.setBounds(30, 80, 280, 30);
        CBLicen.setBounds(350, 80, 20, 25);
        btLicen.setBounds(390, 80, 110, 25);
        lbEspecia.setBounds(30, 110, 250, 30);
        CBEspecia.setBounds(350, 110, 20, 25);
        btEspec.setBounds(390, 110, 110, 25);
        lbEspeciaTic.setBounds(30, 140, 280, 30);
        CBEspeciaTic.setBounds(350, 140, 20, 25);
        btEspecTic.setBounds(390, 140, 110, 25);
        lbMaestria.setBounds(30, 170, 250, 30);
        CBMaestria.setBounds(350, 170, 20, 25);
        btMaestria.setBounds(390, 170, 110, 25);
        lbMaestriaTic.setBounds(30, 200, 250, 30);
        CBMaestriaTic.setBounds(350, 200, 20, 25);
        btMaestriaTic.setBounds(390, 200, 110, 25);
        lbDoctor.setBounds(30, 230, 250, 30);
        CBDoctor.setBounds(350, 230, 20, 25);
        btDoctor.setBounds(390, 230, 110, 25);
        lbDoctorTic.setBounds(30, 260, 250, 30);
        CBDoctorTic.setBounds(350, 260, 20, 25);
        btDoctorTic.setBounds(390, 260, 110, 25);
        
        btAtras.setBounds(125, 350, 110, 30);
        btSiguient.setBounds(255, 350, 110, 30);
        btCancelar.setBounds(385, 350, 110, 30);




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
        btSiguient.addMouseListener(manejador);
    }
    
    public boolean validarCargaArchivos(){
    
        boolean good = true;
    
        if((CBDoctor.isSelected() == true && rtDoctor.equals("N/A")) || 
           (CBDoctorTic.isSelected() == true && rtDoctorTic.equals("N/A")) ||
           (CBMaestria.isSelected() == true && rtMaestria.equals("N/A")) ||
           (CBMaestriaTic.isSelected() == true && rtMaestriaTic.equals("N/A")) ||
           (CBEspecia.isSelected() == true && rtEspecia.equals("N/A")) ||
           (CBEspeciaTic.isSelected() == true && rtEspeciaTic.equals("N/A")) ||
           (CBLicen.isSelected() == true && rtLicen.equals("N/A")) ){
        
            good = false;
        }
    
        return good;
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


    
    private class ManejaEventos implements MouseListener{

       

        @Override
        public void mouseClicked(MouseEvent me) {
            
            if (me.getSource() == btSiguient) {
                
                if(validarCargaArchivos() == true ){
                
                    JOptionPane.showMessageDialog(null, "Siguiente panel");
                }else{
                
                    JOptionPane.showMessageDialog(null, "Se deben de cargar los archivos de respalfo \n de las casillas seleccionadas");
                }
                                
            } else if (me.getSource() == btCancelar) {
                                
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
                
                    btDoctor.removeMouseListener(manejador);
                    btDoctor.setEnabled(false);
                                    
                }

            }  else if (me.getSource() == CBDoctor) {
                
                if(CBDoctor.isSelected() == true) {
                    
                    btDoctor.setEnabled(true);
                    btDoctor.addMouseListener(manejador);
                    
                }else{
                
                    btDoctor.removeMouseListener(manejador);
                    btDoctor.setEnabled(false);
                                    
                }

            }else if (me.getSource() == CBDoctorTic) {
                
                if(CBDoctorTic.isSelected() == true) {
                    
                    btDoctorTic.setEnabled(true);
                    btDoctorTic.addMouseListener(manejador);
                    
                }else{
                
                    btDoctorTic.removeMouseListener(manejador);
                    btDoctorTic.setEnabled(false);
                                    
                }

            }else if (me.getSource() == CBMaestria) {
                
                if(CBMaestria.isSelected() == true) {
                    
                    btMaestria.setEnabled(true);
                    btMaestria.addMouseListener(manejador);
                    
                }else{
                
                    btMaestria.removeMouseListener(manejador);
                    btMaestria.setEnabled(false);
                                    
                }

            }else if (me.getSource() == CBMaestriaTic) {
                
                if(CBMaestriaTic.isSelected() == true) {
                    
                    btMaestriaTic.setEnabled(true);
                    btMaestriaTic.addMouseListener(manejador);
                    
                }else{
                
                    btMaestriaTic.removeMouseListener(manejador);
                    btMaestriaTic.setEnabled(false);
                                    
                }

            }else if (me.getSource() == CBEspecia) {
                
                if(CBEspecia.isSelected() == true) {
                    
                    btEspec.setEnabled(true);
                    btEspec.addMouseListener(manejador);
                    
                }else{
                
                    btEspec.removeMouseListener(manejador);
                    btEspec.setEnabled(false);
                                    
                }

            }else if (me.getSource() == CBEspeciaTic) {
                
                if(CBEspeciaTic.isSelected() == true) {
                    
                    btEspecTic.setEnabled(true);
                    btEspecTic.addMouseListener(manejador);
                    
                }else{
                
                    btEspecTic.removeMouseListener(manejador);
                    btEspecTic.setEnabled(false);
                                    
                }

            }else if (me.getSource() == CBLicen) {
                
                if(CBLicen.isSelected() == true) {
                    
                    btLicen.setEnabled(true);
                    btLicen.addMouseListener(manejador);
                    
                }else{
                
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

    VentanaInfoPrePos ven =  new VentanaInfoPrePos("1234");

}    
    
}