import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;

/**
 * Representa un zoológico y lleva el registro de los visitantes.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0
 */
public class Zoologico
{
    private String nombre;
    private ArrayList<Visitante> visitantes;

    /**
     * Construye un zoológico sin visitantes.
     *
     * @param p_nombre nombre del zoológico
     */
    public Zoologico(String p_nombre)
    {
        this.setNombre(p_nombre);
        this.setVisitantes(new ArrayList<Visitante>());
    }

    /** Devuelve el nombre del zoológico. */
    public String getNombre()
    {
        return this.nombre;
    }

    /** Devuelve los visitantes registrados. */
    public ArrayList<Visitante> getVisitantes()
    {
        return this.visitantes;
    }

    /** Asigna el nombre del zoológico. */
    private void setNombre(String p_nombre)
    {
        this.nombre = p_nombre;
    }

    /** Asigna la colección de visitantes. */
    private void setVisitantes( ArrayList<Visitante> p_visitantes)
    {
        this.visitantes = p_visitantes;
    }

    /**
     * Registra un visitante.
     *
     * @param p_visitante visitante que se agregará
     */
    public void nuevoVisitante(Visitante p_visitante)
    {
        this.getVisitantes().add(p_visitante);
    }

    /**
     * Elimina un visitante.
     *
     * @param p_visitante visitante que se eliminará
     * @return true si estaba registrado
     */
    public boolean quitarVisitante(Visitante p_visitante)
    {
        return this.getVisitantes().remove(p_visitante);
    }

    /**
     * Lista todos los visitantes de una fecha y un tipo.
     *
     * @param p_fecha fecha buscada
     * @param p_tipoVisitante Individuo, Delegación o Todos
     */
    public void listarTipoVisitantePorFecha( Calendar p_fecha, String p_tipoVisitante)
    {
        System.out.println( "\nVisitantes de tipo " + p_tipoVisitante );

        for (Visitante visitante : this.getVisitantes())
        {
            visitante.listarPorFecha( p_fecha, p_tipoVisitante );
        }
    }

    /**
     * Lista todos los visitantes que asistieron en una fecha.
     *
     * @param p_fecha fecha buscada
     */
    public void listarVisitantePorFecha(Calendar p_fecha)
    {
        this.listarTipoVisitantePorFecha( p_fecha, "Todos" );
    }

    /**
     * Calcula la recaudación en un rango inclusive de fechas.
     *
     * @param p_fechaDesde fecha inicial
     * @param p_fechaHasta fecha final
     * @return recaudación total
     */
    public double recaudacion( Calendar p_fechaDesde, Calendar p_fechaHasta)
    {
        double total = 0;

        int desde = claveFecha(p_fechaDesde);
        int hasta = claveFecha(p_fechaHasta);

        for (Visitante visitante : this.getVisitantes())
        {
            int fecha = claveFecha( visitante.getFechaVisita() );

            if (fecha >= desde && fecha <= hasta)
            {
                total += visitante.entrada();
            }
        }

        return total;
    }

    /**
     * Devuelve todas las personas que visitaron el zoológico
     * sin repetir el DNI.
     *
     * @return conjunto de personas
     */
    public HashSet<Persona> listarPersonasQueVisitaronElZoo()
    {
        HashSet<Persona> personas = new HashSet<Persona>();

        for (Visitante visitante : this.getVisitantes())
        {
            HashSet<Persona> personasVisitante = visitante.listarPersonas();

            for (Persona persona : personasVisitante)
            {
                if (!contieneDNI( personas, persona.getDNI()))
                {
                    personas.add(persona);
                }
            }
        }

        return personas;
    }

    /**
     * Muestra todas las personas que visitaron el zoológico.
     */
    public void mostrarPersonasQueVisitaronElZoo()
    {
        System.out.println( "\n===== PERSONAS QUE VISITARON EL ZOOLÓGICO =====" );

        for (Persona persona : this.listarPersonasQueVisitaronElZoo())
        {
            persona.mostrar();
            System.out.println();
        }
    }

    /** Convierte una fecha a un número AAAAMMDD. */
    private int claveFecha(Calendar p_fecha)
    {
        int anio = p_fecha.get(Calendar.YEAR);
        int mes = p_fecha.get(Calendar.MONTH) + 1;
        int dia = p_fecha.get(Calendar.DAY_OF_MONTH);

        return anio * 10000 + mes * 100 + dia;
    }

    /** Comprueba si ya existe una persona con determinado DNI. */
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