/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radial;
import radial.Numeros;

/**
 *
 * @author Administrator
 */
public class Calcular {
 
    public static  boolean calculanum (Numeros numero){
        boolean respuesta=false;
        double [] tamano = new double [90];
      
        
     try {
             
         for(int i=numero.getNumero();i<=90;i++){
           tamano[i] = Math.toRadians(i);           
         }
                     respuesta=true;
         
         }
    
    catch (NumberFormatException e) {
    respuesta=false;
}
    return respuesta;
         
         
        
    
    }
}
    
 

