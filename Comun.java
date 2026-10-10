/**
 * Representa una etiqueta común.
 *
 * Al costo de las unidades se agrega el costo del diseño y
 * posteriormente se aplica el descuento por cantidad.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0
 */
public class Comun extends Etiqueta
{
    private double plus;

    /**
     * Construye una etiqueta común.
     *
     * @param p_costo costo unitario
     * @param p_plus costo adicional del diseño
     */
    public Comun(double p_costo, double p_plus)
    {
        super(p_costo);
        this.setPlus(p_plus);
    }

    /** Devuelve el costo del diseño. */
    public double getPlus()
    {
        return this.plus;
    }

    /** Asigna el costo del diseño. */
    private void setPlus(double p_plus)
    {
        this.plus = p_plus;
    }

    /**
     * Determina el descuento correspondiente a la cantidad.
     *
     * @param p_cantidad cantidad solicitada
     * @return descuento expresado como decimal
     */
    protected double descuento(int p_cantidad)
    {
        if (p_cantidad <= 10)
        {
            return 0;
        }
        else if (p_cantidad <= 50)
        {
            return 0.02;
        }
        else if (p_cantidad <= 100)
        {
            return 0.05;
        }
        else
        {
            /** 
             * Para más de 100 unidades se aplica un 1%
             * por cada grupo completo de 10 unidades.
             */
            return (p_cantidad / 10) * 0.01;
        }
    }

    /**
     * Calcula el precio de las etiquetas comunes.
     *
     * Primero suma el costo de las unidades y el diseño.
     * Luego aplica el descuento por cantidad.
     *
     * @param p_cantidad cantidad solicitada
     * @return precio total
     */
    @Override
    public double precio(int p_cantidad)
    {
        double subtotal = this.getCosto() * p_cantidad + this.getPlus();

        double importeDescuento = subtotal * this.descuento(p_cantidad);

        return subtotal - importeDescuento;
    }

    /**
     * Devuelve el tipo de etiqueta.
     *
     * @return Común
     */
    @Override
    protected String tipo()
    {
        return "Común";
    }

    /**
     * Devuelve la descripción de la etiqueta común.
     */
    @Override
    public String toString()
    {
        return "tipo " + this.tipo() + " - Costo: $" + this.getCosto() + " - Diseño: $" + this.getPlus();
    }
}