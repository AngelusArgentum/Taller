
package practica4.ejercicio5;

public class VisorFiguras {
    private int DL=0;
    private int DF=5;
    private Figura [] vector=new Figura [DF];

    public void mostrarTodas(){
     int i=0;
     while (i<DL){
         mostrar(vector[i]);
         i++;
     }
    }

    public void guardar(Figura f){
        if (quedaEspacio()){
            vector[DL]=f;
            DL++;
        }
        else
            System.out.println("No queda espacio en la estructura.");
    }

    private boolean quedaEspacio(){
        return this.DL<this.DF;
    }

    public void mostrar(Figura f){
        System.out.println(f.toString());
    }
    
    public int getDL() {
        return DL;
    }

}
