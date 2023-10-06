package practica3.ejercicio1;
/*/*1-A- Definir una clase para representar triángulos. Un triángulo se caracteriza por el
tamaño de sus 3 lados (double), el color de relleno (String) y el color de línea (String).
Provea un constructor que reciba todos los datos necesarios para iniciar el objeto.
Provea métodos para:
-> Perímetro
-> Área
-> Get/Setters 
*/
public class Triangulo {
    private double lado1;
    private double lado2;
    private double lado3;
    private String colorRelleno;
    private String colorLinea;
    
    public Triangulo(){
    
    }

    public Triangulo(double lado1, double lado2, double lado3, String colorRelleno, String colorLinea) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
        this.colorRelleno = colorRelleno;
        this.colorLinea = colorLinea;
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

    public String getColorRelleno() {
        return colorRelleno;
    }

    public void setColorRelleno(String colorRelleno) {
        this.colorRelleno = colorRelleno;
    }

    public String getColorLinea() {
        return colorLinea;
    }

    public void setColorLinea(String colorLinea) {
        this.colorLinea = colorLinea;
    }  
    
    private double CalcPerimetro(){
        double AUX=lado1+lado2+lado3;
        return AUX;
   }
    
    private double CalcArea(){
        double cagada=(lado1+lado2+lado3)/2;
        double AUX=Math.sqrt(cagada*(cagada-lado1)*(cagada-lado2)*(cagada-lado3));
        return AUX;
   }
    
    @Override
    public String toString(){
       String aux;
       aux = "El perímetro del triángulo es "+CalcPerimetro()+"cm, y su área es de "+CalcArea()+"cm².";
       return aux;
   }
}
