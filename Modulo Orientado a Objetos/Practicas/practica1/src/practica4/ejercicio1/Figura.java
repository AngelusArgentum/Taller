
package practica4.ejercicio1;

public abstract class Figura {
    private String colorLinea;
    private String colorRelleno;

    public Figura(String colorRelleno, String colorLinea){
        this.colorLinea=colorLinea;
        this.colorRelleno=colorRelleno;
    }
    
    public void despintar(){
        setColorLinea("negro");
        setColorRelleno("blanco");
    }
    
    public String toString(){
        String aux;
        aux= "CR: "+getColorRelleno()+ " CL: "+getColorLinea()+" Perimetro: "+this.calcularPerimetro()+".";
        return aux;
    }
    
    public String getColorLinea() {
        return colorLinea;
    }

    public void setColorLinea(String colorLinea) {
        this.colorLinea = colorLinea;
    }

    public String getColorRelleno() {
        return colorRelleno;
    }

    public void setColorRelleno(String colorRelleno) {
        this.colorRelleno = colorRelleno;
    }
    
    
    public abstract double calcularPerimetro();
    public abstract double calcularArea();
}
