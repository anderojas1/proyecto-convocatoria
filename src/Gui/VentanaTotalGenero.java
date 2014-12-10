/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Gui;

import java.awt.*;
import javax.swing.*;
import controlador.*;
import logica.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santa Gutierrez
 */
public class VentanaTotalGenero extends JFrame{
    
    private Container cont;
    private JPanel principal;
    private JLabel lbEncabezadoi;
    private JLabel lbFinal;
    private JLabel encabezado;
    private JLabel lbMujeres;
    private JLabel lbHombres;
    private JLabel convocatoria;
    private JTextField jtMujeres;
    private JTextField jtHombres;
    private JComboBox listaConvocatorias;
    private JButton consultar;
    private JButton volver;
    private ManejaEvento driverEventos;
    private DriverConvocatoria controlConv;
    private DriverAspirante controlAsp;
    
    private VentanaIniSupervisor ventana_supervisor;

    
    public VentanaTotalGenero(){
        
         super("REPORTE POR GENERO");
    
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
        JPanel principal = new JPanel();
        lbEncabezadoi = new JLabel(new ImageIcon ("src/iconos/encabezado.png"));
        lbFinal = new JLabel(new ImageIcon ("src/iconos/piePagina.png"));
        encabezado = new JLabel("Reporte de Genero por Convocatoria");
        lbMujeres = new JLabel("Mujeres: ");
        lbHombres = new  JLabel("Hombres: ");
        jtMujeres = new JTextField();
        jtMujeres.setEditable(false);
        jtHombres = new JTextField();
        jtHombres.setEditable(false);
        listaConvocatorias = new JComboBox();
        listarConvocatorias();
        consultar = new JButton("Consultar");
        volver= new JButton("Volver");
        convocatoria = new JLabel("Convocatoria: ");
        controlConv = new DriverConvocatoria();
        controlAsp = new DriverAspirante();
  
    }
    
    public void agregarComponentes(){
        principal.add(lbEncabezadoi);
                 
        principal.add(lbFinal);
        principal.add(encabezado);
        principal.add(lbMujeres);
        principal.add(lbHombres);
        principal.add(jtMujeres);
        principal.add(jtHombres);
        principal.add(listaConvocatorias);
        principal.add(consultar);
        principal.add(volver);
        principal.add(convocatoria);
        
        principal.setLayout(null);
        principal.setBackground(Color.WHITE);
    }
    
    public void acomodarComponentes(){
         encabezado.setBounds(360, 110, 200, 30);
         lbEncabezadoi.setBounds(0,0,900,80);
         lbFinal.setBounds(0, 570, 900, 80);
         
         convocatoria.setBounds(200, 200, 50, 30);
         listaConvocatorias.setBounds(270, 200, 200, 30);
         
         lbMujeres.setBounds(200, 250, 50, 20);
         lbHombres.setBounds(400, 205, 50, 20);
         
         jtMujeres.setBounds(200, 235, 50, 20);
         jtHombres.setBounds(400, 235, 50, 20);
         
         consultar.setBounds(490, 200, 100, 30);
         volver.setBounds(400, 300, 100, 30);
         
    }
    
    public void agregarEventos(){
        consultar.addActionListener(driverEventos);
        volver.addActionListener(driverEventos);
    }
    
    public void listarConvocatorias(){
        ArrayList<String> lConvo= new ArrayList();
        lConvo = controlConv.listaConvocatorias();
        
        int tam = lConvo.size();
        
        for (int i=0 ; i < tam; i++){
            listaConvocatorias.addItem(lConvo.get(i));
        }
    }
    
   public void configurarVentana (VentanaIniSupervisor ventana) {//ventana anterior
        
        ventana_supervisor = ventana;
        
    }
    
    
    
    private class ManejaEvento implements ActionListener{

           public void actionPerformed(ActionEvent ae) {
            
               if(ae.getSource() == volver){
                   ventana_supervisor.setVisible(true);
                   dispose();
               }
               
               if(ae.getSource() == consultar){
                   String m="No hay inscritos";
                   String h="No hay inscritos";
                   try {
                       int mujeres = controlAsp.consultarNumeros("Genero", "Mujer");
                       m= mujeres+"";
                   } catch (SQLException ex) {
                       Logger.getLogger(VentanaTotalGenero.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   jtMujeres.setText(m);
                   try {
                       int hombres = controlAsp.consultarNumeros("Genero", "Hombre");
                       h= hombres+"";
                   } catch (SQLException ex) {
                       Logger.getLogger(VentanaTotalGenero.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   jtHombres.setText(h);
               }
        }
         
     }
}
