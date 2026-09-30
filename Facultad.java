import java.util.ArrayList;

/**
 * Representa una facultad con una colección de profesores.
 *
 * La facultad debe conservar al menos un profesor.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0 - 27/09/2026
 */
public class Facultad
{
    private String nombre;
    private ArrayList<Profesor> profesores;

    /**
     * Construye una facultad con un profesor inicial.
     */
    public Facultad(String p_nombre, Profesor p_profesor)
    {
        this.nombre = p_nombre;
        this.profesores = new ArrayList<Profesor>();
        this.profesores.add(p_profesor);
    }

    public String getNombre()
    {
        return this.nombre;
    }

    public ArrayList<Profesor> getProfesores()
    {
        return this.profesores;
    }

    /**
     * Agrega un profesor a la facultad.
     */
    public void agregarProfesor(Profesor p_profesor)
    {
        this.getProfesores().add(p_profesor);
    }

    /**
     * Quita un profesor siempre que la colección no quede vacía.
     *
     * @return true si el profesor pudo eliminarse
     */
    public boolean quitarProfesor(Profesor p_profesor)
    {
        if (this.getProfesores().size() > 1)
        {
            return this.getProfesores().remove(p_profesor);
        }

        return false;
    }

    /**
     * Calcula el importe total que debe pagar la facultad.
     */
    public double totalAPagar()
    {
        double total = 0;

        for (Profesor profesor : this.getProfesores())
        {
            total += profesor.sueldoTotal();
        }

        return total;
    }

    /**
     * Emite la nómina de profesores.
     */
    public void nominaProfesores()
    {
        System.out.println( "*************** Nomina Facultad: " + this.getNombre());

        System.out.println("------------------------------------------------------------------");

        for (Profesor profesor : this.getProfesores())
        {
            System.out.println(profesor.mostrarLinea());
        }

        System.out.println("------------------------------------------------------------------");

        System.out.printf("Total a pagar: $%.2f%n", this.totalAPagar());
    }

    /**
     * Muestra cada profesor junto con sus cargos.
     */
    public void listarProfesorCargos()
    {
        System.out.println("***** Detalle de Profesores y cargos de Facultad: " + this.getNombre() + " *****");

        for (Profesor profesor : this.getProfesores())
        {
            System.out.println( "------------------------------------------------------------------");

            profesor.mostrar();

            System.out.println("------------------ **** -------------------");
        }

        System.out.println( "Hay " + this.getProfesores().size() + " profesores");
    }
}