/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

/**
 *
 * @author julian
 */

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.demo.BarChartDemo1;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.tabbedui.VerticalLayout;

public class Graficos extends JFrame{

    JPanel panel;
    ArrayList <String> municipios;
    
    ManejaEventos manejador;
    JButton btAceptar;
    DefaultCategoryDataset dataset;
    
    public Graficos(){
    
        manejador = new ManejaEventos();
        
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

        setTitle("Sistema Convocatoria Docente");
        setSize(ancho,alto);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        btAceptar =  new JButton("Aceptar");
        btAceptar.setSize(130, 40);
                
        municipios = new ArrayList<>();
        
        municipios.add("Alcalá");
        municipios.add("Andalucía");
        municipios.add("Ansermanuevo");
        
        asignarEventos();
                    
    }
 
    private void init(String titulo, String tituloX, String tituloY) {
        
        panel = new JPanel();
        panel.setBackground(Color.WHITE);
                
        getContentPane().add(panel);

// Creando el Grafico

        JFreeChart chart = ChartFactory.createBarChart3D       
        (titulo,tituloX, tituloY,
        dataset, PlotOrientation.VERTICAL, true,true, false);
       
        chart.setBackgroundPaint(new Color(225,255,228));
        chart.getTitle().setPaint(Color.black);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.red);
        
// Mostrar Grafico

        ChartPanel chartPanel = new ChartPanel(chart);
        panel.add(chartPanel);
        
// panel.setLayout(new VerticalLayout());
        
        panel.add(btAceptar);

//panel.
        panel.setLayout(null);

        chartPanel.setBounds(100, 10, 1100, 600);
        btAceptar.setBounds(1065, 620, 130, 30);
       
    }
    
    public void asignarEventos(){
    
        btAceptar.addMouseListener(manejador);
    
    }
    
    
    public class ManejaEventos implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {

            if(me.getSource() == btAceptar)
            {
            
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
    
    
    public void recibirParametrosGrafica (String titulo, String tituloX, String tituloY, Object [][] datos) {
       
       dataset = new DefaultCategoryDataset();
       String tag = "";
              
        for (int i = 0; i < datos.length; i++) {
              
                String nom = (String)datos[i][0];
                int num = Integer.parseInt((String)datos[i][1]);
                
                System.out.println("###" + nom + "###" + num + "###");
                dataset.setValue(num, nom, nom);

            
        }
        
        init(titulo, tituloX, tituloY);
        
    }
   
    public static void main(String args[]){
        
        Object matriz [][] = {{"Perro","9"},{"Gato","2"},{"Pajaros","6"},{"conejo","11"}};
        
        Graficos vent = new Graficos();
       // vent.setVisible(true);
        vent.recibirParametrosGrafica("ejemplo animales", "Lateral X","Lateral Y", matriz);
    
    }
}
