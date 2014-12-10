

package AccesoDatos;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import logica.formacionTic;

public class DaoFormacionTic {
    
    private final Fachada fachadaConectar;
    private String sentenciaSql;
    
    private Connection conectar;
    private Statement sentencia;
    private ResultSet registros;
    
    public DaoFormacionTic(){
        fachadaConectar = new Fachada();
    }
    

    
     public void ejecutarSentencia () throws SQLException {
        
        try{
            
            conectar= fachadaConectar.conectar();
            
            sentencia = conectar.createStatement();
            sentencia.executeUpdate(sentenciaSql);
            
            conectar.close();
            
        } catch(SQLException ex) { 
            
            throw ex;
        
        } catch (NullPointerException ex) {
            
            JOptionPane.showMessageDialog(null, "Error en base de datos. No se puede conectar");
            
        }
        
    }
     
     
   private void ejecutarConsulta() throws SQLException {
       
       try{

        conectar = fachadaConectar.conectar();
        sentencia = conectar.createStatement();
        registros = sentencia.executeQuery(sentenciaSql);
        conectar.close();
        
        } catch(SQLException ex) { 
            
            JOptionPane.showMessageDialog(null, "Error en base de datos. Verifique los campos que está ingresando");
        
        } catch (NullPointerException ex) {
            
            JOptionPane.showMessageDialog(null, "Error en base de datos. null");
            
        }

    }
   
       public void crearFormacionTic(formacionTic forT) throws SQLException{
        sentenciaSql="INSERT INTO FormacionTic VALUES ('"+forT.getIdentificacion()+"', '"+forT.getConvocatoria()+"', '"+forT.getTitulo()+
                       "', "+forT.getConsecutivo()+", '"+forT.getSoporte()+"', "+forT.getPuntaje()+", false);";
        
        ejecutarSentencia();
    }
   
     public String consultarSoporte(String identificacion, String titulo, String codigo) throws SQLException{//falta convocatoria
         String soporte="";
         
         sentenciaSql = "SELECT soporte FROM FormacionTic WHERE identificacion ='"+identificacion+"' AND titulo ='"+
                        titulo+"' AND codigo_convocatoria = '"+codigo+"' ;";
         
         ejecutarConsulta();
         
            
            while (registros.next()) {
            
                soporte = registros.getString(1);
                
            }
            
         return soporte;
     }
     
     
     public ArrayList<formacionTic> consultarAspiranteFormacionTic(String identificacion, String codigo) throws SQLException{
         
         ArrayList <formacionTic> formacion= new ArrayList();
         formacionTic formT = new formacionTic();
         
         sentenciaSql = "SELECT * FROM FormacionTic WHERE identificacion ='"+identificacion+"' AND codigo_convocatoria ='"+
                        codigo+"';";
         
         ejecutarConsulta();
         
         while (registros.next()) {
            
                formT.setIdentificacion(registros.getString(1));
                formT.setConvocatoria(registros.getString(2));
                formT.setTitulo(registros.getString(3));
                formT.setConsecutivo(registros.getInt(4));
                formT.setSoporte(registros.getString(5));
                formT.setPuntaje(registros.getInt(6));
                
                formacion.add(formT);
            }
         
         return formacion;
     }
     
     
      public ArrayList<String> consultarAspiranteFormacionTic2(String identificacion, String codigo) throws SQLException{
         
         ArrayList <String> titulos= new ArrayList();
         
         sentenciaSql = "SELECT DISTINCT titulo FROM FormacionTic WHERE identificacion ='"+identificacion+"' AND codigo_convocatoria ='"+
                        codigo+"';";
         
         ejecutarConsulta();
         
         while (registros.next()) {
                
                titulos.add(registros.getString(1));
                System.out.print(registros.getString(1));
            }
         
         return titulos;
     }
      
     public ArrayList<String> consultarConsecutivoFormacion(String identificacion, String codigo, String formacion)throws SQLException{
       
        ArrayList <String> item= new ArrayList();
         
         sentenciaSql = "SELECT DISTINCT consecutivo FROM FormacionTic WHERE identificacion ='"+identificacion+"' AND codigo_convocatoria ='"+
                        codigo+"' AND titulo = '"+formacion+"';";
         
         ejecutarConsulta();
         
         while (registros.next()) {
                
                item.add(registros.getString(1));
            }
         
         return item;
         
     }
     
      
     public int maximoPuntajeInscripcion(String identificacion_aspirante, String codigo_convocatoria) throws SQLException{
         sentenciaSql="SELECT MAX(puntaje) FROM formaciontic WHERE identificacion = '"+identificacion_aspirante+"' AND codigo_convocatoria = '"+codigo_convocatoria+"';";
         int puntaje=0;
         
         try{
            
            conectar= fachadaConectar.conectar();
            
            sentencia = conectar.createStatement();

            registros = sentencia.executeQuery(sentenciaSql);
            
            while (registros.next()) {
            
                puntaje = registros.getInt(1);
                
            }
            
        } catch(SQLException ex) { 
            
            JOptionPane.showMessageDialog(null, "Error en base de datos. No se puede guardar");
        
        } catch (NullPointerException ex) {
            
            JOptionPane.showMessageDialog(null, "Error en base de datos. No se puede conectar");
            
        }
         
         return puntaje;
     }
     
     public void asignarPuntajeInscripcion(String identificacion, String codigo_convocatoria, int nuevo_puntaje, int maximo_puntaje)throws SQLException{
 
         
         if(maximo_puntaje < nuevo_puntaje){
         int diferencia = nuevo_puntaje - maximo_puntaje;
         sentenciaSql="UPDATE AspiranteConvocatoria SET puntajetotal = puntajetotal + "+diferencia+" WHERE identificacion = '"+identificacion+"' AND codigo = '"+codigo_convocatoria+"';";
         ejecutarSentencia();
         }
     }
     
     public void editar(String identificacion, String codigo, String titulo, String soporte)throws SQLException{
         
         sentenciaSql="UPDATE FormacionTic Set soporte = '"+soporte+"' WHERE identificacion ='"+identificacion+"' AND titulo ='"+
                        titulo+"' AND codigo_convocatoria = '"+codigo+"' ;";
         ejecutarSentencia();
     }
}
