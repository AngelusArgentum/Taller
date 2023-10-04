package practica2;

import PaqueteLectura.Lector;
//EJERCICIO 1

public class Persona {
    private String nombre;
    private int DNI;
    private int edad; 
    
    public Persona(String unNombre, int unDNI, int unaEdad){
        nombre = unNombre;
        DNI = unDNI;
        edad = unaEdad; 
    }
    
    public Persona(){
     
    }

    public int getDNI() {
        return DNI;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDNI(int unDNI) {
        DNI = unDNI;
    }

    public void setEdad(int unaEdad) {
        edad = unaEdad;
    }

    public void setNombre(String unNombre) {
        nombre = unNombre;
    }
    
    public String toString(){
        String aux; 
        aux = "Mi nombre es " + nombre + ", mi DNI es " + DNI + " y tengo " + edad + " años.";
        return aux;
    }

    public static void main(String args[]) {
        int pDNI,pEdad;
        String pNombre;
        // Settear los datos de la persona.
        Persona p1= new Persona();
        System.out.print("Ingrese el nombre de la persona: ");
        p1.setNombre(pNombre=Lector.leerString());
        System.out.println("--------------------------------------");
        
        System.out.print("Ingrese el DNI de la persona: ");
        p1.setDNI(pDNI=Lector.leerInt());
        System.out.println("--------------------------------------");
        
        System.out.print("Ingrese la edad de la persona: ");
        p1.setEdad(pEdad=Lector.leerInt());
        System.out.println("--------------------------------------");
        
        //Usar el método "toString()".
        System.out.print(p1.toString());
    }