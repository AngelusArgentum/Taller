package repaso.ejercicio2;
public class Estacionamiento {
    private String nombre;
    private String dir;
    private int horaApertura;
    private int horaCierre;
    private int DPlazas;
    private int DPisos;
    private Auto [][] matriz;
  
  public Estacionamiento (String nombre, String dir) {
        this.nombre = nombre;
        this.dir = dir;
        this.horaApertura = 8;
        this.horaCierre = 21;
        this.DPlazas = 10;
        this.DPisos = 5;
    } //Constructor 1
    
    public Estacionamiento (String nombre, String dir, int horaApertura, int horaCierre, int DPlazas, int DPisos) {
        this.nombre = nombre;
        this.dir = dir;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.DPlazas = DPlazas;
        this.DPisos = DPisos;
    } //Constructor 2

    Estacionamiento(int DPlazas, int DPisos) {
        this.DPlazas = DPlazas;
        this.DPisos = DPisos;
        this.matriz=new Auto [DPlazas][DPisos];
    }

    public void parkAuto (Auto a, int X, int Y){ //X= piso, Y=plaza (c1)
        matriz[Y-1][X-1]=a;
    }
    
    public String searchAuto (int patente){
        String aux="Auto inexistente";
        int i,p;
        for (i=0; i<this.DPlazas; i++)
            for (p=0; p<this.DPisos; p++)
                if (this.matriz[i][p]!=null && this.matriz[i][p].getPatente()==patente){
                    aux="El auto con la patente "+patente+" se encuentra en el piso "+(p+1)+", plaza "+(i+1)+".";
                    i=this.DPlazas;
                    p=this.DPisos;
                }
        return aux;
    }
    
    public int countPlaza(int Y){ //Y=plaza.
        int i,aux;
        aux=0;
        if (this.DPlazas>=Y) //No se avisa que el valor sea válido, debo comprobar.
            for (i=0; i<DPisos; i++)
                if (matriz[Y-1][i]!=null) 
                    aux=aux+1;
        else
                    System.out.println("El valor ingresado no se encuentra dentro del rango del estacionamiento.");
        return aux;
    }
    
    @Override
    public String toString(){
        String aux="";
        int i,p;
        for (i=0; i<this.DPlazas; i++)
            for (p=0; p<this.DPisos; p++)
                if (this.matriz[i][p] != null)
                    aux=aux+"========================\n"
                            + "Piso "+(p+1)+" Plaza"+ (i+1)+":\n"+this.matriz[i][p].toString();
                else 
                    aux=aux+"========================\n"
                            + "Piso "+(p+1)+" Plaza"+ (i+1)+":\nVacío\n";
        return aux;
    }
}
