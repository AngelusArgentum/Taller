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

    import PaqueteLectura.*;

public class ejercicio1_2021 {

         /* 1- Escriba un programa que imprima en consola el factorial de un número N
(ingresado por teclado, N > 0). Ejemplo: para N=5 debería imprimir 5! = 120 */ 
   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // Cuerpo
        
        System.out.print("Ingrese un número del que se calculará su factorial:");
        int numero=Lector.leerInt();
        int inicial=numero;
        for (int i=(numero-1)  ;  i>1  ;  i--){
            numero=numero*i;
        }
        
        System.out.println("El factorial del numero "+inicial+" es: "+numero+".");
    }
}
