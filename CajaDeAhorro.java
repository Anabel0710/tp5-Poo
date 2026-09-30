
/**
 * Representa una caja de ahorro con una cantidad limitada de 
 * extraccion. Hereda los datos y operaciones comunes de CuentaBancaria
 * 
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 2.0 - 28/09/2026
 */
public class CajaDeAhorro extends CuentaBancaria
{
    private int extraccionesPosibles;
    
    /** Construye una caja de ahorro sin saldo inicial */
    
    public CajaDeAhorro(int p_nroCuenta, Persona p_titular){
        super (p_nroCuenta, p_titular);
        this.setExtraccionesPosibles(10);
    }
    
    /** Construye una caja de ahorro con saldo inicial */
    public CajaDeAhorro(int p_nroCuenta, Persona p_titular, double p_saldo){
        super (p_nroCuenta, p_titular, p_saldo);
        this.setExtraccionesPosibles(10);
    }
    
    private void setExtraccionesPosibles(int p_extracciones){ this.extraccionesPosibles = p_extracciones;} 
    public int getExtraccionesPosibles() { return this.extraccionesPosibles;}
    
    /**Exige el saldo suficiente y al menos una extraccion disponible*/
    @Override 
    protected boolean puedeExtraer(double p_importe){
        return p_importe > 0 && p_importe <= this.getSaldo() && this.getExtraccionesPosibles() > 0;
    }
    
    /**Descuenta una extraccion solamente cuando la operacion tuvo exito*/
    @Override 
    protected void despuesDeExtraer(){
        this.setExtraccionesPosibles(this.getExtraccionesPosibles() - 1);
    }
    
    /**Informa la causa particular del rechazo */
    @Override 
    protected String xQNoPuedeExtraer(double p_importe){
        if(this.getExtraccionesPosibles() == 0){
        return "No tene habilitadas mas extracciones";
    }
    return "No puede extraer mas que el saldo";
    }
    @Override
    protected String nombreCuenta(){
        return "Caja de ahorro";
    }
    
    @Override
    protected void mostrarDatosEspecificos(){
        System.out.println("Extracciones posibles: " + this.getExtraccionesPosibles());
    }
}