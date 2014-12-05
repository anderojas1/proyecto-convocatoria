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
    
    public Graficos(){
    
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
        municipios.add("Argelia");
        municipios.add("Bolívar");
        municipios.add("Buenaventura");
        municipios.add("Buga");
        municipios.add("Bugalagrande");
        municipios.add("Caicedonia");
        municipios.add("Cali");
        municipios.add("Candelaria");
        municipios.add("Cartago");
        municipios.add("Dagua");
        municipios.add("Calima-El Darién");
        municipios.add("El Águila");
        municipios.add("El Cairo");
        municipios.add("El Cerrito");
        municipios.add("El Dovio");
        municipios.add("Florida");
        municipios.add("Ginebra");
        municipios.add("Guacarí");
        municipios.add("Jamundí");
        municipios.add("La Cumbre");
        municipios.add("La Unión");
        municipios.add("La Victoria");
        municipios.add("Obando");
        municipios.add("Palmira");
        municipios.add("Pradera");
        municipios.add("Restrepo");
        municipios.add("Riofrío");
        municipios.add("Roldanillo");
        municipios.add("San Pedro");
        municipios.add("Sevilla");
        municipios.add("Toro");
        municipios.add("Trujillo");
        municipios.add("Tuluá");
        municipios.add("Ulloa");
        municipios.add("Versalles");
        municipios.add("Vijes");
        municipios.add("Yotoco");
        municipios.add("Yumbo");
        municipios.add("Zarzal");
        
        //init();
        
    }
 
    private void init() {
        
        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        
        
        
        getContentPane().add(panel);
        
// Fuente de Datos

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for (int i = 0; i < municipios.size(); i++) {
                    
        Random r = new Random();
             
        String d1 = municipios.get(i);
                
        dataset.setValue(r.nextInt(100)+1, d1, d1);
                
        }                

// Creando el Grafico

        JFreeChart chart = ChartFactory.createBarChart3D       
         ("Participacion por Municipios","Municipios", "Porcentaje",
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
    
        btAceptar.addActionListener(manejador);
    
    }
    
    
    public class ManejaEventos implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(e.getSource() == btAceptar){
            
                System.out.println("Hice clic");
                dispose();
                
            
            }

        }
        
    }
    
    
    public void recibirParametrosGrafica (String titulo, Object [][] datos) {
        
        for (int i = 0; i < datos.length; i++) {
            
            for (int j = 0; j < datos[i].length; j++) {
                
                System.out.println(datos[i][j]);
                
            }
            
        }
        
    }
    
    public static void main(String args[]){
        
        Graficos vent = new Graficos();
        vent.asignarEventos();
        vent.setVisible(true);
    
    }
}
