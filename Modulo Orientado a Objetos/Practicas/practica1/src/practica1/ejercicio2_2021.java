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
public class ejercicio2_2021 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // Logic
        int numero;
        int numeroOrig;
        int indice;
        //Programa que imprima los factoriales de 1 al 9, luego que solo imprima los pares.
        
        /*
        for (int i=9 ; i>1; i--){
            numeroOrig=i;
            numero=numeroOrig;
            indice=i;
            while (indice>1){
                numero=numero*(indice-1);
                indice--;
            }
            System.out.println("El factorial de "+numeroOrig+" es: "+numero+".");
        }
        System.out.println("El factorial de 1 es: 1");
        */
        
        for (int i=9 ; i>1; i--){
            if (i % 2 == 0){
            numeroOrig=i;
            numero=numeroOrig;
            indice=i;
            while (indice>1){
                numero=numero*(indice-1);
                indice--;
            }
            System.out.println("El factorial de "+numeroOrig+" es: "+numero+".");
        }
    }
    }
}
