/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import controlador.DriverConvocatoria;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;

/**
 *
 * @author anderojas
 */
public class VentanaCrearConvocatoria extends JFrame {
    
    private JLabel lbtitulo;
    private JLabel lbcodigo;
    private JLabel lbnombre;
    private JLabel lbfechaInicio;
    private JLabel lbfechaFin;
    private JLabel lbañoInicio;
    private JLabel lbmesInicio;
    private JLabel lbdiaInicio;
    private JLabel lbañoFinal;
    private JLabel lbmesFinal;
    private JLabel lbdiaFinal;
    
    private JTextField jtfcodigo;
    private JTextField jtfnombre;
    
    private JComboBox jcbañoInicio;
    private JComboBox jcbmesInicio;
    private JComboBox jcbdiaInicio;
    private JComboBox jcbañoFinal;
    private JComboBox jcbmesFinal;
    private JComboBox jcbdiaFinal;
    
    private JButton jbcrear;
    private JButton jbcancelar;
    
    private JPanel panel;
    
    private DriverConvocatoria controlaConvocatoria;
    
    private ViewValidator validar;
    
    private ManejarEventos driverEvent;
    
    private VentanaAdministrador admin;
    
    public VentanaCrearConvocatoria () {
            
        super("Crear Convocatoria");
        
        inicializarComponentes();
        agregarComponentes();
        acomodarComponentes();

        setSize(530, 450);
        setResizable(false);
        setLocationRelativeTo(null);

        setTitle("Sistema Convocatoria Docente");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setDefaultCloseOperation(0);
            
    }
    
    
    private void inicializarComponentes () {
        
        panel = new JPanel();
        getContentPane().add(panel);

        validar = new ViewValidator();

        lbtitulo = new JLabel("Sistema de Convocatoria Docente");
        lbcodigo = new JLabel("Código *");
        lbnombre = new JLabel("Nombre *");
        lbfechaInicio = new JLabel("Fecha inicio *");
        lbfechaFin = new JLabel("Fecha fin *");
        lbañoInicio = new JLabel("Año:");
        lbmesInicio = new JLabel("Mes:");
        lbdiaInicio = new JLabel("Día:");
        
        lbañoFinal = new JLabel("Año:");
        lbmesFinal = new JLabel("Mes:");
        lbdiaFinal = new JLabel("Día:");
        
        jtfcodigo = new JTextField();
        jtfnombre = new JTextField();

        jcbañoInicio = new JComboBox();
        jcbmesInicio = new JComboBox();
        jcbdiaInicio = new JComboBox();
        jcbañoFinal = new JComboBox();
        jcbmesFinal = new JComboBox();
        jcbdiaFinal = new JComboBox();
        
        agregarFechas();
    
        jbcrear = new JButton("Crear");
        jbcancelar = new JButton("Cancelar");
        
        controlaConvocatoria = new DriverConvocatoria();
        driverEvent = new ManejarEventos();
        
    }
    
    
    private void agregarFechas () {
        
        for (int i = 2014; i <= 2020; i++) {
            
            jcbañoInicio.addItem(i);
            jcbañoFinal.addItem(i);
            
        }
        
        for (int i = 1; i <= 12; i++) {
            
            if (i < 10) {
                
                jcbmesInicio.addItem("0" + i);
                jcbmesFinal.addItem("0" + i);
            }
            
            else {
                
                jcbmesInicio.addItem(i);
                jcbmesFinal.addItem(i);
            }
            
        }
        
        
        for (int i = 1; i <= 31; i++) {
            
            if (i < 10) {
                
                jcbdiaInicio.addItem("0" + i);
                jcbdiaFinal.addItem("0" + i);
                
                
            }
            
            else {
                
                jcbdiaInicio.addItem(i);
                jcbdiaFinal.addItem(i);
                
            }
            
        }

    }
    
    
    private void agregarComponentes () {
        
        panel.add(lbtitulo);
        panel.add(lbnombre);
        panel.add(lbcodigo);
        panel.add(lbfechaInicio);
        panel.add(lbfechaFin);
        panel.add(lbtitulo);
        panel.add(lbañoInicio);
        panel.add(lbmesInicio);
        panel.add(lbdiaInicio);
        panel.add(lbañoFinal);
        panel.add(lbmesFinal);
        panel.add(lbdiaFinal);
        
        panel.add(jtfcodigo);
        panel.add(jtfnombre);
        
        panel.add(jcbañoInicio);
        panel.add(jcbmesInicio);
        panel.add(jcbdiaInicio);
        panel.add(jcbañoFinal);
        panel.add(jcbmesFinal);
        panel.add(jcbdiaFinal);
        
        panel.add(jbcrear);
        panel.add(jbcancelar);
        
        panel.setLayout(null);
        
    }
    
    
    private void acomodarComponentes () {
        
        lbtitulo.setBounds(150, 20, 300, 30);
        
        lbcodigo.setBounds(50, 100, 100, 30);
        jtfcodigo.setBounds(170, 100, 310, 30);
        
        lbnombre.setBounds(50, 150, 100, 30);
        jtfnombre.setBounds(170, 150, 310, 30);
        
        lbfechaInicio.setBounds(50, 200, 100, 30);
        lbañoInicio.setBounds(170, 200, 40, 30);
        jcbañoInicio.setBounds(210, 200, 70, 30);
        lbmesInicio.setBounds(290, 200, 40, 30);
        jcbmesInicio.setBounds(330, 200, 50, 30);
        lbdiaInicio.setBounds(390, 200, 40, 30);
        jcbdiaInicio.setBounds(430, 200, 50, 30);
        
        lbfechaFin.setBounds(50, 250, 100, 30);
        lbañoFinal.setBounds(170, 250, 40, 30);
        jcbañoFinal.setBounds(210, 250, 70, 30);
        lbmesFinal.setBounds(290, 250, 40, 30);
        jcbmesFinal.setBounds(330, 250, 50, 30);
        lbdiaFinal.setBounds(390, 250, 40, 30);
        jcbdiaFinal.setBounds(430, 250, 50, 30);
        
        jbcancelar.setBounds(270, 330, 100, 30);
        jbcrear.setBounds(380, 330, 100, 30);
        
    }
    
    
    public void agregarEventos () {
        
        jbcancelar.addMouseListener(driverEvent);
        jbcrear.addMouseListener(driverEvent);
        
    }
    
    
    public void setVentanaAdmin (VentanaAdministrador adm) {
        
        admin = adm;
        
    }
    
    
    private void verificarFechas(int año, int mes, int dia) throws Exception {

        try {

            if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {

                if (dia > 30) {

                    throw new Exception("Fecha inválida");

                }

            } else if (mes == 2) {

                if (año % 4 == 0) {

                    if (dia > 29) {

                        throw new Exception("Fecha inválida");

                    }

                } else {

                    if (dia > 28) {

                        throw new Exception("Fecha inválida");

                    }

                }

            }


        } catch (Exception ex) {

            System.out.print(ex.getMessage());

        }

    }
    
    
    private void registrarConvocatoria () {
        
        String campos [] = new String[2];
        
        campos[0] = jtfcodigo.getText();
        campos[1] = jtfnombre.getText();
        
        Calendar fechaInicio = new GregorianCalendar();
        
        int añoIni = (Integer)jcbañoInicio.getSelectedItem();
        int mesIni = Integer.parseInt(jcbmesInicio.getSelectedItem().toString());
        int diaIni = Integer.parseInt(jcbdiaInicio.getSelectedItem().toString());
        
        fechaInicio.set(añoIni, mesIni, diaIni);
        
        Calendar fechaFinal = new GregorianCalendar();
        
        int añoFin = (Integer)jcbañoFinal.getSelectedItem();
        int mesFin = Integer.parseInt(jcbmesFinal.getSelectedItem().toString());
        int diaFin = Integer.parseInt(jcbdiaFinal.getSelectedItem().toString());
        
        fechaFinal.set(añoFin, mesFin, diaFin);
        
        if (!fechaFinal.after(fechaInicio)) {
            
            JOptionPane.showMessageDialog(this, "La fecha de finalización debe ser posterior a la fecha de inicio", "Error", JOptionPane.ERROR_MESSAGE);
            
        }
        
        else {
            
            if (fechaInicio.after(Calendar.getInstance()))
            
                try {
                    
                    verificarFechas(añoFin, mesFin, diaFin);
                    verificarFechas(añoIni, mesIni, diaIni);

                    validar.validateEmptyFields(campos);

                    String fechafin = añoFin + "/" + mesFin + "/" + diaFin;
                    String fechaini = añoIni + "/" + mesIni + "/" + diaIni;

                    controlaConvocatoria.guardarConvocatoria(campos[1], fechaini, fechafin, "abierta", campos[0], admin.getUsuario());

                } catch (MyException ex) {

                    JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);

                } catch (Exception ex) {
                    
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    
                }
            
            else {
                
                JOptionPane.showMessageDialog(this, "La fecha de inicio no debe ser anterior a la fecha actual", "Error", JOptionPane.ERROR_MESSAGE);
                
            }
            
        }
        
    }
    
    
    private class ManejarEventos implements KeyListener, MouseListener {

        @Override
        public void keyTyped(KeyEvent e) {
            
            
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
            
            
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
            
            
            
        }

        @Override
        public void mouseClicked(MouseEvent me) {
            
            if (jbcancelar == me.getSource()) {
                
                admin.setVisible(true);
                dispose();
                
            }
            
            else if (jbcrear == me.getSource()) {
                
                registrarConvocatoria();
                admin.setVisible(true);
                dispose();
                
            }
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
            
            
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
            
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
            
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
            
                    
        }
        
    }
    
}
