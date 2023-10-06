package practica4.ejercicio2;

public class Entrenador extends Empleado {
    private int champGanados;

        @Override 
    public String toString(){
        String aux;
        aux=super.toString()+"Cantidad de campeonatos ganados del entrenador: "+getChampGanados()+". "+ "Sueldo a cobrar: "+calcularSueldoACobrar()+".";
        return aux;
    }
    
    public int getChampGanados() {
        return champGanados;
    }

    public void setChampGanados(int champGanados) {
        this.champGanados = champGanados;
    }

    public Entrenador(int champGanados, String nombre, double sueldo, int antiq) {
        super(nombre, sueldo, antiq);
        this.champGanados = champGanados;
    }
    
    @Override
    public double calcularSueldoACobrar(){
        int a=getAntiq();
            if (a<=4 && a>0)
                return super.calcularSueldoACobrar()+5000;
            else if (a<=10 && a>4)
                return super.calcularSueldoACobrar()+30000;
            else if (a>10)
                return super.calcularSueldoACobrar()+50000;
            else
                return super.calcularSueldoACobrar();
        }
    
    @Override
    public double calcularEfectividad(){
        return getAntiq()/this.champGanados;
    }
    
}
