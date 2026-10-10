import java.util.Calendar;
import java.util.HashSet;

/**
 * Representa de manera general a un visitante del zoológico.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0
 */
public abstract class Visitante
{
    private String nombre;
    private Calendar fechaVisita;

    /**
     * Construye un visitante.
     *
     * @param p_nombre nombre identificador del visitante
     * @param p_fechaVisita fecha en la que realizó la visita
     */
    public Visitante(String p_nombre, Calendar p_fechaVisita)
    {
        this.setNombre(p_nombre);
        this.setFechaVisita(p_fechaVisita);
    }

    /** Devuelve el nombre del visitante. */
    public String getNombre()
    {
        return this.nombre;
    }

    /** Devuelve la fecha de la visita. */
    public Calendar getFechaVisita()
    {
        return this.fechaVisita;
    }

    /** Asigna el nombre del visitante. */
    private void setNombre(String p_nombre)
    {
        this.nombre = p_nombre;
    }

    /**
     * Asigna una copia de la fecha para evitar que sea modificada
     * desde el exterior.
     */
    private void setFechaVisita(Calendar p_fechaVisita)
    {
        this.fechaVisita = (Calendar) p_fechaVisita.clone();
    }

    /** Muestra los datos particulares del visitante. */
    public abstract void mostrar();

    /**
     * Calcula el valor de la entrada.
     *
     * @return precio de la entrada
     */
    public abstract double entrada();

    /**
     * Lista el visitante cuando coinciden la fecha y el tipo.
     *
     * @param p_fecha fecha buscada
     * @param p_visitante tipo buscado
     */
    public abstract void listarPorFecha( Calendar p_fecha, String p_visitante );

    /**
     * Devuelve el tipo concreto de visitante.
     *
     * @return Individuo o Delegación
     */
    public abstract String tipoVisitante();

    /**
     * Devuelve las personas que integran al visitante.
     *
     * @return conjunto de personas
     */
    public abstract HashSet<Persona> listarPersonas();

    /**
     * Compara solamente día, mes y año de dos fechas.
     *
     * @param p_fecha1 primera fecha
     * @param p_fecha2 segunda fecha
     * @return true si representan el mismo día
     */
    protected boolean mismaFecha( Calendar p_fecha1, Calendar p_fecha2)
    {
        return p_fecha1.get(Calendar.YEAR)  == p_fecha2.get(Calendar.YEAR)  && p_fecha1.get(Calendar.MONTH) == p_fecha2.get(Calendar.MONTH)
            && p_fecha1.get(Calendar.DAY_OF_MONTH) == p_fecha2.get(Calendar.DAY_OF_MONTH);
    }
}