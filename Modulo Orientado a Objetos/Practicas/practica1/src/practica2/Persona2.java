//EJERCICIO 2
package practica2;

import PaqueteLectura.*;

public class Persona2 {
    private String nombre;
    private int edad;
    private int DNI;
    
    public Persona2 (String unNombre, int unaEdad, int unDNI){
        nombre = unNombre;
        edad = unaEdad;
        DNI = unDNI;
    }
    
    public Persona2(){
        
    }
    
    public int getDNI(){
        return DNI;
    }
    
    public int getEdad(){
        return edad;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setDNI(int aDNI){
        DNI=aDNI;
    }
    
    public void setEdad (int aEdad){
        edad=aEdad;
    }
    
    public void setNombre (String aNombre){
        nombre=aNombre;
    }
    
    public String toString(){
        String aux;
        aux="Mi nombre es "+nombre+", mi DNI es "+DNI+", y tengo "+edad+" años.";
        return aux;
    }
    
    public static void main(String args[]) {
        int DF=3;
        int DL =0;
        Persona2 [] arrayPersonas = new Persona2 [DF];
        String nombre;
        int edad = 1;
        int DNI,i;
        int cont = 0;
        Persona2 pDNIMin=new Persona2();
        int DNIMin=99999999;
        
        
        while (edad > 0 && DL<DF){
            System.out.println("Ingrese una edad: "); edad=Lector.leerInt();
            if (edad > 0){
                System.out.println("Ingrese un DNI: "); DNI=Lector.leerInt();
                System.out.println("Ingrese un nombre: "); nombre=Lector.leerString();
                arrayPersonas[DL] = new Persona2(nombre, edad, DNI);
                DL=DL+1;
            } //if
        } //while
        
        for (i=0; i<DL; i++){
            if (arrayPersonas[i].edad > 65) cont=cont+1;
            if (arrayPersonas[i].DNI < DNIMin){
                pDNIMin=arrayPersonas[i];
                DNIMin=arrayPersonas[i].DNI;
            }
        }
        System.out.println("Se encontraron "+cont+" personas mayores de 65 años.");
        System.out.println(pDNIMin.toString());
    }
}
