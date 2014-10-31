/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Gui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


 public class VentanaIniSupervisor extends JFrame{

    Container cont;
    private JPanel inicioSupervisor;
    private JLabel encabezado;
    private JButton informe, genero, ciudad, jornada, mejores, consultar, total, salir;
    final ManejaEvento driverEventos;

    
    
    
    public VentanaIniSupervisor(){
        cont = getContentPane(); 
        inicioSupervisor = new JPanel();
        encabezado = new JLabel("Sistema de Selección de Docentes TIC");
        informe = new JButton("Ver Informe Total");
        genero = new JButton("Ver Total por Genero"); 
        ciudad = new JButton("Porcentaje por Ciudad");
        jornada = new JButton("Jornadas Trabajo Aspirantes");
        mejores = new JButton("Ver Mejores 5");
        consultar = new JButton("Consultar Aspirante");
        total = new JButton("Ver total Seleccionados");
        salir = new JButton("Cerrar Sesión");
        driverEventos = new ManejaEvento();
        
        Dimension di = new Dimension(800, 500);
        setSize(650,350);
        setMaximumSize(di);    
        setResizable(false);
        
        agregarComponentes();
        acomodarComponentes();
        agregarEventos();
        
        cont.add(inicioSupervisor);
        setVisible(true);
        
    }
    
    private void agregarComponentes () {
        
        inicioSupervisor.setLayout(null);
        inicioSupervisor.add(encabezado);
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
        
         encabezado.setBounds(130, 10, 300, 10);
         informe.setBounds(50, 100, 200, 20);
         genero.setBounds(50, 130, 200, 20);
         ciudad.setBounds(50, 160, 200, 20);
         jornada.setBounds(50, 190, 200, 20);
         mejores.setBounds(350, 100, 200, 20);
         consultar.setBounds(350, 130, 200, 20);
         total.setBounds(350, 160, 200, 20);
         salir.setBounds(400, 10, 150, 20);
        
    }
    
    public void agregarEventos () {
        
        salir.addActionListener(driverEventos);
        
    }

     private class ManejaEvento implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(ae.getSource() == salir){
                VentanaLogin nuevoLogin = new VentanaLogin();
                nuevoLogin.addEvents();
                dispose();
            }
        }
         
     }

}
