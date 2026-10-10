/**
 * Representa un renglón de un pedido.
 *
 * Contiene una etiqueta, la cantidad solicitada y el precio
 * calculado polimórficamente.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0
 */
public class Renglon
{
    private int cantidad;
    private double precio;
    private Etiqueta item;

    /**
     * Construye un renglón y calcula su precio.
     *
     * @param p_cantidad cantidad de etiquetas
     * @param p_item etiqueta solicitada
     */
    public Renglon(int p_cantidad, Etiqueta p_item)
    {
        this.setCantidad(p_cantidad);
        this.setItem(p_item);

        this.setPrecio( p_item.precio(p_cantidad));
    }

    /** Devuelve la cantidad solicitada. */
    public int getCantidad()
    {
        return this.cantidad;
    }

    /** Devuelve el precio total del renglón. */
    public double getPrecio()
    {
        return this.precio;
    }

    /** Devuelve la etiqueta solicitada. */
    public Etiqueta getItem()
    {
        return this.item;
    }

    /** Asigna la cantidad. */
    private void setCantidad(int p_cantidad)
    {
        this.cantidad = p_cantidad;
    }

    /** Asigna el precio. */
    private void setPrecio(double p_precio)
    {
        this.precio = p_precio;
    }

    /** Asigna la etiqueta. */
    private void setItem(Etiqueta p_item)
    {
        this.item = p_item;
    }

    /** Muestra los datos del renglón. */
    public void mostrar()
    {
        System.out.println( this.getCantidad() + " Etiquetas de " + this.getItem().toString() );
    }
}