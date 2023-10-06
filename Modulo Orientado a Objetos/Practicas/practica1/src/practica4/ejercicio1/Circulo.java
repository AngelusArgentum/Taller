/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4.ejercicio1;
public class Circulo extends Figura{
    private double radio;
    
    @Override
    public double calcularPerimetro(){
        return 3.14*2*radio;
    }
    
    @Override
    public double calcularArea(){
        return 3.14*radio*radio;
    }

    public Circulo(double radio, String colorRelleno, String colorLinea) {
        super(colorRelleno, colorLinea);
        this.radio = radio;
    }

    
    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }
    
    @Override
    public String toString(){
        String aux;
        aux= "Radio: "+radio+". Datos extra: "+super.toString();
        return aux;
    }
    
}
