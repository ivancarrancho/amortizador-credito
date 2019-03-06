/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radial;

/**
 *
 * @author Administrator
 */
public class Numeros {


    
    private int numero;
    private double grados;
    private double angRadianes;

    Numeros(String parameter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getGrados() {
        return grados;
    }

    public void setGrados(double grados) {
        this.grados = grados;
    }

    public double getAngRadianes() {
        return angRadianes;
    }

    public void setAngRadianes(double angRadianes) {
        this.angRadianes = angRadianes;
    }
    
     public Numeros(int numero, double grados, double angRadianes) {
        this.numero = numero;
        this.grados = grados;
        this.angRadianes = angRadianes;
    }   
    
}
