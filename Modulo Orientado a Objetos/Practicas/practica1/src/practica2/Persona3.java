//EJERCICIO 3
package practica2;

import PaqueteLectura.*;

public class Persona3 {
    private String nombre;
    private int DNI;
    private int edad;
    
    public Persona3(String unNombre, int unDNI, int unaEdad){
        nombre=unNombre;
        DNI=unDNI;
        edad=unaEdad;
    }
    public Persona3(){
        
    }
    //getters
    public int getDNI(){
        return DNI;
    }
    public int getEdad(){
        return edad;
    }
    public String getNombre(){
        return nombre;
    }
    
    //setters
    public void setDNI(int unDNI){
        DNI=unDNI;
    }
    public void setEdad(int unaEdad){
        edad=unaEdad;
    }
    public void setNombre(String unNombre){
        nombre=unNombre;
    }
    
    //toString
    public String toString(){
        String aux;
        aux="Mi nombre es "+nombre+", tengo "+edad+" años. Mi DNI es: "+DNI+".";
        return aux;
    }
    
    public static void main(String args[]) {
        // 8 turnos (columnas) 
        // 5 días (filas) personas entran dando 
        //edad, DNI y nombre + día al que quiere asistir. Hasta cubrir todo o nombre "ZZZ".
        int DF=5;
        int DC=8;
        Persona3 [][] matriz=new Persona3[DF][DC];
        int DNI,edad,dia;
        int [] vectorDL=new int [DF];
        int i,j;
        String nombre; nombre="O";
        int cant=0;
        int maximo=DF*DC;

        for (i=0; i<DF; i++) vectorDL[i]=0;
        
        while (!"ZZZ".equals(nombre) && cant<maximo){
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.print("-> Ingrese su nombre: ");
            nombre=Lector.leerString();
            System.out.println();
            if (!"ZZZ".equals(nombre)){
                System.out.print("-> Ingrese su DNI: ");
                DNI=Lector.leerInt();
                System.out.println();
                System.out.print("-> Ingrese su edad: ");
                edad=Lector.leerInt();
                System.out.println();
                System.out.print("-> Ingrese el día para el que desea un turno: ");
                dia=Lector.leerInt();
                
                
                if (vectorDL[dia-1]<DC && (matriz[dia-1][vectorDL[dia-1]]) == null){    
                        matriz[dia-1][vectorDL[dia-1]]=new Persona3(nombre,DNI,edad);
                        vectorDL[dia-1]=vectorDL[dia-1]+1;
                        cant=cant+1;
                }//if doble
                else
                    System.out.println("No hay turnos disponibles para el día "+dia+".");
            }//if
        }//while
        
        //Informar para cada día la cantidad de inscriptos y el nombre de cada persona en cada turno.
        
        for (i=0; i<DF; i++){
            j=0;
            while (j<vectorDL[i]){
                nombre=matriz[i][j].getNombre();
                System.out.println("En el turno "+(j + 1)+" del día " +(i+1)+ " se encuentra inscripto/a "+nombre+".");
                j++;
            }
        }
            
    }
}
