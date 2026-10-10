/**
 * Representa un servicio adicional solicitado por un huésped.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0 6/10/2026
 */
public class Servicio
{
    private String descripcion;
    private double precio;

    /**
     * Construye un servicio.
     *
     * @param p_descripcion descripción del servicio
     * @param p_precio precio del servicio
     */
    public Servicio(String p_descripcion, double p_precio)
    {
        this.setDescripcion(p_descripcion);
        this.setPrecio(p_precio);
    }

    /** Devuelve la descripción del servicio. */
    public String getDescripcion()
    {
        return this.descripcion;
    }

    /** Devuelve el precio del servicio. */
    public double getPrecio()
    {
        return this.precio;
    }

    /** Asigna la descripción del servicio. */
    private void setDescripcion(String p_descripcion)
    {
        this.descripcion = p_descripcion;
    }

    /** Asigna el precio del servicio. */
    private void setPrecio(double p_precio)
    {
        this.precio = p_precio;
    }

    /**
     * Devuelve los datos del servicio.
     *
     * @return descripción y precio
     */
    @Override
    public String toString()
    {
        return this.getDescripcion() + ": $" + String.format("%.2f", this.getPrecio());
    }
}