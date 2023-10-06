package practica3.ejercicio3;

import PaqueteLectura.Lector;

public class ejercicio3 {

    public static void main(String args[]) {
        Estante E=new Estante();
        String texto="R";
        String texto2;
        int i;
        Libro libroBuscado=null; //Este new es necesario?? PREGUNTAR
        
        while (!"ZZZ".equals(texto) && E.getDL()<E.getDF()){        //Cargar Estante con Libros con Autor.
            System.out.print("Ingrese el nombre del autor: ");
            texto=Lector.leerString();
            System.out.println("--------------------");
            if (!"ZZZ".equals(texto)){
                System.out.print("Ingrese biografía del autor: ");
                texto2=Lector.leerString();
                Autor A=new Autor(texto, texto2);
                System.out.println("--------------------");
                System.out.print("Ingrese el título del libro: ");
                System.out.println("--------------------");
                Libro L=new Libro(texto=Lector.leerString(), A);
                E.setLibro(E.getDL(), L);
            }//if
        }//while
        if (E.getDL()==E.getDF()) E.setLleno(true);     //Si el estante se llenó, entonces cambio estado a true.
        
        System.out.println("--------------------");
        System.out.print("Ingrese un título de libro para buscarlo: ");
        System.out.println("--------------------");
        for (i=0; i<E.getDL(); i++){
            
            if (E.getLibro(i).getTitulo().equals(texto))
                libroBuscado=E.getLibro(i); //Si el titulo del libro es igual me lo devuelve al prog principal.
        }
        if (libroBuscado==null){
            System.out.println("El libro buscado no se encontró en el estante.");
        }
        
        
        texto="Mujercitas";         //Busca el libro titulado "Mujercitas" y devuelve un string informando sobre el autor.
        for (i=0; i<E.getDL(); i++)
            if (E.getLibro(i).getTitulo().equals(texto))
                System.out.println(E.getLibro(i).getAutor().toString());
    }
}
