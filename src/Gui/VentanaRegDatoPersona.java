package Gui;

import controlador.*;
import logica.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import java.util.ArrayList;

public class VentanaRegDatoPersona extends JFrame {

    //declaracion de los atributos de la clase
    private JLabel lbEncabezado;
    private JLabel lbFinal;
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
    private JLabel lbConvocatoria;
    private JTextField campoPNombre;
    private JTextField campoSNombre;
    private JTextField campoPApelli;
    private JTextField campoSApelli;
    private JTextField campoNumIdent;
    private JTextField campoNumCel;
    private JTextField campoTipoDoc;
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
    private JComboBox comboConvocatorias;
    
    private JButton btCancelar;
    private JButton btconfirmar;
    private JButton btaceptar;
    //declaracion paneles
    private JPanel panelPrin;
    //declaracion objetos de control
    private ManejaEventos manejador;
    private DriverAspirante contAspirante;
    private DriverConvocatoria contConvocatoria;
    private ViewValidator validator;
    
    private VentanaPrincipalDigitador ventana_digitador;
    
    private boolean validarAsp= false;
    private int tipo;
    private String[] datos_convocatoria;
    boolean guardar=false;

    //Constructor de la Clase 
    public VentanaRegDatoPersona(int tipo) {

        super("Registro Nuevo Aspirante");
        
        this.tipo = tipo;
        iniciarComponentes();
        agregarComponentes();
        acomodarComponentes();
        //asignarEventos();
        

        getContentPane().add(panelPrin);
        setSize(new Dimension(900, 650));
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(0);

    }

    public final void iniciarComponentes() {

        contAspirante = new DriverAspirante();
        contConvocatoria = new DriverConvocatoria();
        validator = new ViewValidator();
        
        lbEncabezado = new JLabel(new ImageIcon ("src/iconos/encabezado.png"));
        lbFinal = new JLabel(new ImageIcon ("src/iconos/piePagina.png"));
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
        lbConvocatoria = new JLabel("Seleccione la convocatoria");
        lbConvocatoria.setVisible(false);

        campoPNombre = new JTextField("");
        campoPNombre.setVisible(false);
        campoSNombre = new JTextField("");
        campoSNombre.setVisible(false);
        campoPApelli = new JTextField("");
        campoPApelli.setVisible(false);
        campoSApelli = new JTextField("");
        campoSApelli.setVisible(false);
        campoNumIdent = new JTextField("");
        campoNumCel = new JTextField("");
        campoNumCel.setVisible(false);
        campoTipoDoc = new JTextField("");
        campoTipoDoc.setVisible(false);

        comboTipoDoc = new JComboBox();
        comboTipoDoc.addItem("Cedula Ciudadania");
        comboTipoDoc.addItem("Cedula Extranjeria");
        

        comboJorTrabajo = new JComboBox();
        comboJorTrabajo.addItem("Mañana");
        comboJorTrabajo.addItem("Tarde");
        comboJorTrabajo.addItem("Ambas");
        comboJorTrabajo.setVisible(false);
        
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
        comboLugNaci.setVisible(false);
        
        
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
        comboLugResi.setVisible(false);
        
        
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
        comboMunicipio.setVisible(false);
        
        
        comboSexo =  new JComboBox();
        comboSexo.setEditable(false);
        comboSexo.addItem("Hombre");
        comboSexo.addItem("Mujer");
        comboSexo.setVisible(false);
        
        comboDia = new JComboBox();
        
        for(int i = 1; i < 32; i++){
            
            comboDia.addItem(i);
        
        }
        comboDia.setVisible(false);
        
        comboMes = new JComboBox();
        
        for(int i = 1; i < 13; i++){
            
            comboMes.addItem(i);
        
        }
        comboMes.setVisible(false);
        
        comboAnio = new JComboBox();
        
        for(int i = 10; i < 97; i++){
            
            comboAnio.addItem("19"+i);
        
        }
        comboAnio.setVisible(false);
        
        comboConvocatorias = new JComboBox();
        comboConvocatorias.setVisible(false);

              
        btCancelar = new JButton("Cancelar");
        btconfirmar = new JButton(new ImageIcon("src/iconos/lupa.jpg"));
        btconfirmar.setBorder(null);
        btaceptar = new JButton("Inscribir");
        btaceptar.setVisible(false);


        panelPrin = new JPanel();

        manejador = new ManejaEventos();
        
        datos_convocatoria = new String[2];

    }

    public final void agregarComponentes() {
        
        panelPrin.add(lbEncabezado);
        panelPrin.add(lbFinal);
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
        panelPrin.add(lbConvocatoria);

        panelPrin.add(campoPNombre);
        panelPrin.add(campoSNombre);
        panelPrin.add(campoPApelli);
        panelPrin.add(campoSApelli);
        panelPrin.add(campoNumCel);
        panelPrin.add(campoNumIdent);
        panelPrin.add(campoTipoDoc);

        panelPrin.add(comboJorTrabajo);
        panelPrin.add(comboLugNaci);
        panelPrin.add(comboLugResi);
        panelPrin.add(comboMunicipio);
        panelPrin.add(comboSexo);
        panelPrin.add(comboTipoDoc);
        panelPrin.add(comboDia);
        panelPrin.add(comboMes);
        panelPrin.add(comboAnio);
        panelPrin.add(comboConvocatorias);

        panelPrin.add(btCancelar);
        panelPrin.add(btconfirmar);
        panelPrin.add(btaceptar);
        

        panelPrin.setLayout(null);
        panelPrin.setBackground(Color.WHITE);

    }

    private void acomodarComponentes() {

        lbEncabezado.setBounds(0,0,900,80);
        lbTitulo.setBounds(360, 110, 200, 30);
        lbFinal.setBounds(0, 570, 900, 80);
        lbTipoDocumen.setBounds(30, 160, 150, 30);
        campoTipoDoc.setBounds(180, 160, 200, 25);
        comboTipoDoc.setBounds(180, 160, 200, 25);
        lbNumeroDoc.setBounds(30, 190, 150, 30);
        campoNumIdent.setBounds(180, 190, 200, 25);
        btconfirmar.setBounds(390, 190, 30, 30);
        lbPrimerNom.setBounds(30, 220, 150, 30);
        campoPNombre.setBounds(180, 220, 200, 25);
        lbSegundoNom.setBounds(30, 250, 150, 30);
        campoSNombre.setBounds(180, 250, 200, 25);
        lbPrimerApell.setBounds(30, 280, 150, 30);
        campoPApelli.setBounds(180, 280, 200, 25);
        lbSegundoApell.setBounds(30, 310, 150, 30);
        campoSApelli.setBounds(180, 310, 200, 25);
        lbSexo.setBounds(30, 340, 150, 30);
        comboSexo.setBounds(180, 340, 200, 25);
       //lbNumeroDoc.setBounds(30, 200, 150, 30);
        //campoNumIdent.setBounds(230, 200, 200, 25);
        
        lbMunicipio.setBounds(470, 160, 150, 30);
        comboMunicipio.setBounds(650, 160, 200, 25);
        lbJorTrabajo.setBounds(470, 190, 150, 30);
        comboJorTrabajo.setBounds(650, 190, 200, 25);
        
        lbFechaNaci.setBounds(470, 220, 150, 30);
        comboDia.setBounds(650, 220, 45, 25);
        comboMes.setBounds(710, 220, 45, 25);
        comboAnio.setBounds(770, 220, 80, 25);        
        
        
        lbNumeroCel.setBounds(470, 250, 150, 30);
        campoNumCel.setBounds(650, 250, 200, 25);
        //lbTipoDocumen.setBounds(470, 140, 150, 30);
        //comboTipoDoc.setBounds(650, 140, 200, 25);
        
        
        lbLugarResiden.setBounds(470, 280, 150, 30);
        comboLugResi.setBounds(650, 280, 200, 25);
        lbLugarNacimiento.setBounds(470, 310, 150, 30);
        comboLugNaci.setBounds(650, 310, 200, 25);
        lbConvocatoria.setBounds(30, 400, 180, 20);
        comboConvocatorias.setBounds(30, 430, 300, 30);
       
        btCancelar.setBounds(700, 430, 110, 30);
        btaceptar.setBounds(580, 430, 110, 30);




    }
    

    public void asignarEventos() {

        btCancelar.addMouseListener(manejador);
        campoPNombre.addMouseListener(manejador);
        campoSNombre.addMouseListener(manejador);
        campoPApelli.addMouseListener(manejador);
        campoSApelli.addMouseListener(manejador);
        campoNumIdent.addMouseListener(manejador);
        campoNumCel.addMouseListener(manejador);
        btconfirmar.addMouseListener(manejador);
        btaceptar.addMouseListener(manejador);
    }
    
    
    public void configurarVentana (VentanaPrincipalDigitador digitador) {//ventana anterior
        
        ventana_digitador = digitador;
        
    }
    
    public void ingresarModulo1(){//Ventana siguiente
         String idAsp = campoNumIdent.getText();
         VentanaInfoPrePos modulo1 = new VentanaInfoPrePos(tipo, idAsp, datos_convocatoria, ventana_digitador);
         modulo1.asignarEventos();
         //modulo1.configurarVentana(this);
         dispose();
     }
    
    public void comboConvocatorias (String identificacion){
        
        ArrayList<String> nombreC = new ArrayList();
        nombreC=contConvocatoria.listaConvocatorias(identificacion);
        int tam=nombreC.size();
        for(int i = 0; i < tam; i++){
            
        comboConvocatorias.addItem(nombreC.get(i));
        }
        
        if (tam == 0){
            comboConvocatorias.addItem("No hay convocatorias por mostrar");
            btaceptar.setVisible(false);
        }
    }
    
    public void habilitarEdicion1(){
 
        String tipDoc=comboTipoDoc.getSelectedItem()+"";
        campoTipoDoc.setText(tipDoc);
        comboTipoDoc.setVisible(false);
        campoTipoDoc.setVisible(true);
        campoTipoDoc.setEditable(false);
        campoNumIdent.setEditable(false);
        campoPNombre.setVisible(true);
        campoSNombre.setVisible(true);
        campoPApelli.setVisible(true);
        campoSApelli.setVisible(true);
        campoNumCel.setVisible(true);
        campoNumCel.setVisible(true);
        comboJorTrabajo.setVisible(true);
        comboLugNaci.setVisible(true);
        comboLugResi.setVisible(true);
        comboMunicipio.setVisible(true);
        comboSexo.setVisible(true);
        comboDia.setVisible(true);
        comboMes.setVisible(true);
        comboAnio.setVisible(true);
        lbConvocatoria.setVisible(true);
        comboConvocatorias.setVisible(true);
        btconfirmar.setVisible(false);
        btaceptar.setVisible(true);
        
        
    }
    
    public void habilitarEdicion2(Aspirante aspi){
 
        String tipDoc=comboTipoDoc.getSelectedItem()+"";
        campoTipoDoc.setText(tipDoc);
        comboTipoDoc.setVisible(false);
        campoTipoDoc.setVisible(true);
        campoTipoDoc.setEditable(false);
        campoNumIdent.setEditable(false);
        
        campoPNombre.setVisible(true);
        campoPNombre.setText(aspi.getP_nombre());
        campoPNombre.setEditable(false);
        
        campoSNombre.setVisible(true);
        campoSNombre.setText(aspi.getS_nombre());
        campoSNombre.setEditable(false);
        
        campoPApelli.setVisible(true);
        campoPApelli.setText(aspi.getP_apellido());
        campoPApelli.setEditable(false);
        
        campoSApelli.setVisible(true);
        campoSApelli.setText(aspi.getS_apellido());
        campoSApelli.setEditable(false);
        
        lbConvocatoria.setVisible(true);
        comboConvocatorias.setVisible(true);
        btaceptar.setVisible(true);
        
        btconfirmar.setVisible(false);
        
        lbNumeroCel.setVisible(false);
        lbFechaNaci.setVisible(false);
        lbJorTrabajo.setVisible(false);
        lbMunicipio.setVisible(false);
        lbSexo.setVisible(false);
        lbLugarResiden.setVisible(false);
        lbLugarNacimiento.setVisible(false);
       
        comboMunicipio.setVisible(false);
        comboJorTrabajo.setVisible(false);
        comboTipoDoc.setVisible(false);
        comboSexo.setVisible(false);
        comboLugResi.setVisible(false);
        comboLugNaci.setVisible(false);
        comboDia.setVisible(false);
        comboMes.setVisible(false);
        comboAnio.setVisible(false);
        
    }
    
    public void validarIdentificación(){
        
        try{
        String[] id = new String[1];
        
        
        id[0]=campoNumIdent.getText();
        validator.validateInteger(id[0]);
        Aspirante asp = contAspirante.consultarAspirante(id[0]);
        if(asp == null){
        habilitarEdicion1();
        comboConvocatorias(id[0]);
        validarAsp = false;
            }
        else{
             validarAsp = true;
             guardar = true;
             habilitarEdicion2(asp);  
             comboConvocatorias(id[0]);
        }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Error en No de identificación: \nIngrese por favor solo numeros \n"+e.getMessage(), "ERROR IDENTIFICACION", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    
    public void guardarAspConv(){
        String convocatoria=comboConvocatorias.getSelectedItem()+"";
        String partes[] = convocatoria.split(",");
        String idAsp=campoNumIdent.getText();;
        String codconv=partes[0];
        datos_convocatoria=partes;
        
        contAspirante.guardarAspiranteConvocatoria(idAsp, codconv);
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
                    
                    datos[7] = comboDia.getSelectedItem().toString()+"/"+comboMes.getSelectedItem().toString()+"/"+ comboAnio.getSelectedItem().toString();
                   
                    datos[8] = campoNumCel.getText();
                    datosObligatorios[3] = datos[8];
                    
                    datos[9] = (String) campoTipoDoc.getText();
                    
                    datos[10] = (String) comboSexo.getSelectedItem();
                    
                    datos[11] = (String) comboLugResi.getSelectedItem();
                    
                    datos[12] = (String) comboLugNaci.getSelectedItem();
 
                    
                    validator.validateEmptyFields(datosObligatorios);
                    validator.validateInteger(datos[4]);
                    guardar=true;
                    contAspirante.guardarAspirante(datos[0], datos[1], datos[2], datos[3], datos[4], datos[9], datos[5], datos[10], datos[6], datos[11], datos[7], datos[12], datos[8]);
                    guardarAspConv();
                 
                
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
                
            } else if (me.getSource() == btCancelar) {
                
                ventana_digitador.setVisible(true);
                dispose();

            }
            
            else if(me.getSource() == btconfirmar){
                validarIdentificación();
                
            }
            
            else if(me.getSource() == btaceptar){
                 if(validarAsp){
                  guardarAspConv();
                 }else{
                     guardarInfo();
                 }        
                 if(guardar){
                 ingresarModulo1();
                 }
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

