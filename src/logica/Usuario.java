/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author jorgeaer
 */
public class Usuario {
    
    private String nombreUno;
    private String nombreDos;
    private String apellidoUno;
    private String apellidoDos;
    private String username;
    private String password;
    private String tipoIdentificacion;
    private String identificacion;
    private boolean estado;
    private boolean empleo;
    private String tipo;

    public Usuario(String nombre1, String nombre2, String apellido1, String apellido2, 
            String tipoID, String user, String pass, String id, String cargo) {
        
        nombreUno = nombre1;
        nombreDos = nombre2;
        apellidoUno = apellido1;
        apellidoDos = apellido2;
        username = user;
        password = pass;
        tipoIdentificacion = tipoID;
        identificacion = id;
        estado = false;
        empleo = true;
        tipo = cargo;
        
    }
    
    
    public void editarNombreUno (String nombre) {
        
        nombreUno = nombre;
        
    }
    
    public void editarNombreDos (String nombre) {
        
        nombreDos = nombre;
        
    }
    
    public void editarApellidoUno (String apellido) {
        
        apellidoUno = apellido;
        
    }
    
    public void editarApellidoDos (String apellido) {
        
        apellidoDos = apellido;
        
    }
    
    public void editarPassword (String contraseña) {
        
        password = contraseña;
        
    }    
    
    public void setEstado (boolean estado_sistema) {
        
        estado = estado_sistema;
        
    }
    
    public void setEmpleado (boolean estado_empleo) {
        
        empleo = estado_empleo;
        
    }
    
    
    public String getNombreUno () {
        
        return nombreUno;
        
    }
    
    public String getNombreDos () {
        
        return nombreDos;
        
    }
    
    public String getApellidoUno () {
        
        return apellidoUno;
        
    }
    
    public String getApellidoDos () {
        
        return apellidoDos;
        
    }
    
    public String getUsername () {
        
        return username;
        
    }
    
    public String getPassword () {
        
        return password;
        
    }
    
    public String getTipoIdentificacion () {
        
        return tipoIdentificacion;
        
    }
    
    public String getIdentificacion () {
        
        return identificacion;
        
    }
    
    public boolean getEstadoEmpleo () {
        
        return empleo;
        
    }
    
    public boolean getEstado () {
        
        return estado;
        
    }
    
    
    public String getTipo () {
        
        return tipo;
        
    }
    
}
