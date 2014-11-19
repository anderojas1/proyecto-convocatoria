/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import controlador.*;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
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
 * @author kegisan
 */
public class VentanaListadoInscritos extends JFrame {

    private JPanel JPsup, JPtable, JPinf;
    private JLabel JLMensaje, JLmensajecantinscritos;
   
    
    
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

    public VentanaListadoInscritos(Component vis) {

        super("Listado de inscritos");


        initComponets();
        acommodateComponents();

        parentWindow = vis;

        pack();
        this.setSize(600, 500);

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




        JLMensaje = new JLabel("Seleccione la convocatoria");
        JLmensajecantinscritos = new JLabel("Total de inscritos: ");
        
        

    }

    private void acommodateComponents() {

        container = getContentPane();

        container.setLayout(new BorderLayout());

        JPsup.setLayout(new GridLayout(1, 3, 5, 5));

        JPsup.add(JLMensaje);
        JPsup.add(JCBlistConv);
        JPsup.add(JBCargar);


        container.add(JPsup, BorderLayout.NORTH);


        JPtable.setLayout( new BorderLayout());
        
        JPanel JPinscritos = new JPanel();
        
        JPinscritos.setLayout(new BorderLayout());
        JPinscritos.add(JLmensajecantinscritos, BorderLayout.WEST);
       
        
        JPtable.add(JPinscritos, BorderLayout.NORTH);
        
        JScrollPane listBusScrollPane = new JScrollPane();
        listBusScrollPane.setViewportView(tabla);
        JPtable.add(listBusScrollPane, BorderLayout.CENTER);
        
        container.add(JPtable, BorderLayout.CENTER);

        JPinf.setLayout(new BorderLayout());

        JPinf.add(JBback, BorderLayout.EAST);

        container.add(JPinf, BorderLayout.SOUTH);



    }

    private void listarInscritos(String conv) {
        
        
        ArrayList<Object[]> list = controlSuper.getListaAspirantes(conv);

        JLmensajecantinscritos.setText("Total de inscritos: "+String.valueOf(list.size()));


        for (int i = 0; i < list.size(); i++) {

            tableModel.addRow(list.get(i));
        }


    }

    public class EventManager implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == JBCargar) {

                // Se debe limpiar la tabla previamente... 
                
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
}
