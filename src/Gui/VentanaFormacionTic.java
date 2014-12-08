

package Gui;

import controlador.*;
import logica.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class VentanaFormacionTic extends JFrame{
    
    private JLabel lbEncabezadoi;
    private JLabel lbFinal;
    private Container cont;
    private JPanel principal;
    private JLabel lbEncabezado, lbCurso, lbSoporte;
    private JComboBox comboTitulos, comboConsecutivo;
    private JTextField campoRuta;
    private JFileChooser chooserSoporte;
    private JButton btAgregar, btAgregar2, btCancelar, btExaminar, btOmitir, btSiguiente, btEditar, btAceptar;
    private ManejaEvento driverEventos;
    private DriverFormacionTic contFormacionTic;
    private String id_aspirante;
    private String[] datos_convocatoria;
    private VentanaOpcionesModulo ventana_opcionesM;
    
    int item1, item2, item3, item4, tipo;
    
    private VentanaPrincipalDigitador ventana_digitador;
    
    private JTable jttablaform;
    private DefaultTableModel modelo;
    
    public VentanaFormacionTic(int tipo, String identificacion_aspirante, String[] datos_convocatoria){
         
        super("VENTANA FORMACIÓN EN TIC");
        this.tipo = tipo;
        id_aspirante = identificacion_aspirante;
        this.datos_convocatoria = datos_convocatoria;
        contFormacionTic = new DriverFormacionTic();
        item1 = 0;
        item2 = 0;
        item3 = 0;
        item4 = 0;
        
        cont = getContentPane();
        
        setSize(new Dimension(900, 650));
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(0);
        
        driverEventos = new ManejaEvento();
        
        iniciarComponentes();
        agregarComponentes();
        acomodarComponentes();
        //agregarEventos();
        
        cont.add(principal);
        setVisible(true);
        
        
        
    }
    
        public VentanaFormacionTic(int tipo, String identificacion_aspirante, String[] datos_convocatoria, VentanaPrincipalDigitador ventana_digitador){
         
        super("VENTANA FORMACIÓN EN TIC");
        this.tipo = tipo;
        id_aspirante = identificacion_aspirante;
        this.datos_convocatoria = datos_convocatoria;
        this.ventana_digitador = ventana_digitador;
        contFormacionTic = new DriverFormacionTic();
        item1 = 0;
        item2 = 0;
        item3 = 0;
        item4 = 0;
        
        cont = getContentPane();
        
        setSize(new Dimension(900, 650));
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(0);
        
        driverEventos = new ManejaEvento();
        
        iniciarComponentes();
        agregarComponentes();
        acomodarComponentes();
        //agregarEventos();
        
        cont.add(principal);
        setVisible(true);
        
        
        
    }
    
    public void iniciarComponentes(){
        
        principal = new JPanel();
        lbEncabezado = new JLabel("Formacion en Tic - "+datos_convocatoria[1]);
        lbEncabezadoi = new JLabel(new ImageIcon ("src/iconos/encabezado.png"));
        lbFinal = new JLabel(new ImageIcon ("src/iconos/piePagina.png"));
        
        switch (tipo){
            case 0:
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
                btAgregar2 = new JButton("Agregar 2");     
                btSiguiente = new JButton("Siguiente");
                btOmitir = new JButton("Omitir");
            break;
            
            case 1://consultar
                String [] titulos = new String [] {"Titulo", "Consecutivo", "Soporte", "Puntaje"};
                modelo = new DefaultTableModel(0, 4);
                jttablaform =  new JTable(modelo);
        
                jttablaform.setAutoscrolls(true);
                jttablaform.setEnabled(false);
                btCancelar = new JButton("Cancelar");
                agregarFormacionTic(titulos);
                consultarInformacionTic();
            break;
                
            case 2:
                lbCurso = new JLabel("Curso:");
                comboTitulos = new JComboBox();
                comboTitulos.addItem("Curso TIC minimo 40 horas");
                comboTitulos.addItem("Curso TIC hasta 90 horas");
                comboTitulos.addItem("Curso TIC minimo hasta 140 horas certificados o en proceso de certificación");
                comboTitulos.addItem("Curso TIC mas 140 horas");
                btAceptar = new JButton("Aceptar");
                btEditar = new JButton("Editar");
                comboConsecutivo = new JComboBox();
                lbSoporte = new JLabel("Soporte:");
                campoRuta = new JTextField("");
                chooserSoporte = new JFileChooser();
                btExaminar = new JButton("Examinar");
                
        }
        
       
        
    }
    
    public void agregarComponentes(){  
        
        principal.add(lbEncabezado);
        principal.add(lbEncabezadoi);
        principal.add(lbFinal);
        
         switch (tipo){
            case 0:
        
                principal.add(lbCurso);
                principal.add(lbSoporte);
                principal.add(comboTitulos);
                //principal.add(campoRuta);

                principal.add(btExaminar);
                principal.add(btAgregar);
                principal.add(btAgregar2);
                principal.add(btSiguiente);
                principal.add(btOmitir);
                principal.add(campoRuta);
            break;
             
            case 1:
                System.out.print("Siiii  entraaaa");
                principal.add(jttablaform);
                principal.add(btCancelar);
            break;
                
            case 2:
                principal.add(lbCurso);
                principal.add(comboTitulos);
                principal.add(btAceptar);
                principal.add(btEditar);
                principal.add(comboConsecutivo);
                principal.add(lbSoporte);
                principal.add(campoRuta);
                principal.add(btExaminar);
            break;
         }
                principal.setLayout(null);
                principal.setBackground(Color.WHITE);
    }
    
    public void acomodarComponentes(){
        
    lbEncabezado.setBounds(360, 110, 200, 30);
    lbEncabezadoi.setBounds(0,0,900,80);
    lbFinal.setBounds(0, 570, 900, 80);
        switch (tipo){
            case 0:
                        
                        lbCurso.setBounds(30, 200, 50, 10);
                        comboTitulos.setBounds(80, 200, 438, 25);
                        lbSoporte.setBounds(30, 240, 50, 20);
                        campoRuta.setBounds(30, 270, 400, 25);
                        campoRuta.setEditable(false);
                        btExaminar.setBounds(430, 270, 100, 25);
                        btAgregar.setBounds(320, 320, 100, 25);
                        btAgregar2.setBounds(320, 320, 100, 25);
                        btOmitir.setBounds(430, 320, 100, 25);
                        btSiguiente.setBounds(430, 320, 100, 25);
                        
                        lbEncabezado.setVisible(true);
                        lbCurso.setVisible(false);
                        comboTitulos.setVisible(false);
                        lbSoporte.setVisible(false);
                        campoRuta.setVisible(false);
                        btExaminar.setVisible(false);
                        btAgregar.setVisible(true);
                        btAgregar2.setVisible(false);
                        btOmitir.setVisible(true);
                        btSiguiente.setVisible(false);
            break;
                
            case 1:
                        btCancelar.setBounds(400, 500, 100, 25);
                        jttablaform.setBounds(50, 200, 800, 300);
            break;    
        }
    }
    
    public void agregarEventos(){
        
        switch (tipo){
            case 0:
                btExaminar.addActionListener(driverEventos);
                btAgregar.addActionListener(driverEventos);
                btAgregar2.addActionListener(driverEventos);
                btOmitir.addActionListener(driverEventos);
                btSiguiente.addActionListener(driverEventos);
            break;
            
            case 1:
                btCancelar.addActionListener(driverEventos);
            break;
        }
    }
    
    public void configurarVentana (VentanaOpcionesModulo opcionesMod) {//ventana anterior
        
        ventana_opcionesM = opcionesMod;
        
    }
    
    public void funcionAgregar(){
        lbEncabezado.setVisible(true);
        lbCurso.setVisible(true);
        comboTitulos.setVisible(true);
        lbSoporte.setVisible(true);
        campoRuta.setVisible(true);
        btExaminar.setVisible(true);
        btAgregar.setVisible(false);
        btAgregar2.setVisible(true);
        btOmitir.setVisible(false);
        btSiguiente.setVisible(true);
    }
    

    
    
    
    public void ingresarModulo3(){//Ventana siguiente agregar
         VentanaConocimientosEspec modulo3 = new VentanaConocimientosEspec(tipo, id_aspirante, datos_convocatoria, ventana_digitador);
         modulo3.agregarEventos();
         dispose();
     }
    
    
    public void agregarFormacionTic (String [] informacion) {
        
        modelo.addRow(informacion);
        
    }
    
    public void consultarInformacionTic () {  
            ArrayList <formacionTic> formacionT = contFormacionTic.consultarFTICAspirante(id_aspirante, datos_convocatoria[0]);
            
            for (int i = 0; i < formacionT.size(); i++) {
                System.out.print("Titulo ventana"+ formacionT.get(i).getTitulo());
                String [] info = new String [] {formacionT.get(i).getTitulo(), formacionT.get(i).getConsecutivo()+"", formacionT.get(i).getSoporte(), formacionT.get(i).getPuntaje()+""};
                
                agregarFormacionTic(info);
                
            }
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
        String link_soporte;
        int puntos;
        if(campoRuta.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Debe Seleccionar un archivo de soporte");
        }else{
            puntos = puntaje();
            titulo = comboTitulos.getSelectedItem().toString();
            ruta = campoRuta.getText();
            link_soporte = contFormacionTic.consultarSoporte(id_aspirante, titulo, datos_convocatoria[0]);
            //*********************************************************************************************
            if(link_soporte.equals(ruta)){
                JOptionPane.showMessageDialog(null, "Debe Seleccionar un archivo de soporte diferente");
            }
            else{
            int puntaje_maximo = contFormacionTic.puntajeMaximo(id_aspirante, datos_convocatoria[0]);
            System.out.print("Puntaje maximo "+puntaje_maximo);
            contFormacionTic.guardar(id_aspirante, titulo, item1, ruta, puntos, datos_convocatoria[0]);
            
            contFormacionTic.asignarPuntajeInscripcion(id_aspirante, datos_convocatoria[0], puntos, puntaje_maximo);
            item1++;}
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
                funcionAgregar();
                //btSiguiente.setVisible(false);
            }
            if(ae.getSource() == btCancelar){
                ventana_opcionesM.setVisible(true);
                dispose();
            }
            
            if(ae.getSource() == btAgregar2){
                guardar();
            }
            
            if(ae.getSource() == btOmitir){
                ingresarModulo3();
            }
            
            if(ae.getSource() == btSiguiente){
                ingresarModulo3();
            }
        }
         
     }
    
    public static void main(String args[]){
     String[] dato = new String[2];   
     dato[0] = "convo-1";
     dato[1] = "convocatoria-1";
    VentanaFormacionTic ven =  new VentanaFormacionTic(1, "1234", dato);

}  
}
