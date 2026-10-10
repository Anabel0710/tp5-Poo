/**
 * Representa un hotel perteneciente a la cadena hotelera.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0 6/10/2026
 */
public class Hotel extends Alojamiento
{
    private String tipoHabitacion;

    /**
     * Construye un hotel.
     *
     * @param p_nombre nombre del hotel
     * @param p_precioBase precio base por día
     * @param p_diasAlquiler cantidad de días
     * @param p_tipoHabitacion tipo de habitación
     */
    public Hotel( String p_nombre, double p_precioBase, int p_diasAlquiler, String p_tipoHabitacion)
    {
        super(p_nombre, p_precioBase, p_diasAlquiler);
        this.setTipoHabitacion(p_tipoHabitacion);
    }

    /** Devuelve el tipo de habitación. */
    public String getTipoHabitacion()
    {
        return this.tipoHabitacion;
    }

    /** Asigna el tipo de habitación. */
    private void setTipoHabitacion(String p_tipoHabitacion)
    {
        this.tipoHabitacion = p_tipoHabitacion;
    }

    /**
     * Calcula el costo del hotel según el tipo de habitación.
     *
     * @return costo del hotel sin servicios
     */
    @Override
    public double costo()
    {
        double costoBase = this.getPrecioBase() * this.getDiasAlquiler();

        double adicionalPorDia;

        if (this.getTipoHabitacion().equalsIgnoreCase("Single"))
        {
            adicionalPorDia = 20;
        }
        else
        {
            adicionalPorDia = 35;
        }

        return costoBase + adicionalPorDia * this.getDiasAlquiler();
    }

    /**
     * Indica si este alojamiento coincide con el tipo Hotel.
     *
     * @param p_alojamiento tipo buscado
     * @return uno si se busca Hotel; cero en caso contrario
     */
    @Override
    public int contar(String p_alojamiento)
    {
        if (p_alojamiento.equalsIgnoreCase("Hotel"))
        {
            return 1;
        }

        return 0;
    }

    /**
     * Muestra la liquidación completa del hotel.
     */
    @Override
    public void liquidar()
    {
        super.liquidar();

        System.out.println("Habitación " + this.getTipoHabitacion());

        System.out.printf("Total: ------> $%.2f%n", this.costo() + this.costoServicios() );
    }
}