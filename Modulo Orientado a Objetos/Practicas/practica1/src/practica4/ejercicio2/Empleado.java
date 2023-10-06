/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4.ejercicio2;

public abstract class Empleado {
    private String nombre;
    private double sueldo;
    private int antiq;

    public Empleado(String nombre, double sueldo, int antiq) {
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.antiq = antiq;
    }
    
//Abstracts
    public abstract double calcularEfectividad();
    
    @Override
    public String toString(){
        String aux;
        aux="Nombre, sueldo base y antiguedad del empleado:"+getNombre()+", "+getSueldo()+", "+getAntiq()+". ";
        return aux;
    }
    
    public double calcularSueldoACobrar(){
        return sueldo+(sueldo/10)*antiq;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public int getAntiq() {
        return antiq;
    }

    public void setAntiq(int antiq) {
        this.antiq = antiq;
    }
    
}
