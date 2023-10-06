
package practica4.ejercicio4;
public class Cuadrado extends Figura {
    private int lado;

    public Cuadrado(int lado, String colorRelleno, String colorLinea) {
        super(colorRelleno, colorLinea);
        this.lado = lado;
    }

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }
    
    @Override
    public String toString(){
        String aux;
        aux=super.toString()+"Largo de cada lado del cuadrado: "+getLado()+".";
        return aux;
    }
    
}
