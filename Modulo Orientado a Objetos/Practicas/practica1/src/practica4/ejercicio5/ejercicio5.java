package practica4.ejercicio5;

public class ejercicio5 {

    public static void main(String args[]) {
        VisorFiguras visor = new VisorFiguras();

        Cuadrado c1 = new Cuadrado(10,"Violeta","Rosa");
        Rectangulo r1= new Rectangulo(20,10,"Azul","Celeste");
        Cuadrado c2= new Cuadrado(30,"Rojo","Naranja");
        
        visor.guardar(c1);
        visor.guardar(c2);
        visor.guardar(r1);
        
        if (visor.getDL()>0)
            visor.mostrarTodas();
        
        System.out.println("Cantidad de figuras guardadas: "+visor.getDL()+".");
    }
}
