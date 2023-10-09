package repaso.ejercicio1;
public class Subsidio {
    private double monto;
    private String motivo;
    private boolean otorgado=false;

    public Subsidio(double monto, String motivo, boolean otorgado) {
        this.monto = monto;
        this.motivo = motivo;
        this.otorgado = otorgado;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    public void setOtorgado(){
        this.otorgado=true;
    }
    
    public boolean getOtorgado(){
        return this.otorgado;
    }
}
