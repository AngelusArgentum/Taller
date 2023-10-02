/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import PaqueteLectura.*;
public class ejercicio4 {

    /*4- Un edificio de oficinas está conformado por 8 pisos (1..8) y 4 oficinas por piso
(1..4). 
    Realice un programa que permita informar la cantidad de personas que
concurrieron a cada oficina de cada piso. 
    Para esto, simule la llegada de personas al
edificio de la siguiente manera: a cada persona se le pide el nro. de piso y nro. de
oficina a la cual quiere concurrir. 
    La llegada de personas finaliza al indicar un nro.
de piso 9. Al finalizar la llegada de personas, informe lo pedido.*/
    
    public static void main(String args[]) {
        int DF=8;
        int DC=4;
        int [][] edificio=new int [DF][DC];
        int i,j;
        
        for(i=0;i<DF;i++)
            for (j=0; j<DC; j++)
                edificio[i][j]=0;
        
        System.out.print("Ingrese el piso al que quiere ingresar: ");
        i=Lector.leerInt();
        System.out.println();
        if (i!=9) {
            System.out.print("Ingrese a la oficina que quiere ingresar: ");
            j=Lector.leerInt();
            edificio[i-1][j-1]=edificio[i-1][j-1]+1;
        }
        System.out.println("--------------------------");
        while (i!=9){
            System.out.print("Ingrese el piso al que quiere ingresar: ");
            i=Lector.leerInt();
            System.out.println();
            if (i!=9) {
                System.out.print("Ingrese a la oficina que quiere ingresar: ");
                 j=Lector.leerInt();
                edificio[i-1][j-1]=edificio[i-1][j-1]+1;
            }
            System.out.println("--------------------------");
        }
        
        for (i=0; i<DF; i++)
            for (j=0; j<DC; j++)
                System.out.println("En la oficina "+ (j+1) +" del piso "+ (i+1) +" ingresaron un total de " + edificio[i][j] +" personas.");
    }//static void
}//public class
