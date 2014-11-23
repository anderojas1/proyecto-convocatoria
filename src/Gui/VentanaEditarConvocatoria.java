/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import com.toedter.calendar.*;
import controlador.DriverConvocatoria;
import java.awt.Font;
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
    private JLabel jlCodigo;
    private JLabel jlEstado;
    private JLabel jlFechaCrecion;

    private JTextField jtfNombre;
    private JTextField jtfCodigo;
    private JTextField jtfFechaCreacion;

    private JTextArea jtaDescripcion;
    private JScrollPane desplazador;

    private JCheckBoxMenuItem jchbAbierta;
    private JCheckBoxMenuItem jchbCerrada;
    private JCheckBoxMenuItem jchbFinalizada;
    private JCheckBoxMenuItem jchbSuspendida;

    private JDateChooser escogerFechaFin;

    private JComboBox<String> convocatorias;

    private JButton jbEditar;
    private JButton jbCancelar;
    private JButton jbActualizar;

    private JPanel panel;

    private final ViewValidator validador;
    private final DriverConvocatoria controlador;
    private final ManejadorEventos driver;
    private VentanaAdministrador admin;
    
    private GregorianCalendar fechaFinal;

    public VentanaEditarConvocatoria() {

        super("Edición de convocatoria");

        validador = new ViewValidator();
        controlador = new DriverConvocatoria();
        driver = new ManejadorEventos();

        inicializarComponentes();
        adicionarComponentes();
        acomodarComponentes();
        asignarEventos();
        habilitarEdicion(false);

        setSize(1010, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(0);

    }

    public void setVentanaAdmin(VentanaAdministrador interfaz) {

        admin = interfaz;

    }

    private void inicializarComponentes() {

        panel = new JPanel(null);

        jlTitulo = new JLabel("Editar Convocatoria");

        jlConvocatoria = new JLabel("Convocatoria");
        convocatorias = new JComboBox<>();

        jbEditar = new JButton("Editar convocatoria");

        jlNuevoNombre = new JLabel("Nombre");
        jtfNombre = new JTextField();

        jlCodigo = new JLabel("Código");
        jtfCodigo = new JTextField();

        jlNuevaDescripcion = new JLabel("Descripción");
        jtaDescripcion = new JTextArea();
        desplazador = new JScrollPane(jtaDescripcion);

        jlEstado = new JLabel("Estado de convocatoria");
        jchbAbierta = new JCheckBoxMenuItem("Convocatoria abierta");
        jchbCerrada = new JCheckBoxMenuItem("Convocatoria cerrada");
        jchbFinalizada = new JCheckBoxMenuItem("Convocatoria finalizada");
        jchbSuspendida = new JCheckBoxMenuItem("Convocatoria suspendida");

        jlFechaCrecion = new JLabel("Fecha creación");
        jlFechaCrecion.setFont(new Font("Arial", 1, 11));
        jtfFechaCreacion = new JTextField();

        jlNuevaFecha = new JLabel("Fecha cierre");
        escogerFechaFin = new JDateChooser();

        jbCancelar = new JButton("Cerrar");
        jbActualizar = new JButton("Actualizar");

    }

    private void adicionarComponentes() {

        getContentPane().add(panel);

        panel.add(jlTitulo);

        panel.add(jlConvocatoria);
        panel.add(convocatorias);

        panel.add(jbEditar);

        panel.add(jlNuevoNombre);
        panel.add(jtfNombre);

        panel.add(jlCodigo);
        panel.add(jtfCodigo);

        panel.add(jlNuevaDescripcion);
        panel.add(desplazador);

        panel.add(jlEstado);
        panel.add(jchbAbierta);
        panel.add(jchbSuspendida);
        panel.add(jchbFinalizada);
        panel.add(jchbCerrada);

        panel.add(jlFechaCrecion);
        panel.add(jtfFechaCreacion);

        panel.add(jlNuevaFecha);
        panel.add(escogerFechaFin);

        panel.add(jbCancelar);
        panel.add(jbActualizar);

    }

    private void acomodarComponentes() {

        jlTitulo.setBounds(200, 20, 280, 30);

        jlConvocatoria.setBounds(50, 70, 100, 30);
        convocatorias.setBounds(160, 70, 320, 30);
        convocatorias.addItemListener(driver);

        jbEditar.setBounds(650, 70, 200, 30);

        jlNuevoNombre.setBounds(50, 150, 100, 30);
        jtfNombre.setBounds(160, 150, 320, 30);

        jlCodigo.setBounds(530, 150, 100, 30);
        jtfCodigo.setBounds(640, 150, 320, 30);
        jtfCodigo.setEnabled(false);

        jlNuevaDescripcion.setBounds(50, 200, 100, 30);
        desplazador.setBounds(160, 200, 320, 150);

        jlEstado.setBounds(530, 200, 200, 30);
        jchbAbierta.setBounds(580, 230, 200, 30);
        jchbSuspendida.setBounds(580, 260, 200, 30);
        jchbFinalizada.setBounds(580, 290, 200, 30);
        jchbCerrada.setBounds(580, 320, 200, 30);

        jlFechaCrecion.setBounds(50, 370, 100, 30);
        jtfFechaCreacion.setBounds(160, 370, 320, 30);
        jtfFechaCreacion.setEnabled(false);

        jlNuevaFecha.setBounds(530, 370, 100, 30);
        escogerFechaFin.setBounds(640, 370, 320, 30);

        jbCancelar.setBounds(250, 470, 110, 30);
        jbActualizar.setBounds(370, 470, 110, 30);
        jbActualizar.setEnabled(false);

    }

    public void asignarEventos() {

        jbEditar.addMouseListener(driver);
        jbCancelar.addMouseListener(driver);

    }

    public void habilitarEdicion(boolean editar) {
        
        if (editar == true) {
        
            jbEditar.removeMouseListener(driver);
            jbEditar.setEnabled(false);
            jbActualizar.setEnabled(true);
            jbActualizar.addMouseListener(driver);
            
            jchbAbierta.addMouseListener(driver);
            jchbCerrada.addMouseListener(driver);
            jchbFinalizada.addMouseListener(driver);
            jchbSuspendida.addMouseListener(driver);
            
        }
        
        else {
            
            jbEditar.setEnabled(true);
            jbEditar.addMouseListener(driver);
            jbActualizar.removeMouseListener(driver);
            jbActualizar.setEnabled(false);
            
            jchbAbierta.removeMouseListener(driver);
            jchbCerrada.removeMouseListener(driver);
            jchbFinalizada.removeMouseListener(driver);
            jchbSuspendida.removeMouseListener(driver); 
            
        }
        
        jtfNombre.setEnabled(editar);
        escogerFechaFin.setEnabled(editar);
        jtaDescripcion.setEnabled(editar);
        
        jchbAbierta.setEnabled(editar);
        jchbCerrada.setEnabled(editar);
        jchbFinalizada.setEnabled(editar);
        jchbSuspendida.setEnabled(editar);

    }

    private void consultarConvocatoriasVigentes() {

        try {

            ArrayList<String> nombresConvocatorias = controlador.consultarConvocatorias();

            for (int i = 0; i < nombresConvocatorias.size(); i++) {

                convocatorias.addItem(nombresConvocatorias.get(i));

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            dispose();

        }

    }

    public void llenarCampos() {

        String nombreConvocatoria = convocatorias.getSelectedItem().toString();

        try {
            
            String datos[] = controlador.consultaDatosConvocatoria(nombreConvocatoria);
            
            jtfCodigo.setText(datos[0]);
            jtfNombre.setText(datos[1]);
            jtaDescripcion.setText(datos[2]);
            jtfFechaCreacion.setText(datos[3]);
            escogerFechaFin.setDateFormatString("yyyy-MM-dd");
            String fechafin = datos[4];
            
            StringTokenizer partirFecha = new StringTokenizer(fechafin, "-");
            
            int año = Integer.parseInt(partirFecha.nextToken());
            int mes = Integer.parseInt(partirFecha.nextToken());
            int dia = Integer.parseInt(partirFecha.nextToken());
            
            fechaFinal = new GregorianCalendar(año, mes, dia);
            escogerFechaFin.setCalendar(fechaFinal);
            
            String estado = datos[5];
            
            if (estado.equals("abierta")) jchbAbierta.setSelected(true);
            else if (estado.equals("cerrada")) jchbCerrada.setSelected(true);
            else if (estado.equals("finalizada")) jchbFinalizada.setSelected(true);
            else jchbSuspendida.setSelected(true);
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(this, "Error consultando los detalles de la convocatoria", 
                    "Error en la consulta", JOptionPane.ERROR_MESSAGE);
            
        }
    }

    private class ManejadorEventos implements MouseListener, ItemListener {

        @Override
        public void mouseClicked(MouseEvent e) {

            if (e.getSource() == jbCancelar) {

                dispose();

            } else if (e.getSource() == jbEditar) {

                habilitarEdicion(true);

            } else if (e.getSource() == jchbAbierta) {
                
                jchbCerrada.setSelected(false);
                jchbFinalizada.setSelected(false);
                jchbSuspendida.setSelected(false);
                
            } else if (e.getSource() == jchbCerrada) {
                
                jchbAbierta.setSelected(false);
                jchbFinalizada.setSelected(false);
                jchbSuspendida.setSelected(false);
                
            } else if (e.getSource() == jchbFinalizada) {
                
                jchbAbierta.setSelected(false);
                jchbCerrada.setSelected(false);
                jchbSuspendida.setSelected(false);
                
            } else if (e.getSource() == jchbSuspendida) {
                
                jchbAbierta.setSelected(false);
                jchbFinalizada.setSelected(false);
                jchbCerrada.setSelected(false);
                
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

        @Override
        public void itemStateChanged(ItemEvent e) {

            if (e.getStateChange() == ItemEvent.SELECTED) {

                llenarCampos();

            }

        }

    }

    public static void main(String[] args) {

        VentanaEditarConvocatoria ei = new VentanaEditarConvocatoria();
        ei.consultarConvocatoriasVigentes();

    }

}
