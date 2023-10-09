// b. Un investigador sólo debería poder construirse con nombre, categoría y especialidad.
package repaso.ejercicio1;
public class Investigador extends Proyecto {
    private String nombre;
    private String especialidad;
    private int categoria;
    private final int dimF=5;
    private int dimL=0;
    private Subsidio [] vectorS=new Subsidio [dimF];

    public Investigador(String nombre, String especialidad, int categoria) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.categoria = categoria;
    }
    
    private boolean checkEspacio(){
        return this.dimL<this.dimF;
    }
    
    public void addSub(Subsidio s){
        if (checkEspacio())
            vectorS[dimL]=s;
    }
    
    
    public void giveSub(int i){
        vectorS[i].setOtorgado();
    }
    
    public void otorgarTodos(){
        int i=0;
        while (i<dimL)
            if (vectorS[i].getOtorgado()==false)
            vectorS[i].setOtorgado();
    }
    
    @Override
    public double dineroTotalOtorgado(){
        double aux=0;
        int i=0;
        while (i<dimL)
            if (vectorS[i].getOtorgado())
                aux=aux+vectorS[i].getMonto();
        return aux;
    }
    
    @Override
    public String toString(){
        String aux;
        aux="Investigador "+this.nombre+":"
                + "\nEspecialidad: "+this.especialidad+"."
                + "\nCategoría: "+this.categoria+"."
                + "\nDinero total otorgado por subsidios: "+dineroTotalOtorgado()+".";
        return aux;
    }
}

