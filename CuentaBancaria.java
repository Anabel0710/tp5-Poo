/**
 * Representa una cuenta bancaria perteneciente a una persona.
 * Reúne el estado y el comportamiento común de CajaDeAhorro y
 * CuentaCorriente para evitar la duplicación de código.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 2.0 - 28/09/2026
 */
public abstract class CuentaBancaria
{
    private int nroCuenta;
    private double saldo;
    private Persona titular;

    /** Construye una cuenta con saldo inicial igual a cero. */
    public CuentaBancaria(int p_nroCuenta, Persona p_titular)
    {
        this(p_nroCuenta, p_titular, 0.0);
    }

    /** Construye una cuenta con el saldo inicial indicado. */
    public CuentaBancaria(int p_nroCuenta, Persona p_titular,
                          double p_saldo)
    {
        this.setNroCuenta(p_nroCuenta);
        this.setTitular(p_titular);
        this.setSaldo(p_saldo);
    }

    private void setNroCuenta(int p_nroCuenta)
    {
        this.nroCuenta = p_nroCuenta;
    }

    private void setTitular(Persona p_titular)
    {
        this.titular = p_titular;
    }

    /** Es protegido porque las subclases deben actualizar el saldo. */
    protected void setSaldo(double p_saldo)
    {
        this.saldo = p_saldo;
    }

    public int getNroCuenta() { return this.nroCuenta; }
    public double getSaldo() { return this.saldo; }
    public Persona getTitular() { return this.titular; }

    /** Deposita un importe positivo y devuelve el saldo resultante. */
    public double depositar(double p_importe)
    {
        if (p_importe > 0)
        {
            this.setSaldo(this.getSaldo() + p_importe);
        }

        return this.getSaldo();
    }

    /**
     * Determina si una extracción es válida. Las subclases redefinen
     * este método para aplicar sus propias reglas.
     */
    protected boolean puedeExtraer(double p_importe)
    {
        return p_importe > 0 && p_importe <= this.getSaldo();
    }

    /** Devuelve el motivo por el cual no puede realizarse la extracción. */
    protected String xQNoPuedeExtraer(double p_importe)
    {
        return "No puede extraer más que el saldo disponible.";
    }

    /**
     * Punto de extensión ejecutado después de una extracción exitosa.
     * En una cuenta bancaria común no se requiere ninguna acción.
     */
    protected void despuesDeExtraer()
    {
        // La subclase CajaDeAhorro descontará una extracción disponible.
    }

    /** Extrae dinero aplicando la regla correspondiente al tipo de cuenta. */
    public double extraer(double p_importe)
    {
        if (this.puedeExtraer(p_importe))
        {
            this.setSaldo(this.getSaldo() - p_importe);
            this.despuesDeExtraer();
        }
        else
        {
            System.out.println(this.xQNoPuedeExtraer(p_importe));
        }

        return this.getSaldo();
    }

    /** Devuelve el nombre del tipo de cuenta. */
    protected String nombreCuenta()
    {
        return "Cuenta Bancaria";
    }

    /** Permite que cada subclase muestre su información particular. */
    protected void mostrarDatosEspecificos()
    {
        // Una cuenta bancaria común no posee datos adicionales.
    }

    /** Muestra los datos comunes y particulares de la cuenta. */
    public void mostrar()
    {
        System.out.println("- " + this.nombreCuenta() + " -");
        System.out.println("Nro. Cuenta: " + this.getNroCuenta()
            + " - Saldo: " + this.getSaldo());
        System.out.println("Titular: " + this.getTitular().nomYApe());
        this.mostrarDatosEspecificos();
    }

    @Override
    public String toString()
    {
        return this.getNroCuenta() + "\t"
            + this.getTitular().nomYApe() + "\t" + this.getSaldo();
    }
}