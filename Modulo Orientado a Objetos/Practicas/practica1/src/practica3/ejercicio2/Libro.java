package practica3.ejercicio2;


public class Libro {
    private String titulo;
    private String editorial;
    private int añoEdicion;
    private int ISBN;
    private double precio;
    private Autor autor=null;

    public Libro(){
        
    }
    
    public Libro(String titulo, String editorial, int añoEdicion, int ISBN, double precio, Autor autor) {
        this.titulo = titulo;
        this.editorial = editorial;
        this.añoEdicion = añoEdicion;
        this.ISBN = ISBN;
        this.precio = precio;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAñoEdicion() {
        return añoEdicion;
    }

    public void setAñoEdicion(int añoEdicion) {
        this.añoEdicion = añoEdicion;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    

}
