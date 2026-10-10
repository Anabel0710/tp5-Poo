/**
 * Representa de manera general una etiqueta para packaging.
 *
 * Define las operaciones comunes de las etiquetas comunes
 * y premium.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0
 */
public abstract class Etiqueta
{
    private double costo;

    /**
     * Construye una etiqueta con un costo unitario.
     *
     * @param p_costo costo unitario de la etiqueta
     */
    public Etiqueta(double p_costo)
    {
        this.setCosto(p_costo);
    }

    /** Devuelve el costo unitario. */
    public double getCosto()
    {
        return this.costo;
    }

    /** Asigna el costo unitario. */
    private void setCosto(double p_costo)
    {
        this.costo = p_costo;
    }

    /**
     * Calcula el precio correspondiente a una cantidad de etiquetas.
     *
     * @param p_cantidad cantidad solicitada
     * @return precio de venta
     */
    public abstract double precio(int p_cantidad);

    /**
     * Devuelve el tipo de etiqueta.
     *
     * @return Premium o Común
     */
    protected abstract String tipo();

    /**
     * Devuelve la descripción de la etiqueta.
     *
     * @return tipo y características particulares
     */
    @Override
    public abstract String toString();
}