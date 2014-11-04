package Gui;

import controlador.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class VentanaRegDatoPersona extends JFrame {

    //declaracion de los atributos de la clase
    private JLabel lbPrimerNom;
    private JLabel lbSegundoNom;
    private JLabel lbPrimerApell;
    private JLabel lbSegundoApell;
    private JLabel lbTipoDocumen;
    private JLabel lbMunicipio;
    private JLabel lbJorTrabajo;
    private JLabel lbFechaNaci;
    private JLabel lbNumeroCel;
    private JLabel lbNumeroDoc;
    private JLabel lbSexo;
    private JLabel lbLugarResiden;
    private JLabel lbLugarNacimiento;
    private JLabel lbTitulo;
    private JTextField campoPNombre;
    private JTextField campoSNombre;
    private JTextField campoPApelli;
    private JTextField campoSApelli;
    private JTextField campoNumIdent;
    private JTextField campoNumCel;
    private JComboBox comboMunicipio;
    private JComboBox comboJorTrabajo;
    private JComboBox comboTipoDoc;
    private JComboBox comboSexo;
    private JComboBox comboLugResi;
    private JComboBox comboLugNaci;
    //Combox de la fecha modificar a calendario
    private JComboBox comboDia;
    private JComboBox comboMes;
    private JComboBox comboAnio;
    
    private JButton btCancelar;
    private JButton btSiguient;
    //declaracion paneles
    private JPanel panelPrin;
    //declaracion objetos de control
    private ManejaEventos manejador;
    private DriverAspirante contAspirante;
    private ViewValidator validator;
    
    private VentanaPrincipalDigitador ventana_digitador;

    //Constructor de la Clase 
    public VentanaRegDatoPersona() {

        super("Registro Nuevo Aspirante");

        iniciarComponentes();
        agregarComponentes();
        acomodarComponentes();
        //asignarEventos();
        

        getContentPane().add(panelPrin);
        setSize(new Dimension(900, 450));
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(0);

    }

    public final void iniciarComponentes() {

        contAspirante = new DriverAspirante();
        validator = new ViewValidator();

        lbPrimerNom = new JLabel("Primer Nombre *");
        lbSegundoNom = new JLabel("Segundo Nombre");
        lbPrimerApell = new JLabel("Primer Apellido *");
        lbSegundoApell = new JLabel("Segundo Apellido");
        lbTipoDocumen = new JLabel("Tipo de Documento *");
        lbNumeroCel = new JLabel("Numero de Celular*");
        lbFechaNaci = new JLabel("Fecha Nacimiento *");
        lbJorTrabajo = new JLabel("Jornada de Trabajo*");
        lbMunicipio = new JLabel("Municipio *");
        lbNumeroDoc = new JLabel("Numero Documento*");
        lbSexo = new JLabel("Sexo*");
        lbLugarResiden = new JLabel("Lugar Residencia*");
        lbLugarNacimiento = new JLabel("Lugar Nacimiento*");
        lbTitulo = new JLabel("INFORMACION PERSONAL");

        campoPNombre = new JTextField("Primer Nombre");
        campoSNombre = new JTextField("Segundo Nombre");
        campoPApelli = new JTextField("Primer Apellido");
        campoSApelli = new JTextField("Segundo Apellido");
        campoNumIdent = new JTextField("Numero Documento");
        campoNumCel = new JTextField("(+57) 313-444-33-11");

        comboTipoDoc = new JComboBox();
        comboTipoDoc.addItem("Cedula Ciudadania");
        comboTipoDoc.addItem("Cedula Extranjeria");

        comboJorTrabajo = new JComboBox();
        comboJorTrabajo.addItem("Mañana");
        comboJorTrabajo.addItem("Tarde");
        comboJorTrabajo.addItem("Ambas");
        
        comboLugNaci = new JComboBox();
        comboLugNaci.addItem("Alcalá");
        comboLugNaci.addItem("Andalucía");
        comboLugNaci.addItem("Ansermanuevo");
        comboLugNaci.addItem("Argelia");
        comboLugNaci.addItem("Bolívar");
        comboLugNaci.addItem("Buenaventura");
        comboLugNaci.addItem("Buga");
        comboLugNaci.addItem("Bugalagrande");
        comboLugNaci.addItem("Caicedonia");
        comboLugNaci.addItem("Cali");
        comboLugNaci.addItem("Candelaria");
        comboLugNaci.addItem("Cartago");
        comboLugNaci.addItem("Dagua");
        comboLugNaci.addItem("Calima-El Darién");
        comboLugNaci.addItem("El Águila");
        comboLugNaci.addItem("El Cairo");
        comboLugNaci.addItem("El Cerrito");
        comboLugNaci.addItem("El Dovio");
        comboLugNaci.addItem("Florida");
        comboLugNaci.addItem("Ginebra");
        comboLugNaci.addItem("Guacarí");
        comboLugNaci.addItem("Jamundí");
        comboLugNaci.addItem("La Cumbre");
        comboLugNaci.addItem("La Unión");
        comboLugNaci.addItem("La Victoria");
        comboLugNaci.addItem("Obando");
        comboLugNaci.addItem("Palmira");
        comboLugNaci.addItem("Pradera");
        comboLugNaci.addItem("Restrepo");
        comboLugNaci.addItem("Riofrío");
        comboLugNaci.addItem("Roldanillo");
        comboLugNaci.addItem("San Pedro");
        comboLugNaci.addItem("Sevilla");
        comboLugNaci.addItem("Toro");
        comboLugNaci.addItem("Trujillo");
        comboLugNaci.addItem("Tuluá");
        comboLugNaci.addItem("Ulloa");
        comboLugNaci.addItem("Versalles");
        comboLugNaci.addItem("Vijes");
        comboLugNaci.addItem("Yotoco");
        comboLugNaci.addItem("Yumbo");
        comboLugNaci.addItem("Zarzal");
        
        
        comboLugResi = new JComboBox();
        comboLugResi.addItem("Alcalá");
        comboLugResi.addItem("Andalucía");
        comboLugResi.addItem("Ansermanuevo");
        comboLugResi.addItem("Argelia");
        comboLugResi.addItem("Bolívar");
        comboLugResi.addItem("Buenaventura");
        comboLugResi.addItem("Buga");
        comboLugResi.addItem("Bugalagrande");
        comboLugResi.addItem("Caicedonia");
        comboLugResi.addItem("Cali");
        comboLugResi.addItem("Candelaria");
        comboLugResi.addItem("Cartago");
        comboLugResi.addItem("Dagua");
        comboLugResi.addItem("Calima-El Darién");
        comboLugResi.addItem("El Águila");
        comboLugResi.addItem("El Cairo");
        comboLugResi.addItem("El Cerrito");
        comboLugResi.addItem("El Dovio");
        comboLugResi.addItem("Florida");
        comboLugResi.addItem("Ginebra");
        comboLugResi.addItem("Guacarí");
        comboLugResi.addItem("Jamundí");
        comboLugResi.addItem("La Cumbre");
        comboLugResi.addItem("La Unión");
        comboLugResi.addItem("La Victoria");
        comboLugResi.addItem("Obando");
        comboLugResi.addItem("Palmira");
        comboLugResi.addItem("Pradera");
        comboLugResi.addItem("Restrepo");
        comboLugResi.addItem("Riofrío");
        comboLugResi.addItem("Roldanillo");
        comboLugResi.addItem("San Pedro");
        comboLugResi.addItem("Sevilla");
        comboLugResi.addItem("Toro");
        comboLugResi.addItem("Trujillo");
        comboLugResi.addItem("Tuluá");
        comboLugResi.addItem("Ulloa");
        comboLugResi.addItem("Versalles");
        comboLugResi.addItem("Vijes");
        comboLugResi.addItem("Yotoco");
        comboLugResi.addItem("Yumbo");
        comboLugResi.addItem("Zarzal");
        
        
        comboMunicipio = new JComboBox();
        comboMunicipio.addItem("Alcalá");
        comboMunicipio.addItem("Andalucía");
        comboMunicipio.addItem("Ansermanuevo");
        comboMunicipio.addItem("Argelia");
        comboMunicipio.addItem("Bolívar");
        comboMunicipio.addItem("Buenaventura");
        comboMunicipio.addItem("Buga");
        comboMunicipio.addItem("Bugalagrande");
        comboMunicipio.addItem("Caicedonia");
        comboMunicipio.addItem("Cali");
        comboMunicipio.addItem("Candelaria");
        comboMunicipio.addItem("Cartago");
        comboMunicipio.addItem("Dagua");
        comboMunicipio.addItem("Calima-El Darién");
        comboMunicipio.addItem("El Águila");
        comboMunicipio.addItem("El Cairo");
        comboMunicipio.addItem("El Cerrito");
        comboMunicipio.addItem("El Dovio");
        comboMunicipio.addItem("Florida");
        comboMunicipio.addItem("Ginebra");
        comboMunicipio.addItem("Guacarí");
        comboMunicipio.addItem("Jamundí");
        comboMunicipio.addItem("La Cumbre");
        comboMunicipio.addItem("La Unión");
        comboMunicipio.addItem("La Victoria");
        comboMunicipio.addItem("Obando");
        comboMunicipio.addItem("Palmira");
        comboMunicipio.addItem("Pradera");
        comboMunicipio.addItem("Restrepo");
        comboMunicipio.addItem("Riofrío");
        comboMunicipio.addItem("Roldanillo");
        comboMunicipio.addItem("San Pedro");
        comboMunicipio.addItem("Sevilla");
        comboMunicipio.addItem("Toro");
        comboMunicipio.addItem("Trujillo");
        comboMunicipio.addItem("Tuluá");
        comboMunicipio.addItem("Ulloa");
        comboMunicipio.addItem("Versalles");
        comboMunicipio.addItem("Vijes");
        comboMunicipio.addItem("Yotoco");
        comboMunicipio.addItem("Yumbo");
        comboMunicipio.addItem("Zarzal");
        
        
        comboSexo =  new JComboBox();
        comboSexo.addItem("Hombre");
        comboSexo.addItem("Mujer");
        
        comboDia = new JComboBox();
        
        for(int i = 1; i < 32; i++){
            
            comboDia.addItem(i);
        
        }
        
        comboMes = new JComboBox();
        
        for(int i = 1; i < 13; i++){
            
            comboMes.addItem(i);
        
        }
        
        comboAnio = new JComboBox();
        
        for(int i = 10; i < 97; i++){
            
            comboAnio.addItem("19"+i);
        
        }

              
        btCancelar = new JButton("Cancelar");
        btSiguient = new JButton("Siguiente");


        panelPrin = new JPanel();

        manejador = new ManejaEventos();

    }

    public final void agregarComponentes() {

        panelPrin.add(lbPrimerNom);
        panelPrin.add(lbSegundoNom);
        panelPrin.add(lbPrimerApell);
        panelPrin.add(lbSegundoApell);
        panelPrin.add(lbMunicipio);
        panelPrin.add(lbJorTrabajo);
        panelPrin.add(lbFechaNaci);
        panelPrin.add(lbNumeroCel);
        panelPrin.add(lbNumeroDoc);
        panelPrin.add(lbTipoDocumen);
        panelPrin.add(lbSexo);
        panelPrin.add(lbLugarNacimiento);
        panelPrin.add(lbLugarResiden);
        panelPrin.add(lbTitulo);

        panelPrin.add(campoPNombre);
        panelPrin.add(campoSNombre);
        panelPrin.add(campoPApelli);
        panelPrin.add(campoSApelli);
        panelPrin.add(campoNumCel);
        panelPrin.add(campoNumIdent);

        panelPrin.add(comboJorTrabajo);
        panelPrin.add(comboLugNaci);
        panelPrin.add(comboLugResi);
        panelPrin.add(comboMunicipio);
        panelPrin.add(comboSexo);
        panelPrin.add(comboTipoDoc);
        panelPrin.add(comboDia);
        panelPrin.add(comboMes);
        panelPrin.add(comboAnio);

        panelPrin.add(btSiguient);
        panelPrin.add(btCancelar);

        panelPrin.setLayout(null);
        panelPrin.setBackground(Color.WHITE);

    }

    private void acomodarComponentes() {

        lbTitulo.setBounds(360, 30, 200, 30);

        lbPrimerNom.setBounds(30, 80, 150, 30);
        campoPNombre.setBounds(230, 80, 200, 25);
        lbSegundoNom.setBounds(30, 110, 150, 30);
        campoSNombre.setBounds(230, 110, 200, 25);
        lbPrimerApell.setBounds(30, 140, 150, 30);
        campoPApelli.setBounds(230, 140, 200, 25);
        lbSegundoApell.setBounds(30, 170, 150, 30);
        campoSApelli.setBounds(230, 170, 200, 25);
      
        lbNumeroDoc.setBounds(30, 200, 150, 30);
        campoNumIdent.setBounds(230, 200, 200, 25);
        lbMunicipio.setBounds(30, 230, 150, 30);
        comboMunicipio.setBounds(230, 230, 200, 25);
        lbJorTrabajo.setBounds(30, 260, 150, 30);
        comboJorTrabajo.setBounds(230, 260, 200, 25);
        
        lbFechaNaci.setBounds(470, 80, 150, 30);
        comboDia.setBounds(650, 80, 45, 25);
        comboMes.setBounds(710, 80, 45, 25);
        comboAnio.setBounds(770, 80, 80, 25);        
        
        
        lbNumeroCel.setBounds(470, 110, 150, 30);
        campoNumCel.setBounds(650, 110, 200, 25);
        lbTipoDocumen.setBounds(470, 140, 150, 30);
        comboTipoDoc.setBounds(650, 140, 200, 25);
        
        lbSexo.setBounds(470, 170, 150, 30);
        comboSexo.setBounds(650, 170, 200, 25);
        lbLugarResiden.setBounds(470, 200, 150, 30);
        comboLugResi.setBounds(650, 200, 200, 25);
        lbLugarNacimiento.setBounds(470, 230, 150, 30);
        comboLugNaci.setBounds(650, 230, 200, 25);
       
        btSiguient.setBounds(555, 350, 110, 30);
        btCancelar.setBounds(700, 350, 110, 30);




    }
    

    public void asignarEventos() {

        btCancelar.addMouseListener(manejador);
        campoPNombre.addMouseListener(manejador);
        campoSNombre.addMouseListener(manejador);
        campoPApelli.addMouseListener(manejador);
        campoSApelli.addMouseListener(manejador);
        campoNumIdent.addMouseListener(manejador);
        campoNumCel.addMouseListener(manejador);
    }
    
    public void configurarVentana (VentanaPrincipalDigitador digitador) {
        
        ventana_digitador = digitador;
        
    }
    
    public void guardarInfo(){
        String datos[] = new String[13];
        String datosObligatorios[] = new String[4];
                
                try{
                    
                    datos[0] = campoPNombre.getText();
                    datosObligatorios[0] = datos[0];
                    
                    datos[1] = campoSNombre.getText();
                    
                    datos[2] = campoPApelli.getText();
                    datosObligatorios[1] = datos[2];
                    
                    datos[3] = campoSApelli.getText();
                    
                    datos[4] = campoNumIdent.getText();
                    datosObligatorios[2]=datos[4];
                    
                    datos[5] = (String) comboMunicipio.getSelectedItem();
                    
                    datos[6] = (String) comboJorTrabajo.getSelectedItem();
                    
                    datos[7] = (String )comboDia.getSelectedItem()+"/"+comboMes.getSelectedItem()+"/"+comboAnio.getSelectedItem();
                   
                    datos[8] = campoNumCel.getText();
                    datosObligatorios[3] = datos[8];
                    
                    datos[9] = (String) comboTipoDoc.getSelectedItem();
                    
                    datos[10] = (String) comboSexo.getSelectedItem();
                    
                    datos[11] = (String) comboLugResi.getSelectedItem();
                    
                    datos[12] = (String) comboLugNaci.getSelectedItem();
 
                    
                    validator.validateEmptyFields(datosObligatorios);
                    validator.validateInteger(datos[4]);
                    
                    contAspirante.guardarAspirante(datos[0], datos[1], datos[2], datos[3], datos[4], datos[9], datos[5], datos[10], datos[6], datos[11], datos[7], datos[12], datos[8]);
                    
                }catch(MyException e){
                    
                    JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR CAMPOS", JOptionPane.ERROR_MESSAGE);
                }     
                catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Error en No de identificación: "+e.getMessage(), "ERROR IDENTIFICACION", JOptionPane.ERROR_MESSAGE);
                }
    }

    private class ManejaEventos implements MouseListener{

       

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
                            
            }else if (me.getSource() == campoNumIdent){
            
                if(campoNumIdent.getText().equals("Numero Documento")){
                
                    campoNumIdent.setText("");
                
                }
                                            
            }else if(me.getSource() == campoNumCel){
                
                  if(campoNumCel.getText().equals("(+57) 313-444-33-11")){
                
                    campoNumCel.setText("");
                
                }
                
            }else if (me.getSource() == btSiguient) {

                JOptionPane.showMessageDialog(null, "Se guardara la informacion personal");
                
                
                

            } else if (me.getSource() == btCancelar) {
                
                ventana_digitador.setVisible(true);
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

        //@Override
       /* public void actionPerformed(ActionEvent e) {
            
           // if(e.getSource() == btCancelar){
             //   ventana_digitador.setVisible(true);
              //  dispose();
            //}
            
        }*/
    }

    
}