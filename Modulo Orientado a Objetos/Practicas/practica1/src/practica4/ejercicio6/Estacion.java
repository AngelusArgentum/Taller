package practica4.ejercicio6;

public class Estacion {
    private String nombre;
    private double latitud, longitud;
    private int añoBase, dimAños;
    private int dimMeses=12;
    Reporte [][] matriz;

    public Estacion(String nombre, double latitud, double longitud, int añoBase, int dimAños) {
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
        this.añoBase = añoBase;
        this.dimAños = dimAños;
        matriz=new Reporte [dimAños][dimMeses];
    }
    
    public void addReporte(Reporte r){
        this.matriz[r.getAño()-añoBase][r.getMes()]=r;
    }  
    
    public void informReporte (int mes, int año){
        this.matriz[año-añoBase][mes].toString();
    }
    
    public void informMaxReporte(){
        Reporte max=new Reporte();
        int i,h;
        for (i=0; i<dimAños; i++)
            for (h=0; h<dimMeses; h++){
                if (matriz[i][h].getTemperatura()>max.getTemperatura())
                    max=matriz[i][h];
            }
        System.out.println(max.toString());
    }
    
    private double promAnual(int i){
        int j=0;
        double prom=0;
        for (j=0; j<dimMeses; j++)
            prom=prom+matriz[i][j].getTemperatura();
        return prom/12;
    }
    
    public String anualToString(){
        int i=0;
        String auxTotal, aux;
        auxTotal="Promedio anual: ";
        for (i=0; i<dimAños; i++){
            aux="\nEl promedio para el año "+(this.añoBase+i)+" es de: "+promAnual(i)+"°C.";
            auxTotal=auxTotal+aux;
        }
        return auxTotal;
    }

}
