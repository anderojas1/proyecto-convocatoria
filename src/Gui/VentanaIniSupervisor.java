/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Gui;


import controlador.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


 public class VentanaIniSupervisor extends JFrame{
     
     DriverAspirante driverAspirante = new DriverAspirante();

    Container cont;
    private JPanel inicioSupervisor;
    private JLabel encabezado;
    private JLabel lbEncabezadoi;
    private JLabel lbFinal;
    private JButton informe, genero, ciudad, jornada, mejores, consultar, total, salir;
    private ManejaEvento driverEventos;

    private String usuario;
    private DriverUsuario control;
    
    
    public VentanaIniSupervisor(String user){
        
        usuario = user;
        control = new DriverUsuario();
        
        cont = getContentPane(); 
        
        setSize(new Dimension(900, 650));
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(0);
        
        inicioSupervisor = new JPanel();
        encabezado = new JLabel("Sistema de Selección de Docentes TIC");
        informe = new JButton("Ver Informe Total");
        genero = new JButton("Ver Total por Genero"); 
        ciudad = new JButton("Porcentaje por Ciudad");
        jornada = new JButton("Jornadas Trabajo Aspirantes");
        mejores = new JButton("Ver Mejores 5");
        consultar = new JButton("Consultar Aspirante");
        total = new JButton("Ver total Seleccionados");
        salir = new JButton("Cerrar Sesion",new ImageIcon("src/iconos/block.png"));
        driverEventos = new ManejaEvento(this);
        lbEncabezadoi = new JLabel(new ImageIcon ("src/iconos/encabezado.png"));
        lbFinal = new JLabel(new ImageIcon ("src/iconos/piePagina.png"));
        inicioSupervisor.setBackground(Color.WHITE);

        
        agregarComponentes();
        acomodarComponentes();
        agregarEventos();
        
        cont.add(inicioSupervisor);
        setVisible(true);
        
    }
    
    private void agregarComponentes () {
        
        inicioSupervisor.setLayout(null);
        inicioSupervisor.add(encabezado);
        inicioSupervisor.add(lbEncabezadoi);
        inicioSupervisor.add(lbFinal);
        inicioSupervisor.add(informe);
        inicioSupervisor.add(genero);
        inicioSupervisor.add(ciudad);
        inicioSupervisor.add(jornada);
        inicioSupervisor.add(mejores);
        inicioSupervisor.add(consultar);
        inicioSupervisor.add(total);
        inicioSupervisor.add(salir);
        
    }
    
    
    private void acomodarComponentes () {
        encabezado.setBounds(360, 110, 300, 30);
        lbEncabezadoi.setBounds(0,0,900,80);
        lbFinal.setBounds(0, 570, 900, 80);
         informe.setBounds(200, 200, 200, 30);
         genero.setBounds(200, 240, 200, 30);
         ciudad.setBounds(200, 280, 200, 30);
         jornada.setBounds(200, 320, 200, 30);
         mejores.setBounds(500, 200, 200, 30);
         consultar.setBounds(500, 240, 200, 30);
         total.setBounds(500, 280, 200, 30);
         salir.setBounds(500, 400, 200, 35);
        
    }
    
    public void agregarEventos () {
        
        salir.addActionListener(driverEventos);
        informe.addActionListener(driverEventos);
        
    }

     private class ManejaEvento implements ActionListener{

         Component  parentComponent;
         
        public ManejaEvento(Component parent) {
            parentComponent = parent;
        }

         
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(ae.getSource() == salir){
                 VentanaLogin nuevoLogin = new VentanaLogin();
                nuevoLogin.addEvents();
                try {
                    control.estadoSesion(usuario, false);
                    dispose();
                } catch (SQLException ex) {
                    System.out.println("error al cerrar sesion");
                }
            }
            
            if(ae.getSource() == informe){
            
                setVisible(false);
                VentanaListadoInscritos VL = new VentanaListadoInscritos(parentComponent);
                
            
            }
        }
         
     }
     
    public void generarReporteJornadas () {
        
        try {
        
            int jornadaMañana = driverAspirante.consultarNumeros("Jornada", "Mañana");
            int jornadaTarde = driverAspirante.consultarNumeros("Jornada", "Tarde");
            int jornadaAmbas = driverAspirante.consultarNumeros("Jornada", "Ambas");
            System.out.println(jornadaMañana + " - " + jornadaTarde + " - " + jornadaAmbas);
            
            JOptionPane.showMessageDialog(this, "Estamos en desarrollo", "Módulo en desarrollo", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Consulta fallida", JOptionPane.ERROR_MESSAGE);
            
        }
        
    }
    
    public void generarReporteGenero () {
        
        try {
            
            int sexoMasculino = driverAspirante.consultarNumeros("Genero", "Hombre");
            int sexoFemenino = driverAspirante.consultarNumeros("Genero", "Mujer");
            
            Object [][] datos = {{"Hombres", sexoMasculino},{"Mujeres", sexoFemenino}};            
            
            //System.out.println(sexoMasculino + " - " + sexoFemenino);
            
            Graficos reportes = new Graficos();
            
            reportes.recibirParametrosGrafica("Género","titulox","tituloy", datos);
            
            JOptionPane.showMessageDialog(this, "Estamos en desarrollo", "Módulo en desarrollo", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Consulta fallida", JOptionPane.ERROR_MESSAGE);
            
        }
        
    }
    
    public void generarReporteMunicipios () {
        
        JOptionPane.showMessageDialog(this, "Estamos en desarrollo", "Módulo en desarrollo", JOptionPane.INFORMATION_MESSAGE);
    }
    
     public static void main(String args[]){
    VentanaIniSupervisor ven =  new VentanaIniSupervisor ("1234");
     }

}
