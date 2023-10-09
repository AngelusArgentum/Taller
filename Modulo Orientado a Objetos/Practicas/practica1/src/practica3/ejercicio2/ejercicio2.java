package practica3.ejercicio2;

public class ejercicio2 {
    public static void main(String args[]) {
        Autor A = new Autor("Yoko Taro" , "Creador de DrakeNieR" , "Japonés"); 
        Libro L = new Libro("NieR: Automata World Guide 1", "Dark Horse", 2017, 12938712, 49.99, A);
        
        System.out.println(L.getAutor().toString());
    }
}
