import java.util.ArrayList;

/**
 * Representa de manera general un alojamiento.
 *
 * Contiene la información y el comportamiento común de hoteles
 * y cabañas.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0 6/10/2026
 */
public abstract class Alojamiento
{
    private String nombre;
    private double precioBase;
    private int diasAlquiler;
    private ArrayList<Servicio> servicios;

    /**
     * Construye un alojamiento sin servicios contratados.
     *
     * @param p_nombre nombre del alojamiento
     * @param p_precioBase precio por día
     * @param p_diasAlquiler cantidad de días de la estadía
     */
    public Alojamiento( String p_nombre, double p_precioBase, int p_diasAlquiler)
    {
        this.setNombre(p_nombre);
        this.setPrecioBase(p_precioBase);
        this.setDiasAlquiler(p_diasAlquiler);
        this.setServicios(new ArrayList<Servicio>());
    }

    /** Devuelve el nombre del alojamiento. */
    public String getNombre()
    {
        return this.nombre;
    }

    /** Devuelve el precio base por día. */
    public double getPrecioBase()
    {
        return this.precioBase;
    }

    /** Devuelve la cantidad de días de alquiler. */
    public int getDiasAlquiler()
    {
        return this.diasAlquiler;
    }

    /** Devuelve la colección de servicios contratados. */
    public ArrayList<Servicio> getServicios()
    {
        return this.servicios;
    }

    /** Asigna el nombre. */
    private void setNombre(String p_nombre)
    {
        this.nombre = p_nombre;
    }

    /** Asigna el precio base. */
    private void setPrecioBase(double p_precioBase)
    {
        this.precioBase = p_precioBase;
    }

    /** Asigna la cantidad de días. */
    private void setDiasAlquiler(int p_diasAlquiler)
    {
        this.diasAlquiler = p_diasAlquiler;
    }

    /** Asigna la colección de servicios. */
    private void setServicios(ArrayList<Servicio> p_servicios)
    {
        this.servicios = p_servicios;
    }

    /**
     * Agrega un servicio al alojamiento.
     *
     * @param p_servicio servicio solicitado
     * @return true si se agregó correctamente
     */
    public boolean agregarServicio(Servicio p_servicio)
    {
        return this.getServicios().add(p_servicio);
    }

    /**
     * Elimina un servicio previamente contratado.
     *
     * @param p_servicio servicio que se desea eliminar
     * @return true si el servicio se encontraba registrado
     */
    public boolean quitarServicio(Servicio p_servicio)
    {
        return this.getServicios().remove(p_servicio);
    }

    /**
     * Permite contar alojamientos de un tipo determinado.
     *
     * Cada subclase implementa este método de acuerdo con su tipo.
     *
     * @param p_alojamiento tipo buscado
     * @return uno si coincide; cero si no coincide
     */
    public abstract int contar(String p_alojamiento);

    /**
     * Calcula el costo del alojamiento sin servicios.
     *
     * Las subclases agregan sus costos particulares.
     *
     * @return costo del alojamiento
     */
    public abstract double costo();

    /**
     * Muestra todos los servicios contratados.
     */
    public void listarServicios()
    {
        if (this.getServicios().isEmpty())
        {
            System.out.println("Sin servicios adicionales.");
        }
        else
        {
            for (Servicio servicio : this.getServicios())
            {
                System.out.println("   " + servicio);
            }
        }
    }

    /**
     * Calcula el costo total de los servicios.
     *
     * @return suma de los servicios contratados
     */
    public double costoServicios()
    {
        double total = 0;

        for (Servicio servicio : this.getServicios())
        {
            total += servicio.getPrecio();
        }

        return total;
    }

    /**
     * Muestra la parte común de la liquidación.
     */
    public void liquidar()
    {
        System.out.println( "Alojamiento: " + this.getNombre());

        System.out.printf( "Costo por %d días: $%.2f%n",  this.getDiasAlquiler(), this.costo() );

        this.listarServicios();
    }
}