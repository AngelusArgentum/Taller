package practica4.ejercicio6;

public class Reporte {
    private int mes,año;
    private double temperatura=0;

    public Reporte(){
        
    }
    
    public Reporte(int mes, int año, double temperatura) {
        this.mes = mes;
        this.año = año;
        this.temperatura = temperatura;
    }

    public int getMes() {
        return mes;
    }

    public int getAño() {
        return año;
    }

    public double getTemperatura() {
        return temperatura;
    }   
    
    public String toString(){
        String aux;
        aux="En el mes "+this.mes+" del año "+this.año+" se registró la temperatura promedio de: "+this.temperatura+".";
        return aux;
    }
}
