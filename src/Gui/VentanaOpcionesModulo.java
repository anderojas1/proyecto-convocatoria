package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaOpcionesModulo extends JFrame {

    private Container cont;
    private JPanel panelPrin;
    private JLabel lbEncabezadoAgregar, lbEncabezadoConsultar, lbEncabezadoEditar, lbEncabezadoValidar, lbExpFormador;
    private JButton btForPre, btFormTic, btCono, btIdiomas, btExpFormador, btCancelar;
    private ManejaEventos manejador;
    private int tipo;
    private String usuario;
    private String[] datos_convocatoria;
    private VentanaRegDatoPersona ventanaDatosPersonales;

    public VentanaOpcionesModulo(int tipo, String usuario, String[] datos_convocatoria) {
        super("Aspectos hojas de vida");

        this.tipo = tipo;
        this.usuario = usuario;
        this.datos_convocatoria = datos_convocatoria;

        iniciarComponentes();
        agregarComponentes();
        acomodarComponentes();
        //asignarEventos();


        getContentPane().add(panelPrin);
        setSize(new Dimension(400, 500));
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(0);
    }

    public void iniciarComponentes() {

        panelPrin = new JPanel();

        lbExpFormador = new JLabel("Experiencia como formador en TIC");
        btForPre = new JButton("Formacion: Pregrado - Postgrado");
        btFormTic = new JButton("Formacion en TIC");
        btCono = new JButton("Conocimiento especifico");
        btIdiomas = new JButton("Idiomas");
        btExpFormador = new JButton("Experiencia en Formador");
        btCancelar = new JButton("Cancelar");
        manejador = new ManejaEventos();

        panelPrin.setLayout(null);
        panelPrin.setBackground(Color.WHITE);

        switch (tipo) {
            case 0:
                lbEncabezadoAgregar = new JLabel("Agregar Modulos Hoja de Vida");
                break;
            case 1:
                lbEncabezadoConsultar = new JLabel("consultar Modulos Hoja de Vida");
                break;
            case 2:
                lbEncabezadoEditar = new JLabel("Editar Modulos Hoja de Vida");
                break;
            case 3:
                lbEncabezadoValidar = new JLabel("Validar Modulos Hoja de Vida");
                break;
        }

    }

    public void agregarComponentes() {

        panelPrin.add(lbExpFormador);
        panelPrin.add(btForPre);
        panelPrin.add(btFormTic);
        panelPrin.add(btCono);
        panelPrin.add(btIdiomas);
        panelPrin.add(btExpFormador);
        panelPrin.add(btCancelar);

        switch (tipo) {
            case 0:
                panelPrin.add(lbEncabezadoAgregar);
                break;
            case 1:
                panelPrin.add(lbEncabezadoConsultar);
                break;
            case 2:
                panelPrin.add(lbEncabezadoEditar);

                break;
            case 3:
                panelPrin.add(lbEncabezadoValidar);

                break;
        }

    }

    public void acomodarComponentes() {

        btForPre.setBounds(70, 80, 250, 25);
        btFormTic.setBounds(70, 110, 250, 25);
        btCono.setBounds(70, 140, 250, 25);
        btIdiomas.setBounds(70, 170, 250, 25);
        lbExpFormador.setBounds(70, 220, 250, 20);
        btExpFormador.setBounds(70, 250, 250, 25);
        btCancelar.setBounds(100, 370, 200, 25);

        switch (tipo) {
            case 0:
                lbEncabezadoAgregar.setBounds(90, 10, 250, 20);
                break;
            case 1:
                lbEncabezadoConsultar.setBounds(90, 10, 250, 20);
                break;
            case 2:
                lbEncabezadoEditar.setBounds(90, 10, 250, 20);
                break;
            case 3:
                lbEncabezadoValidar.setBounds(90, 10, 250, 20);
                break;
        }

    }

    public void asignarEventos() {
        btForPre.addActionListener(manejador);
        btFormTic.addActionListener(manejador);
        btCono.addActionListener(manejador);
        btIdiomas.addActionListener(manejador);
        btExpFormador.addActionListener(manejador);
        btCancelar.addActionListener(manejador);
    }

    public void configurarVentana(VentanaRegDatoPersona personal) {//ventana anterior

        ventanaDatosPersonales = personal;

    }

    public void ingresarFormacionTIC() {//Ventana siguiente
        VentanaFormacionTic formacionTic = new VentanaFormacionTic(tipo, usuario, datos_convocatoria);
        formacionTic.agregarEventos();
        formacionTic.configurarVentana(this);
        setVisible(false);
    }

    public void ingresarIdiomas() {//Ventana siguiente
        VentanaInformacionIdiomas idiomas = new VentanaInformacionIdiomas(tipo, usuario, datos_convocatoria);
        idiomas.agregarEventos();
        idiomas.configurarVentana(this);
        setVisible(false);
    }

    public void ingresarPrePos() {//Ventana siguiente
        VentanaInfoPrePos prePos = new VentanaInfoPrePos(tipo, usuario, datos_convocatoria);
        prePos.asignarEventos();
        prePos.configurarVentana(this);
        setVisible(false);
    }

    public void ingresarExpFormadorTIC() {//Ventana siguiente
        ventanaExp_FormadorTIC formadorTic = new ventanaExp_FormadorTIC(tipo, usuario, datos_convocatoria);
        formadorTic.agregarEventos();
        formadorTic.configurarVentana(this);
        setVisible(false);
    }

    public void ingresarConocimientosEspecificos() {

        VentanaConociemientosEspec conocEspecific = new VentanaConociemientosEspec(tipo, usuario, datos_convocatoria);
        conocEspecific.configurarVentana(this);
        setVisible(false);

    }

    private class ManejaEventos implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == btCancelar) {
                ventanaDatosPersonales.setVisible(true);
                ventanaDatosPersonales.validarIdentificación();
                dispose();
            }
            if (e.getSource() == btFormTic) {
                ingresarFormacionTIC();
            }
            if (e.getSource() == btIdiomas) {
                ingresarIdiomas();
            }
            if (e.getSource() == btForPre) {
                ingresarPrePos();
            }

            if (e.getSource() == btExpFormador) {
                ingresarExpFormadorTIC();

            }
            if (e.getSource() == btCono) {

                ingresarConocimientosEspecificos();

            }

        }
    }

    public static void main(String args[]) {
        //VentanaOpcionesModulo ven =  new VentanaOpcionesModulo(0, "1234");
    }
}
