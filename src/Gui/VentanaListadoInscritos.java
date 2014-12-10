/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import controlador.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jhonkrave
 */
public class VentanaListadoInscritos extends JFrame {

    private JPanel JPsup, JPtable, JPinf;
    private JPanel JPprincipal;
    private JLabel JLMensaje, JLmensajecantinscritos, JLtitulo;
   
    JLabel JTtotalinscritos;
    
    private JComboBox JCBlistConv;
    private JScrollPane scrollPane;
    private JButton JBCargar, JBback;
    private JTable tabla;
    private DriverSupervisor controlSuper;
    private DriverConvocatoria controlConv;
    private Container container;
    private Component parentWindow;
    private EventManager eventmanager;
    private DefaultTableModel tableModel;
    private final String[] FIELDS_BALANCE = {"Identificacion", "Nombres", "Apellidos", "Municipio"};
    private final Vector FIELDS_VECTOR = new Vector(Arrays.asList(FIELDS_BALANCE));
    private JLabel JLbienvenido;

    public VentanaListadoInscritos(Component vis) {

        super("Listado de inscritos");


        initComponets();
        acommodateComponents();

        parentWindow = vis;

        pack();
        setSize(new Dimension(900, 650));
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(0);
        this.setVisible(true);
    }

    private void initComponets() {



        controlConv = new DriverConvocatoria();
        controlSuper = new DriverSupervisor();
        eventmanager = new EventManager();

        JCBlistConv = new JComboBox();

        ArrayList<String> ALlistConvo = controlConv.listaConvocatorias();


        for (int i = 0; i < ALlistConvo.size(); i++) {

            JCBlistConv.addItem(ALlistConvo.get(i));

        }



        JPprincipal = new JPanel();
        JBCargar = new JButton("Cargar");
        JBCargar.addActionListener(eventmanager);
        JBback = new JButton("Volver");
        JBback.addActionListener(eventmanager);

        JPsup = new JPanel();
        JPinf = new JPanel();

        JPtable = new JPanel();
        tableModel = new DefaultTableModel(FIELDS_VECTOR, 0);
        tabla = new JTable(tableModel);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);



        JLtitulo = new JLabel(new ImageIcon("src/iconos/encabezado.png"));
        
        JLbienvenido = new JLabel("Informe Total de Inscritos");
        JLbienvenido.setFont(new java.awt.Font ( "Arial" , Font.BOLD, 30 ) );
        
        JLMensaje = new JLabel("Seleccione la convocatoria");
        JLmensajecantinscritos = new JLabel("El total de inscritos:");
        
        JTtotalinscritos = new JLabel();
        

    }

    private void acommodateComponents() {

       JPprincipal.setLayout(null);
       
       

        JPprincipal.add(JLtitulo);
        JLtitulo.setBounds(0, 0, 900, 80);
        
        JPprincipal.add(JLbienvenido);
       JLbienvenido.setBounds(250, 150, 400, 80);

        JPprincipal.add(JLMensaje);
        JLMensaje.setBounds(20, 250, 200, 30);
        
        
        JPprincipal.add(JCBlistConv);
        JCBlistConv.setBounds(240, 250, 100, 30);
        
        
        JPprincipal.add(JBCargar);
        JBCargar.setBounds(350, 250, 100, 30);


        
        JPprincipal.add(JLmensajecantinscritos);
        JLmensajecantinscritos.setBounds(450, 300, 200, 30);
        
        
        JPprincipal.add(JTtotalinscritos);
        JTtotalinscritos.setBounds(750, 300, 45, 30);
        
        
        
        JScrollPane listBusScrollPane = new JScrollPane();
        listBusScrollPane.setViewportView(tabla);
        JPprincipal.add(listBusScrollPane);
        listBusScrollPane.setBounds(20, 350, 860, 220);
        
       

        

        JPprincipal.add(JBback);
        JBback.setBounds(400, 590, 100, 30);

        JPprincipal.setBackground(Color.WHITE);
        
        getContentPane().add(JPprincipal);



    }

    private void listarInscritos(String conv) {
        
        
        ArrayList<Object[]> list = controlSuper.getListaAspirantes(conv);

        JTtotalinscritos.setText(String.valueOf(list.size()));


        for (int i = 0; i < list.size(); i++) {

            tableModel.addRow(list.get(i));
        }




        //JPtable.repaint();

        //container.repaint();

    }

    public class EventManager implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == JBCargar) {

                // Se debe limpiar la tabla previamente... 
                
                JTtotalinscritos.setText("");
                
                int rowCount = tableModel.getRowCount();
                System.out.println(rowCount);
                for (int i = (rowCount - 1); i > -1; i--) {
                    tableModel.removeRow(i);
                }

                String item = (String) JCBlistConv.getSelectedItem();

                String[] conv = item.split(",");

                listarInscritos(conv[0]);
            }

            if (e.getSource() == JBback) {

                dispose();
                parentWindow.setVisible(true);

            }

        }
    }
    
    public static void main(String args[]) {
       VentanaListadoInscritos l = new VentanaListadoInscritos(null);
    }
    
 
}
