package practica4.ejercicio2;

public class Jugador extends Empleado {
    private int cantGames,goles;

    public Jugador(int cantGames, int goles, String nombre, double sueldo, int antiq) {
        super(nombre, sueldo, antiq);
        this.cantGames = cantGames;
        this.goles = goles;
    }
    
    @Override 
    public String toString(){
        String aux;
        aux=super.toString()+"Cantidad de partidos y goles del jugador: "+getCantGames()+", "+getGoles()+". "+ "Sueldo a cobrar: "+calcularSueldoACobrar()+".";
        return aux;
    }
    
    @Override 
    public double calcularSueldoACobrar(){
        if (calcularEfectividad()>0.5)
            return super.calcularSueldoACobrar()*2;
        else
            return super.calcularSueldoACobrar();
    }
    
    @Override
    public double calcularEfectividad(){
        return this.goles/this.cantGames;
    }
    
    public int getCantGames() {
        return cantGames;
    }

    public void setCantGames(int cantGames) {
        this.cantGames = cantGames;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }
  
}
