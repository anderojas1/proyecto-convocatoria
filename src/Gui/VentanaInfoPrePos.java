package Gui;

import controlador.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

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
    
    private JButton btCancelar;
    private JButton btAtras;
    private JButton btSiguient;
    //declaracion paneles
    private JPanel panelPrin;
    //declaracion objetos de control
    private ManejaEventos manejador;
    private ViewValidator validator;
    
    
    //Constructor de la Clase 
    public VentanaInfoPrePos() {

        super("Informacion Pregrado Posgrado");

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

        btCancelar.addMouseListener(manejador);
        btSiguient.addMouseListener(manejador);
    }
    
      
    
    private class ManejaEventos implements MouseListener{

       

        @Override
        public void mouseClicked(MouseEvent me) {
            
            if (me.getSource() == btSiguient) {

                
                JOptionPane.showMessageDialog(null,"Siguiente modulo");
                
                

            } else if (me.getSource() == btCancelar) {
                
                
                dispose();

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

    VentanaInfoPrePos ven =  new VentanaInfoPrePos();

}    
    
}