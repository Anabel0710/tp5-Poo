/**
 * Representa una cuenta corriente que permite utilizar un límite
 * de descubierto. Hereda los datos y operaciones comunes de
 * CuentaBancaria.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 2.0 - 28/09/2026
 */
public class CuentaCorriente extends CuentaBancaria
{
    private double limiteDescubierto;

    /** Construye una cuenta corriente sin saldo inicial. */
    public CuentaCorriente(int p_nroCuenta, Persona p_titular)
    {
        super(p_nroCuenta, p_titular);
        this.setLimiteDescubierto(500.0);
    }

    /** Construye una cuenta corriente con saldo inicial. */
    public CuentaCorriente(int p_nroCuenta, Persona p_titular, double p_saldo)
    {
        super(p_nroCuenta, p_titular, p_saldo);
        this.setLimiteDescubierto(500.0);
    }

    private void setLimiteDescubierto(double p_limite)
    {
        this.limiteDescubierto = p_limite;
    }

    public double getLimiteDescubierto()
    {
        return this.limiteDescubierto;
    }

    /** Permite extraer hasta la suma del saldo y el descubierto. */
    @Override
    protected boolean puedeExtraer(double p_importe)
    {
        return p_importe > 0 && p_importe <= this.getSaldo() + this.getLimiteDescubierto();
    }

    @Override
    protected String xQNoPuedeExtraer(double p_importe)
    {
        return "El importe de extracción sobrepasa " + "el límite de descubierto!";
    }

    @Override
    protected String nombreCuenta()
    {
        return "Cuenta Corriente";
    }

    @Override
    protected void mostrarDatosEspecificos()
    {
        System.out.println("Descubierto: " + this.getLimiteDescubierto());
    }
}