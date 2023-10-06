
package practica4.ejercicio1;
public class Triangulo extends Figura {
    private double lado1,lado2,lado3;

    public Triangulo(double lado1, double lado2, double lado3, String colorRelleno, String colorLinea) {
        super (colorRelleno, colorLinea);
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    @Override
    public String toString(){
        String aux;
        aux="Lados 1, 2 y 3 respectivamente: "+lado1+", "+lado2+", "+lado3+". "+super.toString();
        return aux;
    }
    
    @Override
    public double calcularArea(){
        double S=(lado1+lado2+lado3)/2;
        double AUX=Math.sqrt(S*(S-lado1)*(S-lado2)*(S-lado3));
        return AUX;
    }
    
    @Override
    public double calcularPerimetro(){
        return lado1+lado2+lado3;
    }
    
    public double getLado1() {
        return lado1;
    }

    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    public double getLado3() {
        return lado3;
    }

    public void setLado3(double lado3) {
        this.lado3 = lado3;
    }
    
}
