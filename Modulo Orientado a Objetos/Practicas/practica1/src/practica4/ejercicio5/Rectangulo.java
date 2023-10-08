
package practica4.ejercicio5;

public class Rectangulo extends Figura {
    private int lado1,lado2;

    public Rectangulo(int lado1, int lado2, String colorRelleno, String colorLinea) {
        super(colorRelleno, colorLinea);
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    public int getLado1() {
        return lado1;
    }

    public void setLado1(int lado1) {
        this.lado1 = lado1;
    }

    public int getLado2() {
        return lado2;
    }

    public void setLado2(int lado2) {
        this.lado2 = lado2;
    }
    
    @Override
    public String toString(){
        String aux;
        aux=super.toString()+"Largo de cada lado del rectangulo: "+getLado1()+" y "+getLado2()+".";
        return aux;
    }
    
}
