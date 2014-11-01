package Gui;

import controlador.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class VentanaRegUsuario extends JFrame {

    //declaracion de los atributos de la clase
    private JLabel lbPrimerNom;
    private JLabel lbSegundoNom;
    private JLabel lbPrimerApell;
    private JLabel lbSegundoApell;
    private JLabel lbTipoIden;
    private JLabel lbNumIdent;
    private JLabel lbNomUsuario;
    private JLabel lbPassW;
    private JLabel lbPassWC;
    private JLabel lbTipoUsuario;
    private JLabel lbTitulo;
    private JTextField campoPNombre;
    private JTextField campoSNombre;
    private JTextField campoPApelli;
    private JTextField campoSApelli;
    private JTextField campoNomUsu;
    private JTextField campoIdent;
    private JPasswordField passW;
    private JPasswordField passWC;
    private JComboBox comboTipoDoc;
    private JComboBox comboTipoUsu;
    private JButton btCancelar;
    private JButton btAceptar;
    //declaracion paneles
    private JPanel panelPrin;
    //declaracion objetos de control
    private ManejaEventos manejador;
    private DriverUsuario contusuario;
    private DriverUsuario controladorUsuario;
    private ViewValidator validator;

    //Constructor de la Clase 
    public VentanaRegUsuario(boolean inicio) {

        super("Registro Nuevo Usuario");

        controladorUsuario = new DriverUsuario();

        iniciarComponentes(inicio);
        agregarComponentes();
        acomodarComponentes();
        asignarEventos();

        getContentPane().add(panelPrin);
        setSize(new Dimension(500, 520));
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public final void iniciarComponentes(boolean inicio) {

        contusuario = new DriverUsuario();
        validator = new ViewValidator();

        lbPrimerNom = new JLabel("Primer Nombre *");
        lbSegundoNom = new JLabel("Segundo Nombre");
        lbPrimerApell = new JLabel("Primer Apellido *");
        lbSegundoApell = new JLabel("Segundo Apellido");
        lbTipoIden = new JLabel("Tipo de Identificacion *");
        lbNumIdent = new JLabel("Numero de Identificacion *");
        lbNomUsuario = new JLabel("Nombre de Usuario *");
        lbPassW = new JLabel("Contraseña *");
        lbPassWC = new JLabel("Confirmar Contraseña *");
        lbTipoUsuario = new JLabel("Tipo de Usuario *");
        lbTitulo = new JLabel("REGISTRO NUEVO USUARIO");

        campoPNombre = new JTextField("Primer Nombre");
        campoSNombre = new JTextField("Segundo Nombre");
        campoPApelli = new JTextField("Primer Apellido");
        campoSApelli = new JTextField("Segundo Apellido");
        campoNomUsu = new JTextField("Nombre de Usuario");
        campoIdent = new JTextField("Numero de Identificacion");

        passW = new JPasswordField();
        passWC = new JPasswordField();

        comboTipoDoc = new JComboBox();
        comboTipoDoc.addItem("Cedula Ciudadania");
        comboTipoDoc.addItem("Cedula Extranjeria");

        comboTipoUsu = new JComboBox();

        if (inicio == false) {

            comboTipoUsu.addItem("Administrador");

        } else {

            comboTipoUsu.addItem("Supervisor");
            comboTipoUsu.addItem("Digitador");
        }

        btCancelar = new JButton("Cancelar");
        btAceptar = new JButton("Aceptar");


        panelPrin = new JPanel();


        manejador = new ManejaEventos();

    }

    public final void agregarComponentes() {

        panelPrin.add(lbPrimerNom);
        panelPrin.add(lbSegundoNom);
        panelPrin.add(lbPrimerApell);
        panelPrin.add(lbSegundoApell);
        panelPrin.add(lbTipoIden);
        panelPrin.add(lbNumIdent);
        panelPrin.add(lbNomUsuario);
        panelPrin.add(lbPassW);
        panelPrin.add(lbPassWC);
        panelPrin.add(lbTipoUsuario);
        panelPrin.add(lbTitulo);

        panelPrin.add(campoPNombre);
        panelPrin.add(campoSNombre);
        panelPrin.add(campoPApelli);
        panelPrin.add(campoSApelli);
        panelPrin.add(campoNomUsu);
        panelPrin.add(campoIdent);

        panelPrin.add(passW);
        panelPrin.add(passWC);


        panelPrin.add(comboTipoDoc);
        panelPrin.add(comboTipoUsu);

        panelPrin.add(btAceptar);
        panelPrin.add(btCancelar);

        panelPrin.setLayout(null);
        panelPrin.setBackground(Color.WHITE);

    }

    public void acomodarComponentes() {

        lbTitulo.setBounds(160, 30, 200, 30);

        lbPrimerNom.setBounds(30, 80, 150, 30);
        campoPNombre.setBounds(250, 80, 200, 25);
        lbSegundoNom.setBounds(30, 110, 150, 30);
        campoSNombre.setBounds(250, 110, 200, 25);
        lbPrimerApell.setBounds(30, 140, 150, 30);
        campoPApelli.setBounds(250, 140, 200, 25);
        lbSegundoApell.setBounds(30, 170, 150, 30);
        campoSApelli.setBounds(250, 170, 200, 25);
        lbTipoIden.setBounds(30, 200, 150, 30);
        comboTipoDoc.setBounds(250, 200, 200, 25);
        lbNumIdent.setBounds(30, 230, 150, 30);
        campoIdent.setBounds(250, 230, 200, 25);
        lbNomUsuario.setBounds(30, 260, 150, 30);
        campoNomUsu.setBounds(250, 260, 200, 25);
        lbTipoUsuario.setBounds(30, 290, 150, 30);
        comboTipoUsu.setBounds(250, 290, 200, 25);
        lbPassW.setBounds(30, 320, 150, 30);
        passW.setBounds(250, 320, 200, 25);
        lbPassWC.setBounds(30, 350, 150, 30);
        passWC.setBounds(250, 350, 200, 25);

        btAceptar.setBounds(250, 400, 95, 30);
        btCancelar.setBounds(355, 400, 95, 30);




    }

    public void guardar() {

        try {
            
            String[] campos = new String[10];
            String[] camposOblig = new String[5];
            
            campos[0] = campoPNombre.getText();
            camposOblig[0] = campos[0];
            
            campos[1] = campoSNombre.getText();
            
            campos[2] = campoPApelli.getText();
            camposOblig[1] = campos[2];
            
            campos[3] = campoSApelli.getText();
            
            campos[4] = (String) comboTipoDoc.getSelectedItem();
            
            campos[5] = campoIdent.getText();
            camposOblig[2] = campos[5];
            
            campos[6] = campoNomUsu.getText();
            camposOblig[3] = campos[6];
            
            campos[7] = passW.getText();
            camposOblig[4] = campos[7];
            
            campos[8] = passWC.getText();            

            validator.validateEmptyFields(camposOblig);
            validator.validatePass(campos[7], campos[8]);
            validator.validateInteger(campos[5]);

            String tipoUsuario = (String) comboTipoUsu.getSelectedItem();

            contusuario.guardar(campos[0], campos[1], campos[2], campos[3], campos[4], campos[5], campos[6], campos[7], campos[8], tipoUsuario);

            if (tipoUsuario.equalsIgnoreCase("administrador")) {
                
                VentanaLogin nuevoLogin = new VentanaLogin();
                nuevoLogin.addEvents();

                dispose();
                
            } else {
                
                VentanaAdministrador ventanaAdmin = new VentanaAdministrador();
                
                dispose();
                
            }

        } catch (MyException e) {

            JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR CAMPOS", JOptionPane.ERROR_MESSAGE);
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error en No de identificación: "+e.getMessage(), "ERROR IDENTIFICACION", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void asignarEventos() {

        btAceptar.addMouseListener(manejador);
        btCancelar.addMouseListener(manejador);
        campoPNombre.addMouseListener(manejador);
        campoSNombre.addMouseListener(manejador);
        campoPApelli.addMouseListener(manejador);
        campoSApelli.addMouseListener(manejador);
        campoIdent.addMouseListener(manejador);
        campoNomUsu.addMouseListener(manejador);

    }

    private class ManejaEventos implements MouseListener {

       

        @Override
        public void mouseClicked(MouseEvent me) {
            
            if (me.getSource() == campoPNombre){
            
                if(campoPNombre.getText().equals("Primer Nombre")){
                
                    campoPNombre.setText("");
                
                }
                
            }else if (me.getSource() == campoSNombre){
            
                if(campoSNombre.getText().equals("Segundo Nombre")){
                
                    campoSNombre.setText("");
                
                }
                            
            }else if (me.getSource() == campoPApelli){
                
                if(campoPApelli.getText().equals("Primer Apellido")){
                
                    campoPApelli.setText("");
                
                }
                            
            }else if (me.getSource() == campoSApelli){
            
                if(campoSApelli.getText().equals("Segundo Apellido")){
                
                    campoSApelli.setText("");
                
                }
                            
            }else if (me.getSource() == campoIdent){
            
                if(campoIdent.getText().equals("Numero de Identificacion")){
                
                    campoIdent.setText("");
                
                }
                            
            }else if (me.getSource() == campoNomUsu){
            
                if(campoNomUsu.getText().equals("Nombre de Usuario")){
                
                    campoNomUsu.setText("");
                
                }
                            
            }else if (me.getSource() == btAceptar) {

                guardar();

            } else if (me.getSource() == btCancelar) {

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
}