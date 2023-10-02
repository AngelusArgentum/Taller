
package practica1;

import PaqueteLectura.*;

public class ejercicio5 {

    public static void main(String args[]) {
/*5- El dueño de un restaurante entrevista a cinco clientes y les pide que califiquen
(con puntaje de 1 a 10) los siguientes aspectos: 
        (0) Atención al cliente.
        (1) Calidad de la comida.
        (2) Precio.
        (3) Ambiente.
    Escriba un programa que lea desde teclado las calificaciones de los cinco clientes
para cada uno de los aspectos y almacene la información en una estructura. Luego
imprima la calificación promedio obtenida por cada aspecto.*/
        int DF=5;
        int DC=4;
        int [][] calificaciones = new int [DF][DC];
        double  [] promedios = new double [DC];
        int i,j;
        double prom=0;
        for (i=0 ; i<DF; i++){
            System.out.println("Cliente "+ (i+1) +", por favor califique nuestro restaurante en los siguientes aspectos: ");
            System.out.print("-> Atención al cliente: "); calificaciones[i][0]=Lector.leerInt(); System.out.println();
            System.out.print("-> Calidad de la comida: "); calificaciones[i][1]=Lector.leerInt(); System.out.println();
            System.out.print("-> Precio: "); calificaciones[i][2]=Lector.leerInt(); System.out.println();
            System.out.print("-> Ambiente: "); calificaciones[i][3]=Lector.leerInt(); System.out.println();
        }
        
        for (j=0; j<DC; j++){
            for (i=0; i<DF; i++){
                prom=prom+calificaciones[i][j];
            }
            promedios[j]=prom/5;
            prom=0;
        }
        
        System.out.println("El promedio de calificaciones de atención al cliente fue: "+promedios[0]+".");
        System.out.println("El promedio de calificaciones de calidad de la comida fue: "+promedios[1]+".");
        System.out.println("El promedio de calificaciones de precio fue: "+promedios[2]+".");
        System.out.println("El promedio de calificaciones de ambiente fue: "+promedios[3]+".");
    }//
}//
