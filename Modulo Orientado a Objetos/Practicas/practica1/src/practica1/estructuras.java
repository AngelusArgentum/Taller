/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import PaqueteLectura.*;

/**
 *
 * @author Mateo Matus
 */
public class estructuras {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // Ejemplos de todas las estructuras de control.
        
        System.out.println("Ingrese el primer número a comparar.");
        int numeroUno=Lector.leerInt();
        System.out.println("Ingrese el segundo número a comparar.");
        int numeroDos=Lector.leerInt();
        System.out.println("Se avisará la relación entre ambos números...");
        
        //Estructura de selección "if".
        if (numeroUno > numeroDos) {
            System.out.println("El primer número es el mayor.");
        }   else if (numeroUno == numeroDos) {
            System.out.println("Los dos números son iguales.");
        }   else{
            System.out.println("El primer número es el menor.");
        }
        //Las llaves delimitan la condición y las sentencias, se termina con otra }.
        
        //Estructura de selección "case" o "switch".
        System.out.println("¿Qué número de día de semana es hoy?");
        int dia=Lector.leerInt();
        switch (dia) {
            case 1:
                System.out.println("Hoy es lunes.");
                break;
            case 2:
                System.out.println("Hoy es martes.");
                break;
            case 3:
                System.out.println("Hoy es miércoles.");
                break;
            case 4:
                System.out.println("Hoy es miércoles.");
                break;
            case 5:
                System.out.println("Hoy es miércoles.");
                break;
            case 6:
                System.out.println("Hoy es miércoles.");
                break;
            case 7:
                System.out.println("Hoy es miércoles.");
                break;
            default:
                System.out.println("No se ingresó un número dentro del rango de días de la semana (1-7)");
        }
        
        
        //Estructura de Iteración pre-condicional (while)
        int condWhile=3;
        while (condWhile!=1){
            System.out.println("El número "+ condWhile + " es diferente de 1");
            condWhile--;
        }
        
        //Estructura de Iteración post-condicional (repeat until)
        int condRepeat=1;
        do{
            System.out.println("El número es igual al corte de condición (1), pero se ejecuta igual una vez");
        } while (condRepeat!=1);
        
        //Estructura de repetición (for)
        for (int i=1; i<=5; i++){
            System.out.println("El índice actual se encuentra en "+i+".");
              
        }
        
        //DECLARAR dimF y VECTOR: int DF = tamañoDF;   tipoDeDato [] nombre = new int [DF]
        int DF=10; //elementos del 0 al 9 (se toman 10 numeros)
        int [] vectorEnteros = new int [DF]; //inicializo todas las posiciones.
        
        
    } //    Llave de fin de public static void.
} //     Llave de class.
