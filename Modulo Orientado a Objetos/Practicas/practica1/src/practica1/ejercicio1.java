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

import PaqueteLectura.Lector;
import PaqueteLectura.GeneradorAleatorio;

public class ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        
         //Ejemplos de estructuras de datos: vector, matriz.
//Vector:
    int DF=11;                                     //Declaro dimensión fisica de 11 elementos (0-10).
    int [] tablaDos = new int [DF]; //Se declara el vector vacío "int[] tablaDos" > Se inicializa con "= new int [DF]".
    GeneradorAleatorio.iniciar();
    //Carga de Vector de multiplos de 2, del 0 al 10.
    for (int j=0; j<DF; j++) {
        tablaDos[j]=2*j;
        int resPos=tablaDos[j];
        System.out.println("El multiplo de 2 por "+j+" es: "+resPos+".");
         }
    System.out.println("El largo del vector de múltiplos de 2 es de: "+tablaDos.length +".");
    //Estructura "for-each". Para cada posición hace lo mismo.
    
    System.out.println("Los múltiplos de dos son:");
    
   for (int r: tablaDos){
        System.out.println(r);  //<<-- for para arrays, imprime (o hace lo indicado) para todas las posiciones.
    }
    
    // Generar números aleatorios (entre 0 y 11) hasta obtener el 11, el número generado debe usarse como índice del vector para imprimir su resultado.
    
    int tuki=-1;
    while (tuki!=11){
        tuki=GeneradorAleatorio.generarInt(12);
        System.out.println("Numero generado: "+tuki+".");
        if (tuki!=11){
            System.out.println("Su múlitplo de 2 correspondiente es: "+ tablaDos[tuki]+".");
            }
        }
    
    }
}
