package practica3.ejercicio3;

public class Estante {
    private Libro [] E;
    private int DF=20;
    private int DL=0;
    private boolean lleno=false;
    
    public Estante() {  //Inicializar Estante sin Libros
        E = new Libro [DF];
    }

    public Libro[] getE() { //G Estante
        return E;
    }

    public void setE(Libro[] E) { //S Estante
        this.E = E;
    }    
    
    public void setLibro(int i, Libro L){
        this.E[i]=L;
        this.DL=DL+1;
    }
    
    public Libro getLibro(int i){
        return E[i];
    }
            
    public int getDF() {
        return DF;
    }

    public void setDF(int DF) {
        this.DF = DF;
    }

    public int getDL() {
        return DL;
    }

    public void setDL(int DL) {
        this.DL = DL;
    }

    public boolean isLleno() {
        return lleno;
    }

    public void setLleno(boolean lleno) {
        this.lleno = lleno;
    }
    
    
}
