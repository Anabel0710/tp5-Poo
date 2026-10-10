import java.util.ArrayList;

/**
 * Representa la gerencia regional de una cadena hotelera.
 *
 * Registra los alojamientos alquilados y permite emitir
 * sus correspondientes liquidaciones.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0 6/10/2026
 */
public class Gerencia
{
    private String nombre;
    private ArrayList<Alojamiento> alojamientosAlquilados;

    /**
     * Construye una gerencia sin alojamientos registrados.
     *
     * @param p_nombre nombre de la gerencia
     */
    public Gerencia(String p_nombre)
    {
        this.setNombre(p_nombre);

        this.setAlojamientosAlquilados( new ArrayList<Alojamiento>() );
    }

    /** Devuelve el nombre de la gerencia. */
    public String getNombre()
    {
        return this.nombre;
    }

    /** Devuelve los alojamientos alquilados. */
    public ArrayList<Alojamiento> getAlojamientosAlquilados()
    {
        return this.alojamientosAlquilados;
    }

    /** Asigna el nombre de la gerencia. */
    private void setNombre(String p_nombre)
    {
        this.nombre = p_nombre;
    }

    /** Asigna la colección de alojamientos. */
    private void setAlojamientosAlquilados(ArrayList<Alojamiento> p_alojamientos)
    {
        this.alojamientosAlquilados = p_alojamientos;
    }

    /**
     * Registra un alojamiento alquilado.
     *
     * @param p_alojamiento alojamiento que se agregará
     * @return true si se agregó correctamente
     */
    public boolean agregarAlojamiento( Alojamiento p_alojamiento)
    {
        return this.getAlojamientosAlquilados().add(p_alojamiento );
    }

    /**
     * Elimina un alojamiento registrado.
     *
     * @param p_alojamiento alojamiento que se eliminará
     * @return true si estaba registrado
     */
    public boolean quitarAlojamiento( Alojamiento p_alojamiento)
    {
        return this.getAlojamientosAlquilados().remove(p_alojamiento );
    }

    /**
     * Cuenta los alojamientos de un tipo determinado.
     *
     * Se utiliza polimorfismo porque contar() se ejecuta según
     * el tipo real de cada alojamiento.
     *
     * @param p_tipoAlojamiento Hotel o Cabaña
     * @return cantidad encontrada
     */
    public int contarAlojamiento(String p_tipoAlojamiento)
    {
        int cantidad = 0;

        for (Alojamiento alojamiento : this.getAlojamientosAlquilados())
        {
            cantidad += alojamiento.contar( p_tipoAlojamiento );
        }

        return cantidad;
    }

    /**
     * Ejecuta la liquidación de todos los alojamientos.
     */
    public void liquidar()
    {
        for (Alojamiento alojamiento : this.getAlojamientosAlquilados())
        {
            alojamiento.liquidar();
            System.out.println();
        }
    }

    /**
     * Muestra la liquidación general de la gerencia.
     */
    public void mostrarLiquidacion()
    {
        System.out.println( "\nGerencia " + this.getNombre() );

        System.out.println( "Liquidación--------------------" );

        this.liquidar();

        System.out.println( "Alojamiento tipo Cabaña ----> " + this.contarAlojamiento("Cabaña") );

        System.out.println( "Alojamiento tipo Hotel -----> " + this.contarAlojamiento("Hotel") );
    }
}