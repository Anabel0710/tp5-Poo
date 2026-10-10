/**
 * Representa una etiqueta premium.
 *
 * El precio depende del costo acordado, la cantidad solicitada
 * y la cantidad de colores utilizados.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0
 */
public class Premium extends Etiqueta
{
    private int colores;

    /**
     * Construye una etiqueta premium.
     *
     * @param p_costo costo unitario acordado
     * @param p_colores cantidad de colores
     */
    public Premium(double p_costo, int p_colores)
    {
        super(p_costo);
        this.setColores(p_colores);
    }

    /** Devuelve la cantidad de colores. */
    public int getColores()
    {
        return this.colores;
    }

    /** Asigna la cantidad de colores. */
    private void setColores(int p_colores)
    {
        this.colores = p_colores;
    }

    /**
     * Calcula el porcentaje adicional según los colores.
     *
     * @return porcentaje adicional expresado como decimal
     */
    protected double plus()
    {
        if (this.getColores() == 1)
        {
            return 0;
        }
        else if (this.getColores() == 2)
        {
            return 0.05;
        }
        else if (this.getColores() == 3)
        {
            return 0.07;
        }
        else
        {
            return this.getColores() * 0.03;
        }
    }

    /**
     * Calcula el precio de las etiquetas premium.
     *
     * @param p_cantidad cantidad solicitada
     * @return precio total
     */
    @Override
    public double precio(int p_cantidad)
    {
        double subtotal = this.getCosto() * p_cantidad;
        double adicional = subtotal * this.plus();

        return subtotal + adicional;
    }

    /**
     * Devuelve el tipo de etiqueta.
     *
     * @return Premium
     */
    @Override
    protected String tipo()
    {
        return "Premium";
    }

    /**
     * Devuelve la descripción de la etiqueta premium.
     */
    @Override
    public String toString()
    {
        return "tipo " + this.tipo()  + " - Costo: $" + this.getCosto()  + " - Colores: " + this.getColores();
    }
}