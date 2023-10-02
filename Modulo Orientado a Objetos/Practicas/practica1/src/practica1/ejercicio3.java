package practica1;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
public class ejercicio3 {
    public static void main(String[] args) {
        //Cuerpo
        int DFila=5;
        int DColumna=5;
        int [][] matriz = new int [DFila][DColumna];
        int i,j;
        GeneradorAleatorio.iniciar();
        //Cargar la matriz
        for (i=0 ; i<DFila ; i++){
            for (j=0 ;  j<DColumna ; j++){
                matriz[i][j]=GeneradorAleatorio.generarInt(31);
            }
        }
        //Imprimir matriz
        for ( i=0 ; i<DFila; i++){
            for ( j=0 ;  j<DColumna; j++){
                System.out.println(matriz[i][j]);
            }
        }
        //Imprimir solo los elementos de la fila 1 (indexada como 0)
        int sumaF1=0;
        for ( j=0; j<DColumna ; j++){
            sumaF1 = sumaF1 + matriz[0][j];
            System.out.println("La suma del elemento"+ j +" sus anteriores es igual a: "+sumaF1+".");
        }
        //Vector de 5 posiciones que tenga la suma de la columna j en posicion j.
        int DF=5;
        int [] vector = new int [DF];
        for ( j=0 ; j<DF ; j++){
            vector[j]=0;
        }
        for (i=0 ; i<DFila; i++){
            for ( j=0 ; j<DColumna ; j++){
                vector[j]=vector[j]+matriz[i][j];
            }
        }
        for ( i=0 ; i<DF; i++){
            System.out.println(vector[i]);
        }
        
        //Leer valor entero -> Determinar si está en matriz e informar posición.
        System.out.println("Ingrese un valor para buscar en la matriz:");
        int valor=Lector.leerInt();
        int posF=-1;
        int posC=-1;
        
        for (i=0; i<DFila; i++){
            for (j=0; j<DColumna; j++){
                if (valor==matriz[i][j]){
                    valor=matriz[i][j];
                    posF=i;
                    posC=j;
                }
            }
        }
        if (posF!=-1) System.out.println("El elemento se encuentra en la matriz en la fila "+posF+" y columna "+posC+".");
        else System.out.println("El valor no se encontró en la matriz.");
    }
}