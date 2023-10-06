
package practica4.ejercicio4;

public abstract class Figura {
    private String colorRelleno;
    private String colorLinea;

    public Figura(String colorRelleno, String colorLinea) {
        this.colorRelleno = colorRelleno;
        this.colorLinea = colorLinea;
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
    
    @Override
    public String toString(){
        String aux;
        aux="Color de línea de la figura: "+getColorLinea()+", color de relleno:  "+getColorRelleno()+". ";
        return aux;
    }
    
}
