/**
 * Representa una cabaña de la cadena hotelera.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0 6/10/2026
 */
public class Cabaña extends Alojamiento
{
    private int nroHabitaciones;

    /**
     * Construye una cabaña.
     *
     * @param p_nombre nombre de la cabaña
     * @param p_precioBase precio base por día
     * @param p_diasAlquiler cantidad de días
     * @param p_nroHabitaciones cantidad de habitaciones
     */
    public Cabaña( String p_nombre, double p_precioBase, int p_diasAlquiler, int p_nroHabitaciones)
    {
        super(p_nombre, p_precioBase, p_diasAlquiler);
        this.setNroHabitaciones(p_nroHabitaciones);
    }

    /** Devuelve la cantidad de habitaciones. */
    public int getNroHabitaciones()
    {
        return this.nroHabitaciones;
    }

    /** Asigna la cantidad de habitaciones. */
    private void setNroHabitaciones(int p_nroHabitaciones)
    {
        this.nroHabitaciones = p_nroHabitaciones;
    }

    /**
     * Calcula el costo de la cabaña.
     *
     * Al precio base se agregan $30 diarios por cada habitación.
     *
     * @return costo de la cabaña sin servicios
     */
    @Override
    public double costo()
    {
        double costoBase = this.getPrecioBase() * this.getDiasAlquiler();

        double adicional = 30 * this.getDiasAlquiler() * this.getNroHabitaciones();

        return costoBase + adicional;
    }

    /**
     * Indica si este alojamiento coincide con el tipo buscado.
     *
     * @param p_alojamiento tipo de alojamiento buscado
     * @return uno si se busca Cabaña; cero en caso contrario
     */
    @Override
    public int contar(String p_alojamiento)
    {
        if (p_alojamiento.equalsIgnoreCase("Cabaña") || p_alojamiento.equalsIgnoreCase("Cabana"))
        {
            return 1;
        }

        return 0;
    }

    /**
     * Muestra la liquidación completa de la cabaña.
     */
    @Override
    public void liquidar()
    {
        super.liquidar();

        System.out.println( "Cabaña con " + this.getNroHabitaciones() + " habitaciones" );

        System.out.printf( "Total: ------> $%.2f%n", this.costo() + this.costoServicios() );
    }
}