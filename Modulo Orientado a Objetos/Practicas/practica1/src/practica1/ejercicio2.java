/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

/**
 *
 * @author Mateo Matus
 */

//Paquetes importados:

    import PaqueteLectura.Lector;
    import PaqueteLectura.GeneradorAleatorio;


public class ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // Logic
        
        /*2- Escriba un programa que lea las alturas de los 15 jugadores de un equipo de
básquet y las almacene en un vector. Luego informe:
- la altura promedio
- la cantidad de jugadores con altura por encima del promedio*/
        
        GeneradorAleatorio.iniciar();
        int DF=15;
        double [] jugadores=new double [DF];
        
        for (int i=0;i<DF;i++){
            jugadores[i]=GeneradorAleatorio.generarDouble(272);
            System.out.println("El jugador "+(i+1)+" mide: "+jugadores[i]+".");
        }
        
        double promedioJugadores=0;
        
        for (double j : jugadores){
            promedioJugadores=promedioJugadores+j;
        }
        
        promedioJugadores=promedioJugadores/DF;
        System.out.println("El promedio de altura de los jugadores es de :"+promedioJugadores+".");
    }
}
