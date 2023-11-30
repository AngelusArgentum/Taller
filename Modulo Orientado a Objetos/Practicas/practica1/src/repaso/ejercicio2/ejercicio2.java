package repaso.ejercicio2; //01:22 - 02:19
import PaqueteLectura.Lector;
public class ejercicio2 {
    public static void main(String args[]) {
        int cant,i;
        int plaza;
        int piso;
        int patente;
        String dueño;
        cant=2;
        Estacionamiento e=new Estacionamiento(3,3);
        Auto a;
        for (i=0; i<cant; i++){
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.print("Ingrese el nombre del dueño del auto: "); dueño=Lector.leerString();
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.print("Ingrese la patente del auto: "); patente=Lector.leerInt();
            a= new Auto(dueño, patente);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.print("Ingrese una plaza donde estacionar el auto: "); plaza=Lector.leerInt();
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.print("Ingrese un piso donde estacionar el auto: "); piso=Lector.leerInt();
            e.parkAuto(a, piso, plaza);
        }
        System.out.println(e.toString());
        System.out.println(e.countPlaza(1));
        System.out.print("Ingrese una patente para buscarla: ");
        patente=Lector.leerInt();
        System.out.println();
        System.out.println(e.searchAuto(patente));
            
    }
}
