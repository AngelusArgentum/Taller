package practica3.ejercicio2;

public class Autor extends Libro{
    private String nombre;
    private String bio;
    private String origen;

    
    public Autor(){
        
    }
    
    public Autor(String nombre, String bio, String origen){
        this.nombre=nombre;
        this.bio=bio;
        this.origen=origen;
    }

    public Autor(String nombre, String bio, String origen, String titulo, String editorial, int añoEdicion, int ISBN, double precio) {
        setTitulo(titulo);
        setEditorial(editorial);
        setAñoEdicion(añoEdicion);
        setISBN(ISBN);
        setPrecio(precio);
        this.nombre = nombre;
        this.bio = bio;
        this.origen = origen;
        
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    @Override
    public String toString() {
        String aux;
        aux= "Nombre: "+nombre+". Biografía: "+bio+". Origen: "+origen+".";
        return aux;
    }
    
    
}
