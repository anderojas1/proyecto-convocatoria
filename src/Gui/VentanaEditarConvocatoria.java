/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import com.toedter.calendar.*;
import controlador.DriverConvocatoria;
import java.awt.event.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author anderojas
 */
public class VentanaEditarConvocatoria extends JFrame {

    private JLabel jlTitulo;
    private JLabel jlNuevaDescripcion;
    private JLabel jlNuevoNombre;
    private JLabel jlNuevaFecha;
    private JLabel jlConvocatoria;

    private JTextField jtfNombre;

    private JTextArea jtaDescripcion;
    private JScrollPane desplazador;

    private JDateChooser escogerFechaFin;

    private JComboBox<String> convocatorias;

    private JButton jbCancelar;
    private JButton jbEditar;

    private JPanel panel;

    private final ViewValidator validador;
    private final DriverConvocatoria controlador;
    private final ManejadorEventos driver;
    private VentanaAdministrador admin;

    public VentanaEditarConvocatoria() {

        super("Edición de convocatoria");

        validador = new ViewValidator();
        controlador = new DriverConvocatoria();
        driver = new ManejadorEventos();

        inicializarComponentes();
        adicionarComponentes();
        acomodarComponentes();

        setSize(530, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(0);

    }
    
    
    public void setVentanaAdmin (VentanaAdministrador interfaz) {
        
        admin = interfaz;
        
    }

    private void inicializarComponentes() {

        panel = new JPanel(null);

        jlTitulo = new JLabel("Editar Convocatoria");
        
        jlConvocatoria = new JLabel("Convocatoria");
        convocatorias = new JComboBox<>();

        jlNuevoNombre = new JLabel("Nombre");
        jtfNombre = new JTextField();

        jlNuevaDescripcion = new JLabel("Descripción");
        jtaDescripcion = new JTextArea();
        desplazador = new JScrollPane(jtaDescripcion);

        jlNuevaFecha = new JLabel("Fecha cierre");
        escogerFechaFin = new JDateChooser();

        jbCancelar = new JButton("Cancelar");
        jbEditar = new JButton("Actualizar");

    }

    private void adicionarComponentes() {

        getContentPane().add(panel);

        panel.add(jlTitulo);
        
        panel.add(jlConvocatoria);
        panel.add(convocatorias);

        panel.add(jlNuevoNombre);
        panel.add(jtfNombre);

        panel.add(jlNuevaDescripcion);
        panel.add(desplazador);

        panel.add(jlNuevaFecha);
        panel.add(escogerFechaFin);

        panel.add(jbCancelar);
        panel.add(jbEditar);

    }

    private void acomodarComponentes() {

        jlTitulo.setBounds(200, 20, 280, 30);
        
        jlConvocatoria.setBounds(50, 70, 100, 30);
        convocatorias.setBounds(160, 70, 320, 30);
        convocatorias.addMouseListener(driver);
        
        jlNuevoNombre.setBounds(50, 150, 100, 30);
        jtfNombre.setBounds(160, 150, 320, 30);
        jtfNombre.setEnabled(false);
        
        jlNuevaDescripcion.setBounds(50, 200, 100, 30);
        desplazador.setBounds(160, 200, 320, 150);
        jtaDescripcion.setEnabled(false);
        
        jlNuevaFecha.setBounds(50, 370, 100, 30);
        escogerFechaFin.setBounds(160, 370, 320, 30);
        escogerFechaFin.setEnabled(false);
        
        jbCancelar.setBounds(250, 470, 110, 30);
        jbCancelar.addMouseListener(driver);
        jbEditar.setBounds(370, 470, 110, 30);
        jbEditar.setEnabled(false);
        
    }
    
    
    private void consultarConvocatoriasVigentes () {
        
        try {
            
            ArrayList <String> nombresConvocatorias = controlador.consultarConvocatorias();
            
            for (int i = 0; i < nombresConvocatorias.size(); i++) {
                
                convocatorias.addItem(nombresConvocatorias.get(i));
                
            }
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            dispose();
            
        }
    }

    private class ManejadorEventos implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            
            if (e.getSource() == jbCancelar) {
                
                dispose();
                
            } else if (e.getSource() == convocatorias) {
                
                System.out.println("ejecuta");
                
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

    public static void main(String[] args) {

        VentanaEditarConvocatoria ei = new VentanaEditarConvocatoria();
        ei.consultarConvocatoriasVigentes();
        
    }

}
