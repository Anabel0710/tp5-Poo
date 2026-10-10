import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;

/**
 * Representa una delegación que visita el zoológico.
 *
 * Está formada por una colección de individuos y no permite
 * inscribir dos personas con el mismo DNI.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0
 */
public class Delegacion extends Visitante
{
    private ArrayList<Individuo> integrantes;

    /**
     * Construye una delegación sin integrantes.
     *
     * @param p_nombre nombre de la delegación
     * @param p_fecha fecha de la visita
     */
    public Delegacion(String p_nombre, Calendar p_fecha)
    {
        super(p_nombre, p_fecha);

        this.setIntegrantes(new ArrayList<Individuo>() );
    }

    /** Devuelve los integrantes de la delegación. */
    public ArrayList<Individuo> getIntegrantes()
    {
        return this.integrantes;
    }

    /** Asigna la colección de integrantes. */
    private void setIntegrantes( ArrayList<Individuo> p_integrantes)
    {
        this.integrantes = p_integrantes;
    }

    /**
     * Inscribe un individuo si su DNI todavía no está registrado.
     *
     * @param p_individuo individuo que se inscribirá
     * @return true si fue agregado; false si ya estaba registrado
     */
    public boolean inscribirIndividuo(Individuo p_individuo)
    {
        for (Individuo integrante : this.getIntegrantes())
        {
            if (integrante.getPersona().getDNI() == p_individuo.getPersona().getDNI())
            {
                return false;
            }
        }

        return this.getIntegrantes().add(p_individuo);
    }

    /**
     * Elimina un integrante de la delegación.
     *
     * @param p_individuo individuo que se eliminará
     * @return true si estaba registrado
     */
    public boolean quitarIntegrante(Individuo p_individuo)
    {
        return this.getIntegrantes().remove(p_individuo);
    }

    /**
     * Devuelve la cantidad de integrantes.
     *
     * @return cantidad de individuos
     */
    public int cantidadIntegrantes()
    {
        return this.getIntegrantes().size();
    }

    /**
     * Devuelve el tipo concreto.
     *
     * @return Delegación
     */
    @Override
    public String tipoVisitante()
    {
        return "Delegación";
    }

    /**
     * Calcula el costo de la delegación.
     *
     * Se suman las entradas individuales y se descuenta el 10%.
     *
     * @return precio de la entrada de la delegación
     */
    @Override
    public double entrada()
    {
        double total = 0;

        for (Individuo integrante : this.getIntegrantes())
        {
            total += integrante.entrada();
        }

        return total * 0.90;
    }

    /** Muestra la delegación y todos sus integrantes. */
    @Override
    public void mostrar()
    {
        System.out.println("------------------------------------------------" );

        System.out.println( "Delegación: " + this.getNombre() );

        System.out.println("Integrantes");

        for (Individuo integrante : this.getIntegrantes())
        {
            integrante.mostrar();
        }

        System.out.println( "Cantidad de integrantes: " + this.cantidadIntegrantes() );

        System.out.println( "------------------------------------------------" );
    }

    /**
     * Muestra la delegación cuando coinciden la fecha y el tipo.
     */
    @Override
    public void listarPorFecha( Calendar p_fecha, String p_visitante)
    {
        boolean fechaCorrecta = this.mismaFecha( this.getFechaVisita(), p_fecha );

        boolean tipoCorrecto = p_visitante.equalsIgnoreCase("Delegación") || p_visitante.equalsIgnoreCase("Delegacion") 
                     || p_visitante.equalsIgnoreCase("Todos");

        if (fechaCorrecta && tipoCorrecto)
        {
            this.mostrar();
        }
    }

    /**
     * Devuelve las personas integrantes sin repetir DNI.
     *
     * La comprobación se realiza manualmente porque no es
     * necesario modificar la clase Persona.
     */
    @Override
    public HashSet<Persona> listarPersonas()
    {
        HashSet<Persona> personas = new HashSet<Persona>();

        for (Individuo integrante : this.getIntegrantes())
        {
            Persona persona = integrante.getPersona();

            if (!contieneDNI(personas, persona.getDNI()))
            {
                personas.add(persona);
            }
        }

        return personas;
    }

    /**
     * Comprueba si un conjunto contiene una persona con un DNI.
     */
    private boolean contieneDNI( HashSet<Persona> p_personas, int p_dni)
    {
        for (Persona persona : p_personas)
        {
            if (persona.getDNI() == p_dni)
            {
                return true;
            }
        }

        return false;
    }
}