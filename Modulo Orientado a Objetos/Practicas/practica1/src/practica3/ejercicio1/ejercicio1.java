/*
B- Realizar un programa que instancie un triángulo, le cargue información leída desde
teclado e informe en consola el perímetro y el área.*/
package practica3.ejercicio1;

import PaqueteLectura.Lector;

public class ejercicio1 {
    //lado 1 2 3 relleno linea
    public static void main(String args[]) {
        String x;
        double valor;
        Triangulo t = new Triangulo();
        System.out.println("---------------------------------------");
        System.out.print("Ingrese el valor del primer lado: ");
        t.setLado1(valor=Lector.leerDouble());
        System.out.println("---------------------------------------");
        System.out.print("Ingrese el valor del segundo lado: ");
        t.setLado2(valor=Lector.leerDouble());
        System.out.println("---------------------------------------");
        System.out.print("Ingrese el valor del tercer lado: ");
        t.setLado3(valor=Lector.leerDouble());
        System.out.println("---------------------------------------");
        System.out.print("Ingrese el color de relleno: ");
        t.setColorRelleno(x=Lector.leerString());
        System.out.println("---------------------------------------");
        System.out.print("Ingrese el color de línea: ");
        t.setColorLinea(x=Lector.leerString());
        System.out.println("---------------------------------------");
        System.out.println(t.toString());
    }
}
