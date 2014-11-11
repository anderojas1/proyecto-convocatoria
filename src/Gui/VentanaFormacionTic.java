

package Gui;

import controlador.*;
import logica.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaFormacionTic extends JFrame{
    
    private Container cont;
    private JPanel principal;
    private JLabel lbEncabezado, lbCurso, lbSoporte;
    private JComboBox comboTitulos;
    private JTextField campoRuta;
    private JFileChooser chooserSoporte;
    private JButton btAgregar, btSiguiente, btExaminar;
    private ManejaEvento driverEventos;
    private DriverFormacionTic contFormacionTic;
    private String id_aspirante;
    
    int item1, item2, item3, item4;
    
    public VentanaFormacionTic(String identificacion_aspirante){
         
        super("VENTANA FORMACIÓN EN TIC");
        
        id_aspirante = identificacion_aspirante;
        contFormacionTic = new DriverFormacionTic();
        item1 = 0;
        item2 = 0;
        item3 = 0;
        item4 = 0;
        
        cont = getContentPane();
        
        setSize(new Dimension(540, 450));
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(0);
        
        driverEventos = new ManejaEvento();
        
        iniciarComponentes();
        agregarComponentes();
        acomodarComponentes();
        agregarEventos();
        
        cont.add(principal);
        setVisible(true);
        
        
        
    }
    
    public void iniciarComponentes(){
        
        principal = new JPanel();
        lbEncabezado = new JLabel("Formacion en Tic");
        lbCurso = new JLabel("Curso:");
        lbSoporte = new JLabel("Soporte:");
        comboTitulos = new JComboBox();
        comboTitulos.addItem("Curso TIC minimo 40 horas");
        comboTitulos.addItem("Curso TIC hasta 90 horas");
        comboTitulos.addItem("Curso TIC minimo hasta 140 horas certificados o en proceso de certificación");
        comboTitulos.addItem("Curso TIC mas 140 horas");
        campoRuta = new JTextField("");
        chooserSoporte = new JFileChooser();
        btExaminar = new JButton("Examinar");
        btAgregar = new JButton("Agregar");
        btSiguiente = new JButton("Siguiente");
        
    }
    
    public void agregarComponentes(){
        principal.add(lbEncabezado);
        principal.add(lbCurso);
        principal.add(lbSoporte);
        principal.add(comboTitulos);
        //principal.add(campoRuta);
        
        principal.add(btExaminar);
        principal.add(btAgregar);
        principal.add(btSiguiente);
        principal.add(campoRuta);
        
        principal.setLayout(null);
        principal.setBackground(Color.WHITE);
    }
    
    public void acomodarComponentes(){
        lbEncabezado.setBounds(200, 10, 300, 20);
        lbCurso.setBounds(30, 70, 50, 10);
        comboTitulos.setBounds(80, 70, 438, 25);
        lbSoporte.setBounds(30, 110, 50, 20);
        campoRuta.setBounds(30, 140, 400, 25);
        campoRuta.setEditable(false);
        btExaminar.setBounds(430, 140, 100, 25);
        btAgregar.setBounds(320, 190, 100, 25);
        btSiguiente.setBounds(430, 190, 100, 25);
        
    }
    
    public void agregarEventos(){
        btExaminar.addActionListener(driverEventos);
        btAgregar.addActionListener(driverEventos);
    }
    
    public int puntaje(){
        int punt=0;
        int combo = comboTitulos.getSelectedIndex();
        switch (combo){
            case 0:
                punt = 4;
            break;
            case 1:
                punt = 6;
            break;
            case 2:
                punt = 8;
            break;
            case 3:
                punt = 10;
            break;
              
        }
        return punt;
    }
    
    public void guardar(){
        String titulo, ruta;
        int puntos;
        if(campoRuta.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Debe Seleccionar un archivo de soporte");
        }else{
            puntos = puntaje();
            titulo = comboTitulos.getSelectedItem().toString();
            ruta = campoRuta.getText();
            
            contFormacionTic.guardar(id_aspirante, titulo, item1, ruta, puntos);
            item1++;
        }
        
    }
    
    
    public String seleccionador(){
  
    chooserSoporte = new JFileChooser();
  
    int returnVal = chooserSoporte.showOpenDialog(this);
     
    if (returnVal == JFileChooser.APPROVE_OPTION) {
    
        return chooserSoporte.getSelectedFile().getAbsolutePath();
  
    }
 
    else {
    
        return null;
  
    }

}
    
    private class ManejaEvento implements ActionListener{

           public void actionPerformed(ActionEvent ae) {
            if(ae.getSource() == btExaminar){
               String ruta = seleccionador();
               System.out.println(ruta);
               campoRuta.setText(ruta);
            }
            
            if(ae.getSource() == btAgregar){
                guardar();
                //btSiguiente.setVisible(false);
            }
        }
         
     }
    
    public static void main(String args[]){

    VentanaFormacionTic ven =  new VentanaFormacionTic("1234");

}  
}