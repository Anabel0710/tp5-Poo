import java.util.ArrayList;

/**
 * Representa un pedido formado por uno o más renglones.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0
 */
public class Pedido
{
    private ArrayList<Renglon> renglones;

    /**
     * Construye un pedido con su primer renglón.
     *
     * La cardinalidad 1..* establece que el pedido no puede
     * quedar vacío.
     *
     * @param p_renglon primer renglón del pedido
     */
    public Pedido(Renglon p_renglon)
    {
        this.setRenglones(new ArrayList<Renglon>());
        this.agregarRenglon(p_renglon);
    }

    /** Devuelve los renglones del pedido. */
    public ArrayList<Renglon> getRenglones()
    {
        return this.renglones;
    }

    /** Asigna la colección de renglones. */
    private void setRenglones(ArrayList<Renglon> p_renglones)
    {
        this.renglones = p_renglones;
    }

    /**
     * Agrega un renglón al pedido.
     *
     * @param p_renglon renglón que se agregará
     * @return true si se agregó correctamente
     */
    public boolean agregarRenglon(Renglon p_renglon)
    {
        return this.getRenglones().add(p_renglon);
    }

    /**
     * Elimina un renglón siempre que el pedido conserve al menos uno.
     *
     * @param p_renglon renglón que se eliminará
     * @return true si se eliminó; false si no puede eliminarse
     */
    public boolean quitarRenglon(Renglon p_renglon)
    {
        if (this.getRenglones().size() > 1)
        {
            return this.getRenglones().remove(p_renglon);
        }

        return false;
    }

    /**
     * Devuelve la cantidad de renglones.
     *
     * @return cantidad de ítems diferentes
     */
    public int cantidadItems()
    {
        return this.getRenglones().size();
    }

    /**
     * Calcula la cantidad total de etiquetas.
     *
     * @return suma de las cantidades
     */
    public int cantidadTotalEtiquetas()
    {
        int total = 0;

        for (Renglon renglon : this.getRenglones())
        {
            total += renglon.getCantidad();
        }

        return total;
    }

    /**
     * Calcula el importe total del pedido.
     *
     * @return suma de los precios de los renglones
     */
    public double importeTotal()
    {
        double total = 0;

        for (Renglon renglon : this.getRenglones())
        {
            total += renglon.getPrecio();
        }

        return total;
    }

    /** Muestra el pedido completo. */
    public void mostrar()
    {
        System.out.println("\nPedido:");

        System.out.println( "Cantidad de items: " + this.cantidadItems() );

        int numeroItem = 1;

        for (Renglon renglon : this.getRenglones())
        {
            System.out.print( "Item " + numeroItem + ": " );

            renglon.mostrar();

            System.out.printf( "Precio: $ %.2f%n", renglon.getPrecio() );

            numeroItem++;
        }

        System.out.printf( "--- Total pedido: %d Etiquetas por un importe total de: $ %.2f%n",
            this.cantidadTotalEtiquetas(),
            this.importeTotal() );
    }
}