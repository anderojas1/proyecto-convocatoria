/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

/**
 *
 * @author jhonkrave
 */
public class ViewValidator {
    
       /**
     * validateEmptyFields Metodo encargado de validar que los campos no sean vacios.
     * @param data Un arreglo de String que contiene los campos.
     * @throws MyException Lanza Exceptiones de tipo MyException.
     */
    public void validateEmptyFields(String[] data) throws MyException {
        
        for (String data1 : data) {
            
            validateEmptyField(data1);
            
        }
        
    }
    
    
    
    /**
     * validateEmptyField Metodo encargado de validar que un campo no este vacio.
     * @param datum Dato dato a evalidar.
     * @throws MyException 
     */
    public void validateEmptyField (String datum) throws MyException {
        
        if("".equals(datum)){
            
            throw new MyException("Se deben completar todos los campos marcados con *");
            
        }
        
    }
    
     /**
     * validateInteger Metodo encargado de validar que un dato sea entero.
     * @param datum Dato.
     * @throws NumberFormatException 
     */
    public void validateInteger(String dato) throws NumberFormatException{
        
        int integerDatum = Integer.parseInt(dato);
    } 
    
    /**
     * validatePass Metodo encargado de validar que las contraseñas coincidan
     * @param pass1 String pass1
     * @param pass2 String pass2
     * @throws MyException 
     */
    public void validatePass(String pass1, String pass2) throws MyException {
    
        if(!pass1.equals(pass2)){
            
            throw new MyException("Las contraseñas deben coincidir");
            
        }
        
    }
    
}
