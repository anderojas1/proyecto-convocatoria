package ventanapruebas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.*;

public class VentanaRegUsuario extends JFrame{

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
  
  //declaracion del objeto manejador de eventos
  
  private ManejaEventos manejador;
  
  
  //Constructor de la Clase 
  
  public VentanaRegUsuario(){
  
    super("Registro Nuevo Usuario");
    
    iniciarComponentes();
    agergarComponentes();
    acomodarComponentes();
    asignarEventos();
    
    getContentPane().add(panelPrin);
    setSize(new Dimension(500, 520));
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    
  }
  

public void iniciarComponentes(){

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
  campoNomUsu =  new JTextField("Nombre de Usuario");
  campoIdent = new JTextField("Numero de Identificacion");
  
  passW = new JPasswordField();
  passWC = new JPasswordField();
  
  comboTipoDoc =  new JComboBox();
  comboTipoDoc.addItem("Cedula Ciudadania");
  comboTipoDoc.addItem("Cedula Extranjeria");
  
  comboTipoUsu =  new JComboBox();
  comboTipoUsu.addItem("Supervisor");
  comboTipoUsu.addItem("Digitador");  

  btCancelar = new JButton("Cancelar");
  btAceptar =  new JButton("Aceptar");
  
    
  panelPrin = new JPanel();
  
   
  manejador = new ManejaEventos();
   
  }
  
  
public void agergarComponentes(){

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
    
public void acomodarComponentes(){

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
    
public void asignarEventos(){

    btAceptar.addActionListener(manejador);
    btCancelar.addActionListener(manejador);
    
}
    
    
 private class ManejaEventos implements ActionListener, MouseListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           
            if(e.getSource() == btAceptar){
                
                //ingresar informacion para mandar a la base de datos
                
            }else if(e.getSource() == btCancelar){
            
		dispose();
            
            }
        }

        @Override
        public void mouseClicked(MouseEvent me) {
            
         
        }

        @Override
        public void mousePressed(MouseEvent me) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent me) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent me) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }

}