import java.util.Calendar;
import java.util.HashSet;

/**
 * Representa a una persona que visita el zoológico
 * individualmente.
 *
 * La clase Persona actúa como colaboradora.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0
 */
public class Individuo extends Visitante
{
    private Persona persona;

    /**
     * Construye un visitante individual.
     *
     * @param p_persona persona que realiza la visita
     * @param p_fecha fecha de la visita
     */
    public Individuo(Persona p_persona, Calendar p_fecha)
    {
        super(p_persona.nomYApe(), p_fecha);
        this.setPersona(p_persona);
    }

    /** Devuelve la persona asociada. */
    public Persona getPersona()
    {
        return this.persona;
    }

    /** Asigna la persona asociada. */
    private void setPersona(Persona p_persona)
    {
        this.persona = p_persona;
    }

    /**
     * Devuelve el tipo concreto de visitante.
     *
     * @return Individuo
     */
    @Override
    public String tipoVisitante()
    {
        return "Individuo";
    }

    /**
     * Devuelve el precio de la entrada individual.
     *
     * @return precio de la entrada
     */
    @Override
    public double entrada()
    {
        return 10.0;
    }

    /** Muestra los datos de la persona. */
    @Override
    public void mostrar()
    {
        this.getPersona().mostrar();
    }

    /**
     * Muestra el individuo si la fecha y el tipo coinciden.
     *
     * El valor "Todos" permite listar sin discriminar por tipo.
     */
    @Override
    public void listarPorFecha( Calendar p_fecha, String p_visitante)
    {
        boolean fechaCorrecta = this.mismaFecha( this.getFechaVisita(), p_fecha );

        boolean tipoCorrecto = p_visitante.equalsIgnoreCase("Individuo") || p_visitante.equalsIgnoreCase("Todos");

        if (fechaCorrecta && tipoCorrecto)
        {
            this.mostrar();
            System.out.println();
        }
    }

    /**
     * Devuelve un conjunto que contiene a la persona.
     *
     * @return personas representadas por este visitante
     */
    @Override
    public HashSet<Persona> listarPersonas()
    {
        HashSet<Persona> personas = new HashSet<Persona>();
        personas.add(this.getPersona());

        return personas;
    }
}