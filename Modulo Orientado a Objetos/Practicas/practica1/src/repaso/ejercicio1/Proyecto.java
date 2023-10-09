// Un proyecto sólo debería poder construirse con el nombre, código, nombre del director.
package repaso.ejercicio1;
public class Proyecto {
    private String director, nombre;
    private int code;
    private int dimF=50;
    private int dimL=0;
    private Investigador [] vectorP = new Investigador [dimF];

    public Proyecto(String director, String nombre, int code) {
        this.director = director;
        this.nombre = nombre;
        this.code = code;
    }
    
    public void addInvestigador(Investigador inv){
        if (this.dimL<this.dimF)
            vectorP[this.dimL]=inv;
    }
    
    public double dineroTotalOtorgado(){
        int i=0;
        double aux=0;
        while (i<dimL)
            aux=aux+vectorP[i].dineroTotalOtorgado();
        return aux;
    }
    
    public void otorgarTodos(String name){
        int i=0;
        while (i<dimL){
            if (name.equals(nombre))
                vectorP[i].otorgarTodos();
            else
                i++;
        }
    }
    
    @Override
    public String toString(){
        int i=0;
        String aux,auxTotal;
        auxTotal="Información del proyecto:"
                + "\nNombre: "+this.nombre+"."
                + "\nDirección por: "+this.director+"."
                + "\nCódigo: "+this.code+".";
        while (i<dimL){
            aux=vectorP[i].toString();
            auxTotal=auxTotal+""
                    + "\n================"
                    + "\n"+aux;
        }
        return auxTotal;
    }
}
