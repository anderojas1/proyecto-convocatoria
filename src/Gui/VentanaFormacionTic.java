

package Gui;

import controlador.*;
import logica.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class VentanaFormacionTic extends JFrame{
    
    private JLabel lbEncabezadoi;
    private JLabel lbFinal;
    private Container cont;
    private JPanel principal;
    private JLabel lbEncabezado, lbCurso, lbSoporte, lbConsecutivo;
    private JComboBox comboTitulos, comboConsecutivo;
    private JTextField campoRuta;
    private JFileChooser chooserSoporte;
    private JButton btAgregar, btAgregar2, btCancelar, btExaminar, btOmitir, btSiguiente, btEditar, btAceptar, btGuardarEdicion, btDescartar, btAprobar;
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
        agregarEventos();
        
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
            
            /*case 1://consultar
                String [] titulos = new String [] {"Titulo", "Consecutivo", "Soporte", "Puntaje"};
                modelo = new DefaultTableModel(0, 4);
                jttablaform =  new JTable(modelo);
        
                jttablaform.setAutoscrolls(true);
                jttablaform.setEnabled(false);
                btCancelar = new JButton("Cancelar");
                agregarFormacionTic(titulos);
                consultarInformacionTic();
            break;*/
                
            case 1:
                lbCurso = new JLabel("Curso:");
                comboTitulos = new JComboBox();
                //comboTitulos.addItem("Curso TIC hasta 90 horas");
                //comboTitulos.addItem("V");
                comboTitulos.addItem("Seleccionar");
                aspiranteFormacion();
                btAceptar = new JButton("Aceptar");
                btEditar = new JButton("Editar");
                lbConsecutivo= new JLabel("Consecutivo:");
                comboConsecutivo = new JComboBox();
                comboConsecutivo.addItem("Seleccionar");
                lbSoporte = new JLabel("Soporte:");
                campoRuta = new JTextField("");
                chooserSoporte = new JFileChooser();
                btGuardarEdicion = new JButton("Guardar Cambios");
                btCancelar = new JButton("Cancelar");
            break;   
                
            case 2:
                
                if(contFormacionTic.validacionTotal(id_aspirante, datos_convocatoria[0])){
                    btCancelar = new JButton("Cancelar");
                    JOptionPane.showMessageDialog(null, "El aspirante ya está calificado en su totalidad para la convocatoria");
                }else{
                    JOptionPane.showMessageDialog(null, "El aspirante no está calificado en su totalidad para la convocatoria");
                lbCurso = new JLabel("Curso:");
                comboTitulos = new JComboBox();
                comboTitulos.addItem("Seleccionar");
                aspiranteFormacion2();
                btAceptar = new JButton("Aceptar");
                btEditar = new JButton("Ver");
                lbConsecutivo= new JLabel("Consecutivo:");
                comboConsecutivo = new JComboBox();
                comboConsecutivo.addItem("Seleccionar");
                lbSoporte = new JLabel("Soporte:");
                campoRuta = new JTextField("");
                chooserSoporte = new JFileChooser();
                btAprobar = new JButton("Aprobar");
                btDescartar = new JButton("Descartar");
                btCancelar = new JButton("Cancelar");
                }
                
                
            break;
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
             
            /*case 1:
                principal.add(jttablaform);
                principal.add(btCancelar);
            break;*/
                
            case 1:
                principal.add(lbCurso);
                principal.add(comboTitulos);
                principal.add(btCancelar);
                principal.add(btEditar);
                principal.add(btAceptar);
                principal.add(comboConsecutivo);
                principal.add(lbConsecutivo);
                principal.add(lbSoporte);
                principal.add(campoRuta);
                principal.add(btGuardarEdicion);
            break;
                
            case 2:
                principal.add(lbCurso);
                principal.add(comboTitulos);
                principal.add(btCancelar);
                principal.add(btEditar);
                principal.add(btAceptar);
                principal.add(comboConsecutivo);
                principal.add(lbConsecutivo);
                principal.add(lbSoporte);
                principal.add(campoRuta);
                principal.add(btAprobar);
                principal.add(btDescartar);
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
                        
                        lbCurso.setBounds(200, 200, 50, 10);
                        comboTitulos.setBounds(250, 200, 438, 25);
                        lbSoporte.setBounds(200, 240, 50, 20);
                        campoRuta.setBounds(200, 270, 400, 25);
                        campoRuta.setEditable(false);
                        btExaminar.setBounds(600, 270, 100, 25);
                        btAgregar.setBounds(330, 320, 100, 25);
                        btAgregar2.setBounds(500, 320, 100, 25);
                        btOmitir.setBounds(430, 320, 100, 25);
                        btSiguiente.setBounds(600, 320, 100, 25);
                        
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
                
           /* case 1:
                        btCancelar.setBounds(400, 500, 100, 25);
                        jttablaform.setBounds(50, 200, 800, 300);
            break;  */
            
            case 1:
                       lbCurso.setBounds(200, 200, 50, 10);
                       comboTitulos.setBounds(250, 200, 438, 25);
                       lbConsecutivo.setBounds(200, 240, 100, 10);
                       comboConsecutivo.setBounds(280, 240, 100, 25);
                       btAceptar.setBounds(400, 240, 100, 25);
                       lbSoporte.setBounds(200, 270, 50, 20);
                       campoRuta.setBounds(200, 300, 400, 25);
                       campoRuta.setEditable(false);
                       btEditar.setBounds(600, 300, 100, 25);
                       btGuardarEdicion.setBounds(450, 340, 150, 25);
                       btCancelar.setBounds(600, 340, 100, 25);
            break;
                
            case 2:
                       lbCurso.setBounds(200, 200, 50, 10);
                       comboTitulos.setBounds(250, 200, 438, 25);
                       lbConsecutivo.setBounds(200, 240, 100, 10);
                       comboConsecutivo.setBounds(280, 240, 100, 25);
                       btAceptar.setBounds(400, 240, 100, 25);
                       lbSoporte.setBounds(200, 270, 50, 20);
                       campoRuta.setBounds(200, 300, 400, 25);
                       campoRuta.setEditable(false);
                       btEditar.setBounds(600, 300, 100, 25);
                       btAprobar.setBounds(500, 340, 100, 25);
                       btDescartar.setBounds(600, 340, 100, 25);
                       btCancelar.setBounds(400, 400, 100, 25);
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
            
           /* case 1:
                btCancelar.addActionListener(driverEventos);
            break;*/
            
            case 1:
                btCancelar.addActionListener(driverEventos);
                comboTitulos.addItemListener(driverEventos);
                btAceptar.addActionListener(driverEventos);
                btEditar.addActionListener(driverEventos);
                btGuardarEdicion.addActionListener(driverEventos);
            break;
                
            case 2:
                btCancelar.addActionListener(driverEventos);
                comboTitulos.addItemListener(driverEventos);
                btAceptar.addActionListener(driverEventos);
                btEditar.addActionListener(driverEventos);
                btAprobar.addActionListener(driverEventos);
                btDescartar.addActionListener(driverEventos);
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
    
        public void guardarEditar(){
        
        String titulo, ruta, item;
        String link_soporte;
        int puntos;
        if(campoRuta.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Debe Seleccionar un archivo de soporte");
        }else{
            titulo = comboTitulos.getSelectedItem().toString();
            item = comboConsecutivo.getSelectedItem().toString();
            if(titulo.equals("Seleccionar") || item.equals("Seleccionar")){
                JOptionPane.showMessageDialog(null, "Debe Seleccionar un archivo de soporte diferente o seleccionar un número de consecutivo");
            }else{
            ruta = campoRuta.getText();
            
            contFormacionTic.editar(id_aspirante, datos_convocatoria[0], titulo, ruta);
            JOptionPane.showMessageDialog(null, "Se ha editado la información con Exito!!");
            }}
        
        
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
    
    public void aspiranteFormacion(){
       
        ArrayList<String> formacionAsp= new ArrayList();
        formacionAsp = contFormacionTic.consultarFTICAspirante2(id_aspirante, datos_convocatoria[0]);
        
        int tam = formacionAsp.size();
        
        for (int i=0 ; i < tam; i++){
            comboTitulos.addItem(formacionAsp.get(i));
        }
    }
    
    public void aspiranteFormacion2(){
         ArrayList<String> formacionAsp= new ArrayList();
        formacionAsp = contFormacionTic.consultarFTICAspirante3(id_aspirante, datos_convocatoria[0]);
        
        int tam = formacionAsp.size();
        
        for (int i=0 ; i < tam; i++){
            comboTitulos.addItem(formacionAsp.get(i));
        }
    }
        
    public void itemConsecutivo(String formacion){
         //System.out.print("Siiii");
         int itemCount = comboConsecutivo.getItemCount();
        
            for(int i=0;i<itemCount;i++){
                
                comboConsecutivo.removeItemAt(0);
            }
        ArrayList<String> conse= new ArrayList();
        
        conse=contFormacionTic.consultarConsecutivos(id_aspirante, datos_convocatoria[0], formacion);
    
        int tam = conse.size();
        
        comboConsecutivo.addItem("Seleccionar");
        for(int i = 0; i < tam; i++){
            comboConsecutivo.addItem(conse.get(i));
        }
   
    }
    
        public void itemConsecutivo2(String formacion){
         //System.out.print("Siiii");
         int itemCount = comboConsecutivo.getItemCount();
        
            for(int i=0;i<itemCount;i++){
                
                comboConsecutivo.removeItemAt(0);
            }
        ArrayList<String> conse= new ArrayList();
        
        conse=contFormacionTic.consultarConsecutivos2(id_aspirante, datos_convocatoria[0], formacion);
    
        int tam = conse.size();
        
        comboConsecutivo.addItem("Seleccionar");
        for(int i = 0; i < tam; i++){
            comboConsecutivo.addItem(conse.get(i));
        }
   
    }
    
    public void verDocumento(String ruta){
        if(Desktop.isDesktopSupported()) {
 
        try {
        
            File myFile = new File(ruta);
       
            Desktop.getDesktop().open(myFile);
   
        } catch (IOException ex) {
        // no application registered for PDFs
    
        }

    }
    }
    
    public void aprobar(){
            String titulo = comboTitulos.getSelectedItem().toString();
            String consecutivo = comboConsecutivo.getSelectedItem().toString();
            contFormacionTic.aprobarF(id_aspirante, datos_convocatoria[0], titulo, consecutivo);
            JOptionPane.showMessageDialog(null, "Validación Realizada");
            
            if(contFormacionTic.validacionTotal(id_aspirante, datos_convocatoria[0])){
                contFormacionTic.generarPuntaje(id_aspirante, datos_convocatoria[0]);
                JOptionPane.showMessageDialog(null, "El aspirante ya está calificado en su totalidad para la convocatoria");
                ventana_opcionesM.setVisible(true);
                dispose();
            }
        }
    
    public void descartar(){
            String titulo = comboTitulos.getSelectedItem().toString();
            String consecutivo = comboConsecutivo.getSelectedItem().toString();
            contFormacionTic.descartarF(id_aspirante, datos_convocatoria[0], titulo, consecutivo);
            JOptionPane.showMessageDialog(null, "Validación Realizada");
            
            if(contFormacionTic.validacionTotal(id_aspirante, datos_convocatoria[0])){
                contFormacionTic.generarPuntaje(id_aspirante, datos_convocatoria[0]);
                JOptionPane.showMessageDialog(null, "El aspirante ya está calificado en su totalidad para la convocatoria");
                ventana_opcionesM.setVisible(true);
                dispose();
            }
        }
    
    private class ManejaEvento implements ActionListener, ItemListener{

           public void actionPerformed(ActionEvent ae) {
            if(ae.getSource() == btExaminar){
               String ruta = seleccionador();
               System.out.println(ruta);
               campoRuta.setText(ruta);
            }
            
            if(ae.getSource() == btAgregar){
                funcionAgregar();
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
            
            if(ae.getSource() == btAceptar){
                String tituloF = comboTitulos.getSelectedItem().toString();
                System.out.print(tituloF);
                String link_soporte;
                        link_soporte = contFormacionTic.consultarSoporte(id_aspirante, tituloF, datos_convocatoria[0]);
                        campoRuta.setText(link_soporte);
            }
            
            if(ae.getSource() == btEditar){
                
                if(tipo == 1){
                String ruta = seleccionador();
                System.out.println(ruta);
                campoRuta.setText(ruta);}
                else{
                    String ruta = campoRuta.getText()+"";
                    if(ruta.equals("")){
                        JOptionPane.showMessageDialog(null, "Escooja el titulo y el consecutivo, seleccione Aceptar, y por ultimo Ver");
                    }else{
                    verDocumento(ruta);}
                }
            }
            
            if(ae.getSource() == btGuardarEdicion){
                guardarEditar();
                campoRuta.setText("");
            }
            
            if(ae.getSource() == btAprobar){
                aprobar();
            }
            
            if(ae.getSource() == btDescartar){
                descartar();
            }
        }

        @Override
        public void itemStateChanged(ItemEvent ie) {
            
            String tituloF = comboTitulos.getSelectedItem().toString();
            
            if (ie.getStateChange() == ItemEvent.SELECTED && (tipo == 1 || tipo == 2)) {
                    if(ie.getSource() == comboTitulos){
                        
                        if(tipo == 1){
                        itemConsecutivo(tituloF);}
                        else{
                             itemConsecutivo2(tituloF);
                        }
                    }
            }
        }
         
     }
    
    public static void main(String args[]){
     String[] dato = new String[2];   
     dato[0] = "convo-1";
     dato[1] = "convocatoria-1";
     //VentanaPrincipalDigitador ventana_digitador= new VentanaPrincipalDigitador("andre");
    VentanaFormacionTic ven =  new VentanaFormacionTic(2, "1234", dato);

}  
}
