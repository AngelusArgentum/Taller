/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3.ejercicio3;

/**
 *
 * @author Mateo Matus
 */
public class Autor extends Libro{
    private String nombre;
    private String bio;

    public Autor() {
    }
    
    public Autor (String nombre, String bio){
        this.nombre=nombre;
        this.bio=bio;
    }
    
    public Autor(String nombre, String bio, String titulo, Autor autor) {
        super(titulo, autor);
        this.nombre = nombre;
        this.bio = bio;
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
    
    public String toString(){
        String aux;
        aux=" El autor del libro "+getTitulo()+" es "+getNombre()+".";
        return aux;
    }

}
