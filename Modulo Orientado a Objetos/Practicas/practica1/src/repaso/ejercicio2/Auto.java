package repaso.ejercicio2;
public class Auto {
    private String dueño;
    private int patente;

    public String getDueño() {
        return dueño;
    }

    public void setDueño(String dueño) {
        this.dueño = dueño;
    }

    public int getPatente() {
        return patente;
    }

    public void setPatente(int patente) {
        this.patente = patente;
    }

    public Auto(String dueño, int patente) {
        this.dueño = dueño;
        this.patente = patente;
    }

    @Override
    public String toString() {
        String aux;
        aux="Dueño: "+this.dueño+"."
                + "\nPatente"+this.patente+"."
                + "\n";
        return aux;
    }
    
    
}
